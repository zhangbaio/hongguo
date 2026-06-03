package com.xs.fm.player.sdk.play.player.audio.engine;

import android.view.Surface;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Unit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h extends g implements tk6.a {
    static {
        Covode.recordClassIndex(655950);
    }

    public h() {
    }

    @Override // com.xs.fm.player.sdk.play.player.audio.engine.g, com.xs.fm.player.base.play.player.IPlayer
    public void release() {
        String str;
        TTVideoEngine tTVideoEngine = this.d;
        if (tTVideoEngine != null) {
            try {
                MediaPlayer mediaPlayer = (MediaPlayer) Reflect.on((TTVideoEngineInterface) Reflect.on(tTVideoEngine).get("mVideoEngine", new Class[0])).get("mMediaPlayer", new Class[0]);
                String str2 = (String) Reflect.on(mediaPlayer).get("mExceptionStr", new Class[0]);
                Reflect on = Reflect.on(mediaPlayer);
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(", tag=");
                TTVideoEngine tTVideoEngine2 = this.d;
                if (tTVideoEngine2 != null) {
                    str = tTVideoEngine2.getTag();
                } else {
                    str = null;
                }
                sb.append(str);
                on.set("mExceptionStr", sb.toString());
                long j = TTVideoEngineConfig.setSurfaceTimeoutForDestroy;
                if (j == Long.MIN_VALUE) {
                    j = tTVideoEngine.getLongOption(950);
                }
                TTVideoEngine tTVideoEngine3 = this.d;
                if (tTVideoEngine3 != null) {
                    tTVideoEngine3.setSurfaceSync(null, j);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
            }
        }
        super.release();
    }

    public h(int i) {
        super(i);
    }

    @Override // tk6.a
    public void a(boolean z) {
        g.z.d("turnVideoToAudioMode: enable = " + z + ", mEngine=" + this.d, new Object[0]);
        TTVideoEngine tTVideoEngine = this.d;
        if (tTVideoEngine != null) {
            tTVideoEngine.setIntOption(480, z ? 1 : 0);
        }
    }

    @Override // tk6.a
    public void setSurface(Surface surface) {
        g.z.d("DashAudioEnginePlayer setSurface = " + surface + ", mEngine=" + this.d, new Object[0]);
        TTVideoEngine tTVideoEngine = this.d;
        if (tTVideoEngine != null) {
            tTVideoEngine.setSurface(surface);
        }
    }
}
