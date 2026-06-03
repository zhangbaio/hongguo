package com.dragon.read.kmp.story.impl.feeds.trace;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.p;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final a e;
    public static final int f;
    private final yo4.d a;
    public final vp4.b b;
    private boolean c;
    private boolean d;

    public static final class a {
        static {
            Covode.recordClassIndex(609348);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609347);
        e = new a(null);
        f = 8;
    }

    public void h() {
        this.b.c("process_data_with_request_post_dur");
    }

    public void i() {
        this.b.f("process_data_with_request_post_dur");
    }

    public void k() {
        this.b.f("render_with_request_post_dur");
    }

    public void o() {
        this.b.g();
    }

    public void d() {
        this.b.d(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.trace.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e2;
                e2 = b.e(b.this);
                return e2;
            }
        });
    }

    public void f() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.c("init_view_dur");
    }

    public void j() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.b.c("render_with_request_post_dur");
    }

    public void l() {
        this.b.c("total_net_dur");
    }

    public void m() {
        this.b.f("total_net_dur");
    }

    public void g() {
        long a2 = p.a() - this.a.a();
        if (a2 > 0) {
            this.b.a("init_dur", Long.valueOf(a2));
        }
        this.b.f("init_view_dur");
    }

    public void n() {
        long e2 = this.b.e();
        ym4.a aVar = new ym4.a();
        aVar.h(this.b.h);
        aVar.g("trace_dur", Long.valueOf(e2));
        aVar.g("is_kmp", 1);
        zp4.a.b(zp4.a.a, "story_post_detail_trace_event", aVar, false, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(b bVar) {
        bVar.n();
        return Unit.INSTANCE;
    }

    public void c(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.b.b(map);
    }

    public b(yo4.d clientParams) {
        Intrinsics.checkNotNullParameter(clientParams, "clientParams");
        this.a = clientParams;
        this.b = new vp4.b();
    }

    public void b(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.b.a(key, value);
    }
}
