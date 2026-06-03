package com.tencent.open.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n implements Cloneable {
    private long a;

    static {
        Covode.recordClassIndex(653568);
    }

    public int hashCode() {
        return (int) this.a;
    }

    public long b() {
        return this.a;
    }

    public byte[] a() {
        long j = this.a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public n(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n) || this.a != ((n) obj).b()) {
            return false;
        }
        return true;
    }
}
