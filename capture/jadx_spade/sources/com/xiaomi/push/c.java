package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    private final int a;

    /* renamed from: a, reason: collision with other field name */
    private final OutputStream f176a;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f177a;
    private int b;

    static {
        Covode.recordClassIndex(655401);
    }

    public static int a(boolean z) {
        return 1;
    }

    public static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m203a(int i, long j) {
        c(i, 0);
        m208a(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m202a(int i, int i2) {
        c(i, 0);
        m201a(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m207a(int i, boolean z) {
        c(i, 0);
        m212a(z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m206a(int i, String str) {
        c(i, 2);
        m211a(str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m205a(int i, e eVar) {
        c(i, 2);
        m210a(eVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m204a(int i, com.xiaomi.push.a aVar) {
        c(i, 2);
        m209a(aVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m208a(long j) {
        m219c(j);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m201a(int i) {
        if (i >= 0) {
            m220d(i);
        } else {
            m219c(i);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m212a(boolean z) {
        m218c(z ? 1 : 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m211a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m220d(bytes.length);
        a(bytes);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m210a(e eVar) {
        m220d(eVar.a());
        eVar.a(this);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m209a(com.xiaomi.push.a aVar) {
        byte[] m131a = aVar.m131a();
        m220d(m131a.length);
        a(m131a);
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(e eVar) {
        int b = eVar.b();
        return d(b) + b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m200a() {
        if (this.f176a != null) {
            c();
        }
    }

    public int a() {
        if (this.f176a == null) {
            return this.a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void a(byte b) {
        if (this.b == this.a) {
            c();
        }
        byte[] bArr = this.f177a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    public void a(byte[] bArr) {
        m213a(bArr, 0, bArr.length);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m213a(byte[] bArr, int i, int i2) {
        int i3 = this.a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f177a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f177a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.a;
        c();
        if (i7 <= this.a) {
            System.arraycopy(bArr, i6, this.f177a, 0, i7);
            this.b = i7;
        } else {
            this.f176a.write(bArr, i6, i7);
        }
    }

    public static class a extends IOException {
        static {
            Covode.recordClassIndex(655402);
        }

        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private void c() {
        OutputStream outputStream = this.f176a;
        if (outputStream != null) {
            outputStream.write(this.f177a, 0, this.b);
            this.b = 0;
            return;
        }
        throw new a();
    }

    public void b() {
        if (a() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m214b(int i) {
        m220d(i);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int b(int i) {
        return d(i);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m218c(int i) {
        a((byte) i);
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    public static int b(long j) {
        return c(j);
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m220d(int i) {
        while ((i & (-128)) != 0) {
            m218c((i & 127) | 128);
            i >>>= 7;
        }
        m218c(i);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m219c(long j) {
        while (((-128) & j) != 0) {
            m218c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m218c((int) j);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m217b(long j) {
        m219c(j);
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f176a = outputStream;
        this.f177a = bArr;
        this.b = 0;
        this.a = bArr.length;
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public void c(int i, int i2) {
        m220d(f.a(i, i2));
    }

    public static int a(int i, com.xiaomi.push.a aVar) {
        return c(i) + a(aVar);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m215b(int i, int i2) {
        c(i, 0);
        m214b(i2);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m216b(int i, long j) {
        c(i, 0);
        m217b(j);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    private c(byte[] bArr, int i, int i2) {
        this.f176a = null;
        this.f177a = bArr;
        this.b = i;
        this.a = i + i2;
    }
}
