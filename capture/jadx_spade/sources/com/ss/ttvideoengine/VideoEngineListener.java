package com.ss.ttvideoengine;

import android.view.Surface;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.utils.Error;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface VideoEngineListener {

    /* renamed from: com.ss.ttvideoengine.VideoEngineListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFirstAVSyncFrame(VideoEngineListener videoEngineListener, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onRefreshSurface(VideoEngineListener videoEngineListener, TTVideoEngine tTVideoEngine) {
        }

        public static int $default$onSetSurface(VideoEngineListener videoEngineListener, TTVideoEngine tTVideoEngine, VideoSurface videoSurface, Surface surface) {
            return 0;
        }

        public static void $default$onSilenceDetected(VideoEngineListener videoEngineListener, TTVideoEngine tTVideoEngine) {
        }

        public static void $default$onVideoSecondFrame(VideoEngineListener videoEngineListener, TTVideoEngine tTVideoEngine) {
        }
    }

    void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i);

    void onCompletion(TTVideoEngine tTVideoEngine);

    void onError(Error error);

    void onFirstAVSyncFrame(TTVideoEngine tTVideoEngine);

    void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i);

    void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i);

    void onPrepare(TTVideoEngine tTVideoEngine);

    void onPrepared(TTVideoEngine tTVideoEngine);

    void onRefreshSurface(TTVideoEngine tTVideoEngine);

    void onRenderStart(TTVideoEngine tTVideoEngine);

    int onSetSurface(TTVideoEngine tTVideoEngine, VideoSurface videoSurface, Surface surface);

    void onSilenceDetected(TTVideoEngine tTVideoEngine);

    void onStreamChanged(TTVideoEngine tTVideoEngine, int i);

    void onVideoSecondFrame(TTVideoEngine tTVideoEngine);

    void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2);

    void onVideoStatusException(int i);
}
