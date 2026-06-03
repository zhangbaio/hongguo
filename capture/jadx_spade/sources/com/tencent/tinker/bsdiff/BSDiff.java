package com.tencent.tinker.bsdiff;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BSDiff {
    private static final byte[] MAGIC_BYTES;

    static {
        Covode.recordClassIndex(653647);
        MAGIC_BYTES = new byte[]{77, 105, 99, 114, 111, 77, 115, 103};
    }

    private static class IntByRef {
        private int value;

        static {
            Covode.recordClassIndex(653649);
        }

        private IntByRef() {
        }
    }

    public static void main(String[] strArr) throws IOException {
        bsdiff(new PolarisFileWrapper("/Users/tomystang/bsdiff-test/old/classes.dex"), new PolarisFileWrapper("/Users/tomystang/bsdiff-test/new/classes.dex"), new PolarisFileWrapper("/Users/tomystang/bsdiff-test/test_bsdiff.diff"));
    }

    public static void bsdiff(File file, File file2, File file3) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new PolarisFileInputStreamWrapper(file));
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new PolarisFileInputStreamWrapper(file2));
        PolarisFileOutputStreamWrapper polarisFileOutputStreamWrapper = new PolarisFileOutputStreamWrapper(file3);
        try {
            polarisFileOutputStreamWrapper.write(bsdiff(bufferedInputStream, (int) file.length(), bufferedInputStream2, (int) file2.length()));
        } finally {
            polarisFileOutputStreamWrapper.close();
        }
    }

    /* renamed from: com.tencent.tinker.bsdiff.BSDiff$1EmuStackFrame, reason: invalid class name */
    class C1EmuStackFrame {
        int h;
        int len;
        int start;
        int stmRetLabel;
        int i = 0;
        int j = 0;
        int k = 0;
        int x = 0;
        int jj = 0;
        int kk = 0;

        static {
            Covode.recordClassIndex(653648);
        }

        C1EmuStackFrame(int i, int i2, int i3, int i4) {
            this.stmRetLabel = i;
            this.start = i2;
            this.len = i3;
            this.h = i4;
        }
    }

    public static byte[] bsdiff(InputStream inputStream, int i, InputStream inputStream2, int i2) throws IOException {
        byte[] bArr = new byte[i];
        BSUtil.readFromStream(inputStream, bArr, 0, i);
        inputStream.close();
        byte[] bArr2 = new byte[i2];
        BSUtil.readFromStream(inputStream2, bArr2, 0, i2);
        inputStream2.close();
        return bsdiff(bArr, i, bArr2, i2);
    }

    private static void qsufsort(int[] iArr, int[] iArr2, byte[] bArr, int i) {
        int i2;
        int i3;
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = 255 & bArr[i4];
            iArr3[i5] = iArr3[i5] + 1;
        }
        for (int i6 = 1; i6 < 256; i6++) {
            iArr3[i6] = iArr3[i6] + iArr3[i6 - 1];
        }
        for (int i7 = 255; i7 > 0; i7--) {
            iArr3[i7] = iArr3[i7 - 1];
        }
        iArr3[0] = 0;
        for (int i8 = 0; i8 < i; i8++) {
            int i9 = bArr[i8] & 255;
            int i10 = iArr3[i9] + 1;
            iArr3[i9] = i10;
            iArr[i10] = i8;
        }
        iArr[0] = i;
        for (int i11 = 0; i11 < i; i11++) {
            iArr2[i11] = iArr3[bArr[i11] & 255];
        }
        iArr2[i] = 0;
        for (int i12 = 1; i12 < 256; i12++) {
            int i13 = iArr3[i12];
            if (i13 == iArr3[i12 - 1] + 1) {
                iArr[i13] = -1;
            }
        }
        iArr[0] = -1;
        int i14 = 1;
        while (true) {
            i2 = i + 1;
            if (iArr[0] == (-i2)) {
                break;
            }
            int i15 = 0;
            while (true) {
                i3 = 0;
                while (i15 < i2) {
                    int i16 = iArr[i15];
                    if (i16 < 0) {
                        i3 -= i16;
                        i15 -= i16;
                    } else {
                        if (i3 != 0) {
                            iArr[i15 - i3] = -i3;
                        }
                        int i17 = (iArr2[iArr[i15]] + 1) - i15;
                        split(iArr, iArr2, i15, i17, i14);
                        i15 += i17;
                    }
                }
                break;
            }
            if (i3 != 0) {
                iArr[i15 - i3] = -i3;
            }
            i14 += i14;
        }
        for (int i18 = 0; i18 < i2; i18++) {
            iArr[iArr2[i18]] = i18;
        }
    }

    public static byte[] bsdiff(byte[] bArr, int i, byte[] bArr2, int i2) throws IOException {
        int i3;
        IntByRef intByRef;
        DataOutputStream dataOutputStream;
        GZIPOutputStream gZIPOutputStream;
        long j;
        DataOutputStream dataOutputStream2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = i;
        int i13 = i12 + 1;
        int[] iArr = new int[i13];
        qsufsort(iArr, new int[i13], bArr, i12);
        byte[] bArr3 = new byte[i2];
        byte[] bArr4 = new byte[i2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream3 = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream3.write(MAGIC_BYTES);
        dataOutputStream3.writeLong(-1L);
        dataOutputStream3.writeLong(-1L);
        long j2 = i2;
        dataOutputStream3.writeLong(j2);
        dataOutputStream3.flush();
        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(dataOutputStream3);
        DataOutputStream dataOutputStream4 = new DataOutputStream(gZIPOutputStream2);
        IntByRef intByRef2 = new IntByRef();
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i14 < i2) {
            int i21 = i14 + i17;
            int i22 = i17;
            int i23 = 0;
            int i24 = i21;
            while (true) {
                if (i21 < i2) {
                    int i25 = i21;
                    i3 = i15;
                    intByRef = intByRef2;
                    dataOutputStream = dataOutputStream4;
                    gZIPOutputStream = gZIPOutputStream2;
                    j = j2;
                    dataOutputStream2 = dataOutputStream3;
                    i5 = search(iArr, bArr, i, bArr2, i2, i25, 0, i, intByRef);
                    int i26 = i24;
                    i6 = i23;
                    i4 = i25;
                    while (i26 < i4 + i5) {
                        int i27 = i26 + i18;
                        if (i27 < i12 && bArr[i27] == bArr2[i26]) {
                            i6++;
                        }
                        i26++;
                    }
                    if ((i5 == i6 && i5 != 0) || i5 > i6 + 8) {
                        break;
                    }
                    int i28 = i4 + i18;
                    if (i28 < i12 && bArr[i28] == bArr2[i4]) {
                        i6--;
                    }
                    i23 = i6;
                    i22 = i5;
                    i24 = i26;
                    i21 = i4 + 1;
                    i15 = i3;
                    intByRef2 = intByRef;
                    dataOutputStream4 = dataOutputStream;
                    gZIPOutputStream2 = gZIPOutputStream;
                    j2 = j;
                    dataOutputStream3 = dataOutputStream2;
                } else {
                    i3 = i15;
                    intByRef = intByRef2;
                    dataOutputStream = dataOutputStream4;
                    gZIPOutputStream = gZIPOutputStream2;
                    j = j2;
                    dataOutputStream2 = dataOutputStream3;
                    i4 = i21;
                    i5 = i22;
                    i6 = i23;
                    break;
                }
            }
            if (i5 == i6 && i4 != i2) {
                i17 = i5;
                i14 = i4;
                i15 = i3;
                intByRef2 = intByRef;
                dataOutputStream4 = dataOutputStream;
                gZIPOutputStream2 = gZIPOutputStream;
                j2 = j;
                dataOutputStream3 = dataOutputStream2;
            } else {
                int i29 = 0;
                int i30 = 0;
                int i31 = 0;
                int i32 = 0;
                while (true) {
                    int i33 = i20 + i30;
                    if (i33 >= i4 || (i11 = i19 + i30) >= i12) {
                        break;
                    }
                    if (bArr[i11] == bArr2[i33]) {
                        i29++;
                    }
                    i30++;
                    if ((i29 * 2) - i30 > (i31 * 2) - i32) {
                        i31 = i29;
                        i32 = i30;
                    }
                }
                if (i4 < i2) {
                    i7 = 0;
                    int i34 = 0;
                    int i35 = 0;
                    for (int i36 = 1; i4 >= i20 + i36 && intByRef.value >= i36; i36++) {
                        if (bArr[intByRef.value - i36] == bArr2[i4 - i36]) {
                            i34++;
                        }
                        if ((i34 * 2) - i36 > (i35 * 2) - i7) {
                            i7 = i36;
                            i35 = i34;
                        }
                    }
                } else {
                    i7 = 0;
                }
                int i37 = i20 + i32;
                int i38 = i4 - i7;
                if (i37 > i38) {
                    int i39 = i37 - i38;
                    i8 = i5;
                    int i40 = 0;
                    int i41 = 0;
                    int i42 = 0;
                    int i43 = 0;
                    while (i41 < i39) {
                        int i44 = i37;
                        if (bArr2[(i37 - i39) + i41] == bArr[((i19 + i32) - i39) + i41]) {
                            i43++;
                        }
                        if (bArr2[i38 + i41] == bArr[(intByRef.value - i7) + i41]) {
                            i43--;
                        }
                        int i45 = i43;
                        if (i45 > i40) {
                            i42 = i41 + 1;
                            i40 = i45;
                        }
                        i41++;
                        i43 = i45;
                        i37 = i44;
                    }
                    i32 += i42 - i39;
                    i7 -= i42;
                } else {
                    i8 = i5;
                }
                for (int i46 = 0; i46 < i32; i46++) {
                    bArr3[i3 + i46] = (byte) (bArr2[i20 + i46] - bArr[i19 + i46]);
                }
                int i47 = i3;
                int i48 = 0;
                while (true) {
                    i9 = i4 - i7;
                    int i49 = i20 + i32;
                    i10 = i9 - i49;
                    if (i48 >= i10) {
                        break;
                    }
                    int i50 = i16;
                    bArr4[i50 + i48] = bArr2[i49 + i48];
                    i48++;
                    i16 = i50;
                }
                i15 = i47 + i32;
                i16 += i10;
                DataOutputStream dataOutputStream5 = dataOutputStream;
                dataOutputStream5.writeInt(i32);
                dataOutputStream5.writeInt(i10);
                dataOutputStream5.writeInt((intByRef.value - i7) - (i19 + i32));
                i19 = intByRef.value - i7;
                i12 = i;
                i20 = i9;
                i17 = i8;
                gZIPOutputStream2 = gZIPOutputStream;
                j2 = j;
                dataOutputStream3 = dataOutputStream2;
                dataOutputStream4 = dataOutputStream5;
                i18 = intByRef.value - i4;
                i14 = i4;
                intByRef2 = intByRef;
            }
        }
        DataOutputStream dataOutputStream6 = dataOutputStream3;
        dataOutputStream4.flush();
        gZIPOutputStream2.finish();
        int size = dataOutputStream6.size() - 32;
        GZIPOutputStream gZIPOutputStream3 = new GZIPOutputStream(dataOutputStream6);
        gZIPOutputStream3.write(bArr3, 0, i15);
        gZIPOutputStream3.finish();
        gZIPOutputStream3.flush();
        int size2 = (dataOutputStream6.size() - size) - 32;
        GZIPOutputStream gZIPOutputStream4 = new GZIPOutputStream(dataOutputStream6);
        gZIPOutputStream4.write(bArr4, 0, i16);
        gZIPOutputStream4.finish();
        gZIPOutputStream4.flush();
        dataOutputStream6.close();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(32);
        DataOutputStream dataOutputStream7 = new DataOutputStream(byteArrayOutputStream2);
        dataOutputStream7.write(MAGIC_BYTES);
        dataOutputStream7.writeLong(size);
        dataOutputStream7.writeLong(size2);
        dataOutputStream7.writeLong(j2);
        dataOutputStream7.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
        System.arraycopy(byteArray2, 0, byteArray, 0, byteArray2.length);
        return byteArray;
    }

    private static void split(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Stack stack = new Stack();
        stack.push(new C1EmuStackFrame(2, i, i2, i3));
        while (true) {
            int i9 = 0;
            while (!stack.empty()) {
                C1EmuStackFrame c1EmuStackFrame = (C1EmuStackFrame) stack.peek();
                if (i9 != 0) {
                    if (i9 != 1) {
                        i9 = c1EmuStackFrame.stmRetLabel;
                        stack.pop();
                    } else {
                        c1EmuStackFrame.i = 0;
                        while (true) {
                            int i10 = c1EmuStackFrame.i;
                            i4 = c1EmuStackFrame.kk;
                            i5 = c1EmuStackFrame.jj;
                            if (i10 >= i4 - i5) {
                                break;
                            }
                            iArr2[iArr[i5 + i10]] = i4 - 1;
                            c1EmuStackFrame.i = i10 + 1;
                        }
                        if (i5 == i4 - 1) {
                            iArr[i5] = -1;
                        }
                        if (c1EmuStackFrame.start + c1EmuStackFrame.len > i4) {
                            int i11 = c1EmuStackFrame.kk;
                            stack.push(new C1EmuStackFrame(2, i11, (c1EmuStackFrame.start + c1EmuStackFrame.len) - i11, c1EmuStackFrame.h));
                        }
                        i9 = 2;
                    }
                } else {
                    int i12 = c1EmuStackFrame.len;
                    if (i12 < 16) {
                        int i13 = c1EmuStackFrame.start;
                        while (true) {
                            c1EmuStackFrame.k = i13;
                            int i14 = c1EmuStackFrame.k;
                            if (i14 >= c1EmuStackFrame.start + c1EmuStackFrame.len) {
                                break;
                            }
                            c1EmuStackFrame.j = 1;
                            c1EmuStackFrame.x = iArr2[iArr[i14] + c1EmuStackFrame.h];
                            c1EmuStackFrame.i = 1;
                            while (true) {
                                int i15 = c1EmuStackFrame.k;
                                int i16 = c1EmuStackFrame.i;
                                if (i15 + i16 >= c1EmuStackFrame.start + c1EmuStackFrame.len) {
                                    break;
                                }
                                int i17 = iArr[i15 + i16];
                                int i18 = c1EmuStackFrame.h;
                                if (iArr2[i17 + i18] < c1EmuStackFrame.x) {
                                    c1EmuStackFrame.x = iArr2[iArr[i15 + i16] + i18];
                                    c1EmuStackFrame.j = 0;
                                }
                                if (iArr2[iArr[i15 + i16] + i18] == c1EmuStackFrame.x) {
                                    int i19 = c1EmuStackFrame.j;
                                    int i20 = iArr[i15 + i19];
                                    iArr[i15 + i19] = iArr[i15 + i16];
                                    iArr[i15 + i16] = i20;
                                    c1EmuStackFrame.j = i19 + 1;
                                }
                                c1EmuStackFrame.i = i16 + 1;
                            }
                            c1EmuStackFrame.i = 0;
                            while (true) {
                                int i21 = c1EmuStackFrame.i;
                                i6 = c1EmuStackFrame.j;
                                if (i21 >= i6) {
                                    break;
                                }
                                int i22 = c1EmuStackFrame.k;
                                iArr2[iArr[i22 + i21]] = (i22 + i6) - 1;
                                c1EmuStackFrame.i = i21 + 1;
                            }
                            if (i6 == 1) {
                                iArr[c1EmuStackFrame.k] = -1;
                            }
                            i13 = c1EmuStackFrame.k + i6;
                        }
                        i9 = 2;
                    } else {
                        int i23 = c1EmuStackFrame.start;
                        c1EmuStackFrame.x = iArr2[iArr[(i12 / 2) + i23] + c1EmuStackFrame.h];
                        c1EmuStackFrame.jj = 0;
                        c1EmuStackFrame.kk = 0;
                        c1EmuStackFrame.i = i23;
                        while (true) {
                            int i24 = c1EmuStackFrame.i;
                            i7 = c1EmuStackFrame.start;
                            if (i24 >= c1EmuStackFrame.len + i7) {
                                break;
                            }
                            int i25 = iArr[i24];
                            int i26 = c1EmuStackFrame.h;
                            int i27 = iArr2[i25 + i26];
                            int i28 = c1EmuStackFrame.x;
                            if (i27 < i28) {
                                c1EmuStackFrame.jj++;
                            }
                            if (iArr2[i25 + i26] == i28) {
                                c1EmuStackFrame.kk++;
                            }
                            c1EmuStackFrame.i = i24 + 1;
                        }
                        int i29 = c1EmuStackFrame.jj + i7;
                        c1EmuStackFrame.jj = i29;
                        c1EmuStackFrame.kk += i29;
                        c1EmuStackFrame.i = i7;
                        c1EmuStackFrame.j = 0;
                        c1EmuStackFrame.k = 0;
                        while (true) {
                            int i30 = c1EmuStackFrame.i;
                            int i31 = c1EmuStackFrame.jj;
                            if (i30 >= i31) {
                                break;
                            }
                            int i32 = iArr[i30];
                            int i33 = c1EmuStackFrame.h;
                            int i34 = iArr2[i32 + i33];
                            int i35 = c1EmuStackFrame.x;
                            if (i34 < i35) {
                                c1EmuStackFrame.i = i30 + 1;
                            } else if (iArr2[i33 + i32] == i35) {
                                int i36 = c1EmuStackFrame.j;
                                iArr[i30] = iArr[i31 + i36];
                                iArr[i31 + i36] = i32;
                                c1EmuStackFrame.j = i36 + 1;
                            } else {
                                int i37 = c1EmuStackFrame.kk;
                                int i38 = c1EmuStackFrame.k;
                                iArr[i30] = iArr[i37 + i38];
                                iArr[i37 + i38] = i32;
                                c1EmuStackFrame.k = i38 + 1;
                            }
                        }
                        while (true) {
                            i8 = c1EmuStackFrame.jj;
                            int i39 = c1EmuStackFrame.j;
                            int i40 = i8 + i39;
                            int i41 = c1EmuStackFrame.kk;
                            if (i40 >= i41) {
                                break;
                            }
                            if (iArr2[iArr[i8 + i39] + c1EmuStackFrame.h] == c1EmuStackFrame.x) {
                                c1EmuStackFrame.j = i39 + 1;
                            } else {
                                int i42 = iArr[i8 + i39];
                                int i43 = i8 + i39;
                                int i44 = c1EmuStackFrame.k;
                                iArr[i43] = iArr[i41 + i44];
                                iArr[i41 + i44] = i42;
                                c1EmuStackFrame.k = i44 + 1;
                            }
                        }
                        if (i8 > c1EmuStackFrame.start) {
                            int i45 = c1EmuStackFrame.start;
                            stack.push(new C1EmuStackFrame(1, i45, c1EmuStackFrame.jj - i45, c1EmuStackFrame.h));
                        } else {
                            i9 = 1;
                        }
                    }
                }
            }
            return;
        }
    }

    private static int matchlen(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int min = Math.min(i - i2, i3 - i4);
        for (int i5 = 0; i5 < min; i5++) {
            if (bArr[i2 + i5] != bArr2[i4 + i5]) {
                return i5;
            }
        }
        return min;
    }

    private static int memcmp(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i - i2;
        int i6 = i3 - i4;
        if (i5 > i6) {
            i5 = i6;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            byte b = bArr[i7 + i2];
            byte b2 = bArr2[i7 + i4];
            if (b != b2) {
                if (b < b2) {
                    return -1;
                }
                return 1;
            }
        }
        return 0;
    }

    private static int search(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, IntByRef intByRef) {
        int i6 = i5 - i4;
        if (i6 < 2) {
            int matchlen = matchlen(bArr, i, iArr[i4], bArr2, i2, i3);
            int matchlen2 = matchlen(bArr, i, iArr[i5], bArr2, i2, i3);
            if (matchlen > matchlen2) {
                intByRef.value = iArr[i4];
                return matchlen;
            }
            intByRef.value = iArr[i5];
            return matchlen2;
        }
        int i7 = i4 + (i6 / 2);
        if (memcmp(bArr, i, iArr[i7], bArr2, i2, i3) < 0) {
            return search(iArr, bArr, i, bArr2, i2, i3, i7, i5, intByRef);
        }
        return search(iArr, bArr, i, bArr2, i2, i3, i4, i7, intByRef);
    }
}
