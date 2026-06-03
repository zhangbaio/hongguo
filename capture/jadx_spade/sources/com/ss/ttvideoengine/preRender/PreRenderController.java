package com.ss.ttvideoengine.preRender;

import android.os.Looper;
import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.source.Source;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreRenderController implements PreRenderTriggerListener, VideoEngineCallback {
    private final PreRenderAlgorithm mAlgorithm;
    private final EngineFactory mEngineFactory;
    private PreRenderListener mListener;
    private TTVideoEngine mPreRenderEngine;
    private Source mPreRenderSource;
    private int mState;
    private final String mTraceId;

    static {
        Covode.recordClassIndex(652619);
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
    public /* synthetic */ void onABRPredictBitrate(int i, int i2) {
        VideoEngineCallback.CC.$default$onABRPredictBitrate(this, i, i2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onAVBadInterlaced(Map map) {
        VideoEngineCallback.CC.$default$onAVBadInterlaced(this, map);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onBufferEnd(int i) {
        VideoEngineCallback.CC.$default$onBufferEnd(this, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onBufferStart(int i, int i2, int i3) {
        VideoEngineCallback.CC.$default$onBufferStart(this, i, i2, i3);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineCallback.CC.$default$onBufferingUpdate(this, tTVideoEngine, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onCompletion(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onCompletion(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineCallback.CC.$default$onCurrentPlaybackTimeUpdate(this, tTVideoEngine, i);
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
    public /* synthetic */ void onFrameDraw(int i, Map map) {
        VideoEngineCallback.CC.$default$onFrameDraw(this, i, map);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onInfoIdChanged(int i) {
        VideoEngineCallback.CC.$default$onInfoIdChanged(this, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineCallback.CC.$default$onLoadStateChanged(this, tTVideoEngine, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onPlayUrlChanged(int i, String str, String str2) {
        VideoEngineCallback.CC.$default$onPlayUrlChanged(this, i, str, str2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineCallback.CC.$default$onPlaybackStateChanged(this, tTVideoEngine, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onPrepare(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onPrepare(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onReadyForDisplay(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onReadyForDisplay(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onRefreshSurface(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onRefreshSurface(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onRenderStart(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onRenderStart(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onSARChanged(int i, int i2) {
        VideoEngineCallback.CC.$default$onSARChanged(this, i, i2);
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
    public /* synthetic */ void onStreamChanged(TTVideoEngine tTVideoEngine, int i) {
        VideoEngineCallback.CC.$default$onStreamChanged(this, tTVideoEngine, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoSecondFrame(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onVideoSecondFrame(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
        VideoEngineCallback.CC.$default$onVideoSizeChanged(this, tTVideoEngine, i, i2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoStatusException(int i) {
        VideoEngineCallback.CC.$default$onVideoStatusException(this, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoStreamBitrateChanged(Resolution resolution, int i) {
        VideoEngineCallback.CC.$default$onVideoStreamBitrateChanged(this, resolution, i);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoURLRouteFailed(Error error, String str) {
        VideoEngineCallback.CC.$default$onVideoURLRouteFailed(this, error, str);
    }

    private void callbackPreRenderStart() {
        runOnMainThread(new Runnable() { // from class: com.ss.ttvideoengine.preRender.d
            @Override // java.lang.Runnable
            public final void run() {
                PreRenderController.this.lambda$callbackPreRenderStart$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callbackPreRenderStart$0() {
        PreRenderListener preRenderListener = this.mListener;
        if (preRenderListener != null) {
            preRenderListener.onPreRenderStart(this.mPreRenderEngine, this.mPreRenderSource);
        }
    }

    @Override // com.ss.ttvideoengine.preRender.PreRenderTriggerListener
    public synchronized void onTriggerPreRender() {
        if (this.mState != 1) {
            return;
        }
        this.mState = 2;
        startPreRender();
    }

    @Override // com.ss.ttvideoengine.preRender.PreRenderTriggerListener
    public synchronized void onPausePreRender() {
        TTVideoEngine tTVideoEngine = this.mPreRenderEngine;
        if (tTVideoEngine != null && !tTVideoEngine.isPrepared()) {
            TTVideoEngineLog.d("PreRender_Controller", this.mTraceId + " pausePreRender");
            PreRenderListener preRenderListener = this.mListener;
            if (preRenderListener == null) {
                return;
            }
            if (preRenderListener.onPreRenderPause(this.mPreRenderEngine, this.mPreRenderSource)) {
                this.mState = 1;
            }
        }
    }

    public synchronized boolean start() {
        TTVideoEngineLog.d("PreRender_Controller", this.mTraceId + " start");
        int i = this.mState;
        if (i != 1 && i != 2) {
            Source source = this.mPreRenderSource;
            if (source == null) {
                callbackError(1, null);
                return false;
            }
            this.mState = 1;
            this.mAlgorithm.shouldStartPreRender(source, this);
            return true;
        }
        callbackError(0, null);
        return false;
    }

    public synchronized void stop() {
        TTVideoEngineLog.d("PreRender_Controller", this.mTraceId + " stop");
        this.mState = 0;
        this.mPreRenderSource = null;
        TTVideoEngine tTVideoEngine = this.mPreRenderEngine;
        if (tTVideoEngine != null) {
            tTVideoEngine.removeVideoEngineCallback(this);
        }
        this.mPreRenderEngine = null;
        this.mAlgorithm.stop();
    }

    private void startPreRender() {
        TTVideoEngineLog.d("PreRender_Controller", this.mTraceId + " startPreRender");
        TTVideoEngine tTVideoEngine = this.mPreRenderEngine;
        if (tTVideoEngine != null && tTVideoEngine.isPrepared()) {
            callbackSuccess(this.mPreRenderEngine);
            return;
        }
        if (this.mPreRenderEngine == null) {
            this.mPreRenderEngine = this.mEngineFactory.createEngine(this.mPreRenderSource);
        }
        TTVideoEngine tTVideoEngine2 = this.mPreRenderEngine;
        if (tTVideoEngine2 == null) {
            callbackError(2, null);
            return;
        }
        tTVideoEngine2.setAutoRangeRead(2, this.mAlgorithm.getAutoRange());
        this.mPreRenderEngine.addVideoEngineCallback(this);
        this.mPreRenderEngine.prepare();
        callbackPreRenderStart();
    }

    public void setListener(PreRenderListener preRenderListener) {
        this.mListener = preRenderListener;
    }

    public void setSource(Source source) {
        this.mPreRenderSource = source;
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPrepared(TTVideoEngine tTVideoEngine) {
        tTVideoEngine.removeVideoEngineCallback(this);
        callbackSuccess(tTVideoEngine);
    }

    public PreRenderController(EngineFactory engineFactory) {
        this(engineFactory, new PreRenderAlgorithmDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callbackSuccess$1(TTVideoEngine tTVideoEngine) {
        PreRenderListener preRenderListener = this.mListener;
        if (preRenderListener != null) {
            preRenderListener.onPreRenderSuccess(tTVideoEngine, this.mPreRenderSource);
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onError(Error error) {
        TTVideoEngine tTVideoEngine = this.mPreRenderEngine;
        if (tTVideoEngine != null) {
            tTVideoEngine.removeVideoEngineCallback(this);
        }
        callbackError(3, error);
    }

    private void runOnMainThread(Runnable runnable) {
        Looper mainLooper = Looper.getMainLooper();
        if (Looper.myLooper() == mainLooper) {
            runnable.run();
        } else {
            new HandlerDelegate(mainLooper).post(runnable);
        }
    }

    private void callbackSuccess(final TTVideoEngine tTVideoEngine) {
        TTVideoEngineLog.d("PreRender_Controller", this.mTraceId + " prerender success engine:" + tTVideoEngine);
        this.mAlgorithm.stop();
        this.mState = 3;
        runOnMainThread(new Runnable() { // from class: com.ss.ttvideoengine.preRender.c
            @Override // java.lang.Runnable
            public final void run() {
                PreRenderController.this.lambda$callbackSuccess$1(tTVideoEngine);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callbackError$2(int i, Error error) {
        PreRenderListener preRenderListener = this.mListener;
        if (preRenderListener != null) {
            preRenderListener.onPreRenderError(this.mPreRenderEngine, this.mPreRenderSource, i, error);
        }
    }

    public PreRenderController(EngineFactory engineFactory, PreRenderAlgorithm preRenderAlgorithm) {
        this.mTraceId = "@" + hashCode();
        this.mState = 0;
        this.mEngineFactory = engineFactory;
        this.mAlgorithm = preRenderAlgorithm;
    }

    private void callbackError(final int i, final Error error) {
        TTVideoEngineLog.d("PreRender_Controller", this.mTraceId + " prerender error errorType:" + i + "， error:" + error);
        this.mAlgorithm.stop();
        this.mState = 4;
        runOnMainThread(new Runnable() { // from class: com.ss.ttvideoengine.preRender.b
            @Override // java.lang.Runnable
            public final void run() {
                PreRenderController.this.lambda$callbackError$2(i, error);
            }
        });
    }
}
