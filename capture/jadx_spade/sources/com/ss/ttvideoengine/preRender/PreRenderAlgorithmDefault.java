package com.ss.ttvideoengine.preRender;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreRenderAlgorithmDefault implements PreRenderAlgorithm {
    private PreRenderTriggerListener mBufferListener;
    private PreRenderTriggerListener mListener;
    private Source mSource;
    private SourceCache mSourceCache;
    private SourceCacheListener mSourceCacheListener;
    private final String mTraceId = "@" + hashCode();
    private int mAutoRangeKB = 500;
    private boolean mSourceCacheEnough = false;
    private boolean mTriggered = false;
    private boolean mStop = false;

    static {
        Covode.recordClassIndex(652618);
    }

    @Override // com.ss.ttvideoengine.preRender.PreRenderAlgorithm
    public int getAutoRange() {
        return this.mAutoRangeKB * 1024;
    }

    private void checkPlayBuffer() {
        this.mBufferListener = new PreRenderTriggerListener() { // from class: com.ss.ttvideoengine.preRender.PreRenderAlgorithmDefault.1
            @Override // com.ss.ttvideoengine.preRender.PreRenderTriggerListener
            public void onPausePreRender() {
                PreRenderAlgorithmDefault.this.pausePreRender();
            }

            @Override // com.ss.ttvideoengine.preRender.PreRenderTriggerListener
            public void onTriggerPreRender() {
                TTVideoEngineLog.d("PreRender_AlgorithmDef", PreRenderAlgorithmDefault.this.mTraceId + " start preRender playBuffer allowed");
                PreRenderAlgorithmDefault.this.startPreRender();
            }
        };
        PlayBufferManager.instance().addListener(this.mBufferListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPreRender() {
        if (!this.mStop && !this.mTriggered) {
            this.mTriggered = true;
            PreRenderTriggerListener preRenderTriggerListener = this.mListener;
            if (preRenderTriggerListener != null) {
                preRenderTriggerListener.onTriggerPreRender();
            }
        }
    }

    private void updateSettingsInfo() {
        JSONObject vodJsonObject = SettingsHelper.helper().getVodJsonObject("prerender");
        if (vodJsonObject == null) {
            return;
        }
        this.mAutoRangeKB = vodJsonObject.optInt("auto_range_k", 500);
    }

    @Override // com.ss.ttvideoengine.preRender.PreRenderAlgorithm
    public void stop() {
        this.mStop = true;
        PlayBufferManager.instance().removeListener(this.mBufferListener);
        SourceCache sourceCache = this.mSourceCache;
        if (sourceCache != null) {
            sourceCache.removeSourceCacheListener(this.mSourceCacheListener);
            this.mSourceCache.stop();
            this.mSourceCache = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePreRender() {
        if (this.mStop || !this.mTriggered || this.mSourceCacheEnough) {
            return;
        }
        TTVideoEngineLog.d("PreRender_AlgorithmDef", this.mTraceId + " pause preRender");
        this.mTriggered = false;
        PreRenderTriggerListener preRenderTriggerListener = this.mListener;
        if (preRenderTriggerListener != null) {
            preRenderTriggerListener.onPausePreRender();
        }
    }

    protected void checkSourceCache() {
        this.mSourceCacheListener = new SourceCacheListener() { // from class: com.ss.ttvideoengine.preRender.a
            @Override // com.ss.ttvideoengine.preRender.SourceCacheListener
            public final void onCacheSize(Source source, long j) {
                PreRenderAlgorithmDefault.this.lambda$checkSourceCache$0(source, j);
            }
        };
        SourceCache sourceCache = new SourceCache(TimerDefault.instance());
        this.mSourceCache = sourceCache;
        sourceCache.setSource(this.mSource);
        this.mSourceCache.addSourceCacheListener(this.mSourceCacheListener);
        this.mSourceCache.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkSourceCache$0(Source source, long j) {
        if (j > this.mAutoRangeKB * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
            this.mSourceCacheEnough = true;
            TTVideoEngineLog.d("PreRender_AlgorithmDef", this.mTraceId + " start preRender cache enough " + j);
            startPreRender();
        }
    }

    @Override // com.ss.ttvideoengine.preRender.PreRenderAlgorithm
    public void shouldStartPreRender(Source source, PreRenderTriggerListener preRenderTriggerListener) {
        TTVideoEngineLog.d("PreRender_AlgorithmDef", this.mTraceId + " shouldStartPreRender " + source);
        updateSettingsInfo();
        this.mSourceCacheEnough = false;
        this.mTriggered = false;
        this.mStop = false;
        this.mListener = preRenderTriggerListener;
        this.mSource = source;
        checkPlayBuffer();
        checkSourceCache();
    }
}
