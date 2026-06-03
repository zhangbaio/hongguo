package ql6;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.videoshop.utils.VideoCommonUtils;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.inter.IPlayManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c implements g, Application.ActivityLifecycleCallbacks {
    private int f;
    private final bl6.a a = new bl6.a("AudioPrepareManagerImpl");
    private ConcurrentHashMap<PlayEngineInfo, h> b = new ConcurrentHashMap<>();
    private ConcurrentHashMap<PlayEngineInfo, WeakReference<View>> c = new ConcurrentHashMap<>();
    private LinkedList<PlayEngineInfo> d = new LinkedList<>();
    private HashSet<String> e = new HashSet<>();
    private f g = new ql6.a();

    static {
        Covode.recordClassIndex(655975);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public c() {
        boolean z;
        Application application;
        this.f = 2;
        Integer valueOf = Integer.valueOf(lk6.c.a.o.f());
        if (valueOf.intValue() >= 0) {
            z = true;
        } else {
            z = false;
        }
        valueOf = z ? valueOf : null;
        if (valueOf != null) {
            this.f = valueOf.intValue();
        }
        lk6.b bVar = lk6.c.a;
        if (bVar != null && (application = bVar.b) != null) {
            application.registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // ql6.g
    public void release() {
        View view;
        Iterator<Map.Entry<PlayEngineInfo, h>> it2 = this.b.entrySet().iterator();
        while (it2.hasNext()) {
            h value = it2.next().getValue();
            value.release();
            value.removePlayerListener();
        }
        Iterator<Map.Entry<PlayEngineInfo, WeakReference<View>>> it4 = this.c.entrySet().iterator();
        while (it4.hasNext()) {
            View view2 = it4.next().getValue().get();
            if (view2 != null) {
                if (!(view2 instanceof TextureView)) {
                    view = null;
                } else {
                    view = view2;
                }
                TextureView textureView = (TextureView) view;
                if (textureView != null) {
                    textureView.setSurfaceTextureListener(null);
                }
                UIUtils.detachFromParent(view2);
            }
        }
        this.d.clear();
        this.b.clear();
        this.e.clear();
        this.c.clear();
    }

    @Override // ql6.g
    public void c(f fVar) {
        this.g = fVar;
    }

    private final boolean l(PlayEngineInfo playEngineInfo) {
        boolean z;
        boolean z2;
        boolean z3;
        if (playEngineInfo == null) {
            return false;
        }
        PlayAddress playAddress = playEngineInfo.playAddress;
        if (playAddress.playType == 1) {
            String str = playAddress.playFile;
            if (str != null && str.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                return false;
            }
        }
        PlayAddress playAddress2 = playEngineInfo.playAddress;
        if (playAddress2.playType == 0) {
            String str2 = playAddress2.playUrl;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return false;
            }
        }
        PlayAddress playAddress3 = playEngineInfo.playAddress;
        if (playAddress3.playType == 2) {
            String str3 = playAddress3.playVideoModel;
            if (str3 != null && str3.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
        }
        return true;
    }

    private final void m(PlayEngineInfo playEngineInfo) {
        View view;
        View view2;
        this.a.d("releasePreparedPlayer audioPlayInfo = " + playEngineInfo, new Object[0]);
        h remove = this.b.remove(playEngineInfo);
        if (remove != null) {
            remove.release();
            remove.removePlayerListener();
        }
        this.d.remove(playEngineInfo);
        WeakReference<View> remove2 = this.c.remove(playEngineInfo);
        if (remove2 != null && (view = remove2.get()) != null) {
            if (!(view instanceof TextureView)) {
                view2 = null;
            } else {
                view2 = view;
            }
            TextureView textureView = (TextureView) view2;
            if (textureView != null) {
                textureView.setSurfaceTextureListener(null);
            }
            UIUtils.detachFromParent(view);
        }
        this.e.clear();
    }

    @Override // ql6.g
    public boolean b(PlayEngineInfo playEngineInfo) {
        String str;
        boolean contains;
        for (Map.Entry<PlayEngineInfo, h> entry : this.b.entrySet()) {
            this.a.d("preparedPlayer playEngineInfo = " + entry.getKey(), new Object[0]);
            if (playEngineInfo.isSameWith(entry.getKey())) {
                HashSet<String> hashSet = this.e;
                PlayAddress playAddress = entry.getKey().playAddress;
                if (playAddress != null) {
                    str = playAddress.cacheKey;
                } else {
                    str = null;
                }
                contains = CollectionsKt___CollectionsKt.contains(hashSet, str);
                if (contains) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Context context;
        WeakReference<View> remove;
        View view;
        View view2;
        for (Map.Entry entry : new LinkedHashMap(this.c).entrySet()) {
            View view3 = (View) ((WeakReference) entry.getValue()).get();
            if (view3 != null) {
                context = view3.getContext();
            } else {
                context = null;
            }
            if (Intrinsics.areEqual(context, activity) && (remove = this.c.remove(entry.getKey())) != null && (view = remove.get()) != null) {
                if (!(view instanceof TextureView)) {
                    view2 = null;
                } else {
                    view2 = view;
                }
                TextureView textureView = (TextureView) view2;
                if (textureView != null) {
                    textureView.setSurfaceTextureListener(null);
                }
                UIUtils.detachFromParent(view);
            }
        }
    }

    @Override // ql6.g
    public h e(PlayEngineInfo playEngineInfo) {
        h hVar;
        String str;
        View view;
        View view2;
        this.a.d("switchPlayer: preparedPlayerMap.size = " + this.b.size() + ", playerInfoQueue size=" + this.d.size() + ",  playEngineInfo = " + playEngineInfo, new Object[0]);
        Iterator<PlayEngineInfo> it2 = this.d.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it2, "playerInfoQueue.iterator()");
        while (true) {
            hVar = null;
            if (!it2.hasNext()) {
                break;
            }
            PlayEngineInfo next = it2.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "iterator.next()");
            PlayEngineInfo playEngineInfo2 = next;
            this.a.d("preparedPlayer playEngineInfo = " + playEngineInfo2, new Object[0]);
            if (playEngineInfo.isSameWith(playEngineInfo2)) {
                this.a.d("hit prepared player! key = " + playEngineInfo2, new Object[0]);
                this.d.remove(playEngineInfo2);
                h remove = this.b.remove(playEngineInfo2);
                WeakReference<View> remove2 = this.c.remove(playEngineInfo2);
                if (remove2 != null && (view = remove2.get()) != null) {
                    if (!(view instanceof TextureView)) {
                        view2 = null;
                    } else {
                        view2 = view;
                    }
                    TextureView textureView = (TextureView) view2;
                    if (textureView != null) {
                        textureView.setSurfaceTextureListener(null);
                    }
                    UIUtils.detachFromParent(view);
                }
                PlayAddress playAddress = playEngineInfo2.playAddress;
                if (playAddress != null && (str = playAddress.cacheKey) != null) {
                    this.e.remove(str);
                }
                hVar = remove;
            }
        }
        ml6.a.g.a("tryGetPreparedPlayer: preparedAudioPlayer = " + hVar);
        return hVar;
    }

    @Override // ql6.g
    public void a(PlayEngineInfo playEngineInfo) {
        String str;
        PlayEngineInfo peek;
        nk6.f fVar;
        String str2;
        ml6.a.g.a("AudioPrepareManagerImpl prepare: item = " + playEngineInfo.itemId);
        this.a.d("prepare playEngineInfo = " + playEngineInfo.toString() + ", engine map size is " + this.b.size(), new Object[0]);
        if (playEngineInfo.isOsPlayer) {
            this.a.b("try addPrepareTask failed! because isOsPlayer", new Object[0]);
            return;
        }
        if (!l(playEngineInfo)) {
            this.a.b("try addPrepareTask failed! because audioPlayInfo = " + playEngineInfo, new Object[0]);
            return;
        }
        IPlayManager B = il6.a.B();
        Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
        PlayAddress currentPlayAddress = B.getCurrentPlayAddress();
        if (currentPlayAddress != null && (str2 = currentPlayAddress.cacheKey) != null && str2.equals(playEngineInfo.playAddress.cacheKey)) {
            this.a.d("This chapter is playing! audioPlayInfo = " + playEngineInfo, new Object[0]);
            return;
        }
        lk6.b bVar = lk6.c.a;
        if (bVar != null && (fVar = bVar.o) != null && fVar.i()) {
            Iterator it2 = new LinkedHashMap(this.b).entrySet().iterator();
            while (it2.hasNext()) {
                PlayEngineInfo playEngineInfo2 = (PlayEngineInfo) ((Map.Entry) it2.next()).getKey();
                if (playEngineInfo2.playAddress.cacheKey.equals(playEngineInfo.playAddress.cacheKey) && playEngineInfo2.isSameWith(playEngineInfo)) {
                    this.a.d("This chapter has already prepared! audioPlayInfo = " + playEngineInfo, new Object[0]);
                    return;
                }
            }
        }
        if (this.b.size() >= this.f && (peek = this.d.peek()) != null) {
            m(peek);
        }
        com.xs.fm.player.sdk.play.player.audio.engine.g a2 = this.g.a(0, Integer.valueOf(playEngineInfo.genreType));
        this.d.offer(playEngineInfo);
        this.b.put(playEngineInfo, a2);
        PlayAddress playAddress = playEngineInfo.playAddress;
        if (playAddress != null && (str = playAddress.cacheKey) != null) {
            this.e.add(str);
        }
        a2.K(playEngineInfo);
        ml6.a.g.a("AudioPrepareManagerImpl prepare end success: item = " + playEngineInfo.itemId + ", map = " + this.b.size());
        bl6.a aVar = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("prepare end. map size is ");
        sb.append(this.b.size());
        aVar.d(sb.toString(), new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ql6.g
    public void d(Context context, PlayEngineInfo playEngineInfo) {
        ViewGroup viewGroup;
        PlayEngineInfo peek;
        nk6.f fVar;
        ml6.a.g.a("AudioPrepareManagerImpl prepare: item = " + playEngineInfo.itemId);
        this.a.d("prepareWithSurface playEngineInfo = " + playEngineInfo.toString() + ", engine map size is " + this.b.size(), new Object[0]);
        Activity safeCastActivity = VideoCommonUtils.safeCastActivity(context);
        if (safeCastActivity != null && (viewGroup = (ViewGroup) safeCastActivity.findViewById(R.id.content)) != null) {
            if (playEngineInfo.isOsPlayer) {
                this.a.b("try addPrepareTask failed! because isOsPlayer", new Object[0]);
                return;
            }
            if (!l(playEngineInfo)) {
                this.a.b("try addPrepareTask failed! because audioPlayInfo = " + playEngineInfo, new Object[0]);
                return;
            }
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            PlayAddress currentPlayAddress = B.getCurrentPlayAddress();
            if (currentPlayAddress != null && currentPlayAddress.cacheKey.equals(playEngineInfo.playAddress.cacheKey)) {
                this.a.d("This chapter is playing! audioPlayInfo = " + playEngineInfo, new Object[0]);
                return;
            }
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (fVar = bVar.o) != null && fVar.i()) {
                Iterator it2 = new LinkedHashMap(this.b).entrySet().iterator();
                while (it2.hasNext()) {
                    PlayEngineInfo playEngineInfo2 = (PlayEngineInfo) ((Map.Entry) it2.next()).getKey();
                    if (playEngineInfo2.playAddress.cacheKey.equals(playEngineInfo.playAddress.cacheKey) && playEngineInfo2.isSameWith(playEngineInfo)) {
                        this.a.d("This chapter has already prepared! audioPlayInfo = " + playEngineInfo, new Object[0]);
                        return;
                    }
                }
            }
            if (this.b.size() >= this.f && (peek = this.d.peek()) != null) {
                m(peek);
            }
            com.xs.fm.player.sdk.play.player.audio.engine.g a2 = this.g.a(0, Integer.valueOf(playEngineInfo.genreType));
            if (!(a2 instanceof tk6.a)) {
                return;
            }
            ((tk6.a) a2).a(false);
            TextureView textureView = new TextureView(context);
            textureView.setSurfaceTextureListener(new a(playEngineInfo, a2));
            this.c.put(playEngineInfo, new WeakReference<>(textureView));
            viewGroup.addView(textureView, new ViewGroup.LayoutParams(0, 0));
        }
    }

    public static final class a implements TextureView.SurfaceTextureListener {
        final /* synthetic */ PlayEngineInfo b;
        final /* synthetic */ com.xs.fm.player.sdk.play.player.audio.engine.g c;

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

        a(PlayEngineInfo playEngineInfo, com.xs.fm.player.sdk.play.player.audio.engine.g gVar) {
            this.b = playEngineInfo;
            this.c = gVar;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            View view;
            String str;
            WeakReference weakReference = (WeakReference) c.this.c.get(this.b);
            if (weakReference != null) {
                view = (View) weakReference.get();
            } else {
                view = null;
            }
            if (view == null) {
                return;
            }
            c.this.d.offer(this.b);
            c.this.b.put(this.b, this.c);
            PlayAddress playAddress = this.b.playAddress;
            if (playAddress != null && (str = playAddress.cacheKey) != null) {
                c.this.e.add(str);
            }
            ((tk6.a) this.c).setSurface(new Surface(surfaceTexture));
            this.c.K(this.b);
            ml6.a.g.a("AudioPrepareManagerImpl prepare end success: item = " + this.b.itemId + ", map = " + c.this.b.size());
            bl6.a aVar = c.this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("prepare end. map size is ");
            sb.append(c.this.b.size());
            aVar.d(sb.toString(), new Object[0]);
        }
    }
}
