package com.ss.ttvideoengine;

import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoEngineSimpleCallback implements VideoEngineCallback {
    static {
        Covode.recordClassIndex(652385);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void OnFirstFrameAfterSurfaceChange(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$OnFirstFrameAfterSurfaceChange(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ String getEncryptedLocalTime() {
        return VideoEngineCallback.CC.$default$getEncryptedLocalTime(this);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onABRPredictBitrate(int i, int i2) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onAVBadInterlaced(Map map) {
        VideoEngineCallback.CC.$default$onAVBadInterlaced(this, map);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onBufferEnd(int i) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onBufferStart(int i, int i2, int i3) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onCompletion(TTVideoEngine tTVideoEngine) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineCallback.CC.$default$onCurrentPlaybackTimeUpdate(this, tTVideoEngine, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onError(Error error) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onFirstAVSyncFrame(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onFrameAboutToBeRendered(TTVideoEngine tTVideoEngine, int i, long j, long j2, Map map) {
        VideoEngineCallback.CC.$default$onFrameAboutToBeRendered(this, tTVideoEngine, i, j, j2, map);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onFrameDraw(int i, Map map) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onInfoIdChanged(int i) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onPlayUrlChanged(int i, String str, String str2) {
        VideoEngineCallback.CC.$default$onPlayUrlChanged(this, i, str, str2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPrepare(TTVideoEngine tTVideoEngine) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPrepared(TTVideoEngine tTVideoEngine) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onReadyForDisplay(TTVideoEngine tTVideoEngine) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onRefreshSurface(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onRefreshSurface(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onRenderStart(TTVideoEngine tTVideoEngine) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onSARChanged(int i, int i2) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ int onSetSurface(TTVideoEngine tTVideoEngine, VideoSurface videoSurface, Surface surface) {
        return VideoEngineCallback.CC.$default$onSetSurface(this, tTVideoEngine, videoSurface, surface);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onSilenceDetected(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onSilenceDetected(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onStreamChanged(TTVideoEngine tTVideoEngine, int i) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoSecondFrame(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onVideoSecondFrame(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoStatusException(int i) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoStreamBitrateChanged(Resolution resolution, int i) {
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onVideoURLRouteFailed(Error error, String str) {
    }
}
