package com.ss.videoarch.liveplayer.model;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    public String a;
    public String b;
    public LiveStreamInfo c;

    static {
        Covode.recordClassIndex(653059);
    }

    public b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("options").getJSONObject("default_quality");
            this.a = jSONObject2.getString("name");
            this.b = jSONObject2.getString("sdk_key");
            this.c = new LiveStreamInfo(new JSONObject(jSONObject.getString("stream_data")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
