package cl6;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import com.xs.fm.player.base.play.inter.IPlayManager;
import com.xs.fm.player.base.play.player.IPlayer;
import kotlin.jvm.internal.Intrinsics;
import lk6.c;
import xk6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static final bl6.a a;
    private static Context b;
    private static kk6.a c;
    private static MediaSessionCompat d;
    private static final b e;
    private static boolean f;
    public static final a g;

    private a() {
    }

    public static final class b extends AbsPlayListener {
        b() {
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onListDataChanged() {
            kk6.b a;
            a aVar = a.g;
            kk6.a b = a.b(aVar);
            if (b != null && (a = b.a(a.a(aVar))) != null) {
                aVar.h(a);
            }
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onItemChanged(String str, String str2) {
            a aVar = a.g;
            aVar.update(a.a(aVar));
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onListChanged(pk6.b bVar, pk6.b bVar2) {
            a aVar = a.g;
            aVar.update(a.a(aVar));
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onPlayStateChange(IPlayer iPlayer, int i) {
            kk6.b a;
            a aVar = a.g;
            kk6.a b = a.b(aVar);
            if (b != null && (a = b.a(a.a(aVar))) != null) {
                aVar.h(a);
            }
        }
    }

    public final MediaSessionCompat d() {
        return d;
    }

    static {
        Covode.recordClassIndex(655901);
        g = new a();
        a = new bl6.a("MediaSessionManager");
        e = new b();
    }

    /* renamed from: cl6.a$a, reason: collision with other inner class name */
    static final class RunnableC0011a implements Runnable {
        public static final RunnableC0011a a = new RunnableC0011a();

        RunnableC0011a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(a.a(a.g), "MediaSessionManager");
            mediaSessionCompat.k(3);
            kk6.a aVar = c.a.i;
            Intrinsics.checkExpressionValueIsNotNull(aVar, "PlayConfigUtil.playConfig.mediaSession");
            MediaSessionCompat.c b = aVar.b();
            if (b != null) {
                mediaSessionCompat.i(b);
            }
            mediaSessionCompat.h(true);
            a.d = mediaSessionCompat;
        }
    }

    public final void e() {
        Application application;
        kk6.a aVar;
        lk6.b bVar = c.a;
        if (bVar != null && (application = bVar.b) != null) {
            b = application;
            if (bVar != null && (aVar = bVar.i) != null) {
                c = aVar;
                g.k(RunnableC0011a.a);
                kk6.a aVar2 = c;
                if (aVar2 != null && !aVar2.c()) {
                    il6.a.B().addPlayListener(e);
                }
            }
        }
    }

    public static final /* synthetic */ Context a(a aVar) {
        return b;
    }

    public static final /* synthetic */ kk6.a b(a aVar) {
        return c;
    }

    public final void f(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        MediaSessionCompat.Token d2;
        a.d("serviceBindMediaSession()", new Object[0]);
        MediaSessionCompat mediaSessionCompat = d;
        if (mediaSessionCompat != null && (d2 = mediaSessionCompat.d()) != null) {
            mediaBrowserServiceCompat.setSessionToken(d2);
        }
    }

    public final void update(Context context) {
        kk6.b a2;
        a.d("update()", new Object[0]);
        kk6.a aVar = c;
        if (aVar != null && (a2 = aVar.a(context)) != null) {
            a aVar2 = g;
            aVar2.g(a2);
            aVar2.h(a2);
        }
    }

    public final void g(kk6.b bVar) {
        try {
            MediaMetadataCompat.b bVar2 = new MediaMetadataCompat.b();
            String str = bVar.a;
            if (str != null) {
                bVar2.e("android.media.metadata.TITLE", str);
            }
            String str2 = bVar.b;
            if (str2 != null) {
                bVar2.e("android.media.metadata.DISPLAY_SUBTITLE", str2);
            }
            int i = bVar.d;
            if (i > 0) {
                bVar2.c("android.media.metadata.DURATION", i);
            }
            Bitmap bitmap = bVar.e;
            if (bitmap != null && !bitmap.isRecycled()) {
                bVar2.b("android.media.metadata.ALBUM_ART", bitmap);
            }
            bVar2.d("android.media.metadata.RATING", RatingCompat.newHeartRating(bVar.f));
            String str3 = bVar.g;
            if (str3 != null) {
                bVar2.e("android.media.metadata.ARTIST", str3);
            }
            bVar2.e("hicar.media.metadata.LYRICS", "--");
            MediaSessionCompat mediaSessionCompat = d;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.m(bVar2.a());
            }
            f = true;
        } catch (Exception e2) {
            a.b("failed updateUIInfo, errMsg = " + e2.getMessage(), new Object[0]);
        }
    }

    public final void h(kk6.b bVar) {
        int i;
        long j;
        if (!f) {
            return;
        }
        IPlayManager B = il6.a.B();
        Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
        if (B.getPlayState() == 103) {
            i = 3;
        } else {
            i = 2;
        }
        int i2 = bVar.c;
        if ((bVar.i && il6.a.B().canPlayNext()) || bVar.l) {
            j = 38;
        } else {
            j = 6;
        }
        if ((bVar.h && il6.a.B().canPlayPrev()) || bVar.m) {
            j |= 16;
        }
        if (bVar.j) {
            j |= 128;
        }
        if (bVar.k) {
            j |= 256;
        }
        float f2 = 1.0f;
        if (bVar.n) {
            Intrinsics.checkExpressionValueIsNotNull(il6.a.B(), "PlayManager.getInstance()");
            if (r9.getCurrentSpeed() / 100.0f > 0) {
                Intrinsics.checkExpressionValueIsNotNull(il6.a.B(), "PlayManager.getInstance()");
                f2 = r9.getCurrentSpeed() / 100.0f;
            }
        }
        MediaSessionCompat mediaSessionCompat = d;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.n(new PlaybackStateCompat.b().b(j).c(i, i2, f2).a());
        }
    }
}
