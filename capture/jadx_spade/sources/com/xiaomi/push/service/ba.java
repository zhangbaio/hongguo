package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.push.gi;
import com.xiaomi.push.ho;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ba {
    public static final Object a;

    static {
        Covode.recordClassIndex(655704);
        a = new Object();
    }

    public static byte[] a(Context context) {
        String a2 = com.xiaomi.push.n.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.ba.a(20);
            com.xiaomi.push.n.a(context).m639a("mipush", "td_key", a2);
        }
        return a(a2);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.push.ax.m165a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    public static void a(final Context context, final gi giVar) {
        if (!az.a(giVar.e())) {
            return;
        }
        com.xiaomi.push.ad.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.ba.1
            @Override // java.lang.Runnable
            public void run() {
                RandomAccessFile randomAccessFile;
                synchronized (ba.a) {
                    FileLock fileLock = null;
                    try {
                        try {
                            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(context.getFilesDir(), "tiny_data.lock");
                            com.xiaomi.push.v.m769a((File) polarisFileWrapper);
                            randomAccessFile = new RandomAccessFile((File) polarisFileWrapper, "rw");
                            try {
                                try {
                                    fileLock = randomAccessFile.getChannel().lock();
                                    ba.c(context, giVar);
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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void c(Context context, gi giVar) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        ?? a2 = a(context);
        try {
            try {
                byte[] b = com.xiaomi.push.h.b(a2, ho.a(giVar));
                if (b != null && b.length >= 1) {
                    if (b.length > 30720) {
                        com.xiaomi.channel.commonutils.logger.b.m54a("TinyData write to cache file failed case too much data content item:" + giVar.d() + "  ts:" + System.currentTimeMillis());
                        com.xiaomi.push.v.a((Closeable) null);
                        com.xiaomi.push.v.a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(com.xiaomi.push.x.a(b.length));
                        bufferedOutputStream3.write(b);
                        bufferedOutputStream3.flush();
                        com.xiaomi.push.v.a((Closeable) null);
                        com.xiaomi.push.v.a(bufferedOutputStream3);
                        return;
                    } catch (IOException e) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed cause io exception item:" + giVar.d(), e);
                        a2 = bufferedOutputStream2;
                        com.xiaomi.push.v.a((Closeable) null);
                        com.xiaomi.push.v.a((Closeable) a2);
                        return;
                    } catch (Exception e2) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file  failed item:" + giVar.d(), e);
                        a2 = bufferedOutputStream;
                        com.xiaomi.push.v.a((Closeable) null);
                        com.xiaomi.push.v.a((Closeable) a2);
                        return;
                    } catch (Throwable th) {
                        a2 = bufferedOutputStream3;
                        th = th;
                        com.xiaomi.push.v.a((Closeable) null);
                        com.xiaomi.push.v.a((Closeable) a2);
                        throw th;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m54a("TinyData write to cache file failed case encryption fail item:" + giVar.d() + "  ts:" + System.currentTimeMillis());
                com.xiaomi.push.v.a((Closeable) null);
                com.xiaomi.push.v.a((Closeable) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = null;
        } catch (Exception e4) {
            e = e4;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            a2 = 0;
        }
    }
}
