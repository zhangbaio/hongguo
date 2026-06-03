package com.ss.ttvideoengine;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TextureRenderStrategySharpen implements TextureRenderStrategyInterface {
    private boolean mIsInitSharpen = false;
    private boolean mOpensharpen = false;
    private boolean mPlaybackUseSharpen = false;
    private boolean mAsyncInit = false;
    private Bundle mInitBundle = null;

    static {
        Covode.recordClassIndex(652372);
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public boolean isInitEffect() {
        return this.mIsInitSharpen;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public boolean isPlaybackUse() {
        return this.mPlaybackUseSharpen;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void setIsInitEffect(boolean z) {
        this.mIsInitSharpen = z;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public boolean isNeedAsyncEffect(ji6.d dVar) {
        this.mPlaybackUseSharpen = this.mIsInitSharpen;
        if (this.mAsyncInit) {
            dVar.d(1, 1);
        }
        return this.mAsyncInit;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void didInitTextureRender(VideoSurface videoSurface) {
        this.mInitBundle.putInt("enable_bmf", EngineGlobalConfig.getInstance().getEnableBmf());
        this.mInitBundle.putString("moduleName", FeatureManager.getModuleName());
        videoSurface.setEffect(this.mInitBundle);
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void reset(VideoSurface videoSurface, boolean z) {
        openSharpen(false, videoSurface, z);
        this.mIsInitSharpen = false;
        this.mOpensharpen = false;
        this.mPlaybackUseSharpen = false;
        this.mAsyncInit = false;
        this.mInitBundle = null;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void setEffect(Bundle bundle, VideoSurface videoSurface) {
        if (bundle.getInt("action") == 21) {
            this.mIsInitSharpen = true;
            this.mOpensharpen = bundle.getBoolean("use_effect");
            this.mAsyncInit = bundle.getBoolean("asyncInit");
            this.mInitBundle = bundle;
            return;
        }
        if (bundle.getInt("action") == 19) {
            this.mOpensharpen = bundle.getBoolean("use_effect");
            openSharpen(this.mOpensharpen, videoSurface, bundle.getBoolean("HasFirstFrameShown"));
        }
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void onRenderStart(float f, VideoSurface videoSurface, boolean z) {
        boolean z2 = this.mOpensharpen;
        if (f >= 31.0f || f <= 0.0f) {
            z2 = false;
        }
        this.mOpensharpen = z2;
        openSharpen(z2, videoSurface, z);
    }

    private void openSharpen(boolean z, VideoSurface videoSurface, boolean z2) {
        this.mOpensharpen = z;
        if (videoSurface != null && z2) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("action", 19);
                int i = 1;
                bundle.putInt("effect_type", 1);
                if (!this.mOpensharpen) {
                    i = 0;
                }
                bundle.putInt("int_value", i);
                videoSurface.setEffect(bundle);
            } catch (Exception e) {
                TTVideoEngineLog.i("[SALog]", "[SALog]doOpenSharpen catch exception e=" + e);
            }
        }
    }
}
