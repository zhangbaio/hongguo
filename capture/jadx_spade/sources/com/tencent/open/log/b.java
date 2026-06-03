package com.tencent.open.log;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.open.log.d;
import com.tencent.open.utils.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static SimpleDateFormat a;
    private File g;
    private String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = 4096;
    private long f = 10000;
    private int h = 10;
    private String i = ".log";
    private long j = Long.MAX_VALUE;

    public String c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    static {
        Covode.recordClassIndex(653537);
        a = d.C0113d.a("yy.MM.dd.HH");
    }

    public File b() {
        File e = e();
        if (e != null) {
            e.mkdirs();
        }
        return e;
    }

    public File[] a() {
        return d(System.currentTimeMillis());
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public void a(File file) {
        this.g = file;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(int i) {
        this.e = i;
    }

    public void d(int i) {
        this.h = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void c(long j) {
        this.j = j;
    }

    public static String a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public void b(String str) {
        this.i = str;
    }

    private File[] d(long j) {
        PolarisFileWrapper polarisFileWrapper;
        File b = b();
        String c = c(a(j));
        try {
            b = new PolarisFileWrapper(b, c);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG", "getWorkFile,get old sdcard file exception:", th);
        }
        String b2 = m.b();
        if (!TextUtils.isEmpty(b2) || b2 != null) {
            try {
                PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(b2, c.o);
                if (!polarisFileWrapper2.exists()) {
                    polarisFileWrapper2.mkdirs();
                }
                polarisFileWrapper = new PolarisFileWrapper(polarisFileWrapper2, c);
            } catch (Exception e) {
                SLog.e("openSDK_LOG", "getWorkFile,get app specific file exception:", e);
            }
            return new File[]{b, polarisFileWrapper};
        }
        polarisFileWrapper = null;
        return new File[]{b, polarisFileWrapper};
    }

    public b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        a(file);
        b(i);
        a(i2);
        c(i3);
        a(str);
        b(j);
        d(i4);
        b(str2);
        c(j2);
    }
}
