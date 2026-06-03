package com.ss.ttvideoengine.strategy;

import android.os.Handler;
import com.bytedance.covode.number.Covode;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StrategyManager {
    static {
        Covode.recordClassIndex(652725);
    }

    private StrategyManager() {
    }

    public void addStrategySources(List<StrategySource> list) {
    }

    public void bufferStart(TTVideoEngine tTVideoEngine, int i, int i2, int i3) {
    }

    public void clearAll() {
    }

    public void codecType(TTVideoEngineInterface tTVideoEngineInterface, String str) {
    }

    public void enable(int i, int i2) {
    }

    public boolean enableEngineLooper() {
        return false;
    }

    public void engineCreate(TTVideoEngineInterface tTVideoEngineInterface) {
    }

    public void enginePlay(TTVideoEngine tTVideoEngine) {
    }

    public TTVideoEngine getPreRenderEngine(StrategySource strategySource) {
        return null;
    }

    public TTVideoEngine getPreRenderEngine(String str) {
        return null;
    }

    public void initGearGlobalConfig() {
    }

    public void mdlStart(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
    }

    public void onPrepared(TTVideoEngineInterface tTVideoEngineInterface) {
    }

    public TTVideoEngine removePreRenderEngine(String str) {
        return null;
    }

    public void setListener(EngineStrategyListener engineStrategyListener) {
    }

    public void setStrategySources(List<StrategySource> list) {
    }

    public void setVideoInfo(TTVideoEngineInterface tTVideoEngineInterface, VideoInfo videoInfo) {
    }

    public void startSpeedPredictor() {
    }

    public void updateSRStrategyConfig(SRStrategyConfig sRStrategyConfig) {
    }

    private static class Holder {
        private static final StrategyManager instance;

        private Holder() {
        }

        static {
            Covode.recordClassIndex(652726);
            instance = new StrategyManager();
        }
    }

    public static StrategyManager instance() {
        return Holder.instance;
    }

    public Handler handler() {
        throw new UnsupportedOperationException("tob only");
    }

    public void mdlCleanCache() {
        throw new UnsupportedOperationException("tob only");
    }

    public int version() {
        throw new UnsupportedOperationException("tob only");
    }

    public void engineRenderStart(TTVideoEngine tTVideoEngine) {
        throw new UnsupportedOperationException("tob only");
    }
}
