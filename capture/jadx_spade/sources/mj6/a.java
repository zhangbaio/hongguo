package mj6;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel.LSStrategySDKSettings;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    public String a = "CommonConfigInfo";
    public JSONObject b = new JSONObject();
    public JSONObject c = new JSONObject();
    public JSONObject d = null;
    public LSStrategySDKSettings e = new LSStrategySDKSettings();

    static {
        Covode.recordClassIndex(653116);
    }

    public void a() {
        if (lj6.a.m().p != null) {
            if (lj6.a.m().p.has("LSStrategySDKSettings")) {
                this.b = lj6.a.m().p.optJSONObject("LSStrategySDKSettings");
                this.e = new LSStrategySDKSettings(this.b);
            }
            if (lj6.a.m().p.has("LivePlayerSettings")) {
                this.c = lj6.a.m().p.optJSONObject("LivePlayerSettings");
            }
            if (lj6.a.m().p.has("RTMPlayer")) {
                this.d = lj6.a.m().p.optJSONObject("RTMPlayer");
            }
        }
        Log.d(this.a, "LSStrategySDKSettings: " + this.b + ", LivePlayerSettings: " + this.c + ", RTMPlayerSettings: " + this.d);
    }
}
