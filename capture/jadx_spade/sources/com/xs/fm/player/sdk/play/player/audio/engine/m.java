package com.xs.fm.player.sdk.play.player.audio.engine;

import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.log.VideoEventLoggerV2;
import com.ss.ttvideoengine.log.VideoEventOnePlay;
import com.ss.ttvideoengine.utils.Error;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class m implements VideoEngineCallback {
    private static final bl6.a r;
    public static long s;
    public static long t;
    public static long u;
    public static long v;
    public static long w;
    TTVideoEngine a;
    public IPlayer.PlayerListener b;
    IPlayer c;
    public PlayEngineInfo f;
    private int h;
    private long k;
    private boolean d = false;
    public boolean e = false;
    HashMap<String, Resolution> g = new HashMap<>();
    public boolean i = false;
    private volatile int j = 0;
    private WeakHandler.IHandler l = new i();
    private WeakHandler m = new WeakHandler(this.l);
    private boolean n = true;
    long o = 0;
    int p = 0;
    long q = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.j = 0;
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
    public /* synthetic */ void onABRPredictBitrate(int i2, int i3) {
        VideoEngineCallback.CC.$default$onABRPredictBitrate(this, i2, i3);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onAVBadInterlaced(Map map) {
        VideoEngineCallback.CC.$default$onAVBadInterlaced(this, map);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onBufferEnd(int i2) {
        VideoEngineCallback.CC.$default$onBufferEnd(this, i2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onBufferStart(int i2, int i3, int i4) {
        VideoEngineCallback.CC.$default$onBufferStart(this, i2, i3, i4);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine tTVideoEngine, int i2) {
        VideoEngineCallback.CC.$default$onCurrentPlaybackTimeUpdate(this, tTVideoEngine, i2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onFirstAVSyncFrame(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onFrameAboutToBeRendered(TTVideoEngine tTVideoEngine, int i2, long j, long j2, Map map) {
        VideoEngineCallback.CC.$default$onFrameAboutToBeRendered(this, tTVideoEngine, i2, j, j2, map);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onFrameDraw(int i2, Map map) {
        VideoEngineCallback.CC.$default$onFrameDraw(this, i2, map);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onInfoIdChanged(int i2) {
        VideoEngineCallback.CC.$default$onInfoIdChanged(this, i2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onPlayUrlChanged(int i2, String str, String str2) {
        VideoEngineCallback.CC.$default$onPlayUrlChanged(this, i2, str, str2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onRefreshSurface(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onRefreshSurface(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onSARChanged(int i2, int i3) {
        VideoEngineCallback.CC.$default$onSARChanged(this, i2, i3);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ int onSetSurface(TTVideoEngine tTVideoEngine, VideoSurface videoSurface, Surface surface) {
        return VideoEngineCallback.CC.$default$onSetSurface(this, tTVideoEngine, videoSurface, surface);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onStreamChanged(TTVideoEngine tTVideoEngine, int i2) {
        VideoEngineCallback.CC.$default$onStreamChanged(this, tTVideoEngine, i2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoSecondFrame(TTVideoEngine tTVideoEngine) {
        VideoEngineCallback.CC.$default$onVideoSecondFrame(this, tTVideoEngine);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i2, int i3) {
        VideoEngineCallback.CC.$default$onVideoSizeChanged(this, tTVideoEngine, i2, i3);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoStatusException(int i2) {
        VideoEngineCallback.CC.$default$onVideoStatusException(this, i2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoStreamBitrateChanged(Resolution resolution, int i2) {
        VideoEngineCallback.CC.$default$onVideoStreamBitrateChanged(this, resolution, i2);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public /* synthetic */ void onVideoURLRouteFailed(Error error, String str) {
        VideoEngineCallback.CC.$default$onVideoURLRouteFailed(this, error, str);
    }

    class c implements Runnable {
        final /* synthetic */ int a;

        @Override // java.lang.Runnable
        public void run() {
            IPlayer.PlayerListener playerListener = m.this.b;
            if (playerListener != null) {
                playerListener.onBufferingUpdate(this.a);
            }
        }

        c(int i) {
            this.a = i;
        }
    }

    class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            IPlayer.PlayerListener playerListener = m.this.b;
            if (playerListener != null) {
                playerListener.onPlayerPrepare();
            }
        }

        d() {
        }
    }

    private void v() {
        this.n = false;
        this.m.removeMessages(257);
    }

    class f implements Runnable {
        final /* synthetic */ Resolution a;
        final /* synthetic */ Resolution b;

        @Override // java.lang.Runnable
        public void run() {
            Resolution resolution;
            IPlayer.PlayerListener playerListener = m.this.b;
            if (playerListener != null) {
                playerListener.onPlayerRenderStart();
                Resolution resolution2 = this.a;
                if (resolution2 != null && resolution2 != (resolution = this.b)) {
                    m.this.b.onResolutionChange(resolution2, resolution);
                }
            }
        }

        f(Resolution resolution, Resolution resolution2) {
            this.a = resolution;
            this.b = resolution2;
        }
    }

    class g implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.b != null) {
                m.r.d("onCompletion", new Object[0]);
                m mVar = m.this;
                mVar.b.onPlayCompletion(mVar.c);
            }
        }

        g() {
        }
    }

    class h implements Runnable {
        final /* synthetic */ Error a;

        @Override // java.lang.Runnable
        public void run() {
            int i;
            m mVar = m.this;
            IPlayer.PlayerListener playerListener = mVar.b;
            if (playerListener != null) {
                IPlayer iPlayer = mVar.c;
                Error error = this.a;
                if (error == null) {
                    i = 0;
                } else {
                    i = error.code;
                }
                playerListener.onError(iPlayer, i, null);
            }
        }

        h(Error error) {
            this.a = error;
        }
    }

    static {
        Covode.recordClassIndex(655959);
        r = new bl6.a("FMSDKPlayerTrace-VideoEngineListenerWrapper");
        s = 0L;
        t = 0L;
        u = 0L;
        v = 0L;
        w = 0L;
    }

    private boolean l() {
        nk6.b bVar = lk6.c.a.l;
        if (bVar != null && bVar.y0(this.f)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        boolean z;
        IPlayer.PlayerListener playerListener = this.b;
        if (playerListener != null) {
            if (!this.e && this.d) {
                z = true;
            } else {
                z = false;
            }
            playerListener.onReadyToDisplay(z);
        }
    }

    private boolean n() {
        nk6.b bVar;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.l) != null && bVar.w(this.f) && Looper.myLooper() != Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.n = true;
        this.m.removeMessages(257);
        this.m.sendMessageDelayed(this.m.obtainMessage(257), this.k);
    }

    class b implements Runnable {
        final /* synthetic */ int a;

        @Override // java.lang.Runnable
        public void run() {
            m mVar = m.this;
            IPlayer.PlayerListener playerListener = mVar.b;
            if (playerListener != null) {
                int i = this.a;
                if (i == 1) {
                    playerListener.onUIStateChange(mVar.c, 303);
                    return;
                }
                if (i == 2) {
                    playerListener.onUIStateChange(mVar.c, 302);
                } else if (i == 0 || i == 3) {
                    playerListener.onUIStateChange(mVar.c, 301);
                }
            }
        }

        b(int i) {
            this.a = i;
        }
    }

    class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            IPlayer.PlayerListener playerListener = m.this.b;
            if (playerListener != null) {
                playerListener.onPlayerPrepared();
                TTVideoEngine tTVideoEngine = m.this.a;
                if (tTVideoEngine != null && tTVideoEngine.isSystemPlayer()) {
                    m mVar = m.this;
                    mVar.b.onPlayStateChange(mVar.c, 103);
                    m.this.t();
                }
            }
        }

        e() {
        }
    }

    public void o() {
        if (this.i && this.h != 2 && this.b != null) {
            r.d("VideoEngineListenerWrapper", "pause, delivery pause callback for looper play, stopCallbackCount = " + this.j);
            this.b.onPlayStateChange(this.c, 101);
            this.j = this.j + 1;
        }
    }

    public void u() {
        if (this.i && this.h != 0 && this.b != null) {
            r.d("stop, delivery stop callback for looper play, stopCallbackCount = " + this.j, new Object[0]);
            this.b.onPlayStateChange(this.c, 101);
            this.j = this.j + 1;
        }
    }

    class a implements Runnable {
        final /* synthetic */ int a;

        @Override // java.lang.Runnable
        public void run() {
            m mVar = m.this;
            if (mVar.b != null) {
                int i = this.a;
                if (i != 1) {
                    if (i != 3) {
                        if (i == 2 || i == 0) {
                            if (mVar.j > 0) {
                                m.r.d("onPlaybackStateChanged, delivery stop or pause callback for looper play, playbackState = " + this.a + ", stopCallbackCount = " + m.this.j, new Object[0]);
                                m.d(m.this);
                                return;
                            }
                            m mVar2 = m.this;
                            mVar2.b.onPlayStateChange(mVar2.c, 101);
                            return;
                        }
                        return;
                    }
                    mVar.q();
                    m mVar3 = m.this;
                    mVar3.b.onPlayStateChange(mVar3.c, 102);
                    return;
                }
                mVar.q();
                m mVar4 = m.this;
                mVar4.b.onPlayStateChange(mVar4.c, 103);
            }
        }

        a(int i) {
            this.a = i;
        }
    }

    private void k() {
        TTVideoEngine tTVideoEngine;
        try {
            nk6.b bVar = lk6.c.a.l;
            if ((bVar != null && !bVar.R()) || (tTVideoEngine = this.a) == null) {
                return;
            }
            IVideoEventLogger logger = tTVideoEngine.getLogger();
            if (logger instanceof VideoEventLoggerV2) {
                Object obj = Reflect.on(logger).get("prepare_before_play_t", new Class[0]);
                Object obj2 = Reflect.on(logger).get("mEvent", new Class[0]);
                if (obj2 instanceof VideoEventOnePlay) {
                    long j = ((VideoEventOnePlay) obj2).pt_new;
                    if (j > 0 && (obj instanceof Long)) {
                        long longValue = ((Long) obj).longValue();
                        bl6.a aVar = r;
                        StringBuilder sb = new StringBuilder();
                        sb.append("isEnginePrepare, prepareBeforePlayTs = ");
                        sb.append(longValue);
                        sb.append(" , ptNew = ");
                        sb.append(j);
                        sb.append(", gapTime = ");
                        float f2 = (j - longValue) / 1000.0f;
                        sb.append(f2);
                        aVar.d(sb.toString(), new Object[0]);
                        if (longValue > 0) {
                            al6.b.e.w(true, f2);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            r.d("isEnginePrepare, e.getMessage() = " + e2.getMessage(), new Object[0]);
        }
    }

    private void p() {
        bl6.a aVar = r;
        aVar.a("从点击切章按钮到首帧结束，click, play time = " + (System.currentTimeMillis() - u), new Object[0]);
        aVar.a("manager, play time = " + (System.currentTimeMillis() - v), new Object[0]);
        aVar.a("stop end, play time = " + (System.currentTimeMillis() - w), new Object[0]);
        aVar.a("first frame time = " + (System.currentTimeMillis() - t), new Object[0]);
        aVar.a("play time = " + (System.currentTimeMillis() - s), new Object[0]);
        s = 0L;
        t = 0L;
        u = 0L;
        v = 0L;
        w = 0L;
    }

    class i implements WeakHandler.IHandler {
        i() {
        }

        public void handleMsg(Message message) {
            TTVideoEngine tTVideoEngine;
            m mVar;
            IPlayer.PlayerListener playerListener;
            m mVar2 = m.this;
            if (mVar2.b != null && mVar2.n && (tTVideoEngine = m.this.a) != null) {
                if (message.what == 257) {
                    boolean isSystemPlayer = tTVideoEngine.isSystemPlayer();
                    if (m.this.a.getPlaybackState() == 1 || isSystemPlayer) {
                        try {
                            int currentPlaybackTime = m.this.a.getCurrentPlaybackTime();
                            int duration = m.this.a.getDuration();
                            if (currentPlaybackTime > 0 && currentPlaybackTime < duration && (playerListener = (mVar = m.this).b) != null) {
                                playerListener.onProgressUpdate(mVar.c, currentPlaybackTime, duration);
                            }
                        } catch (Throwable th) {
                            m.r.d(th.getMessage(), new Object[0]);
                        }
                    }
                }
                m.this.m.removeMessages(257);
                m.this.m.sendMessageDelayed(m.this.m.obtainMessage(257), m.this.k);
            }
        }
    }

    static /* synthetic */ int d(m mVar) {
        int i2 = mVar.j;
        mVar.j = i2 - 1;
        return i2;
    }

    public void s(boolean z) {
        this.d = z;
        if (z) {
            this.e = false;
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onCompletion(TTVideoEngine tTVideoEngine) {
        j(new g());
    }

    private void j(Runnable runnable) {
        if (n()) {
            r.d("checkAndThrowToMainThread: now in Sub Thread", new Object[0]);
            xk6.g.f(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onReadyForDisplay(TTVideoEngine tTVideoEngine) {
        r.d("onReadyForDisplay: engine = " + tTVideoEngine + ", prepareOnly = " + this.d + ", realStartPlay = " + this.e, new Object[0]);
        j(new Runnable() { // from class: com.xs.fm.player.sdk.play.player.audio.engine.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.m();
            }
        });
    }

    public m(TTVideoEngine tTVideoEngine) {
        nk6.b bVar;
        this.h = 0;
        this.k = 500L;
        this.a = tTVideoEngine;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.l) != null) {
            this.k = bVar.G();
        }
        if (tTVideoEngine != null) {
            this.h = tTVideoEngine.getPlaybackState();
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPrepare(TTVideoEngine tTVideoEngine) {
        zk6.c.n(new zk6.b("engine_prepare", 30));
        j(new d());
        r.d("onPrepare:  ,this = " + this + ", thread = " + Thread.currentThread() + ", prepareOnly = " + this.d, new Object[0]);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPrepared(TTVideoEngine tTVideoEngine) {
        zk6.c.n(new zk6.b("engine_prepared", 40));
        j(new e());
        if (this.d) {
            ql6.e.b(false, this.f);
        }
        r.d("onPrepared: ,this = " + this + ", thread = " + Thread.currentThread() + ", prepareOnly = " + this.d, new Object[0]);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onError(Error error) {
        String str;
        int i2;
        int i3;
        PlayAddress playAddress;
        if (error != null) {
            i2 = error.code;
            str = error.description;
        } else {
            str = "";
            i2 = 0;
        }
        bl6.a aVar = r;
        aVar.b("onError: errorCode = " + i2 + " , errMsg = " + str + ", preparedOnly = " + this.d + ", realStartPlay = " + this.e, new Object[0]);
        if (!this.e && this.d) {
            aVar.b("onError: error when try prepare early", new Object[0]);
            PlayEngineInfo playEngineInfo = this.f;
            if (playEngineInfo != null && (playAddress = playEngineInfo.playAddress) != null) {
                ql6.e.c(playEngineInfo.itemId, playAddress.tag, playEngineInfo.genreType, i2, str);
                return;
            }
            return;
        }
        j(new h(error));
        PlayEngineInfo playEngineInfo2 = this.f;
        if (playEngineInfo2 != null) {
            i3 = playEngineInfo2.genreType;
        } else {
            i3 = -1;
        }
        zk6.c.j(Integer.valueOf(i3), "engine_error", i2, str);
        zk6.c.o();
        ml6.b.a.g(this.f, "audio_player", "engine_error", i2, str);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onRenderStart(TTVideoEngine tTVideoEngine) {
        PlayAddress playAddress;
        PlayAddress playAddress2;
        boolean z = this.d;
        if (z) {
            s(false);
            onPrepare(tTVideoEngine);
            onPrepared(tTVideoEngine);
            r.d("csccsc onRenderStart: HitAudioPrepare", new Object[0]);
            ql6.e.a(this.f);
            zk6.c.t("has_hit_prepare", "1");
            al6.b.e.C(true);
        } else {
            zk6.c.t("has_hit_prepare", "0");
        }
        k();
        Resolution resolution = null;
        lk6.c.a.f.onEvent("v3_render_start", null);
        zk6.c.q("engine_render_time", tTVideoEngine.getLongOption(615));
        zk6.c.i(new zk6.b("engine_renderStart", 50));
        al6.b.e.u();
        PlayEngineInfo playEngineInfo = this.f;
        if (playEngineInfo != null && (playAddress2 = playEngineInfo.playAddress) != null) {
            resolution = this.g.get(playAddress2.tag);
        }
        Resolution currentResolution = this.a.getCurrentResolution();
        j(new f(resolution, currentResolution));
        PlayEngineInfo playEngineInfo2 = this.f;
        if (playEngineInfo2 != null && (playAddress = playEngineInfo2.playAddress) != null) {
            this.g.put(playAddress.tag, currentResolution);
            r.d("onRenderStart: genreType=" + this.f.genreType + ", currentResolution=" + currentResolution + ", lastResolution=" + resolution, new Object[0]);
        }
        r.d("csccsc onRenderStart: volume balance is enable = " + tTVideoEngine.getIntOption(655) + ",thread = " + Thread.currentThread() + ", prepareOnly = " + z, new Object[0]);
        p();
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onSilenceDetected(TTVideoEngine tTVideoEngine) {
        if (!lk6.c.a.l.i()) {
            return;
        }
        int O = lk6.c.a.l.O();
        int s0 = lk6.c.a.l.s0();
        int y = lk6.c.a.l.y();
        if (O > 0 && s0 > 0) {
            bl6.a aVar = r;
            aVar.d("onSilenceDetected, upTime=" + O + " , downTime=" + s0 + " , reportLimitCount=" + y + " , engine = " + tTVideoEngine, new Object[0]);
            long currentTimeMillis = System.currentTimeMillis() - this.o;
            if (currentTimeMillis > s0 && currentTimeMillis < O) {
                int i2 = this.p + 1;
                this.p = i2;
                if (i2 == 1) {
                    this.q = System.currentTimeMillis();
                }
                aVar.d("onSilenceDetected, start continuousSilenceCount = " + this.p, new Object[0]);
                if (this.p >= y) {
                    aVar.d("onSilenceDetected, reportSilenceEvent continuousSilenceCount = " + this.p, new Object[0]);
                    ml6.b.a.h(System.currentTimeMillis() - this.q, tTVideoEngine.getCurrentPlaybackTime());
                    this.p = 0;
                }
            }
            this.o = System.currentTimeMillis();
        }
    }

    public void r(IPlayer.PlayerListener playerListener, IPlayer iPlayer) {
        TTVideoEngine tTVideoEngine;
        this.b = playerListener;
        this.c = iPlayer;
        if (playerListener != null && (tTVideoEngine = this.a) != null && tTVideoEngine.getPlaybackState() == 1) {
            t();
        } else {
            v();
        }
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i2) {
        r.d("onBufferingUpdate: percent = " + i2 + ", prepareOnly = " + this.d, new Object[0]);
        j(new c(i2));
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i2) {
        r.d("onLoadStateChanged: loadState = " + i2 + ", engine = " + tTVideoEngine + ", prepareOnly = " + this.d, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (l() && this.h != 1) {
            return;
        }
        j(new b(i2));
        zk6.c.q("engine_load_state_" + i2, System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // com.ss.ttvideoengine.VideoEngineCallback
    public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i2) {
        r.d("onPlaybackStateChanged: playbackState = " + i2 + ", engine = " + tTVideoEngine + ", prepareOnly = " + this.d, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        this.h = i2;
        if (i2 == 1) {
            al6.b bVar = al6.b.e;
            bVar.q("engine_playing", System.currentTimeMillis());
            bVar.p();
            t();
        } else {
            v();
            this.p = 0;
        }
        j(new a(i2));
        zk6.c.q("engine_play_state_" + i2, System.currentTimeMillis() - currentTimeMillis);
    }
}
