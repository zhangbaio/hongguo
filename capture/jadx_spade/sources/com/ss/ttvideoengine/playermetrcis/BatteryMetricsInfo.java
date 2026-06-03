package com.ss.ttvideoengine.playermetrcis;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BatteryMetricsInfo implements IMetricsInfo {
    public int mBatteryUsage = 0;
    public int mLastThermalState = 0;
    public int mLastBatteryLevel = 0;
    public int mCurrentBatteryUse = 0;
    public boolean mLowPowerMode = false;
    public int mPowerState = 0;
    public long mStartPowerTime = 0;
    public long mTotalPowerTime = 0;
    public long mStartCriticalTime = 0;
    public long mTotalCriticalTime = 0;
    public long mStartEmergencyTime = 0;
    public long mTotalEmergencyTime = 0;

    static {
        Covode.recordClassIndex(652594);
    }

    public long getCurCriticalTime() {
        if (this.mStartCriticalTime > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mTotalCriticalTime += currentTimeMillis - this.mStartCriticalTime;
            this.mStartCriticalTime = currentTimeMillis;
        }
        return this.mTotalCriticalTime;
    }

    public long getCurEmergencyTime() {
        if (this.mStartEmergencyTime > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mTotalEmergencyTime += currentTimeMillis - this.mStartEmergencyTime;
            this.mStartEmergencyTime = currentTimeMillis;
        }
        return this.mTotalEmergencyTime;
    }

    @Override // com.ss.ttvideoengine.playermetrcis.IMetricsInfo
    public Map<String, Object> getMetricsInfo(String str) {
        HashMap hashMap = new HashMap();
        if (this.mStartEmergencyTime > 0) {
            hashMap.put("cri_t", Long.valueOf(getCurEmergencyTime()));
        }
        if (this.mStartCriticalTime > 0) {
            hashMap.put("ser_t", Long.valueOf(getCurCriticalTime()));
        }
        if (this.mStartPowerTime > 0) {
            hashMap.put("bu_t", Long.valueOf(this.mTotalPowerTime));
            hashMap.put("bu_l", Integer.valueOf(this.mCurrentBatteryUse));
        }
        return hashMap;
    }
}
