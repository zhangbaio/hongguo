package com.xs.fm.player.base.play.player.audio.segment.model;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlaySegmentInfo<T> extends PlayEngineInfo {
    private int mDuration;
    private T mSegmentInfo;
    private String mSegmentKey;
    private boolean playByLocal;

    static {
        Covode.recordClassIndex(655860);
    }

    public int getDuration() {
        return this.mDuration;
    }

    public T getSegmentInfo() {
        return this.mSegmentInfo;
    }

    public String getSegmentKey() {
        return this.mSegmentKey;
    }

    public boolean isPlayByLocal() {
        return this.playByLocal;
    }

    @Override // com.xs.fm.player.base.play.data.PlayEngineInfo
    public String toString() {
        return "PlaySegmentInfo{playBookid=" + this.playBookId + ", itemId=" + this.itemId + ", toneId=" + this.toneId + ", genreType=" + this.genreType + ", playAddress=" + this.playAddress + ", playPosition=" + this.playPosition + ", speed=" + this.speed + ", mSegmentKey='" + this.mSegmentKey + "', mSegmentInfo=" + this.mSegmentInfo + ", mDuration=" + this.mDuration + ", playByLocal=" + this.playByLocal + '}';
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setPlayByLocal(boolean z) {
        this.playByLocal = z;
    }

    public void setSegmentInfo(T t) {
        this.mSegmentInfo = t;
    }

    public PlaySegmentInfo(String str, PlayAddress playAddress, long j, int i, int i2, T t) {
        this(str, playAddress, j, i, i2, t, false);
    }

    public PlaySegmentInfo(String str, PlayAddress playAddress, long j, int i, int i2, T t, boolean z) {
        super(playAddress, j, i);
        this.mSegmentKey = str;
        this.mDuration = i2;
        this.mSegmentInfo = t;
        this.playByLocal = z;
    }
}
