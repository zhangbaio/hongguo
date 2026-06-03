package com.ss.ttvideoengine.configcenter;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ConfigCenter {
    static {
        Covode.recordClassIndex(652401);
    }

    private ConfigCenter() {
    }

    public void updateVodSettings(String str, JSONObject jSONObject) {
    }

    private static final class InstanceHolder {
        private static final ConfigCenter INSTANCE;

        private InstanceHolder() {
        }

        static {
            Covode.recordClassIndex(652402);
            INSTANCE = new ConfigCenter();
        }
    }

    public static ConfigCenter getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
