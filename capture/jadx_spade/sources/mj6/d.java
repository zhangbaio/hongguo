package mj6;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d {
    public JSONArray A;
    public JSONArray B;
    public JSONArray C;
    public String a = "StrategyConfigInfo";
    public String b = "";
    public long c = 0;
    public String d = "none";
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public JSONObject h = null;
    public JSONArray i = null;
    public JSONArray j = null;
    public JSONObject k = null;
    public JSONObject l = null;
    public JSONArray m = null;
    public JSONArray n = null;
    public JSONObject o = null;
    public JSONObject p = null;
    public JSONObject q = null;
    public int r = -1;
    public JSONObject s = new JSONObject();
    public JSONArray t;
    public JSONArray u;
    public JSONArray v;
    public JSONArray w;
    public JSONArray x;
    public JSONArray y;
    public JSONArray z;

    static {
        Covode.recordClassIndex(653119);
    }

    public void a() {
        String string;
        JSONObject optJSONObject;
        if (lj6.a.m().n != null) {
            if (lj6.a.m().n.has(this.b)) {
                JSONObject optJSONObject2 = lj6.a.m().n.optJSONObject(this.b);
                if (optJSONObject2 != null) {
                    if (optJSONObject2.has("StrategyID")) {
                        this.c = optJSONObject2.optLong("StrategyID");
                    }
                    this.e = optJSONObject2.optInt("Enable");
                    this.f = optJSONObject2.optInt("EnableSmartStrategyConfig");
                    this.g = optJSONObject2.optInt("EnableCloudStrategyModel");
                    this.h = optJSONObject2.optJSONObject("InputSettingsParam");
                    if (optJSONObject2.has("FeatureSampleConfig")) {
                        this.k = optJSONObject2.optJSONObject("FeatureSampleConfig");
                    } else {
                        this.k = this.q;
                    }
                    this.l = optJSONObject2.optJSONObject("GroundTruthRule");
                    if (optJSONObject2.has("InputFeatureList")) {
                        this.j = optJSONObject2.optJSONArray("InputFeatureList");
                    } else {
                        this.j = this.m;
                    }
                } else {
                    this.j = this.m;
                    this.k = this.q;
                }
            } else {
                this.j = this.m;
                this.k = this.q;
            }
        }
        if (lj6.a.m().r.e.mPitayaABSettingsJSON != null && lj6.a.m().r.e.mPitayaABSettingsJSON.has(this.b) && (optJSONObject = lj6.a.m().r.e.mPitayaABSettingsJSON.optJSONObject(this.b)) != null && optJSONObject.has("package_name")) {
            this.d = optJSONObject.optString("package_name");
        }
        Log.d(this.a, "strategy name:" + this.b + ",PiatayABPackageName:" + this.d);
        Log.d(this.a, "strategy name:" + this.b + ",inputFeatureList:" + this.j);
        JSONArray jSONArray = this.j;
        if (jSONArray == null) {
            return;
        }
        if (this.i != null && jSONArray.toString().equals(this.i.toString())) {
            return;
        }
        this.i = this.j;
        this.t = new JSONArray();
        this.u = new JSONArray();
        this.v = new JSONArray();
        this.w = new JSONArray();
        this.x = new JSONArray();
        this.y = new JSONArray();
        this.z = new JSONArray();
        this.A = new JSONArray();
        this.B = new JSONArray();
        this.C = new JSONArray();
        for (int i = 0; i < this.j.length(); i++) {
            try {
                string = this.j.getString(i);
                String b = b.b(string);
                Log.d(this.a, "featureName:" + string + " featureType:" + b);
                b.hashCode();
                switch (b) {
                    case "NETWORK":
                        if (com.ss.videoarch.strategy.featureCenter.featureType.c.d().b != null && com.ss.videoarch.strategy.featureCenter.featureType.c.d().b.f != null && com.ss.videoarch.strategy.featureCenter.featureType.c.d().b.f.contains(string)) {
                            this.w.put(string);
                            break;
                        } else {
                            this.v.put(string);
                            break;
                        }
                        break;
                    case "PLAY":
                        if (TypePlayFeaturesCollector.h().b != null && TypePlayFeaturesCollector.h().b.f != null && TypePlayFeaturesCollector.h().b.f.contains(string)) {
                            this.u.put(string);
                            break;
                        } else {
                            this.t.put(string);
                            break;
                        }
                        break;
                    case "PUSH":
                        if (com.ss.videoarch.strategy.featureCenter.featureType.d.e().b != null && com.ss.videoarch.strategy.featureCenter.featureType.d.e().b.f != null && com.ss.videoarch.strategy.featureCenter.featureType.d.e().b.f.contains(string)) {
                            this.C.put(string);
                            break;
                        } else {
                            this.B.put(string);
                            break;
                        }
                        break;
                    case "USER":
                    case "ANCHOR":
                        if (e.e().b != null && e.e().b.f != null && e.e().b.f.contains(string)) {
                            this.A.put(string);
                            break;
                        } else {
                            this.z.put(string);
                            break;
                        }
                        break;
                    case "DEVICE":
                        if (com.ss.videoarch.strategy.featureCenter.featureType.b.f().b != null && com.ss.videoarch.strategy.featureCenter.featureType.b.f().b.f != null && com.ss.videoarch.strategy.featureCenter.featureType.b.f().b.f.contains(string)) {
                            this.y.put(string);
                            break;
                        } else {
                            this.x.put(string);
                            break;
                        }
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            this.s.put("PlayFeaturesBundle", this.t).put("RTPlayFeaturesBundle", this.u).put("NetworkFeaturesBundle", this.v).put("RTNetworkFeaturesBundle", this.w).put("DeviceFeaturesBundle", this.x).put("RTDeviceFeaturesBundle", this.y).put("UserFeaturesBundle", this.z).put("RTUserFeaturesBundle", this.A).put("PushFeaturesBundle", this.B).put("RTPushFeaturesBundle", this.C);
            Log.d(this.a, "mFeaturesBundle" + this.s);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
