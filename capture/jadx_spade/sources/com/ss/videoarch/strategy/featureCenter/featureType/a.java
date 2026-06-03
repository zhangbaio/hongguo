package com.ss.videoarch.strategy.featureCenter.featureType;

import com.bytedance.covode.number.Covode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    protected String a = "BaseType";
    public mj6.b b = new mj6.b();

    static {
        Covode.recordClassIndex(653134);
    }

    public void b() {
        mj6.b bVar = this.b;
        if (bVar != null) {
            bVar.c();
        }
    }

    protected int a(String str) {
        JSONObject jSONObject;
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.optInt("net_effective_connection_type");
    }
}
