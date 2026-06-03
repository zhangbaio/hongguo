package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.ByteOutput;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class EncodedValueCodec {
    static {
        Covode.recordClassIndex(653609);
    }

    private EncodedValueCodec() {
    }

    public static int readSignedInt(ByteInput byteInput, int i) {
        int i2 = 0;
        for (int i3 = i; i3 >= 0; i3--) {
            i2 = (i2 >>> 8) | ((byteInput.readByte() & 255) << 24);
        }
        return i2 >> ((3 - i) * 8);
    }

    public static long readSignedLong(ByteInput byteInput, int i) {
        long j = 0;
        for (int i2 = i; i2 >= 0; i2--) {
            j = (j >>> 8) | ((byteInput.readByte() & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public static int readUnsignedInt(ByteInput byteInput, int i, boolean z) {
        int i2 = 0;
        if (!z) {
            for (int i3 = i; i3 >= 0; i3--) {
                i2 = (i2 >>> 8) | ((byteInput.readByte() & 255) << 24);
            }
            return i2 >>> ((3 - i) * 8);
        }
        while (i >= 0) {
            i2 = ((byteInput.readByte() & 255) << 24) | (i2 >>> 8);
            i--;
        }
        return i2;
    }

    public static long readUnsignedLong(ByteInput byteInput, int i, boolean z) {
        long j = 0;
        if (!z) {
            for (int i2 = i; i2 >= 0; i2--) {
                j = (j >>> 8) | ((byteInput.readByte() & 255) << 56);
            }
            return j >>> ((7 - i) * 8);
        }
        while (i >= 0) {
            j = (j >>> 8) | ((byteInput.readByte() & 255) << 56);
            i--;
        }
        return j;
    }

    public static void writeRightZeroExtendedValue(ByteOutput byteOutput, int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        int i2 = (numberOfTrailingZeros + 7) >> 3;
        long j2 = j >> (64 - (i2 * 8));
        byteOutput.writeByte(i | ((i2 - 1) << 5));
        while (i2 > 0) {
            byteOutput.writeByte((byte) j2);
            j2 >>= 8;
            i2--;
        }
    }

    public static void writeSignedIntegralValue(ByteOutput byteOutput, int i, long j) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j >> 63) ^ j)) + 7) >> 3;
        byteOutput.writeByte(i | ((numberOfLeadingZeros - 1) << 5));
        while (numberOfLeadingZeros > 0) {
            byteOutput.writeByte((byte) j);
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    public static void writeUnsignedIntegralValue(ByteOutput byteOutput, int i, long j) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        int i2 = (numberOfLeadingZeros + 7) >> 3;
        byteOutput.writeByte(i | ((i2 - 1) << 5));
        while (i2 > 0) {
            byteOutput.writeByte((byte) j);
            j >>= 8;
            i2--;
        }
    }
}
