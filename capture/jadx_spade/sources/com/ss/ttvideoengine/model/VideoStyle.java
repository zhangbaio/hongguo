package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoStyle {
    private int mVideoStyle = 0;
    private int mDimension = 0;
    private int mProjectionModel = 0;
    private int mViewSize = 0;

    static {
        Covode.recordClassIndex(652572);
    }

    public int getValueInt(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return -1;
                    }
                    return this.mViewSize;
                }
                return this.mProjectionModel;
            }
            return this.mDimension;
        }
        return this.mVideoStyle;
    }

    public void extractFields(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mVideoStyle = jSONObject.optInt("vstyle", 0);
        this.mDimension = jSONObject.optInt("dimension", 0);
        this.mProjectionModel = jSONObject.optInt("projection_model", 0);
        this.mViewSize = jSONObject.optInt("view_size", 0);
    }
}
