package nl6;

import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;
import com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer;
import com.xs.fm.player.sdk.play.player.audio.engine.g;
import com.xs.fm.player.sdk.play.player.audio.engine.h;
import ql6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends nl6.a {
    private com.xs.fm.player.sdk.play.player.video.custom.b h;

    static {
        Covode.recordClassIndex(655944);
    }

    public b() {
        this.c = new a();
    }

    /* renamed from: nl6.b$b, reason: collision with other inner class name */
    public static final class RunnableC0246b implements Runnable {
        final /* synthetic */ com.xs.fm.player.sdk.play.player.video.custom.b b;

        @Override // java.lang.Runnable
        public void run() {
            IAudioPlayer b = b.this.b();
            if (!(b instanceof tk6.a)) {
                b = null;
            }
            tk6.a aVar = (tk6.a) b;
            if (aVar != null) {
                aVar.setSurface(this.b.getSurface());
            }
        }

        RunnableC0246b(com.xs.fm.player.sdk.play.player.video.custom.b bVar) {
            this.b = bVar;
        }
    }

    public static final class c implements Runnable {
        final /* synthetic */ IAudioPlayer b;

        @Override // java.lang.Runnable
        public void run() {
            IAudioPlayer iAudioPlayer = this.b;
            Surface surface = null;
            if (!(iAudioPlayer instanceof tk6.a)) {
                iAudioPlayer = null;
            }
            tk6.a aVar = (tk6.a) iAudioPlayer;
            if (aVar == null) {
                return;
            }
            com.xs.fm.player.sdk.play.player.video.custom.b bVar = b.this.h;
            if (bVar != null) {
                surface = bVar.getSurface();
            }
            aVar.setSurface(surface);
        }

        c(IAudioPlayer iAudioPlayer) {
            this.b = iAudioPlayer;
        }
    }

    public final void a(boolean z) {
        this.a.d("turnVideoToAudioMode, enable=" + z, new Object[0]);
        IAudioPlayer b = b();
        if (!(b instanceof tk6.a)) {
            b = null;
        }
        tk6.a aVar = (tk6.a) b;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public final void e(com.xs.fm.player.sdk.play.player.video.custom.b bVar) {
        this.a.d("bindVideoView, videoView=" + bVar, new Object[0]);
        this.h = bVar;
        if (bVar != null) {
            bVar.setTTVideoEngine(getEngine());
        }
        if (bVar != null) {
            bVar.w(new RunnableC0246b(bVar));
        }
    }

    @Override // nl6.a
    protected void c(IAudioPlayer iAudioPlayer) {
        Boolean bool;
        bl6.a aVar = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("onBeforePlay, player=");
        sb.append(iAudioPlayer);
        sb.append(" videoView=");
        sb.append(this.h);
        sb.append(" surfaceValid=");
        com.xs.fm.player.sdk.play.player.video.custom.b bVar = this.h;
        TTVideoEngine tTVideoEngine = null;
        if (bVar != null) {
            bool = Boolean.valueOf(bVar.B());
        } else {
            bool = null;
        }
        sb.append(bool);
        aVar.d(sb.toString(), new Object[0]);
        com.xs.fm.player.sdk.play.player.video.custom.b bVar2 = this.h;
        if (bVar2 != null) {
            if (iAudioPlayer != null) {
                tTVideoEngine = iAudioPlayer.getEngine();
            }
            bVar2.setTTVideoEngine(tTVideoEngine);
        }
        com.xs.fm.player.sdk.play.player.video.custom.b bVar3 = this.h;
        if (bVar3 != null) {
            bVar3.w(new c(iAudioPlayer));
        }
    }

    public static final class a implements f {
        a() {
        }

        @Override // ql6.f
        public g a(int i, Integer num) {
            return new h();
        }
    }
}
