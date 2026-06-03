package tj6;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i implements d {
    private final String b;
    private final String c;
    private final Integer d;
    private final JSONObject e;
    private final JSONObject f;

    static {
        Covode.recordClassIndex(654075);
    }

    @Override // tj6.d
    public Integer f() {
        return this.d;
    }

    @Override // tj6.d
    public String getDescription() {
        return this.b;
    }

    @Override // tj6.d
    public String j() {
        return this.c;
    }

    @Override // tj6.d
    public JSONObject n() {
        return this.e;
    }

    @Override // tj6.d
    public JSONObject u() {
        return this.f;
    }

    @Override // tj6.b
    public JSONObject toJsonObject() {
        return com.tt.android.qualitystat.base.c.c(com.tt.android.qualitystat.base.c.c(com.tt.android.qualitystat.base.c.c(com.tt.android.qualitystat.base.c.c(com.tt.android.qualitystat.base.c.c(new com.tt.android.qualitystat.base.c(0L, 1, null), "description", getDescription(), 0L, 4, null), "description_type", j(), 0L, 4, null), "description_code", f(), 0L, 4, null), "net_info", n(), 0L, 4, null), "extra", u(), 0L, 4, null).a;
    }

    public i(String str, String str2, Integer num, JSONObject jSONObject, JSONObject jSONObject2) {
        this.b = str;
        this.c = str2;
        this.d = num;
        this.e = jSONObject;
        this.f = jSONObject2;
    }
}
