package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.db;
import com.xiaomi.push.dc;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Logger {
    private static boolean sDisablePushLog;
    private static LoggerInterface sUserLogger;

    public static File getLogFile(String str) {
        return null;
    }

    public static void uploadLogFile(Context context, boolean z) {
    }

    protected static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    static {
        Covode.recordClassIndex(655266);
        sDisablePushLog = false;
        sUserLogger = null;
    }

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    public static void setPushLog(Context context) {
        boolean z;
        LoggerInterface loggerInterface;
        boolean z2 = false;
        if (sUserLogger != null) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = sDisablePushLog;
        if (!z3) {
            z2 = z;
        }
        boolean z4 = !z3;
        dc dcVar = null;
        if (z2) {
            loggerInterface = sUserLogger;
        } else {
            loggerInterface = null;
        }
        if (z4) {
            dcVar = dc.a(context);
        }
        com.xiaomi.channel.commonutils.logger.b.a(new db(loggerInterface, dcVar));
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }
}
