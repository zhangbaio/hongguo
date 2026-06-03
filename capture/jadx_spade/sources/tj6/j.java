package tj6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j implements e, c, d {
    private final c b;
    private final d c;
    private final JSONObject d;

    static {
        Covode.recordClassIndex(654076);
    }

    @Override // tj6.c
    public int a() {
        return this.b.a();
    }

    @Override // tj6.c
    public JSONObject d() {
        return this.b.d();
    }

    @Override // tj6.d
    public Integer f() {
        return this.c.f();
    }

    @Override // tj6.c
    public int getDataType() {
        return this.b.getDataType();
    }

    @Override // tj6.d
    public String getDescription() {
        return this.c.getDescription();
    }

    @Override // tj6.c
    public int getDuration() {
        return this.b.getDuration();
    }

    @Override // tj6.c
    public long getErrorType() {
        return this.b.getErrorType();
    }

    @Override // tj6.c
    public String getEventName() {
        return this.b.getEventName();
    }

    @Override // tj6.c
    public sj6.b getScene() {
        return this.b.getScene();
    }

    @Override // tj6.c
    public long getStatus() {
        return this.b.getStatus();
    }

    @Override // tj6.c
    public long getTimestamp() {
        return this.b.getTimestamp();
    }

    @Override // tj6.d
    public String j() {
        return this.c.j();
    }

    @Override // tj6.d
    public JSONObject n() {
        return this.c.n();
    }

    @Override // tj6.d
    public JSONObject u() {
        return this.c.u();
    }

    @Override // tj6.c
    public String v() {
        return this.b.v();
    }

    public JSONObject A() {
        return this.d;
    }

    public String toString() {
        String jSONObject = toJsonObject().toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJsonObject().toString()");
        return jSONObject;
    }

    @Override // tj6.b
    public JSONObject toJsonObject() {
        return com.tt.android.qualitystat.base.c.d(com.tt.android.qualitystat.base.c.d(new com.tt.android.qualitystat.base.c(0L, 1, null), this.b.toJsonObject(), 0L, 2, null), this.c.toJsonObject(), 0L, 2, null).b(A(), 1L).a;
    }

    public j(c cVar, d dVar, JSONObject jSONObject) {
        this.b = cVar;
        this.c = dVar;
        this.d = jSONObject;
    }
}
