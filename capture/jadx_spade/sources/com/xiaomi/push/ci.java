package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ci implements Comparable<ci> {
    protected int a;

    /* renamed from: a, reason: collision with other field name */
    private long f198a;

    /* renamed from: a, reason: collision with other field name */
    String f199a;

    /* renamed from: a, reason: collision with other field name */
    private final LinkedList<ca> f200a;

    static {
        Covode.recordClassIndex(655414);
    }

    public ci() {
        this(null, 0);
    }

    public String toString() {
        return this.f199a + ":" + this.a;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f198a);
        jSONObject.put("wt", this.a);
        jSONObject.put("host", this.f199a);
        JSONArray jSONArray = new JSONArray();
        Iterator<ca> it2 = this.f200a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().m221a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public ci(String str) {
        this(str, 0);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ci ciVar) {
        if (ciVar == null) {
            return 1;
        }
        return ciVar.a - this.a;
    }

    public synchronized ci a(JSONObject jSONObject) {
        this.f198a = jSONObject.getLong("tt");
        this.a = jSONObject.getInt("wt");
        this.f199a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f200a.add(new ca().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    protected synchronized void a(ca caVar) {
        if (caVar != null) {
            this.f200a.add(caVar);
            int a = caVar.a();
            if (a > 0) {
                this.a += caVar.a();
            } else {
                int i = 0;
                for (int size = this.f200a.size() - 1; size >= 0 && this.f200a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f200a.size() > 30) {
                this.a -= this.f200a.remove().a();
            }
        }
    }

    public ci(String str, int i) {
        this.f200a = new LinkedList<>();
        this.f198a = 0L;
        this.f199a = str;
        this.a = i;
    }
}
