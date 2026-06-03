package mj6;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    public String a = "";
    public JSONArray b = null;
    public JSONArray c = null;
    public JSONArray d = null;
    public JSONArray e = null;
    public String f = "";
    public JSONObject g = null;
    public JSONObject h = null;

    static {
        Covode.recordClassIndex(653117);
    }

    public void c() {
        if (lj6.a.m().Q == 1) {
            if (lj6.a.m().o == null) {
                Log.d("FeatureConfigInfo", "No FeatureConfig");
                return;
            } else {
                SettingsManager.getInstance().getFeatureConfig(String.valueOf(lj6.a.m().o), this);
                return;
            }
        }
        a();
    }

    public void a() {
        if (lj6.a.m().o != null) {
            if (lj6.a.m().o.has(this.a)) {
                JSONObject optJSONObject = lj6.a.m().o.optJSONObject(this.a);
                if (optJSONObject != null) {
                    if (optJSONObject.has("FeatureList")) {
                        this.b = optJSONObject.optJSONArray("FeatureList");
                    } else {
                        this.b = this.c;
                    }
                    if (optJSONObject.has("RTFeatureList")) {
                        this.d = optJSONObject.optJSONArray("RTFeatureList");
                    } else {
                        this.d = this.e;
                    }
                    JSONArray jSONArray = this.d;
                    if (jSONArray != null) {
                        this.f = jSONArray.toString();
                    }
                    if (optJSONObject.has("FeaturesCollectRules")) {
                        this.g = optJSONObject.optJSONObject("FeaturesCollectRules");
                        return;
                    } else {
                        this.g = this.h;
                        return;
                    }
                }
                this.b = this.c;
                this.g = this.h;
                return;
            }
            this.b = this.c;
            this.g = this.h;
        }
    }

    public static String b(String str) {
        Log.d("FeatureConfigInfo", "featureName:" + str);
        String str2 = "UNKNOWN";
        if (str != null) {
            int indexOf = str.indexOf("-");
            if (indexOf > 0) {
                str2 = str.substring(0, indexOf);
            }
            Log.d("FeatureConfigInfo", "endIndex:" + indexOf + "featureName.substring(0, endIndex):" + str2);
        }
        return str2;
    }
}
