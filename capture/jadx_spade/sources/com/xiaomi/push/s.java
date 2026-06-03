package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class s {
    private static final Set<String> a;

    /* renamed from: a, reason: collision with other field name */
    private Context f853a;

    /* renamed from: a, reason: collision with other field name */
    private RandomAccessFile f854a;

    /* renamed from: a, reason: collision with other field name */
    private String f855a;

    /* renamed from: a, reason: collision with other field name */
    private FileLock f856a;

    static {
        Covode.recordClassIndex(655630);
        a = Collections.synchronizedSet(new HashSet());
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f856a);
        FileLock fileLock = this.f856a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f856a.release();
            } catch (IOException unused) {
            }
            this.f856a = null;
        }
        RandomAccessFile randomAccessFile = this.f854a;
        if (randomAccessFile != null) {
            v.a(randomAccessFile);
        }
        a.remove(this.f855a);
    }

    private s(Context context) {
        this.f853a = context;
    }

    public static s a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(str);
        if (!polarisFileWrapper.exists()) {
            polarisFileWrapper.getParentFile().mkdirs();
            polarisFileWrapper.createNewFile();
        }
        Set<String> set = a;
        if (set.add(str)) {
            s sVar = new s(context);
            sVar.f855a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile((File) polarisFileWrapper, "rw");
                sVar.f854a = randomAccessFile;
                sVar.f856a = randomAccessFile.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + sVar.f856a);
                if (sVar.f856a == null) {
                    RandomAccessFile randomAccessFile2 = sVar.f854a;
                    if (randomAccessFile2 != null) {
                        v.a(randomAccessFile2);
                    }
                    set.remove(sVar.f855a);
                }
                return sVar;
            } catch (Throwable th) {
                if (sVar.f856a == null) {
                    RandomAccessFile randomAccessFile3 = sVar.f854a;
                    if (randomAccessFile3 != null) {
                        v.a(randomAccessFile3);
                    }
                    a.remove(sVar.f855a);
                }
                throw th;
            }
        }
        throw new IOException("abtain lock failure");
    }
}
