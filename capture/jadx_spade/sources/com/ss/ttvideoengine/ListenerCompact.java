package com.ss.ttvideoengine;

import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ListenerCompact implements VideoEngineCallback {
    private ABRListener mABRListener;
    private VideoBufferDetailListener mBufferDetailListener;
    private VideoBufferListener mBufferListener;
    private VideoEngineCallback mEngineCallback;
    private final CopyOnWriteArrayList<VideoEngineCallback> mEngineCallbacks = new CopyOnWriteArrayList<>();
    private VideoEngineListener mEngineListener;
    private SARChangeListener mSARChangeListener;
    private StreamInfoListener mStreamInfoListener;
    private VideoURLRouteListener mURLRouteListener;
    private VideoEngineInfoListener mVideoEngineInfoListener;
    private VideoInfoListener mVideoInfoListener;

    static {
        Covode.recordClassIndex(652295);
    }

    public VideoEngineInfoListener getVideoEngineInfoListener() {
        return this.mVideoEngineInfoListener;
    }

    ListenerCompact() {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public String getEncryptedLocalTime() {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            return videoEngineCallback.getEncryptedLocalTime();
        }
        return null;
    }

    public void setABRListener(ABRListener aBRListener) {
        this.mABRListener = aBRListener;
    }

    public void setSARChangeListener(SARChangeListener sARChangeListener) {
        this.mSARChangeListener = sARChangeListener;
    }

    public void setStreamInfoListener(StreamInfoListener streamInfoListener) {
        this.mStreamInfoListener = streamInfoListener;
    }

    public void setVideoBufferDetailListener(VideoBufferDetailListener videoBufferDetailListener) {
        this.mBufferDetailListener = videoBufferDetailListener;
    }

    public void setVideoBufferListener(VideoBufferListener videoBufferListener) {
        this.mBufferListener = videoBufferListener;
    }

    public void setVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        this.mEngineCallback = videoEngineCallback;
    }

    public void setVideoEngineInfoListener(VideoEngineInfoListener videoEngineInfoListener) {
        this.mVideoEngineInfoListener = videoEngineInfoListener;
    }

    public void setVideoEngineListener(VideoEngineListener videoEngineListener) {
        this.mEngineListener = videoEngineListener;
    }

    public void setVideoInfoListener(VideoInfoListener videoInfoListener) {
        this.mVideoInfoListener = videoInfoListener;
    }

    public void setVideoURLRouteListener(VideoURLRouteListener videoURLRouteListener) {
        this.mURLRouteListener = videoURLRouteListener;
    }

    public void addVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        this.mEngineCallbacks.addIfAbsent(videoEngineCallback);
    }

    public void onVideoEngineInfos(VideoEngineInfos videoEngineInfos) {
        VideoEngineInfoListener videoEngineInfoListener = this.mVideoEngineInfoListener;
        if (videoEngineInfoListener != null) {
            videoEngineInfoListener.onVideoEngineInfos(videoEngineInfos);
        }
    }

    public void removeVideoEngineCallback(VideoEngineCallback videoEngineCallback) {
        this.mEngineCallbacks.remove(videoEngineCallback);
    }

    public boolean onFetchedVideoInfo(VideoModel videoModel) {
        VideoInfoListener videoInfoListener = this.mVideoInfoListener;
        if (videoInfoListener != null) {
            return videoInfoListener.onFetchedVideoInfo(videoModel);
        }
        return false;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void OnFirstFrameAfterSurfaceChange(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            try {
                videoEngineCallback.OnFirstFrameAfterSurfaceChange(tTVideoEngine);
            } catch (Throwable unused) {
            }
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().OnFirstFrameAfterSurfaceChange(tTVideoEngine);
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onAVBadInterlaced(Map map) {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            videoEngineCallback.onAVBadInterlaced(map);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onAVBadInterlaced(map);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onInfoIdChanged(int i) {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            videoEngineCallback.onInfoIdChanged(i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onInfoIdChanged(i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onReadyForDisplay(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            videoEngineCallback.onReadyForDisplay(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onReadyForDisplay(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onBufferEnd(int i) {
        VideoBufferListener videoBufferListener = this.mBufferListener;
        VideoBufferDetailListener videoBufferDetailListener = this.mBufferDetailListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoBufferListener != null) {
            videoBufferListener.onBufferEnd(i);
        }
        if (videoBufferDetailListener != null) {
            videoBufferDetailListener.onBufferEnd(i);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onBufferEnd(i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onBufferEnd(i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onCompletion(TTVideoEngine tTVideoEngine) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onCompletion(tTVideoEngine);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onCompletion(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onCompletion(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onError(Error error) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onError(error);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onError(error);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onError(error);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onFirstAVSyncFrame(TTVideoEngine tTVideoEngine) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onFirstAVSyncFrame(tTVideoEngine);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onFirstAVSyncFrame(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onFirstAVSyncFrame(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPrepare(TTVideoEngine tTVideoEngine) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onPrepare(tTVideoEngine);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onPrepare(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onPrepare(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPrepared(TTVideoEngine tTVideoEngine) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onPrepared(tTVideoEngine);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onPrepared(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onPrepared(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onRefreshSurface(TTVideoEngine tTVideoEngine) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onRefreshSurface(tTVideoEngine);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onRefreshSurface(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onRefreshSurface(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onRenderStart(TTVideoEngine tTVideoEngine) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onRenderStart(tTVideoEngine);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onRenderStart(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onRenderStart(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onSilenceDetected(TTVideoEngine tTVideoEngine) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onSilenceDetected(tTVideoEngine);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onSilenceDetected(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onSilenceDetected(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoSecondFrame(TTVideoEngine tTVideoEngine) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onVideoSecondFrame(tTVideoEngine);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onVideoSecondFrame(tTVideoEngine);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onVideoSecondFrame(tTVideoEngine);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoStatusException(int i) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onVideoStatusException(i);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onVideoStatusException(i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onVideoStatusException(i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onCurrentPlaybackTimeUpdate(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            videoEngineCallback.onCurrentPlaybackTimeUpdate(tTVideoEngine, i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onCurrentPlaybackTimeUpdate(tTVideoEngine, i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onFrameDraw(int i, Map map) {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            videoEngineCallback.onFrameDraw(i, map);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onFrameDraw(i, map);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onABRPredictBitrate(int i, int i2) {
        ABRListener aBRListener = this.mABRListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (aBRListener != null) {
            aBRListener.onPredictBitrate(i, i2);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onABRPredictBitrate(i, i2);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onABRPredictBitrate(i, i2);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onBufferingUpdate(tTVideoEngine, i);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onBufferingUpdate(tTVideoEngine, i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onBufferingUpdate(tTVideoEngine, i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onLoadStateChanged(tTVideoEngine, i);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onLoadStateChanged(tTVideoEngine, i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onLoadStateChanged(tTVideoEngine, i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onPlaybackStateChanged(tTVideoEngine, i);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onPlaybackStateChanged(tTVideoEngine, i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onPlaybackStateChanged(tTVideoEngine, i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onSARChanged(int i, int i2) {
        SARChangeListener sARChangeListener = this.mSARChangeListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (sARChangeListener != null) {
            sARChangeListener.onSARChanged(i, i2);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onSARChanged(i, i2);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onSARChanged(i, i2);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onStreamChanged(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onStreamChanged(tTVideoEngine, i);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onStreamChanged(tTVideoEngine, i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onStreamChanged(tTVideoEngine, i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoStreamBitrateChanged(Resolution resolution, int i) {
        StreamInfoListener streamInfoListener = this.mStreamInfoListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (streamInfoListener != null) {
            streamInfoListener.onVideoStreamBitrateChanged(resolution, i);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onVideoStreamBitrateChanged(resolution, i);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onVideoStreamBitrateChanged(resolution, i);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoURLRouteFailed(Error error, String str) {
        VideoURLRouteListener videoURLRouteListener = this.mURLRouteListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoURLRouteListener != null) {
            videoURLRouteListener.onFailed(error, str);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onVideoURLRouteFailed(error, str);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onVideoURLRouteFailed(error, str);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPlayUrlChanged(int i, String str, String str2) {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            videoEngineCallback.onPlayUrlChanged(i, str, str2);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onPlayUrlChanged(i, str, str2);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public int onSetSurface(TTVideoEngine tTVideoEngine, VideoSurface videoSurface, Surface surface) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onSetSurface(tTVideoEngine, videoSurface, surface);
        }
        if (videoEngineCallback != null) {
            return videoEngineCallback.onSetSurface(tTVideoEngine, videoSurface, surface);
        }
        return 0;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onBufferStart(int i, int i2, int i3) {
        VideoBufferListener videoBufferListener = this.mBufferListener;
        VideoBufferDetailListener videoBufferDetailListener = this.mBufferDetailListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoBufferListener != null) {
            videoBufferListener.onBufferStart(i);
        }
        if (videoBufferDetailListener != null) {
            videoBufferDetailListener.onBufferStart(i, i2, i3);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onBufferStart(i, i2, i3);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onBufferStart(i, i2, i3);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
        VideoEngineListener videoEngineListener = this.mEngineListener;
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineListener != null) {
            videoEngineListener.onVideoSizeChanged(tTVideoEngine, i, i2);
        }
        if (videoEngineCallback != null) {
            videoEngineCallback.onVideoSizeChanged(tTVideoEngine, i, i2);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onVideoSizeChanged(tTVideoEngine, i, i2);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onFrameAboutToBeRendered(TTVideoEngine tTVideoEngine, int i, long j, long j2, Map<Integer, String> map) {
        VideoEngineCallback videoEngineCallback = this.mEngineCallback;
        if (videoEngineCallback != null) {
            videoEngineCallback.onFrameAboutToBeRendered(tTVideoEngine, i, j, j2, map);
        }
        Iterator<VideoEngineCallback> it2 = this.mEngineCallbacks.iterator();
        while (it2.hasNext()) {
            it2.next().onFrameAboutToBeRendered(tTVideoEngine, i, j, j2, map);
        }
    }
}
