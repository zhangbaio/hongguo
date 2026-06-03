package com.dragon.read.kmp.story.impl.feeds.trace;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public static final a b;
    public static final int c;
    public final vp4.b a = new vp4.b();

    public static final class a {
        static {
            Covode.recordClassIndex(609352);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609351);
        b = new a(null);
        c = 8;
    }

    public void f() {
        this.a.c("process_data_dur");
    }

    public void g() {
        this.a.f("process_data_dur");
    }

    public void h() {
        this.a.c("first_feed_render_dur");
    }

    public void i() {
        this.a.f("first_feed_render_dur");
    }

    public void m() {
        this.a.g();
    }

    public void d() {
        this.a.d(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.trace.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e;
                e = j.e(j.this);
                return e;
            }
        });
    }

    public void j() {
        this.a.c("total_net_dur");
    }

    public void k() {
        this.a.f("total_net_dur");
    }

    public void l() {
        long e = this.a.e();
        ym4.a aVar = new ym4.a();
        aVar.h(this.a.h);
        aVar.g("trace_dur", Long.valueOf(e));
        aVar.g("is_kmp", 1);
        zp4.a.b(zp4.a.a, "story_post_feed_trace_event", aVar, false, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(j jVar) {
        jVar.l();
        return Unit.INSTANCE;
    }

    public void c(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.a.b(map);
    }

    public void b(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a.a(key, value);
    }
}
