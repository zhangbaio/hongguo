package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.IOException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class e {
    static {
        Covode.recordClassIndex(655477);
    }

    public abstract int a();

    public abstract e a(b bVar);

    public abstract void a(c cVar);

    public abstract int b();

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m378a() {
        int b = b();
        byte[] bArr = new byte[b];
        m377a(bArr, 0, b);
        return bArr;
    }

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    protected boolean a(b bVar, int i) {
        return bVar.m174a(i);
    }

    public e a(byte[] bArr, int i, int i2) {
        try {
            b a = b.a(bArr, i, i2);
            a(a);
            a.m172a(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m377a(byte[] bArr, int i, int i2) {
        try {
            c a = c.a(bArr, i, i2);
            a(a);
            a.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }
}
