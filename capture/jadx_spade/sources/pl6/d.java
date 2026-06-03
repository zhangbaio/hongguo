package pl6;

import al2.i0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsXrayApi;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import com.ss.ttvideoengine.PreloaderVideoModelItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoModel;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AbsPlayList;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.inter.IPlayManager;
import com.xs.fm.player.base.play.player.IPlayer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.ImplementedInterface;
import me.ele.lancet.base.annotations.Insert;
import pl6.c;
import xk6.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d extends vk6.a {
    public volatile boolean c;
    public volatile boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    private final HashSet<String> k;
    private pk6.c l;
    private final int a = 100;
    private final bl6.a b = new bl6.a("FMSDKPlayerPreload-DefaultPreloadStrategy");
    public CopyOnWriteArrayList<g> i = new CopyOnWriteArrayList<>();
    public int j = 1;

    static {
        Covode.recordClassIndex(655966);
    }

    protected void B(vk6.c cVar) {
        throw null;
    }

    protected void i(vk6.c cVar, PreloaderVideoModelItem preloaderVideoModelItem, PlayAddress playAddress) {
    }

    protected void l(boolean z, vk6.c cVar, int i) {
    }

    public int r() {
        throw null;
    }

    public String s() {
        return "default";
    }

    protected boolean v() {
        return true;
    }

    protected void x(VideoModel videoModel, Resolution resolution, vk6.c cVar) {
    }

    protected void y(PlayEngineInfo playEngineInfo) {
    }

    public bl6.a p() {
        return this.b;
    }

    private final void A() {
        pl6.c.c.b(new c());
    }

    private final void z() {
        xk6.a.g().e(new b());
    }

    @Override // xk6.a.b
    public void onEnterBackground() {
        p().d("onEnterBackground", new Object[0]);
        this.j = 0;
    }

    @Override // xk6.a.b
    public void onEnterForeground() {
        p().d("onEnterForeground", new Object[0]);
        this.j = 1;
    }

    public static final class b implements a.b {
        b() {
        }

        @Override // xk6.a.b
        public void onEnterBackground() {
            vk6.a p;
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            qk6.a currentStrategy = B.getCurrentStrategy();
            if (currentStrategy != null && (p = currentStrategy.p()) != null) {
                p.onEnterBackground();
            }
        }

        @Override // xk6.a.b
        public void onEnterForeground() {
            vk6.a p;
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            qk6.a currentStrategy = B.getCurrentStrategy();
            if (currentStrategy != null && (p = currentStrategy.p()) != null) {
                p.onEnterForeground();
            }
        }
    }

    /* renamed from: pl6.d$d, reason: collision with other inner class name */
    public static final class C0254d extends vk6.d {
        final /* synthetic */ g a;
        final /* synthetic */ d b;
        final /* synthetic */ pk6.c c;
        final /* synthetic */ vk6.c d;

        @Override // vk6.b
        public void f() {
            this.b.p().d("onAllFinish", new Object[0]);
            this.b.B(this.a.k);
        }

        @Override // vk6.b
        public void onStart() {
            this.b.p().d("onStart", new Object[0]);
            this.b.c = true;
        }

        @Override // vk6.b
        public void b(boolean z) {
            this.b.p().d("onRetry, startOrEnd = " + z, new Object[0]);
            this.b.d = z;
        }

        @Override // vk6.b
        public void d(PlayAddress playAddress) {
            VideoModel videoModel;
            this.b.p().d("onVideoModelRequestFinish", new Object[0]);
            d dVar = this.b;
            if (playAddress != null) {
                videoModel = playAddress.videoModel;
            } else {
                videoModel = null;
            }
            dVar.x(videoModel, null, this.d);
            this.b.c = false;
        }

        @Override // vk6.b
        public boolean e(vk6.c cVar) {
            int i;
            this.b.p().d("isValidToPreload", new Object[0]);
            d dVar = this.b;
            CopyOnWriteArrayList<g> copyOnWriteArrayList = dVar.i;
            if (copyOnWriteArrayList != null) {
                i = copyOnWriteArrayList.size();
            } else {
                i = 0;
            }
            return vk6.a.h(dVar, i, h.b(this.c), 0, 4, null);
        }

        @Override // vk6.b
        public void g(PreLoaderItemCallBackInfo preLoaderItemCallBackInfo) {
            this.b.p().d("onMdlCallback key=" + preLoaderItemCallBackInfo.getKey(), new Object[0]);
        }

        @Override // vk6.b
        public void a(int i, String str) {
            this.b.p().b("onPlayInfoRequestFailed, errCode = " + i, new Object[0]);
        }

        @Override // vk6.d, vk6.b
        public void c(vk6.c cVar, PreloaderVideoModelItem preloaderVideoModelItem, PlayAddress playAddress) {
            this.b.i(cVar, preloaderVideoModelItem, playAddress);
        }

        C0254d(g gVar, d dVar, pk6.c cVar, vk6.c cVar2) {
            this.a = gVar;
            this.b = dVar;
            this.c = cVar;
            this.d = cVar2;
        }
    }

    @Override // pl6.e
    public void d() {
        h.g();
        p().d("tryCancelPreloadTask with video engine", new Object[0]);
        this.c = false;
        TTVideoEngine.cancelAllPreloadTasks();
        h.a();
        m();
    }

    protected void m() {
        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            Iterator<T> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                ((g) it2.next()).r();
            }
            copyOnWriteArrayList.clear();
        }
    }

    public d() {
        A();
        z();
        this.k = new HashSet<>();
    }

    private final void u() {
        boolean z;
        int i;
        int i2;
        String g;
        boolean b2;
        nk6.f fVar;
        nk6.f fVar2;
        nk6.f fVar3;
        nk6.f fVar4;
        nk6.f fVar5;
        Integer num;
        String str;
        lk6.b bVar = lk6.c.a;
        Integer num2 = null;
        if (bVar != null && (fVar5 = bVar.o) != null) {
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            AbsPlayList currentList = B.getCurrentList();
            if (currentList != null) {
                num = Integer.valueOf(currentList.getGenreType());
            } else {
                num = null;
            }
            IPlayManager B2 = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B2, "PlayManager.getInstance()");
            PlayAddress currentPlayAddress = B2.getCurrentPlayAddress();
            if (currentPlayAddress != null) {
                str = currentPlayAddress.tag;
            } else {
                str = null;
            }
            z = fVar5.j(num, str);
        } else {
            z = false;
        }
        if (z) {
            int i3 = this.h;
            lk6.b bVar2 = lk6.c.a;
            if (bVar2 != null && (fVar4 = bVar2.o) != null) {
                i = fVar4.b();
            } else {
                i = 300;
            }
            if (i3 >= i * 1000) {
                int i4 = this.h - this.g;
                lk6.b bVar3 = lk6.c.a;
                if (bVar3 != null && (fVar3 = bVar3.o) != null) {
                    i2 = fVar3.r();
                } else {
                    i2 = 0;
                }
                if (i4 < i2 * 1000) {
                    pk6.c cVar = this.l;
                    if (cVar != null) {
                        HashSet<String> hashSet = this.k;
                        if (cVar == null) {
                            Intrinsics.throwNpe();
                        }
                        if (hashSet.contains(h.b(cVar))) {
                            return;
                        }
                    }
                    bl6.a p = p();
                    StringBuilder sb = new StringBuilder();
                    sb.append("handlePlayCompletePrepareOpt: enableAudioCompletePrepareOpt = ");
                    sb.append(z);
                    sb.append(", getPlayCompletePrepareInterval() = ");
                    lk6.b bVar4 = lk6.c.a;
                    if (bVar4 != null && (fVar2 = bVar4.o) != null) {
                        num2 = Integer.valueOf(fVar2.r());
                    }
                    sb.append(num2);
                    p.d(sb.toString(), new Object[0]);
                    IPlayManager B3 = il6.a.B();
                    Intrinsics.checkExpressionValueIsNotNull(B3, "PlayManager.getInstance()");
                    AbsPlayList currentList2 = B3.getCurrentList();
                    if (currentList2 != null) {
                        IPlayManager B4 = il6.a.B();
                        Intrinsics.checkExpressionValueIsNotNull(B4, "PlayManager.getInstance()");
                        String currentItemId = B4.getCurrentItemId();
                        if (currentItemId != null) {
                            IPlayManager B5 = il6.a.B();
                            Intrinsics.checkExpressionValueIsNotNull(B5, "PlayManager.getInstance()");
                            qk6.a currentStrategy = B5.getCurrentStrategy();
                            if (currentStrategy != null && (g = currentStrategy.g(currentList2, currentItemId)) != null) {
                                Intrinsics.checkExpressionValueIsNotNull(g, "playStrategy.getNextItem…t, currentItem) ?: return");
                                pk6.c l = currentStrategy.l(currentList2, g);
                                if (l != null) {
                                    Intrinsics.checkExpressionValueIsNotNull(l, "playStrategy.getPlayPara…List, nextItem) ?: return");
                                    jl6.a aVar = jl6.a.g;
                                    PlayAddress o = aVar.o(h.b(l), Integer.valueOf(currentList2.getGenreType()));
                                    this.l = l;
                                    this.k.add(h.b(l));
                                    p().d("handlePlayCompletePrepareOpt: playAddressCache = " + o + ", nextPlayParam = " + l, new Object[0]);
                                    if (o == null) {
                                        b2 = false;
                                    } else {
                                        b2 = ql6.b.b.b(vl6.b.a(l, o));
                                    }
                                    p().d("handlePlayCompletePrepareOpt: nextItemIsPrepared=" + b2, new Object[0]);
                                    if (o != null && b2 && ((fVar = lk6.c.a.o) == null || !fVar.o(Integer.valueOf(currentList2.getGenreType())))) {
                                        p().d("handlePlayCompletePrepareOpt: next item has prepared", new Object[0]);
                                        return;
                                    }
                                    AbsPlayList absPlayList = l.a;
                                    Intrinsics.checkExpressionValueIsNotNull(absPlayList, "nextPlayParam.playList");
                                    String str2 = l.b;
                                    Intrinsics.checkExpressionValueIsNotNull(str2, "nextPlayParam.playItem");
                                    String str3 = l.k;
                                    Intrinsics.checkExpressionValueIsNotNull(str3, "nextPlayParam.playFrom");
                                    aVar.g(h.b(l), new jl6.d(absPlayList, str2, str3, l.c, l.e, true, true, false, "preload_on_play_complete_prepare_opt"), new a(z, l));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected void C() {
        String g;
        int i;
        int i2;
        Integer num;
        int i3;
        IPlayManager B = il6.a.B();
        Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
        AbsPlayList currentList = B.getCurrentList();
        if (currentList != null) {
            IPlayManager B2 = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B2, "PlayManager.getInstance()");
            String currentItemId = B2.getCurrentItemId();
            if (currentItemId != null) {
                IPlayManager B3 = il6.a.B();
                Intrinsics.checkExpressionValueIsNotNull(B3, "PlayManager.getInstance()");
                qk6.a currentStrategy = B3.getCurrentStrategy();
                if (currentStrategy != null && (g = currentStrategy.g(currentList, currentItemId)) != null) {
                    Intrinsics.checkExpressionValueIsNotNull(g, "playStrategy.getNextItem…t, currentItem) ?: return");
                    pk6.c l = currentStrategy.l(currentList, g);
                    if (l != null) {
                        Intrinsics.checkExpressionValueIsNotNull(l, "playStrategy.getPlayPara…List, nextItem) ?: return");
                        CopyOnWriteArrayList<g> copyOnWriteArrayList = this.i;
                        if (copyOnWriteArrayList != null) {
                            i = copyOnWriteArrayList.size();
                        } else {
                            i = 0;
                        }
                        String b2 = h.b(l);
                        AbsPlayList absPlayList = l.a;
                        if (absPlayList != null) {
                            i2 = absPlayList.getGenreType();
                        } else {
                            i2 = 0;
                        }
                        boolean g2 = g(i, b2, i2);
                        bl6.a p = p();
                        StringBuilder sb = new StringBuilder();
                        sb.append("tryPreloadNextItem: canPreloadTask = ");
                        sb.append(g2);
                        sb.append(", continuousPreloadTaskList?.size = ");
                        CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.i;
                        Integer num2 = null;
                        if (copyOnWriteArrayList2 != null) {
                            num = Integer.valueOf(copyOnWriteArrayList2.size());
                        } else {
                            num = null;
                        }
                        sb.append(num);
                        sb.append(", genreType = ");
                        AbsPlayList absPlayList2 = l.a;
                        if (absPlayList2 != null) {
                            num2 = Integer.valueOf(absPlayList2.getGenreType());
                        }
                        sb.append(num2);
                        p.d(sb.toString(), new Object[0]);
                        if (!g2) {
                            return;
                        }
                        if (h.d(h.b(l))) {
                            p().d("tryPreloadNextItem: isPreloaded return", new Object[0]);
                            return;
                        }
                        vk6.c cVar = new vk6.c(l);
                        cVar.b(s());
                        cVar.b = true;
                        cVar.c = lk6.c.a.o.a();
                        cVar.f = false;
                        cVar.g = h.b(l);
                        if (cVar.h <= 0) {
                            cVar.h = lk6.c.a.n.J();
                        }
                        AbsPlayList absPlayList3 = l.a;
                        if (absPlayList3 != null) {
                            i3 = absPlayList3.getGenreType();
                        } else {
                            i3 = 0;
                        }
                        l(true, cVar, i3);
                        g gVar = new g(cVar);
                        gVar.i = new C0254d(gVar, this, l, cVar);
                        p().d("tryPreloadNextItem: start task currentItem = " + currentItemId + ", nextItem = " + g, new Object[0]);
                        gVar.x();
                        CopyOnWriteArrayList<g> copyOnWriteArrayList3 = this.i;
                        if (copyOnWriteArrayList3 != null) {
                            copyOnWriteArrayList3.add(gVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onBufferingUpdate(int i) {
        nk6.e eVar;
        this.f = i;
        p().d("onBufferingUpdate, bufferPercent = " + this.f, new Object[0]);
        lk6.b bVar = lk6.c.a;
        if (bVar != null && (eVar = bVar.n) != null && eVar.z()) {
            C();
        }
        super.onBufferingUpdate(i);
    }

    public static final class c implements c.b {
        c() {
        }

        @Override // pl6.c.b
        public void a(int i, int i2) {
            vk6.a p;
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            qk6.a currentStrategy = B.getCurrentStrategy();
            if (currentStrategy != null && (p = currentStrategy.p()) != null) {
                p.a(i, i2);
            }
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onItemChanged(String str, String str2) {
        this.e = 0;
        this.f = 0;
        p().d("onItemChanged tryCancelPreloadTask", new Object[0]);
        this.k.clear();
        this.l = null;
        d();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onListChanged(pk6.b bVar, pk6.b bVar2) {
        p().d("onListChanged tryCancelPreloadTask", new Object[0]);
        this.f = 0;
        d();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayStateChange(IPlayer iPlayer, int i) {
        if (i == 103) {
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            this.e = B.getCurrentProgress();
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onToneChanged(int i, int i2) {
        p().d("onToneChanged tryCancelPreloadTask", new Object[0]);
        this.f = 0;
        d();
    }

    public static final class a implements ok6.c {
        final /* synthetic */ boolean b;
        final /* synthetic */ pk6.c c;

        @Override // ok6.c
        public void a(int i, String str, jl6.d dVar) {
            e(this, i, str, dVar);
        }

        @Override // ok6.c
        public void b(PlayAddress playAddress, jl6.d dVar) {
            f(this, playAddress, dVar);
        }

        public void d(PlayAddress playAddress, jl6.d dVar) {
            boolean z;
            if (this.b) {
                PlayEngineInfo a = vl6.b.a(this.c, playAddress);
                nk6.f fVar = lk6.c.a.o;
                if (fVar != null) {
                    AbsPlayList absPlayList = this.c.a;
                    Intrinsics.checkExpressionValueIsNotNull(absPlayList, "nextPlayParam.playList");
                    if (fVar.q(Integer.valueOf(absPlayList.getGenreType()))) {
                        d.this.p().d("handlePlayCompletePrepareOpt: success, playAddress and tryPrepare next video, onVideoPlayCompletePrepareOpt", new Object[0]);
                        d.this.y(a);
                        return;
                    }
                }
                nk6.f fVar2 = lk6.c.a.o;
                if (fVar2 != null) {
                    z = fVar2.g();
                } else {
                    z = false;
                }
                d.this.p().d("handlePlayCompletePrepareOpt: success, playAddress and tryPrepare again, enableAudioCompletePrepareOpt=true, enableAudioDevicePrepare = " + z, new Object[0]);
                a.enableAudioDevicePrepare = z;
                ql6.b.b.a(a);
            }
        }

        a(boolean z, pk6.c cVar) {
            this.b = z;
            this.c = cVar;
        }

        @Insert("success")
        @ImplementedInterface(scope = Scope.ALL, value = {"com.xs.fm.player.base.play.address.PlayAddressCacheCallBack"})
        public static void f(a aVar, PlayAddress playAddress, jl6.d dVar) {
            NsXrayApi nsXrayApi = NsXrayApi.IMPL;
            if (nsXrayApi.enable()) {
                i0.a.i("播放地址获取成功, playAddress = " + playAddress + ", req = " + dVar, new Object[0]);
                v03.g gVar = new v03.g();
                i0.h(gVar, dVar);
                i0.l(gVar, playAddress);
                nsXrayApi.sendEvent("播放地址请求成功", gVar);
            }
            aVar.d(playAddress, dVar);
        }

        public void c(int i, String str, jl6.d dVar) {
            d.this.p().b("handlePlayCompletePrepareOpt: fail, code = " + i + ", errorMsg = " + str, new Object[0]);
        }

        @Insert("fail")
        @ImplementedInterface(scope = Scope.ALL, value = {"com.xs.fm.player.base.play.address.PlayAddressCacheCallBack"})
        public static void e(a aVar, int i, String str, jl6.d dVar) {
            if (NsXrayApi.IMPL.enable()) {
                i0.a.e("播放地址获取失败(" + str + "," + dVar + ")", new Object[0]);
            }
            aVar.c(i, str, dVar);
        }
    }

    @Override // pl6.c.b
    public void a(int i, int i2) {
        int i3;
        boolean z;
        p().d("network changed, from = " + i + " and to = " + i2, new Object[0]);
        pl6.a aVar = pl6.a.a;
        if (aVar.b()) {
            if (i == 0 && i != i2) {
                if (r() > 1) {
                    CopyOnWriteArrayList<g> copyOnWriteArrayList = this.i;
                    if (copyOnWriteArrayList != null) {
                        i3 = copyOnWriteArrayList.size();
                    } else {
                        i3 = 0;
                    }
                    if (i3 > 1) {
                        CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.i;
                        if (copyOnWriteArrayList2 != null) {
                            Iterator<T> it2 = copyOnWriteArrayList2.iterator();
                            z = false;
                            while (it2.hasNext()) {
                                if (((g) it2.next()).k.f) {
                                    z = true;
                                }
                            }
                        } else {
                            z = false;
                        }
                        p().d("net from WIFI to other, hasNetChangeTask = " + z, new Object[0]);
                        if (z) {
                            d();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (i2 == 0 && i != i2) {
                C();
                return;
            }
            return;
        }
        if (aVar.c()) {
            if (i2 == 1 && i != i2) {
                p().d("onNetChanged tryCancelPreloadTask: WiFi 切 4G，暂停所有播放器的预加载任务 ", new Object[0]);
                d();
            } else if (i2 == 0 && i != i2) {
                p().d("onNetChanged tryPreloadNextItem: 断网 or 4g 切 WiFi，尝试开始预加载", new Object[0]);
                C();
            }
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayProgressChanged(IPlayer iPlayer, int i, int i2) {
        nk6.e eVar;
        this.g = i;
        this.h = i2;
        lk6.b bVar = lk6.c.a;
        if (bVar == null || (eVar = bVar.n) == null || !eVar.C()) {
            C();
        }
        u();
    }

    protected boolean w(int i, int i2, int i3) {
        nk6.e eVar;
        int i4;
        lk6.b bVar = lk6.c.a;
        if ((bVar != null && (eVar = bVar.n) != null && eVar.z() && ((i4 = this.f) >= this.a || lk6.c.a.s.i(i2, i3, i4))) || lk6.c.a.n.g(this.f)) {
            return true;
        }
        if (i2 - Math.max(lk6.c.a.n.q(), Math.min(lk6.c.a.n.e(), (i3 - i) / 2)) >= i) {
            return true;
        }
        return false;
    }

    @Override // vk6.a
    public boolean g(int i, String str, int i2) {
        if (this.c) {
            p().d("canPreloadTask: isLoading = " + this.c, new Object[0]);
            return false;
        }
        if (this.d) {
            p().d("canPreloadTask: isRetrying = " + this.d, new Object[0]);
            return false;
        }
        IPlayManager B = il6.a.B();
        Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
        if (B.getPlayState() != 103 && v()) {
            bl6.a p = p();
            StringBuilder sb = new StringBuilder();
            sb.append("canPreloadTask: playState is ");
            IPlayManager B2 = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B2, "PlayManager.getInstance()");
            sb.append(B2.getPlayState());
            p.d(sb.toString(), new Object[0]);
            return false;
        }
        if (!w(this.e, this.g, this.h)) {
            p().d("canPreloadTask: progress invalid, startTime = " + this.e + ", progress = " + this.g + ", duration = " + this.h, new Object[0]);
            return false;
        }
        TTNetWorkListener tTNetWorkListener = TTNetWorkListener.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(tTNetWorkListener, "TTNetWorkListener.getInstance()");
        if (tTNetWorkListener.getCurrentAccessType() != -1) {
            TTNetWorkListener tTNetWorkListener2 = TTNetWorkListener.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(tTNetWorkListener2, "TTNetWorkListener.getInstance()");
            if (tTNetWorkListener2.getCurrentAccessType() != 1000) {
                if (pl6.a.a.c()) {
                    TTNetWorkListener tTNetWorkListener3 = TTNetWorkListener.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(tTNetWorkListener3, "TTNetWorkListener.getInstance()");
                    if (tTNetWorkListener3.getCurrentAccessType() == 1) {
                        p().d("canPreloadTask: network type is 4G", new Object[0]);
                        return false;
                    }
                }
                return true;
            }
        }
        p().d("canPreloadTask: network type unknown", new Object[0]);
        return false;
    }
}
