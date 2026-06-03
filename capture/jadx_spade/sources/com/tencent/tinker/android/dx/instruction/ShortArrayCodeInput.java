package com.tencent.tinker.android.dx.instruction;

import com.bytedance.covode.number.Covode;
import java.io.EOFException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ShortArrayCodeInput extends CodeCursor {
    private final short[] array;

    static {
        Covode.recordClassIndex(653640);
    }

    public boolean hasMore() {
        if (cursor() < this.array.length) {
            return true;
        }
        return false;
    }

    public int readInt() throws EOFException {
        return read() | (read() << 16);
    }

    public int read() throws EOFException {
        try {
            short s = this.array[cursor()];
            advance(1);
            return s & 65535;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new EOFException();
        }
    }

    public long readLong() throws EOFException {
        return read() | (read() << 16) | (read() << 32) | (read() << 48);
    }

    public ShortArrayCodeInput(short[] sArr) {
        if (sArr != null) {
            this.array = sArr;
            return;
        }
        throw new NullPointerException("array == null");
    }
}
