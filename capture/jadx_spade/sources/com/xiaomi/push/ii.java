package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ii extends ij {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f839a;
    private int b;

    static {
        Covode.recordClassIndex(655615);
    }

    @Override // com.xiaomi.push.ij
    public byte[] a() {
        return this.f839a;
    }

    @Override // com.xiaomi.push.ij
    public int a_() {
        return this.a;
    }

    @Override // com.xiaomi.push.ij
    public int b() {
        return this.b - this.a;
    }

    @Override // com.xiaomi.push.ij
    public void a(int i) {
        this.a += i;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public void b(byte[] bArr, int i, int i2) {
        this.f839a = bArr;
        this.a = i;
        this.b = i + i2;
    }

    @Override // com.xiaomi.push.ij
    public int a(byte[] bArr, int i, int i2) {
        int b = b();
        if (i2 > b) {
            i2 = b;
        }
        if (i2 > 0) {
            System.arraycopy(this.f839a, this.a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.ij
    /* renamed from: a */
    public void mo626a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }
}
