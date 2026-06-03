package com.ss.videoarch.liveplayer;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IABRObserver {
    void o(o oVar, s sVar, s sVar2, JSONObject jSONObject);

    SwitchPermissionRequestResult s(o oVar, s sVar, s sVar2, JSONObject jSONObject);

    public enum StrategySubtype {
        FakeResolution;

        static {
            Covode.recordClassIndex(652906);
        }
    }

    public enum StrategyType {
        Performance,
        Bandwidth,
        Quality;

        static {
            Covode.recordClassIndex(652907);
        }
    }

    public enum SwitchPermissionRequestResult {
        APPROVED,
        REJECTED_FOR_FIXED_RESOLUTION,
        REJECTED_FOR_FIXED_SUGGESTED_RESOLUTION_INVALID;

        static {
            Covode.recordClassIndex(652908);
        }
    }
}
