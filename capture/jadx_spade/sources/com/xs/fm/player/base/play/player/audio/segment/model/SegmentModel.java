package com.xs.fm.player.base.play.player.audio.segment.model;

import com.bytedance.covode.number.Covode;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SegmentModel<T> {
    public boolean isEnd;
    public long predictDuration;
    public long realDuration;
    public List<PlaySegmentInfo<T>> segments;

    static {
        Covode.recordClassIndex(655861);
    }

    public String toString() {
        return "SegmentModel{segments=" + this.segments.size() + ", realDuration=" + this.realDuration + ", predictDuration=" + this.predictDuration + ", isEnd=" + this.isEnd + '}';
    }

    public SegmentModel(List<PlaySegmentInfo<T>> list, long j, long j2, boolean z) {
        this.segments = list;
        this.realDuration = j;
        this.predictDuration = j2;
        this.isEnd = z;
    }
}
