package com.tencent.tinker.lib.signature;

import android.system.Os;
import android.system.OsConstants;
import com.bytedance.covode.number.Covode;
import java.io.FileDescriptor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class MemoryMappedFileDataSource implements DataSource {
    private static final long MEMORY_PAGE_SIZE_BYTES;
    private final FileDescriptor mFd;
    private final long mFilePosition;
    private final long mSize;

    @Override // com.tencent.tinker.lib.signature.DataSource
    public long size() {
        return this.mSize;
    }

    static {
        Covode.recordClassIndex(653806);
        MEMORY_PAGE_SIZE_BYTES = Os.sysconf(OsConstants._SC_PAGESIZE);
    }

    MemoryMappedFileDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        this.mFd = fileDescriptor;
        this.mFilePosition = j;
        this.mSize = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.tinker.lib.signature.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void feedIntoDataDigester(com.tencent.tinker.lib.signature.DataDigester r19, long r20, int r22) throws java.io.IOException, java.security.DigestException {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.signature.MemoryMappedFileDataSource.feedIntoDataDigester(com.tencent.tinker.lib.signature.DataDigester, long, int):void");
    }
}
