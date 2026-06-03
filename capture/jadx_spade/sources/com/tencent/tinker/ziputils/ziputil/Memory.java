package com.tencent.tinker.ziputils.ziputil;

import com.bytedance.covode.number.Covode;
import java.nio.ByteOrder;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Memory {
    static {
        Covode.recordClassIndex(653974);
    }

    private Memory() {
    }

    public static short peekShort(byte[] bArr, int i, ByteOrder byteOrder) {
        int i2;
        byte b;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i2 = bArr[i] << 8;
            b = bArr[i + 1];
        } else {
            i2 = bArr[i + 1] << 8;
            b = bArr[i];
        }
        return (short) ((b & 255) | i2);
    }

    public static int peekInt(byte[] bArr, int i, ByteOrder byteOrder) {
        int i2;
        int i3;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i4 = i + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i] & 255) << 24) | ((bArr[i4] & 255) << 16);
            i2 = i6 | ((bArr[i5] & 255) << 8);
            i3 = (bArr[i5 + 1] & 255) << 0;
        } else {
            int i7 = i + 1;
            int i8 = i7 + 1;
            int i9 = ((bArr[i] & 255) << 0) | ((bArr[i7] & 255) << 8);
            i2 = i9 | ((bArr[i8] & 255) << 16);
            i3 = (bArr[i8 + 1] & 255) << 24;
        }
        return i3 | i2;
    }

    public static long peekLong(byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << 16);
            int i5 = i3 + 1;
            int i6 = i4 | ((bArr[i3] & 255) << 8);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 0);
            int i9 = i7 + 1;
            int i10 = i9 + 1;
            int i11 = ((bArr[i9] & 255) << 16) | ((bArr[i7] & 255) << 24);
            int i12 = i10 + 1;
            return (i8 << 32) | ((((bArr[i12] & 255) << 0) | i11 | ((bArr[i10] & 255) << 8)) & 4294967295L);
        }
        int i13 = i + 1;
        int i14 = i13 + 1;
        int i15 = ((bArr[i] & 255) << 0) | ((bArr[i13] & 255) << 8);
        int i16 = i14 + 1;
        int i17 = i15 | ((bArr[i14] & 255) << 16);
        int i18 = i16 + 1;
        int i19 = i17 | ((bArr[i16] & 255) << 24);
        int i20 = i18 + 1;
        int i21 = i20 + 1;
        int i22 = ((bArr[i20] & 255) << 8) | ((bArr[i18] & 255) << 0) | ((bArr[i21] & 255) << 16);
        return (i19 & 4294967295L) | ((((bArr[i21 + 1] & 255) << 24) | i22) << 32);
    }

    public static void pokeShort(byte[] bArr, int i, short s, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            bArr[i] = (byte) ((s >> 8) & 255);
            bArr[i + 1] = (byte) ((s >> 0) & 255);
        } else {
            bArr[i] = (byte) ((s >> 0) & 255);
            bArr[i + 1] = (byte) ((s >> 8) & 255);
        }
    }

    public static void pokeInt(byte[] bArr, int i, int i2, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i3 = i + 1;
            bArr[i] = (byte) ((i2 >> 24) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >> 16) & 255);
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            bArr[i4 + 1] = (byte) ((i2 >> 0) & 255);
            return;
        }
        int i5 = i + 1;
        bArr[i] = (byte) ((i2 >> 0) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >> 8) & 255);
        bArr[i6] = (byte) ((i2 >> 16) & 255);
        bArr[i6 + 1] = (byte) ((i2 >> 24) & 255);
    }

    public static void pokeLong(byte[] bArr, int i, long j, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            int i2 = (int) (j >> 32);
            int i3 = i + 1;
            bArr[i] = (byte) ((i2 >> 24) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >> 16) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i2 >> 0) & 255);
            int i7 = (int) j;
            int i8 = i6 + 1;
            bArr[i6] = (byte) ((i7 >> 24) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((i7 >> 16) & 255);
            bArr[i9] = (byte) ((i7 >> 8) & 255);
            bArr[i9 + 1] = (byte) ((i7 >> 0) & 255);
            return;
        }
        int i10 = (int) j;
        int i11 = i + 1;
        bArr[i] = (byte) ((i10 >> 0) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >> 8) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >> 24) & 255);
        int i15 = (int) (j >> 32);
        int i16 = i14 + 1;
        bArr[i14] = (byte) ((i15 >> 0) & 255);
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((i15 >> 8) & 255);
        bArr[i17] = (byte) ((i15 >> 16) & 255);
        bArr[i17 + 1] = (byte) ((i15 >> 24) & 255);
    }
}
