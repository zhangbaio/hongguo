package com.xiaomi.push;

import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class et {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private ex f406a;

    /* renamed from: a, reason: collision with other field name */
    private OutputStream f407a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f410a;
    private int b;

    /* renamed from: a, reason: collision with other field name */
    ByteBuffer f408a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with other field name */
    private ByteBuffer f411b = ByteBuffer.allocate(4);

    /* renamed from: a, reason: collision with other field name */
    private Adler32 f409a = new Adler32();

    static {
        Covode.recordClassIndex(655501);
    }

    public void b() {
        eq eqVar = new eq();
        eqVar.a("CLOSE", (String) null);
        a(eqVar);
        this.f407a.close();
    }

    public void a() {
        Cdo.e eVar = new Cdo.e();
        eVar.a(106);
        String str = Build.MODEL;
        eVar.a(str);
        eVar.b(q.m641a());
        eVar.c(com.xiaomi.push.service.ax.m709a());
        eVar.b(48);
        eVar.d(this.f406a.m420b());
        eVar.e(this.f406a.mo418a());
        eVar.f(Locale.getDefault().toString());
        int i = Build.VERSION.SDK_INT;
        eVar.c(i);
        eVar.d(g.a(this.f406a.a(), "com.xiaomi.xmsf"));
        byte[] mo426a = this.f406a.m417a().mo426a();
        if (mo426a != null) {
            eVar.a(Cdo.b.a(mo426a));
        }
        eq eqVar = new eq();
        eqVar.a(0);
        eqVar.a("CONN", (String) null);
        eqVar.a(0L, "xiaomi.com", null);
        eqVar.a(eVar.m378a(), (String) null);
        a(eqVar);
        com.xiaomi.channel.commonutils.logger.b.m54a("[slim] open conn: andver=" + i + " sdk=48 tz=" + this.a + ":" + this.b + " Model=" + str + " os=" + Build.VERSION.INCREMENTAL);
    }

    public int a(eq eqVar) {
        int c = eqVar.c();
        if (c > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + eqVar.a() + " id=" + eqVar.e());
            return 0;
        }
        this.f408a.clear();
        int i = c + 8 + 4;
        if (i > this.f408a.capacity() || this.f408a.capacity() > 4096) {
            this.f408a = ByteBuffer.allocate(i);
        }
        this.f408a.putShort((short) -15618);
        this.f408a.putShort((short) 5);
        this.f408a.putInt(c);
        int position = this.f408a.position();
        this.f408a = eqVar.mo395a(this.f408a);
        if (!"CONN".equals(eqVar.m394a())) {
            if (this.f410a == null) {
                this.f410a = this.f406a.m412a();
            }
            com.xiaomi.push.service.ar.a(this.f410a, this.f408a.array(), true, position, c);
        }
        this.f409a.reset();
        this.f409a.update(this.f408a.array(), 0, this.f408a.position());
        this.f411b.putInt(0, (int) this.f409a.getValue());
        this.f407a.write(this.f408a.array(), 0, this.f408a.position());
        this.f407a.write(this.f411b.array(), 0, 4);
        this.f407a.flush();
        int position2 = this.f408a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + eqVar.m394a() + ";chid=" + eqVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    et(OutputStream outputStream, ex exVar) {
        this.f407a = new BufferedOutputStream(outputStream);
        this.f406a = exVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }
}
