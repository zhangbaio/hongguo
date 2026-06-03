package il6;

import al2.i0;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsXrayApi;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AbsPlayList;
import com.xs.fm.player.base.play.data.AudioDeviceInfoForPlay;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfo;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import com.xs.fm.player.base.play.inter.IPlayManager;
import com.xs.fm.player.base.play.player.IPlayer;
import com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer;
import com.xs.fm.player.sdk.play.player.audio.engine.m;
import il6.a;
import java.util.HashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.ImplementedInterface;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import rl6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a implements IPlayManager {
    private static final bl6.a v;
    private static a w;
    private pk6.c a;
    private AbsPlayList b;
    private qk6.a j;
    private IPlayer k;
    private jl6.e l;
    private pk6.c n;
    private String q;
    private String c = "";
    private int d = 0;
    private int e = 0;
    private int f = 100;
    private long g = 0;
    private long h = 0;
    private String i = "unKnow";
    boolean m = false;
    int o = -1;
    private long p = 0;
    private qk6.d r = new C0171a();
    private jl6.d s = null;
    private i t = null;
    private IPlayer.PlayerListener u = new h();

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void play(pk6.c cVar) {
        y(this, cVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getCurrentDuration() {
        return (int) this.h;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getCurrentProgress() {
        return (int) this.g;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getCurrentBgNoiseId() {
        return this.e;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public AbsPlayList getCurrentList() {
        return this.b;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public String getCurrentPlayFrom() {
        return this.i;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public pk6.c getCurrentPlayParam() {
        return this.a;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public IPlayer getCurrentPlayer() {
        return this.k;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getCurrentSpeed() {
        return this.f;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public qk6.a getCurrentStrategy() {
        return this.j;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getCurrentTone() {
        return this.d;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public jl6.e getRespOfPlayAddress() {
        return this.l;
    }

    class g implements rk6.b {
        @Override // rk6.b
        public void onCancel() {
            a.this.resume(false);
        }

        @Override // rk6.b
        public void onFinish() {
            a.this.resume(false);
        }

        g() {
        }
    }

    class h implements IPlayer.PlayerListener {
        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onReadyToDisplay(boolean z) {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onAbandonAudioFocus() {
            ll6.d.e.e();
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayerPlay() {
            ll6.d.e.B();
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayerPrepare() {
            ll6.d.e.C();
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayerPrepared() {
            ll6.d.e.D();
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onRequestAudioFocus() {
            ll6.d.e.H();
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayerRenderStart() {
            a.v.d("onPlayerRenderStart", new Object[0]);
            a.this.G("onPlayerRenderStart");
            ll6.d.e.E();
        }

        h() {
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onAudioFocusChange(int i) {
            ll6.d.e.h(i);
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onBufferingUpdate(int i) {
            ll6.d.e.j(i);
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayCompletion(IPlayer iPlayer) {
            final String str;
            a.v.d("onPlayCompletion: playItem:%s", a.this.c);
            a.this.G("onPlayCompletion");
            al6.b.e.s(3);
            if (lk6.c.a.l.i0() && iPlayer != null && iPlayer.getCurrentPlayInfo() != null) {
                PlayEngineInfo currentPlayInfo = iPlayer.getCurrentPlayInfo();
                if (!TextUtils.isEmpty(currentPlayInfo.itemId) && !currentPlayInfo.itemId.equals(a.this.c)) {
                    a.v.d("playItem[%s] != playEngineInfo.itemId[%s], ignore onPlayCompletion callback!!!", a.this.c, currentPlayInfo.itemId);
                    return;
                }
            }
            ll6.d dVar = ll6.d.e;
            dVar.o(iPlayer);
            if (a.this.j == null) {
                a.v.d("playStrategy is null", new Object[0]);
                return;
            }
            if (a.this.c != null) {
                str = a.this.j.g(a.this.b, a.this.c);
            } else {
                str = null;
            }
            if (str == null) {
                dVar.t();
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("from", "play_complete");
            final pk6.c m = a.this.j.m(a.this.b, str, hashMap);
            a.this.j.v(m, "play_complete");
            ll6.c.j.p(new Runnable() { // from class: il6.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.h.this.b(m, str);
                }
            });
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onResolutionChange(Resolution resolution, Resolution resolution2) {
            ll6.d.e.J(resolution, resolution2);
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onVideoEngineInfos(IPlayer iPlayer, VideoEngineInfos videoEngineInfos) {
            ll6.d.e.Q(iPlayer, videoEngineInfos);
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onUIStateChange(IPlayer iPlayer, int i) {
            nk6.b bVar;
            a.v.d("onUIStateChange: {state=%d} ", Integer.valueOf(i));
            lk6.b bVar2 = lk6.c.a;
            if (bVar2 != null && (bVar = bVar2.l) != null && !bVar.g0() && i == 303) {
                a.this.G("onUIStateChange playable");
                a.this.m = true;
            }
            ll6.d.e.P(iPlayer, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(pk6.c cVar, String str) {
            ll6.d.e.w(true, cVar);
            if (a.this.b != null) {
                a.v.d("onPlayCompletion: {curPlayListId=%s, ,currentPlayItem=%s, nextItem=%s, nextPlayParam=%s}", a.this.b.getListId(), a.this.c, str, cVar);
            }
            zk6.c.u("play_completion_auto_change_duration");
            HashMap hashMap = new HashMap();
            hashMap.put("business_start_case", "play_completion_auto_change_duration");
            a.this.play(cVar, new kl6.c("PlayManager_onPlayCompletion", hashMap));
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onPlayStateChange(IPlayer iPlayer, int i) {
            lk6.b bVar;
            nk6.b bVar2;
            nk6.b bVar3;
            a.v.d("onPlayStateChange: {state=%d}", Integer.valueOf(i));
            if (i == 103) {
                a.this.G("onPlayStateChange isPlaying");
                a aVar = a.this;
                aVar.m = true;
                aVar.o = -1;
            }
            ll6.d dVar = ll6.d.e;
            dVar.y(iPlayer, i);
            if (i == 103) {
                lk6.b bVar4 = lk6.c.a;
                if (bVar4 != null && (bVar3 = bVar4.l) != null && bVar3.g0()) {
                    dVar.P(iPlayer, 303);
                }
                rl6.c.g();
                rl6.c.e();
                return;
            }
            if (i == 101 && (bVar = lk6.c.a) != null && (bVar2 = bVar.l) != null && bVar2.g0()) {
                dVar.P(iPlayer, 301);
            }
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onReachDynamicBuffer(IPlayer iPlayer, boolean z, long j) {
            ll6.d.e.G(iPlayer, z, j);
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onError(IPlayer iPlayer, int i, String str) {
            a.v.b("onError: {code=%d，msg=%s}", Integer.valueOf(i), str);
            a.this.G("onError, code = " + i + ", msg = " + str);
            a.this.m = false;
            al6.b bVar = al6.b.e;
            bVar.y("engine_error", Integer.valueOf(i), str);
            bVar.s(1);
            ll6.d dVar = ll6.d.e;
            dVar.p(iPlayer, i, str);
            dVar.y(iPlayer, 101);
            dVar.P(iPlayer, 301);
        }

        @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
        public void onProgressUpdate(IPlayer iPlayer, int i, int i2) {
            a.this.g = i;
            a.this.h = i2;
            int i3 = (int) (((i * 1.0f) / i2) * 100.0f);
            if (i3 != a.this.o) {
                a.v.d("onProgressUpdate: progress = %d, duration = %d, curProgress = %d%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), "%");
            }
            if (!a.this.j.u(iPlayer, i, i2)) {
                ll6.d.e.q(iPlayer, i, i2);
            }
            a.this.o = i3;
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public String getCurrentItemId() {
        String str = this.c;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getPlayState() {
        return ll6.d.e.c();
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getUIState() {
        return ll6.d.e.d();
    }

    class d implements Runnable {
        final /* synthetic */ pk6.c a;
        final /* synthetic */ kl6.a b;

        @Override // java.lang.Runnable
        public void run() {
            a.this.play(this.a, this.b);
        }

        d(pk6.c cVar, kl6.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }
    }

    class e implements Runnable {
        final /* synthetic */ pk6.c a;
        final /* synthetic */ kl6.a b;

        @Override // java.lang.Runnable
        public void run() {
            a.this.play(this.a, this.b);
        }

        e(pk6.c cVar, kl6.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }
    }

    class f implements Runnable {
        final /* synthetic */ pk6.c a;
        final /* synthetic */ kl6.a b;

        @Override // java.lang.Runnable
        public void run() {
            a.this.play(this.a, this.b);
        }

        f(pk6.c cVar, kl6.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        ll6.d.e.K();
        this.k.resume();
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getCurrentEnginePosition() {
        IPlayer iPlayer = this.k;
        if (iPlayer != null) {
            return iPlayer.getPosition();
        }
        return 0;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public int getCurrentListSize() {
        qk6.a aVar = this.j;
        if (aVar != null) {
            return aVar.k(this.b);
        }
        return 0;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public PlayAddress getCurrentPlayAddress() {
        IPlayer iPlayer = this.k;
        if (iPlayer != null) {
            return iPlayer.getPlayAddress();
        }
        return null;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public PlayEngineInfo getCurrentPlayInfo() {
        IPlayer iPlayer = this.k;
        if (iPlayer != null) {
            return iPlayer.getCurrentPlayInfo();
        }
        return null;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public boolean isCurrentOsPlayer() {
        IPlayer iPlayer = this.k;
        if (iPlayer != null) {
            return iPlayer.isOsPlayer();
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public boolean isPaused() {
        IPlayer iPlayer = this.k;
        if (iPlayer != null) {
            return iPlayer.isPaused();
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void pause() {
        pause(new kl6.c());
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void playNext() {
        playNext(new kl6.c());
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void playPrev() {
        playPrev(new kl6.c());
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void stop() {
        stop(new kl6.c());
    }

    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a.v.d(" resume resumePlayer: byManual=true, 2", new Object[0]);
            al6.b bVar = al6.b.e;
            bVar.D("resume");
            bVar.g("resume");
            a.this.H();
        }

        b() {
        }
    }

    abstract class i implements Runnable {
        public volatile boolean a = false;

        static {
            Covode.recordClassIndex(655917);
        }

        abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a) {
                a();
            } else if (!a.this.A()) {
                a();
            }
        }

        public i() {
        }
    }

    static {
        Covode.recordClassIndex(655916);
        v = new bl6.a("FMSDKPlayerTrace-PlayManager");
        w = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        nk6.b bVar;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.l) != null && bVar.e0()) {
            return true;
        }
        return false;
    }

    public static IPlayManager B() {
        if (w == null) {
            synchronized (a.class) {
                if (w == null) {
                    a aVar = new a();
                    w = aVar;
                    aVar.addInterceptorListener(aVar.r);
                }
            }
        }
        return w;
    }

    private void F() {
        this.b = null;
        this.c = null;
        this.d = 0;
        this.f = 100;
        this.g = 0L;
        this.h = 0L;
        this.j = null;
        this.m = false;
        G("reset");
    }

    private void x() {
        if (A()) {
            i iVar = this.t;
            if (iVar != null) {
                iVar.a = true;
            }
            jl6.d dVar = this.s;
            if (dVar != null) {
                dVar.h = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        nk6.b bVar;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.l) != null && bVar.q0()) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public boolean canPlayNext() {
        qk6.a aVar;
        AbsPlayList absPlayList = this.b;
        if (absPlayList != null && (aVar = this.j) != null && aVar.h(absPlayList, this.c) != null) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public boolean canPlayPrev() {
        qk6.a aVar;
        AbsPlayList absPlayList = this.b;
        if (absPlayList != null && (aVar = this.j) != null && aVar.o(absPlayList, this.c) != null) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public AudioDeviceInfoForPlay getCurrentAudioDeviceInfoForPlay() {
        IAudioPlayer d2;
        IPlayer iPlayer = this.k;
        if (iPlayer instanceof IAudioPlayer) {
            return ((IAudioPlayer) iPlayer).getCurrentAudioDeviceInfoForPlay();
        }
        if ((iPlayer instanceof uk6.b) && (d2 = ((uk6.b) iPlayer).d()) != null) {
            return d2.getCurrentAudioDeviceInfoForPlay();
        }
        return null;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public String getCurrentListId() {
        AbsPlayList absPlayList = this.b;
        if (absPlayList != null && absPlayList.getListId() != null) {
            return this.b.getListId();
        }
        return "";
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public float getCurrentProgressPercent() {
        if (getCurrentDuration() > 0) {
            return (getCurrentProgress() * 1.0f) / getCurrentDuration();
        }
        return 0.0f;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public boolean isPlaying() {
        IPlayer iPlayer = this.k;
        if (iPlayer != null) {
            return iPlayer.isPlaying();
        }
        if (getPlayState() == 103) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void release() {
        v.d("release player", new Object[0]);
        G("release");
        al6.b.e.g("release");
        lk6.c.a.g.e();
        this.k = null;
        pl6.f.d.d();
        ql6.b.b.release();
        F();
    }

    class c extends i {
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ pk6.c h;
        final /* synthetic */ kl6.a i;
        final /* synthetic */ boolean j;

        @Override // il6.a.i
        public void a() {
            c(this);
        }

        public void b() {
            lk6.b bVar;
            nk6.b bVar2;
            lk6.b bVar3;
            nk6.b bVar4;
            a.v.d("playWithTryResume realPlay: {playList=%s, playItem=%s, playPosition=%d, playSpeed=%d}", a.this.b.getListId(), a.this.c, Long.valueOf(a.this.g), Integer.valueOf(a.this.f));
            if (a.this.z()) {
                pl6.f.d.d();
            }
            a.v.d("isCurrentHasPlay = " + a.this.m, new Object[0]);
            a aVar = a.this;
            if (aVar.m && aVar.getCurrentPlayAddress() != null && ((a.this.getCurrentPlayAddress().isValidExpiredTime() || ((bVar3 = lk6.c.a) != null && (bVar4 = bVar3.l) != null && bVar4.h0())) && !this.c && !this.d && !this.e && !this.f && !this.g && (bVar = lk6.c.a) != null && (bVar2 = bVar.l) != null && bVar2.H(a.this.k, this.h))) {
                if (this.h.h) {
                    a.this.E(true, this.i.a);
                    a.v.d("playWithTryResume: resumePlayer, return", new Object[0]);
                    a.this.H();
                }
                if (this.j) {
                    a.this.setPlaySpeed(this.h.d);
                }
                al6.b bVar5 = al6.b.e;
                bVar5.D("playResume");
                bVar5.g("playResume");
                return;
            }
            a.this.m = false;
            ll6.d dVar = ll6.d.e;
            dVar.y(null, 102);
            dVar.P(null, 302);
            m.s = System.currentTimeMillis();
            if (a.this.s != null) {
                a.this.s.h = true;
            }
            a.this.s = new jl6.d(a.this.b, a.this.c, a.this.i, a.this.d, a.this.e, false, this.h.j, false, "req_default_play");
            jl6.a.g.g(a.this.j.j(a.this.s), a.this.s, new C0172a());
        }

        /* renamed from: il6.a$c$a, reason: collision with other inner class name */
        class C0172a implements ok6.c {
            @Override // ok6.c
            public void a(int i, String str, jl6.d dVar) {
                e(this, i, str, dVar);
            }

            @Override // ok6.c
            public void b(PlayAddress playAddress, jl6.d dVar) {
                f(this, playAddress, dVar);
            }

            C0172a() {
            }

            public void d(PlayAddress playAddress, jl6.d dVar) {
                boolean z;
                if (dVar.h && a.this.A()) {
                    a.v.d("playWithTryResume: reqOfPlayAddress needCancel and enableQuickPauseOrStop, return", new Object[0]);
                    return;
                }
                al6.b bVar = al6.b.e;
                bVar.q("playmanager_request_data", System.currentTimeMillis());
                AbsPlayList absPlayList = dVar.a;
                String listId = absPlayList.getListId();
                String str = dVar.b;
                int i = dVar.d;
                if (playAddress != null && !listId.equals("") && !str.equals("")) {
                    if (!playAddress.isFromCache && !playAddress.isFromDisk) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (a.this.b == absPlayList && str.equals(a.this.c) && a.this.d == i) {
                        a.v.d("playWithTryResume: success get playAddress: isFromCache=%b, isMempryCache=%b, isDiskCache=%b}", Boolean.valueOf(z), Boolean.valueOf(playAddress.isFromCache), Boolean.valueOf(playAddress.isFromDisk));
                        lk6.b bVar2 = lk6.c.a;
                        pk6.c cVar = c.this.h;
                        qk6.a a = bVar2.a(cVar.a, cVar.k);
                        String j = a.j(dVar);
                        if (z) {
                            jl6.c.a(j, true, true, System.currentTimeMillis() - playAddress.fetchTime, dVar.a.getGenreType(), c.this.i.a);
                        } else {
                            jl6.c.a(j, false, true, 0L, dVar.a.getGenreType(), c.this.i.a);
                        }
                        bVar.v(z, playAddress.cacheType);
                        a.this.l = new jl6.e(true, a.n(c.this.h), playAddress, absPlayList, a.this.c, i, a.this.e, 0, z);
                        c cVar2 = c.this;
                        a.this.E(false, cVar2.i.a);
                        c cVar3 = c.this;
                        a aVar = a.this;
                        pk6.c cVar4 = cVar3.h;
                        if (aVar.C(cVar4.f, cVar4.g).booleanValue()) {
                            c.this.h.f = 0L;
                            ll6.d.e.F();
                            a.v.d("playWithTryResume play reset: {playParam=%s}", c.this.h.toString());
                        }
                        PlayEngineInfo a2 = vl6.b.a(c.this.h, playAddress);
                        a2.extras.put("key_play_entrance", c.this.i.a);
                        HashMap<String, Object> hashMap = c.this.i.b;
                        if (hashMap != null) {
                            if (hashMap.containsKey("is_new_user_first_launch_first_play")) {
                                a2.extras.put("is_new_user_first_launch_first_play", c.this.i.b.get("is_new_user_first_launch_first_play"));
                            }
                            if (c.this.i.b.containsKey("is_use_cache_data_play")) {
                                a2.extras.put("is_use_cache_data_play", c.this.i.b.get("is_use_cache_data_play"));
                            }
                        }
                        a.v.d("playWithTryResume final real play: {playList=%s，playItem=%s}", absPlayList.getListId(), str);
                        a.b(a2);
                        ll6.d dVar2 = ll6.d.e;
                        dVar2.k(a.this.l);
                        dVar2.v(a.this.k, a2);
                        zk6.c.n(new zk6.b("PlayStrategy_start_play", 10));
                        bVar.q("player_start_play", System.currentTimeMillis());
                        bVar.D("play");
                        a.this.k.play(a2);
                        return;
                    }
                    zk6.c.j(Integer.valueOf(absPlayList.getGenreType()), "sdk_internal_error", 0, "no match playAddress");
                    a.v.d("playWithTryResume play: 不是当前要播放的内容，扔掉, return; {playAddress=%s，isFromCache=%b}", playAddress.toString(), Boolean.valueOf(z));
                    return;
                }
                zk6.c.j(Integer.valueOf(absPlayList.getGenreType()), "sdk_internal_error", 0, "no playAddress or listId or itemId");
            }

            @Insert("success")
            @ImplementedInterface(scope = Scope.ALL, value = {"com.xs.fm.player.base.play.address.PlayAddressCacheCallBack"})
            public static void f(C0172a c0172a, PlayAddress playAddress, jl6.d dVar) {
                NsXrayApi nsXrayApi = NsXrayApi.IMPL;
                if (nsXrayApi.enable()) {
                    i0.a.i("播放地址获取成功, playAddress = " + playAddress + ", req = " + dVar, new Object[0]);
                    v03.g gVar = new v03.g();
                    i0.h(gVar, dVar);
                    i0.l(gVar, playAddress);
                    nsXrayApi.sendEvent("播放地址请求成功", gVar);
                }
                c0172a.d(playAddress, dVar);
            }

            public void c(int i, String str, jl6.d dVar) {
                if (dVar.h && a.this.A()) {
                    a.v.b("playWithTryResume: fail:{code=%d，msg=%s}, reqOfPlayAddress needCancel and enableQuickPauseOrStop, return", Integer.valueOf(i), str);
                    ml6.b.a.d(dVar.b, dVar.a.getGenreType(), i, str);
                    return;
                }
                al6.b bVar = al6.b.e;
                bVar.y("server_api_error", Integer.valueOf(i), str);
                bVar.s(1);
                a.v.b("playWithTryResume fail: {code=%d，msg=%s}", Integer.valueOf(i), str);
                a.this.l = null;
                a aVar = a.this;
                aVar.m = false;
                aVar.G("playWithTryResume fail callPlayAddress: code = " + i + ", msg = " + str);
                lk6.b bVar2 = lk6.c.a;
                pk6.c cVar = c.this.h;
                qk6.a a = bVar2.a(cVar.a, cVar.k);
                jl6.c.a(a.j(dVar), false, true, 0L, dVar.a.getGenreType(), c.this.i.a);
                a.b(vl6.b.a(c.this.h, null));
                ll6.d dVar2 = ll6.d.e;
                dVar2.k(new jl6.e(false, a.n(c.this.h), null, a.this.b, a.this.c, a.this.d, a.this.e, i, false));
                dVar2.p(null, i, str);
                dVar2.y(null, 101);
                dVar2.P(null, 301);
            }

            @Insert("fail")
            @ImplementedInterface(scope = Scope.ALL, value = {"com.xs.fm.player.base.play.address.PlayAddressCacheCallBack"})
            public static void e(C0172a c0172a, int i, String str, jl6.d dVar) {
                if (NsXrayApi.IMPL.enable()) {
                    i0.a.e("播放地址获取失败(" + str + "," + dVar + ")", new Object[0]);
                }
                c0172a.c(i, str, dVar);
            }
        }

        @TargetClass(scope = Scope.LEAF, value = "com.xs.fm.player.sdk.play.PlayManager$CancelableRunnable")
        @Insert("start")
        public static void c(c cVar) {
            NsXrayApi nsXrayApi = NsXrayApi.IMPL;
            if (nsXrayApi.enable()) {
                i0.a.d("PlayManager(SDK).playRunnable.start()", new Object[0]);
                nsXrayApi.sendEvent("听书SDK起播未被拦截");
            }
            cVar.b();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, pk6.c cVar, kl6.a aVar, boolean z6) {
            super();
            this.c = z;
            this.d = z2;
            this.e = z3;
            this.f = z4;
            this.g = z5;
            this.h = cVar;
            this.i = aVar;
            this.j = z6;
        }
    }

    /* renamed from: il6.a$a, reason: collision with other inner class name */
    class C0171a extends ll6.e {
        C0171a() {
        }

        @Override // qk6.d
        public void n(boolean z) {
            if (!z) {
                return;
            }
            a.this.G("onAfterManualChangeInterceptor");
        }

        @Override // qk6.d
        public void o(boolean z) {
            if (!z) {
                return;
            }
            a.this.G("onAfterAutoNextInterceptor");
        }

        @Override // qk6.d
        public void t(boolean z) {
            if (!z) {
                return;
            }
            a.this.G("onAfterManualResumeInterceptor");
        }

        @Override // qk6.d
        public void b(boolean z, boolean z2) {
            if (z) {
                a.this.G("onAfterStartInterceptor");
            }
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void addInterceptorListener(qk6.d dVar) {
        ll6.c.j.e(dVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void addManualChangeChapterInterceptor(ll6.a aVar) {
        ll6.c.j.f(aVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void addManualResumePlayInterceptor(ll6.b bVar) {
        ll6.c.j.g(bVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void addPlayAutoNextInterceptor(qk6.b bVar) {
        ll6.c.j.h(bVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void addPlayListener(AbsPlayListener absPlayListener) {
        ll6.d.e.a(absPlayListener);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void addPlayStartInterceptor(qk6.c cVar) {
        ll6.c.j.i(cVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void pause(kl6.a aVar) {
        pause(false, aVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void removeInterceptorListener(qk6.d dVar) {
        ll6.c.j.r(dVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void removeManualChangeChapterInterceptor(ll6.a aVar) {
        ll6.c.j.s(aVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void removeManualResumePlayInterceptor(ll6.b bVar) {
        ll6.c.j.t(bVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void removePlayAutoNextInterceptor(qk6.b bVar) {
        ll6.c.j.u(bVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void removePlayListener(AbsPlayListener absPlayListener) {
        ll6.d.e.S(absPlayListener);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void removePlayStartInterceptor(qk6.c cVar) {
        ll6.c.j.v(cVar);
    }

    public void a(pk6.c cVar) {
        play(cVar, new kl6.c());
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void playItemOfN(int i2) {
        playItemOfN(i2, new kl6.c());
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void resume(boolean z) {
        resume(z, new kl6.c());
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void seekTo(long j) {
        seekTo(j, new kl6.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str) {
        v.d("play double resetQueryPlayId: %s", str);
        this.q = null;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void changeAudioEffect(pk6.a aVar) {
        IAudioPlayer d2;
        IPlayer iPlayer = this.k;
        if (iPlayer instanceof IAudioPlayer) {
            ((IAudioPlayer) iPlayer).changeAudioEffect(aVar);
        } else if ((iPlayer instanceof uk6.b) && (d2 = ((uk6.b) iPlayer).d()) != null) {
            d2.changeAudioEffect(aVar);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void changeAudioLoudestInfo(pk6.a aVar) {
        IAudioPlayer d2;
        IPlayer iPlayer = this.k;
        if (iPlayer instanceof IAudioPlayer) {
            ((IAudioPlayer) iPlayer).changeAudioLoudestInfo(aVar);
        } else if ((iPlayer instanceof uk6.b) && (d2 = ((uk6.b) iPlayer).d()) != null) {
            d2.changeAudioLoudestInfo(aVar);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void pause(boolean z) {
        pause(z, new kl6.c());
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void changeAudioResolution(Resolution resolution) {
        IAudioPlayer d2;
        if (resolution != null) {
            al6.b.e.g("change_resolution_" + resolution.toString());
        }
        IPlayer iPlayer = this.k;
        if (iPlayer instanceof IAudioPlayer) {
            ((IAudioPlayer) iPlayer).configAudioResolution(resolution);
        } else if ((iPlayer instanceof uk6.b) && (d2 = ((uk6.b) iPlayer).d()) != null) {
            d2.configAudioResolution(resolution);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void setPlaySpeed(int i2) {
        if (this.k != null) {
            v.d("setPlaySpeed: setPlaySpeed=%d", Integer.valueOf(i2));
            this.f = i2;
            this.k.setPlaySpeed(i2);
            al6.b.e.g("setPlaySpeed-" + i2);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void stop(kl6.a aVar) {
        v.d(" stop: {playEntrance=%s}", aVar.toString());
        if (!aVar.a.startsWith("normal_play_stop_")) {
            G("stop");
        }
        x();
        al6.b.e.g("stop");
        if (this.k != null) {
            ll6.d.e.M(this.n);
            this.k.stop();
        }
        this.m = false;
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void changeVoiceBgmInfo(VoiceBgmInfo voiceBgmInfo) {
        IAudioPlayer d2;
        if (voiceBgmInfo != null && getCurrentPlayInfo() != null && getCurrentPlayInfo().voiceBgmInfo != null && voiceBgmInfo.bgmRate == getCurrentPlayInfo().voiceBgmInfo.bgmRate) {
            v.d("changeVoiceBgmInfo, no change return", new Object[0]);
            return;
        }
        IPlayer iPlayer = this.k;
        if (iPlayer instanceof IAudioPlayer) {
            ((IAudioPlayer) iPlayer).changeVoiceBgmInfo(voiceBgmInfo);
        } else if ((iPlayer instanceof uk6.b) && (d2 = ((uk6.b) iPlayer).d()) != null) {
            d2.changeVoiceBgmInfo(voiceBgmInfo);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void playNext(kl6.a aVar) {
        String h2;
        bl6.a aVar2 = v;
        aVar2.d("playNext: {playEntrance=%s}", aVar.toString());
        if (canPlayNext() && (h2 = this.j.h(this.b, this.c)) != null) {
            pk6.c l = this.j.l(this.b, h2);
            ll6.d.e.w(false, l);
            if (l != null) {
                this.j.v(l, "play_next");
                aVar2.d("playNext start play next: {curPlayListId=%s, curPlayItem=%s, nextItem=%s, nextPlayParam=%s}", this.b.getListId(), this.c, h2, l.toString());
                ll6.c.j.n(new d(l, aVar));
            }
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void playPrev(kl6.a aVar) {
        pk6.c l;
        bl6.a aVar2 = v;
        aVar2.d("playPrev: {playEntrance=%s}", aVar.toString());
        if (canPlayPrev()) {
            String o = this.j.o(this.b, this.c);
            ll6.d.e.x(o);
            if (o != null && (l = this.j.l(this.b, o)) != null) {
                this.j.v(l, "play_pre");
                aVar2.g("playPrev start play prev: {curPlayListId=%s, curPlayItem=%s, preItem=%s, prevPlayParam=%s}", this.b.getListId(), this.c, o, l.toString());
                ll6.c.j.n(new f(l, aVar));
            }
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void play(pk6.c cVar, kl6.a aVar) {
        D(cVar, aVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void updateProgress(long j, long j2) {
        this.g = j;
        this.h = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean C(long j, long j2) {
        boolean z;
        if (j + 1000 > j2 && j2 > 0) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z, String str) {
        AbsPlayList currentList = getCurrentList();
        qk6.a currentStrategy = getCurrentStrategy();
        if (currentList != null && currentStrategy != null) {
            ml6.b.a.f(currentList.getGenreType(), currentStrategy.n(this.a), this.c, this.d, z, str);
        }
    }

    private static void I(pk6.c cVar, kl6.a aVar) {
        al6.b bVar = al6.b.e;
        if (bVar.o() && cVar.h) {
            bVar.E(cVar, aVar);
            long currentTimeMillis = System.currentTimeMillis();
            HashMap<String, Object> hashMap = aVar.b;
            if (hashMap != null && hashMap.containsKey("business_start_play")) {
                currentTimeMillis = ((Long) aVar.b.get("business_start_play")).longValue();
            }
            bVar.q("business_start_play", currentTimeMillis);
            bVar.q("playmanager_start_play", System.currentTimeMillis());
            bVar.g("startPlay");
        }
    }

    @TargetClass("com.xs.fm.player.sdk.play.PlayManager")
    @Insert("play")
    public static void y(a aVar, pk6.c cVar) {
        NsXrayApi nsXrayApi = NsXrayApi.IMPL;
        if (nsXrayApi.enable()) {
            i0.a.d("PlayManager(SDK).play(), playParam = " + cVar, new Object[0]);
            if (cVar != null) {
                nsXrayApi.sendEvent("听书SDK.PlayManager.play()", i0.i(new v03.g(), cVar));
            }
        }
        aVar.a(cVar);
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void pause(boolean z, kl6.a aVar) {
        v.d("pause: {isAbandonFocus=%s , playEntrance=%s}", Boolean.valueOf(z), aVar.toString());
        G("pause");
        x();
        al6.b.e.g("pause");
        if (this.k != null) {
            ll6.d.e.u();
            this.k.pause(z);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void playTip(rk6.a aVar, boolean z) {
        if (aVar != null) {
            if (z && getPlayState() == 103 && this.m) {
                pause(true);
                new c.a().d(aVar).c(new g()).h();
            } else {
                new c.a().d(aVar).c(null).h();
            }
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void seekTo(long j, kl6.a aVar) {
        if (this.k != null) {
            v.d("seekTo: position=%d, playEntrance=%s", Long.valueOf(j), aVar);
            this.g = j;
            this.k.seekTo(j);
            ll6.d.e.L(j);
            al6.b.e.g("seekTo-" + j);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void playItemOfN(int i2, kl6.a aVar) {
        AbsPlayList absPlayList;
        pk6.c l;
        bl6.a aVar2 = v;
        aVar2.d("playItemOfN: {pos=%s , playEntrance=%s}", Integer.valueOf(i2), aVar.toString());
        qk6.a aVar3 = this.j;
        if (aVar3 != null && (absPlayList = this.b) != null) {
            String f2 = aVar3.f(absPlayList, i2);
            if (!TextUtils.isEmpty(f2) && (l = this.j.l(this.b, f2)) != null) {
                aVar2.d("playItemOfN start play item of N: {curPlayListId=%s, itemIdOfN=%d, playParamOfN=%s}", this.b.getListId(), Integer.valueOf(i2), l.toString());
                ll6.c.j.n(new e(l, aVar));
            }
        }
    }

    @Override // com.xs.fm.player.base.play.inter.IPlayManager
    public void resume(boolean z, kl6.a aVar) {
        bl6.a aVar2 = v;
        aVar2.d(" resume: {byManual=%s, playEntrance=%s}", Boolean.valueOf(z), aVar.toString());
        if (this.m && getCurrentPlayAddress() != null && getCurrentPlayAddress().isValidExpiredTime()) {
            if (lk6.c.a.l.u() && xk6.f.b(lk6.c.a.b)) {
                xk6.f.c(lk6.c.a.b);
            }
            E(true, aVar.a);
            if (z) {
                ll6.c.j.o(new b());
                return;
            }
            aVar2.d(" resume resumePlayer: byManual=false, 3", new Object[0]);
            al6.b bVar = al6.b.e;
            bVar.D("resume");
            bVar.g("resume");
            H();
            return;
        }
        AbsPlayList absPlayList = this.b;
        if (absPlayList != null) {
            pk6.c l = this.j.l(absPlayList, this.c);
            if (l != null) {
                l.h = true;
            }
            aVar2.d(" resume: playWithTryResume, 4", new Object[0]);
            D(l, aVar);
        }
    }

    private void D(pk6.c cVar, kl6.a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Integer valueOf;
        boolean z7;
        boolean z8;
        nk6.b bVar;
        nk6.b bVar2;
        if (lk6.c.a.l.u() && xk6.f.b(lk6.c.a.b)) {
            xk6.f.c(lk6.c.a.b);
        }
        if (cVar != null && cVar.a != null && aVar != null) {
            ll6.d dVar = ll6.d.e;
            dVar.m(cVar.h);
            long currentTimeMillis = System.currentTimeMillis() - this.p;
            bl6.a aVar2 = v;
            aVar2.d("playWithTryResume: isForeground=%s", Boolean.valueOf(xk6.a.g().b));
            aVar2.d("playWithTryResume: {playParam=%s, playEntrance=%s, timeInterval=%d}", cVar.toString(), aVar.toString(), Long.valueOf(currentTimeMillis));
            lk6.b bVar3 = lk6.c.a;
            if (bVar3 != null && (bVar2 = bVar3.l) != null && bVar2.M()) {
                if (!TextUtils.isEmpty(this.q) && TextUtils.equals(this.q, cVar.b) && TextUtils.equals(this.c, cVar.b) && cVar.a(this.a) && currentTimeMillis < lk6.c.a.l.S()) {
                    aVar2.d("playWithTryResume: enableOptimizeReplay double play, return；timeInterval=%d", Long.valueOf(currentTimeMillis));
                    return;
                } else if (cVar.h) {
                    aVar2.d("playWithTryResume: enableOptimizeReplay set the queryPlayId = " + cVar.b, new Object[0]);
                    this.q = cVar.b;
                }
            }
            this.p = System.currentTimeMillis();
            this.n = this.a;
            pk6.b bVar4 = new pk6.b();
            bVar4.b = this.i;
            bVar4.a = this.b;
            bVar4.c.putAll(cVar.l);
            this.a = cVar;
            AbsPlayList absPlayList = this.b;
            if (absPlayList == null) {
                z = true;
            } else {
                z = false;
            }
            if (absPlayList != null && absPlayList.getGenreType() == cVar.a.getGenreType() && this.b.getListId().equals(cVar.a.getListId())) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 && cVar.b.equals(this.c)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (this.d != cVar.c) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (this.f != cVar.d) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (this.e != cVar.e) {
                z6 = true;
            } else {
                z6 = false;
            }
            qk6.a aVar3 = this.j;
            if (aVar3 == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(aVar3.n(this.n));
            }
            int n = lk6.c.a.a(cVar.a, cVar.k).n(cVar);
            if (this.j != null && n == valueOf.intValue()) {
                z7 = false;
            } else {
                z7 = true;
            }
            boolean z9 = z5;
            boolean z10 = !this.i.equals(cVar.k);
            String str = this.c;
            Integer num = valueOf;
            int i2 = this.d;
            int i3 = this.e;
            IPlayer iPlayer = this.k;
            dVar.b(cVar.a.getListId(), cVar.b);
            if (!z2 && !z3 && !z4 && !z7 && !z6 && !z10) {
                z8 = z10;
            } else {
                z8 = z10;
                aVar2.d("playWithTryResume: stop last player", new Object[0]);
                stop(new kl6.c("normal_play_stop_" + aVar.a, null));
                al6.b.e.s(2);
            }
            I(cVar, aVar);
            AbsPlayList absPlayList2 = cVar.a;
            this.b = absPlayList2;
            this.c = cVar.b;
            this.d = cVar.c;
            this.e = cVar.e;
            String str2 = cVar.k;
            this.i = str2;
            this.f = cVar.d;
            boolean z11 = z3;
            this.g = cVar.f;
            this.h = cVar.g;
            qk6.a a = lk6.c.a.a(absPlayList2, str2);
            this.j = a;
            if (a == null) {
                zk6.c.j(Integer.valueOf(this.b.getGenreType()), "sdk_internal_error", 0, "no playStrategy");
                aVar2.d("playWithTryResume: current playStrategy is null, return", new Object[0]);
                return;
            }
            IPlayer iPlayer2 = this.k;
            if (iPlayer2 != null) {
                iPlayer2.removePlayerListener();
            }
            IPlayer c2 = lk6.c.a.g.c(new pk6.d(this.j.n(cVar), cVar.a.getGenreType(), cVar.k));
            this.k = c2;
            if (c2 != null) {
                c2.setPlayerListener(this.u);
            }
            IPlayer iPlayer3 = this.k;
            if (iPlayer3 != iPlayer) {
                dVar.A(iPlayer, iPlayer3);
            }
            pk6.b bVar5 = new pk6.b();
            bVar5.b = this.i;
            bVar5.a = this.b;
            bVar5.c.putAll(cVar.l);
            if (z && (!cVar.h || !lk6.c.a.l.o())) {
                aVar2.d("onFirstListPlay: needStartPlay = " + cVar.h, new Object[0]);
                dVar.l();
            } else {
                if (z2) {
                    aVar2.d("isListChange", new Object[0]);
                    dVar.s(bVar4, bVar5);
                    dVar.r();
                }
                if (z11) {
                    aVar2.d("isItemChange", new Object[0]);
                    dVar.n(str, this.c);
                }
                if (z4) {
                    aVar2.d("isToneChange", new Object[0]);
                    dVar.O(i2, this.d);
                }
                if (z7) {
                    aVar2.d("isPlayTypeChange", new Object[0]);
                    dVar.z(num, Integer.valueOf(n));
                }
                if (z6) {
                    dVar.i(i3, this.e);
                }
            }
            if (!z()) {
                pl6.f.d.d();
            }
            al6.b.e.q("playmanager_data_callback", System.currentTimeMillis());
            if (!cVar.h) {
                return;
            }
            i iVar = this.t;
            if (iVar != null) {
                iVar.a = true;
            }
            this.t = new c(z2, z11, z4, z6, z8, cVar, aVar, z9);
            lk6.b bVar6 = lk6.c.a;
            if (bVar6 != null && (bVar = bVar6.l) != null && bVar.n()) {
                if (!z2 && !z11 && !z4 && !z6 && isPlaying()) {
                    i iVar2 = this.t;
                    if (iVar2 != null) {
                        iVar2.run();
                        return;
                    }
                    return;
                }
                ll6.c.j.q(z11, this.t, cVar.i);
                return;
            }
            ll6.c.j.q(z11, this.t, cVar.i);
            return;
        }
        zk6.c.j(null, "sdk_internal_error", 0, "no playParam or playList");
        v.d("playWithTryResume: null return", new Object[0]);
    }
}
