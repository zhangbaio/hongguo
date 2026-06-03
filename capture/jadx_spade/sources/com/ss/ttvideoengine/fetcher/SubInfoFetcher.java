package com.ss.ttvideoengine.fetcher;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.net.ChannelSelect;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SubInfoFetcher {
    private Context mContext;
    private String mHost;
    private FetcherListener mListener;
    private TTVNetClient mNetworkSession;
    private ArrayList<String> mTriedHost;
    private boolean mCancelled = false;
    private String mSubApiString = "";
    private int mErrorCode = -1;
    private int mRetryIndex = 0;
    private int mMaxRetryCount = 1;
    private Handler mHandler = new MyHandler(this, TTHelper.getLooper());

    public interface FetcherListener {
        void onCompletion(String str, Error error);

        void onLog(String str);
    }

    static {
        Covode.recordClassIndex(652441);
    }

    public String _extractFields(JSONObject jSONObject) {
        return "";
    }

    private void _fetchInfoInternal() {
        if (TextUtils.isEmpty(this.mSubApiString)) {
            _notifyError(new Error("kTTVideoErrorDomainSubFetchingInfo", -9930, "sub ApiString empty"));
        } else {
            _beginToFetch(this.mSubApiString);
        }
    }

    private boolean _isTriedAllHost() {
        List groupByApiVersionLocked;
        if (this.mTriedHost == null || (groupByApiVersionLocked = ChannelSelect.getInstance().groupByApiVersionLocked(4)) == null || groupByApiVersionLocked.size() != this.mTriedHost.size()) {
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
            this.mNetworkSession.cancel();
        }
    }

    public void setListener(FetcherListener fetcherListener) {
        this.mListener = fetcherListener;
    }

    private void _beginToFetch(String str) {
        this.mNetworkSession.startTask(str, new TTVNetClient.CompletionListener() { // from class: com.ss.ttvideoengine.fetcher.SubInfoFetcher.1
            @Override // com.ss.ttvideoengine.net.TTVNetClient.CompletionListener
            public void onCompletion(JSONObject jSONObject, Error error) {
                if (error != null) {
                    SubInfoFetcher.this.mErrorCode = error.internalCode;
                }
                if (jSONObject != null || error == null) {
                    SubInfoFetcher.this._getInfoSuccess(jSONObject);
                } else {
                    SubInfoFetcher.this._notifyError(error);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _notifyError(Error error) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, error));
    }

    private void _notifySuccess(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, str));
    }

    public void fetchInfo(String str) {
        this.mSubApiString = str;
        try {
            this.mHost = new URL(str).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        _fetchInfoInternal();
    }

    private static class MyHandler extends HandlerDelegate {
        private final WeakReference<SubInfoFetcher> mFetcherRef;

        static {
            Covode.recordClassIndex(652443);
        }

        public void handleMessage(Message message) {
            FetcherListener fetcherListener;
            SubInfoFetcher subInfoFetcher = this.mFetcherRef.get();
            if (subInfoFetcher == null || (fetcherListener = subInfoFetcher.mListener) == null) {
                return;
            }
            if (subInfoFetcher.mCancelled) {
                fetcherListener.onLog("fetcher is cancelled");
                return;
            }
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    fetcherListener.onCompletion((String) message.obj, null);
                    return;
                }
                return;
            }
            fetcherListener.onCompletion(null, (Error) message.obj);
        }

        public MyHandler(SubInfoFetcher subInfoFetcher, Looper looper) {
            super(looper);
            this.mFetcherRef = new WeakReference<>(subInfoFetcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _getInfoSuccess(JSONObject jSONObject) {
        synchronized (this) {
            if (!this.mCancelled && jSONObject != null) {
                TTVideoEngineLog.d("SubInfoFetcher", "sub jsonObject:" + jSONObject.toString());
                int optInt = jSONObject.optInt("code");
                String optString = jSONObject.optString("message");
                String optString2 = jSONObject.optString("trace_id");
                if (optInt != 200) {
                    Error error = new Error("kTTVideoErrorDomainSubFetchingInfo", -9932, optInt, optString);
                    error.parameters.put("log_id", optString2);
                    _notifyError(error);
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        _notifyError(new Error("kTTVideoErrorDomainSubFetchingInfo", -9931, "sub fetched info Result is empty"));
                    } else {
                        _notifySuccess(optJSONObject.toString());
                    }
                }
            }
        }
    }

    private void _retryIfNeeded(Error error) {
        TTVideoEngineLog.i("SubInfoFetcher", "_retryIfNeeded error " + error);
        synchronized (this) {
            if (this.mCancelled) {
                return;
            }
            int i = this.mRetryIndex;
            if (i < this.mMaxRetryCount) {
                this.mRetryIndex = i + 1;
                _fetchInfoInternal();
            } else {
                error.description += ("<apiStr:" + this.mSubApiString + ">");
                _notifyError(error);
            }
        }
    }

    public SubInfoFetcher(Context context, TTVNetClient tTVNetClient) {
        this.mContext = context;
        if (tTVNetClient == null) {
            this.mNetworkSession = new TTHTTPNetwork();
        } else {
            this.mNetworkSession = tTVNetClient;
        }
    }
}
