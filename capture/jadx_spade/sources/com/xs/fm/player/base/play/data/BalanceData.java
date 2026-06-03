package com.xs.fm.player.base.play.data;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BalanceData implements Serializable {
    public float preGain = 0.25f;
    public float ratio = 8.0f;
    public float threshold = -18.0f;
    public float preDelay = 0.007f;
    public int needVolInfoFromStream = 0;

    static {
        Covode.recordClassIndex(655819);
    }

    public boolean isOriginalParam() {
        if (this.preGain == 0.25f && this.ratio == 8.0f && this.threshold == -18.0f && this.preDelay == 0.007f) {
            return true;
        }
        return false;
    }
}
