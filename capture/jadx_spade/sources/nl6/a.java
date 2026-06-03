package nl6;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AudioDeviceInfoForPlay;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.data.VoiceBgmInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer;
import com.xs.fm.player.sdk.play.player.audio.engine.EngineLooperMonitor;
import lk6.c;
import ql6.f;
import ql6.g;
import ql6.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a implements IAudioPlayer {
    private static volatile a f;
    private static final g g;
    private volatile IAudioPlayer d;
    protected final bl6.a a = new bl6.a("FMSDKPlayerTrace-FMAudioPlayer");
    private final Object b = new Object();
    public f c = new ql6.a();
    private volatile boolean e = false;

    protected void c(IAudioPlayer iAudioPlayer) {
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public TTVideoEngine getEngine() {
        return this.d.getEngine();
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void promoteThreadPriority() {
        b().promoteThreadPriority();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void release() {
        b().release();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void removePlayerListener() {
        b().removePlayerListener();
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void resetThreadPriority() {
        b().resetThreadPriority();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void resume() {
        b().resume();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void stop() {
        b().stop();
    }

    static {
        Covode.recordClassIndex(655943);
        f = null;
        g = ql6.b.b;
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public AudioDeviceInfoForPlay getCurrentAudioDeviceInfoForPlay() {
        return b().getCurrentAudioDeviceInfoForPlay();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayEngineInfo getCurrentPlayInfo() {
        return b().getCurrentPlayInfo();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getDuration() {
        return b().getDuration();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public float getPercentage() {
        return b().getPercentage();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayAddress getPlayAddress() {
        return b().getPlayAddress();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getPosition() {
        return b().getPosition();
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public boolean isEngineLooperBlock() {
        return b().isEngineLooperBlock();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isOsPlayer() {
        return b().isOsPlayer();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPaused() {
        return b().isPaused();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPlaying() {
        return b().isPlaying();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isReleased() {
        return b().isReleased();
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isStopped() {
        return b().isStopped();
    }

    protected IAudioPlayer b() {
        if (this.d == null) {
            synchronized (this.b) {
                if (this.d == null) {
                    this.d = this.c.a(0, null);
                }
            }
        }
        return this.d;
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeAudioEffect(pk6.a aVar) {
        b().changeAudioEffect(aVar);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeAudioLoudestInfo(pk6.a aVar) {
        b().changeAudioLoudestInfo(aVar);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void changeVoiceBgmInfo(VoiceBgmInfo voiceBgmInfo) {
        b().changeVoiceBgmInfo(voiceBgmInfo);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void configAudioResolution(Resolution resolution) {
        b().configAudioResolution(resolution);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void pause(boolean z) {
        b().pause(z);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void seekTo(long j) {
        b().seekTo(j);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlaySpeed(int i) {
        b().setPlaySpeed(i);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlayerListener(IPlayer.PlayerListener playerListener) {
        b().setPlayerListener(playerListener);
    }

    @Override // com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer
    public void switchPlayer(IAudioPlayer iAudioPlayer) {
        b().switchPlayer(iAudioPlayer);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void play(PlayEngineInfo playEngineInfo) {
        lk6.b bVar;
        nk6.b bVar2;
        this.e = false;
        IAudioPlayer b = b();
        if (!playEngineInfo.isOsPlayer) {
            h e = g.e(playEngineInfo);
            if ((e instanceof IAudioPlayer) && b != e) {
                IAudioPlayer iAudioPlayer = (IAudioPlayer) e;
                b.switchPlayer(iAudioPlayer);
                this.a.d("play: play switch preparedPlayer success! hit prepare item = %s", playEngineInfo.itemId);
                this.e = true;
                b = iAudioPlayer;
            }
        }
        EngineLooperMonitor.j(playEngineInfo, b.isEngineLooperBlock(), false);
        int i = 2;
        if (b.isReleased() || b.isOsPlayer() != playEngineInfo.isOsPlayer || ((!this.e && (bVar = c.a) != null && (bVar2 = bVar.l) != null && bVar2.K()) || ((b.getPlayAddress() != null && b.getPlayAddress().playType != playEngineInfo.playAddress.playType) || (c.a.l.N() && b.isEngineLooperBlock() && EngineLooperMonitor.g() <= 2)))) {
            if (c.a.l.N() && b.isEngineLooperBlock()) {
                EngineLooperMonitor.i(false);
            }
            f fVar = this.c;
            if (!playEngineInfo.isOsPlayer) {
                i = 0;
            }
            com.xs.fm.player.sdk.play.player.audio.engine.g a = fVar.a(i, Integer.valueOf(playEngineInfo.genreType));
            this.a.d("play: currentPlayer isReleased, switchPlayer player os=%s success!", Boolean.valueOf(playEngineInfo.isOsPlayer));
            b.switchPlayer(a);
            b = a;
        }
        this.d = b;
        promoteThreadPriority();
        c(b);
        b.play(playEngineInfo);
    }
}
