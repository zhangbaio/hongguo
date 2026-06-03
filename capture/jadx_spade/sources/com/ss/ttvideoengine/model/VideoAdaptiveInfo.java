package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoAdaptiveInfo {
    private String mAdaptiveType;
    private String mBackupPlayUrl;
    private String mMainPlayUrl;

    static {
        Covode.recordClassIndex(652549);
    }

    public void extractFields(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mAdaptiveType = jSONObject.optString("AdaptiveType");
        this.mMainPlayUrl = jSONObject.optString("MainPlayUrl");
        this.mBackupPlayUrl = jSONObject.optString("BackupPlayUrl");
    }

    public String getValueStr(int i) {
        if (i != 108) {
            if (i != 109) {
                if (i != 215) {
                    return "";
                }
                return this.mAdaptiveType;
            }
            return this.mBackupPlayUrl;
        }
        return this.mMainPlayUrl;
    }
}
