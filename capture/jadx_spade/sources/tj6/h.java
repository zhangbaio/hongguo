package tj6;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h implements c {
    private final String b;
    private final sj6.b c;
    private final int d;
    private final long e;
    private final long f;
    private final String g;
    private final int h;
    private final int i;
    private final JSONObject j;
    private final long k;

    static {
        Covode.recordClassIndex(654074);
    }

    @Override // tj6.c
    public int a() {
        return this.i;
    }

    @Override // tj6.c
    public JSONObject d() {
        return this.j;
    }

    @Override // tj6.c
    public int getDataType() {
        return this.d;
    }

    @Override // tj6.c
    public int getDuration() {
        return this.h;
    }

    @Override // tj6.c
    public long getErrorType() {
        return this.f;
    }

    @Override // tj6.c
    public String getEventName() {
        return this.b;
    }

    @Override // tj6.c
    public sj6.b getScene() {
        return this.c;
    }

    @Override // tj6.c
    public long getStatus() {
        return this.e;
    }

    @Override // tj6.c
    public long getTimestamp() {
        return this.k;
    }

    @Override // tj6.c
    public String v() {
        return this.g;
    }

    @Override // tj6.b
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("event_name", getEventName());
        jSONObject.putOpt("scene", getScene().getMainScene());
        jSONObject.putOpt("sub_scene", sj6.c.e(getScene()));
        sj6.b scene = getScene();
        String str = null;
        if (!(scene instanceof sj6.b)) {
            scene = null;
        }
        if (scene != null) {
            str = scene.getDetailScene();
        }
        jSONObject.putOpt("detail_scene", str);
        jSONObject.putOpt("status", Long.valueOf(getStatus()));
        jSONObject.putOpt("error_type", Long.valueOf(getErrorType()));
        jSONObject.putOpt("duration", Integer.valueOf(getDuration()));
        jSONObject.putOpt("data_type", Integer.valueOf(getDataType()));
        jSONObject.putOpt("duration_type", v());
        jSONObject.putOpt("sampling_type", Integer.valueOf(a()));
        jSONObject.putOpt("stay_info", d());
        return jSONObject;
    }

    public h(String str, sj6.b bVar, int i, long j, long j2, String str2, int i2, int i3, JSONObject jSONObject, long j3) {
        this.b = str;
        this.c = bVar;
        this.d = i;
        this.e = j;
        this.f = j2;
        this.g = str2;
        this.h = i2;
        this.i = i3;
        this.j = jSONObject;
        this.k = j3;
    }
}
