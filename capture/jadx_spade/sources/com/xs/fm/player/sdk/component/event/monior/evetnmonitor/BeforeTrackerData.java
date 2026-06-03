package com.xs.fm.player.sdk.component.event.monior.evetnmonitor;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class BeforeTrackerData implements Serializable {
    private long jumpAudioPageTime;
    private String openAudioPageFrom = "";

    static {
        Covode.recordClassIndex(655894);
    }

    public final long getJumpAudioPageTime() {
        return this.jumpAudioPageTime;
    }

    public final String getOpenAudioPageFrom() {
        return this.openAudioPageFrom;
    }

    public String toString() {
        return "BeforeTrackerData{jumpAudioPageTime=" + this.jumpAudioPageTime + ", openAudioPageFrom='" + this.openAudioPageFrom + "'}";
    }

    public final void setJumpAudioPageTime(long j) {
        this.jumpAudioPageTime = j;
    }

    public final void setOpenAudioPageFrom(String str) {
        this.openAudioPageFrom = str;
    }
}
