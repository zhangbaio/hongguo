package com.tencent.tinker.lib;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.hotupgrade.api.ILogger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteLog {
    private static final ILogger DEFAULT_LOG;
    private static final List<Object[]> PENDING_LOGS;
    private static ILogger sCurLog;

    public static ILogger getImpl() {
        ILogger iLogger;
        synchronized (sCurLog) {
            iLogger = sCurLog;
        }
        return iLogger;
    }

    static {
        Covode.recordClassIndex(653705);
        PENDING_LOGS = new ArrayList();
        ILogger iLogger = new ILogger() { // from class: com.tencent.tinker.lib.MuteLog.1
            public void d(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.out.println(str + " >>> " + str2);
            }

            public void e(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.err.println(str + " >>> " + str2);
            }

            public void i(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.out.println(str + " >>> " + str2);
            }

            public void v(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.out.println(str + " >>> " + str2);
            }

            public void w(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.out.println(str + " >>> " + str2);
            }

            public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2 + "  " + Log.getStackTraceString(th);
                System.out.println(str + " >>> " + str3);
            }
        };
        DEFAULT_LOG = iLogger;
        sCurLog = iLogger;
    }

    public static void printPendingLogs() {
        final ILogger impl = getImpl();
        List<Object[]> list = PENDING_LOGS;
        synchronized (list) {
            if (impl != null) {
                if (!list.isEmpty()) {
                    new Thread(new Runnable() { // from class: com.tencent.tinker.lib.MuteLog.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
                            synchronized (MuteLog.PENDING_LOGS) {
                                for (Object[] objArr : MuteLog.PENDING_LOGS) {
                                    String str = "[PendingLog @ " + simpleDateFormat.format(new Date(((Long) objArr[1]).longValue())) + "] ";
                                    int intValue = ((Integer) objArr[0]).intValue();
                                    if (intValue != 2) {
                                        if (intValue != 3) {
                                            if (intValue != 4) {
                                                if (intValue != 5) {
                                                    if (intValue != 6) {
                                                        if (intValue == 4001) {
                                                            impl.printErrStackTrace((String) objArr[2], (Throwable) objArr[3], str + ((String) objArr[4]), (Object[]) objArr[5]);
                                                        }
                                                    } else {
                                                        impl.e((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                                    }
                                                } else {
                                                    impl.w((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                                }
                                            } else {
                                                impl.i((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                            }
                                        } else {
                                            impl.d((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                        }
                                    } else {
                                        impl.v((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                    }
                                }
                                MuteLog.PENDING_LOGS.clear();
                            }
                        }
                    }, "tinker_log_printer").start();
                }
            }
        }
    }

    public static void setImp(ILogger iLogger) {
        ILogger iLogger2;
        if (iLogger != null && iLogger != (iLogger2 = sCurLog)) {
            synchronized (iLogger2) {
                if (iLogger != sCurLog) {
                    sCurLog = iLogger;
                    printPendingLogs();
                }
            }
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        ILogger impl = getImpl();
        if (impl != null) {
            impl.d(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                list.add(new Object[]{3, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
            }
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        ILogger impl = getImpl();
        if (impl != null) {
            impl.e(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                list.add(new Object[]{6, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
            }
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        ILogger impl = getImpl();
        if (impl != null) {
            impl.i(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                list.add(new Object[]{4, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
            }
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        ILogger impl = getImpl();
        if (impl != null) {
            impl.v(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                list.add(new Object[]{2, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
            }
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        ILogger impl = getImpl();
        if (impl != null) {
            impl.w(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                list.add(new Object[]{5, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
            }
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        ILogger impl = getImpl();
        if (impl != null) {
            impl.printErrStackTrace(str, th, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                list.add(new Object[]{4001, Long.valueOf(System.currentTimeMillis()), str, th, str2, objArr});
            }
        }
    }
}
