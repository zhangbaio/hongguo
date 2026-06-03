package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ca {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private long f178a;

    /* renamed from: a, reason: collision with other field name */
    private String f179a;
    private long b;
    private long c;

    static {
        Covode.recordClassIndex(655403);
    }

    public int a() {
        return this.a;
    }

    public ca() {
        this(0, 0L, 0L, null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public JSONObject m221a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f178a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f179a);
        return jSONObject;
    }

    public ca a(JSONObject jSONObject) {
        this.f178a = jSONObject.getLong("cost");
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f179a = jSONObject.optString("expt");
        return this;
    }

    public ca(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f178a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f179a = exc.getClass().getSimpleName();
        }
    }
}
