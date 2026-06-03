package com.ss.ttvideoengine;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TextureRenderStrategy {
    private HashMap<Integer, TextureRenderStrategyInterface> strategyMap = new HashMap<>();

    static {
        Covode.recordClassIndex(652370);
    }

    void didInitTextureRender(VideoSurface videoSurface) {
        Iterator<TextureRenderStrategyInterface> it2 = this.strategyMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().didInitTextureRender(videoSurface);
        }
    }

    public boolean getAsyncEffect(ji6.d dVar) {
        Iterator<TextureRenderStrategyInterface> it2 = this.strategyMap.values().iterator();
        boolean z = false;
        while (it2.hasNext()) {
            boolean isNeedAsyncEffect = it2.next().isNeedAsyncEffect(dVar);
            if (isNeedAsyncEffect) {
                z = isNeedAsyncEffect;
            }
        }
        return z;
    }

    boolean isInitForEffect(int i) {
        TextureRenderStrategyInterface textureRenderStrategyInterface = this.strategyMap.get(Integer.valueOf(i));
        if (textureRenderStrategyInterface != null) {
            return textureRenderStrategyInterface.isInitEffect();
        }
        return false;
    }

    public boolean isPlaybackUseForEffect(int i) {
        TextureRenderStrategyInterface textureRenderStrategyInterface = this.strategyMap.get(Integer.valueOf(i));
        if (textureRenderStrategyInterface != null) {
            return textureRenderStrategyInterface.isPlaybackUse();
        }
        return false;
    }

    void reset(VideoSurface videoSurface, boolean z) {
        Iterator<TextureRenderStrategyInterface> it2 = this.strategyMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().reset(videoSurface, z);
        }
    }

    void setIsInitForEffect(int i, boolean z) {
        TextureRenderStrategyInterface textureRenderStrategyInterface = this.strategyMap.get(Integer.valueOf(i));
        if (textureRenderStrategyInterface != null) {
            textureRenderStrategyInterface.setIsInitEffect(z);
        }
    }

    public void setEffect(Bundle bundle, VideoSurface videoSurface) {
        int i = bundle.getInt("effect_type");
        TextureRenderStrategyInterface textureRenderStrategyInterface = this.strategyMap.get(Integer.valueOf(i));
        if (textureRenderStrategyInterface == null && bundle.getInt("action") == 21 && i == 1) {
            textureRenderStrategyInterface = new TextureRenderStrategySharpen();
            this.strategyMap.put(1, textureRenderStrategyInterface);
        }
        if (textureRenderStrategyInterface != null) {
            textureRenderStrategyInterface.setEffect(bundle, videoSurface);
        }
    }

    public void onRenderStart(float f, VideoSurface videoSurface, boolean z) {
        Iterator<TextureRenderStrategyInterface> it2 = this.strategyMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().onRenderStart(f, videoSurface, z);
        }
    }
}
