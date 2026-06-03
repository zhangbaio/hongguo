package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class eq {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static final byte[] f393a;
    private static String b;

    /* renamed from: a, reason: collision with other field name */
    int f394a;

    /* renamed from: a, reason: collision with other field name */
    private Cdo.a f395a;

    /* renamed from: a, reason: collision with other field name */
    String f396a;

    /* renamed from: a, reason: collision with other field name */
    private short f397a;

    /* renamed from: b, reason: collision with other field name */
    private final long f398b;

    /* renamed from: b, reason: collision with other field name */
    private byte[] f399b;

    /* renamed from: a, reason: collision with other method in class */
    public long m393a() {
        return this.f398b;
    }

    public String f() {
        return this.f396a;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f395a.c(str);
        this.f395a.m286a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f395a.d(str2);
    }

    public void a(String str) {
        this.f395a.e(str);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m397a() {
        return this.f395a.j();
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f395a.c(1);
            this.f399b = com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), bArr);
        } else {
            this.f395a.c(0);
            this.f399b = bArr;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m398a() {
        return er.a(this, this.f399b);
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m399a(String str) {
        if (this.f395a.e() == 1) {
            return er.a(this, com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(str, e()), this.f399b));
        }
        if (this.f395a.e() == 0) {
            return er.a(this, this.f399b);
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("unknow cipher = " + this.f395a.e());
        return er.a(this, this.f399b);
    }

    public void a(short s) {
        this.f397a = s;
    }

    public int a() {
        return this.f395a.c();
    }

    public int b() {
        return this.f395a.f();
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m403c() {
        return this.f395a.m285a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m394a() {
        return this.f395a.m293c();
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m400b() {
        return this.f395a.m289b();
    }

    public int c() {
        return this.f395a.b() + 8 + this.f399b.length;
    }

    public eq() {
        this.f397a = (short) 2;
        this.f399b = f393a;
        this.f396a = null;
        this.f398b = System.currentTimeMillis();
        this.f395a = new Cdo.a();
        this.f394a = 1;
    }

    /* renamed from: a, reason: collision with other method in class */
    public short m396a() {
        return this.f397a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m401b() {
        return this.f395a.m295d();
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m404c() {
        return this.f395a.m299f();
    }

    static {
        Covode.recordClassIndex(655498);
        b = fw.a(5) + "-";
        a = 0L;
        f393a = new byte[0];
    }

    public static synchronized String d() {
        String sb;
        synchronized (eq.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            long j = a;
            a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public String e() {
        String m297e = this.f395a.m297e();
        if ("ID_NOT_AVAILABLE".equals(m297e)) {
            return null;
        }
        if (!this.f395a.g()) {
            String d = d();
            this.f395a.e(d);
            return d;
        }
        return m297e;
    }

    public String g() {
        if (this.f395a.m291b()) {
            return Long.toString(this.f395a.m285a()) + "@" + this.f395a.m287a() + "/" + this.f395a.m290b();
        }
        return null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m402b() {
        return this.f395a.l();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.aj.a(e()) + "; cmd=" + m394a() + "; type=" + ((int) m396a()) + "; from=" + g() + " ]";
    }

    public void b(String str) {
        this.f396a = str;
    }

    public void a(int i) {
        this.f395a.a(i);
    }

    public void b(long j) {
        this.f395a.b(j);
    }

    public void c(long j) {
        this.f395a.c(j);
    }

    static eq a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            Cdo.a aVar = new Cdo.a();
            aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new eq(aVar, s, bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f395a.a(parseLong);
                this.f395a.a(substring);
                this.f395a.b(substring2);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m54a("Blob parse user err " + e.getMessage());
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    ByteBuffer mo395a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f397a);
        byteBuffer.putShort((short) this.f395a.a());
        byteBuffer.putInt(this.f399b.length);
        int position = byteBuffer.position();
        this.f395a.m377a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f395a.a());
        byteBuffer.position(position + this.f395a.a());
        byteBuffer.put(this.f399b);
        return byteBuffer;
    }

    public void a(long j) {
        this.f395a.a(j);
    }

    public static eq a(fn fnVar, String str) {
        int i;
        eq eqVar = new eq();
        try {
            i = Integer.parseInt(fnVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        eqVar.a(i);
        eqVar.a(fnVar.j());
        eqVar.c(fnVar.m());
        eqVar.b(fnVar.n());
        eqVar.a("XMLMSG", (String) null);
        try {
            eqVar.a(fnVar.mo435a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                eqVar.a((short) 3);
            } else {
                eqVar.a((short) 2);
                eqVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob setPayload err： " + e2.getMessage());
        }
        return eqVar;
    }

    eq(Cdo.a aVar, short s, byte[] bArr) {
        this.f397a = (short) 2;
        this.f399b = f393a;
        this.f396a = null;
        this.f398b = System.currentTimeMillis();
        this.f395a = aVar;
        this.f397a = s;
        this.f399b = bArr;
        this.f394a = 2;
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f395a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f395a.a(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f395a.b(str2);
        }
    }
}
