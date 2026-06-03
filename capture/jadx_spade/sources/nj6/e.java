package nj6;

import com.bytedance.covode.number.Covode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e extends com.ss.videoarch.strategy.log.strategyMonitor.b {
    private static volatile e i;
    public String a = "none";
    public String b = "none";
    public String c = "none";
    public String d = "none";
    public int e = 0;
    public int f = 0;
    public long g = -1;
    public long h = -1;

    static {
        Covode.recordClassIndex(653128);
        i = null;
    }

    public e() {
        this.mServiceName = "live_stream_strategy_sqlite_data_monitor";
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createMetric() {
        try {
            return new JSONObject().put("operate_cost", this.g);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.b
    public JSONObject createCategory() {
        try {
            return new JSONObject().put("table_name", this.a).put("operate", this.b).put("operate_info", this.c).put("index", this.e).put("is_success", this.h).put("extra_info", this.d);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str, String str2, String str3, long j, long j2, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.e++;
        this.h = j;
        this.g = System.currentTimeMillis() - j2;
        this.d = str4;
    }
}
