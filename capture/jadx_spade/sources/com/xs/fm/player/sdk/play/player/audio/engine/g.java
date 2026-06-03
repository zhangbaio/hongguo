package com.xs.fm.player.sdk.play.player.audio.engine;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoCacheManager;
import com.ss.ttvideoengine.VideoEngineGetInfoListener;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AudioDeviceInfoForPlay;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfoFromServer;
import com.xs.fm.player.base.play.player.IPlayer;
import com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import xk6.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g implements IAudioPlayer, ql6.h {
    static boolean A;
    protected static final bl6.a z;
    private long a;
    private Context b;
    private Handler c;
    protected TTVideoEngine d;
    IPlayer.PlayerListener e;
    private m f;
    private ol6.a g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private ArrayList<HashMap<String, Object>> n;
    private long o;
    private HandlerThread p;
    private Handler q;
    private EngineLooperMonitor r;
    private Boolean s;
    private yk6.b t;
    private a.b u;
    private PlayEngineInfo v;
    private int w;
    private i x;
    private final Runnable y;

    protected void t() {
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayEngineInfo getCurrentPlayInfo() {
        return this.v;
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public TTVideoEngine getEngine() {
        return this.d;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isReleased() {
        return this.i;
    }

    class a implements a.b {
        @Override // xk6.a.b
        public void onEnterBackground() {
            g.this.L(true);
        }

        @Override // xk6.a.b
        public void onEnterForeground() {
            g.this.L(false);
        }

        a() {
        }
    }

    /* renamed from: com.xs.fm.player.sdk.play.player.audio.engine.g$g, reason: collision with other inner class name */
    class RunnableC0134g implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            g.this.y();
        }

        RunnableC0134g() {
        }
    }

    private static class i implements AudioManager.OnAudioFocusChangeListener {
        private final WeakReference<IPlayer.PlayerListener> a;

        static {
            Covode.recordClassIndex(655949);
        }

        public void c() {
            this.a.clear();
        }

        class a implements Runnable {
            final /* synthetic */ int a;

            @Override // java.lang.Runnable
            public void run() {
                IPlayer.PlayerListener playerListener = (IPlayer.PlayerListener) i.this.a.get();
                if (playerListener != null) {
                    playerListener.onAudioFocusChange(this.a);
                }
            }

            a(int i) {
                this.a = i;
            }
        }

        private boolean d() {
            nk6.b bVar;
            lk6.b bVar2 = lk6.c.a;
            if (bVar2 != null && (bVar = bVar2.l) != null && bVar.w(null) && Looper.myLooper() != Looper.getMainLooper()) {
                return true;
            }
            return false;
        }

        public i(IPlayer.PlayerListener playerListener) {
            this.a = new WeakReference<>(playerListener);
        }

        private void b(Runnable runnable) {
            if (d()) {
                g.z.d("checkAndThrowToMainThread: now in Sub Thread", new Object[0]);
                xk6.g.f(runnable);
            } else {
                runnable.run();
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            bl6.a aVar = g.z;
            aVar.d("onAudioFocusChange focusChange = " + i + " isTrackAudioFocus = " + g.A + " playerListenerRf = " + this.a.get(), new Object[0]);
            if (g.A || this.a.get() == null) {
                return;
            }
            nk6.a aVar2 = lk6.c.a.q;
            if (aVar2 != null && aVar2.c()) {
                b(new a(i));
            } else if (i == -1 || i == -2) {
                aVar.d("AUDIOFOCUS_LOSS || AUDIOFOCUS_LOSS_TRANSIENT, but do nothing", new Object[0]);
            }
        }
    }

    public g() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.d.createPlayer();
    }

    private void I() {
        ol6.a aVar = this.g;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void M() {
        this.c.removeCallbacks(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.n.clear();
        this.o = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.d.release();
        yk6.a.b(this.d);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayAddress getPlayAddress() {
        PlayEngineInfo playEngineInfo = this.v;
        if (playEngineInfo != null) {
            return playEngineInfo.playAddress;
        }
        return null;
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public boolean isEngineLooperBlock() {
        EngineLooperMonitor engineLooperMonitor = this.r;
        if (engineLooperMonitor != null) {
            return engineLooperMonitor.g;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPaused() {
        if (this.d.getPlaybackState() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPlaying() {
        if (this.d.getPlaybackState() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isStopped() {
        TTVideoEngine tTVideoEngine = this.d;
        if (tTVideoEngine == null || tTVideoEngine.getPlaybackState() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void removePlayerListener() {
        this.f.r(null, null);
        this.d.setVideoEngineCallback(null);
        this.e = null;
    }

    static {
        Covode.recordClassIndex(655948);
        z = new bl6.a("FMSDKPlayerTrace-AudioEnginePlayer");
        A = false;
    }

    private void g() {
        z.d("abandonAudioFocusDelay", new Object[0]);
        A = false;
        this.c.removeCallbacks(this.y);
        this.c.postDelayed(this.y, lk6.a.a());
    }

    private int z() {
        int i2 = this.v.playerFocusDurationHint;
        if (-1 != i2) {
            return i2;
        }
        if (lk6.a.c()) {
            return 1;
        }
        return 2;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getDuration() {
        z.d("getDuration", new Object[0]);
        return this.d.getDuration();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getPosition() {
        z.d("getCurrentPosition", new Object[0]);
        return this.d.getCurrentPlaybackTime();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isOsPlayer() {
        TTVideoEngine tTVideoEngine = this.d;
        if (tTVideoEngine != null) {
            return tTVideoEngine.isOSPlayer();
        }
        if (this.h == 2) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void resume() {
        z.d("resume", new Object[0]);
        m mVar = this.f;
        if (mVar != null) {
            mVar.e = true;
        }
        P();
        this.d.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        z.d("doAbandonAudioFocus", new Object[0]);
        try {
            if (this.x != null) {
                nk6.a aVar = lk6.c.a.q;
                if (aVar != null && aVar.a()) {
                    this.x.c();
                }
                IPlayer.PlayerListener playerListener = this.e;
                if (playerListener != null) {
                    playerListener.onAbandonAudioFocus();
                }
                ((AudioManager) this.b.getSystemService("audio")).abandonAudioFocus(this.x);
                this.x = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public AudioDeviceInfoForPlay getCurrentAudioDeviceInfoForPlay() {
        lk6.b bVar = lk6.c.a;
        if (bVar != null && bVar.l.c() && isPlaying()) {
            AudioDeviceInfoForPlay audioDeviceInfoForPlay = new AudioDeviceInfoForPlay();
            audioDeviceInfoForPlay.deviceType = this.d.getIntOption(3013);
            audioDeviceInfoForPlay.deviceName = this.d.getStringOption(3014);
            return audioDeviceInfoForPlay;
        }
        return null;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public float getPercentage() {
        z.d("getPercentage", new Object[0]);
        if (this.d.getDuration() > 0) {
            return (this.d.getCurrentPlaybackTime() * 100.0f) / this.d.getDuration();
        }
        return 0.0f;
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void resetThreadPriority() {
        if (this.p != null && this.s.booleanValue()) {
            z.d("resetThreadPriority threadId=%s", Integer.valueOf((int) this.p.getId()));
            xk6.g.j((int) this.p.getId(), lk6.c.a.l.I());
            this.s = Boolean.FALSE;
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void stop() {
        z.d("stop", new Object[0]);
        this.a = 0L;
        this.l = false;
        lk6.b bVar = lk6.c.a;
        if (bVar.l == null || !bVar.q.b()) {
            g();
        }
        this.d.stop();
        this.f.u();
        ol6.a aVar = this.g;
        if (aVar != null) {
            aVar.j();
        }
        xk6.a.g().i(this.u);
    }

    private void J() {
        if (this.d != null) {
            final PlayAddress playAddress = getPlayAddress();
            Handler handler = this.q;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.xs.fm.player.sdk.play.player.audio.engine.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.D(playAddress);
                    }
                });
                return;
            }
            if (playAddress != null) {
                playAddress.customStr.put("entrance", zk6.c.l.k());
                playAddress.customStr.put("key_play_entrance", this.v.extras.get("key_play_entrance"));
                playAddress.customStr.put("is_foreground_play", Boolean.valueOf(xk6.a.g().b));
                kl6.b.a("is_new_user_first_launch_first_play", this.v.extras.get("is_new_user_first_launch_first_play"), playAddress.customStr);
                kl6.b.a("is_use_cache_data_play", this.v.extras.get("is_use_cache_data_play"), playAddress.customStr);
                this.d.setCustomStr(new JSONObject(playAddress.customStr).toString());
            }
        }
    }

    private void P() {
        A = true;
        bl6.a aVar = z;
        aVar.d("trackAudioFocus", new Object[0]);
        this.c.removeCallbacks(this.y);
        try {
            if (this.x == null) {
                aVar.d("trackAudioFocus real", new Object[0]);
                this.x = new i(this.e);
                ((AudioManager) this.b.getSystemService("audio")).requestAudioFocus(this.x, 3, z());
                IPlayer.PlayerListener playerListener = this.e;
                if (playerListener != null) {
                    playerListener.onRequestAudioFocus();
                }
            }
            this.c.postDelayed(new h(), 1500L);
        } catch (Throwable unused) {
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void promoteThreadPriority() {
        if (this.p != null && !this.s.booleanValue()) {
            if (lk6.c.a.l.J() != 0 || lk6.c.a.l.I()) {
                xk6.g.h((int) this.p.getId(), lk6.c.a.l.J(), lk6.c.a.l.I());
                z.d("promoteThreadPriority threadId=%s  priority=%s  isBoost=%s", Integer.valueOf((int) this.p.getId()), Integer.valueOf(lk6.c.a.l.J()), Boolean.valueOf(lk6.c.a.l.I()));
                this.s = Boolean.TRUE;
            }
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void release() {
        bl6.a aVar = z;
        aVar.d("release", new Object[0]);
        if (this.i) {
            return;
        }
        this.i = true;
        this.l = false;
        this.a = 0L;
        nk6.a aVar2 = lk6.c.a.q;
        if (aVar2 == null || !aVar2.b()) {
            g();
        }
        resetThreadPriority();
        if (isEngineLooperBlock()) {
            aVar.d("release but EngineLooperBlock", new Object[0]);
            EngineLooperMonitor.k(EngineLooperMonitor.g() + 1);
            u(this.d);
            final HandlerThread handlerThread = this.r.d;
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.xs.fm.player.sdk.play.player.audio.engine.b
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.F(handlerThread);
                }
            });
        } else if (lk6.c.a.l.P()) {
            aVar.d("releaseAsync", new Object[0]);
            if (lk6.c.a.r.h()) {
                this.d.stop();
                ThreadPlus.submitRunnable(new Runnable() { // from class: com.xs.fm.player.sdk.play.player.audio.engine.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.G();
                    }
                });
            } else {
                this.d.releaseAsync();
            }
        } else {
            aVar.d("release", new Object[0]);
            this.d.release();
            if (lk6.c.a.r.h()) {
                yk6.a.b(this.d);
            }
        }
        ol6.a aVar3 = this.g;
        if (aVar3 != null) {
            aVar3.j();
        }
        xk6.a.g().i(this.u);
        EngineLooperMonitor engineLooperMonitor = this.r;
        if (engineLooperMonitor != null) {
            engineLooperMonitor.m();
        }
    }

    class b implements VideoEngineInfoListener {
        b() {
        }

        @Override // com.ss.ttvideoengine.VideoEngineInfoListener
        public void onVideoEngineInfos(VideoEngineInfos videoEngineInfos) {
            bl6.a aVar = g.z;
            boolean z = false;
            aVar.d("onVideoEngineInfos, videoEngineInfos = " + videoEngineInfos, new Object[0]);
            if (videoEngineInfos == null) {
                return;
            }
            g gVar = g.this;
            IPlayer.PlayerListener playerListener = gVar.e;
            if (playerListener != null) {
                playerListener.onVideoEngineInfos(gVar, videoEngineInfos);
            }
            if (!videoEngineInfos.getKey().equals("mdlhitcachesize") && !videoEngineInfos.getKey().equals("mdlfilepathhitcachesize")) {
                if (videoEngineInfos.getKey().equals("mdlcacheend") && g.this.g != null) {
                    g.this.g.g();
                    return;
                }
                return;
            }
            String usingMDLPlayTaskKey = videoEngineInfos.getUsingMDLPlayTaskKey();
            long usingMDLHitCacheSize = videoEngineInfos.getUsingMDLHitCacheSize();
            aVar.d("onVideoEngineInfos, usingKey = " + usingMDLPlayTaskKey + ", hitCacheSize = " + usingMDLHitCacheSize + ", playItemId = " + g.this.v.itemId, new Object[0]);
            if (usingMDLHitCacheSize > 0) {
                if (!g.this.k) {
                    zk6.c.t("has_hit_preload", "1");
                    al6.b.e.B(true, usingMDLHitCacheSize);
                } else {
                    g.this.l = true;
                    g.this.m = usingMDLHitCacheSize;
                }
            }
            if (g.this.a <= 0 && usingMDLHitCacheSize > 0) {
                g.this.a = usingMDLHitCacheSize;
                z = true;
            }
            pl6.b.a(usingMDLPlayTaskKey, usingMDLHitCacheSize, g.this.v, z);
        }
    }

    class d implements VideoEngineGetInfoListener {
        @Override // com.ss.ttvideoengine.VideoEngineGetInfoListener
        public /* synthetic */ Map getInfoMap(int i) {
            return VideoEngineGetInfoListener.CC.$default$getInfoMap(this, i);
        }

        d() {
        }

        @Override // com.ss.ttvideoengine.VideoEngineGetInfoListener
        public Object getInfo(int i) {
            if (i != 1) {
                if (i == 2) {
                    return g.this.n;
                }
                if (i != 3) {
                    return null;
                }
                if (!g.this.n.isEmpty()) {
                    return Long.valueOf(g.this.o);
                }
                return -1;
            }
            return Integer.valueOf(!xk6.a.g().b ? 1 : 0);
        }
    }

    class e implements sk6.b {
        e() {
        }

        @Override // sk6.b
        public void a(long j) {
            g gVar = g.this;
            IPlayer.PlayerListener playerListener = gVar.e;
            if (playerListener != null) {
                playerListener.onReachDynamicBuffer(gVar, false, j);
            }
        }

        @Override // sk6.b
        public void b(long j) {
            g gVar = g.this;
            IPlayer.PlayerListener playerListener = gVar.e;
            if (playerListener != null) {
                playerListener.onReachDynamicBuffer(gVar, true, j);
            }
        }
    }

    class h implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            g.A = false;
        }

        h() {
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void configAudioResolution(Resolution resolution) {
        this.d.configResolution(resolution);
    }

    class c extends m {
        @Override // com.xs.fm.player.sdk.play.player.audio.engine.m, com.ss.ttvideoengine.VideoEngineCallback
        public void onError(Error error) {
            int i;
            super.onError(error);
            g gVar = g.this;
            if (error == null) {
                i = 0;
            } else {
                i = error.code;
            }
            gVar.R(i);
        }

        c(TTVideoEngine tTVideoEngine) {
            super(tTVideoEngine);
        }

        @Override // com.xs.fm.player.sdk.play.player.audio.engine.m, com.ss.ttvideoengine.VideoEngineCallback
        public void onBufferStart(int i, int i2, int i3) {
            super.onBufferStart(i, i2, i3);
            if (g.this.g != null) {
                g.this.g.f();
            }
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlayerListener(IPlayer.PlayerListener playerListener) {
        this.f.r(playerListener, this);
        this.d.setVideoEngineCallback(this.f);
        this.e = playerListener;
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeAudioLoudestInfo(pk6.a aVar) {
        if (this.v != null) {
            z.d("changeAudioLoudestInfo", new Object[0]);
            this.v.getClass();
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void pause(boolean z2) {
        z.d("pause", new Object[0]);
        if (z2) {
            g();
        }
        this.d.pause();
        this.f.o();
    }

    class f implements SeekCompletionListener {
        final /* synthetic */ long a;

        @Override // com.ss.ttvideoengine.SeekCompletionListener
        public void onCompletion(boolean z) {
            g.z.d("seekTo:" + this.a + ", success=" + z, new Object[0]);
        }

        f(long j) {
            this.a = j;
        }
    }

    private void A(TTVideoEngine tTVideoEngine) {
        if (tTVideoEngine != null && lk6.c.a.r.h()) {
            z.d("handleAudioEffect", new Object[0]);
            yk6.a.a(lk6.c.a.b, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(HandlerThread handlerThread) {
        if (handlerThread != null) {
            handlerThread.interrupt();
        }
        this.d.release();
        EngineLooperMonitor.k(EngineLooperMonitor.g() - 1);
        z.d("release", new Object[0]);
        if (lk6.c.a.r.h()) {
            yk6.a.b(this.d);
        }
    }

    private void H(PlayEngineInfo playEngineInfo) {
        zk6.c.n(new zk6.b("engine_play", 20));
        zk6.c.t("play_type", "play_audio");
        zk6.c.t("genre_type", playEngineInfo.genreType + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z2) {
        if (this.n.isEmpty()) {
            this.o = System.currentTimeMillis();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("is_back2fore", Integer.valueOf(!z2 ? 1 : 0));
        hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
        this.n.add(hashMap);
    }

    private void u(TTVideoEngine tTVideoEngine) {
        try {
            Reflect.on(Reflect.on(Reflect.on(tTVideoEngine).get("mVideoEngine", new Class[0])).get("mLooperThread", new Class[0])).call("closeEngineLooperThread");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeAudioEffect(pk6.a aVar) {
        if (this.v != null) {
            z.d("changeAudioEffect, mPlayEngineInfo = " + this.v, new Object[0]);
            this.v.getClass();
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void seekTo(long j) {
        z.d("seekTo:" + j, new Object[0]);
        this.d.seekTo((int) j, new f(j));
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlaySpeed(int i2) {
        z.d("setPlaySpeed speed=%d", Integer.valueOf(i2));
        PlaybackParams playbackParams = new PlaybackParams();
        playbackParams.setPitch(1.0f);
        playbackParams.setSpeed(i2 / 100.0f);
        try {
            this.d.setPlaybackParams(playbackParams);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void switchPlayer(IAudioPlayer iAudioPlayer) {
        iAudioPlayer.setPlayerListener(this.f.b);
        removePlayerListener();
        release();
        nk6.a aVar = lk6.c.a.q;
        if (aVar == null || !aVar.a()) {
            this.c.removeCallbacks(this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(PlayAddress playAddress) {
        if (playAddress != null) {
            playAddress.customStr.put("entrance", zk6.c.l.k());
            playAddress.customStr.put("key_play_entrance", this.v.extras.get("key_play_entrance"));
            playAddress.customStr.put("is_foreground_play", Boolean.valueOf(xk6.a.g().b));
            kl6.b.a("is_new_user_first_launch_first_play", this.v.extras.get("is_new_user_first_launch_first_play"), playAddress.customStr);
            kl6.b.a("is_use_cache_data_play", this.v.extras.get("is_use_cache_data_play"), playAddress.customStr);
            this.d.setCustomStr(new JSONObject(playAddress.customStr).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i2) {
        PlayEngineInfo playEngineInfo;
        boolean z2;
        if (!this.j && (playEngineInfo = this.v) != null && !TextUtils.isEmpty(playEngineInfo.backUrl)) {
            z.d("try play backupUrl", new Object[0]);
            this.j = true;
            PlayEngineInfo playEngineInfo2 = this.v;
            String str = playEngineInfo2.backUrl;
            PlayAddress playAddress = playEngineInfo2.playAddress;
            String str2 = playAddress.mdlCachePath;
            if (playAddress.volumeBalanceType != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            S(str, str2, z2, playAddress.volumeBalanceSrcLoudness, playAddress.volumeBalanceLoudPeak);
            return;
        }
        z.d("tried backupUrl, now callback biz error, code = " + i2, new Object[0]);
        g();
    }

    private void v(PlayEngineInfo playEngineInfo) {
        if (playEngineInfo != null && playEngineInfo.playAddress != null) {
            this.d.setStartTime((int) playEngineInfo.playPosition);
            this.f.f = this.v;
            this.d.setTag(playEngineInfo.playAddress.tag);
            Resolution resolution = playEngineInfo.resolution;
            if (resolution != null) {
                this.d.configResolution(resolution);
            }
            if (!TextUtils.isEmpty(playEngineInfo.playAddress.subTag)) {
                this.d.setSubTag(playEngineInfo.playAddress.subTag);
            }
            setPlaySpeed(playEngineInfo.speed);
            Q(this.d, playEngineInfo);
        }
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeVoiceBgmInfo(VoiceBgmInfo voiceBgmInfo) {
        if (this.v != null) {
            bl6.a aVar = z;
            aVar.d("changeVoiceBgmInfo", new Object[0]);
            if (voiceBgmInfo != null) {
                aVar.d("changeVoiceBgmInfo, playEngineInfo = " + this.v + ", voiceBgmInfo = " + voiceBgmInfo, new Object[0]);
            }
            PlayEngineInfo playEngineInfo = this.v;
            playEngineInfo.voiceBgmInfo = voiceBgmInfo;
            PlayAddress playAddress = playEngineInfo.playAddress;
            if (playAddress.playType == 1 && playAddress.voiceBgmInfoFromServer != null) {
                n.h(this.d, voiceBgmInfo);
                return;
            }
            n.h(this.d, voiceBgmInfo);
            if (voiceBgmInfo.bgmRate != voiceBgmInfo.voiceRate) {
                PlayAddress playAddress2 = this.v.playAddress;
                if (TextUtils.equals(playAddress2.voiceBgmInfoFromServer.originVideoModelStr, playAddress2.playVideoModel)) {
                    PlayAddress playAddress3 = this.v.playAddress;
                    VoiceBgmInfoFromServer voiceBgmInfoFromServer = playAddress3.voiceBgmInfoFromServer;
                    playAddress3.playVideoModel = voiceBgmInfoFromServer.bgmVideoModelStr;
                    playAddress3.videoModel = voiceBgmInfoFromServer.bgmVideoModel;
                    int currentPlaybackTime = this.d.getCurrentPlaybackTime();
                    stop();
                    play(this.v);
                    this.d.setStartTime(currentPlaybackTime);
                    n.g(this.d, this.v);
                    this.d.setVideoModel(this.v.playAddress.videoModel);
                    aVar.d("changeVoiceBgmInfo, videoModel change to four channel, setStartTime progress = " + currentPlaybackTime, new Object[0]);
                    this.d.play();
                }
            }
        }
    }

    public g(int i2) {
        this.a = 0L;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = 0L;
        this.n = new ArrayList<>();
        this.o = -1L;
        this.s = Boolean.FALSE;
        this.u = new a();
        this.w = -1;
        this.y = new RunnableC0134g();
        lk6.b bVar = lk6.c.a;
        this.b = bVar.b;
        this.h = i2;
        if (bVar.c) {
            TTVideoEngineLog.turnOn(1, 1);
        }
        VideoCacheManager.getInstance().setMaxSize(lk6.a.b());
        this.c = new HandlerDelegate(Looper.getMainLooper());
        HashMap hashMap = new HashMap();
        hashMap.put("scene", "audio_player");
        boolean f0 = lk6.c.a.l.f0();
        if (f0) {
            hashMap.put("enable_looper", Boolean.TRUE);
            this.p = lk6.c.a.l.D();
            Looper X = lk6.c.a.l.X();
            HandlerThread handlerThread = this.p;
            if (handlerThread != null) {
                hashMap.put("handler_thread", handlerThread);
                this.q = new HandlerDelegate(this.p.getLooper());
                if (!lk6.c.a.l.l0()) {
                    hashMap.put("handler_thread_not_allow_destroy", 1);
                }
            } else if (lk6.c.a.l.N()) {
                HandlerThread handlerThread2 = new HandlerThread("engineMsgLooper");
                this.p = handlerThread2;
                handlerThread2.start();
                hashMap.put("handler_thread", this.p);
                this.q = new HandlerDelegate(this.p.getLooper());
                EngineLooperMonitor engineLooperMonitor = new EngineLooperMonitor();
                this.r = engineLooperMonitor;
                engineLooperMonitor.l(this.p);
                hashMap.put("handler_thread_not_allow_destroy", 0);
            }
            if (X != null) {
                hashMap.put("callback_looper", X);
            }
        }
        TTVideoEngine tTVideoEngine = new TTVideoEngine(this.b, this.h, hashMap);
        this.d = tTVideoEngine;
        tTVideoEngine.setNetworkClient(new k());
        this.d.setVideoEngineInfoListener(new b());
        n.c(this.d, false);
        this.f = new c(this.d);
        if (lk6.c.a.l.t()) {
            this.f.i = f0;
        }
        this.d.setVideoEngineCallback(this.f);
        this.d.setVideoEngineGetInfoListener(new d());
        if (this.q != null && lk6.c.a.l.f()) {
            this.q.post(new Runnable() { // from class: com.xs.fm.player.sdk.play.player.audio.engine.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.C();
                }
            });
        }
    }

    public void K(PlayEngineInfo playEngineInfo) {
        PlayAddress playAddress;
        boolean z2;
        boolean z3;
        if (playEngineInfo != null && (playAddress = playEngineInfo.playAddress) != null && (playAddress.playType != 2 || !TextUtils.isEmpty(playAddress.playVideoModel))) {
            PlayAddress playAddress2 = playEngineInfo.playAddress;
            if (playAddress2.playType != 1 || !TextUtils.isEmpty(playAddress2.playFile)) {
                PlayAddress playAddress3 = playEngineInfo.playAddress;
                if (playAddress3.playType != 0 || !TextUtils.isEmpty(playAddress3.playUrl)) {
                    ml6.a.g.a("AudioEnginePlayer prepare: item = " + playEngineInfo.itemId);
                    z.d("prepare: start, playEngineInfo = %s", playEngineInfo.toString());
                    ql6.e.b(true, playEngineInfo);
                    this.v = playEngineInfo;
                    this.w = (int) playEngineInfo.playPosition;
                    this.k = true;
                    this.f.s(true);
                    if (lk6.c.a.o.m()) {
                        this.d.setIntOption(586, 1);
                    } else {
                        this.d.setIntOption(100, 0);
                        if (lk6.c.a.o.d() || playEngineInfo.enableAudioDevicePrepare) {
                            this.d.setIntOption(371, 1);
                        }
                    }
                    if (lk6.c.a.o.n() > 0) {
                        this.d.setIntOption(491, lk6.c.a.o.n());
                    }
                    n.i(this.d, playEngineInfo);
                    this.d.setAutoRangeRead(2, lk6.c.a.o.c());
                    v(playEngineInfo);
                    N(this.d, playEngineInfo);
                    n.f(this.d, playEngineInfo);
                    PlayAddress playAddress4 = playEngineInfo.playAddress;
                    int i2 = playAddress4.playType;
                    if (i2 == 0) {
                        if (playAddress4.isEncrypt && !TextUtils.isEmpty(playAddress4.encryptionKey)) {
                            this.d.setEncodedKey(playEngineInfo.playAddress.encryptionKey);
                        }
                        try {
                            String decode = URLDecoder.decode(playEngineInfo.playAddress.playUrl, "UTF-8");
                            if (!URLUtil.isNetworkUrl(decode)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            n.b(this.d, new String[]{decode}, playEngineInfo.playAddress.mdlCachePath, z3);
                        } catch (UnsupportedEncodingException unused) {
                            z.b("prepare: play type url decode url error when prepare", new Object[0]);
                        }
                    } else if (i2 == 1) {
                        if (playAddress4.isEncrypt && !TextUtils.isEmpty(playAddress4.encryptionKey)) {
                            this.d.setEncodedKey(playEngineInfo.playAddress.encryptionKey);
                        }
                        try {
                            String decode2 = URLDecoder.decode(playEngineInfo.playAddress.playFile, "UTF-8");
                            if (!URLUtil.isNetworkUrl(decode2)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            n.b(this.d, new String[]{decode2}, playEngineInfo.playAddress.mdlCachePath, z2);
                        } catch (UnsupportedEncodingException unused2) {
                            z.b("prepare: play type file decode url error when prepare", new Object[0]);
                        }
                    } else if (i2 == 2) {
                        n.d(this.d, playAddress4.mdlCachePath);
                        PlayAddress playAddress5 = playEngineInfo.playAddress;
                        VideoModel videoModel = playAddress5.videoModel;
                        if (videoModel != null) {
                            this.d.setVideoModel(videoModel);
                        } else {
                            this.d.setVideoModel(xk6.h.a.c(playAddress5.playVideoModel, "AudioEnginePlayer_prepare"));
                        }
                    }
                    B(false, playEngineInfo);
                    gk6.b bVar = lk6.c.a.r;
                    if (bVar != null) {
                        bVar.e(this.d, playEngineInfo, true);
                    }
                    z.d("prepare: success finish prepare", new Object[0]);
                    com.xs.fm.player.sdk.play.player.audio.engine.i.a.a(this.d, true, false, playEngineInfo.playAddress.tag);
                    t();
                    this.d.prepare();
                    return;
                }
            }
        }
        z.d("prepare: failed, return; playEngineInfo = " + playEngineInfo, new Object[0]);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void play(PlayEngineInfo playEngineInfo) {
        boolean z2;
        boolean z3;
        boolean z4;
        nk6.b bVar;
        if (playEngineInfo != null && playEngineInfo.playAddress != null) {
            if (this.k && this.l) {
                zk6.c.t("has_hit_preload", "1");
                al6.b.e.B(true, this.m);
            }
            this.m = 0L;
            H(playEngineInfo);
            this.j = false;
            PlayEngineInfo playEngineInfo2 = this.v;
            this.v = playEngineInfo;
            bl6.a aVar = z;
            aVar.d("play: begin play, curPlayEngineInfo = %s, lastPlayEngineInfo = %s", playEngineInfo, playEngineInfo2);
            IPlayer.PlayerListener playerListener = this.e;
            if (playerListener != null) {
                playerListener.onPlayerPlay();
            }
            this.d.setIntOption(100, 1);
            this.d.setIntOption(586, 0);
            this.d.setIntOption(371, 0);
            lk6.b bVar2 = lk6.c.a;
            if (bVar2 != null && (bVar = bVar2.l) != null) {
                if (bVar.a()) {
                    this.d.setIntOption(509, 1);
                } else {
                    this.d.setIntOption(509, 0);
                }
            }
            this.d.setAutoRangeRead(0, 819200);
            v(playEngineInfo);
            Q(this.d, playEngineInfo);
            N(this.d, playEngineInfo);
            n.f(this.d, playEngineInfo);
            w(this.d, playEngineInfo);
            com.xs.fm.player.sdk.play.player.audio.engine.i.a.a(this.d, true, true, playEngineInfo.playAddress.tag);
            B(this.k, playEngineInfo);
            gk6.b bVar3 = lk6.c.a.r;
            if (bVar3 != null) {
                bVar3.e(this.d, playEngineInfo, false);
            }
            al6.b bVar4 = al6.b.e;
            bVar4.A(this.d.getTag(), this.d.getSubTag(), Integer.valueOf((int) playEngineInfo.playPosition), Integer.valueOf(this.d.getDuration()), Integer.valueOf(playEngineInfo.playAddress.playType), this.d.getCurrentResolution(), vl6.b.b(playEngineInfo), xk6.h.a.a(playEngineInfo.playAddress, playEngineInfo.resolution));
            bVar4.x(playEngineInfo, this.d, null);
            Handler handler = this.q;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.xs.fm.player.sdk.play.player.audio.engine.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.E();
                    }
                });
            } else {
                this.n.clear();
                this.o = -1L;
            }
            this.a = 0L;
            n.i(this.d, playEngineInfo);
            PlayEngineInfo playEngineInfo3 = this.v;
            if (playEngineInfo3.isOsPlayer) {
                aVar.d("play: tryPlayWithUrl useOsPlayer", new Object[0]);
                PlayAddress playAddress = this.v.playAddress;
                String str = playAddress.playUrl;
                String str2 = playAddress.mdlCachePath;
                if (playAddress.volumeBalanceType != -1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                S(str, str2, z4, playAddress.volumeBalanceSrcLoudness, playAddress.volumeBalanceLoudPeak);
            } else {
                PlayAddress playAddress2 = playEngineInfo3.playAddress;
                int i2 = playAddress2.playType;
                if (i2 == 2) {
                    T(playEngineInfo3, playEngineInfo2);
                    if (TextUtils.isEmpty(this.v.playAddress.playVideoModel)) {
                        aVar.b("play: tryPlay with videoModel, but videoModel is null", new Object[0]);
                        ml6.b.j(playEngineInfo);
                    }
                } else if (i2 == 1) {
                    String str3 = playAddress2.playFile;
                    String str4 = playAddress2.mdlCachePath;
                    if (playAddress2.volumeBalanceType != -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    S(str3, str4, z3, playAddress2.volumeBalanceSrcLoudness, playAddress2.volumeBalanceLoudPeak);
                } else {
                    String str5 = playAddress2.playUrl;
                    String str6 = playAddress2.mdlCachePath;
                    if (playAddress2.volumeBalanceType != -1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    S(str5, str6, z2, playAddress2.volumeBalanceSrcLoudness, playAddress2.volumeBalanceLoudPeak);
                }
            }
            int i3 = this.w;
            if (i3 >= 0) {
                long j = i3;
                long j2 = playEngineInfo.playPosition;
                if (j != j2) {
                    seekTo(j2);
                }
            }
            this.w = -1;
            this.k = false;
            return;
        }
        zk6.c.j(null, "sdk_internal_error", 0, "no playEngineInfo");
        z.d("play: playEngineInfo.playAddress = null, return;", new Object[0]);
    }

    private void Q(TTVideoEngine tTVideoEngine, PlayEngineInfo playEngineInfo) {
        if (tTVideoEngine != null && playEngineInfo != null) {
            n.g(tTVideoEngine, playEngineInfo);
        }
    }

    private void B(boolean z2, PlayEngineInfo playEngineInfo) {
        if (!z2 || this.t == null) {
            this.t = new yk6.b();
        }
        this.t.a(playEngineInfo);
        this.d.setAudioProcessor(this.t);
    }

    private void x(TTVideoEngine tTVideoEngine, PlayEngineInfo playEngineInfo) {
        if (playEngineInfo.dynamicBuffer != null) {
            ol6.a aVar = new ol6.a(tTVideoEngine, playEngineInfo.dynamicBuffer);
            this.g = aVar;
            aVar.a = new e();
        }
    }

    private void w(TTVideoEngine tTVideoEngine, PlayEngineInfo playEngineInfo) {
        sk6.a aVar = playEngineInfo.dynamicBuffer;
        if (aVar != null && aVar.b()) {
            ol6.a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.h();
            }
            ol6.a aVar3 = this.g;
            if (aVar3 == null || !aVar3.g.a(playEngineInfo.dynamicBuffer)) {
                x(tTVideoEngine, playEngineInfo);
                return;
            }
            return;
        }
        ol6.a aVar4 = this.g;
        if (aVar4 != null) {
            aVar4.h();
            this.g = null;
        }
    }

    private void N(TTVideoEngine tTVideoEngine, PlayEngineInfo playEngineInfo) {
        for (Map.Entry<Integer, Object> entry : playEngineInfo.engineOptions.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Integer) {
                tTVideoEngine.setIntOption(entry.getKey().intValue(), ((Integer) value).intValue());
            } else if (value instanceof Long) {
                tTVideoEngine.setLongOption(entry.getKey().intValue(), ((Long) value).longValue());
            } else if (value instanceof Float) {
                tTVideoEngine.setFloatOption(entry.getKey().intValue(), ((Float) value).floatValue());
            } else if (value instanceof String) {
                tTVideoEngine.setStringOption(entry.getKey().intValue(), (String) value);
            }
        }
    }

    private void O(PlayEngineInfo playEngineInfo, PlayEngineInfo playEngineInfo2) {
        String videoRefStr;
        if (playEngineInfo2 != null && TextUtils.equals(playEngineInfo.playAddress.playVideoModel, playEngineInfo2.playAddress.playVideoModel)) {
            if (lk6.c.a.l.u0()) {
                bl6.a aVar = z;
                StringBuilder sb = new StringBuilder();
                sb.append("tryPlayWithVideoModel: set the same videoModel, fallbackapi = ");
                if (this.d.getVideoModel() == null) {
                    videoRefStr = null;
                } else {
                    videoRefStr = this.d.getVideoModel().getVideoRefStr(217);
                }
                sb.append(videoRefStr);
                aVar.d(sb.toString(), new Object[0]);
                TTVideoEngine tTVideoEngine = this.d;
                tTVideoEngine.setVideoModel(tTVideoEngine.getVideoModel());
                return;
            }
            return;
        }
        bl6.a aVar2 = z;
        aVar2.d("tryPlayWithVideoModel: set the different VideoModel", new Object[0]);
        PlayAddress playAddress = playEngineInfo.playAddress;
        VideoModel videoModel = playAddress.videoModel;
        if (videoModel == null) {
            videoModel = xk6.h.a.c(playAddress.playVideoModel, "AudioEnginePlayer_tryPlayWithVideoModel");
        }
        if (playEngineInfo2 != null && lk6.c.a.l.c0()) {
            xk6.h hVar = xk6.h.a;
            if (hVar.d(videoModel, hVar.b(playEngineInfo2.playAddress.playVideoModel))) {
                return;
            }
        }
        if (playEngineInfo.playAddress.voiceBgmInfoFromServer != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setVideoModel: set the different VideoModel, videoModel is two channel = ");
            PlayAddress playAddress2 = playEngineInfo.playAddress;
            sb2.append(TextUtils.equals(playAddress2.playVideoModel, playAddress2.voiceBgmInfoFromServer.originVideoModelStr));
            sb2.append(", isPrepareOnly = ");
            sb2.append(this.k);
            aVar2.d(sb2.toString(), new Object[0]);
        }
        this.d.setVideoModel(videoModel);
    }

    private void T(PlayEngineInfo playEngineInfo, PlayEngineInfo playEngineInfo2) {
        if (playEngineInfo.playAddress.voiceBgmInfoFromServer != null) {
            bl6.a aVar = z;
            StringBuilder sb = new StringBuilder();
            sb.append("tryPlayWithVideoModel: videoModel is two channel = ");
            PlayAddress playAddress = playEngineInfo.playAddress;
            sb.append(TextUtils.equals(playAddress.playVideoModel, playAddress.voiceBgmInfoFromServer.originVideoModelStr));
            sb.append(", isPrepareOnly = ");
            sb.append(this.k);
            aVar.d(sb.toString(), new Object[0]);
        }
        n.d(this.d, playEngineInfo.playAddress.mdlCachePath);
        O(playEngineInfo, playEngineInfo2);
        P();
        A(this.d);
        m.t = System.currentTimeMillis();
        xk6.a.g().e(this.u);
        m mVar = this.f;
        if (mVar != null) {
            mVar.e = true;
        }
        J();
        z.d("tryPlayWithVideoModel: TTVideoEngine play videoPlayModel success, isPrepareOnly = " + this.k, new Object[0]);
        al6.b.e.q("engine_start_play", System.currentTimeMillis());
        this.d.play();
        I();
    }

    private void S(String str, String str2, boolean z2, float f2, float f3) {
        boolean z3;
        PlayAddress playAddress = this.v.playAddress;
        if (playAddress.isEncrypt && !TextUtils.isEmpty(playAddress.encryptionKey)) {
            this.d.setEncodedKey(this.v.playAddress.encryptionKey);
        }
        if (z2) {
            z.d("tryPlayWithUrl: isBalanceEnable loudness = " + f2 + ", loudPeak = " + f3, new Object[0]);
            this.d.setFloatOption(345, f2);
            this.d.setFloatOption(346, f3);
        }
        try {
            if (str == null) {
                zk6.c.j(Integer.valueOf(this.v.genreType), "sdk_internal_error", 0, "no url");
                return;
            }
            String decode = URLDecoder.decode(str, "UTF-8");
            bl6.a aVar = z;
            aVar.d("ryPlayWithUrl: url=%s", decode);
            if (!URLUtil.isNetworkUrl(decode)) {
                z3 = true;
            } else {
                z3 = false;
            }
            n.b(this.d, new String[]{decode}, str2, z3);
            P();
            m mVar = this.f;
            if (mVar != null) {
                mVar.e = true;
            }
            A(this.d);
            m.t = System.currentTimeMillis();
            xk6.a.g().e(this.u);
            J();
            aVar.d("tryPlayWithUrl: TTVideoEngine play url success", new Object[0]);
            al6.b.e.q("engine_start_play", System.currentTimeMillis());
            this.d.play();
            I();
        } catch (UnsupportedEncodingException unused) {
            z.b("tryPlayWithUrl: decode url error", new Object[0]);
            R(-204);
            zk6.c.j(Integer.valueOf(this.v.genreType), "sdk_internal_error", 0, "unsupported encoding");
        }
    }
}
