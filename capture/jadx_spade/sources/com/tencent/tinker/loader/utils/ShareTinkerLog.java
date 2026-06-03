package com.tencent.tinker.loader.utils;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ShareTinkerLog {
    private static final TinkerLogImp DEFAULT_LOG;
    private static final List<Object[]> PENDING_LOGS;
    private static TinkerLogImp sCurLog;

    public interface TinkerLogImp {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static TinkerLogImp getDefaultImpl() {
        return DEFAULT_LOG;
    }

    public static TinkerLogImp getImpl() {
        TinkerLogImp tinkerLogImp;
        synchronized (sCurLog) {
            tinkerLogImp = sCurLog;
        }
        return tinkerLogImp;
    }

    static {
        Covode.recordClassIndex(653967);
        PENDING_LOGS = new ArrayList();
        TinkerLogImp tinkerLogImp = new TinkerLogImp() { // from class: com.tencent.tinker.loader.utils.ShareTinkerLog.1
            @Override // com.tencent.tinker.loader.utils.ShareTinkerLog.TinkerLogImp
            public void d(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.out.println(str + " >>> " + str2);
            }

            @Override // com.tencent.tinker.loader.utils.ShareTinkerLog.TinkerLogImp
            public void e(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.err.println(str + " >>> " + str2);
            }

            @Override // com.tencent.tinker.loader.utils.ShareTinkerLog.TinkerLogImp
            public void i(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.out.println(str + " >>> " + str2);
            }

            @Override // com.tencent.tinker.loader.utils.ShareTinkerLog.TinkerLogImp
            public void v(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.out.println(str + " >>> " + str2);
            }

            @Override // com.tencent.tinker.loader.utils.ShareTinkerLog.TinkerLogImp
            public void w(String str, String str2, Object... objArr) {
                if (objArr != null && objArr.length != 0) {
                    str2 = String.format(str2, objArr);
                }
                System.out.println(str + " >>> " + str2);
            }

            @Override // com.tencent.tinker.loader.utils.ShareTinkerLog.TinkerLogImp
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
        DEFAULT_LOG = tinkerLogImp;
        sCurLog = tinkerLogImp;
    }

    public static void printPendingLogs() {
        final TinkerLogImp impl = getImpl();
        List<Object[]> list = PENDING_LOGS;
        synchronized (list) {
            if (impl != null) {
                if (!list.isEmpty()) {
                    new Thread(new Runnable() { // from class: com.tencent.tinker.loader.utils.ShareTinkerLog.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
                            synchronized (ShareTinkerLog.PENDING_LOGS) {
                                for (Object[] objArr : ShareTinkerLog.PENDING_LOGS) {
                                    String str = "[PendingLog @ " + simpleDateFormat.format(new Date(((Long) objArr[1]).longValue())) + "] ";
                                    int intValue = ((Integer) objArr[0]).intValue();
                                    if (intValue != 2) {
                                        if (intValue != 3) {
                                            if (intValue != 4) {
                                                if (intValue != 5) {
                                                    if (intValue != 6) {
                                                        if (intValue == 4001) {
                                                            TinkerLogImp.this.printErrStackTrace((String) objArr[2], (Throwable) objArr[3], str + ((String) objArr[4]), (Object[]) objArr[5]);
                                                        }
                                                    } else {
                                                        TinkerLogImp.this.e((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                                    }
                                                } else {
                                                    TinkerLogImp.this.w((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                                }
                                            } else {
                                                TinkerLogImp.this.i((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                            }
                                        } else {
                                            TinkerLogImp.this.d((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                        }
                                    } else {
                                        TinkerLogImp.this.v((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                    }
                                }
                                ShareTinkerLog.PENDING_LOGS.clear();
                            }
                        }
                    }, "tinker_log_printer").start();
                }
            }
        }
    }

    public static void setTinkerLogImp(TinkerLogImp tinkerLogImp) {
        TinkerLogImp tinkerLogImp2;
        if (tinkerLogImp != null && tinkerLogImp != (tinkerLogImp2 = sCurLog)) {
            synchronized (tinkerLogImp2) {
                if (tinkerLogImp != sCurLog) {
                    sCurLog = tinkerLogImp;
                    printPendingLogs();
                }
            }
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        TinkerLogImp impl = getImpl();
        if (impl != null) {
            impl.d(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                if (list.size() < 2048) {
                    list.add(new Object[]{3, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
                }
            }
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        TinkerLogImp impl = getImpl();
        if (impl != null) {
            impl.i(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                if (list.size() < 2048) {
                    list.add(new Object[]{4, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
                }
            }
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        TinkerLogImp impl = getImpl();
        if (impl != null) {
            impl.v(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                if (list.size() < 2048) {
                    list.add(new Object[]{2, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
                }
            }
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        TinkerLogImp impl = getImpl();
        if (impl != null) {
            impl.w(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                if (list.size() < 2048) {
                    list.add(new Object[]{5, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
                }
            }
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        TinkerLogImp impl = getImpl();
        if (impl != null) {
            impl.e(str, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                if (list.size() < 2048) {
                    list.add(new Object[]{6, Long.valueOf(System.currentTimeMillis()), str, str2, objArr});
                }
            }
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        TinkerLogImp impl = getImpl();
        if (impl != null) {
            impl.printErrStackTrace(str, th, str2, objArr);
        }
        if (impl == null || impl == DEFAULT_LOG) {
            List<Object[]> list = PENDING_LOGS;
            synchronized (list) {
                if (list.size() < 2048) {
                    list.add(new Object[]{4001, Long.valueOf(System.currentTimeMillis()), str, th, str2, objArr});
                }
            }
        }
    }
}
