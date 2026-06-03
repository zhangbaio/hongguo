package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SubModel implements SubModelProvider {
    private final long mExpireTime;
    private final String mFormat;
    private final int mIndex;
    private final String mLanguage;
    private final int mLanguageId;
    private final int mSubId;
    private final String mUrlString;

    static {
        Covode.recordClassIndex(652321);
    }

    public long getExpireTime() {
        return this.mExpireTime;
    }

    public String getFormat() {
        return this.mFormat;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public int getLanguageId() {
        return this.mLanguageId;
    }

    public int getSubId() {
        return this.mSubId;
    }

    public String getUrlString() {
        return this.mUrlString;
    }

    @Override // com.ss.ttvideoengine.SubModelProvider
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.mUrlString);
            jSONObject.put("language_id", this.mLanguageId);
            jSONObject.put("format", this.mFormat);
            jSONObject.put("language", this.mLanguage);
            jSONObject.put("id", this.mIndex);
            jSONObject.put("expire", this.mExpireTime);
            jSONObject.put("sub_id", this.mSubId);
        } catch (JSONException e) {
            TTVideoEngineLog.d(e);
        }
        return jSONObject;
    }

    @Override // com.ss.ttvideoengine.SubModelProvider
    public String toString() {
        JSONObject json = toJson();
        if (json == null || !json.has("url") || !json.has("language_id") || !json.has("format") || !json.has("sub_id")) {
            return null;
        }
        return json.toString();
    }

    public SubModel(JSONObject jSONObject) {
        this.mUrlString = jSONObject.optString("url");
        this.mLanguageId = jSONObject.optInt("language_id");
        this.mFormat = jSONObject.optString("format");
        this.mLanguage = jSONObject.optString("language");
        this.mIndex = jSONObject.optInt("id");
        this.mExpireTime = jSONObject.optLong("expire");
        this.mSubId = jSONObject.optInt("sub_id");
    }
}
