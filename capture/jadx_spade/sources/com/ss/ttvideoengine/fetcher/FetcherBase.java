package com.ss.ttvideoengine.fetcher;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class FetcherBase {
    private String mFallbackAPI;
    private String mKeyseed;
    private int mVersion;

    static {
        Covode.recordClassIndex(652437);
    }

    public String getFallbackAPI() {
        return this.mFallbackAPI;
    }

    public String getKeyseed() {
        return this.mKeyseed;
    }

    public int getVideoModelVersion() {
        return this.mVersion;
    }

    public FetcherBase(String str, String str2, int i) {
        this.mKeyseed = str;
        this.mFallbackAPI = str2;
        this.mVersion = i;
    }
}
