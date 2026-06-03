package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.hv;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.if, reason: invalid class name */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Cif extends hv {
    private static int b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;

    /* renamed from: com.xiaomi.push.if$a */
    public static class a extends hv.a {
        static {
            Covode.recordClassIndex(655612);
        }

        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.hv.a, com.xiaomi.push.ib
        public hz a(ij ijVar) {
            Cif cif = new Cif(ijVar, ((hv.a) this).f828a, this.b);
            int i = ((hv.a) this).a;
            if (i != 0) {
                cif.b(i);
            }
            return cif;
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }
    }

    static {
        Covode.recordClassIndex(655611);
        b = 10000;
        c = 10000;
        d = 10000;
        e = 10485760;
        f = 104857600;
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* renamed from: a */
    public hx mo608a() {
        byte a2 = a();
        int mo605a = mo605a();
        if (mo605a <= c) {
            return new hx(a2, mo605a);
        }
        throw new ia(3, "Thrift list size " + mo605a + " out of range!");
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* renamed from: a */
    public hy mo609a() {
        byte a2 = a();
        byte a3 = a();
        int mo605a = mo605a();
        if (mo605a <= b) {
            return new hy(a2, a3, mo605a);
        }
        throw new ia(3, "Thrift map size " + mo605a + " out of range!");
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* renamed from: a */
    public id mo610a() {
        byte a2 = a();
        int mo605a = mo605a();
        if (mo605a <= d) {
            return new id(a2, mo605a);
        }
        throw new ia(3, "Thrift set size " + mo605a + " out of range!");
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* renamed from: a */
    public String mo612a() {
        int mo605a = mo605a();
        if (mo605a <= e) {
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
        throw new ia(3, "Thrift string size " + mo605a + " out of range!");
    }

    @Override // com.xiaomi.push.hv, com.xiaomi.push.hz
    /* renamed from: a */
    public ByteBuffer mo613a() {
        int mo605a = mo605a();
        if (mo605a <= f) {
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
        throw new ia(3, "Thrift binary size " + mo605a + " out of range!");
    }

    public Cif(ij ijVar, boolean z, boolean z2) {
        super(ijVar, z, z2);
    }
}
