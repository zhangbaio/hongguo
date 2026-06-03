package com.ss.videoarch.strategy.log.strategyMonitor;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.NativeObject;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends NativeObject {
    public static String MONITOR_QUERY_OPERATE;
    public static String MONITOR_UPDATE_OPERATE;
    protected String mServiceName = null;
    private JSONObject mCategoryLog = null;
    private JSONObject mMetricLog = null;
    private JSONObject mLogExtrLog = null;

    public JSONObject createCategory() {
        return null;
    }

    public JSONObject createLogExtrLog() {
        return null;
    }

    public JSONObject createMetric() {
        return null;
    }

    public int strategyCode() {
        return -1;
    }

    static {
        Covode.recordClassIndex(653144);
        MONITOR_UPDATE_OPERATE = "Update";
        MONITOR_QUERY_OPERATE = "Query";
    }

    public void uploadMonitorLog() {
        if (lj6.a.m().r.e.mEnableUploadStrategyMonitorLog != 1) {
            return;
        }
        this.mCategoryLog = createCategory();
        this.mMetricLog = createMetric();
        Log.d("BaseStrategyMonitor", "serviceName:" + this.mServiceName + " categoryLog:" + this.mCategoryLog + " metricLog:" + this.mMetricLog + " logExtra:" + this.mLogExtrLog);
        String str = this.mServiceName;
        if (str != null) {
            oj6.a.c(str, this.mCategoryLog, this.mMetricLog, this.mLogExtrLog);
        }
    }
}
