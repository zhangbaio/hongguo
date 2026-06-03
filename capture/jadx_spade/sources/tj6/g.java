package tj6;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.constants.SystemScene;
import com.tt.android.qualitystat.util.KotlinExtKt;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g implements f {
    public static final a s;
    private String b;
    private sj6.b c;
    private Integer d;
    private Long e;
    private Long f;
    private String g;
    private Integer h;
    private Integer i;
    private JSONObject j;
    public long k;
    private String l;
    private String m;
    private Integer n;
    private JSONObject o;
    private final com.tt.android.qualitystat.base.c p;
    public String q;
    private JSONObject r;

    static {
        Covode.recordClassIndex(654072);
        s = new a(null);
    }

    public final g F() {
        this.e = 0L;
        this.f = 0L;
        return this;
    }

    public final e k() {
        return new j(h(), i(), this.r);
    }

    public g() {
        this.c = sj6.c.i(SystemScene.NULL);
        this.k = System.currentTimeMillis();
        this.p = new com.tt.android.qualitystat.base.c(3L);
        g();
    }

    private final g g() {
        this.k = System.currentTimeMillis();
        this.b = "user_perceptible_event";
        this.d = 0;
        this.i = Integer.valueOf(com.tt.android.qualitystat.config.d.g.e());
        return this;
    }

    private final d i() {
        return new i(this.l, this.m, this.n, this.o, this.p.a);
    }

    public final String w() {
        return this.c.getScene() + this.d + this.e + this.f + this.l + this.m + this.n;
    }

    private final c h() {
        int i;
        long j;
        long j2;
        int i2;
        int e;
        String str = this.b;
        if (str == null) {
            str = "user_perceptible_event";
        }
        String str2 = str;
        sj6.b bVar = this.c;
        Integer num = this.d;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        Long l = this.e;
        if (l != null) {
            j = l.longValue();
        } else {
            j = -1;
        }
        Long l2 = this.f;
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            j2 = 0;
        }
        String str3 = this.g;
        if (str3 == null) {
            str3 = "direct_report";
        }
        String str4 = str3;
        Integer num2 = this.h;
        if (num2 != null) {
            i2 = num2.intValue();
        } else {
            i2 = 0;
        }
        Integer num3 = this.i;
        if (num3 != null) {
            e = num3.intValue();
        } else {
            e = com.tt.android.qualitystat.config.d.g.e();
        }
        return new h(str2, bVar, i, j, j2, str4, i2, e, this.j, this.k);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParamBuilder(");
        sb.append("eventName=" + this.b);
        a aVar = s;
        sb.append(aVar.d(", dataType", this.d));
        sb.append(aVar.d(", status", this.e));
        sb.append(aVar.d(", errorType", this.f));
        sb.append(aVar.d(", durationType", this.g));
        sb.append(aVar.d(", duration", this.h));
        sb.append(aVar.d(", samplingType", this.i));
        sb.append(aVar.d(", description", this.l));
        sb.append(aVar.d(", descriptionType", this.m));
        sb.append(aVar.d(", descriptionCode", this.n));
        sb.append(aVar.d(", qualityNetInfo", this.o));
        sb.append(aVar.d(", stayInfo", this.j));
        sb.append(aVar.d(", extra", this.p));
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }

    public final g C(JSONObject jSONObject) {
        this.r = jSONObject;
        return this;
    }

    public final g D(sj6.b bVar) {
        this.c = bVar;
        return this;
    }

    public final g m(String str) {
        this.l = str;
        return this;
    }

    public final g p(String str) {
        this.m = str;
        return this;
    }

    public final g r(String str) {
        this.g = str;
        return this;
    }

    public final g s(String str) {
        this.b = str;
        return this;
    }

    private static final class a {
        static {
            Covode.recordClassIndex(654073);
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> T c(T t, T t2) {
            return t != null ? t : t2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d(String str, Object obj) {
            if (obj == null) {
                return "";
            }
            return str + '=' + obj;
        }
    }

    public g(f fVar) {
        this();
        A(fVar);
    }

    public final g l(int i) {
        this.d = Integer.valueOf(i);
        return this;
    }

    public final g o(int i) {
        this.n = Integer.valueOf(i);
        return this;
    }

    public final g q(int i) {
        this.h = Integer.valueOf(i);
        return this;
    }

    public final g E(String str) {
        if (str != null && (!StringsKt__StringsKt.isBlank(str))) {
            this.q = str;
        }
        return this;
    }

    public final g c(Map<String, ? extends Object> map) {
        e(new JSONObject(map));
        return this;
    }

    public final g t(boolean z) {
        this.e = 1L;
        x(z);
        return this;
    }

    private final g x(boolean z) {
        long j;
        if (z) {
            j = 1L;
        } else {
            j = 2L;
        }
        this.f = j;
        return this;
    }

    public final g A(f fVar) {
        if (fVar instanceof g) {
            B((g) fVar);
        } else if (fVar instanceof d) {
            z((d) fVar);
        } else if (fVar instanceof c) {
            y((c) fVar);
        }
        return this;
    }

    public final g e(JSONObject jSONObject) {
        com.tt.android.qualitystat.base.c.d(this.p, jSONObject, 0L, 2, null);
        if (jSONObject != null && jSONObject.has("error_reason")) {
            m(jSONObject.optString("error_reason"));
            this.p.e("error_reason");
        } else if (jSONObject != null && jSONObject.has("up_description")) {
            m(jSONObject.optString("up_description"));
            this.p.e("up_description");
        }
        return this;
    }

    private final g z(d dVar) {
        a aVar = s;
        this.l = (String) aVar.c(this.l, dVar.getDescription());
        this.m = (String) aVar.c(this.m, dVar.j());
        this.n = (Integer) aVar.c(this.n, dVar.f());
        KotlinExtKt.a(this.o, dVar.n());
        com.tt.android.qualitystat.base.c.d(this.p, dVar.u(), 0L, 2, null);
        return this;
    }

    private final g B(g gVar) {
        a aVar = s;
        this.b = (String) aVar.c(this.b, gVar.b);
        this.c = (sj6.b) aVar.c(this.c, gVar.c);
        this.d = (Integer) aVar.c(this.d, gVar.d);
        this.e = (Long) aVar.c(this.e, gVar.e);
        this.f = (Long) aVar.c(this.f, gVar.f);
        this.g = (String) aVar.c(this.g, gVar.g);
        this.h = (Integer) aVar.c(this.h, gVar.h);
        this.i = (Integer) aVar.c(this.i, gVar.i);
        KotlinExtKt.a(this.j, gVar.j);
        this.l = (String) aVar.c(this.l, gVar.l);
        this.m = (String) aVar.c(this.m, gVar.m);
        this.n = (Integer) aVar.c(this.n, gVar.n);
        KotlinExtKt.a(this.o, gVar.o);
        com.tt.android.qualitystat.base.c.d(this.p, gVar.p.a, 0L, 2, null);
        return this;
    }

    private final g y(c cVar) {
        a aVar = s;
        this.b = (String) aVar.c(this.b, cVar.getEventName());
        this.c = (sj6.b) aVar.c(this.c, cVar.getScene());
        this.k = ((Number) aVar.c(Long.valueOf(this.k), Long.valueOf(cVar.getTimestamp()))).longValue();
        this.d = (Integer) aVar.c(this.d, Integer.valueOf(cVar.getDataType()));
        this.e = (Long) aVar.c(this.e, Long.valueOf(cVar.getStatus()));
        this.f = (Long) aVar.c(this.f, Long.valueOf(cVar.getErrorType()));
        this.g = (String) aVar.c(this.g, cVar.v());
        this.h = (Integer) aVar.c(this.h, Integer.valueOf(cVar.getDuration()));
        this.i = (Integer) aVar.c(this.i, Integer.valueOf(cVar.a()));
        this.j = (JSONObject) aVar.c(this.j, cVar.d());
        return this;
    }

    public final g b(String str, Object obj) {
        com.tt.android.qualitystat.base.c.c(this.p, str, obj.toString(), 0L, 4, null);
        return this;
    }
}
