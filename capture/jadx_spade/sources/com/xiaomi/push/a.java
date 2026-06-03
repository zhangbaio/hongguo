package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    public static final a a;

    /* renamed from: a, reason: collision with other field name */
    private volatile int f83a = 0;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f84a;

    public int a() {
        return this.f84a.length;
    }

    static {
        Covode.recordClassIndex(655326);
        a = new a(new byte[0]);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m131a() {
        byte[] bArr = this.f84a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public int hashCode() {
        int i = this.f83a;
        if (i == 0) {
            byte[] bArr = this.f84a;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            if (length == 0) {
                i = 1;
            } else {
                i = length;
            }
            this.f83a = i;
        }
        return i;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private a(byte[] bArr) {
        this.f84a = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f84a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f84a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static a a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }
}
