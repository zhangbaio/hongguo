package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import org.json.JSONArray;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class be extends JSONArray implements bd {
    private int a = 2;

    static {
        Covode.recordClassIndex(655373);
    }

    @Override // com.xiaomi.push.bd
    public int a() {
        return this.a + (length() - 1);
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof bd) {
            this.a += ((bd) obj).a();
        }
        return super.put(obj);
    }
}
