package qj6;

import com.bytedance.covode.number.Covode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends com.ss.videoarch.strategy.log.strategyMonitor.b {
    public int f;
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public String e = "none";
    public String g = "none";
    public String h = "none";

    static {
        Covode.recordClassIndex(653191);
    }

    public a() {
        this.mServiceName = "live_stream_strategy_dns_error_monitor";
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createCategory() {
        try {
            return new JSONObject().put("enable_force_refresh", this.a).put("enable_localDNS_timeout", this.b).put("enable_httpdns", this.c).put("httpdns_type", this.d).put("error_domain", this.e).put("index", this.f).put("error_info", this.h).put("request_id", this.g);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
