package sk4;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import com.xs.fm.player.base.play.player.IPlayer;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends AbsPlayListener {
    public static final int b;
    private final b a;

    static {
        Covode.recordClassIndex(607983);
        b = 8;
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public String getListId() {
        return this.a.k();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onAbandonAudioFocus() {
        this.a.onAbandonAudioFocus();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onAllTipCancel() {
        this.a.b();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onAllTipFinish() {
        this.a.d();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onFirstListPlay() {
        this.a.l();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onListDataChanged() {
        this.a.m();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onListPlayCompletion() {
        this.a.s();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPause() {
        this.a.onPause();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayerPlay() {
        this.a.onPlayerPlay();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayerPrepare() {
        this.a.onPlayerPrepare();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayerPrepared() {
        this.a.onPlayerPrepared();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayerRenderStart() {
        this.a.onPlayerRenderStart();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayerResetBegin() {
        this.a.r();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onRequestAudioFocus() {
        this.a.onRequestAudioFocus();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onResume() {
        this.a.onResume();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onAudioFocusChange(int i) {
        this.a.onAudioFocusChange(i);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onBufferingUpdate(int i) {
        this.a.onBufferingUpdate(i);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onInitBeforePlay(boolean z) {
        this.a.A(z);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onItemPlayCompletion(IPlayer iPlayer) {
        this.a.i();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onTipPlay(String str) {
        this.a.c(str);
    }

    public a(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.a = listener;
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onFetchPlayAddress(jl6.e respOfPlayAddress) {
        Intrinsics.checkNotNullParameter(respOfPlayAddress, "respOfPlayAddress");
        this.a.f();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayPre(String preItemId) {
        Intrinsics.checkNotNullParameter(preItemId, "preItemId");
        this.a.g(preItemId);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onStop(pk6.c cVar) {
        com.dragon.read.kmp.player.base.play.data.c cVar2;
        b bVar = this.a;
        if (cVar != null) {
            cVar2 = com.dragon.read.kmp.player.base.play.data.f.a(cVar);
        } else {
            cVar2 = null;
        }
        bVar.q(cVar2);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onBgNoiseIdChanged(int i, int i2) {
        this.a.w(i, i2);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onItemChanged(String str, String str2) {
        this.a.C(str, str2);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayStateChange(IPlayer iPlayer, int i) {
        this.a.h(i);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayTypeChanged(Integer num, Integer num2) {
        this.a.o(num, num2);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayerChanged(IPlayer iPlayer, IPlayer iPlayer2) {
        this.a.v();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onToneChanged(int i, int i2) {
        this.a.u(i, i2);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onUIStateChange(IPlayer iPlayer, int i) {
        this.a.B(i);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void beforePlay(String playList, String playItem) {
        Intrinsics.checkNotNullParameter(playList, "playList");
        Intrinsics.checkNotNullParameter(playItem, "playItem");
        this.a.a(playList, playItem);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlay(IPlayer iPlayer, PlayEngineInfo engineInfo) {
        Intrinsics.checkNotNullParameter(engineInfo, "engineInfo");
        this.a.j(new com.dragon.read.kmp.player.base.play.data.b(engineInfo));
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayNext(boolean z, pk6.c cVar) {
        com.dragon.read.kmp.player.base.play.data.c cVar2;
        b bVar = this.a;
        if (cVar != null) {
            cVar2 = com.dragon.read.kmp.player.base.play.data.f.a(cVar);
        } else {
            cVar2 = null;
        }
        bVar.p(z, cVar2);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onVideoEngineInfos(IPlayer iPlayer, VideoEngineInfos videoEngineInfos) {
        Intrinsics.checkNotNullParameter(videoEngineInfos, "videoEngineInfos");
        this.a.z();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onListChanged(pk6.b oldPlayContextInfo, pk6.b currentPlayContextInfo) {
        Intrinsics.checkNotNullParameter(oldPlayContextInfo, "oldPlayContextInfo");
        Intrinsics.checkNotNullParameter(currentPlayContextInfo, "currentPlayContextInfo");
        this.a.y(com.dragon.read.kmp.player.base.play.data.e.a(oldPlayContextInfo), com.dragon.read.kmp.player.base.play.data.e.a(currentPlayContextInfo));
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onResolutionChange(Resolution resolution, Resolution resolution2) {
        com.dragon.read.kmp.player.base.play.data.g gVar;
        b bVar = this.a;
        com.dragon.read.kmp.player.base.play.data.g gVar2 = null;
        if (resolution != null) {
            gVar = com.dragon.read.kmp.player.base.play.data.h.a(resolution);
        } else {
            gVar = null;
        }
        if (resolution2 != null) {
            gVar2 = com.dragon.read.kmp.player.base.play.data.h.a(resolution2);
        }
        bVar.n(gVar, gVar2);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayProgressChanged(IPlayer iPlayer, int i, int i2) {
        this.a.x(i, i2);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onReachDynamicBuffer(IPlayer iPlayer, boolean z, long j) {
        this.a.t(z, j);
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayError(IPlayer iPlayer, int i, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.a.e(i, msg);
    }
}
