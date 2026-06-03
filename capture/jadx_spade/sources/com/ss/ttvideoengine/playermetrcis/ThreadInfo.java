package com.ss.ttvideoengine.playermetrcis;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ThreadInfo {
    public HashMap<String, Object> mMutiThreadUsage;
    public String pid;
    public String pidName;
    public HashSet<String> pids;
    public long cpuTime = -1;
    public long currentTime = 0;
    public long cpuTimeStart = 0;
    public float cpuUsage = -1.0f;
    public int type = 1;

    static {
        Covode.recordClassIndex(652602);
    }

    public void reset() {
        this.currentTime = 0L;
        this.cpuTimeStart = 0L;
        this.cpuUsage = -1.0f;
        this.cpuTime = 0L;
    }

    public String toString() {
        return "ProcInfo{pidName='" + this.pidName + "', pid=" + this.pid + ", cpuTime=" + this.cpuTime + ", currentTime=" + this.currentTime + '}';
    }
}
