package com.xs.fm.player.base.play.player;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPlayer {

    public interface PlayerListener {

        public static class Stub implements PlayerListener {
            static {
                Covode.recordClassIndex(655840);
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onAbandonAudioFocus() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onAudioFocusChange(int i) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onBufferingUpdate(int i) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onError(IPlayer iPlayer, int i, String str) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayCompletion(IPlayer iPlayer) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayStateChange(IPlayer iPlayer, int i) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayerPlay() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayerPrepare() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayerPrepared() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayerRenderStart() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onProgressUpdate(IPlayer iPlayer, int i, int i2) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onReachDynamicBuffer(IPlayer iPlayer, boolean z, long j) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onReadyToDisplay(boolean z) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onRequestAudioFocus() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onResolutionChange(Resolution resolution, Resolution resolution2) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onUIStateChange(IPlayer iPlayer, int i) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onVideoEngineInfos(IPlayer iPlayer, VideoEngineInfos videoEngineInfos) {
            }
        }

        void onAbandonAudioFocus();

        void onAudioFocusChange(int i);

        void onBufferingUpdate(int i);

        void onError(IPlayer iPlayer, int i, String str);

        void onPlayCompletion(IPlayer iPlayer);

        void onPlayStateChange(IPlayer iPlayer, int i);

        void onPlayerPlay();

        void onPlayerPrepare();

        void onPlayerPrepared();

        void onPlayerRenderStart();

        void onProgressUpdate(IPlayer iPlayer, int i, int i2);

        void onReachDynamicBuffer(IPlayer iPlayer, boolean z, long j);

        void onReadyToDisplay(boolean z);

        void onRequestAudioFocus();

        void onResolutionChange(Resolution resolution, Resolution resolution2);

        void onUIStateChange(IPlayer iPlayer, int i);

        void onVideoEngineInfos(IPlayer iPlayer, VideoEngineInfos videoEngineInfos);
    }

    PlayEngineInfo getCurrentPlayInfo();

    int getDuration();

    float getPercentage();

    PlayAddress getPlayAddress();

    int getPosition();

    boolean isOsPlayer();

    boolean isPaused();

    boolean isPlaying();

    boolean isReleased();

    boolean isStopped();

    void pause(boolean z);

    void play(PlayEngineInfo playEngineInfo);

    void release();

    void removePlayerListener();

    void resume();

    void seekTo(long j);

    void setPlaySpeed(int i);

    void setPlayerListener(PlayerListener playerListener);

    void stop();
}
