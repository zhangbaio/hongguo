package com.ss.ttvideoengine.playermetrcis;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DiagnoseResult implements IMetricsInfo {
    public int maxValue = 0;
    public int avgValue = 0;
    public int overCount = 0;

    static {
        Covode.recordClassIndex(652596);
    }

    public void reset() {
        this.maxValue = 0;
        this.avgValue = 0;
        this.overCount = 0;
    }

    @Override // com.ss.ttvideoengine.playermetrcis.IMetricsInfo
    public Map<String, Object> getMetricsInfo(String str) {
        HashMap hashMap = new HashMap();
        if (str.equals("pow")) {
            hashMap.put("avg_pow", Integer.valueOf(this.avgValue));
            hashMap.put("max_pow", Integer.valueOf(this.maxValue));
            int i = this.overCount;
            if (i > 0) {
                hashMap.put("over_pow", Integer.valueOf(i));
            }
        } else if (str.equals("mem")) {
            hashMap.put("avg_mem", Integer.valueOf(this.avgValue));
            hashMap.put("max_mem", Integer.valueOf(this.maxValue));
            int i2 = this.overCount;
            if (i2 > 0) {
                hashMap.put("over_mem", Integer.valueOf(i2));
            }
        } else if (str.equals("cpu")) {
            hashMap.put("avg_cpu", Integer.valueOf(this.avgValue));
            hashMap.put("max_cpu", Integer.valueOf(this.maxValue));
            int i3 = this.overCount;
            if (i3 > 0) {
                hashMap.put("over_cpu", Integer.valueOf(i3));
            }
        }
        return hashMap;
    }
}
