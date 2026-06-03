package com.tencent.open.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o implements Cloneable {
    private int a;

    static {
        Covode.recordClassIndex(653569);
    }

    public int b() {
        return this.a;
    }

    public int hashCode() {
        return this.a;
    }

    public byte[] a() {
        int i = this.a;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public o(int i) {
        this.a = i;
    }

    public o(byte[] bArr) {
        this(bArr, 0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof o) || this.a != ((o) obj).b()) {
            return false;
        }
        return true;
    }

    public o(byte[] bArr, int i) {
        this.a = ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255);
    }
}
