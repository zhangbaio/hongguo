package com.ss.ttvideoengine;

import android.view.Surface;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface VideoEngineCallback {

    /* renamed from: com.ss.ttvideoengine.VideoEngineCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$OnFirstFrameAfterSurfaceChange(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static String $default$getEncryptedLocalTime(VideoEngineCallback videoEngineCallback) {
            return null;
        }

        public static void $default$onABRPredictBitrate(VideoEngineCallback videoEngineCallback, int i, int i2) {
        }

        public static void $default$onAVBadInterlaced(VideoEngineCallback videoEngineCallback, Map map) {
        }

        public static void $default$onBufferEnd(VideoEngineCallback videoEngineCallback, int i) {
        }

        public static void $default$onBufferStart(VideoEngineCallback videoEngineCallback, int i, int i2, int i3) {
        }

        public static void $default$onBufferingUpdate(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine, int i) {
        }

        public static void $default$onCompletion(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onCurrentPlaybackTimeUpdate(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine, int i) {
        }

        public static void $default$onError(VideoEngineCallback videoEngineCallback, Error error) {
        }

        public static void $default$onFirstAVSyncFrame(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onFrameAboutToBeRendered(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine, int i, long j, long j2, Map map) {
        }

        public static void $default$onFrameDraw(VideoEngineCallback videoEngineCallback, int i, Map map) {
        }

        public static void $default$onInfoIdChanged(VideoEngineCallback videoEngineCallback, int i) {
        }

        public static void $default$onLoadStateChanged(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine, int i) {
        }

        public static void $default$onPlayUrlChanged(VideoEngineCallback videoEngineCallback, int i, String str, String str2) {
        }

        public static void $default$onPlaybackStateChanged(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine, int i) {
        }

        public static void $default$onPrepare(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onPrepared(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onReadyForDisplay(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onRefreshSurface(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onRenderStart(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onSARChanged(VideoEngineCallback videoEngineCallback, int i, int i2) {
        }

        public static int $default$onSetSurface(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine, VideoSurface videoSurface, Surface surface) {
            return 0;
        }

        public static void $default$onSilenceDetected(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onStreamChanged(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine, int i) {
        }

        public static void $default$onVideoSecondFrame(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onVideoSizeChanged(VideoEngineCallback videoEngineCallback, TTVideoEngine tTVideoEngine, int i, int i2) {
        }

        public static void $default$onVideoStatusException(VideoEngineCallback videoEngineCallback, int i) {
        }

        public static void $default$onVideoStreamBitrateChanged(VideoEngineCallback videoEngineCallback, Resolution resolution, int i) {
        }

        public static void $default$onVideoURLRouteFailed(VideoEngineCallback videoEngineCallback, Error error, String str) {
        }
    }

    void OnFirstFrameAfterSurfaceChange(TTVideoEngine tTVideoEngine);

    String getEncryptedLocalTime();

    void onABRPredictBitrate(int i, int i2);

    void onAVBadInterlaced(Map map);

    void onBufferEnd(int i);

    void onBufferStart(int i, int i2, int i3);

    void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i);

    void onCompletion(TTVideoEngine tTVideoEngine);

    void onCurrentPlaybackTimeUpdate(TTVideoEngine tTVideoEngine, int i);

    void onError(Error error);

    void onFirstAVSyncFrame(TTVideoEngine tTVideoEngine);

    void onFrameAboutToBeRendered(TTVideoEngine tTVideoEngine, int i, long j, long j2, Map<Integer, String> map);

    void onFrameDraw(int i, Map map);

    void onInfoIdChanged(int i);

    void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i);

    void onPlayUrlChanged(int i, String str, String str2);

    void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i);

    void onPrepare(TTVideoEngine tTVideoEngine);

    void onPrepared(TTVideoEngine tTVideoEngine);

    void onReadyForDisplay(TTVideoEngine tTVideoEngine);

    void onRefreshSurface(TTVideoEngine tTVideoEngine);

    void onRenderStart(TTVideoEngine tTVideoEngine);

    void onSARChanged(int i, int i2);

    int onSetSurface(TTVideoEngine tTVideoEngine, VideoSurface videoSurface, Surface surface);

    void onSilenceDetected(TTVideoEngine tTVideoEngine);

    void onStreamChanged(TTVideoEngine tTVideoEngine, int i);

    void onVideoSecondFrame(TTVideoEngine tTVideoEngine);

    void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2);

    void onVideoStatusException(int i);

    void onVideoStreamBitrateChanged(Resolution resolution, int i);

    void onVideoURLRouteFailed(Error error, String str);
}
