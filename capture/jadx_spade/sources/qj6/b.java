package qj6;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends com.ss.videoarch.strategy.log.strategyMonitor.b {
    public long a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public String k = "none";
    public List<String> l = new ArrayList();
    public Set<String> m = new HashSet();

    static {
        Covode.recordClassIndex(653199);
    }

    public b() {
        this.mServiceName = "live_stream_strategy_node_optimize";
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createMetric() {
        try {
            return new JSONObject().put("cur_total_dns_cost", this.a).put("cur_need_dns_total_domain_cnt", this.b).put("cur_domain_cnt", this.c);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createCategory() {
        try {
            return new JSONObject().put("enable_force_refresh", this.d).put("enable_localDNS_timeout", this.e).put("enable_httpdns", this.f).put("enable_topn", this.j).put("httpdns_type", this.g).put("index", this.h).put("request_id", this.k).put("is_timeout", this.i).put("localdns_host", this.m);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
