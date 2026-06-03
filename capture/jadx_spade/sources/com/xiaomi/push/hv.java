package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class hv extends hz {
    private static final ie a;

    /* renamed from: a, reason: collision with other field name */
    protected int f823a;

    /* renamed from: a, reason: collision with other field name */
    protected boolean f824a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f825a;
    protected boolean b;

    /* renamed from: b, reason: collision with other field name */
    private byte[] f826b;
    protected boolean c;

    /* renamed from: c, reason: collision with other field name */
    private byte[] f827c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private byte[] h;

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public void mo615a() {
    }

    @Override // com.xiaomi.push.hz
    public void a(ie ieVar) {
    }

    @Override // com.xiaomi.push.hz
    public void b() {
    }

    @Override // com.xiaomi.push.hz
    public void d() {
    }

    @Override // com.xiaomi.push.hz
    public void e() {
    }

    @Override // com.xiaomi.push.hz
    public void f() {
    }

    @Override // com.xiaomi.push.hz
    public void g() {
    }

    @Override // com.xiaomi.push.hz
    public void h() {
    }

    @Override // com.xiaomi.push.hz
    public void i() {
    }

    @Override // com.xiaomi.push.hz
    public void j() {
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public ie mo611a() {
        return a;
    }

    @Override // com.xiaomi.push.hz
    public void a(hw hwVar) {
        a(hwVar.a);
        a(hwVar.f830a);
    }

    @Override // com.xiaomi.push.hz
    public void a(hy hyVar) {
        a(hyVar.a);
        a(hyVar.b);
        mo616a(hyVar.f832a);
    }

    @Override // com.xiaomi.push.hz
    public void a(hx hxVar) {
        a(hxVar.a);
        mo616a(hxVar.f831a);
    }

    @Override // com.xiaomi.push.hz
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.hz
    public void a(byte b) {
        byte[] bArr = this.f825a;
        bArr[0] = b;
        ((hz) this).a.mo626a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.hz
    public void a(short s) {
        byte[] bArr = this.f826b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((hz) this).a.mo626a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public void mo616a(int i) {
        byte[] bArr = this.f827c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        ((hz) this).a.mo626a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.hz
    public void a(long j) {
        byte[] bArr = this.d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        ((hz) this).a.mo626a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.hz
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo616a(bytes.length);
            ((hz) this).a.mo626a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new ht("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.hz
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo616a(limit);
        ((hz) this).a.mo626a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public id mo610a() {
        return new id(a(), mo605a());
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo617a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public short mo614a() {
        int i;
        byte[] bArr = this.f;
        if (((hz) this).a.b() >= 2) {
            bArr = ((hz) this).a.a();
            i = ((hz) this).a.a_();
            ((hz) this).a.a(2);
        } else {
            a(this.f, 0, 2);
            i = 0;
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public String mo612a() {
        int mo605a = mo605a();
        if (((hz) this).a.b() >= mo605a) {
            try {
                String str = new String(((hz) this).a.a(), ((hz) this).a.a_(), mo605a, "UTF-8");
                ((hz) this).a.a(mo605a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new ht("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(mo605a);
    }

    public String a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            ((hz) this).a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new ht("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo613a() {
        int mo605a = mo605a();
        c(mo605a);
        if (((hz) this).a.b() >= mo605a) {
            ByteBuffer wrap = ByteBuffer.wrap(((hz) this).a.a(), ((hz) this).a.a_(), mo605a);
            ((hz) this).a.a(mo605a);
            return wrap;
        }
        byte[] bArr = new byte[mo605a];
        ((hz) this).a.b(bArr, 0, mo605a);
        return ByteBuffer.wrap(bArr);
    }

    public static class a implements ib {
        protected int a;

        /* renamed from: a, reason: collision with other field name */
        protected boolean f828a;
        protected boolean b;

        static {
            Covode.recordClassIndex(655600);
        }

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.ib
        public hz a(ij ijVar) {
            hv hvVar = new hv(ijVar, this.f828a, this.b);
            int i = this.a;
            if (i != 0) {
                hvVar.b(i);
            }
            return hvVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f828a = z;
            this.b = z2;
            this.a = i;
        }
    }

    @Override // com.xiaomi.push.hz
    public void c() {
        a((byte) 0);
    }

    static {
        Covode.recordClassIndex(655599);
        a = new ie();
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public double mo604a() {
        return Double.longBitsToDouble(mo606a());
    }

    @Override // com.xiaomi.push.hz
    public byte a() {
        if (((hz) this).a.b() >= 1) {
            byte b = ((hz) this).a.a()[((hz) this).a.a_()];
            ((hz) this).a.a(1);
            return b;
        }
        a(this.e, 0, 1);
        return this.e[0];
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public int mo605a() {
        int i;
        byte[] bArr = this.g;
        if (((hz) this).a.b() >= 4) {
            bArr = ((hz) this).a.a();
            i = ((hz) this).a.a_();
            ((hz) this).a.a(4);
        } else {
            a(this.g, 0, 4);
            i = 0;
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public long mo606a() {
        int i;
        byte[] bArr = this.h;
        if (((hz) this).a.b() >= 8) {
            bArr = ((hz) this).a.a();
            i = ((hz) this).a.a_();
            ((hz) this).a.a(8);
        } else {
            a(this.h, 0, 8);
            i = 0;
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public hw mo607a() {
        short mo614a;
        byte a2 = a();
        if (a2 == 0) {
            mo614a = 0;
        } else {
            mo614a = mo614a();
        }
        return new hw("", a2, mo614a);
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public hx mo608a() {
        return new hx(a(), mo605a());
    }

    @Override // com.xiaomi.push.hz
    /* renamed from: a, reason: collision with other method in class */
    public hy mo609a() {
        return new hy(a(), a(), mo605a());
    }

    public void b(int i) {
        this.f823a = i;
        this.c = true;
    }

    protected void c(int i) {
        if (i >= 0) {
            if (this.c) {
                int i2 = this.f823a - i;
                this.f823a = i2;
                if (i2 < 0) {
                    throw new ht("Message length exceeded: " + i);
                }
                return;
            }
            return;
        }
        throw new ht("Negative length: " + i);
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return ((hz) this).a.b(bArr, i, i2);
    }

    public hv(ij ijVar, boolean z, boolean z2) {
        super(ijVar);
        this.c = false;
        this.f825a = new byte[1];
        this.f826b = new byte[2];
        this.f827c = new byte[4];
        this.d = new byte[8];
        this.e = new byte[1];
        this.f = new byte[2];
        this.g = new byte[4];
        this.h = new byte[8];
        this.f824a = z;
        this.b = z2;
    }
}
