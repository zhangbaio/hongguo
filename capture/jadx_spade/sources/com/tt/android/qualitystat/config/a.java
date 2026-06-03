package com.tt.android.qualitystat.config;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a extends tj6.b {
    public static final C0115a a;

    /* renamed from: com.tt.android.qualitystat.config.a$a, reason: collision with other inner class name */
    public static final class C0115a {
        private static final a a;
        static final /* synthetic */ C0115a b;

        private C0115a() {
        }

        /* renamed from: com.tt.android.qualitystat.config.a$a$a, reason: collision with other inner class name */
        public static final class C0116a implements a {
            private final String b;
            private final Boolean c;
            private final Integer d;
            private final Integer e;
            private final Boolean f;
            private final Boolean g;
            private final Integer h;
            private final Integer i;
            private final Integer j;
            private final Integer k;
            private final Integer l;
            private a m;

            @Override // com.tt.android.qualitystat.config.a
            public Integer b() {
                return this.i;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer e() {
                return this.h;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer g() {
                return this.k;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean getEnable() {
                return this.c;
            }

            @Override // com.tt.android.qualitystat.config.a
            public a getFallback() {
                return this.m;
            }

            @Override // com.tt.android.qualitystat.config.a
            public String getScene() {
                return this.b;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer h() {
                return this.l;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean k() {
                return this.g;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer o() {
                return this.d;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Boolean r() {
                return this.f;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer s() {
                return this.j;
            }

            @Override // com.tt.android.qualitystat.config.a
            public Integer w() {
                return this.e;
            }

            @Override // com.tt.android.qualitystat.config.a
            public int c() {
                return b.k(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean enable() {
                return b.a(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int i() {
                return b.c(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int l() {
                return b.g(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean m() {
                return b.i(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int p() {
                return b.h(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public boolean q() {
                return b.j(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int t() {
                return b.b(this);
            }

            @Override // com.tt.android.qualitystat.config.a, tj6.b
            public JSONObject toJsonObject() {
                return b.l(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int y() {
                return b.e(this);
            }

            @Override // com.tt.android.qualitystat.config.a
            public int z() {
                return b.f(this);
            }

            C0116a() {
                Boolean bool = Boolean.FALSE;
                this.c = bool;
                this.d = 0;
                this.e = 300000;
                this.f = bool;
                this.g = Boolean.TRUE;
                this.h = 3000;
                this.i = 500;
                this.j = 1000;
                this.k = 0;
                this.l = 3;
            }

            @Override // com.tt.android.qualitystat.config.a
            public void x(a aVar) {
                this.m = aVar;
            }
        }

        public final a a() {
            return a;
        }

        static {
            Covode.recordClassIndex(654032);
            b = new C0115a();
            a = new C0116a();
        }
    }

    static {
        Covode.recordClassIndex(654031);
        a = C0115a.b;
    }

    Integer b();

    int c();

    Integer e();

    boolean enable();

    Integer g();

    Boolean getEnable();

    a getFallback();

    String getScene();

    Integer h();

    int i();

    Boolean k();

    int l();

    boolean m();

    Integer o();

    int p();

    boolean q();

    Boolean r();

    Integer s();

    int t();

    @Override // tj6.b
    JSONObject toJsonObject();

    Integer w();

    void x(a aVar);

    int y();

    int z();

    public static final class b {
        static {
            Covode.recordClassIndex(654033);
        }

        public static boolean a(a aVar) {
            Boolean enable = aVar.getEnable();
            if (enable != null) {
                return enable.booleanValue();
            }
            return d(aVar).enable();
        }

        public static int b(a aVar) {
            Integer s = aVar.s();
            if (s != null) {
                return s.intValue();
            }
            return d(aVar).t();
        }

        public static int c(a aVar) {
            Integer e = aVar.e();
            if (e != null) {
                return e.intValue();
            }
            return d(aVar).i();
        }

        public static int e(a aVar) {
            Integer g = aVar.g();
            if (g != null) {
                return g.intValue();
            }
            return d(aVar).y();
        }

        public static int f(a aVar) {
            Integer h = aVar.h();
            if (h != null) {
                return h.intValue();
            }
            return d(aVar).z();
        }

        public static int g(a aVar) {
            Integer w = aVar.w();
            if (w != null) {
                return w.intValue();
            }
            return d(aVar).l();
        }

        public static int h(a aVar) {
            Integer o = aVar.o();
            if (o != null) {
                return o.intValue();
            }
            return d(aVar).p();
        }

        public static boolean i(a aVar) {
            Boolean k = aVar.k();
            if (k != null) {
                return k.booleanValue();
            }
            return d(aVar).m();
        }

        public static boolean j(a aVar) {
            Boolean r = aVar.r();
            if (r != null) {
                return r.booleanValue();
            }
            return d(aVar).q();
        }

        public static int k(a aVar) {
            Integer b = aVar.b();
            if (b != null) {
                return b.intValue();
            }
            return d(aVar).c();
        }

        private static a d(a aVar) {
            boolean z;
            StatConfig c;
            if (!Intrinsics.areEqual(aVar, a.a.a())) {
                a fallback = aVar.getFallback();
                if (fallback == null) {
                    String scene = aVar.getScene();
                    if (scene != null && !StringsKt__StringsKt.isBlank(scene)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        c = StatConfig.i.c();
                    } else {
                        c = c.b.c();
                    }
                    return c;
                }
                return fallback;
            }
            throw new IllegalStateException("循环调用fallback,找quwanxin修复");
        }

        public static JSONObject l(a aVar) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("scene_name", aVar.getScene());
            jSONObject.putOpt("enable", aVar.getEnable());
            jSONObject.putOpt("min_stat_duration", aVar.o());
            jSONObject.putOpt("max_stat_duration", aVar.w());
            jSONObject.putOpt("double_send", aVar.r());
            jSONObject.putOpt("send_to_slardar", aVar.k());
            jSONObject.putOpt("error_stat_interval", aVar.e());
            jSONObject.putOpt("start_event_interval", aVar.b());
            jSONObject.putOpt("end_event_interval", aVar.s());
            jSONObject.putOpt("frequency_interval", aVar.g());
            jSONObject.putOpt("match_mode", aVar.h());
            return jSONObject;
        }
    }
}
