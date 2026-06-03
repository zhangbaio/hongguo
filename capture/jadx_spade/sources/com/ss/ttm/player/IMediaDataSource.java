package com.ss.ttm.player;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface IMediaDataSource extends Closeable {

    /* renamed from: com.ss.ttm.player.IMediaDataSource$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$close(IMediaDataSource iMediaDataSource, int i) {
            return -1;
        }

        public static String $default$getFilePath(IMediaDataSource iMediaDataSource) {
            return "/mds_default_file";
        }

        public static int $default$getMDSVersion(IMediaDataSource iMediaDataSource) {
            return 0;
        }

        public static long $default$getSize(IMediaDataSource iMediaDataSource, int i) {
            return -1L;
        }

        public static int $default$open(IMediaDataSource iMediaDataSource, String str) {
            return -1;
        }

        public static int $default$readAt(IMediaDataSource iMediaDataSource, int i, long j, ByteBuffer byteBuffer, int i2, int i3) {
            return -1;
        }
    }

    int close(int i);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    String getFilePath();

    int getMDSVersion();

    long getSize() throws IOException;

    long getSize(int i);

    int open(String str);

    int readAt(int i, long j, ByteBuffer byteBuffer, int i2, int i3);

    int readAt(long j, byte[] bArr, int i, int i2) throws IOException;
}
