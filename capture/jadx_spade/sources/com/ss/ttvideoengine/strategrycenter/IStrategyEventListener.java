package com.ss.ttvideoengine.strategrycenter;

import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IStrategyEventListener {

    /* renamed from: com.ss.ttvideoengine.strategrycenter.IStrategyEventListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCustomEvent(IStrategyEventListener iStrategyEventListener, String str, String str2, JSONObject jSONObject) {
        }

        public static void $default$onEvent(IStrategyEventListener iStrategyEventListener, String str, int i, int i2, String str2) {
        }
    }

    void onCustomEvent(String str, String str2, JSONObject jSONObject);

    void onEvent(String str, int i, int i2, String str2);
}
