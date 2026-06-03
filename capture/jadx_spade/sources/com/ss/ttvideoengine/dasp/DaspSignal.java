package com.ss.ttvideoengine.dasp;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DaspSignal {
    public final String name;
    public final Object value;

    static {
        Covode.recordClassIndex(652416);
    }

    public DaspSignal(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public DaspSignal(String str, double d) {
        this.name = str;
        this.value = Double.valueOf(d);
    }

    public DaspSignal(String str, float f) {
        this.name = str;
        this.value = Float.valueOf(f);
    }

    public DaspSignal(String str, int i) {
        this.name = str;
        this.value = Integer.valueOf(i);
    }

    public DaspSignal(String str, long j) {
        this.name = str;
        this.value = Long.valueOf(j);
    }

    public DaspSignal(String str, boolean z) {
        this.name = str;
        this.value = Boolean.valueOf(z);
    }
}
