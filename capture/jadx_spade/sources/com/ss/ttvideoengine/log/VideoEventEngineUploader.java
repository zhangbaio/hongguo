package com.ss.ttvideoengine.log;

import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface VideoEventEngineUploader {
    void onEvent(String str, JSONObject jSONObject);

    void onEventV2(String str, JSONObject jSONObject);
}
