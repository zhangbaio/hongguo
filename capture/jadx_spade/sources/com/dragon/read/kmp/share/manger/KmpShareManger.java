package com.dragon.read.kmp.share.manger;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.cb0;
import com.bytedance.kmp.reading.model.db0;
import com.bytedance.kmp.reading.model.eb0;
import com.bytedance.kmp.reading.model.jb0;
import com.bytedance.kmp.reading.model.ob0;
import com.bytedance.kmp.reading.model.pv;
import com.bytedance.kmp.reading.model.qv;
import com.bytedance.kmp.reading.rpc.UserApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.utils.ThreadUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.serialization.internal.a1;
import kotlinx.serialization.internal.v2;
import xn4.b0;
import xn4.g0;
import yn0.a;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpShareManger {
    public static final KmpShareManger a;
    private static final com.dragon.read.kmp.i b;
    private static Map<String, cb0> c;
    private static long d;
    private static un4.d<String, a> e;
    private static final c f;
    private static final b g;
    public static final int h;

    private KmpShareManger() {
    }

    static {
        Covode.recordClassIndex(608927);
        a = new KmpShareManger();
        b = new com.dragon.read.kmp.i("ShareMangerKmp");
        d = -1L;
        e = new un4.d<>(100, false, 2, null);
        f = new c();
        g = new b();
        h = 8;
    }

    public final void y() {
        List mutableListOf;
        List mutableListOf2;
        List mutableListOf3;
        vf1.c cVar = new vf1.c();
        cVar.b(f, g);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("video_player");
        cVar.a(mutableListOf, new com.dragon.read.kmp.share.business.series.q());
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf("video_player_poster");
        cVar.a(mutableListOf2, new com.dragon.read.kmp.share.business.series.g());
        mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf("common_poster_share");
        cVar.a(mutableListOf3, new tn4.e());
        wf1.c cVar2 = wf1.c.a;
        cVar2.e(cVar);
        cVar2.f(new Function1() { // from class: com.dragon.read.kmp.share.manger.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z;
                z = KmpShareManger.z(obj);
                return z;
            }
        });
        I();
    }

    private final Map<String, cb0> w() {
        boolean z;
        Object m773constructorimpl;
        Map<String, cb0> map = c;
        if (map != null) {
            return map;
        }
        com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
        String string = xn0.c.a("KEY_UG_SHARE_CONFIG").getString("KEY_UG_SHARE_CHANNEL_CONFIG", "");
        if (string != null && string.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        Object obj = null;
        if (!z) {
            try {
                Result.Companion companion = Result.Companion;
                gn6.a c2 = com.dragon.read.kmp.base.h.c();
                c2.getSerializersModule();
                m773constructorimpl = Result.m773constructorimpl(c2.c(new a1(v2.a, cb0.Companion.serializer()), string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
            if (m776exceptionOrNullimpl != null) {
                a.a.b(yn0.b.b, "JSONUtils", "fromJson json error " + m776exceptionOrNullimpl.getMessage(), false, 4, (Object) null);
            }
            if (!Result.m779isFailureimpl(m773constructorimpl)) {
                obj = m773constructorimpl;
            }
        }
        Map<String, cb0> map2 = (Map) obj;
        if (map2 == null) {
            map2 = new LinkedHashMap<>();
        }
        c = map2;
        return map2;
    }

    public final void I() {
        if (!g0.a.c()) {
            return;
        }
        Clock.System system = Clock.System.INSTANCE;
        if (system.now().toEpochMilliseconds() - d <= 1800000) {
            return;
        }
        d = system.now().toEpochMilliseconds();
        Observable h2 = UserApiService.h(UserApiService.a, new db0(), (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = h2.subscribeOn(io2);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.share.manger.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Map J;
                J = KmpShareManger.J((eb0) obj);
                return J;
            }
        };
        Observable map = subscribeOn.map(new Function() { // from class: com.dragon.read.kmp.share.manger.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Map K;
                K = KmpShareManger.K(Function1.this, obj);
                return K;
            }
        });
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = map.observeOn(mainThread);
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.share.manger.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit L;
                L = KmpShareManger.L((Throwable) obj);
                return L;
            }
        };
        Observable doOnError = observeOn.doOnError(new Consumer() { // from class: com.dragon.read.kmp.share.manger.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                KmpShareManger.M(Function1.this, obj);
            }
        });
        final Function1 function13 = new Function1() { // from class: com.dragon.read.kmp.share.manger.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit N;
                N = KmpShareManger.N((Map) obj);
                return N;
            }
        };
        Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.share.manger.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                KmpShareManger.O(Function1.this, obj);
            }
        };
        final Function1 function14 = new Function1() { // from class: com.dragon.read.kmp.share.manger.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit P;
                P = KmpShareManger.P((Throwable) obj);
                return P;
            }
        };
        doOnError.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.share.manger.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                KmpShareManger.Q(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Throwable th) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Throwable th) {
        b.b("requestSharePanel error", th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Map map) {
        KmpShareManger kmpShareManger = a;
        Intrinsics.checkNotNull(map);
        kmpShareManger.S(map);
        return Unit.INSTANCE;
    }

    public final void R(bh1.b params) {
        Intrinsics.checkNotNullParameter(params, "params");
        wf1.c.a.h(params);
    }

    public final void S(Map<String, cb0> shareChannelConfig) {
        Intrinsics.checkNotNullParameter(shareChannelConfig, "shareChannelConfig");
        c = shareChannelConfig;
        T(shareChannelConfig);
    }

    public static final class c implements uh1.b {
        c() {
        }

        public List<bh1.a> b(bh1.b params) {
            List<String> emptyList;
            Intrinsics.checkNotNullParameter(params, "params");
            KmpShareManger kmpShareManger = KmpShareManger.a;
            cb0 x = kmpShareManger.x(params.b);
            if (x == null || (emptyList = x.a) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            return kmpShareManger.t(params, emptyList);
        }

        public List<bh1.a> a(bh1.b params, Object obj) {
            un4.e eVar;
            List<String> emptyList;
            jb0 jb0Var;
            Intrinsics.checkNotNullParameter(params, "params");
            KmpShareManger kmpShareManger = KmpShareManger.a;
            if (obj instanceof un4.e) {
                eVar = (un4.e) obj;
            } else {
                eVar = null;
            }
            if (eVar == null || (jb0Var = eVar.i) == null || (emptyList = jb0Var.a) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            return kmpShareManger.t(params, emptyList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(bh1.b bVar) {
        if (!Intrinsics.areEqual(bVar.a, "video_player") && !Intrinsics.areEqual(bVar.a, "video_player_poster")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cb0 x(String str) {
        List mutableListOf;
        cb0 cb0Var = w().get(str);
        if (cb0Var == null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("copy_link");
            return new cb0(mutableListOf);
        }
        return cb0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Object obj) {
        un4.e eVar;
        if (obj instanceof un4.e) {
            eVar = (un4.e) obj;
        } else {
            eVar = null;
        }
        if (eVar == null || b0.a.h((un4.e) obj) == null) {
            ig4.g.b("分享失败，请稍后重试", (ToastDuration) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public final void T(Map<String, cb0> shareChannelConfig) {
        Intrinsics.checkNotNullParameter(shareChannelConfig, "shareChannelConfig");
        ThreadUtils.a.k(new KmpShareManger$updateShareConfigInMMKV$1(shareChannelConfig, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map J(eb0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        bc4.b.d(bc4.b.a, response.a, response.b, response.c, false, 0, 24, (Object) null);
        Map map = response.c;
        if (map != null) {
            return map;
        }
        throw new IllegalStateException("data is null".toString());
    }

    public final void U(Pair<String, jb0> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        e.b(pair.getFirst(), new a(Clock.System.INSTANCE.now().toEpochMilliseconds(), pair.getSecond()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final bh1.a s(String str) {
        String str2;
        un4.g d2 = b0.a.d(str);
        if (d2 == null) {
            return null;
        }
        switch (str.hashCode()) {
            case -1777292293:
                if (str.equals("image_share")) {
                    str2 = "保存图片";
                    bh1.a aVar = new bh1.a();
                    aVar.a(str);
                    aVar.b(str2);
                    aVar.c = Integer.valueOf(d2.a);
                    aVar.d = Integer.valueOf(d2.b);
                    return aVar;
                }
                return null;
            case -791770330:
                if (str.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                    str2 = "微信";
                    bh1.a aVar2 = new bh1.a();
                    aVar2.a(str);
                    aVar2.b(str2);
                    aVar2.c = Integer.valueOf(d2.a);
                    aVar2.d = Integer.valueOf(d2.b);
                    return aVar2;
                }
                return null;
            case -333314600:
                if (str.equals("long_image")) {
                    str2 = "图片分享";
                    bh1.a aVar22 = new bh1.a();
                    aVar22.a(str);
                    aVar22.b(str2);
                    aVar22.c = Integer.valueOf(d2.a);
                    aVar22.d = Integer.valueOf(d2.b);
                    return aVar22;
                }
                return null;
            case -150184081:
                if (str.equals("douyin_im")) {
                    str2 = "抖音好友";
                    bh1.a aVar222 = new bh1.a();
                    aVar222.a(str);
                    aVar222.b(str2);
                    aVar222.c = Integer.valueOf(d2.a);
                    aVar222.d = Integer.valueOf(d2.b);
                    return aVar222;
                }
                return null;
            case 3616:
                if (str.equals("qq")) {
                    str2 = "qq";
                    bh1.a aVar2222 = new bh1.a();
                    aVar2222.a(str);
                    aVar2222.b(str2);
                    aVar2222.c = Integer.valueOf(d2.a);
                    aVar2222.d = Integer.valueOf(d2.b);
                    return aVar2222;
                }
                return null;
            case 118659:
                if (str.equals("xhs")) {
                    str2 = "小红书";
                    bh1.a aVar22222 = new bh1.a();
                    aVar22222.a(str);
                    aVar22222.b(str2);
                    aVar22222.c = Integer.valueOf(d2.a);
                    aVar22222.d = Integer.valueOf(d2.b);
                    return aVar22222;
                }
                return null;
            case 108102557:
                if (str.equals("qzone")) {
                    str2 = "qq空间";
                    bh1.a aVar222222 = new bh1.a();
                    aVar222222.a(str);
                    aVar222222.b(str2);
                    aVar222222.c = Integer.valueOf(d2.a);
                    aVar222222.d = Integer.valueOf(d2.b);
                    return aVar222222;
                }
                return null;
            case 113011944:
                if (str.equals("weibo")) {
                    str2 = "微博";
                    bh1.a aVar2222222 = new bh1.a();
                    aVar2222222.a(str);
                    aVar2222222.b(str2);
                    aVar2222222.c = Integer.valueOf(d2.a);
                    aVar2222222.d = Integer.valueOf(d2.b);
                    return aVar2222222;
                }
                return null;
            case 540697581:
                if (str.equals("sys_share")) {
                    str2 = "系统分享";
                    bh1.a aVar22222222 = new bh1.a();
                    aVar22222222.a(str);
                    aVar22222222.b(str2);
                    aVar22222222.c = Integer.valueOf(d2.a);
                    aVar22222222.d = Integer.valueOf(d2.b);
                    return aVar22222222;
                }
                return null;
            case 1235271283:
                if (str.equals("moments")) {
                    str2 = "朋友圈";
                    bh1.a aVar222222222 = new bh1.a();
                    aVar222222222.a(str);
                    aVar222222222.b(str2);
                    aVar222222222.c = Integer.valueOf(d2.a);
                    aVar222222222.d = Integer.valueOf(d2.b);
                    return aVar222222222;
                }
                return null;
            case 1505434244:
                if (str.equals("copy_link")) {
                    str2 = "复制链接";
                    bh1.a aVar2222222222 = new bh1.a();
                    aVar2222222222.a(str);
                    aVar2222222222.b(str2);
                    aVar2222222222.c = Integer.valueOf(d2.a);
                    aVar2222222222.d = Integer.valueOf(d2.b);
                    return aVar2222222222;
                }
                return null;
            case 1701892393:
                if (str.equals("douyin_feed")) {
                    str2 = "发抖音";
                    bh1.a aVar22222222222 = new bh1.a();
                    aVar22222222222.a(str);
                    aVar22222222222.b(str2);
                    aVar22222222222.c = Integer.valueOf(d2.a);
                    aVar22222222222.d = Integer.valueOf(d2.b);
                    return aVar22222222222;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public static final class a {
        public static final int c;
        public final long a;
        public final jb0 b;

        static {
            Covode.recordClassIndex(608928);
            c = 8;
        }

        public a(long j, jb0 shareInfoData) {
            Intrinsics.checkNotNullParameter(shareInfoData, "shareInfoData");
            this.a = j;
            this.b = shareInfoData;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair D(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (Pair) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map K(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (Map) function1.invoke(p0);
    }

    public static final class b implements uh1.e {
        b() {
        }

        public void b(bh1.b params, Function1<Object, Unit> completion) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(completion, "completion");
            KmpShareManger kmpShareManger = KmpShareManger.a;
            if (kmpShareManger.A(params)) {
                a aVar = (a) KmpShareManger.e.a(params.f);
                if (aVar != null) {
                    if (Clock.System.INSTANCE.now().toEpochMilliseconds() - aVar.a > 600000) {
                        KmpShareManger.e.c(params.f);
                        kmpShareManger.B(params, completion);
                        return;
                    } else {
                        completion.invoke(aVar.b);
                        return;
                    }
                }
                kmpShareManger.B(params, completion);
                return;
            }
            kmpShareManger.B(params, completion);
        }

        public Object a(Object obj, bh1.a channel, bh1.b params) {
            jb0 jb0Var;
            jb0 jb0Var2;
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(params, "params");
            un4.j jVar = null;
            if (obj instanceof jb0) {
                jb0Var = (jb0) obj;
            } else {
                jb0Var = null;
            }
            if (jb0Var != null) {
                return KmpShareManger.a.u(jb0Var, channel, params);
            }
            if (obj instanceof un4.j) {
                jVar = (un4.j) obj;
            }
            if (jVar != null && (jb0Var2 = jVar.m) != null) {
                return KmpShareManger.a.u(jb0Var2, channel, jVar);
            }
            un4.e eVar = new un4.e();
            eVar.b = channel.a;
            return eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair C(bh1.b bVar, qv response) {
        Intrinsics.checkNotNullParameter(response, "response");
        bc4.b.d(bc4.b.a, response.a, response.b, response.c, false, 0, 24, (Object) null);
        Map map = response.c;
        if (map != null) {
            jb0 jb0Var = (jb0) map.get(bVar.f);
            if (jb0Var != null) {
                return TuplesKt.to(bVar.f, jb0Var);
            }
            throw new IllegalStateException("cacheId is null".toString());
        }
        throw new IllegalStateException("data is null".toString());
    }

    public final void B(final bh1.b params, final Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(params, "params");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(params.f, new ob0(params.c, params.d, params.e));
        Observable r = UserApiService.r(UserApiService.a, new pv(params.b, linkedHashMap), (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = r.subscribeOn(io2);
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.share.manger.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pair C;
                C = KmpShareManger.C(params, (qv) obj);
                return C;
            }
        };
        Observable map = subscribeOn.map(new Function() { // from class: com.dragon.read.kmp.share.manger.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Pair D;
                D = KmpShareManger.D(Function1.this, obj);
                return D;
            }
        });
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = map.observeOn(mainThread);
        final Function1 function13 = new Function1() { // from class: com.dragon.read.kmp.share.manger.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E;
                E = KmpShareManger.E(params, function1, (Pair) obj);
                return E;
            }
        };
        Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.share.manger.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                KmpShareManger.F(Function1.this, obj);
            }
        };
        final Function1 function14 = new Function1() { // from class: com.dragon.read.kmp.share.manger.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G;
                G = KmpShareManger.G(params, function1, (Throwable) obj);
                return G;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.share.manger.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                KmpShareManger.H(Function1.this, obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0013 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<bh1.a> t(bh1.b r5, java.util.List<java.lang.String> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "channelIdList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L13:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L5b
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = r5.a
            java.lang.String r3 = "video_player"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L3f
            java.lang.String r2 = r5.a
            java.lang.String r3 = "video_player_poster"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L36
            goto L3f
        L36:
            xn4.b0 r2 = xn4.b0.a
            boolean r2 = r2.f(r1)
            if (r2 != 0) goto L51
            goto L13
        L3f:
            java.lang.String r2 = "weibo"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r2 == 0) goto L51
            xn4.g0 r2 = xn4.g0.a
            boolean r2 = r2.d()
            if (r2 != 0) goto L51
            goto L13
        L51:
            bh1.a r1 = r4.s(r1)
            if (r1 == 0) goto L13
            r0.add(r1)
            goto L13
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.manger.KmpShareManger.t(bh1.b, java.util.List):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(bh1.b bVar, Function1 function1, Pair pair) {
        KmpShareManger kmpShareManger = a;
        if (kmpShareManger.A(bVar)) {
            Intrinsics.checkNotNull(pair);
            kmpShareManger.U(pair);
        }
        if (function1 != null) {
            function1.invoke(pair.getSecond());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(bh1.b bVar, Function1 function1, Throwable th) {
        b.b("requestShareInfo error, entrance:" + bVar.b + ", cacheId:" + bVar.f + ", groupId:" + bVar.c, th);
        if (function1 != null) {
            function1.invoke(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final un4.e u(com.bytedance.kmp.reading.model.jb0 r22, bh1.a r23, bh1.b r24) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.manger.KmpShareManger.u(com.bytedance.kmp.reading.model.jb0, bh1.a, bh1.b):un4.e");
    }

    public static /* synthetic */ un4.e v(KmpShareManger kmpShareManger, jb0 jb0Var, bh1.a aVar, bh1.b bVar, int i, Object obj) {
        if ((i & 4) != 0) {
            bVar = null;
        }
        return kmpShareManger.u(jb0Var, aVar, bVar);
    }
}
