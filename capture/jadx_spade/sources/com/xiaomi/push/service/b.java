package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static volatile b a;

    /* renamed from: a, reason: collision with other field name */
    private Context f963a;
    private volatile String e;
    private volatile String f;

    /* renamed from: a, reason: collision with other field name */
    private final Object f964a = new Object();
    private final Object b = new Object();

    /* renamed from: a, reason: collision with other field name */
    private final String f965a = "mipush_region";

    /* renamed from: b, reason: collision with other field name */
    private final String f966b = "mipush_country_code";
    private final String c = "mipush_region.lock";
    private final String d = "mipush_country_code.lock";

    static {
        Covode.recordClassIndex(655703);
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = a(this.f963a, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
        return this.f;
    }

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = a(this.f963a, "mipush_region", "mipush_region.lock", this.f964a);
        }
        return this.e;
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    public b(Context context) {
        this.f963a = context;
    }

    public void b(String str, boolean z) {
        if (!TextUtils.equals(str, this.f)) {
            this.f = str;
        }
        if (z) {
            a(this.f963a, str, "mipush_country_code", "mipush_region.lock", this.f964a);
        }
    }

    public void a(String str, boolean z) {
        if (!TextUtils.equals(str, this.e)) {
            this.e = str;
        }
        if (z) {
            a(this.f963a, str, "mipush_region", "mipush_region.lock", this.f964a);
        }
    }

    private String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!polarisFileWrapper.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(context.getFilesDir(), str2);
                com.xiaomi.push.v.m769a((File) polarisFileWrapper2);
                randomAccessFile = new RandomAccessFile((File) polarisFileWrapper2, "rw");
            } catch (Exception e) {
                e = e;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
            }
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    try {
                        String a2 = com.xiaomi.push.v.a((File) polarisFileWrapper);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                        com.xiaomi.push.v.a(randomAccessFile);
                        return a2;
                    } catch (Exception e3) {
                        e = e3;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                com.xiaomi.channel.commonutils.logger.b.a(e4);
                            }
                        }
                        com.xiaomi.push.v.a(randomAccessFile);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileLock2 = fileLock;
                    if (fileLock2 != null && fileLock2.isValid()) {
                        try {
                            fileLock2.release();
                        } catch (IOException e5) {
                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                        }
                    }
                    com.xiaomi.push.v.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileLock = null;
            } catch (Throwable th3) {
                th = th3;
                if (fileLock2 != null) {
                    fileLock2.release();
                }
                com.xiaomi.push.v.a(randomAccessFile);
                throw th;
            }
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                try {
                    PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(context.getFilesDir(), str3);
                    com.xiaomi.push.v.m769a((File) polarisFileWrapper);
                    randomAccessFile = new RandomAccessFile((File) polarisFileWrapper, "rw");
                    try {
                        try {
                            fileLock = randomAccessFile.getChannel().lock();
                            com.xiaomi.push.v.a((File) new PolarisFileWrapper(context.getFilesDir(), str2), str);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                }
                            }
                            com.xiaomi.push.v.a(randomAccessFile);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                com.xiaomi.channel.commonutils.logger.b.a(e4);
                            }
                        }
                        com.xiaomi.push.v.a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                com.xiaomi.push.v.a(randomAccessFile);
                throw th;
            }
            com.xiaomi.push.v.a(randomAccessFile);
        }
    }
}
