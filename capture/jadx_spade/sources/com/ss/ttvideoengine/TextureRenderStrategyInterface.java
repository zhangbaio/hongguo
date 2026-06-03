package com.ss.ttvideoengine;

import android.os.Bundle;
import com.ss.texturerender.VideoSurface;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface TextureRenderStrategyInterface {
    void didInitTextureRender(VideoSurface videoSurface);

    boolean isInitEffect();

    boolean isNeedAsyncEffect(ji6.d dVar);

    boolean isPlaybackUse();

    void onRenderStart(float f, VideoSurface videoSurface, boolean z);

    void reset(VideoSurface videoSurface, boolean z);

    void setEffect(Bundle bundle, VideoSurface videoSurface);

    void setIsInitEffect(boolean z);
}
