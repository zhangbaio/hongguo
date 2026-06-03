package com.ss.ttvideoengine.preRender;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineStateListener;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class PlayBufferManager implements PlayBufferListener, VideoEngineStateListener {
    private int mCustomStartBufferInS;
    private int mCustomStopBufferInS;
    private String mEngineHash;
    private final CopyOnWriteArrayList<PreRenderTriggerListener> mListeners;
    private PlayBuffer mPlayBuffer;
    private int mStartBufferInS;
    private int mStopBufferInS;
    private final Timer mTimer;
    private volatile boolean mTriggered;

    static {
        Covode.recordClassIndex(652613);
    }

    private static class Holder {
        private static final PlayBufferManager PLAY_BUFFER_MANAGER;

        private Holder() {
        }

        static {
            Covode.recordClassIndex(652614);
            PLAY_BUFFER_MANAGER = new PlayBufferManager();
        }
    }

    public static PlayBufferManager instance() {
        return Holder.PLAY_BUFFER_MANAGER;
    }

    private PlayBufferManager() {
        this.mStartBufferInS = 14;
        this.mStopBufferInS = 3;
        this.mTimer = TimerDefault.instance();
        this.mListeners = new CopyOnWriteArrayList<>();
    }

    private void updateSettingsInfo() {
        JSONObject vodJsonObject = SettingsHelper.helper().getVodJsonObject("prerender");
        if (vodJsonObject == null) {
            return;
        }
        if (this.mCustomStartBufferInS <= 0) {
            this.mStartBufferInS = vodJsonObject.optInt("start_buffer_s", 14);
        }
        if (this.mCustomStopBufferInS <= 0) {
            this.mStopBufferInS = vodJsonObject.optInt("stop_buffer_s", 3);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineStateListener
    public void onEnginePlay(TTVideoEngine tTVideoEngine) {
        enginePlay(tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineStateListener
    public void onEngineStop(TTVideoEngine tTVideoEngine) {
        engineStop(tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.preRender.PlayBufferListener
    public void onCacheEnd(TTVideoEngine tTVideoEngine) {
        triggerPreRender("cache end");
    }

    public void setStartBufferInS(int i) {
        this.mCustomStartBufferInS = i;
        this.mStartBufferInS = i;
    }

    public void setStopBufferInS(int i) {
        this.mCustomStopBufferInS = i;
        this.mStopBufferInS = i;
    }

    public void removeListener(PreRenderTriggerListener preRenderTriggerListener) {
        if (preRenderTriggerListener == null) {
            return;
        }
        this.mListeners.remove(preRenderTriggerListener);
    }

    public void useDefaultEngineState(boolean z) {
        if (z) {
            TTVideoEngine.addEngineStateListener(this);
        } else {
            TTVideoEngine.removeEngineStateListener(this);
        }
    }

    private void pausePreRender(String str) {
        if (!this.mTriggered) {
            return;
        }
        TTVideoEngineLog.d("PreRender_PlayBufferManager", "pause PreRender " + str);
        this.mTriggered = false;
        Iterator<PreRenderTriggerListener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPausePreRender();
        }
    }

    private void triggerPreRender(String str) {
        if (this.mTriggered) {
            return;
        }
        TTVideoEngineLog.d("PreRender_PlayBufferManager", "trigger PreRender " + str);
        this.mTriggered = true;
        Iterator<PreRenderTriggerListener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onTriggerPreRender();
        }
    }

    public void addListener(PreRenderTriggerListener preRenderTriggerListener) {
        TTVideoEngineLog.d("PreRender_PlayBufferManager", "addListener triggered " + this.mTriggered);
        updateSettingsInfo();
        if (preRenderTriggerListener == null) {
            return;
        }
        this.mListeners.addIfAbsent(preRenderTriggerListener);
        if (this.mTriggered) {
            preRenderTriggerListener.onTriggerPreRender();
        } else {
            preRenderTriggerListener.onPausePreRender();
        }
    }

    public synchronized void engineStop(TTVideoEngine tTVideoEngine) {
        TTVideoEngineLog.d("PreRender_PlayBufferManager", "engineStop " + tTVideoEngine);
        if (tTVideoEngine == null) {
            return;
        }
        if (TextUtils.equals(tTVideoEngine.getHash(), this.mEngineHash)) {
            PlayBuffer playBuffer = this.mPlayBuffer;
            if (playBuffer != null) {
                playBuffer.removePlayBufferListener(this);
                this.mPlayBuffer.stop();
                this.mPlayBuffer = null;
            }
            triggerPreRender("engineStop");
        }
    }

    public synchronized void enginePlay(TTVideoEngine tTVideoEngine) {
        TTVideoEngineLog.d("PreRender_PlayBufferManager", "enginePlay " + tTVideoEngine);
        if (tTVideoEngine == null) {
            return;
        }
        pausePreRender("new enginePlay");
        this.mEngineHash = tTVideoEngine.getHash();
        if (this.mPlayBuffer == null) {
            PlayBuffer playBuffer = new PlayBuffer(this.mTimer);
            this.mPlayBuffer = playBuffer;
            playBuffer.addPlayBufferListener(this);
        }
        this.mPlayBuffer.setEngine(tTVideoEngine);
        this.mPlayBuffer.start();
    }

    @Override // com.ss.ttvideoengine.preRender.PlayBufferListener
    public void onCacheSize(TTVideoEngine tTVideoEngine, long j) {
        if (j >= this.mStartBufferInS * 1000) {
            triggerPreRender("high buffer " + j);
        }
        if (j <= this.mStopBufferInS * 1000) {
            pausePreRender("low buffer " + j);
        }
    }
}
