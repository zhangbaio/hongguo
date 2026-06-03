package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StrategyMediaParam {
    public String sceneId;
    public int type;
    public String videoId;

    static {
        Covode.recordClassIndex(652723);
    }

    public StrategyMediaParam(String str, String str2, int i) {
        this.videoId = str;
        this.sceneId = str2;
        this.type = i;
    }
}
