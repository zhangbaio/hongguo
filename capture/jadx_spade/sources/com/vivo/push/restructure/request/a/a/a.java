package com.vivo.push.restructure.request.a.a;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private int a;
    private int b;
    private JSONArray c;

    static {
        Covode.recordClassIndex(655133);
    }

    public a() {
        this.a = 0;
        this.c = new JSONArray();
    }

    public final String e() {
        JSONArray jSONArray = this.c;
        if (jSONArray != null) {
            return jSONArray.toString();
        }
        return "";
    }

    public final int a() throws JSONException {
        int i = this.a;
        if (i < this.b) {
            JSONArray jSONArray = this.c;
            this.a = i + 1;
            return jSONArray.getInt(i);
        }
        return 0;
    }

    public final long b() throws JSONException {
        int i = this.a;
        if (i < this.b) {
            JSONArray jSONArray = this.c;
            this.a = i + 1;
            return jSONArray.getLong(i);
        }
        return 0L;
    }

    public final String c() throws JSONException {
        int i = this.a;
        if (i < this.b) {
            JSONArray jSONArray = this.c;
            this.a = i + 1;
            return jSONArray.getString(i);
        }
        return null;
    }

    public final boolean d() throws JSONException {
        int i = this.a;
        if (i < this.b) {
            JSONArray jSONArray = this.c;
            this.a = i + 1;
            return jSONArray.getBoolean(i);
        }
        return false;
    }

    public final void a(int i) {
        this.c.put(i);
    }

    public final void a(long j) {
        this.c.put(j);
    }

    public a(String str) throws JSONException {
        this.a = 0;
        JSONArray jSONArray = new JSONArray(str);
        this.c = jSONArray;
        this.a = 0;
        this.b = jSONArray.length();
    }

    public final void a(String str) {
        this.c.put(str);
    }

    public final <T extends c> void a(List<T> list) {
        if (list != null) {
            this.c.put(list.size());
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                this.c.put(it2.next().a());
            }
            return;
        }
        this.c.put((Object) null);
    }

    public final void a(boolean z) {
        this.c.put(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends c> void a(c.a<T> aVar, List<T> list) throws JSONException {
        boolean z;
        c cVar;
        int i = this.a;
        if (i < this.b) {
            z = this.c.isNull(i);
        } else {
            z = true;
        }
        if (z) {
            this.a++;
            return;
        }
        JSONArray jSONArray = this.c;
        int i2 = this.a;
        this.a = i2 + 1;
        int i3 = jSONArray.getInt(i2);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.a;
            if (i5 < this.b) {
                JSONArray jSONArray2 = this.c;
                this.a = i5 + 1;
                cVar = aVar.a(jSONArray2.getString(i5));
            } else {
                cVar = null;
            }
            list.add(cVar);
        }
    }
}
