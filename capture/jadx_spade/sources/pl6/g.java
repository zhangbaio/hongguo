package pl6;

import al2.i0;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsXrayApi;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import com.ss.ttvideoengine.PreloaderFilePathListener;
import com.ss.ttvideoengine.PreloaderVideoModelItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AbsPlayList;
import java.util.ArrayList;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.ImplementedInterface;
import me.ele.lancet.base.annotations.Insert;
import pl6.c;
import ul6.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g {
    private final bl6.a a = new bl6.a("FMSDKPlayerPreload-PreloadTask");
    private volatile boolean b;
    private volatile boolean c;
    private CountDownTimer d;
    private volatile int e;
    private boolean f;
    private int g;
    private Runnable h;
    public vk6.b i;
    private c.b j;
    public final vk6.c k;

    static {
        Covode.recordClassIndex(655970);
    }

    static final class b implements IPreLoaderItemCallBackListener {
        final /* synthetic */ vk6.c b;
        final /* synthetic */ PlayAddress c;
        final /* synthetic */ PreloaderVideoModelItem d;

        b(vk6.c cVar, PlayAddress playAddress, PreloaderVideoModelItem preloaderVideoModelItem) {
            this.b = cVar;
            this.c = playAddress;
            this.d = preloaderVideoModelItem;
        }

        /* renamed from: pl6.g$b$b, reason: collision with other inner class name */
        static final class RunnableC0255b implements Runnable {
            RunnableC0255b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                xk6.g.k(new a());
            }

            /* renamed from: pl6.g$b$b$a */
            static final class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b bVar = b.this;
                    if (bVar.b.c) {
                        g.this.a.d("addEnginePreloadTask: preloadItemInfo success, start prepare item = " + b.this.b.n.b, new Object[0]);
                        b bVar2 = b.this;
                        vk6.c cVar = bVar2.b;
                        if (!cVar.d) {
                            if (cVar.e) {
                                g.this.a.d("addEnginePreloadTask: preloadItemInfo success, start VideoPrepareManager prepareVideoWithSurface item = " + b.this.b.n.b + ", preloadInfo.context = " + b.this.b.getContext(), new Object[0]);
                                Context context = b.this.b.getContext();
                                if (context != null) {
                                    ul6.c cVar2 = ul6.c.b;
                                    b bVar3 = b.this;
                                    a.C0275a.a(cVar2, context, vl6.b.a(bVar3.b.n, bVar3.c), null, 4, null);
                                }
                            } else {
                                g.this.a.d("addEnginePreloadTask: preloadItemInfo success, start AudioPrepareManager prepare item = " + b.this.b.n.b, new Object[0]);
                                ql6.b bVar4 = ql6.b.b;
                                b bVar5 = b.this;
                                bVar4.a(vl6.b.a(bVar5.b.n, bVar5.c));
                            }
                        } else {
                            g.this.a.d("addEnginePreloadTask: preloadItemInfo success, start AudioPrepareManager prepareWithSurface item = " + b.this.b.n.b + ", preloadInfo.context = " + b.this.b.getContext(), new Object[0]);
                            Context context2 = b.this.b.getContext();
                            if (context2 != null) {
                                ql6.b bVar6 = ql6.b.b;
                                b bVar7 = b.this;
                                bVar6.d(context2, vl6.b.a(bVar7.b.n, bVar7.c));
                            }
                        }
                    }
                    vk6.b bVar8 = g.this.i;
                    if (bVar8 != null) {
                        bVar8.f();
                    }
                }
            }
        }

        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                lk6.b bVar;
                nk6.f fVar;
                if (!b.this.b.c || (bVar = lk6.c.a) == null || (fVar = bVar.o) == null || !fVar.h()) {
                    return;
                }
                g.this.a.d("addEnginePreloadTask: preloadItemInfo fail, and need prepare, start prepare item = " + b.this.b.n.b, new Object[0]);
                ql6.b bVar2 = ql6.b.b;
                b bVar3 = b.this;
                bVar2.a(vl6.b.a(bVar3.b.n, bVar3.c));
            }
        }

        @Override // com.ss.ttvideoengine.IPreLoaderItemCallBackListener
        public final void preloadItemInfo(PreLoaderItemCallBackInfo info) {
            Integer num;
            Integer num2;
            String str;
            String str2;
            Integer num3;
            Integer num4;
            Error error;
            pk6.c cVar;
            pk6.c cVar2;
            int i;
            String str3;
            bl6.a aVar = g.this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("addEnginePreloadTask: IPreLoaderItemCallBackListener, preloadItemInfo info.key = ");
            Integer num5 = null;
            r2 = null;
            String str4 = null;
            if (info != null) {
                num = Integer.valueOf(info.getKey());
            } else {
                num = null;
            }
            sb.append(num);
            aVar.d(sb.toString(), new Object[0]);
            vk6.b bVar = g.this.i;
            if (bVar != null) {
                Intrinsics.checkExpressionValueIsNotNull(info, "info");
                bVar.g(info);
            }
            if (info != null) {
                num2 = Integer.valueOf(info.getKey());
            } else {
                num2 = null;
            }
            if (num2 != null && num2.intValue() == 2) {
                if (g.this.f) {
                    g.this.a.d("hadCallback=" + g.this.f + " return", new Object[0]);
                    return;
                }
                g.this.f = true;
                g.this.s();
                g.this.t();
                pl6.b.d(this.b.j, g.this.g, true);
                pk6.c cVar3 = this.b.n;
                if (cVar3 != null) {
                    String str5 = cVar3.b;
                    Long valueOf = Long.valueOf(cVar3.c);
                    AbsPlayList absPlayList = cVar3.a;
                    if (absPlayList != null) {
                        i = absPlayList.getGenreType();
                    } else {
                        i = 0;
                    }
                    AbsPlayList absPlayList2 = cVar3.a;
                    if (absPlayList2 != null) {
                        str3 = absPlayList2.getListId();
                    } else {
                        str3 = null;
                    }
                    pl6.b.c(str5, valueOf, i, str3, this.b.j);
                }
                bl6.a aVar2 = g.this.a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("addEnginePreloadTask: preloadItemInfo success! itemid = ");
                vk6.c cVar4 = this.b;
                if (cVar4 != null && (cVar2 = cVar4.n) != null) {
                    str4 = cVar2.b;
                }
                sb2.append(str4);
                aVar2.d(sb2.toString(), new Object[0]);
                RunnableC0255b runnableC0255b = new RunnableC0255b();
                nk6.e eVar = lk6.c.a.n;
                if (eVar != null && !eVar.o(runnableC0255b)) {
                    runnableC0255b.run();
                    return;
                }
                return;
            }
            if (num2 != null && num2.intValue() == 3) {
                g.this.s();
                bl6.a aVar3 = g.this.a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("addEnginePreloadTask: preloadItemInfo fail! itemid = ");
                vk6.c cVar5 = this.b;
                if (cVar5 != null && (cVar = cVar5.n) != null) {
                    str = cVar.b;
                } else {
                    str = null;
                }
                sb3.append(str);
                sb3.append(", errorMsg=");
                if (info != null && (error = info.preloadError) != null) {
                    str2 = error.toString();
                } else {
                    str2 = null;
                }
                sb3.append(str2);
                aVar3.b(sb3.toString(), new Object[0]);
                Error error2 = info.preloadError;
                if (error2 != null) {
                    num3 = Integer.valueOf(error2.code);
                } else {
                    num3 = null;
                }
                String valueOf2 = String.valueOf(num3);
                vk6.c cVar6 = this.b;
                long j = cVar6.h;
                pk6.c cVar7 = cVar6.n;
                String str6 = cVar7.b;
                AbsPlayList absPlayList3 = cVar7.a;
                Intrinsics.checkExpressionValueIsNotNull(absPlayList3, "preloadInfo.playParam.playList");
                String listId = absPlayList3.getListId();
                pk6.c cVar8 = this.b.n;
                long j2 = cVar8.c;
                AbsPlayList absPlayList4 = cVar8.a;
                Intrinsics.checkExpressionValueIsNotNull(absPlayList4, "preloadInfo.playParam.playList");
                pl6.b.b(valueOf2, j, str6, listId, j2, absPlayList4.getGenreType(), this.b.j);
                xk6.g.k(new a());
                if (lk6.c.a.s.e() && !lk6.c.a.s.h(new Triple<>("20:00", "23:00", 0))) {
                    Error error3 = info.preloadError;
                    if (error3 != null) {
                        num4 = Integer.valueOf(error3.code);
                    } else {
                        num4 = null;
                    }
                    if (!TextUtils.equals(String.valueOf(num4), "-3000")) {
                        Error error4 = info.preloadError;
                        if (error4 != null) {
                            num5 = Integer.valueOf(error4.code);
                        }
                        if (!TextUtils.equals(String.valueOf(num5), "-1003")) {
                            g.this.v(this.b, this.d);
                            return;
                        }
                    }
                    g.this.u(this.b, this.d);
                    return;
                }
                return;
            }
            if (num2 != null && num2.intValue() == 5) {
                g.this.a.d("preloadItemInfo cancel", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        xk6.g.i(this.h);
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        c.b bVar = this.j;
        if (bVar != null) {
            pl6.c cVar = pl6.c.c;
            if (bVar == null) {
                Intrinsics.throwNpe();
            }
            cVar.c(bVar);
        }
    }

    public final void r() {
        this.b = true;
        y();
        s();
        t();
    }

    static final class d implements Runnable {
        final /* synthetic */ vk6.c b;
        final /* synthetic */ PreloaderVideoModelItem c;

        d(vk6.c cVar, PreloaderVideoModelItem preloaderVideoModelItem) {
            this.b = cVar;
            this.c = preloaderVideoModelItem;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!StringsKt__StringsJVMKt.endsWith$default(this.b.j, "_retry", false, 2, null)) {
                this.b.b(this.b.j + "_retry");
            }
            TTVideoEngine.addTask(this.c);
            g.this.g++;
        }
    }

    public static final class e extends CountDownTimer {
        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            g.this.a.d("startRetryGetVideoModel: retry task run!", new Object[0]);
            g.this.c = false;
            vk6.b bVar = g.this.i;
            if (bVar != null) {
                bVar.b(false);
            }
            g gVar = g.this;
            vk6.b bVar2 = gVar.i;
            if (bVar2 != null) {
                if (bVar2.e(gVar.k)) {
                    g.this.x();
                    return;
                } else {
                    g.this.w();
                    return;
                }
            }
            gVar.x();
        }

        e(long j, long j2) {
            super(j, j2);
        }
    }

    private final void y() {
        this.a.d("stopRetry, countDownTimer = " + this.d, new Object[0]);
        this.e = 0;
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.d = null;
        this.c = false;
        vk6.b bVar = this.i;
        if (bVar != null) {
            bVar.b(false);
        }
    }

    public static final class c implements c.b {
        final /* synthetic */ vk6.c b;
        final /* synthetic */ PreloaderVideoModelItem c;

        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (!StringsKt__StringsJVMKt.endsWith$default(c.this.b.j, "_retry", false, 2, null)) {
                    c.this.b.b(c.this.b.j + "_retry");
                }
                TTVideoEngine.addTask(c.this.c);
                g.this.g++;
            }
        }

        @Override // pl6.c.b
        public void a(int i, int i2) {
            if (g.this.q(i2)) {
                g.this.h = new a();
                Runnable runnable = g.this.h;
                if (runnable == null) {
                    Intrinsics.throwNpe();
                }
                xk6.g.g(runnable);
            }
        }

        c(vk6.c cVar, PreloaderVideoModelItem preloaderVideoModelItem) {
            this.b = cVar;
            this.c = preloaderVideoModelItem;
        }
    }

    public final void x() {
        if (this.b) {
            this.a.d("startTask: canceled, return", new Object[0]);
            return;
        }
        this.a.d("startPreloadTask, item = " + this.k.n.b, new Object[0]);
        vk6.b bVar = this.i;
        if (bVar != null) {
            bVar.onStart();
        }
        vk6.c cVar = this.k;
        pk6.c cVar2 = cVar.n;
        if (cVar2.a == null) {
            return;
        }
        jl6.a aVar = jl6.a.g;
        String str = cVar.g;
        AbsPlayList absPlayList = cVar2.a;
        Intrinsics.checkExpressionValueIsNotNull(absPlayList, "playParam.playList");
        String str2 = cVar2.b;
        Intrinsics.checkExpressionValueIsNotNull(str2, "playParam.playItem");
        String str3 = cVar2.k;
        Intrinsics.checkExpressionValueIsNotNull(str3, "playParam.playFrom");
        aVar.g(str, new jl6.d(absPlayList, str2, str3, cVar2.c, cVar2.e, true, false, false, this.k.j, 192, null), new f(cVar2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        if (this.c) {
            return;
        }
        this.a.d("startRetryGetVideoModel: start, retryCount=" + this.e, new Object[0]);
        this.c = true;
        if (this.e >= lk6.c.a.n.b()) {
            this.a.d("startRetryGetVideoModel: more than retry count", new Object[0]);
            return;
        }
        this.e++;
        vk6.b bVar = this.i;
        if (bVar != null) {
            bVar.b(true);
        }
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        e eVar = new e(lk6.c.a.n.y(), lk6.c.a.n.y());
        this.d = eVar;
        eVar.start();
        this.a.d("countDownTimer?.start(), countDownTimer = " + this.d, new Object[0]);
    }

    public g(vk6.c cVar) {
        this.k = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(int i) {
        boolean z = this.k.f;
        if (z && i == 0) {
            return true;
        }
        if (!z) {
            if (i == 0 || i == 4 || i == 1) {
                return true;
            }
            return false;
        }
        return false;
    }

    static final class a implements PreloaderFilePathListener {
        final /* synthetic */ PlayAddress a;

        a(PlayAddress playAddress) {
            this.a = playAddress;
        }

        @Override // com.ss.ttvideoengine.PreloaderFilePathListener
        public final String cacheFilePath(String str, VideoInfo videoInfo) {
            return this.a.mdlCachePath;
        }
    }

    public static final class f implements ok6.c {
        final /* synthetic */ pk6.c b;

        @Override // ok6.c
        public void a(int i, String str, jl6.d dVar) {
            e(this, i, str, dVar);
        }

        @Override // ok6.c
        public void b(PlayAddress playAddress, jl6.d dVar) {
            f(this, playAddress, dVar);
        }

        f(pk6.c cVar) {
            this.b = cVar;
        }

        public void d(PlayAddress playAddress, jl6.d dVar) {
            String str;
            vk6.b bVar = g.this.i;
            if (bVar != null) {
                bVar.d(playAddress);
            }
            int i = 0;
            if (playAddress != null) {
                g gVar = g.this;
                if (!gVar.k.m) {
                    gVar.a.d("startTask: tryPreloadItem, GetPlayAddressCallBack success, playParam = " + this.b + ", playAddress = " + playAddress, new Object[0]);
                    g gVar2 = g.this;
                    gVar2.p(gVar2.k, playAddress);
                    if (!dVar.f && playAddress != null && !playAddress.isFromCache) {
                        pk6.c cVar = this.b;
                        String str2 = cVar.b;
                        long j = cVar.c;
                        AbsPlayList absPlayList = cVar.a;
                        if (absPlayList != null) {
                            i = absPlayList.getGenreType();
                        }
                        AbsPlayList absPlayList2 = this.b.a;
                        if (absPlayList2 != null) {
                            str = absPlayList2.getListId();
                        } else {
                            str = null;
                        }
                        jl6.c.b(str2, j, i, str);
                        return;
                    }
                    return;
                }
            }
            g gVar3 = g.this;
            if (gVar3.k.b) {
                gVar3.a.d("startTask: tryPreloadItem, GetPlayAddressCallBack fail, playAddress is null, playParam = " + this.b, new Object[0]);
                g.this.w();
            }
            if (!dVar.f) {
            }
        }

        @Insert("success")
        @ImplementedInterface(scope = Scope.ALL, value = {"com.xs.fm.player.base.play.address.PlayAddressCacheCallBack"})
        public static void f(f fVar, PlayAddress playAddress, jl6.d dVar) {
            NsXrayApi nsXrayApi = NsXrayApi.IMPL;
            if (nsXrayApi.enable()) {
                i0.a.i("播放地址获取成功, playAddress = " + playAddress + ", req = " + dVar, new Object[0]);
                v03.g gVar = new v03.g();
                i0.h(gVar, dVar);
                i0.l(gVar, playAddress);
                nsXrayApi.sendEvent("播放地址请求成功", gVar);
            }
            fVar.d(playAddress, dVar);
        }

        public void c(int i, String str, jl6.d dVar) {
            ArrayList<Integer> arrayList;
            int i2;
            String str2;
            g.this.a.b("startTask: tryPreloadItem, GetPlayAddressCallBack fail, code = " + i + ", errorMsg = " + str + ",  playParam = " + this.b, new Object[0]);
            pk6.c cVar = g.this.k.n;
            if (cVar != null) {
                String str3 = cVar.b;
                long j = cVar.c;
                AbsPlayList absPlayList = cVar.a;
                if (absPlayList != null) {
                    i2 = absPlayList.getGenreType();
                } else {
                    i2 = 0;
                }
                AbsPlayList absPlayList2 = cVar.a;
                if (absPlayList2 != null) {
                    str2 = absPlayList2.getListId();
                } else {
                    str2 = null;
                }
                pl6.b.e(str3, j, i2, str2, i, str);
            }
            vk6.b bVar = g.this.i;
            if (bVar != null) {
                bVar.a(i, str);
            }
            vk6.b bVar2 = g.this.i;
            if (bVar2 != null) {
                bVar2.d(null);
            }
            if (g.this.k.b) {
                nk6.e eVar = lk6.c.a.n;
                if (eVar == null || (arrayList = eVar.E()) == null) {
                    arrayList = new ArrayList<>();
                }
                if (!arrayList.contains(Integer.valueOf(i))) {
                    g.this.w();
                }
            }
        }

        @Insert("fail")
        @ImplementedInterface(scope = Scope.ALL, value = {"com.xs.fm.player.base.play.address.PlayAddressCacheCallBack"})
        public static void e(f fVar, int i, String str, jl6.d dVar) {
            if (NsXrayApi.IMPL.enable()) {
                i0.a.e("播放地址获取失败(" + str + "," + dVar + ")", new Object[0]);
            }
            fVar.c(i, str, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(vk6.c cVar, PreloaderVideoModelItem preloaderVideoModelItem) {
        if (this.g > lk6.c.a.s.a()) {
            t();
        } else if (this.j == null) {
            c cVar2 = new c(cVar, preloaderVideoModelItem);
            this.j = cVar2;
            pl6.c.c.b(cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(vk6.c cVar, PreloaderVideoModelItem preloaderVideoModelItem) {
        if (this.g <= lk6.c.a.s.a()) {
            int d2 = lk6.c.a.s.d();
            d dVar = new d(cVar, preloaderVideoModelItem);
            this.h = dVar;
            xk6.g.c(dVar, d2);
            return;
        }
        pl6.b.d(cVar.j, this.g, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(vk6.c cVar, PlayAddress playAddress) {
        String str;
        boolean z;
        lk6.b bVar;
        nk6.f fVar;
        h.g();
        boolean z2 = false;
        this.a.d("addEnginePreloadTask: start preloadInfo = " + cVar, new Object[0]);
        int i = playAddress.playType;
        if (i == 1) {
            this.a.d("addEnginePreloadTask: no need preload local file, return", new Object[0]);
            h.e(h.b(cVar.n));
            h.f(h.b(cVar.n) + "_" + Resolution.toString(cVar.i));
            if (cVar.c && (bVar = lk6.c.a) != null && (fVar = bVar.o) != null && fVar.e()) {
                this.a.d("addEnginePreloadTask: prepare file, preloadInfo = " + cVar, new Object[0]);
                ql6.b.b.a(vl6.b.a(cVar.n, playAddress));
                return;
            }
            return;
        }
        if (i == 2 && !TextUtils.isEmpty(playAddress.playVideoModel)) {
            if (this.b) {
                this.a.d("addEnginePreloadTask: cancel return", new Object[0]);
                return;
            }
            long j = cVar.h;
            if (j < 0) {
                return;
            }
            if (j == 0) {
                cVar.h = 819200;
            } else {
                this.a.d("Size is valid", new Object[0]);
            }
            if (cVar.f) {
                TTNetWorkListener tTNetWorkListener = TTNetWorkListener.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(tTNetWorkListener, "TTNetWorkListener.getInstance()");
                if (tTNetWorkListener.getCurrentAccessType() != 0) {
                    this.a.d("addEnginePreloadTask: 4G cancel return", new Object[0]);
                    return;
                }
            }
            if (pl6.a.a.c()) {
                TTNetWorkListener tTNetWorkListener2 = TTNetWorkListener.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(tTNetWorkListener2, "TTNetWorkListener.getInstance()");
                if (tTNetWorkListener2.getCurrentAccessType() == 1) {
                    return;
                }
            }
            bl6.a aVar = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("addEnginePreloadTask: addPreloadTask! preloadInfo itemId = ");
            pk6.c cVar2 = cVar.n;
            if (cVar2 != null) {
                str = cVar2.b;
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(", preloadVideoSize = ");
            sb.append(cVar.h);
            aVar.d(sb.toString(), new Object[0]);
            VideoModel videoModel = playAddress.videoModel;
            if (videoModel == null) {
                videoModel = xk6.h.a.c(playAddress.playVideoModel, "addEnginePreloadTask");
            }
            PreloaderVideoModelItem preloaderVideoModelItem = new PreloaderVideoModelItem(videoModel, cVar.i, cVar.h, false);
            preloaderVideoModelItem.setPriorityLevel(0);
            String str2 = playAddress.tag;
            if (str2 != null && str2.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                preloaderVideoModelItem.setTag(playAddress.tag);
            }
            String str3 = playAddress.mdlCachePath;
            if (str3 == null || str3.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                preloaderVideoModelItem.setFilePathListener(new a(playAddress));
            }
            preloaderVideoModelItem.setCallBackListener(new b(cVar, playAddress, preloaderVideoModelItem));
            vk6.b bVar2 = this.i;
            if (bVar2 != null) {
                bVar2.c(cVar, preloaderVideoModelItem, playAddress);
            }
            TTVideoEngine.addTask(preloaderVideoModelItem);
            h.e(h.b(cVar.n));
            h.f(h.b(cVar.n) + "_" + Resolution.toString(cVar.i));
            return;
        }
        this.a.d("addEnginePreloadTask: not videoModel or videomodel is null, return", new Object[0]);
    }
}
