package ij6;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private final Context a;
    public MediaPlayer b;
    private float c;
    public float d = 1.0f;
    private boolean e = false;

    static {
        Covode.recordClassIndex(653083);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float a() {
        /*
            r3 = this;
            android.content.Context r0 = r3.a
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            boolean r1 = r3.e
            if (r1 == 0) goto L10
            int r0 = com.ss.videoarch.liveplayer.utils.a.e(r0)
            float r0 = (float) r0
            return r0
        L10:
            java.lang.String r1 = "audio"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            r1 = 0
            if (r0 == 0) goto L22
            r2 = 3
            int r0 = r0.getStreamMaxVolume(r2)     // Catch: java.lang.Exception -> L21
            goto L23
        L21:
        L22:
            r0 = 0
        L23:
            if (r0 >= 0) goto L26
            goto L27
        L26:
            r1 = r0
        L27:
            float r0 = (float) r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ij6.b.a():float");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float b() {
        /*
            r3 = this;
            android.content.Context r0 = r3.a
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            boolean r1 = r3.e
            if (r1 == 0) goto L10
            double r0 = com.ss.videoarch.liveplayer.utils.a.g(r0)
            float r0 = (float) r0
            return r0
        L10:
            r1 = 0
            java.lang.String r2 = "audio"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch: java.lang.Exception -> L21
            android.media.AudioManager r0 = (android.media.AudioManager) r0     // Catch: java.lang.Exception -> L21
            if (r0 == 0) goto L25
            r2 = 3
            int r0 = r0.getStreamVolume(r2)     // Catch: java.lang.Exception -> L21
            goto L26
        L21:
            r0 = move-exception
            r0.printStackTrace()
        L25:
            r0 = 0
        L26:
            if (r0 >= 0) goto L29
            goto L2a
        L29:
            r1 = r0
        L2a:
            float r0 = (float) r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ij6.b.b():float");
    }

    public void c(boolean z) {
        this.e = z;
        if (z) {
            com.ss.videoarch.liveplayer.utils.a.j(this.a);
        } else {
            com.ss.videoarch.liveplayer.utils.a.l(this.a);
        }
    }

    public void e(float f) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.d = f;
        mediaPlayer.setVolume(f, f);
    }

    public void d(boolean z) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        if (mediaPlayer.isOSPlayer()) {
            float a = a();
            if (a > 0.0f) {
                this.c = b() / a;
            }
            if (z) {
                this.b.setVolume(0.0f, 0.0f);
                return;
            }
            MediaPlayer mediaPlayer2 = this.b;
            float f = this.c;
            mediaPlayer2.setVolume(f, f);
            return;
        }
        this.b.setIsMute(z);
    }

    public void f(float f) {
        if (this.b == null) {
            return;
        }
        if (this.e) {
            com.ss.videoarch.liveplayer.utils.a.k(this.a, (int) f, 0);
            return;
        }
        AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamVolume(3, (int) f, 0);
        }
    }

    public b(Context context, MediaPlayer mediaPlayer) {
        this.b = mediaPlayer;
        this.a = context;
    }
}
