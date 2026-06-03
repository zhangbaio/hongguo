package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class cc {
    private String a;

    /* renamed from: a, reason: collision with other field name */
    private final ArrayList<cb> f184a = new ArrayList<>();

    static {
        Covode.recordClassIndex(655405);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m226a() {
        return this.a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public ArrayList<cb> m227a() {
        return this.f184a;
    }

    public cc() {
    }

    public synchronized cb a() {
        for (int size = this.f184a.size() - 1; size >= 0; size--) {
            cb cbVar = this.f184a.get(size);
            if (cbVar.m225a()) {
                cf.a().m236a(cbVar.a());
                return cbVar;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<cb> it2 = this.f184a.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
        }
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m228a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cb> it2 = this.f184a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().m223a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public cc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    public synchronized cc a(JSONObject jSONObject) {
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f184a.add(new cb(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized void a(cb cbVar) {
        int i = 0;
        while (true) {
            if (i >= this.f184a.size()) {
                break;
            }
            if (this.f184a.get(i).a(cbVar)) {
                this.f184a.set(i, cbVar);
                break;
            }
            i++;
        }
        if (i >= this.f184a.size()) {
            this.f184a.add(cbVar);
        }
    }

    public synchronized void a(boolean z) {
        for (int size = this.f184a.size() - 1; size >= 0; size--) {
            cb cbVar = this.f184a.get(size);
            if (z) {
                if (cbVar.c()) {
                    this.f184a.remove(size);
                }
            } else if (!cbVar.b()) {
                this.f184a.remove(size);
            }
        }
    }
}
