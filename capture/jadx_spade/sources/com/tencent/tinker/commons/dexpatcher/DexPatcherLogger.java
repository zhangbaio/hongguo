package com.tencent.tinker.commons.dexpatcher;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DexPatcherLogger {
    private IDexPatcherLogger loggerImpl = null;

    public interface IDexPatcherLogger {
        void d(String str);

        void e(String str);

        void i(String str);

        void v(String str);

        void w(String str);
    }

    static {
        Covode.recordClassIndex(653653);
    }

    public IDexPatcherLogger getLoggerImpl() {
        return this.loggerImpl;
    }

    public void setLoggerImpl(IDexPatcherLogger iDexPatcherLogger) {
        this.loggerImpl = iDexPatcherLogger;
    }

    public void d(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[D][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            if (objArr != null && objArr.length != 0) {
                str3 = String.format(str3, objArr);
            }
            iDexPatcherLogger.d(str3);
        }
    }

    public void e(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[E][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            if (objArr != null && objArr.length != 0) {
                str3 = String.format(str3, objArr);
            }
            iDexPatcherLogger.e(str3);
        }
    }

    public void i(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[I][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            if (objArr != null && objArr.length != 0) {
                str3 = String.format(str3, objArr);
            }
            iDexPatcherLogger.i(str3);
        }
    }

    public void v(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[V][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            if (objArr != null && objArr.length != 0) {
                str3 = String.format(str3, objArr);
            }
            iDexPatcherLogger.v(str3);
        }
    }

    public void w(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[W][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            if (objArr != null && objArr.length != 0) {
                str3 = String.format(str3, objArr);
            }
            iDexPatcherLogger.w(str3);
        }
    }
}
