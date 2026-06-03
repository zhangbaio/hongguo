package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SubInfo {
    private String mFormat;
    private int mLanguageId;
    private int mSubId;
    private String mVersion;

    static {
        Covode.recordClassIndex(652547);
    }

    public int getValueInt(int i) {
        if (i != 0) {
            if (i != 1) {
                return -1;
            }
            return this.mLanguageId;
        }
        return this.mSubId;
    }

    public String getValueStr(int i) {
        if (i != 2) {
            if (i != 3) {
                return "";
            }
            return this.mVersion;
        }
        return this.mFormat;
    }

    public void extractFields(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mSubId = jSONObject.optInt("sub_id");
        this.mLanguageId = jSONObject.optInt("language_id");
        this.mFormat = jSONObject.optString("format");
        this.mVersion = jSONObject.optString(Constants.VERSION);
    }
}
