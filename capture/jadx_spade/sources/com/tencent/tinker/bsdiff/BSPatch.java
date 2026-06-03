package com.tencent.tinker.bsdiff;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BSPatch {
    static {
        Covode.recordClassIndex(653650);
    }

    public static byte[] patchFast(InputStream inputStream, InputStream inputStream2) throws IOException {
        if (inputStream == null || inputStream2 == null) {
            return null;
        }
        byte[] inputStreamToByte = BSUtil.inputStreamToByte(inputStream);
        byte[] inputStreamToByte2 = BSUtil.inputStreamToByte(inputStream2);
        return patchFast(inputStreamToByte, inputStreamToByte.length, inputStreamToByte2, inputStreamToByte2.length, 0);
    }

    public static int patchFast(InputStream inputStream, InputStream inputStream2, File file) throws IOException {
        if (inputStream == null) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (inputStream2 == null) {
            return 2;
        }
        byte[] inputStreamToByte = BSUtil.inputStreamToByte(inputStream);
        byte[] inputStreamToByte2 = BSUtil.inputStreamToByte(inputStream2);
        byte[] patchFast = patchFast(inputStreamToByte, inputStreamToByte.length, inputStreamToByte2, inputStreamToByte2.length, 0);
        PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(file);
        try {
            polarisFileOutputStreamWrapper.write(patchFast);
            polarisFileOutputStreamWrapper.close();
            return 1;
        } catch (Throwable th) {
            polarisFileOutputStreamWrapper.close();
            throw th;
        }
    }

    public static byte[] patchFast(InputStream inputStream, int i, byte[] bArr, int i2) throws IOException {
        byte[] bArr2 = new byte[i];
        BSUtil.readFromStream(inputStream, bArr2, 0, i);
        inputStream.close();
        return patchFast(bArr2, i, bArr, bArr.length, i2);
    }

    public static int patchFast(File file, File file2, File file3, int i) throws IOException {
        if (file != null && file.length() > 0) {
            if (file2 == null) {
                return 4;
            }
            if (file3 != null && file3.length() > 0) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new PolarisFileInputStreamWrapper(file));
                int length = (int) file3.length();
                byte[] bArr = new byte[length];
                PolarisFileInputStreamWrapper polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(file3);
                try {
                    BSUtil.readFromStream(polarisFileInputStreamWrapper, bArr, 0, length);
                    polarisFileInputStreamWrapper.close();
                    byte[] patchFast = patchFast(bufferedInputStream, (int) file.length(), bArr, i);
                    PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(file2);
                    try {
                        polarisFileOutputStreamWrapper.write(patchFast);
                        polarisFileOutputStreamWrapper.close();
                        return 1;
                    } catch (Throwable th) {
                        polarisFileOutputStreamWrapper.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    polarisFileInputStreamWrapper.close();
                    throw th2;
                }
            }
            return 2;
        }
        return 3;
    }

    public static int patchLessMemory(RandomAccessFile randomAccessFile, File file, File file2, int i) throws IOException {
        if (randomAccessFile != null && randomAccessFile.length() > 0) {
            if (file == null) {
                return 4;
            }
            if (file2 != null && file2.length() > 0) {
                int length = (int) file2.length();
                byte[] bArr = new byte[length];
                PolarisFileInputStreamWrapper polarisFileInputStreamWrapper = new PolarisFileInputStreamWrapper(file2);
                try {
                    BSUtil.readFromStream(polarisFileInputStreamWrapper, bArr, 0, length);
                    polarisFileInputStreamWrapper.close();
                    return patchLessMemory(randomAccessFile, (int) randomAccessFile.length(), bArr, length, file, i);
                } catch (Throwable th) {
                    polarisFileInputStreamWrapper.close();
                    throw th;
                }
            }
            return 2;
        }
        return 3;
    }

    public static byte[] patchFast(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws IOException {
        int i4;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2, 0, i2));
        dataInputStream.skip(8L);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, i2);
        byteArrayInputStream.skip(32L);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr2, 0, i2);
        byteArrayInputStream2.skip(readLong + 32);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr2, 0, i2);
        byteArrayInputStream3.skip(readLong2 + readLong + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
        byte[] bArr3 = new byte[readLong3];
        int[] iArr = new int[3];
        int i5 = 0;
        int i6 = 0;
        while (i5 < readLong3) {
            for (int i7 = 0; i7 <= 2; i7++) {
                iArr[i7] = dataInputStream2.readInt();
            }
            int i8 = iArr[0];
            if (i5 + i8 <= readLong3) {
                if (BSUtil.readFromStream(gZIPInputStream, bArr3, i5, i8)) {
                    int i9 = 0;
                    while (true) {
                        i4 = iArr[0];
                        if (i9 >= i4) {
                            break;
                        }
                        int i10 = i6 + i9;
                        if (i10 >= 0 && i10 < i) {
                            int i11 = i5 + i9;
                            bArr3[i11] = (byte) (bArr3[i11] + bArr[i10]);
                        }
                        i9++;
                    }
                    int i12 = i5 + i4;
                    int i13 = i6 + i4;
                    int i14 = iArr[1];
                    if (i12 + i14 <= readLong3) {
                        if (BSUtil.readFromStream(gZIPInputStream2, bArr3, i12, i14)) {
                            i5 = i12 + iArr[1];
                            i6 = i13 + iArr[2];
                        } else {
                            throw new IOException("Corrupt by wrong patch file.");
                        }
                    } else {
                        throw new IOException("Corrupt by wrong patch file.");
                    }
                } else {
                    throw new IOException("Corrupt by wrong patch file.");
                }
            } else {
                throw new IOException("Corrupt by wrong patch file.");
            }
        }
        dataInputStream2.close();
        gZIPInputStream.close();
        gZIPInputStream2.close();
        return bArr3;
    }

    public static int patchLessMemory(RandomAccessFile randomAccessFile, int i, byte[] bArr, int i2, File file, int i3) throws IOException {
        if (randomAccessFile != null && i > 0) {
            if (file == null) {
                return 4;
            }
            if (bArr != null && i2 > 0) {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr, 0, i2));
                dataInputStream.skip(8L);
                long readLong = dataInputStream.readLong();
                long readLong2 = dataInputStream.readLong();
                int readLong3 = (int) dataInputStream.readLong();
                dataInputStream.close();
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i2);
                byteArrayInputStream.skip(32L);
                DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr, 0, i2);
                byteArrayInputStream2.skip(readLong + 32);
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
                ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr, 0, i2);
                byteArrayInputStream3.skip(readLong2 + readLong + 32);
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
                PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(file);
                try {
                    int[] iArr = new int[3];
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < readLong3) {
                        for (int i6 = 0; i6 <= 2; i6++) {
                            iArr[i6] = dataInputStream2.readInt();
                        }
                        int i7 = iArr[0];
                        if (i4 + i7 > readLong3) {
                            polarisFileOutputStreamWrapper.close();
                        } else {
                            byte[] bArr2 = new byte[i7];
                            if (!BSUtil.readFromStream(gZIPInputStream, bArr2, 0, i7)) {
                                polarisFileOutputStreamWrapper.close();
                            } else {
                                int i8 = iArr[0];
                                byte[] bArr3 = new byte[i8];
                                try {
                                    if (randomAccessFile.read(bArr3, 0, i8) < iArr[0]) {
                                        polarisFileOutputStreamWrapper.close();
                                    } else {
                                        for (int i9 = 0; i9 < iArr[0]; i9++) {
                                            int i10 = i5 + i9;
                                            if (i10 >= 0 && i10 < i) {
                                                bArr2[i9] = (byte) (bArr2[i9] + bArr3[i9]);
                                            }
                                        }
                                        polarisFileOutputStreamWrapper.write(bArr2);
                                        int i11 = iArr[0];
                                        int i12 = i4 + i11;
                                        int i13 = i5 + i11;
                                        int i14 = iArr[1];
                                        if (i12 + i14 > readLong3) {
                                            polarisFileOutputStreamWrapper.close();
                                        } else {
                                            byte[] bArr4 = new byte[i14];
                                            if (!BSUtil.readFromStream(gZIPInputStream2, bArr4, 0, i14)) {
                                                polarisFileOutputStreamWrapper.close();
                                                randomAccessFile.close();
                                                polarisFileOutputStreamWrapper.close();
                                                return 2;
                                            }
                                            polarisFileOutputStreamWrapper.write(bArr4);
                                            polarisFileOutputStreamWrapper.flush();
                                            i4 = i12 + iArr[1];
                                            i5 = i13 + iArr[2];
                                            randomAccessFile.seek(i5);
                                        }
                                    }
                                    randomAccessFile.close();
                                    polarisFileOutputStreamWrapper.close();
                                    return 2;
                                } catch (Throwable th) {
                                    th = th;
                                    randomAccessFile.close();
                                    polarisFileOutputStreamWrapper.close();
                                    throw th;
                                }
                            }
                        }
                        randomAccessFile.close();
                        polarisFileOutputStreamWrapper.close();
                        return 2;
                    }
                    dataInputStream2.close();
                    gZIPInputStream.close();
                    gZIPInputStream2.close();
                    randomAccessFile.close();
                    polarisFileOutputStreamWrapper.close();
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }
}
