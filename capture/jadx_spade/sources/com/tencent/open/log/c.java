package com.tencent.open.log;

import com.bytedance.covode.number.Covode;
import com.tencent.connect.common.Constants;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    public static int a;
    public static int b;
    public static String c;
    public static String d;
    public static String e;
    public static long f;
    public static int g;
    public static int h;
    public static int i;
    public static String j;
    public static String k;
    public static String l;
    public static int m;
    public static long n;
    public static String o;

    static {
        Covode.recordClassIndex(653538);
        a = 60;
        b = 60;
        c = "OpenSDK.Client.File.Tracer";
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append("tencent");
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        d = sb.toString();
        e = ".log";
        f = 8388608L;
        g = 262144;
        h = 1024;
        i = 10000;
        j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
        o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
