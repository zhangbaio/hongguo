package qj6;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d extends com.ss.videoarch.strategy.log.strategyMonitor.b {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public long d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public List<String> j = new ArrayList();
    public String k = "none";
    public String l = "none";
    public String m = "none";
    public String n = "none";

    static {
        Covode.recordClassIndex(653201);
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createMetric() {
        try {
            return new JSONObject().put("sdk_start_cost", this.d);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public d() {
        this.mServiceName = "live_stream_strategy_node_optimize_service_monitor";
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createCategory() {
        try {
            return new JSONObject().put("is_hit", this.a).put("hit_type", this.k).put("index", this.b).put("caller", this.c).put("domain", this.l).put("return_ip", this.m).put("has_domain_list", this.e).put("host_in_domain_list", this.f).put("host_has_local_dns_result", this.g).put("has_reset", this.h).put("retry_failed", this.i).put("stream_session_vv_id", this.n).put("force_dns_host", this.j);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
