package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTSamplingSettingProvider$TTSlaSamplingRule {
    public boolean a;
    public boolean b;
    public String[] c;
    public String[] d;
    public String[] e;
    public String[] f;
    public String[] g;
    public String[] h;
    public String[] i;

    static {
        Covode.recordClassIndex(654534);
    }

    public String[] getHostPatternWhiteList() {
        return this.i;
    }

    public String[] getPathContainWhiteList() {
        return this.e;
    }

    public String[] getPathEqualWhiteList() {
        return this.d;
    }

    public String[] getPathPrefixWhiteList() {
        return this.f;
    }

    public String[] getPathRegexWhiteList() {
        return this.g;
    }

    public String[] getUrlRegexBlackList() {
        return this.c;
    }

    public String[] getUrlRegexWhiteList() {
        return this.h;
    }

    public boolean isEnableApiAllUpload() {
        return this.b;
    }

    public boolean isEnableBaseApiAll() {
        return this.a;
    }
}
