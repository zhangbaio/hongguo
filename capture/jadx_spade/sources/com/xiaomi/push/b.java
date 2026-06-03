package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.InputStream;
import java.util.Vector;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private final InputStream f138a;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f139a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    static {
        Covode.recordClassIndex(655368);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m172a(int i) {
        if (this.d != i) {
            throw d.e();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m174a(int i) {
        int a = f.a(i);
        if (a == 0) {
            m176b();
            return true;
        }
        if (a == 1) {
            m180d();
            return true;
        }
        if (a == 2) {
            c(d());
            return true;
        }
        if (a == 3) {
            m171a();
            m172a(f.a(f.b(i), 4));
            return true;
        }
        if (a == 4) {
            return false;
        }
        if (a == 5) {
            e();
            return true;
        }
        throw d.f();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m171a() {
        int m167a;
        do {
            m167a = m167a();
            if (m167a == 0) {
                return;
            }
        } while (m174a(m167a));
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m173a() {
        return d() != 0;
    }

    public void a(e eVar) {
        int d = d();
        if (this.g >= this.h) {
            throw d.g();
        }
        int a = a(d);
        this.g++;
        eVar.a(this);
        m172a(0);
        this.g--;
        b(a);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m175a(int i) {
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.e;
        int i3 = this.c;
        int i4 = i2 + i3 + i;
        int i5 = this.f;
        if (i4 > i5) {
            c((i5 - i2) - i3);
            throw d.a();
        }
        int i6 = this.a;
        if (i <= i6 - i3) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f139a, i3, bArr, 0, i);
            this.c += i;
            return bArr;
        }
        if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i7 = i6 - i3;
            System.arraycopy(this.f139a, i3, bArr2, 0, i7);
            this.c = this.a;
            a(true);
            while (true) {
                int i8 = i - i7;
                int i9 = this.a;
                if (i8 > i9) {
                    System.arraycopy(this.f139a, 0, bArr2, i7, i9);
                    int i10 = this.a;
                    i7 += i10;
                    this.c = i10;
                    a(true);
                } else {
                    System.arraycopy(this.f139a, 0, bArr2, i7, i8);
                    this.c = i8;
                    return bArr2;
                }
            }
        } else {
            this.e = i2 + i6;
            this.c = 0;
            this.a = 0;
            int i11 = i6 - i3;
            int i12 = i - i11;
            Vector vector = new Vector();
            while (i12 > 0) {
                int min = Math.min(i12, 4096);
                byte[] bArr3 = new byte[min];
                int i13 = 0;
                while (i13 < min) {
                    InputStream inputStream = this.f138a;
                    int read = inputStream == null ? -1 : inputStream.read(bArr3, i13, min - i13);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.e += read;
                    i13 += read;
                }
                i12 -= min;
                vector.addElement(bArr3);
            }
            byte[] bArr4 = new byte[i];
            System.arraycopy(this.f139a, i3, bArr4, 0, i11);
            for (int i14 = 0; i14 < vector.size(); i14++) {
                byte[] bArr5 = (byte[]) vector.elementAt(i14);
                System.arraycopy(bArr5, 0, bArr4, i11, bArr5.length);
                i11 += bArr5.length;
            }
            return bArr4;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public int m176b() {
        return d();
    }

    public int c() {
        return d();
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m177b() {
        return m179c();
    }

    private void b() {
        int i = this.a + this.b;
        this.a = i;
        int i2 = this.e + i;
        int i3 = this.f;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.b = i4;
            this.a = i - i4;
            return;
        }
        this.b = 0;
    }

    public byte a() {
        if (this.c == this.a) {
            a(true);
        }
        byte[] bArr = this.f139a;
        int i = this.c;
        this.c = i + 1;
        return bArr[i];
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m179c() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((a() & 128) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m167a() {
        if (m178b()) {
            this.d = 0;
            return 0;
        }
        int d = d();
        this.d = d;
        if (d != 0) {
            return d;
        }
        throw d.d();
    }

    public int e() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m178b() {
        if (this.c != this.a || a(false)) {
            return false;
        }
        return true;
    }

    public int d() {
        int i;
        byte a = a();
        if (a >= 0) {
            return a;
        }
        int i2 = a & Byte.MAX_VALUE;
        byte a2 = a();
        if (a2 >= 0) {
            i = a2 << 7;
        } else {
            i2 |= (a2 & Byte.MAX_VALUE) << 7;
            byte a3 = a();
            if (a3 >= 0) {
                i = a3 << 14;
            } else {
                i2 |= (a3 & Byte.MAX_VALUE) << 14;
                byte a4 = a();
                if (a4 >= 0) {
                    i = a4 << 21;
                } else {
                    int i3 = i2 | ((a4 & Byte.MAX_VALUE) << 21);
                    byte a5 = a();
                    int i4 = i3 | (a5 << 28);
                    if (a5 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            if (a() >= 0) {
                                return i4;
                            }
                        }
                        throw d.c();
                    }
                    return i4;
                }
            }
        }
        return i2 | i;
    }

    /* renamed from: d, reason: collision with other method in class */
    public long m180d() {
        return ((a() & 255) << 8) | (a() & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m168a() {
        return m179c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m169a() {
        int d = d();
        int i = this.a;
        int i2 = this.c;
        if (d <= i - i2 && d > 0) {
            a a = a.a(this.f139a, i2, d);
            this.c += d;
            return a;
        }
        return a.a(m175a(d));
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m170a() {
        int d = d();
        int i = this.a;
        int i2 = this.c;
        if (d <= i - i2 && d > 0) {
            String str = new String(this.f139a, i2, d, "UTF-8");
            this.c += d;
            return str;
        }
        return new String(m175a(d), "UTF-8");
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    private b(InputStream inputStream) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = 67108864;
        this.f139a = new byte[4096];
        this.a = 0;
        this.c = 0;
        this.f138a = inputStream;
    }

    public void b(int i) {
        this.f = i;
        b();
    }

    private boolean a(boolean z) {
        int read;
        int i = this.c;
        int i2 = this.a;
        if (i >= i2) {
            int i3 = this.e;
            if (i3 + i2 == this.f) {
                if (!z) {
                    return false;
                }
                throw d.a();
            }
            this.e = i3 + i2;
            this.c = 0;
            InputStream inputStream = this.f138a;
            if (inputStream == null) {
                read = -1;
            } else {
                read = inputStream.read(this.f139a);
            }
            this.a = read;
            if (read != 0 && read >= -1) {
                if (read == -1) {
                    this.a = 0;
                    if (!z) {
                        return false;
                    }
                    throw d.a();
                }
                b();
                int i4 = this.e + this.a + this.b;
                if (i4 <= this.i && i4 >= 0) {
                    return true;
                }
                throw d.h();
            }
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.a + "\nThe InputStream implementation is buggy.");
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public void c(int i) {
        int skip;
        if (i >= 0) {
            int i2 = this.e;
            int i3 = this.c;
            int i4 = i2 + i3 + i;
            int i5 = this.f;
            if (i4 <= i5) {
                int i6 = this.a;
                if (i <= i6 - i3) {
                    this.c = i3 + i;
                    return;
                }
                int i7 = i6 - i3;
                this.e = i2 + i6;
                this.c = 0;
                this.a = 0;
                while (i7 < i) {
                    InputStream inputStream = this.f138a;
                    if (inputStream == null) {
                        skip = -1;
                    } else {
                        skip = (int) inputStream.skip(i - i7);
                    }
                    if (skip > 0) {
                        i7 += skip;
                        this.e += skip;
                    } else {
                        throw d.a();
                    }
                }
                return;
            }
            c((i5 - i2) - i3);
            throw d.a();
        }
        throw d.b();
    }

    public int a(int i) {
        if (i >= 0) {
            int i2 = i + this.e + this.c;
            int i3 = this.f;
            if (i2 <= i3) {
                this.f = i2;
                b();
                return i3;
            }
            throw d.a();
        }
        throw d.b();
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    private b(byte[] bArr, int i, int i2) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = 67108864;
        this.f139a = bArr;
        this.a = i2 + i;
        this.c = i;
        this.f138a = null;
    }
}
