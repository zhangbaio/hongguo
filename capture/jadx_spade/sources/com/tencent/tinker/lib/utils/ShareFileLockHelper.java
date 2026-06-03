package com.tencent.tinker.lib.utils;

import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.tencent.tinker.lib.MuteLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ShareFileLockHelper implements Closeable {
    private final FileLock fileLock;
    private final FileOutputStream outputStream;

    static {
        Covode.recordClassIndex(653940);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public static ShareFileLockHelper getFileLock(File file) throws IOException {
        return new ShareFileLockHelper(file);
    }

    private ShareFileLockHelper(File file) throws IOException {
        boolean z;
        this.outputStream = new PolarisFileOutputStreamWrapper(file);
        FileLock fileLock = null;
        Exception e = null;
        int i = 0;
        while (i < 3) {
            i++;
            try {
                fileLock = this.outputStream.getChannel().lock();
                if (fileLock != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } catch (Exception e2) {
                e = e2;
                MuteLog.e("Tinker.FileLockHelper", "getInfoLock Thread failed time:10", new Object[0]);
            }
            try {
                ThreadMonitor.sleepMonitor(10L);
            } catch (Exception e3) {
                MuteLog.e("Tinker.FileLockHelper", "getInfoLock Thread sleep exception", e3);
            }
        }
        if (fileLock != null) {
            this.fileLock = fileLock;
            return;
        }
        throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + file.getAbsolutePath(), e);
    }
}
