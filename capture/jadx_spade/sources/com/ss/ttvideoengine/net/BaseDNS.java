package com.ss.ttvideoengine.net;

import android.os.Handler;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BaseDNS {
    protected boolean mCancelled;
    protected Handler mHandler;
    protected String mHostname;
    protected DNSCompletionListener mListener;
    protected TTVNetClient mNetClient;

    static {
        Covode.recordClassIndex(652574);
    }

    public void cancel() {
    }

    public void close() {
    }

    public void start() {
    }

    protected void notifyCancelled() {
        this.mHandler.sendEmptyMessage(0);
    }

    public void setCompletionListener(DNSCompletionListener dNSCompletionListener) {
        this.mListener = dNSCompletionListener;
    }

    private static class MyHandler extends HandlerDelegate {
        private final WeakReference<BaseDNS> mDNSRef;

        static {
            Covode.recordClassIndex(652575);
        }

        public MyHandler(BaseDNS baseDNS) {
            super(TTHelper.getLooper());
            this.mDNSRef = new WeakReference<>(baseDNS);
        }

        public void handleMessage(Message message) {
            DNSCompletionListener dNSCompletionListener;
            BaseDNS baseDNS = this.mDNSRef.get();
            if (baseDNS == null || (dNSCompletionListener = baseDNS.mListener) == null || baseDNS.mCancelled) {
                return;
            }
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            baseDNS.close();
                            dNSCompletionListener.onCompletion((JSONObject) message.obj, null);
                            return;
                        }
                        return;
                    }
                    baseDNS.close();
                    dNSCompletionListener.onCompletion(null, (Error) message.obj);
                    return;
                }
                baseDNS.close();
                dNSCompletionListener.onRetry((Error) message.obj);
                return;
            }
            dNSCompletionListener.onCancelled();
        }
    }

    protected void notifyError(Error error) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, error));
    }

    protected void notifyRetry(Error error) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, error));
    }

    protected void notifySuccess(JSONObject jSONObject) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, jSONObject));
    }

    public BaseDNS(String str) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = str;
        this.mHandler = new MyHandler(this);
    }

    public BaseDNS(String str, TTVNetClient tTVNetClient) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = str;
        this.mHandler = new MyHandler(this);
        this.mNetClient = tTVNetClient == null ? new TTHTTPNetwork() : tTVNetClient;
    }
}
