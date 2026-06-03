package ul6;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.android.videoshop.utils.VideoCommonUtils;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.inter.IPlayManager;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d implements ul6.a {
    private final bl6.a a = new bl6.a("FMSDKPlayerPrepare-VideoPrepareManagerImpl");
    private sl6.a b = new sl6.c();
    private ConcurrentHashMap<PlayEngineInfo, ul6.b> c = new ConcurrentHashMap<>();
    private ConcurrentHashMap<PlayEngineInfo, com.xs.fm.player.sdk.play.player.video.custom.a> d = new ConcurrentHashMap<>();
    private LinkedList<PlayEngineInfo> e = new LinkedList<>();
    private LinkedList<PlayEngineInfo> f = new LinkedList<>();
    private int g = 2;
    private final Handler h = new HandlerDelegate(Looper.getMainLooper());

    static {
        Covode.recordClassIndex(656045);
    }

    static final class b implements Runnable {
        final /* synthetic */ com.xs.fm.player.sdk.play.player.video.custom.a a;

        b(com.xs.fm.player.sdk.play.player.video.custom.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UIUtils.detachFromParent(this.a);
        }
    }

    private final void g(PlayEngineInfo playEngineInfo) {
        this.a.d("releasePreparedPlayer playEngineInfo = " + playEngineInfo, new Object[0]);
        ul6.b remove = this.c.remove(playEngineInfo);
        if (remove != null) {
            remove.release();
            remove.removePlayerListener();
        }
        this.e.remove(playEngineInfo);
        this.f.remove(playEngineInfo);
        com.xs.fm.player.sdk.play.player.video.custom.a it2 = this.d.remove(playEngineInfo);
        if (it2 != null) {
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            it2.setSurfaceTextureListener(null);
            this.h.post(new b(it2));
        }
    }

    public static final class a implements TextureView.SurfaceTextureListener {
        final /* synthetic */ PlayEngineInfo b;
        final /* synthetic */ sl6.b c;

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        a(PlayEngineInfo playEngineInfo, sl6.b bVar) {
            this.b = playEngineInfo;
            this.c = bVar;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (!d.this.d.containsKey(this.b)) {
                d.this.a.d("preparedTextureViewMap not contains playEngineInfo, itemId=" + this.b.itemId, new Object[0]);
                return;
            }
            d.this.e.offer(this.b);
            d.this.f.offer(this.b);
            d.this.c.put(this.b, this.c);
            Surface surface = new Surface(surfaceTexture);
            d.this.a.d("prepareWithSurface: onSurfaceTextureAvailable, start prepare surface=" + surface, new Object[0]);
            this.c.k(this.b, surface);
        }
    }

    @Override // ul6.a
    public void a(Context context, PlayEngineInfo playEngineInfo, Surface surface) {
        boolean z;
        String str;
        tl6.b bVar;
        String str2;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.u) != null) {
            PlayAddress playAddress = playEngineInfo.playAddress;
            if (playAddress != null) {
                str2 = playAddress.tag;
            } else {
                str2 = null;
            }
            z = bVar.e(str2);
        } else {
            z = false;
        }
        if (!z) {
            this.a.d("prepareWithSurface: enablePrepare is false, playEngineInfo = " + playEngineInfo, new Object[0]);
            return;
        }
        IPlayManager B = il6.a.B();
        Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
        PlayAddress currentPlayAddress = B.getCurrentPlayAddress();
        if (currentPlayAddress != null && (str = currentPlayAddress.cacheKey) != null && str.equals(playEngineInfo.playAddress.cacheKey)) {
            this.a.d("TprepareWithSurface: his chapter is playing! playEngineInfo = " + playEngineInfo, new Object[0]);
            return;
        }
        if (this.c.size() >= this.g) {
            this.a.d("prepareWithSurface: preparedPlayerMap is full!", new Object[0]);
            PlayEngineInfo peek = this.e.peek();
            if (peek != null) {
                g(peek);
            }
        }
        this.a.d("prepareWithSurface: start prepareWithSurface: playEngineInfo = " + playEngineInfo, new Object[0]);
        sl6.b a2 = this.b.a(0);
        if (surface != null && surface.isValid()) {
            this.a.d("prepareWithSurface: surface is not null, surface = " + surface, new Object[0]);
            a2.k(playEngineInfo, surface);
            this.e.offer(playEngineInfo);
            this.c.put(playEngineInfo, a2);
            return;
        }
        xk6.a g = xk6.a.g();
        Intrinsics.checkExpressionValueIsNotNull(g, "AppLifecycleMonitor.getInstance()");
        if (g.b) {
            this.a.d("prepareWithSurface: surface is null or invalid and is foreground, create TextureView", new Object[0]);
            Activity safeCastActivity = VideoCommonUtils.safeCastActivity(context);
            ViewGroup viewGroup = (ViewGroup) safeCastActivity.findViewById(R.id.content);
            this.a.b("activity=" + safeCastActivity + ", contentGroup=" + viewGroup, new Object[0]);
            if (viewGroup == null) {
                this.a.b("activity or contentGroup is null", new Object[0]);
                return;
            }
            com.xs.fm.player.sdk.play.player.video.custom.a aVar = new com.xs.fm.player.sdk.play.player.video.custom.a(context, null, 0, 6, null);
            aVar.setSurfaceTextureListener(new a(playEngineInfo, a2));
            this.d.put(playEngineInfo, aVar);
            this.a.d("prepareWithSurface: add textureView to contentGroup, textureView=" + aVar, new Object[0]);
            viewGroup.addView(aVar, new ViewGroup.LayoutParams(0, 0));
            return;
        }
        this.a.d("prepareWithSurface: surface is null or invalid and is background, no surface prepare", new Object[0]);
        this.e.offer(playEngineInfo);
        this.c.put(playEngineInfo, a2);
        a2.k(playEngineInfo, surface);
    }
}
