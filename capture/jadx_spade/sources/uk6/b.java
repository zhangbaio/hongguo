package uk6;

import al2.i0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsXrayApi;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import v03.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b implements IPlayer {
    private final a a;
    private IPlayer.PlayerListener b;

    static {
        Covode.recordClassIndex(655849);
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isReleased() {
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void play(PlayEngineInfo playEngineInfo) {
        c(this, playEngineInfo);
    }

    public IAudioPlayer d() {
        return this.a.a;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void release() {
        if (d() != null) {
            d().release();
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void resume() {
        if (d() != null) {
            d().resume();
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void stop() {
        if (d() != null) {
            d().stop();
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayEngineInfo getCurrentPlayInfo() {
        if (d() != null) {
            return d().getCurrentPlayInfo();
        }
        return null;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getDuration() {
        if (d() != null) {
            return d().getDuration();
        }
        return 0;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public float getPercentage() {
        if (d() != null) {
            return d().getPercentage();
        }
        return 0.0f;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public PlayAddress getPlayAddress() {
        if (d() != null) {
            return d().getPlayAddress();
        }
        return null;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public int getPosition() {
        if (d() != null) {
            return d().getPosition();
        }
        return 0;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isOsPlayer() {
        if (d() != null) {
            return d().isOsPlayer();
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPaused() {
        if (d() != null) {
            return d().isPaused();
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isPlaying() {
        if (d() != null) {
            return d().isPlaying();
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public boolean isStopped() {
        if (d() != null) {
            return d().isStopped();
        }
        return false;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void removePlayerListener() {
        this.b = null;
        if (d() != null) {
            d().removePlayerListener();
        }
    }

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void pause(boolean z) {
        if (d() != null) {
            d().pause(z);
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void seekTo(long j) {
        if (d() != null) {
            d().seekTo(j);
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlaySpeed(int i) {
        if (d() != null) {
            d().setPlaySpeed(i);
        }
    }

    @Override // com.xs.fm.player.base.play.player.IPlayer
    public void setPlayerListener(IPlayer.PlayerListener playerListener) {
        this.b = playerListener;
        if (d() != null) {
            d().setPlayerListener(playerListener);
        }
    }

    public void b(PlayEngineInfo playEngineInfo) {
        this.a.g(playEngineInfo);
        if (d() != null) {
            d().setPlayerListener(this.b);
            d().play(playEngineInfo);
        }
    }

    @TargetClass("com.xs.fm.player.base.play.player.audio.multi.MultiAudioPlayer")
    @Insert("play")
    public static void c(b bVar, PlayEngineInfo playEngineInfo) {
        NsXrayApi nsXrayApi = NsXrayApi.IMPL;
        if (nsXrayApi.enable()) {
            i0.a.d("MultiAudioPlayer(SDK).play(), ", new Object[0]);
            nsXrayApi.sendEvent("听书SDK结束结束调用Player.play()", i0.g(new g(), playEngineInfo));
        }
        bVar.b(playEngineInfo);
    }
}
