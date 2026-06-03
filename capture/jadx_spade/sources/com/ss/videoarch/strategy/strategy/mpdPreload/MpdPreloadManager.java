package com.ss.videoarch.strategy.strategy.mpdPreload;

import android.content.Context;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import com.ss.videoarch.strategy.utils.JNINamespace;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MpdPreloadManager {
    private Context mContext;
    private Boolean mInitialized;

    static {
        Covode.recordClassIndex(653167);
    }

    private native void nativeInit();

    private static class b {
        private static final MpdPreloadManager a;

        static {
            Covode.recordClassIndex(653168);
            a = new MpdPreloadManager();
        }
    }

    private MpdPreloadManager() {
        this.mContext = null;
        this.mInitialized = Boolean.FALSE;
    }

    public static synchronized MpdPreloadManager getInstance() {
        MpdPreloadManager mpdPreloadManager;
        synchronized (MpdPreloadManager.class) {
            mpdPreloadManager = b.a;
        }
        return mpdPreloadManager;
    }

    private void loadNative() {
        if (this.mInitialized.booleanValue()) {
            return;
        }
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            Log.e("MpdPreloadManager", "init MpdPreloadManager failed, so load failed");
            return;
        }
        SettingsManager.getInstance();
        nativeInit();
        this.mInitialized = Boolean.TRUE;
    }

    public synchronized void init(Context context) {
        if (this.mContext != context) {
            this.mContext = context;
        }
        loadNative();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:52|53|54|55|(2:57|(11:59|60|(1:62)|63|64|65|(1:67)|68|(1:70)|72|73))|76|60|(0)|63|64|65|(0)|68|(0)|72|73) */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a0, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016a A[Catch: MalformedURLException -> 0x01c5, JSONException -> 0x01c7, TryCatch #2 {MalformedURLException -> 0x01c5, blocks: (B:13:0x004a, B:16:0x0065, B:18:0x0074, B:20:0x007a, B:22:0x0084, B:23:0x008b, B:28:0x00b5, B:31:0x00bc, B:33:0x00c2, B:36:0x00b1, B:38:0x00c9, B:40:0x00f6, B:42:0x00fe, B:44:0x0104, B:45:0x0109, B:47:0x010f, B:52:0x011c, B:54:0x012e, B:55:0x0139, B:57:0x0144, B:59:0x015e, B:60:0x0164, B:62:0x016a, B:63:0x017e, B:65:0x0183, B:67:0x018e, B:68:0x0193, B:70:0x0199, B:72:0x01a3, B:75:0x01a0, B:79:0x0136, B:80:0x01a8), top: B:12:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018e A[Catch: JSONException -> 0x019f, MalformedURLException -> 0x01c5, TryCatch #2 {MalformedURLException -> 0x01c5, blocks: (B:13:0x004a, B:16:0x0065, B:18:0x0074, B:20:0x007a, B:22:0x0084, B:23:0x008b, B:28:0x00b5, B:31:0x00bc, B:33:0x00c2, B:36:0x00b1, B:38:0x00c9, B:40:0x00f6, B:42:0x00fe, B:44:0x0104, B:45:0x0109, B:47:0x010f, B:52:0x011c, B:54:0x012e, B:55:0x0139, B:57:0x0144, B:59:0x015e, B:60:0x0164, B:62:0x016a, B:63:0x017e, B:65:0x0183, B:67:0x018e, B:68:0x0193, B:70:0x0199, B:72:0x01a3, B:75:0x01a0, B:79:0x0136, B:80:0x01a8), top: B:12:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0199 A[Catch: JSONException -> 0x019f, MalformedURLException -> 0x01c5, TRY_LEAVE, TryCatch #2 {MalformedURLException -> 0x01c5, blocks: (B:13:0x004a, B:16:0x0065, B:18:0x0074, B:20:0x007a, B:22:0x0084, B:23:0x008b, B:28:0x00b5, B:31:0x00bc, B:33:0x00c2, B:36:0x00b1, B:38:0x00c9, B:40:0x00f6, B:42:0x00fe, B:44:0x0104, B:45:0x0109, B:47:0x010f, B:52:0x011c, B:54:0x012e, B:55:0x0139, B:57:0x0144, B:59:0x015e, B:60:0x0164, B:62:0x016a, B:63:0x017e, B:65:0x0183, B:67:0x018e, B:68:0x0193, B:70:0x0199, B:72:0x01a3, B:75:0x01a0, B:79:0x0136, B:80:0x01a8), top: B:12:0x004a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String GetPreloadInfo(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.mpdPreload.MpdPreloadManager.GetPreloadInfo(java.lang.String):java.lang.String");
    }
}
