package com.ss.videoarch.live.ttquic;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTLogManager implements com.ss.videoarch.live.ttquic.b {
    private static final String TAG;
    private static final String[] mAlogEventKey;
    private com.ss.videoarch.live.ttquic.b mListener;
    private Handler mLogHandler;
    private final Object mLogLock;
    private HandlerThread mLogThread;

    private static class c {
        private static final TTLogManager a;

        static {
            Covode.recordClassIndex(652893);
            a = new TTLogManager(null);
        }
    }

    public static int sdk_int() {
        return Build.VERSION.SDK_INT;
    }

    public static TTLogManager getInstance() {
        return c.a;
    }

    static {
        Covode.recordClassIndex(652892);
        TAG = TTLogManager.class.getCanonicalName();
        mAlogEventKey = new String[]{"live_client_log_reserved", "live_client_log_request_start", "live_client_log_response", "live_client_log_net_info", "live_client_log_request_end"};
    }

    private TTLogManager() {
        this.mListener = null;
        this.mLogThread = null;
        this.mLogHandler = null;
        this.mLogLock = new Object();
        init();
    }

    private void deInit() {
        Handler handler = this.mLogHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mLogHandler = null;
        }
        HandlerThread handlerThread = this.mLogThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mLogThread = null;
        }
    }

    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ JSONObject c;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (TTLogManager.this.mLogLock) {
                int i = this.a;
                if (i == 1 || i == 101) {
                    AppLogNewUtils.onEventV3(TTLogManager.mAlogEventKey[this.b], this.c);
                }
            }
        }

        a(int i, int i2, JSONObject jSONObject) {
            this.a = i;
            this.b = i2;
            this.c = jSONObject;
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        @Override // java.lang.Runnable
        public void run() {
            synchronized (TTLogManager.this.mLogLock) {
                if (TTLogManager.this.mListener != null) {
                    TTLogManager.this.mListener.onMonitoryLog(this.a, this.b, this.c);
                }
            }
        }

        b(int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }
    }

    private void init() {
        if (this.mLogThread == null) {
            HandlerThread handlerThread = new HandlerThread("ttquic_log_manager");
            this.mLogThread = handlerThread;
            handlerThread.start();
        }
        if (this.mLogHandler == null) {
            this.mLogHandler = new HandlerDelegate(this.mLogThread.getLooper());
        }
    }

    /* synthetic */ TTLogManager(a aVar) {
        this();
    }

    public void setLogListener(com.ss.videoarch.live.ttquic.b bVar) {
        synchronized (this.mLogLock) {
            this.mListener = bVar;
        }
    }

    @Override // com.ss.videoarch.live.ttquic.b
    public void onMonitoryLog(int i, int i2, String str) {
        Log.i(TAG, "monitor log: " + str);
        Handler handler = this.mLogHandler;
        if (handler != null) {
            handler.post(new b(i, i2, str));
        }
    }

    public void onAlog(int i, int i2, String str) {
        JSONObject jSONObject;
        if (i2 < 0 || i2 > 4) {
            Log.w(TAG, "onAlog failed, event not support, event: " + i2);
        }
        Log.i(TAG, "alog: " + str);
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            Log.e(TAG, "create jLog failed: " + str);
            jSONObject = null;
        }
        Handler handler = this.mLogHandler;
        if (handler != null && jSONObject != null) {
            handler.post(new a(i, i2, jSONObject));
        }
    }
}
