package com.ss.videoarch.liveplayer;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r {
    public boolean a = false;
    public boolean b = true;
    public int c = 5000;
    public int d = 5000;
    public int e = 5;
    public boolean f = false;
    public boolean g = false;
    public int h = 5;
    public String i = "";
    public long j = 60000;

    static {
        Covode.recordClassIndex(652952);
    }

    public String toString() {
        return "VeLivePlayerConfiguration{enableSei=" + this.a + ", enableHardwareDecode=" + this.b + ", networkTimeoutMs=" + this.c + ", retryIntervalTimeMs=" + this.d + ", retryMaxCount=" + this.e + ", enableLiveDNS=" + this.f + ", enableStatisticsCallback=" + this.g + ", statisticsCallbackInterval=" + this.h + '}';
    }
}
