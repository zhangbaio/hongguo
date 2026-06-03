package com.tt.android.qualitystat;

import android.content.Context;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.base.QualityStatLog;
import com.tt.android.qualitystat.base.d;
import com.tt.android.qualitystat.config.StatConfig;
import com.tt.android.qualitystat.duration.TimeEventManager;
import com.tt.android.qualitystat.util.b;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tj6.g;
import uj6.c;
import uj6.e;
import uj6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class UserStatAgent {
    private static boolean a;
    private static AtomicBoolean b;
    private static final ConcurrentHashMap<Class<? extends e>, LinkedHashSet<e>> c;
    private static f d;
    private static c e;
    private static final ConcurrentHashMap<String, Object> f;
    public static final UserStatAgent g;

    private UserStatAgent() {
    }

    public final ConcurrentHashMap<String, Object> c() {
        return f;
    }

    public final boolean d() {
        return a;
    }

    public final ConcurrentHashMap<Class<? extends e>, LinkedHashSet<e>> e() {
        return c;
    }

    public final AtomicBoolean f() {
        return b;
    }

    public final c g() {
        return e;
    }

    public final f h() {
        return d;
    }

    static {
        Covode.recordClassIndex(654023);
        g = new UserStatAgent();
        b = new AtomicBoolean(false);
        c = new ConcurrentHashMap<>();
        f = new ConcurrentHashMap<>();
    }

    private final void m(final Function0<Unit> function0) {
        b.c.a(new Function0<Unit>() { // from class: com.tt.android.qualitystat.UserStatAgent$statEventInThread$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (com.tt.android.qualitystat.config.c.b.a() || !UserStatAgent.g.f().get()) {
                    Function0.this.invoke();
                }
            }
        });
    }

    public final void j(final sj6.b bVar) {
        if (a) {
            com.tt.android.qualitystat.util.c.a.a(bVar.getScene());
        }
        m(new Function0<Unit>() { // from class: com.tt.android.qualitystat.UserStatAgent$pause$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tt.android.qualitystat.duration.a.b.g(sj6.b.this);
            }
        });
    }

    public final void k(final sj6.b bVar) {
        if (a) {
            com.tt.android.qualitystat.util.c.a.a(bVar.getScene());
        }
        m(new Function0<Unit>() { // from class: com.tt.android.qualitystat.UserStatAgent$resume$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tt.android.qualitystat.duration.a.b.c(sj6.b.this);
            }
        });
    }

    public final void l(final sj6.b bVar, final g gVar) {
        if (a) {
            com.tt.android.qualitystat.util.c.a.a(bVar.getScene() + '|' + gVar);
        }
        m(new Function0<Unit>() { // from class: com.tt.android.qualitystat.UserStatAgent$start$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tt.android.qualitystat.duration.a.b.h(sj6.b.this, gVar);
            }
        });
    }

    public final void i(StatConfig statConfig, Context context) {
        if (a) {
            com.tt.android.qualitystat.util.c.b(com.tt.android.qualitystat.util.c.a, null, 1, null);
            if (context == null) {
                throw new IllegalArgumentException("Param context in init must NOT be null!");
            }
        }
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        if (mainLooper.getThread() == Thread.currentThread()) {
            QualityStatLog.c.c("init method should call in work thread");
        }
        com.tt.android.qualitystat.config.c cVar = com.tt.android.qualitystat.config.c.b;
        cVar.d(statConfig, context);
        if (!b.getAndSet(true)) {
            try {
                QualityStatLog.c.f("DEBUG= " + a + ", init by config: " + statConfig);
                d.c.a();
                if (!cVar.a()) {
                    TimeEventManager.b.e();
                    return;
                }
                return;
            } catch (Exception e2) {
                QualityStatLog.c.c(e2.toString());
                return;
            }
        }
        QualityStatLog.c.h("ttquality stat sdk has init already!");
    }

    public final void a(final sj6.b bVar, final g gVar, final int i) {
        if (a) {
            com.tt.android.qualitystat.util.c.a.a(bVar.getScene() + '|' + gVar);
        }
        m(new Function0<Unit>() { // from class: com.tt.android.qualitystat.UserStatAgent$end$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.tt.android.qualitystat.duration.a.b.d(sj6.b.this, gVar, i);
            }
        });
    }

    public static /* synthetic */ void b(UserStatAgent userStatAgent, sj6.b bVar, g gVar, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = com.tt.android.qualitystat.config.c.b.b(bVar).z();
        }
        userStatAgent.a(bVar, gVar, i);
    }
}
