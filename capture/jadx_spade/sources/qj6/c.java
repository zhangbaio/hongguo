package qj6;

import com.bytedance.covode.number.Covode;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c extends com.ss.videoarch.strategy.log.strategyMonitor.b {
    public int a = -1;
    public long b = 0;
    public Set<String> c = new HashSet();

    static {
        Covode.recordClassIndex(653200);
    }

    public c() {
        this.mServiceName = "live_stream_strategy_node_optimize";
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createCategory() {
        try {
            return new JSONObject().put("enable_topn", this.a).put("pre_dns_host", this.c);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createMetric() {
        try {
            return new JSONObject().put("pre_dns_cost", this.b);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
