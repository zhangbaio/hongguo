package com.xs.fm.player.base.play.data;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VoiceBgmInfo implements Serializable {
    public int voiceRate = 100;
    public int bgmRate = 100;
    public int enableDynamicMix = 0;
    public boolean userSetBgm = false;
    public int useRecommendRatio = 0;

    static {
        Covode.recordClassIndex(655824);
    }

    public String toString() {
        return "VoiceBgmInfo{voiceRate=" + this.voiceRate + ", bgmRate=" + this.bgmRate + ", enableDynamicMix=" + this.enableDynamicMix + '}';
    }
}
