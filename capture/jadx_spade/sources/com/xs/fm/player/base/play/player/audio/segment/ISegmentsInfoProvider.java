package com.xs.fm.player.base.play.player.audio.segment;

import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.player.audio.segment.model.PlaySegmentInfo;
import com.xs.fm.player.base.play.player.audio.segment.model.SegmentModel;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ISegmentsInfoProvider<T> {

    public interface RequestCallback<U> {
        void onRefreshSegmentModel(SegmentModel<U> segmentModel);

        void onSegmentRequestFailed(int i, String str);
    }

    T getTargetSegment();

    boolean isSegmentInfoValid(PlaySegmentInfo<T> playSegmentInfo);

    boolean isTargetSegmentIncluded(T t, T t2);

    void requestSegments(PlayEngineInfo playEngineInfo, RequestCallback<T> requestCallback);

    void requestSegmentsTts(T t, RequestCallback<T> requestCallback);

    void stopRequest();
}
