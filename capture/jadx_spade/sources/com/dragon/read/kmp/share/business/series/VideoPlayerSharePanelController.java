package com.dragon.read.kmp.share.business.series;

import ak4.d;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.jb0;
import com.bytedance.kmp.reading.model.lb0;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.share.manger.KmpShareManger;
import com.dragon.read.kmp.utils.ThreadUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.datetime.Clock;
import uh1.a;
import xn4.f0;
import xn4.h0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoPlayerSharePanelController extends rn4.q {
    public static final int n;
    private jb0 g;
    private Function1<? super Boolean, Unit> h;
    private boolean i;
    private boolean j;
    private boolean k;
    private o l;
    private Function0<Unit> m;

    static {
        Covode.recordClassIndex(608922);
        n = 8;
    }

    public final e0 B() {
        un4.a aVar = this.a;
        if (aVar instanceof e0) {
            return (e0) aVar;
        }
        return null;
    }

    public void x() {
        wn4.k kVar = this.e;
        if (kVar != null) {
            kVar.dismiss("choose_channel");
        }
        this.e = null;
    }

    public final void O() {
        un4.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        this.i = true;
        this.j = false;
        uh1.e eVar = this.b;
        if (eVar != null) {
            eVar.b(aVar, new Function1() { // from class: com.dragon.read.kmp.share.business.series.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit P;
                    P = VideoPlayerSharePanelController.P(VideoPlayerSharePanelController.this, obj);
                    return P;
                }
            });
        }
    }

    public void c() {
        boolean z;
        wn4.b c;
        yn4.b bVar;
        e0 B = B();
        if (B != null && B.r) {
            z = true;
        } else {
            z = false;
        }
        ArrayList arrayList = null;
        if (z) {
            h0 h0Var = h0.a;
            List<bh1.a> list = this.c;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            c = h0Var.b("分享至", list, y(null, false), true);
        } else {
            h0 h0Var2 = h0.a;
            List<bh1.a> list2 = this.c;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            c = h0Var2.c("分享至", list2, y(null, false));
        }
        this.e = new wn4.k(c, B());
        un4.a aVar = this.a;
        if (aVar != null && (bVar = aVar.h) != null) {
            List<bh1.a> list3 = this.c;
            if (list3 != null) {
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((bh1.a) it2.next()).a);
                }
            }
            bVar.f = arrayList;
        }
        wn4.k kVar = this.e;
        if (kVar != null) {
            kVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(VideoPlayerSharePanelController videoPlayerSharePanelController) {
        yn4.a aVar;
        h0.a.g();
        o oVar = videoPlayerSharePanelController.l;
        if (oVar != null) {
            yn4.b bVar = oVar.h;
            if (bVar != null && (aVar = bVar.c) != null) {
                aVar.f("video_poster");
            }
            KmpShareManger.a.R(oVar);
        }
        return Unit.INSTANCE;
    }

    public final String C(e0 e0Var) {
        boolean z = false;
        if (e0Var != null && e0Var.p) {
            z = true;
        }
        if (z) {
            return e0Var.k;
        }
        if (e0Var != null) {
            return e0Var.j;
        }
        return null;
    }

    public final void D(final jb0 jb0Var) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        lb0 lb0Var;
        if (jb0Var != null && (lb0Var = jb0Var.c) != null) {
            str = lb0Var.c;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        bh1.a aVar = new bh1.a();
        aVar.a("long_image");
        final un4.e v = KmpShareManger.v(KmpShareManger.a, jb0Var, aVar, null, 4, null);
        if (v == null) {
            return;
        }
        this.k = true;
        f0 f0Var = f0.a;
        e0 B = B();
        if (B == null || (str2 = B.n) == null) {
            str2 = "";
        }
        final un4.f f = f0Var.f(str2);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        e0 B2 = B();
        if (B2 == null || (str5 = B2.t) == null) {
            str3 = "";
        } else {
            str3 = str5;
        }
        f0Var.g(str3, new Function1() { // from class: com.dragon.read.kmp.share.business.series.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K;
                K = VideoPlayerSharePanelController.K(Ref$ObjectRef.this, ref$ObjectRef2, ref$ObjectRef3, ref$BooleanRef, this, f, v, jb0Var, (un4.h) obj);
                return K;
            }
        }, new Function1() { // from class: com.dragon.read.kmp.share.business.series.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit L;
                L = VideoPlayerSharePanelController.L(Ref$BooleanRef.this, this, (Throwable) obj);
                return L;
            }
        });
        xn4.e0.a.g("https://lf3-reading.fqnovelpic.com/obj/novel-common/img_671_share_short_series_post_bg_v2.png", new Function1() { // from class: com.dragon.read.kmp.share.business.series.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E;
                E = VideoPlayerSharePanelController.E(Ref$ObjectRef.this, ref$ObjectRef, ref$ObjectRef3, ref$BooleanRef, this, f, v, jb0Var, (un4.h) obj);
                return E;
            }
        }, new Function1() { // from class: com.dragon.read.kmp.share.business.series.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit F;
                F = VideoPlayerSharePanelController.F(Ref$BooleanRef.this, this, (Throwable) obj);
                return F;
            }
        });
        com.dragon.read.kmp.share.manger.c cVar = com.dragon.read.kmp.share.manger.c.a;
        String str6 = jb0Var.d;
        if (str6 == null) {
            str4 = "";
        } else {
            str4 = str6;
        }
        Observable<String> e = cVar.e(str4);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.share.business.series.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G;
                G = VideoPlayerSharePanelController.G(Ref$ObjectRef.this, ref$ObjectRef, ref$ObjectRef2, ref$BooleanRef, this, f, v, jb0Var, (String) obj);
                return G;
            }
        };
        Consumer<? super String> consumer = new Consumer() { // from class: com.dragon.read.kmp.share.business.series.c0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoPlayerSharePanelController.H(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.share.business.series.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I;
                I = VideoPlayerSharePanelController.I(Ref$BooleanRef.this, this, (Throwable) obj);
                return I;
            }
        };
        e.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.share.business.series.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VideoPlayerSharePanelController.J(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public final Function1<bh1.a, Unit> y(final jb0 jb0Var, final boolean z) {
        return new Function1() { // from class: com.dragon.read.kmp.share.business.series.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z2;
                z2 = VideoPlayerSharePanelController.z(VideoPlayerSharePanelController.this, z, jb0Var, (bh1.a) obj);
                return z2;
            }
        };
    }

    private static final void M(Ref$BooleanRef ref$BooleanRef, VideoPlayerSharePanelController videoPlayerSharePanelController) {
        if (ref$BooleanRef.element) {
            return;
        }
        ref$BooleanRef.element = true;
        videoPlayerSharePanelController.k = false;
        if (videoPlayerSharePanelController.m != null) {
            ig4.g.b("分享失败，请稍后重试", (ToastDuration) null, 2, (Object) null);
        }
        videoPlayerSharePanelController.m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(VideoPlayerSharePanelController videoPlayerSharePanelController, Object obj) {
        jb0 jb0Var;
        if (obj instanceof jb0) {
            jb0Var = (jb0) obj;
        } else {
            jb0Var = null;
        }
        videoPlayerSharePanelController.g = jb0Var;
        if (jb0Var != null) {
            Function1<? super Boolean, Unit> function1 = videoPlayerSharePanelController.h;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } else {
            videoPlayerSharePanelController.j = true;
            Function1<? super Boolean, Unit> function12 = videoPlayerSharePanelController.h;
            if (function12 != null) {
                function12.invoke(Boolean.FALSE);
            }
        }
        videoPlayerSharePanelController.D(videoPlayerSharePanelController.g);
        videoPlayerSharePanelController.h = null;
        videoPlayerSharePanelController.i = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Ref$BooleanRef ref$BooleanRef, VideoPlayerSharePanelController videoPlayerSharePanelController, Throwable th) {
        M(ref$BooleanRef, videoPlayerSharePanelController);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Ref$BooleanRef ref$BooleanRef, VideoPlayerSharePanelController videoPlayerSharePanelController, Throwable it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        M(ref$BooleanRef, videoPlayerSharePanelController);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Ref$BooleanRef ref$BooleanRef, VideoPlayerSharePanelController videoPlayerSharePanelController, Throwable it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        M(ref$BooleanRef, videoPlayerSharePanelController);
        return Unit.INSTANCE;
    }

    @Override // rn4.q
    public void b(List<bh1.a> channel, Object obj, Object obj2) {
        un4.e eVar;
        yn4.a aVar;
        yn4.b bVar;
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (obj2 instanceof un4.e) {
            eVar = (un4.e) obj2;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            if (Intrinsics.areEqual(eVar.b, "copy_link")) {
                jb0 jb0Var = eVar.i;
                un4.a aVar2 = this.a;
                if (aVar2 != null && (bVar = aVar2.h) != null) {
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(channel, 10));
                    Iterator<T> it2 = channel.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(((bh1.a) it2.next()).a);
                    }
                    bVar.f = arrayList;
                }
                wn4.k kVar = this.e;
                if (kVar != null) {
                    kVar.C("链接已复制，去粘贴分享:", channel, y(jb0Var, true));
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(eVar.b, "long_image")) {
                o oVar = this.l;
                if (oVar != null) {
                    yn4.b bVar2 = oVar.h;
                    if (bVar2 != null) {
                        bVar2.d = Clock.System.INSTANCE.now().toEpochMilliseconds();
                    }
                    yn4.b bVar3 = oVar.h;
                    if (bVar3 != null && (aVar = bVar3.c) != null) {
                        aVar.f("video_poster");
                    }
                    KmpShareManger.a.R(oVar);
                    return;
                }
                h0.a.i("加载中");
                this.m = new Function0() { // from class: com.dragon.read.kmp.share.business.series.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit w;
                        w = VideoPlayerSharePanelController.w(VideoPlayerSharePanelController.this);
                        return w;
                    }
                };
            }
        }
    }

    @Override // rn4.q
    public void a(bh1.b params, uh1.e datasource, List<bh1.a> channels, a.b listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(datasource, "datasource");
        Intrinsics.checkNotNullParameter(channels, "channels");
        Intrinsics.checkNotNullParameter(listener, "listener");
        super.a(params, datasource, channels, listener);
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit z(final VideoPlayerSharePanelController videoPlayerSharePanelController, final boolean z, final jb0 jb0Var, final bh1.a channel) {
        boolean z2;
        Integer num;
        e0 e0Var;
        VideoContentType videoContentType;
        d.a.C0000a c0000a;
        yn4.b bVar;
        Intrinsics.checkNotNullParameter(channel, "channel");
        com.dragon.read.kmp.share.manger.a0 a0Var = com.dragon.read.kmp.share.manger.a0.a;
        if (a0Var.i()) {
            videoPlayerSharePanelController.x();
            return Unit.INSTANCE;
        }
        if (videoPlayerSharePanelController.j) {
            videoPlayerSharePanelController.O();
        }
        if (videoPlayerSharePanelController.i) {
            h0.a.i("加载中");
            final long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
            videoPlayerSharePanelController.h = new Function1() { // from class: com.dragon.read.kmp.share.business.series.w
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit A;
                    A = VideoPlayerSharePanelController.A(z, jb0Var, videoPlayerSharePanelController, epochMilliseconds, channel, ((Boolean) obj).booleanValue());
                    return A;
                }
            };
        } else {
            un4.a aVar = videoPlayerSharePanelController.a;
            if (aVar != null && (bVar = aVar.h) != null) {
                bVar.e = 0L;
            }
            if (!z) {
                jb0Var = videoPlayerSharePanelController.g;
            }
            Function3<? super bh1.a, Object, ? super String, Unit> function3 = videoPlayerSharePanelController.d;
            if (function3 != null) {
                if (z) {
                    c0000a = "copy_link";
                } else {
                    c0000a = 0;
                }
                function3.invoke(channel, jb0Var, c0000a);
            }
            if (jb0Var != null && !channel.e) {
                String C = videoPlayerSharePanelController.C(videoPlayerSharePanelController.B());
                if (C == null) {
                    C = "";
                }
                String str = channel.a;
                o oVar = videoPlayerSharePanelController.l;
                if (oVar != null && (e0Var = oVar.o) != null && (videoContentType = e0Var.o) != null) {
                    num = Integer.valueOf(videoContentType.getValue());
                } else {
                    num = null;
                }
                com.dragon.read.kmp.share.manger.a0.r(a0Var, C, str, num, null, 8, null);
            }
            if (Intrinsics.areEqual(channel.a, "copy_link") && channel.e) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                videoPlayerSharePanelController.x();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit A(boolean z, jb0 jb0Var, VideoPlayerSharePanelController videoPlayerSharePanelController, long j, bh1.a aVar, boolean z2) {
        boolean z3;
        e0 e0Var;
        VideoContentType videoContentType;
        d.a.C0000a c0000a;
        yn4.b bVar;
        h0.a.g();
        if (!z) {
            jb0Var = videoPlayerSharePanelController.g;
        }
        un4.a aVar2 = videoPlayerSharePanelController.a;
        if (aVar2 != null && (bVar = aVar2.h) != null) {
            bVar.e = Clock.System.INSTANCE.now().toEpochMilliseconds() - j;
        }
        Function3<? super bh1.a, Object, ? super String, Unit> function3 = videoPlayerSharePanelController.d;
        Integer num = null;
        if (function3 != null) {
            if (z) {
                c0000a = "copy_link";
            } else {
                c0000a = 0;
            }
            function3.invoke(aVar, jb0Var, c0000a);
        }
        if (jb0Var != null && !aVar.e) {
            com.dragon.read.kmp.share.manger.a0 a0Var = com.dragon.read.kmp.share.manger.a0.a;
            String C = videoPlayerSharePanelController.C(videoPlayerSharePanelController.B());
            if (C == null) {
                C = "";
            }
            String str = C;
            String str2 = aVar.a;
            o oVar = videoPlayerSharePanelController.l;
            if (oVar != null && (e0Var = oVar.o) != null && (videoContentType = e0Var.o) != null) {
                num = Integer.valueOf(videoContentType.getValue());
            }
            com.dragon.read.kmp.share.manger.a0.r(a0Var, str, str2, num, null, 8, null);
        }
        if (Intrinsics.areEqual(aVar.a, "copy_link") && aVar.e) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            videoPlayerSharePanelController.x();
        }
        return Unit.INSTANCE;
    }

    private static final void N(Ref$ObjectRef<un4.h> ref$ObjectRef, Ref$ObjectRef<un4.h> ref$ObjectRef2, Ref$ObjectRef<String> ref$ObjectRef3, Ref$BooleanRef ref$BooleanRef, VideoPlayerSharePanelController videoPlayerSharePanelController, un4.f fVar, un4.e eVar, jb0 jb0Var) {
        un4.h hVar = ref$ObjectRef.element;
        un4.h hVar2 = ref$ObjectRef2.element;
        String str = ref$ObjectRef3.element;
        if (!ref$BooleanRef.element && hVar != null && hVar2 != null && str != null) {
            ThreadUtils.a.o(new VideoPlayerSharePanelController$preparePostShareParams$tryComplete$1(videoPlayerSharePanelController, hVar, hVar2, fVar, str, eVar, jb0Var, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit K(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$BooleanRef ref$BooleanRef, VideoPlayerSharePanelController videoPlayerSharePanelController, un4.f fVar, un4.e eVar, jb0 jb0Var, un4.h it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        ref$ObjectRef.element = it2;
        N(ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ref$BooleanRef, videoPlayerSharePanelController, fVar, eVar, jb0Var);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit E(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$BooleanRef ref$BooleanRef, VideoPlayerSharePanelController videoPlayerSharePanelController, un4.f fVar, un4.e eVar, jb0 jb0Var, un4.h it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        ref$ObjectRef.element = it2;
        N(ref$ObjectRef2, ref$ObjectRef, ref$ObjectRef3, ref$BooleanRef, videoPlayerSharePanelController, fVar, eVar, jb0Var);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit G(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$BooleanRef ref$BooleanRef, VideoPlayerSharePanelController videoPlayerSharePanelController, un4.f fVar, un4.e eVar, jb0 jb0Var, String str) {
        ref$ObjectRef.element = str;
        N(ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef, ref$BooleanRef, videoPlayerSharePanelController, fVar, eVar, jb0Var);
        return Unit.INSTANCE;
    }
}
