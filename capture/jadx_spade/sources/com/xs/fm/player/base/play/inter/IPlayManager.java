package com.xs.fm.player.base.play.inter;

import com.ss.ttvideoengine.Resolution;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AbsPlayList;
import com.xs.fm.player.base.play.data.AudioDeviceInfoForPlay;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import jl6.e;
import ll6.a;
import ll6.b;
import qk6.c;
import qk6.d;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPlayManager {
    void addInterceptorListener(d dVar);

    void addManualChangeChapterInterceptor(a aVar);

    void addManualResumePlayInterceptor(b bVar);

    void addPlayAutoNextInterceptor(qk6.b bVar);

    void addPlayListener(AbsPlayListener absPlayListener);

    void addPlayStartInterceptor(c cVar);

    boolean canPlayNext();

    boolean canPlayPrev();

    void changeAudioEffect(pk6.a aVar);

    void changeAudioLoudestInfo(pk6.a aVar);

    void changeAudioResolution(Resolution resolution);

    void changeVoiceBgmInfo(VoiceBgmInfo voiceBgmInfo);

    AudioDeviceInfoForPlay getCurrentAudioDeviceInfoForPlay();

    int getCurrentBgNoiseId();

    int getCurrentDuration();

    int getCurrentEnginePosition();

    String getCurrentItemId();

    AbsPlayList getCurrentList();

    String getCurrentListId();

    int getCurrentListSize();

    PlayAddress getCurrentPlayAddress();

    String getCurrentPlayFrom();

    PlayEngineInfo getCurrentPlayInfo();

    pk6.c getCurrentPlayParam();

    IPlayer getCurrentPlayer();

    int getCurrentProgress();

    float getCurrentProgressPercent();

    int getCurrentSpeed();

    qk6.a getCurrentStrategy();

    int getCurrentTone();

    int getPlayState();

    e getRespOfPlayAddress();

    int getUIState();

    boolean isCurrentOsPlayer();

    boolean isPaused();

    boolean isPlaying();

    void pause();

    /* synthetic */ void pause(kl6.a aVar);

    void pause(boolean z);

    /* synthetic */ void pause(boolean z, kl6.a aVar);

    void play(pk6.c cVar);

    /* synthetic */ void play(pk6.c cVar, kl6.a aVar);

    void playItemOfN(int i);

    /* synthetic */ void playItemOfN(int i, kl6.a aVar);

    void playNext();

    /* synthetic */ void playNext(kl6.a aVar);

    void playPrev();

    /* synthetic */ void playPrev(kl6.a aVar);

    void playTip(rk6.a aVar, boolean z);

    void release();

    void removeInterceptorListener(d dVar);

    void removeManualChangeChapterInterceptor(a aVar);

    void removeManualResumePlayInterceptor(b bVar);

    void removePlayAutoNextInterceptor(qk6.b bVar);

    void removePlayListener(AbsPlayListener absPlayListener);

    void removePlayStartInterceptor(c cVar);

    void resume(boolean z);

    /* synthetic */ void resume(boolean z, kl6.a aVar);

    void seekTo(long j);

    /* synthetic */ void seekTo(long j, kl6.a aVar);

    void setPlaySpeed(int i);

    void stop();

    /* synthetic */ void stop(kl6.a aVar);

    void updateProgress(long j, long j2);
}
