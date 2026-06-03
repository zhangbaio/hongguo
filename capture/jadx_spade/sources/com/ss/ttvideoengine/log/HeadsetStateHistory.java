package com.ss.ttvideoengine.log;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.log.HeadsetStateMonitor;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class HeadsetStateHistory implements HeadsetStateMonitor.HeadsetStateChangedListener {
    private final HeadsetStateMonitor mHeadsetStateMonitor;
    private volatile long mLastSwitchTime = 0;
    private final ArrayList<String> mConnectionHistoryList = new ArrayList<>();

    static {
        Covode.recordClassIndex(652468);
    }

    public long getLastSwitchTime() {
        return this.mLastSwitchTime;
    }

    public ArrayList<String> get() {
        return new ArrayList<>(this.mConnectionHistoryList);
    }

    public void reset() {
        this.mLastSwitchTime = 0L;
        this.mConnectionHistoryList.clear();
    }

    public void start() {
        this.mHeadsetStateMonitor.addStateChangedListener(this);
        TTVideoEngineLog.d("HeadsetStateHistory", "start");
    }

    public void stop() {
        this.mHeadsetStateMonitor.removeStateChangedListener(this);
        TTVideoEngineLog.d("HeadsetStateHistory", "stop");
    }

    public HeadsetStateHistory(HeadsetStateMonitor headsetStateMonitor) {
        this.mHeadsetStateMonitor = headsetStateMonitor;
    }

    @Override // com.ss.ttvideoengine.log.HeadsetStateMonitor.HeadsetStateChangedListener
    public void onHeadsetStateChanged(boolean z, boolean z2) {
        this.mLastSwitchTime = System.currentTimeMillis();
        addToHistory(z, z2);
    }

    private void addToHistory(boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("bt", Integer.valueOf(z2 ? 1 : 0));
        hashMap.put("con", Integer.valueOf(z ? 1 : 0));
        this.mConnectionHistoryList.add(new JSONObject(hashMap).toString());
    }
}
