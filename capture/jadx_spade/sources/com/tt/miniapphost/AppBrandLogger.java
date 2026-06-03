package com.tt.miniapphost;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.debug.tag.business.module.miniapp.MiniappTag;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AppBrandLogger {
    private static Boolean isGsonSupport;
    private static ILogger sFeedbackLogger;
    private static ILogger sLogger;
    private static boolean sLoggerDisable;
    private static boolean sShowMoreLogInfo;

    public interface ILogger {
        void flush();

        void logD(String str, String str2);

        void logE(String str, String str2);

        void logE(String str, String str2, Throwable th);

        void logI(String str, String str2);

        void logW(String str, String str2);
    }

    public static boolean debug() {
        return sShowMoreLogInfo;
    }

    public static boolean isShowMoreLogInfo() {
        return sShowMoreLogInfo;
    }

    public static void flush() {
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.flush();
        }
    }

    private static void updateLoggerEnableState() {
        boolean z;
        if (sLogger == null && sFeedbackLogger == null) {
            z = true;
        } else {
            z = false;
        }
        sLoggerDisable = z;
    }

    static {
        Covode.recordClassIndex(654102);
        sShowMoreLogInfo = LocalTestManager.isDebug(new Class[]{MiniappTag.class});
        sLoggerDisable = true;
    }

    public static void registerFeedbackLogger(ILogger iLogger) {
        sFeedbackLogger = iLogger;
        updateLoggerEnableState();
    }

    public static void registerLogger(ILogger iLogger) {
        sLogger = iLogger;
        updateLoggerEnableState();
    }

    private static String formatTag(String str) {
        if (str == null) {
            return "tma";
        }
        if (!str.startsWith("tma_")) {
            return "tma_" + str;
        }
        return str;
    }

    public static void setShowMoreLogInfo(boolean z) {
        sShowMoreLogInfo = z;
        i("AppBrandLogger", "setShowMoreLogInfo:", Boolean.valueOf(z));
    }

    public static String prettifyJson(String str) {
        Boolean bool = isGsonSupport;
        if (bool == Boolean.FALSE) {
            return str;
        }
        if (bool == null) {
            try {
                a.q("com.google.gson.Gson");
                isGsonSupport = Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                isGsonSupport = Boolean.FALSE;
                return str;
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return new GsonBuilder().setPrettyPrinting().create().toJson(new JsonParser().parse(str).getAsJsonObject());
    }

    private static String createLog(Object[] objArr) {
        int i;
        String str;
        String str2;
        if (objArr == null) {
            return "empty_log";
        }
        StringBuilder sb = new StringBuilder();
        if (sShowMoreLogInfo) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 2) {
                str = stackTrace[2].getFileName();
                str2 = stackTrace[2].getMethodName();
                i = stackTrace[2].getLineNumber();
            } else {
                i = -1;
                str = "unknown file";
                str2 = "unknown";
            }
            sb.append(str2);
            sb.append('(');
            sb.append(str);
            sb.append(':');
            sb.append(i);
            sb.append(") ");
        }
        for (Object obj : objArr) {
            sb.append(' ');
            if (obj != null) {
                sb.append(obj);
            } else {
                sb.append("null");
            }
        }
        return sb.toString();
    }

    public static void d(String str, Object... objArr) {
        String str2;
        String str3;
        if (sLoggerDisable) {
            if (sShowMoreLogInfo) {
                Log.d(formatTag(str), createLog(objArr));
                return;
            }
            return;
        }
        if (sShowMoreLogInfo) {
            str2 = formatTag(str);
            str3 = createLog(objArr);
            ILogger iLogger = sLogger;
            if (iLogger != null) {
                iLogger.logD(str2, str3);
            }
        } else {
            str2 = null;
            str3 = null;
        }
        if (sFeedbackLogger != null) {
            if (str2 == null) {
                str2 = formatTag(str);
            }
            if (str3 == null) {
                str3 = createLog(objArr);
            }
            sFeedbackLogger.logD(str2, str3);
        }
    }

    public static void i(String str, Object... objArr) {
        if (sLoggerDisable) {
            if (sShowMoreLogInfo) {
                Log.i(formatTag(str), createLog(objArr));
                return;
            }
            return;
        }
        String formatTag = formatTag(str);
        String createLog = createLog(objArr);
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.logI(formatTag, createLog);
        }
        ILogger iLogger2 = sFeedbackLogger;
        if (iLogger2 != null) {
            iLogger2.logI(formatTag, createLog);
        }
    }

    public static void w(String str, Object... objArr) {
        if (sLoggerDisable) {
            if (sShowMoreLogInfo) {
                Log.w(formatTag(str), createLog(objArr));
                return;
            }
            return;
        }
        String formatTag = formatTag(str);
        String createLog = createLog(objArr);
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.logW(formatTag, createLog);
        }
        ILogger iLogger2 = sFeedbackLogger;
        if (iLogger2 != null) {
            iLogger2.logW(formatTag, createLog);
        }
    }

    public static void e(String str, Object... objArr) {
        boolean z;
        if (objArr != null && objArr.length > 0 && (objArr[objArr.length - 1] instanceof Throwable)) {
            z = true;
        } else {
            z = false;
        }
        if (sLoggerDisable) {
            if (sShowMoreLogInfo) {
                String createLog = createLog(objArr);
                if (z) {
                    Log.e(formatTag(str), createLog, (Throwable) objArr[objArr.length - 1]);
                    return;
                } else {
                    Log.e(formatTag(str), createLog);
                    return;
                }
            }
            return;
        }
        String formatTag = formatTag(str);
        String createLog2 = createLog(objArr);
        if (z) {
            eWithThrowable(formatTag, createLog2, (Throwable) objArr[objArr.length - 1]);
            return;
        }
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.logE(formatTag, createLog2);
        }
        ILogger iLogger2 = sFeedbackLogger;
        if (iLogger2 != null) {
            iLogger2.logE(formatTag, createLog2);
        }
    }

    public static void eWithThrowable(String str, String str2, Throwable th) {
        if (sLoggerDisable) {
            if (sShowMoreLogInfo) {
                Log.e(formatTag(str), str2, th);
                return;
            }
            return;
        }
        String formatTag = formatTag(str);
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.logE(formatTag, str2, th);
        }
        ILogger iLogger2 = sFeedbackLogger;
        if (iLogger2 != null) {
            iLogger2.logE(formatTag, str2, th);
        }
    }

    public static void stacktrace(int i, String str, StackTraceElement[] stackTraceElementArr) {
        int i2 = 0;
        if (sLoggerDisable) {
            if (sShowMoreLogInfo) {
                StringBuilder sb = new StringBuilder();
                if (stackTraceElementArr != null) {
                    int length = stackTraceElementArr.length;
                    while (i2 < length) {
                        sb.append(stackTraceElementArr[i2]);
                        sb.append("\n");
                        i2++;
                    }
                }
                Log.e(formatTag(str), sb.toString());
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (stackTraceElementArr != null) {
            int length2 = stackTraceElementArr.length;
            while (i2 < length2) {
                sb2.append(stackTraceElementArr[i2]);
                sb2.append("\n");
                i2++;
            }
        }
        String sb3 = sb2.toString();
        String formatTag = formatTag(str);
        ILogger iLogger = sLogger;
        if (iLogger != null) {
            iLogger.logE(formatTag, sb3);
        }
        ILogger iLogger2 = sFeedbackLogger;
        if (iLogger2 != null) {
            iLogger2.logE(formatTag, sb3);
        }
    }
}
