package com.xs.fm.player.base.play.player.audio.engine;

import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.xs.fm.player.base.play.data.AudioDeviceInfoForPlay;
import com.xs.fm.player.base.play.data.VoiceBgmInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import pk6.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IAudioPlayer extends IPlayer {
    void changeAudioEffect(a aVar);

    void changeAudioLoudestInfo(a aVar);

    void changeVoiceBgmInfo(VoiceBgmInfo voiceBgmInfo);

    void configAudioResolution(Resolution resolution);

    AudioDeviceInfoForPlay getCurrentAudioDeviceInfoForPlay();

    TTVideoEngine getEngine();

    boolean isEngineLooperBlock();

    void promoteThreadPriority();

    void resetThreadPriority();

    void switchPlayer(IAudioPlayer iAudioPlayer);
}
