package com.ss.ttvideoengine.fetcher;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import com.ss.ttvideoengine.database.VideoModelDBManager;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.net.ChannelSelect;
import com.ss.ttvideoengine.net.NetUtils;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoInfoFetcher {
    private static final HandlerThread OWN_HANDLER_THREAD;
    private static HashMap<String, Integer> errorMapping;
    private static volatile boolean handlerThreadisStarted;
    private String[] EnvParamsStrs;
    private String[] ParamsStrs;
    private boolean isExternNetClient;
    private String mApiString;
    private String mAuth;
    private boolean mCancelled;
    private Context mContext;
    private JSONObject mEnvParams;
    private int mErrorCode;
    private Future mFuture;
    private boolean mGetMethodEnable;
    private Handler mHandler;
    private String mHost;
    private String mKeyseed;
    private FetcherListener mListener;
    private int mMaxRetryCount;
    private TTVNetClient mNetworkSession;
    private JSONObject mParams;
    private int mPlayVersion;
    private String mProjectTag;
    private HashMap<String, Resolution> mResolutionMap;
    private int mRetryIndex;
    private long mStartFetchT;
    private ArrayList<String> mTriedHost;
    private int mType;
    private String mURLWithoutParams;
    private boolean mUseFallbakApi;
    private boolean mUseVideoModelCache;
    private boolean mUseVideoModelCacheForce;
    private String mVID;
    public VideoModel mVideoModel;
    private TreeMap<String, String> queryMap;

    public interface FetcherListener {
        void onCompletion(VideoModel videoModel, Error error);

        void onLog(String str);

        void onRetry(Error error);

        void onStatusException(int i, String str);
    }

    static {
        Covode.recordClassIndex(652444);
        OWN_HANDLER_THREAD = new HandlerThread("VideoInforFetcher HandlerThread");
        handlerThreadisStarted = false;
    }

    private boolean _isTriedAllHost() {
        List groupByApiVersionLocked;
        if (this.mTriedHost == null || (groupByApiVersionLocked = ChannelSelect.getInstance().groupByApiVersionLocked(this.mPlayVersion)) == null || groupByApiVersionLocked.size() != this.mTriedHost.size()) {
            return false;
        }
        return true;
    }

    public void cancel() {
        synchronized (this) {
            this.mHandler.removeCallbacksAndMessages(null);
            FetcherListener fetcherListener = this.mListener;
            if (fetcherListener == null) {
                return;
            }
            fetcherListener.onLog("fetcher cancelled");
            if (this.mCancelled) {
                return;
            }
            this.mCancelled = true;
            Future future = this.mFuture;
            if (future != null) {
                future.cancel(true);
            }
            this.mNetworkSession.cancel();
        }
    }

    private void _fetchInfoInternal() {
        if (this.mUseVideoModelCache && (TextUtils.isEmpty(this.mApiString) || !NetUtils.isNetAvailable(this.mContext) || this.mUseVideoModelCacheForce)) {
            TTVideoEngineLog.i("VideoInfoFetcher", "get videomodel from DB");
            EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.fetcher.VideoInfoFetcher.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoModelDBManager.CacheInfo query = VideoModelDBManager.query(VideoInfoFetcher.this.mVID);
                    if (query != null && !TextUtils.isEmpty(query.videoModelStr)) {
                        try {
                            JSONObject jSONObject = new JSONObject(query.videoModelStr);
                            TTVideoEngineLog.i("VideoInfoFetcher", "using videomodel from DB");
                            VideoInfoFetcher.this._getInfoSuccess(jSONObject, query);
                            return;
                        } catch (Exception e) {
                            TTVideoEngineLog.e("VideoInfoFetcher", e.toString());
                        }
                    }
                    if (!TextUtils.isEmpty(VideoInfoFetcher.this.mApiString)) {
                        VideoInfoFetcher videoInfoFetcher = VideoInfoFetcher.this;
                        videoInfoFetcher._beginToFetch(videoInfoFetcher.mApiString, null);
                    } else {
                        VideoInfoFetcher.this._notifyError(new Error("kTTVideoErrorDomainFetchingInfo", -9999, "apistring empty and no cache"));
                    }
                }
            });
        } else if (TextUtils.isEmpty(this.mApiString)) {
            _notifyError(new Error("kTTVideoErrorDomainFetchingInfo", -9999, "apistring empty"));
        } else {
            _beginToFetch(this.mApiString, null);
        }
    }

    public void setListener(FetcherListener fetcherListener) {
        this.mListener = fetcherListener;
    }

    public void setPlayType(int i) {
        this.mType = i;
    }

    public void setResolutionMap(HashMap<String, Resolution> hashMap) {
        this.mResolutionMap = hashMap;
    }

    public void setUseVideoModelCacheForce(boolean z) {
        this.mUseVideoModelCacheForce = z;
    }

    public void setVideoID(String str) {
        this.mVID = str;
    }

    public void setUseFallbakApi(Boolean bool) {
        this.mUseFallbakApi = bool.booleanValue();
    }

    private void _notifyShouldRetry(Error error) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, error));
    }

    public void setUseVideoModelCache(boolean z) {
        this.mUseVideoModelCache = z;
        if (z) {
            VideoModelDBManager.getInstance(this.mContext);
        }
    }

    private void _notifySuccess(VideoModel videoModel) {
        TTVideoEngineLog.i("VideoInfoFetcher", "_notifySuccess");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, videoModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _notifyError(Error error) {
        TTVideoEngineLog.i("VideoInfoFetcher", "_notifyError " + error);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, error));
    }

    private static class MyHandler extends HandlerDelegate {
        private final WeakReference<VideoInfoFetcher> mFetcherRef;

        static {
            Covode.recordClassIndex(652446);
        }

        public void handleMessage(Message message) {
            FetcherListener fetcherListener;
            VideoInfoFetcher videoInfoFetcher = this.mFetcherRef.get();
            if (videoInfoFetcher == null || (fetcherListener = videoInfoFetcher.mListener) == null) {
                return;
            }
            if (videoInfoFetcher.mCancelled) {
                fetcherListener.onLog("fetcher is cancelled");
                return;
            }
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            fetcherListener.onStatusException(message.arg1, (String) message.obj);
                            return;
                        }
                        return;
                    } else {
                        VideoModel videoModel = (VideoModel) message.obj;
                        videoInfoFetcher.mVideoModel = videoModel;
                        fetcherListener.onCompletion(videoModel, null);
                        return;
                    }
                }
                fetcherListener.onCompletion(null, (Error) message.obj);
                return;
            }
            fetcherListener.onRetry((Error) message.obj);
        }

        public MyHandler(VideoInfoFetcher videoInfoFetcher, Looper looper) {
            super(looper);
            this.mFetcherRef = new WeakReference<>(videoInfoFetcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _retryIfNeeded(Error error) {
        TTVideoEngineLog.i("VideoInfoFetcher", "_retryIfNeeded error " + error);
        synchronized (this) {
            if (this.mCancelled) {
                return;
            }
            if (error != null) {
                if (TextUtils.isEmpty(error.domain) && error.code == -9979) {
                    error = new Error("kTTVideoErrorDomainFetchingInfo", -9979, error.internalCode, error.description);
                } else if (TextUtils.isEmpty(error.domain)) {
                    error = new Error("kTTVideoErrorDomainFetchingInfo", -9994, error.internalCode, error.description);
                }
            } else {
                error = new Error("kTTVideoErrorDomainFetchingInfo", -9994);
            }
            if (error.code == -9969) {
                int i = error.internalCode;
                if (i / 10000 != 10 && i != -9970) {
                    error.code = -9990;
                }
                error.description += ("<apiStr:" + this.mApiString + ">");
                _notifyError(error);
                return;
            }
            if (this.mRetryIndex < this.mMaxRetryCount) {
                _notifyShouldRetry(error);
                this.mRetryIndex++;
                _fetchInfoInternal();
            } else {
                error.description += ("<apiStr:" + this.mApiString + ">");
                _notifyError(error);
            }
        }
    }

    private int parseErrorCode(JSONObject jSONObject) {
        if (jSONObject.has("CodeN")) {
            return jSONObject.optInt("CodeN");
        }
        if (jSONObject.has("Code")) {
            String optString = jSONObject.optString("Code");
            if (TextUtils.isEmpty(optString)) {
                return -1;
            }
            int indexOf = optString.indexOf(".");
            if (indexOf > 0) {
                optString = optString.substring(0, indexOf);
            }
            if (errorMapping == null) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                errorMapping = hashMap;
                hashMap.put("InvalidClientTokenId", 100009);
                errorMapping.put("SignatureDoesNotMatch", 100010);
                errorMapping.put("MissingSignature", 100005);
                errorMapping.put("InvalidTimestamp", 100006);
                errorMapping.put("LackProjectPolicy", 100012);
                errorMapping.put("AccessDenied", 100013);
                errorMapping.put("InternalServiceError", 100014);
                errorMapping.put("InternalServiceTimeout", 100016);
                errorMapping.put("FlowLimitExceeded", 100018);
                errorMapping.put("ServiceUnavailableTemp", 100019);
                errorMapping.put("MethodNotAllowed", 100020);
            }
            if (errorMapping.containsKey(optString)) {
                try {
                    return errorMapping.get(optString).intValue();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    private String _parseAPIString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "_parseAPIString:apistring is empty";
        }
        try {
            this.mHost = new URL(str).getHost();
            String[] split = str.split("[?]");
            if (split.length < 2) {
                return "_parseAPIString:apistring param is empty";
            }
            String[] split2 = split[1].split("&");
            this.mURLWithoutParams = split[0] + "?";
            this.mEnvParams = new JSONObject();
            this.mParams = new JSONObject();
            this.queryMap = new TreeMap<>();
            for (int i = 0; i < split2.length; i++) {
                if (this.mGetMethodEnable) {
                    String[] split3 = split2[i].split("=");
                    this.queryMap.put(split3[0], split3[1]);
                } else if (split2[i].indexOf("Action") != 0 && split2[i].indexOf("Version") != 0) {
                    String[] split4 = split2[i].split("=");
                    if (split4.length >= 2) {
                        String str2 = split4[0];
                        String str3 = split4[1];
                        for (int i2 = 2; i2 < split4.length; i2++) {
                            str3 = str3 + "=" + split4[i2];
                        }
                        int i3 = 0;
                        while (true) {
                            try {
                                String[] strArr = this.EnvParamsStrs;
                                if (i3 >= strArr.length) {
                                    break;
                                }
                                if (strArr[i3].equals(str2)) {
                                    this.mEnvParams.put(str2, str3);
                                }
                                i3++;
                            } catch (JSONException unused) {
                                return "_parseAPIString:put params error";
                            }
                        }
                        int i4 = 0;
                        while (true) {
                            String[] strArr2 = this.ParamsStrs;
                            if (i4 < strArr2.length) {
                                if (strArr2[i4].equals(str2)) {
                                    this.mParams.put(str2, str3);
                                }
                                i4++;
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    this.mURLWithoutParams += split2[i];
                    this.mURLWithoutParams += "&";
                    String[] split5 = split2[i].split("=");
                    this.queryMap.put(split5[0], split5[1]);
                }
            }
            String str4 = this.mURLWithoutParams;
            this.mURLWithoutParams = str4.substring(0, str4.length() - 1);
            return null;
        } catch (Throwable unused2) {
            return "_parseAPIString:apistring to URL error";
        }
    }

    public VideoInfoFetcher(Context context, TTVNetClient tTVNetClient) {
        this(context, tTVNetClient, "");
    }

    public void fetchInfo(String str, String str2) {
        this.mApiString = str;
        this.mAuth = str2;
        this.mRetryIndex = 0;
        _fetchInfoInternal();
    }

    private void _notifyException(int i, String str) {
        TTVideoEngineLog.i("VideoInfoFetcher", "_notifyException " + i + ", excMessage " + str);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, i, 0, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _beginToFetch(String str, JSONObject jSONObject) {
        HashMap hashMap;
        TTVideoEngineLog.i("VideoInfoFetcher", "_beginToFetch url " + str);
        this.mStartFetchT = SystemClock.elapsedRealtime();
        if (!TextUtils.isEmpty(this.mAuth)) {
            hashMap = new HashMap();
            hashMap.put("Authorization", this.mAuth);
        } else {
            hashMap = null;
        }
        HashMap hashMap2 = hashMap;
        Method[] declaredMethods = this.mNetworkSession.getClass().getDeclaredMethods();
        boolean z = false;
        if (declaredMethods != null && declaredMethods.length > 0) {
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Method method = declaredMethods[i];
                    if (method != null && method.getName() != null && method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.mNetworkSession.startTask(str, hashMap2, (JSONObject) null, 0, new TTVNetClient.CompletionListener() { // from class: com.ss.ttvideoengine.fetcher.VideoInfoFetcher.2
                @Override // com.ss.ttvideoengine.net.TTVNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject2, Error error) {
                    if (jSONObject2 == null && error != null) {
                        VideoInfoFetcher.this._retryIfNeeded(error);
                        return;
                    }
                    if (error != null) {
                        VideoInfoFetcher.this.mErrorCode = error.internalCode;
                    }
                    VideoInfoFetcher.this._getInfoSuccess(jSONObject2, null);
                }
            });
        } else {
            this.mNetworkSession.startTask(str, hashMap2, new TTVNetClient.CompletionListener() { // from class: com.ss.ttvideoengine.fetcher.VideoInfoFetcher.3
                @Override // com.ss.ttvideoengine.net.TTVNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject2, Error error) {
                    if (jSONObject2 == null && error != null) {
                        VideoInfoFetcher.this._retryIfNeeded(error);
                    } else {
                        VideoInfoFetcher.this._getInfoSuccess(jSONObject2, null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void _getInfoSuccess(org.json.JSONObject r9, com.ss.ttvideoengine.database.VideoModelDBManager.CacheInfo r10) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.fetcher.VideoInfoFetcher._getInfoSuccess(org.json.JSONObject, com.ss.ttvideoengine.database.VideoModelDBManager$CacheInfo):void");
    }

    public void fetchInfo(String str, String str2, int i) {
        fetchInfo(str, str2, i, null);
    }

    public VideoInfoFetcher(Context context, TTVNetClient tTVNetClient, String str) {
        this.mCancelled = false;
        this.mRetryIndex = 0;
        this.mType = 0;
        this.mApiString = "";
        this.mResolutionMap = null;
        this.mFuture = null;
        this.mStartFetchT = 0L;
        this.mUseVideoModelCache = false;
        this.mUseVideoModelCacheForce = false;
        this.mGetMethodEnable = true;
        this.mErrorCode = -1;
        this.mMaxRetryCount = 1;
        this.EnvParamsStrs = new String[]{"device_type", "device_id", "ac", "aid", "device_platform", "ab_version", "app_name", "version_code", "os_version", "menifest_version_code", "update_version_code", "user_id", "web_id", "player_version", "barragemask"};
        this.ParamsStrs = new String[]{"Action", "Version", "video_id", "codec_type", "base64", "url_type", "format_type", "ptoken", "preload", "cdn_type"};
        this.mContext = context;
        if (EngineGlobalConfig.getInstance().isUseVideoInfoFetcherHandlerThread()) {
            if (TTHelper.getLooper() == Looper.getMainLooper()) {
                if (!handlerThreadisStarted) {
                    synchronized (VideoInfoFetcher.class) {
                        if (!handlerThreadisStarted) {
                            OWN_HANDLER_THREAD.start();
                            handlerThreadisStarted = true;
                        }
                    }
                }
                this.mHandler = new MyHandler(this, OWN_HANDLER_THREAD.getLooper());
            } else {
                this.mHandler = new MyHandler(this, TTHelper.getLooper());
            }
        } else {
            this.mHandler = new MyHandler(this, TTHelper.getLooper());
        }
        TTVNetClient tTVNetClient2 = (tTVNetClient != null || (tTVNetClient2 = TTVideoEngineConfig.gNetClient) == null) ? tTVNetClient : tTVNetClient2;
        if (tTVNetClient2 == null) {
            this.isExternNetClient = false;
            this.mNetworkSession = new TTHTTPNetwork();
        } else {
            this.isExternNetClient = true;
            this.mNetworkSession = tTVNetClient2;
        }
        this.mProjectTag = str;
    }

    public void fetchInfo(String str, String str2, int i, String str3) {
        TTVideoEngineLog.i("VideoInfoFetcher", "fetchInfo apiString " + str + ", auth " + str2 + ", playversion " + i + ", keyseed " + str3);
        this.mApiString = str;
        this.mAuth = str2;
        this.mRetryIndex = 0;
        this.mPlayVersion = i;
        this.mKeyseed = str3;
        try {
            this.mHost = new URL(str).getHost();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        _fetchInfoInternal();
    }
}
