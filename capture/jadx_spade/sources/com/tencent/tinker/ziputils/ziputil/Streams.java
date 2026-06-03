package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Streams {
    private static AtomicReference<byte[]> skipBuffer;

    private Streams() {
    }

    static {
        Covode.recordClassIndex(653977);
        skipBuffer = new AtomicReference<>();
    }

    public static byte[] readFully(InputStream inputStream) throws IOException {
        try {
            return readFullyNoClose(inputStream);
        } finally {
            inputStream.close();
        }
    }

    public static int readSingleByte(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1];
        if (inputStream.read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public static void skipAll(InputStream inputStream) throws IOException {
        do {
            inputStream.skip(Long.MAX_VALUE);
        } while (inputStream.read() != -1);
    }

    public static byte[] readFullyNoClose(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String readAsciiLine(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                if (read == 10) {
                    int length = sb.length();
                    if (length > 0) {
                        int i = length - 1;
                        if (sb.charAt(i) == '\r') {
                            sb.setLength(i);
                        }
                    }
                    return sb.toString();
                }
                sb.append((char) read);
            } else {
                throw new EOFException();
            }
        }
    }

    public static String readFully(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    return stringWriter.toString();
                }
            }
        } finally {
            reader.close();
        }
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void writeSingleByte(OutputStream outputStream, int i) throws IOException {
        outputStream.write(new byte[]{(byte) (i & 255)});
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                i += read;
                outputStream.write(bArr, 0, read);
            } else {
                return i;
            }
        }
    }

    public static long skipByReading(InputStream inputStream, long j) throws IOException {
        int min;
        int read;
        byte[] andSet = skipBuffer.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        long j2 = 0;
        while (j2 < j && (read = inputStream.read(andSet, 0, (min = (int) Math.min(j - j2, andSet.length)))) != -1) {
            j2 += read;
            if (read < min) {
                break;
            }
        }
        skipBuffer.set(andSet);
        return j2;
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        if (inputStream != null) {
            if (bArr != null) {
                Arrays.checkOffsetAndCount(bArr.length, i, i2);
                while (i2 > 0) {
                    int read = inputStream.read(bArr, i, i2);
                    if (read >= 0) {
                        i += read;
                        i2 -= read;
                    } else {
                        throw new EOFException();
                    }
                }
                return;
            }
            throw new NullPointerException("dst == null");
        }
        throw new NullPointerException("in == null");
    }
}
