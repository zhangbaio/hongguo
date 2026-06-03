package com.xs.fm.player.base.play.inter;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import il6.a;
import jl6.d;
import jl6.e;
import pk6.b;
import pk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class AbsPlayListener {
    static {
        Covode.recordClassIndex(655827);
    }

    public void beforePlay(String str, String str2) {
    }

    public void onAbandonAudioFocus() {
    }

    public void onAllTipCancel() {
    }

    public void onAllTipFinish() {
    }

    public void onAudioFocusChange(int i) {
    }

    public void onBgNoiseIdChanged(int i, int i2) {
    }

    public void onBufferingUpdate(int i) {
    }

    public void onFetchPlayAddress(e eVar) {
    }

    public void onFirstListPlay() {
    }

    public void onInitBeforePlay(boolean z) {
    }

    public void onItemChanged(String str, String str2) {
    }

    public void onItemPlayCompletion(IPlayer iPlayer) {
    }

    public void onListChanged() {
    }

    public void onListChanged(b bVar, b bVar2) {
    }

    public void onListDataChanged() {
    }

    public void onListPlayCompletion() {
    }

    public void onPause() {
    }

    public void onPlay(IPlayer iPlayer, PlayEngineInfo playEngineInfo) {
    }

    public void onPlayError(IPlayer iPlayer, int i, String str) {
    }

    public void onPlayNext(boolean z, c cVar) {
    }

    public void onPlayPre(String str) {
    }

    public void onPlayProgressChanged(IPlayer iPlayer, int i, int i2) {
    }

    public void onPlayStateChange(IPlayer iPlayer, int i) {
    }

    public void onPlayTypeChanged(Integer num, Integer num2) {
    }

    public void onPlayerChanged(IPlayer iPlayer, IPlayer iPlayer2) {
    }

    public void onPlayerPlay() {
    }

    public void onPlayerPrepare() {
    }

    public void onPlayerPrepared() {
    }

    public void onPlayerRenderStart() {
    }

    public void onPlayerResetBegin() {
    }

    public void onReachDynamicBuffer(IPlayer iPlayer, boolean z, long j) {
    }

    public void onRequestAudioFocus() {
    }

    public void onRequestPlayAddress(d dVar) {
    }

    public void onResolutionChange(Resolution resolution, Resolution resolution2) {
    }

    public void onResume() {
    }

    public void onSeekTo(long j) {
    }

    public void onStop(c cVar) {
    }

    public void onTipPlay(String str) {
    }

    public void onToneChanged(int i, int i2) {
    }

    public void onUIStateChange(IPlayer iPlayer, int i) {
    }

    public void onVideoEngineInfos(IPlayer iPlayer, VideoEngineInfos videoEngineInfos) {
    }

    public String getListId() {
        return a.B().getCurrentListId();
    }
}
