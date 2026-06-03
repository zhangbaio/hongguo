package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class es {

    /* renamed from: a, reason: collision with other field name */
    private ex f400a;

    /* renamed from: a, reason: collision with other field name */
    private InputStream f401a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f404a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f405a;

    /* renamed from: a, reason: collision with other field name */
    private ByteBuffer f402a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: a, reason: collision with other field name */
    private Adler32 f403a = new Adler32();
    private ev a = new ev();

    static {
        Covode.recordClassIndex(655500);
    }

    void b() {
        this.f404a = true;
    }

    /* renamed from: a, reason: collision with other method in class */
    void m406a() {
        try {
            c();
        } catch (IOException e) {
            if (this.f404a) {
            } else {
                throw e;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    eq m405a() {
        int i;
        ByteBuffer a;
        eq a2;
        try {
            a = a();
            i = a.position();
        } catch (IOException e) {
            e = e;
            i = 0;
        }
        try {
            a.flip();
            a.position(8);
            if (i == 8) {
                a2 = new ew();
            } else {
                a2 = eq.a(a.slice());
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + a2.m394a() + ";chid=" + a2.a() + ";len=" + i + "}");
            return a2;
        } catch (IOException e2) {
            e = e2;
            if (i == 0) {
                i = this.f402a.position();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[Slim] read Blob [");
            byte[] array = this.f402a.array();
            if (i > 128) {
                i = 128;
            }
            sb.append(aa.a(array, 0, i));
            sb.append("] Err:");
            sb.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.m54a(sb.toString());
            throw e;
        }
    }

    private ByteBuffer a() {
        this.f402a.clear();
        a(this.f402a, 8);
        short s = this.f402a.getShort(0);
        short s2 = this.f402a.getShort(2);
        if (s == -15618 && s2 == 5) {
            int i = this.f402a.getInt(4);
            int position = this.f402a.position();
            if (i <= 32768) {
                if (i + 4 > this.f402a.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
                    allocate.put(this.f402a.array(), 0, this.f402a.arrayOffset() + this.f402a.position());
                    this.f402a = allocate;
                } else if (this.f402a.capacity() > 4096 && i < 2048) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(2048);
                    allocate2.put(this.f402a.array(), 0, this.f402a.arrayOffset() + this.f402a.position());
                    this.f402a = allocate2;
                }
                a(this.f402a, i);
                this.b.clear();
                a(this.b, 4);
                this.b.position(0);
                int i2 = this.b.getInt();
                this.f403a.reset();
                this.f403a.update(this.f402a.array(), 0, this.f402a.position());
                if (i2 == ((int) this.f403a.getValue())) {
                    byte[] bArr = this.f405a;
                    if (bArr != null) {
                        com.xiaomi.push.service.ar.a(bArr, this.f402a.array(), true, position, i);
                    }
                    return this.f402a;
                }
                com.xiaomi.channel.commonutils.logger.b.m54a("CRC = " + ((int) this.f403a.getValue()) + " and " + i2);
                throw new IOException("Corrupted Blob bad CRC");
            }
            throw new IOException("Blob size too large");
        }
        throw new IOException("Malformed Input");
    }

    private void c() {
        boolean z = false;
        this.f404a = false;
        eq m405a = m405a();
        if ("CONN".equals(m405a.m394a())) {
            Cdo.f a = Cdo.f.a(m405a.m398a());
            if (a.m336a()) {
                this.f400a.a(a.m335a());
                z = true;
            }
            if (a.c()) {
                Cdo.b m334a = a.m334a();
                eq eqVar = new eq();
                eqVar.a("SYNC", "CONF");
                eqVar.a(m334a.m378a(), (String) null);
                this.f400a.a(eqVar);
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] CONN: host = " + a.m337b());
        }
        if (z) {
            this.f405a = this.f400a.m412a();
            while (!this.f404a) {
                eq m405a2 = m405a();
                long currentTimeMillis = System.currentTimeMillis();
                this.f400a.c();
                short m396a = m405a2.m396a();
                if (m396a != 1) {
                    if (m396a != 2) {
                        if (m396a != 3) {
                            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] unknow blob type " + ((int) m405a2.m396a()));
                        } else {
                            try {
                                this.f400a.b(this.a.a(m405a2.m398a(), this.f400a));
                            } catch (Exception e) {
                                com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] Parse packet from Blob chid=" + m405a2.a() + "; Id=" + m405a2.e() + " failure:" + e.getMessage());
                            }
                        }
                    } else if ("SECMSG".equals(m405a2.m394a()) && ((m405a2.a() == 2 || m405a2.a() == 3) && TextUtils.isEmpty(m405a2.m401b()))) {
                        try {
                            fn a2 = this.a.a(m405a2.m399a(com.xiaomi.push.service.am.a().a(Integer.valueOf(m405a2.a()).toString(), m405a2.g()).h), this.f400a);
                            a2.f461a = currentTimeMillis;
                            this.f400a.b(a2);
                        } catch (Exception e2) {
                            com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] Parse packet from Blob chid=" + m405a2.a() + "; Id=" + m405a2.e() + " failure:" + e2.getMessage());
                        }
                    } else {
                        this.f400a.a(m405a2);
                    }
                } else {
                    this.f400a.a(m405a2);
                }
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("[Slim] Invalid CONN");
        throw new IOException("Invalid Connection");
    }

    private void a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f401a.read(byteBuffer.array(), position, i);
            if (read != -1) {
                i -= read;
                position += read;
            } else {
                throw new EOFException();
            }
        } while (i > 0);
        byteBuffer.position(position);
    }

    es(InputStream inputStream, ex exVar) {
        this.f401a = new BufferedInputStream(inputStream);
        this.f400a = exVar;
    }
}
