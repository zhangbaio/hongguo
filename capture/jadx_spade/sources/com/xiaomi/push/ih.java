package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ih extends ij {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private hr f838a;

    static {
        Covode.recordClassIndex(655614);
    }

    public int a() {
        return this.f838a.size();
    }

    public ih(int i) {
        this.f838a = new hr(i);
    }

    @Override // com.xiaomi.push.ij
    /* renamed from: a */
    public void mo626a(byte[] bArr, int i, int i2) {
        this.f838a.write(bArr, i, i2);
    }

    @Override // com.xiaomi.push.ij
    public int a(byte[] bArr, int i, int i2) {
        byte[] m603a = this.f838a.m603a();
        if (i2 > this.f838a.a() - this.a) {
            i2 = this.f838a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m603a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }
}
