package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.Cif;
import com.xiaomi.push.aw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class en {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private long f387a;

    /* renamed from: a, reason: collision with other field name */
    private em f389a;

    /* renamed from: a, reason: collision with other field name */
    private String f390a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f391a = false;

    /* renamed from: a, reason: collision with other field name */
    private aw f388a = aw.a();

    static {
        Covode.recordClassIndex(655493);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static en m386a() {
        return a.a;
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f389a = new em(xMPushService);
        this.f390a = "";
        com.xiaomi.push.service.ax.a().a(new ax.a() { // from class: com.xiaomi.push.en.1
            @Override // com.xiaomi.push.service.ax.a
            public void a(Cdo.b bVar) {
                if (bVar.m305e()) {
                    en.m386a().m390a(bVar.e());
                }
            }
        });
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m391a() {
        return this.f391a;
    }

    static class a {
        static final en a;

        static {
            Covode.recordClassIndex(655494);
            a = new en();
        }
    }

    public static em a() {
        em emVar;
        en enVar = a.a;
        synchronized (enVar) {
            emVar = enVar.f389a;
        }
        return emVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m387a() {
        if (this.f391a && System.currentTimeMillis() - this.f387a > this.a) {
            this.f391a = false;
            this.f387a = 0L;
        }
    }

    boolean b() {
        m387a();
        if (this.f391a && this.f388a.m163a() > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    synchronized ei m388a() {
        ei eiVar;
        eiVar = new ei();
        eiVar.a(at.m151a((Context) this.f389a.f384a));
        eiVar.f361a = (byte) 0;
        eiVar.f365b = 1;
        eiVar.d((int) (System.currentTimeMillis() / 1000));
        return eiVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    synchronized ej m389a() {
        ej ejVar;
        int i;
        if (b()) {
            if (!at.d(this.f389a.f384a)) {
                i = 375;
            } else {
                i = 750;
            }
            ejVar = a(i);
        } else {
            ejVar = null;
        }
        return ejVar;
    }

    private ei a(aw.a aVar) {
        if (aVar.f133a == 0) {
            Object obj = aVar.f134a;
            if (obj instanceof ei) {
                return (ei) obj;
            }
            return null;
        }
        ei m388a = m388a();
        m388a.a(eh.CHANNEL_STATS_COUNTER.a());
        m388a.c(aVar.f133a);
        m388a.c(aVar.f135a);
        return m388a;
    }

    private ej a(int i) {
        ArrayList arrayList = new ArrayList();
        ej ejVar = new ej(this.f390a, arrayList);
        if (!at.d(this.f389a.f384a)) {
            ejVar.a(i.i(this.f389a.f384a));
        }
        ih ihVar = new ih(i);
        hz a2 = new Cif.a().a(ihVar);
        try {
            ejVar.b(a2);
        } catch (ht unused) {
        }
        LinkedList<aw.a> m164a = this.f388a.m164a();
        while (m164a.size() > 0) {
            try {
                ei a3 = a(m164a.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (ihVar.a() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                m164a.removeLast();
            } catch (ht | NoSuchElementException unused2) {
            }
        }
        return ejVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m390a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.a != i2 || !this.f391a) {
                this.f391a = true;
                this.f387a = System.currentTimeMillis();
                this.a = i2;
                com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + i2 + " start = " + this.f387a);
            }
        }
    }

    synchronized void a(ei eiVar) {
        this.f388a.a(eiVar);
    }
}
