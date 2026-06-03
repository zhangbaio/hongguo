package sl6;

import android.app.Application;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoModel;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import com.xs.fm.player.sdk.play.player.audio.engine.i;
import com.xs.fm.player.sdk.play.player.audio.engine.k;
import com.xs.fm.player.sdk.play.player.audio.engine.m;
import com.xs.fm.player.sdk.play.player.audio.engine.n;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ql6.e;
import xk6.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b implements IPlayer, ul6.b {
    private final bl6.a a = new bl6.a("FMSDKPlayerTrace-StandardVideoEnginePlayer");
    private final Application b;
    public TTVideoEngine c;
    private m d;
    private IPlayer.PlayerListener e;
    private yk6.b f;
    private com.xs.fm.player.sdk.play.player.video.custom.b g;
    private boolean h;
    private boolean i;
    private boolean j;
    private PlayEngineInfo k;
    private PlayEngineInfo l;
    private int m;
    private boolean n;

    static final class a implements VideoEngineInfoListener {
        public static final a a = new a();

        a() {
        }

        @Override // com.ss.ttvideoengine.VideoEngineInfoListener
        public final void onVideoEngineInfos(VideoEngineInfos videoEngineInfos) {
        }
    }

    static {
        Covode.recordClassIndex(656035);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isOsPlayer() {
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayEngineInfo getCurrentPlayInfo() {
        return this.k;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isReleased() {
        return this.j;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getDuration() {
        return this.c.getDuration();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getPosition() {
        return this.c.getCurrentPlaybackTime();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayAddress getPlayAddress() {
        PlayEngineInfo playEngineInfo = this.k;
        if (playEngineInfo != null) {
            return playEngineInfo.playAddress;
        }
        return null;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPaused() {
        if (this.c.getPlaybackState() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPlaying() {
        if (this.c.getPlaybackState() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isStopped() {
        if (this.c.getPlaybackState() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void removePlayerListener() {
        this.e = null;
        this.d.r(null, this);
        this.c.setVideoEngineCallback(null);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void resume() {
        this.a.d("resume", new Object[0]);
        this.c.play();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public float getPercentage() {
        if (this.c.getDuration() > 0) {
            return (this.c.getCurrentPlaybackTime() * 100.0f) / this.c.getDuration();
        }
        return 0.0f;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void release() {
        this.a.d("release", new Object[0]);
        this.j = true;
        this.c.releaseAsync();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void stop() {
        this.a.d("stop", new Object[0]);
        this.c.stop();
        m mVar = this.d;
        if (mVar != null) {
            mVar.u();
        }
    }

    /* renamed from: sl6.b$b, reason: collision with other inner class name */
    static final class RunnableC0263b implements Runnable {
        RunnableC0263b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Surface surface;
            boolean z;
            TTVideoEngine tTVideoEngine = b.this.c;
            com.xs.fm.player.sdk.play.player.video.custom.b bVar = b.this.g;
            if (bVar != null) {
                surface = bVar.getSurface();
            } else {
                surface = null;
            }
            tTVideoEngine.setSurface(surface);
            com.xs.fm.player.sdk.play.player.video.custom.b bVar2 = b.this.g;
            if (bVar2 != null) {
                z = bVar2.isShown();
            } else {
                z = false;
            }
            b.this.l(!z, "execAction_surface_valid");
            if (b.this.i && !b.this.h) {
                b.this.a.d("bindVideoView: surface is inValid, and engine has play, call play again", new Object[0]);
            }
        }
    }

    private final void i(PlayEngineInfo playEngineInfo) {
        yk6.b bVar = new yk6.b();
        this.f = bVar;
        bVar.a(playEngineInfo);
        this.c.setAudioProcessor(this.f);
    }

    static final class c implements SeekCompletionListener {
        final /* synthetic */ long b;

        c(long j) {
            this.b = j;
        }

        @Override // com.ss.ttvideoengine.SeekCompletionListener
        public final void onCompletion(boolean z) {
            b.this.a.d("seekTo: millionSecond=" + this.b + ", success=" + z, new Object[0]);
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void pause(boolean z) {
        this.a.d("pause: isAbandonFocus=" + z, new Object[0]);
        this.c.pause();
        m mVar = this.d;
        if (mVar != null) {
            mVar.o();
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void seekTo(long j) {
        this.a.d("seekTo: millionSecond=" + j, new Object[0]);
        this.c.seekTo((int) j, new c(j));
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlayerListener(IPlayer.PlayerListener playerListener) {
        this.a.d("setPlayerListener: listener=" + playerListener, new Object[0]);
        this.e = playerListener;
        this.d.r(playerListener, this);
        this.c.setVideoEngineCallback(this.d);
    }

    private final void j(PlayEngineInfo playEngineInfo) {
        HashMap<String, Object> customStr = playEngineInfo.playAddress.customStr;
        Intrinsics.checkExpressionValueIsNotNull(customStr, "customStr");
        customStr.put("book_id", playEngineInfo.playBookId);
        customStr.put("item_id", playEngineInfo.itemId);
        customStr.put("genre_type", String.valueOf(playEngineInfo.genreType));
        customStr.put("key_play_entrance", playEngineInfo.extras.get("key_play_entrance"));
        xk6.a g = xk6.a.g();
        Intrinsics.checkExpressionValueIsNotNull(g, "AppLifecycleMonitor.getInstance()");
        customStr.put("is_foreground_play", Boolean.valueOf(g.b));
        kl6.b.a("is_new_user_first_launch_first_play", playEngineInfo.extras.get("is_new_user_first_launch_first_play"), customStr);
        kl6.b.a("is_use_cache_data_play", playEngineInfo.extras.get("is_use_cache_data_play"), customStr);
        this.c.setCustomStr(new JSONObject(customStr).toString());
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlaySpeed(int i) {
        this.a.d("setPlaySpeed: playSpeed=" + i, new Object[0]);
        PlaybackParams playbackParams = new PlaybackParams();
        playbackParams.setPitch(1.0f);
        playbackParams.setSpeed(((float) i) / 100.0f);
        try {
            this.c.setPlaybackParams(playbackParams);
        } catch (Exception e) {
            this.a.b("setPlaySpeed: failed, e=" + e, new Object[0]);
            e.printStackTrace();
        }
    }

    public b(int i) {
        boolean z;
        tl6.b bVar;
        lk6.b bVar2 = lk6.c.a;
        Application application = bVar2.b;
        this.b = application;
        this.m = -1;
        if (bVar2 != null && (bVar = bVar2.u) != null) {
            z = bVar.c();
        } else {
            z = false;
        }
        if (z) {
            HashMap hashMap = new HashMap();
            hashMap.put("enable_looper", Boolean.TRUE);
            HandlerThread D = lk6.c.a.l.D();
            if (D != null) {
                hashMap.put("handler_thread", D);
                hashMap.put("callback_looper", Looper.getMainLooper());
                if (!lk6.c.a.l.l0()) {
                    hashMap.put("handler_thread_not_allow_destroy", 1);
                }
            }
            this.c = new TTVideoEngine(application, i, hashMap);
        } else {
            this.c = new TTVideoEngine(application, i);
        }
        m mVar = new m(this.c);
        this.d = mVar;
        mVar.i = z;
        n.c(this.c, true);
        this.c.setVideoEngineInfoListener(a.a);
        this.c.setNetworkClient(new k());
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e3, code lost:
    
        if (r0.d(r3) == true) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01cf  */
    @Override // com.xs.fm.player.base.play.player.IPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void play(com.xs.fm.player.base.play.data.PlayEngineInfo r8) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sl6.b.play(com.xs.fm.player.base.play.data.PlayEngineInfo):void");
    }

    public void l(boolean z, String str) {
        this.a.d("turnVideoToAudioMode: " + z + ", source: " + str, new Object[0]);
        this.c.setIntOption(480, z ? 1 : 0);
    }

    private final void g(PlayEngineInfo playEngineInfo, boolean z) {
        tl6.b bVar;
        tl6.b bVar2;
        String tag = playEngineInfo.playAddress.tag;
        gl6.c cVar = lk6.c.a.t;
        Intrinsics.checkExpressionValueIsNotNull(tag, "tag");
        if (cVar.h(tag)) {
            this.c.setIntOption(42010, z ? 1 : 0);
            this.c.setIntOption(622, z ? 1 : 0);
        }
        if (lk6.c.a.t.b(tag) > 0) {
            this.c.setIntOption(118, lk6.c.a.t.b(tag));
        }
        lk6.b bVar3 = lk6.c.a;
        if (bVar3 != null && (bVar2 = bVar3.u) != null && bVar2.b(tag)) {
            this.c.setIntOption(7, 1);
        }
        lk6.b bVar4 = lk6.c.a;
        if (bVar4 != null && (bVar = bVar4.u) != null && bVar.a(tag)) {
            this.c.setIntOption(591, 1);
        }
        if (playEngineInfo.enableAudioDevicePrepare) {
            this.c.setIntOption(371, z ? 1 : 0);
        }
    }

    private final void h(PlayEngineInfo playEngineInfo, Resolution resolution) {
        al6.b bVar = al6.b.e;
        String tag = this.c.getTag();
        String subTag = this.c.getSubTag();
        Integer valueOf = Integer.valueOf((int) playEngineInfo.playPosition);
        Integer valueOf2 = Integer.valueOf(this.c.getDuration());
        Integer valueOf3 = Integer.valueOf(playEngineInfo.playAddress.playType);
        int b = vl6.b.b(playEngineInfo);
        h hVar = h.a;
        PlayAddress playAddress = playEngineInfo.playAddress;
        Intrinsics.checkExpressionValueIsNotNull(playAddress, "playEngineInfo.playAddress");
        bVar.A(tag, subTag, valueOf, valueOf2, valueOf3, resolution, b, hVar.a(playAddress, resolution));
        bVar.x(playEngineInfo, this.c, resolution);
    }

    public void k(PlayEngineInfo playEngineInfo, Surface surface) {
        int i;
        Boolean bool;
        gl6.c cVar;
        if (playEngineInfo.playAddress == null) {
            this.a.b("prepare: failed, playEngineInfo playAddress is null", new Object[0]);
            return;
        }
        this.a.d("prepare: start chapterId=" + playEngineInfo.itemId + ", genreType=" + playEngineInfo.genreType, new Object[0]);
        e.b(true, playEngineInfo);
        this.l = playEngineInfo;
        this.n = true;
        this.d.s(true);
        this.c.setVideoEngineCallback(this.d);
        this.c.setTag(playEngineInfo.playAddress.tag);
        this.c.setSubTag(playEngineInfo.playAddress.subTag);
        n.e(this.c);
        n.d(this.c, playEngineInfo.playAddress.mdlCachePath);
        n.g(this.c, playEngineInfo);
        n.f(this.c, playEngineInfo);
        i.a.a(this.c, false, true, playEngineInfo.playAddress.tag);
        i(playEngineInfo);
        g(playEngineInfo, true);
        this.c.setIntOption(100, 0);
        TTVideoEngine tTVideoEngine = this.c;
        lk6.b bVar = lk6.c.a;
        if (bVar != null && (cVar = bVar.t) != null) {
            String str = playEngineInfo.playAddress.tag;
            Intrinsics.checkExpressionValueIsNotNull(str, "playEngineInfo.playAddress.tag");
            i = cVar.j(str);
        } else {
            i = 819200;
        }
        tTVideoEngine.setAutoRangeRead(2, i);
        if (surface != null) {
            this.c.setSurface(surface);
        }
        PlayAddress playAddress = playEngineInfo.playAddress;
        VideoModel videoModel = playAddress.videoModel;
        if (videoModel == null) {
            videoModel = h.a.c(playAddress.playVideoModel, "StandardVideoEnginePlayer_prepare");
        }
        this.c.setVideoModel(videoModel);
        this.c.setStartTime((int) playEngineInfo.playPosition);
        this.c.configResolution(playEngineInfo.resolution);
        setPlaySpeed(playEngineInfo.speed);
        bl6.a aVar = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("success init ttVideoEngine, and begin engine prepare, startTime=");
        sb.append(this.c.getStartTime());
        sb.append(", resolution=");
        sb.append(this.c.getCurrentResolution());
        sb.append(", ");
        sb.append("speed=");
        sb.append(playEngineInfo.speed);
        sb.append(", isSurfaceValid=");
        com.xs.fm.player.sdk.play.player.video.custom.b bVar2 = this.g;
        if (bVar2 != null) {
            bool = Boolean.valueOf(bVar2.B());
        } else {
            bool = null;
        }
        sb.append(bool);
        aVar.d(sb.toString(), new Object[0]);
        this.c.prepare();
    }
}
