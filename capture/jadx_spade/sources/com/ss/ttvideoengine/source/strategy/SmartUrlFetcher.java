package com.ss.ttvideoengine.source.strategy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.source.strategy.CodecStrategy;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.WeakHandler;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SmartUrlFetcher implements WeakHandler.IHandler {
    private final Callback mCallback;
    private volatile boolean mCanceled;
    private final Handler mH;
    private final TTVNetClient mHttpClient;
    private RequestParams mRequestParams;

    public interface Callback {
        void onComplete(RequestParams requestParams, int i, Result result);

        void onError(RequestParams requestParams, Error error);
    }

    static {
        Covode.recordClassIndex(652699);
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public static class SmartUrlCache {
        private static final Map<String, CacheHolder> sCacheMap;

        static {
            Covode.recordClassIndex(652703);
            sCacheMap = new HashMap();
        }

        public static void clear() {
            if (TTVideoEngineLog.d()) {
                TTVideoEngineLog.d("CodecStrategy_SmartUrlCache", "clear");
            }
            sCacheMap.clear();
        }

        public static class CacheHolder {
            private final long expiredMS;
            private final Result result;

            static {
                Covode.recordClassIndex(652704);
            }

            public CacheHolder(Result result, long j) {
                this.result = result;
                this.expiredMS = j;
            }
        }

        public static String key(RequestParams requestParams) {
            if (!TextUtils.isEmpty(requestParams.cacheKey)) {
                return requestParams.cacheKey;
            }
            return requestParams.playUrl;
        }

        private static Result find(String str) {
            CacheHolder cacheHolder = sCacheMap.get(str);
            if (cacheHolder == null) {
                return null;
            }
            if (cacheHolder.expiredMS == -1 || cacheHolder.expiredMS < SystemClock.uptimeMillis()) {
                return cacheHolder.result;
            }
            return null;
        }

        public static Result get(String str) {
            Result find = find(str);
            TTVideoEngineLog.d("CodecStrategy_SmartUrlCache", "get " + str + " " + find);
            return find;
        }

        public static void remove(String str) {
            if (TTVideoEngineLog.d()) {
                TTVideoEngineLog.d("CodecStrategy_SmartUrlCache", "remove " + str);
            }
            sCacheMap.remove(str);
        }

        public static void put(String str, Result result) {
            if (TTVideoEngineLog.d()) {
                TTVideoEngineLog.d("CodecStrategy_SmartUrlCache", "put " + str + " " + result);
            }
            sCacheMap.put(str, new CacheHolder(result, -1L));
        }
    }

    public static class Result {
        public final int dataStoreStatus;
        public final Error error;
        public final JSONObject jsonResult;
        public final String originalPlayUrl;
        public final int streamType;
        public final IVideoModel videoModel;

        static {
            Covode.recordClassIndex(652702);
        }

        private static boolean isStreamTypeValid(int i) {
            return i == 2 || i == 3;
        }

        public boolean isEncodeStream() {
            IVideoModel iVideoModel = this.videoModel;
            if (iVideoModel == null || iVideoModel.getVideoRefStr(2) == null) {
                return false;
            }
            VideoInfo videoInfo = this.videoModel.getVideoInfo(CodecStrategy.SmartUrlVod.findTargetResolution(this.videoModel), false);
            if (videoInfo == null) {
                return false;
            }
            String valueStr = videoInfo.getValueStr(0);
            String valueStr2 = videoInfo.getValueStr(17);
            if (TextUtils.isEmpty(valueStr) && TextUtils.isEmpty(valueStr2)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "Result{dataStoreStatus=" + this.dataStoreStatus + ", streamType=" + this.streamType + ", originalPlayUrl='" + this.originalPlayUrl + "', videoModel=" + this.videoModel + ", jsonResult=" + this.jsonResult + ", error=" + this.error + '}';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Result parseResult(JSONObject jSONObject) {
            JSONObject optJSONObject = jSONObject.optJSONObject("Result");
            if (optJSONObject == null) {
                return new Result(jSONObject, new Error("kTTVideoErrorDomainFetchingSmartUrlInfo", -9979, "Result is null"));
            }
            int optInt = optJSONObject.optInt("DataStoreStatus");
            int optInt2 = optJSONObject.optInt("StreamType");
            String optString = optJSONObject.optString("OriginalPlayUrl");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("PlayInfoModel");
            if (optJSONObject2 != null && isStreamTypeValid(optInt2)) {
                try {
                    VideoModel videoModel = new VideoModel();
                    videoModel.extractFields(optJSONObject2);
                    return new Result(optInt, optInt2, optString, videoModel, jSONObject, null);
                } catch (Throwable th) {
                    return new Result(optInt, optInt2, optString, null, jSONObject, new Error("kTTVideoErrorDomainFetchingSmartUrlInfo", -9976, "video model extract failed: " + th));
                }
            }
            return new Result(optInt, optInt2, optString, null, jSONObject, null);
        }

        public Result(JSONObject jSONObject, Error error) {
            this.dataStoreStatus = -1;
            this.streamType = -1;
            this.originalPlayUrl = null;
            this.videoModel = null;
            this.jsonResult = jSONObject;
            this.error = error;
        }

        public Result(int i, int i2, String str, IVideoModel iVideoModel, JSONObject jSONObject, Error error) {
            this.dataStoreStatus = i;
            this.streamType = i2;
            this.originalPlayUrl = str;
            this.videoModel = iVideoModel;
            this.jsonResult = jSONObject;
            this.error = error;
        }
    }

    public void cancel() {
        if (this.mCanceled) {
            return;
        }
        this.mCanceled = true;
        this.mHttpClient.cancel();
        this.mH.removeCallbacksAndMessages(null);
        if (TTVideoEngineLog.d()) {
            TTVideoEngineLog.d("CodecStrategy_SmartUrlFetcher", "cancel " + this.mRequestParams);
        }
    }

    public void start() {
        if (TTVideoEngineLog.d()) {
            TTVideoEngineLog.d("CodecStrategy_SmartUrlFetcher", "start " + this.mRequestParams);
        }
        RequestParams requestParams = this.mRequestParams;
        String key = SmartUrlCache.key(requestParams);
        Result result = SmartUrlCache.get(key);
        if (result != null) {
            notifyComplete(requestParams, 1, result);
        } else {
            fetch(key, requestParams);
        }
    }

    public static class RequestParams {
        public String cacheKey;
        public String codec;
        public String definition;
        public String playUrl;
        public String videoId;

        static {
            Covode.recordClassIndex(652701);
        }

        public String toString() {
            return "RequestParams{videoId='" + this.videoId + "', playUrl='" + this.playUrl + "', cacheKey='" + this.cacheKey + "', codec='" + this.codec + "', definition='" + this.definition + "'}";
        }
    }

    public void setRequestParams(RequestParams requestParams) {
        this.mRequestParams = requestParams;
    }

    public SmartUrlFetcher(Callback callback) {
        Looper myLooper;
        this.mCallback = callback;
        TTVNetClient tTVNetClient = TTVideoEngineConfig.gNetClient;
        if (tTVNetClient != null) {
            this.mHttpClient = tTVNetClient;
        } else {
            this.mHttpClient = new TTHTTPNetwork();
        }
        if (Looper.myLooper() == null) {
            myLooper = Looper.getMainLooper();
        } else {
            myLooper = Looper.myLooper();
        }
        this.mH = new WeakHandler(myLooper, this);
    }

    @Override // com.ss.ttvideoengine.utils.WeakHandler.IHandler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                Object[] objArr = (Object[]) message.obj;
                notifyError((RequestParams) objArr[0], (Error) objArr[1]);
                return;
            }
            return;
        }
        Object[] objArr2 = (Object[]) message.obj;
        notifyComplete((RequestParams) objArr2[0], ((Integer) objArr2[1]).intValue(), (Result) objArr2[2]);
    }

    private static String buildRequestUrl(RequestParams requestParams) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("PlayUrl", requestParams.playUrl);
        linkedHashMap.put("Codec", requestParams.codec);
        linkedHashMap.put("Definition", requestParams.definition);
        StringBuilder sb = new StringBuilder();
        String apiHost = CodecStrategy.SmartUrlVod.getApiHost();
        if (apiHost != null && !apiHost.startsWith("http")) {
            sb.append("https://");
        }
        sb.append(apiHost);
        sb.append("/api/general/getSmartStrategyLitePlayInfo20220101");
        sb.append("?");
        sb.append((CharSequence) TTHelper.buildUrlEncodedQuery(linkedHashMap));
        return sb.toString();
    }

    private void fetch(final String str, final RequestParams requestParams) {
        String buildRequestUrl = buildRequestUrl(requestParams);
        this.mHttpClient.startTask(buildRequestUrl, new TTVNetClient.CompletionListener() { // from class: com.ss.ttvideoengine.source.strategy.SmartUrlFetcher.1
            @Override // com.ss.ttvideoengine.net.TTVNetClient.CompletionListener
            public void onCompletion(JSONObject jSONObject, Error error) {
                if (SmartUrlFetcher.this.mCanceled) {
                    return;
                }
                if (error == null) {
                    if (jSONObject != null) {
                        Result parseResult = Result.parseResult(jSONObject);
                        Error error2 = parseResult.error;
                        if (error2 == null) {
                            SmartUrlCache.put(str, parseResult);
                            SmartUrlFetcher.this.notifyComplete(requestParams, 0, parseResult);
                            return;
                        } else {
                            SmartUrlFetcher.this.notifyError(requestParams, error2);
                            return;
                        }
                    }
                    SmartUrlFetcher.this.notifyError(requestParams, new Error("kTTVideoErrorDomainFetchingSmartUrlInfo", -9997));
                    return;
                }
                SmartUrlFetcher.this.notifyError(requestParams, error);
            }
        });
        if (TTVideoEngineLog.d()) {
            TTVideoEngineLog.d("CodecStrategy_SmartUrlFetcher", "fetch " + requestParams + ", requestUrl = " + buildRequestUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(RequestParams requestParams, Error error) {
        error.domain = "kTTVideoErrorDomainFetchingSmartUrlInfo";
        if (this.mH.getLooper() == Looper.myLooper()) {
            if (this.mCanceled) {
                if (TTVideoEngineLog.d()) {
                    TTVideoEngineLog.d("CodecStrategy_SmartUrlFetcher", "notifyError canceled");
                    return;
                }
                return;
            } else {
                if (this.mCallback == null) {
                    return;
                }
                if (TTVideoEngineLog.d()) {
                    TTVideoEngineLog.d("CodecStrategy_SmartUrlFetcher", "notifyError " + requestParams + " " + error);
                }
                this.mCallback.onError(requestParams, error);
                return;
            }
        }
        this.mH.obtainMessage(2, new Object[]{requestParams, error}).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyComplete(RequestParams requestParams, int i, Result result) {
        if (this.mH.getLooper() == Looper.myLooper()) {
            if (this.mCanceled) {
                if (TTVideoEngineLog.d()) {
                    TTVideoEngineLog.d("CodecStrategy_SmartUrlFetcher", "notifyComplete canceled");
                    return;
                }
                return;
            } else {
                if (this.mCallback == null) {
                    return;
                }
                if (TTVideoEngineLog.d()) {
                    TTVideoEngineLog.d("CodecStrategy_SmartUrlFetcher", "notifyComplete " + requestParams + " " + i + " " + result);
                }
                this.mCallback.onComplete(requestParams, i, result);
                return;
            }
        }
        this.mH.obtainMessage(1, new Object[]{requestParams, Integer.valueOf(i), result}).sendToTarget();
    }
}
