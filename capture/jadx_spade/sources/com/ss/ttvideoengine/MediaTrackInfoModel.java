package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MediaTrackInfoModel implements MediaTrackInfoModelProvider {
    private final String mGroupId;
    private final int mIndex;
    private final String mLanguage;
    private final String mName;
    private final int mType;

    static {
        Covode.recordClassIndex(652298);
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getName() {
        return this.mName;
    }

    public int getType() {
        return this.mType;
    }

    @Override // com.ss.ttvideoengine.MediaTrackInfoModelProvider
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("index", this.mIndex);
            jSONObject.put("type", this.mType);
            jSONObject.put("language", this.mLanguage);
            jSONObject.put("name", this.mName);
            jSONObject.put("group_id", this.mGroupId);
        } catch (JSONException e) {
            TTVideoEngineLog.d(e);
        }
        return jSONObject;
    }

    public MediaTrackInfoModel(JSONObject jSONObject) {
        this.mIndex = jSONObject.optInt("index");
        this.mType = jSONObject.optInt("type");
        this.mLanguage = jSONObject.optString("language");
        this.mName = jSONObject.optString("name");
        this.mGroupId = jSONObject.optString("group_id");
    }
}
