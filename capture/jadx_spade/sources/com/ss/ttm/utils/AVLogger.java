package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AVLogger {
    private static int gLogLevel;
    private static Method methodLogD;
    private static Method methodLogE;
    private static Method methodLogI;
    private static Method methodLogW;
    private static Class<?> objectTTVideoEngineLog;

    public static void Debug(String str, Object obj, String str2) {
    }

    public static void Verbose(String str, Object obj, String str2) {
    }

    public static void d(String str, String str2) {
    }

    public static void v(String str, String str2) {
    }

    static {
        Covode.recordClassIndex(652225);
        objectTTVideoEngineLog = null;
        methodLogI = null;
        methodLogD = null;
        methodLogW = null;
        methodLogE = null;
        gLogLevel = 33554432;
    }

    public static void setLogLevel(int i) {
        gLogLevel = i;
    }

    public static void e(String str, String str2) {
        Error(str, null, str2);
    }

    public static void i(String str, String str2) {
        Info(str, null, str2);
    }

    public static void k(String str, String str2) {
        InfoKill(str, null, str2);
    }

    public static void w(String str, String str2) {
        Warn(str, null, str2);
    }

    public static void Error(String str, Object obj, String str2) {
        log(67108864, str, obj, str2);
    }

    public static void Info(String str, Object obj, String str2) {
        log(33554432, str, obj, str2);
    }

    public static void InfoKill(String str, Object obj, String str2) {
        log(34603008, str, obj, str2);
    }

    public static void InfoTrackFunc(String str, Object obj, String str2) {
        log(42860544, str, obj, str2);
    }

    public static void InfoTrackLife(String str, Object obj, String str2) {
        log(42926080, str, obj, str2);
    }

    public static void Warn(String str, Object obj, String str2) {
        log(50331648, str, obj, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0113 A[Catch: Exception -> 0x0125, TryCatch #1 {Exception -> 0x0125, blocks: (B:41:0x00d1, B:45:0x00d5, B:48:0x00e5, B:49:0x00e9, B:51:0x00f9, B:52:0x00fd, B:54:0x0113, B:55:0x0117, B:57:0x010d), top: B:24:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0117 A[Catch: Exception -> 0x0125, TRY_LEAVE, TryCatch #1 {Exception -> 0x0125, blocks: (B:41:0x00d1, B:45:0x00d5, B:48:0x00e5, B:49:0x00e9, B:51:0x00f9, B:52:0x00fd, B:54:0x0113, B:55:0x0117, B:57:0x010d), top: B:24:0x00af }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void log(int r9, java.lang.String r10, java.lang.Object r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.utils.AVLogger.log(int, java.lang.String, java.lang.Object, java.lang.String):void");
    }
}
