package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTSamplingSettingProvider$TTSlaSamplingSetting {
    public int a;
    public int b;
    public TTSamplingSettingProvider$TTSlaSamplingRule c;
    public TTSamplingSettingProvider$TTEventLogSamplingRule d;

    static {
        Covode.recordClassIndex(654535);
    }

    public TTSamplingSettingProvider$TTEventLogSamplingRule getEventLogSamplingRule() {
        return this.d;
    }

    public int getHostAid() {
        return this.a;
    }

    public int getSdkAid() {
        return this.b;
    }

    public TTSamplingSettingProvider$TTSlaSamplingRule getSlaSamplingRule() {
        return this.c;
    }
}
