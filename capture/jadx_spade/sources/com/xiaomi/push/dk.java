package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.push.ad;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class dk extends ad.a {
    protected int a;

    /* renamed from: a, reason: collision with other field name */
    protected Context f262a;

    static {
        Covode.recordClassIndex(655447);
    }

    public abstract gg a();

    public abstract String b();

    /* renamed from: b, reason: collision with other method in class */
    protected boolean m276b() {
        return true;
    }

    /* renamed from: c, reason: collision with other method in class */
    protected boolean m277c() {
        return false;
    }

    private String c() {
        return "dc_job_result_time_" + mo187a();
    }

    private String d() {
        return "dc_job_result_" + mo187a();
    }

    /* renamed from: a, reason: collision with other method in class */
    protected boolean m275a() {
        return dh.a(this.f262a, String.valueOf(mo187a()), this.a);
    }

    @Override // java.lang.Runnable
    public void run() {
        String a;
        String b = b();
        if (TextUtils.isEmpty(b)) {
            return;
        }
        if (m275a()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("DC run job mutual: " + mo187a());
            return;
        }
        de m273a = df.a().m273a();
        if (m273a == null) {
            a = "";
        } else {
            a = m273a.a();
        }
        if (TextUtils.isEmpty(a) || !m276b()) {
            return;
        }
        if (m277c()) {
            SharedPreferences sharedPreferences = this.f262a.getSharedPreferences("mipush_extra", 0);
            if (ba.a(b).equals(sharedPreferences.getString(d(), null))) {
                long j = sharedPreferences.getLong(c(), 0L);
                int a2 = com.xiaomi.push.service.ah.a(this.f262a).a(gj.DCJobUploadRepeatedInterval.a(), 604800);
                if ((System.currentTimeMillis() - j) / 1000 < this.a) {
                    return;
                }
                if ((System.currentTimeMillis() - j) / 1000 < a2) {
                    b = "same_" + j;
                }
            }
        }
        gm gmVar = new gm();
        gmVar.a(b);
        gmVar.a(System.currentTimeMillis());
        gmVar.a(a());
        a(this.f262a, gmVar, a);
    }

    public dk(Context context, int i) {
        this.a = i;
        this.f262a = context;
    }

    public static void a(Context context, gm gmVar) {
        String a;
        de m273a = df.a().m273a();
        if (m273a == null) {
            a = "";
        } else {
            a = m273a.a();
        }
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(gmVar.a())) {
            return;
        }
        a(context, gmVar, a);
    }

    private static void a(Context context, gm gmVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] b = dh.b(str, ho.a(gmVar));
        if (b != null && b.length != 0) {
            synchronized (di.a) {
                FileLock fileLock = null;
                BufferedOutputStream bufferedOutputStream2 = null;
                fileLock = null;
                fileLock = null;
                fileLock = null;
                try {
                    try {
                        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(context.getFilesDir(), "push_cdata.lock");
                        v.m769a((File) polarisFileWrapper);
                        randomAccessFile = new RandomAccessFile((File) polarisFileWrapper, "rw");
                        try {
                            FileLock lock = randomAccessFile.getChannel().lock();
                            try {
                                PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(context.getFilesDir(), "push_cdata.data");
                                if (u.m768a((File) polarisFileWrapper2)) {
                                    bufferedOutputStream = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(polarisFileWrapper2, true));
                                    try {
                                        bufferedOutputStream.write(x.a(b.length));
                                        bufferedOutputStream.write(b);
                                        bufferedOutputStream.flush();
                                        polarisFileWrapper2.setLastModified(0L);
                                        bufferedOutputStream2 = bufferedOutputStream;
                                    } catch (IOException e) {
                                        e = e;
                                        fileLock = lock;
                                        try {
                                            e.printStackTrace();
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException unused) {
                                                }
                                            }
                                            v.a(bufferedOutputStream);
                                            v.a(randomAccessFile);
                                        } catch (Throwable th) {
                                            th = th;
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException unused2) {
                                                }
                                            }
                                            v.a(bufferedOutputStream);
                                            v.a(randomAccessFile);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileLock = lock;
                                        if (fileLock != null) {
                                            fileLock.release();
                                        }
                                        v.a(bufferedOutputStream);
                                        v.a(randomAccessFile);
                                        throw th;
                                    }
                                }
                                if (lock != null && lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                v.a(bufferedOutputStream2);
                            } catch (IOException e2) {
                                e = e2;
                                bufferedOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedOutputStream = null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            bufferedOutputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedOutputStream = null;
                        }
                    } catch (Throwable th5) {
                        throw th5;
                    }
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                }
                v.a(randomAccessFile);
            }
        }
    }
}
