package com.tencent.tinker.android.dx.instruction;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ShortArrayCodeOutput extends CodeCursor {
    private short[] array;

    static {
        Covode.recordClassIndex(653641);
    }

    public short[] getArray() {
        int cursor = cursor();
        short[] sArr = this.array;
        if (cursor == sArr.length) {
            return sArr;
        }
        short[] sArr2 = new short[cursor];
        System.arraycopy(sArr, 0, sArr2, 0, cursor);
        return sArr2;
    }

    public ShortArrayCodeOutput(short[] sArr) {
        if (sArr != null) {
            this.array = sArr;
            return;
        }
        throw new IllegalArgumentException("array is null.");
    }

    public void write(short s) {
        ensureArrayLength(1);
        this.array[cursor()] = s;
        advance(1);
    }

    public void writeInt(int i) {
        write((short) i);
        write((short) (i >> 16));
    }

    public ShortArrayCodeOutput(int i) {
        if (i >= 0) {
            this.array = new short[i];
            return;
        }
        throw new IllegalArgumentException("initSize < 0");
    }

    private void ensureArrayLength(int i) {
        int cursor = cursor();
        short[] sArr = this.array;
        if (sArr.length - cursor < i) {
            short[] sArr2 = new short[sArr.length + (sArr.length >> 1)];
            System.arraycopy(sArr, 0, sArr2, 0, cursor);
            this.array = sArr2;
        }
    }

    public void writeLong(long j) {
        write((short) j);
        write((short) (j >> 16));
        write((short) (j >> 32));
        write((short) (j >> 48));
    }

    public void write(byte[] bArr) {
        boolean z = true;
        int i = 0;
        for (byte b : bArr) {
            if (z) {
                i = b & 255;
                z = false;
            } else {
                int i2 = (b << 8) | i;
                write((short) i2);
                i = i2;
                z = true;
            }
        }
        if (!z) {
            write((short) i);
        }
    }

    public void write(int[] iArr) {
        for (int i : iArr) {
            writeInt(i);
        }
    }

    public void write(long[] jArr) {
        for (long j : jArr) {
            writeLong(j);
        }
    }

    public void write(short[] sArr) {
        for (short s : sArr) {
            write(s);
        }
    }

    public void write(short s, short s2) {
        write(s);
        write(s2);
    }

    public void write(short s, short s2, short s3) {
        write(s);
        write(s2);
        write(s3);
    }

    public void write(short s, short s2, short s3, short s4) {
        write(s);
        write(s2);
        write(s3);
        write(s4);
    }

    public void write(short s, short s2, short s3, short s4, short s5) {
        write(s);
        write(s2);
        write(s3);
        write(s4);
        write(s5);
    }
}
