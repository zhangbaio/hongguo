package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngineInternalLog {
    public static int LogNotifyLevel;
    public static int LogTurnOn;
    public static TTVideoEngineLogListener mListener;
    private static boolean sEnablePredicateLoglevelTurn;

    public static boolean d() {
        return logLevelTurnOn(1);
    }

    public static boolean e() {
        return logLevelTurnOn(6);
    }

    public static boolean i() {
        return logLevelTurnOn(2);
    }

    public static boolean k() {
        return logLevelTurnOn(4);
    }

    public static boolean t() {
        return logLevelTurnOn(3);
    }

    public static boolean w() {
        return logLevelTurnOn(5);
    }

    static {
        Covode.recordClassIndex(652761);
        LogTurnOn = 112;
        mListener = null;
        sEnablePredicateLoglevelTurn = false;
        LogNotifyLevel = 116;
    }

    public static void enablePredicateLoglevelTurn(boolean z) {
        sEnablePredicateLoglevelTurn = z;
    }

    public static void setListener(TTVideoEngineLogListener tTVideoEngineLogListener) {
        mListener = tTVideoEngineLogListener;
    }

    public static void d(Throwable th) {
        if (((LogTurnOn >> 1) & 1) == 1) {
            th.printStackTrace();
        }
    }

    public static boolean isPredicateLoglevelTurnOn(int i) {
        if (sEnablePredicateLoglevelTurn && !logLevelTurnOn(i)) {
            return false;
        }
        return true;
    }

    private static boolean logLevelTurnOn(int i) {
        if (((LogTurnOn >> i) & 1) == 1 || ((LogNotifyLevel >> i) & 1) == 1) {
            return true;
        }
        return false;
    }

    public static void setLogNotifyLevel(int i, int i2) {
        LogNotifyLevel = (i2 << i) | ((~(1 << i)) & LogNotifyLevel);
    }

    public static void turnOn(int i, int i2) {
        int i3 = ((~(1 << i)) & LogTurnOn) | (i2 << i);
        LogTurnOn = i3;
        if (i == 1 && i2 == 1) {
            LogTurnOn = (i3 & (-5)) | (i2 << 2);
        }
    }

    protected static void _notifyListener(String str, String str2) {
        if (mListener != null && !TextUtils.isEmpty(str2)) {
            TTVideoEngineLogListener tTVideoEngineLogListener = mListener;
            if (!TextUtils.isEmpty(str)) {
                str2 = "TTVideoEngine: tag = " + str + ";  " + str2;
            }
            tTVideoEngineLogListener.consoleLog(str2);
        }
    }

    public static void d(String str, String str2) {
        if (((LogNotifyLevel >> 1) & 1) == 1) {
            _notifyListener(str, str2);
        }
        if (((LogTurnOn >> 1) & 1) == 1) {
            Log.d("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static void e(String str, String str2) {
        if (((LogNotifyLevel >> 6) & 1) == 1) {
            _notifyListener(str, str2);
        }
        if (((LogTurnOn >> 6) & 1) == 1) {
            Log.e("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static void i(String str, String str2) {
        if (((LogNotifyLevel >> 2) & 1) == 1) {
            _notifyListener(str, str2);
        }
        if (((LogTurnOn >> 2) & 1) == 1) {
            Log.i("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static void k(String str, String str2) {
        if (((LogNotifyLevel >> 4) & 1) == 1) {
            _notifyListener(str, str2);
        }
        if (((LogTurnOn >> 4) & 1) == 1) {
            Log.i("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static void t(String str, String str2) {
        if (((LogNotifyLevel >> 3) & 1) == 1) {
            _notifyListener(str, str2);
        }
        if (((LogTurnOn >> 3) & 1) == 1) {
            Log.i("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }

    public static void w(String str, String str2) {
        if (((LogNotifyLevel >> 5) & 1) == 1) {
            _notifyListener(str, str2);
        }
        if (((LogTurnOn >> 5) & 1) == 1) {
            Log.w("TTVideoEngineLog", String.format("<%s>%s", str, str2));
        }
    }
}
