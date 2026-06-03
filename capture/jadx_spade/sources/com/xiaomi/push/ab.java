package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ab {
    static {
        Covode.recordClassIndex(655328);
    }

    public static boolean a(Context context, String str, long j) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        try {
            PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(context.getFilesDir(), "/.vdevdir/");
            if (!u.m768a((File) polarisFileWrapper)) {
                v.a((Closeable) null);
                return true;
            }
            PolarisFileWrapper polarisFileWrapper2 = new PolarisFileWrapper(polarisFileWrapper, "lcfp.lock");
            v.m769a((File) polarisFileWrapper2);
            randomAccessFile = new RandomAccessFile((File) polarisFileWrapper2, "rw");
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    boolean b = b(context, str, j);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    v.a(randomAccessFile);
                    return b;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    v.a(randomAccessFile);
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                }
                v.a(randomAccessFile);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLock != null) {
                fileLock.release();
            }
            v.a(randomAccessFile);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00d9 A[Catch: all -> 0x00ed, IOException -> 0x00f0, LOOP:0: B:16:0x00d3->B:18:0x00d9, LOOP_END, TRY_LEAVE, TryCatch #7 {IOException -> 0x00f0, all -> 0x00ed, blocks: (B:15:0x00cf, B:16:0x00d3, B:18:0x00d9), top: B:14:0x00cf }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean b(android.content.Context r16, java.lang.String r17, long r18) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ab.b(android.content.Context, java.lang.String, long):boolean");
    }
}
