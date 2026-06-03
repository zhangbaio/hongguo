package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LiveVideoRef {
    public int mBackupStatus;
    public long mEndTime;
    public String mLiveId;
    public int mLiveStatus;
    public LiveVideoInfo mLiveVideo1;
    public LiveVideoInfo mLiveVideo2;
    public long mStartTime;
    public int mStatus;
    public String mUserId;

    static {
        Covode.recordClassIndex(652545);
    }

    public LiveVideoInfo getLiveVideoInfo() {
        LiveVideoInfo liveVideoInfo = this.mLiveVideo1;
        if (liveVideoInfo != null) {
            return liveVideoInfo;
        }
        LiveVideoInfo liveVideoInfo2 = this.mLiveVideo2;
        if (liveVideoInfo2 != null) {
            return liveVideoInfo2;
        }
        return null;
    }

    public void extractFields(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("live_info");
        try {
            if (optJSONObject.has("live_0")) {
                LiveVideoInfo liveVideoInfo = new LiveVideoInfo();
                this.mLiveVideo1 = liveVideoInfo;
                liveVideoInfo.extractFields(optJSONObject.getJSONObject("live_0"));
            }
            if (optJSONObject.has("live_1")) {
                LiveVideoInfo liveVideoInfo2 = new LiveVideoInfo();
                this.mLiveVideo2 = liveVideoInfo2;
                liveVideoInfo2.extractFields(optJSONObject.getJSONObject("live_1"));
            }
            this.mBackupStatus = optJSONObject.optInt("backup_status");
            this.mLiveStatus = optJSONObject.optInt("live_status");
            this.mStatus = optJSONObject.optInt("status");
            this.mStartTime = optJSONObject.optLong("start_time");
            this.mEndTime = optJSONObject.optLong("end_time");
        } catch (JSONException e) {
            TTVideoEngineLog.d(e);
        }
        this.mUserId = jSONObject.optString("user_id");
        this.mLiveId = jSONObject.optString("live_id");
    }
}
