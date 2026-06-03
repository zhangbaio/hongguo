package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEnginePlayItem {
    public long expire;
    public String playURL;
    public Resolution resolution;
    public String vid;

    static {
        Covode.recordClassIndex(652365);
    }

    public boolean isExpired() {
        if (System.currentTimeMillis() / 1000 > this.expire) {
            return true;
        }
        return false;
    }
}
