package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.VideoModelPb;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoSeekTs {
    public float mOpening = -1.0f;
    public float mEnding = -1.0f;
    private float mOpeningVer2 = -1.0f;
    private float mEndingVer2 = -1.0f;
    private int mVersion = 1;

    static {
        Covode.recordClassIndex(652571);
    }

    public void parseFromPb(VideoModelPb.SeekOffSet seekOffSet) {
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public float getValueFloat(int i) {
        if (this.mVersion == 2) {
            if (i != 0) {
                if (i != 1) {
                    return -1.0f;
                }
                return this.mEndingVer2;
            }
            return this.mOpeningVer2;
        }
        if (i != 0) {
            if (i != 1) {
                return -1.0f;
            }
            return this.mEnding;
        }
        return this.mOpening;
    }

    public void extractFields(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (!jSONObject.has("opening") && !jSONObject.has("ending")) {
            if (jSONObject.has("Ending") || jSONObject.has("Opening")) {
                this.mVersion = 2;
                try {
                    this.mOpeningVer2 = (float) jSONObject.optDouble("Opening");
                    this.mEndingVer2 = (float) jSONObject.optDouble("Ending");
                    return;
                } catch (Exception e) {
                    TTVideoEngineLog.d(e);
                    return;
                }
            }
            return;
        }
        this.mVersion = 1;
        try {
            this.mOpening = (float) jSONObject.optDouble("opening");
            this.mEnding = (float) jSONObject.optDouble("ending");
        } catch (Exception e2) {
            TTVideoEngineLog.d(e2);
        }
    }
}
