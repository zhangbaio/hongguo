package com.ss.ttvideoengine.selector.strategy;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.IVideoModel;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class GearStrategyContext {
    private WeakReference<TTVideoEngine> mVideoEngineRef;
    private IGearStrategyListener mGearStrategyListener = null;
    private Object mUserData = null;
    private IVideoModel mVideoModel = null;

    static {
        Covode.recordClassIndex(652672);
    }

    public IGearStrategyListener getGearStrategyListener() {
        return this.mGearStrategyListener;
    }

    public Object getUserData() {
        return this.mUserData;
    }

    public WeakReference<TTVideoEngine> getVideoEngineRef() {
        return this.mVideoEngineRef;
    }

    public IVideoModel getVideoModel() {
        return this.mVideoModel;
    }

    public void reset() {
        this.mGearStrategyListener = null;
        this.mUserData = null;
        this.mVideoModel = null;
    }

    public void setGearStrategyListener(IGearStrategyListener iGearStrategyListener) {
        this.mGearStrategyListener = iGearStrategyListener;
    }

    public void setUserData(Object obj) {
        this.mUserData = obj;
    }

    public void setVideoModel(IVideoModel iVideoModel) {
        this.mVideoModel = iVideoModel;
    }

    public GearStrategyContext(TTVideoEngine tTVideoEngine) {
        this.mVideoEngineRef = null;
        this.mVideoEngineRef = new WeakReference<>(tTVideoEngine);
    }
}
