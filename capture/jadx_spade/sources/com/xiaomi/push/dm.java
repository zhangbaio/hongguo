package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.push.ad;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dm extends ad.a {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f263a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.ah f264a;

    static {
        Covode.recordClassIndex(655449);
    }

    @Override // com.xiaomi.push.ad.a
    /* renamed from: a */
    public String mo187a() {
        return "1";
    }

    private void a() {
        SharedPreferences.Editor edit = this.f263a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m278a() {
        if (at.d(this.a)) {
            return false;
        }
        if ((at.f(this.a) || at.e(this.a)) && !c()) {
            return true;
        }
        if ((!at.g(this.a) || b()) && !at.h(this.a)) {
            return false;
        }
        return true;
    }

    private boolean b() {
        if (!this.f264a.a(gj.Upload3GSwitch.a(), true)) {
            return false;
        }
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f263a.getLong("last_upload_data_timestamp", -1L)) > Math.max(86400, this.f264a.a(gj.Upload3GFrequency.a(), 432000))) {
            return true;
        }
        return false;
    }

    private boolean c() {
        if (!this.f264a.a(gj.Upload4GSwitch.a(), true)) {
            return false;
        }
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f263a.getLong("last_upload_data_timestamp", -1L)) > Math.max(86400, this.f264a.a(gj.Upload4GFrequency.a(), 259200))) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(this.a.getFilesDir(), "push_cdata.data");
        if (!at.c(this.a)) {
            if (polarisFileWrapper.length() > 1863680) {
                polarisFileWrapper.delete();
                return;
            }
            return;
        }
        if (m278a() || !polarisFileWrapper.exists()) {
            return;
        }
        List<gm> a = a((File) polarisFileWrapper);
        if (!y.a(a)) {
            int size = a.size();
            if (size > 4000) {
                a = a.subList(size - 4000, size);
            }
            gx gxVar = new gx();
            gxVar.a(a);
            byte[] a2 = v.a(ho.a(gxVar));
            hd hdVar = new hd("-1", false);
            hdVar.c(go.DataCollection.f529a);
            hdVar.a(a2);
            de m273a = df.a().m273a();
            if (m273a != null) {
                m273a.a(hdVar, ge.Notification, null);
            }
            a();
        }
        polarisFileWrapper.delete();
    }

    public dm(Context context) {
        this.a = context;
        this.f263a = context.getSharedPreferences("mipush_extra", 0);
        this.f264a = com.xiaomi.push.service.ah.a(context);
    }

    private void a(gm gmVar) {
        if (gmVar.f520a == gg.AppInstallList && !gmVar.f521a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f263a.edit();
            edit.putLong("dc_job_result_time_4", gmVar.f519a);
            edit.putString("dc_job_result_4", ba.a(gmVar.f521a));
            edit.commit();
        }
    }

    private List<gm> a(File file) {
        String a;
        RandomAccessFile randomAccessFile;
        PolarisFileInputStreamWrapper polarisFileInputStreamWrapper;
        de m273a = df.a().m273a();
        if (m273a == null) {
            a = "";
        } else {
            a = m273a.a();
        }
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (di.a) {
            try {
                PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(this.a.getFilesDir(), "push_cdata.lock");
                v.m769a((File) polarisFileWrapper);
                randomAccessFile = new RandomAccessFile((File) polarisFileWrapper, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(file);
                        while (polarisFileInputStreamWrapper.read(bArr) == 4) {
                            try {
                                int a2 = x.a(bArr);
                                byte[] bArr2 = new byte[a2];
                                if (polarisFileInputStreamWrapper.read(bArr2) != a2) {
                                    break;
                                }
                                byte[] a3 = dh.a(a, bArr2);
                                if (a3 != null && a3.length != 0) {
                                    gm gmVar = new gm();
                                    ho.a(gmVar, a3);
                                    arrayList.add(gmVar);
                                    a(gmVar);
                                }
                            } catch (Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                v.a((Closeable) polarisFileInputStreamWrapper);
                                v.a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                v.a((Closeable) polarisFileInputStreamWrapper);
                                v.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        v.a((Closeable) polarisFileInputStreamWrapper);
                    } catch (Exception unused5) {
                        polarisFileInputStreamWrapper = null;
                    } catch (Throwable th2) {
                        th = th2;
                        polarisFileInputStreamWrapper = null;
                    }
                } catch (Exception unused6) {
                    polarisFileInputStreamWrapper = null;
                } catch (Throwable th3) {
                    th = th3;
                    polarisFileInputStreamWrapper = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                polarisFileInputStreamWrapper = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                polarisFileInputStreamWrapper = null;
            }
            v.a(randomAccessFile);
        }
        return arrayList;
    }
}
