package com.ss.videoarch.liveplayer.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class LiveURL {
    public final String backupURL;
    public final String mainURL;
    public String sdkParams;

    static {
        Covode.recordClassIndex(653062);
    }

    public String getVCodec() {
        JSONObject jSONObject;
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.sdkParams != null) {
            jSONObject = new JSONObject(this.sdkParams);
            if (jSONObject == null && jSONObject.has("VCodec")) {
                String optString = jSONObject.optString("VCodec");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                return optString;
            }
        }
        jSONObject = null;
        return jSONObject == null ? null : null;
    }

    public static LiveURL build(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new LiveURL(jSONObject.optString("main_play_url"), jSONObject.optString("backup_play_url"), jSONObject.optString("SdkParams"));
    }

    public LiveURL(String str, String str2, String str3) {
        this.mainURL = str;
        this.backupURL = str2;
        this.sdkParams = str3;
    }
}
