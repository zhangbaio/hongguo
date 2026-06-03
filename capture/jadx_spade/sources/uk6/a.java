package uk6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer;
import zk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a {
    public IAudioPlayer a;
    protected String b = "";

    static {
        Covode.recordClassIndex(655848);
    }

    public abstract IAudioPlayer c(String str);

    protected abstract void d(String str, String str2);

    public abstract String f(PlayEngineInfo playEngineInfo);

    public void e() {
        IAudioPlayer iAudioPlayer = this.a;
        if (iAudioPlayer != null) {
            iAudioPlayer.release();
            this.a = null;
        }
        this.b = "";
    }

    public void g(PlayEngineInfo playEngineInfo) {
        String f = f(playEngineInfo);
        c.t("sub_player_key", f);
        if (!f.equals(this.b)) {
            IAudioPlayer c = c(f);
            IAudioPlayer iAudioPlayer = this.a;
            if (iAudioPlayer != null) {
                iAudioPlayer.switchPlayer(c);
            }
            d(this.b, f);
            e();
            this.b = f;
            this.a = c;
        }
    }
}
