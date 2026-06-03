package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.xiaomi.push.el;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ek implements am.b.a {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private ez f376a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f377a;

    /* renamed from: a, reason: collision with other field name */
    private am.b f378a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f380a = false;

    /* renamed from: a, reason: collision with other field name */
    private am.c f379a = am.c.binding;

    static {
        Covode.recordClassIndex(655489);
    }

    private void b() {
        this.f378a.b(this);
    }

    void a() {
        this.f378a.a(this);
        this.f376a = this.f377a.m664a();
    }

    /* renamed from: com.xiaomi.push.ek$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[am.c.values().length];
            a = iArr;
            try {
                iArr[am.c.unbind.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[am.c.binding.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[am.c.binded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b();
        if (!this.f380a || this.a == 11) {
            return;
        }
        ei m388a = en.m386a().m388a();
        int i = AnonymousClass2.a[this.f379a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                m388a.f362a = eh.BIND_SUCCESS.a();
            }
        } else {
            int i2 = this.a;
            if (i2 == 17) {
                m388a.f362a = eh.BIND_TCP_READ_TIMEOUT.a();
            } else if (i2 == 21) {
                m388a.f362a = eh.BIND_TIMEOUT.a();
            } else {
                try {
                    el.a c = el.c(en.a().a());
                    m388a.f362a = c.a.a();
                    m388a.c(c.f381a);
                } catch (NullPointerException unused) {
                    m388a = null;
                }
            }
        }
        if (m388a != null) {
            m388a.b(this.f376a.mo418a());
            m388a.d(this.f378a.f936b);
            m388a.f365b = 1;
            try {
                m388a.a((byte) Integer.parseInt(this.f378a.g));
            } catch (NumberFormatException unused2) {
            }
            en.m386a().a(m388a);
        }
    }

    ek(XMPushService xMPushService, am.b bVar) {
        this.f377a = xMPushService;
        this.f378a = bVar;
    }

    @Override // com.xiaomi.push.service.am.b.a
    public void a(am.c cVar, am.c cVar2, int i) {
        if (!this.f380a && cVar == am.c.binding) {
            this.f379a = cVar2;
            this.a = i;
            this.f380a = true;
        }
        this.f377a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.ek.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Handling bind stats";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a, reason: collision with other method in class */
            public void mo383a() {
                ek.this.c();
            }
        });
    }
}
