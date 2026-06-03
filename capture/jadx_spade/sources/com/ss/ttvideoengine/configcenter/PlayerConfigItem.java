package com.ss.ttvideoengine.configcenter;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayerConfigItem extends ConfigItem {
    protected int batchExecuteStage;

    static {
        Covode.recordClassIndex(652414);
    }

    public PlayerConfigItem(int i, Object obj, int i2) {
        super(i, obj, 0, i2, 1);
        this.batchExecuteStage = 0;
    }

    public PlayerConfigItem(int i, Object obj, int i2, int i3) {
        super(i, obj, 0, i2, 1);
        this.batchExecuteStage = i3;
    }
}
