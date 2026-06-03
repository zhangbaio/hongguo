package com.ss.videoarch.strategy.strategy.abr;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.utils.JNINamespace;
import org.json.JSONObject;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DecisionMaker {
    static {
        Covode.recordClassIndex(653163);
    }

    private native String nativeMakeDecision(String str);

    private static class a {
        private static final DecisionMaker a;

        static {
            Covode.recordClassIndex(653164);
            a = new DecisionMaker();
        }
    }

    public static DecisionMaker a() {
        return a.a;
    }

    public JSONObject b(JSONObject jSONObject) {
        String nativeMakeDecision = nativeMakeDecision(jSONObject.toString());
        if (nativeMakeDecision != null && !nativeMakeDecision.isEmpty()) {
            try {
                return new JSONObject(nativeMakeDecision);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
