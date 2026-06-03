package com.dragon.read.kmp.share.manger;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserEventReportType;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.a20;
import com.bytedance.kmp.reading.model.a4;
import com.bytedance.kmp.reading.model.a6;
import com.bytedance.kmp.reading.model.b20;
import com.bytedance.kmp.reading.model.b4;
import com.bytedance.kmp.reading.model.b50;
import com.bytedance.kmp.reading.model.b6;
import com.bytedance.kmp.reading.model.b60;
import com.bytedance.kmp.reading.model.bc0;
import com.bytedance.kmp.reading.model.cs;
import com.bytedance.kmp.reading.model.dm0;
import com.bytedance.kmp.reading.model.ee0;
import com.bytedance.kmp.reading.model.f2;
import com.bytedance.kmp.reading.model.fb0;
import com.bytedance.kmp.reading.model.fe0;
import com.bytedance.kmp.reading.model.fq;
import com.bytedance.kmp.reading.model.gb0;
import com.bytedance.kmp.reading.model.gg0;
import com.bytedance.kmp.reading.model.gj;
import com.bytedance.kmp.reading.model.hb0;
import com.bytedance.kmp.reading.model.j9;
import com.bytedance.kmp.reading.model.l8;
import com.bytedance.kmp.reading.model.lc0;
import com.bytedance.kmp.reading.model.m8;
import com.bytedance.kmp.reading.model.n8;
import com.bytedance.kmp.reading.model.nl0;
import com.bytedance.kmp.reading.model.q3;
import com.bytedance.kmp.reading.model.rp;
import com.bytedance.kmp.reading.model.se0;
import com.bytedance.kmp.reading.model.t4;
import com.bytedance.kmp.reading.model.tk0;
import com.bytedance.kmp.reading.model.ue0;
import com.bytedance.kmp.reading.model.uf0;
import com.bytedance.kmp.reading.model.uk0;
import com.bytedance.kmp.reading.model.v8;
import com.bytedance.kmp.reading.model.xs;
import com.bytedance.kmp.reading.model.y3;
import com.bytedance.kmp.reading.model.yf0;
import com.bytedance.kmp.reading.model.z8;
import com.bytedance.kmp.reading.model.zb0;
import com.bytedance.kmp.reading.rpc.UserApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import xn4.g0;
import xn4.h0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 {
    public static final a0 a;
    private static final xm6.e<gb0> b;
    public static final int c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608930);
            int[] iArr = new int[VideoContentType.values().length];
            try {
                iArr[VideoContentType.ShortSeriesPlay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoContentType.MotionComic.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoContentType.PUGC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoContentType.Movie.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VideoContentType.TelePlay.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    private a0() {
    }

    static {
        Covode.recordClassIndex(608929);
        a = new a0();
        b = xm6.b.g(null);
        c = 8;
    }

    public final boolean i() {
        v8 v8Var;
        boolean z;
        gb0 gb0Var = b.b;
        if (gb0Var != null) {
            v8Var = gb0Var.c;
        } else {
            v8Var = null;
        }
        if (v8Var != null) {
            z = Intrinsics.areEqual(v8Var.a, Boolean.FALSE);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        h0 h0Var = h0.a;
        String str = v8Var.b;
        if (str == null) {
            str = "手速太快，请稍后再试";
        }
        h0Var.h(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(uk0 uk0Var) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Throwable th) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(gb0 gb0Var) {
        b.b(gb0Var);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Throwable th) {
        b.b(null);
        return Unit.INSTANCE;
    }

    private final long w(String str) {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return -1L;
    }

    private final VideoContentType x(int i) {
        boolean z;
        for (VideoContentType videoContentType : VideoContentType.values()) {
            if (videoContentType.getValue() == i) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return videoContentType;
            }
        }
        return null;
    }

    public final String j(Integer num) {
        VideoContentType videoContentType;
        int i;
        if (num != null) {
            videoContentType = x(num.intValue());
        } else {
            videoContentType = null;
        }
        if (videoContentType == null) {
            i = -1;
        } else {
            i = a.a[videoContentType.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return "0";
                        }
                        return "5";
                    }
                    return "4";
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public final Observable<gb0> k(String str, Integer num, String str2) {
        Map<String, String> a2 = g0.a.a();
        fb0 fb0Var = new fb0((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        fb0Var.a = str;
        fb0Var.b = j(num);
        fb0Var.c = str2;
        fb0Var.d = a2.get("enter_from");
        fb0Var.e = a2.get("previous_page");
        fb0Var.f = a2.get("page_list");
        Observable x = UserApiService.x(UserApiService.a, fb0Var, (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = x.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.share.manger.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m;
                m = a0.m((gb0) obj);
                return m;
            }
        };
        Observable doOnNext = observeOn.doOnNext(new Consumer() { // from class: com.dragon.read.kmp.share.manger.x
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                a0.n(Function1.this, obj);
            }
        });
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.share.manger.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o;
                o = a0.o((Throwable) obj);
                return o;
            }
        };
        Observable<gb0> doOnError = doOnNext.doOnError(new Consumer() { // from class: com.dragon.read.kmp.share.manger.z
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                a0.p(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnError, "doOnError(...)");
        return doOnError;
    }

    public final void q(String str, String str2, Integer num, String str3) {
        if (str2 != null && str != null) {
            hb0 hb0Var = new hb0(Long.valueOf(w(str)), str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 252, (DefaultConstructorMarker) null);
            Map<String, String> a2 = g0.a.a();
            hb0Var.c = str;
            hb0Var.d = j(num);
            hb0Var.e = str3;
            hb0Var.f = a2.get("enter_from");
            hb0Var.g = a2.get("previous_page");
            hb0Var.h = a2.get("page_list");
            Observable z = UserApiService.z(UserApiService.a, new tk0(Integer.valueOf(UserEventReportType.ShareCount.getValue()), (yf0) null, (m8) null, (l8) null, (b4) null, (List) null, (gg0) null, (Integer) null, (cs) null, (uf0) null, (n8) null, (t4) null, (xs) null, (b6) null, (com.bytedance.kmp.reading.model.m) null, (b50) null, (a4) null, (zb0) null, (gj) null, (dm0) null, (y3) null, (b60) null, (ee0) null, (j9) null, (lc0) null, (se0) null, hb0Var, (z8) null, (b20) null, (fe0) null, (fq) null, (a20) null, (rp) null, (ue0) null, (q3) null, (a6) null, (bc0) null, (f2) null, (nl0) null, -67108866, 127, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
            KSchedulers kSchedulers = KSchedulers.INSTANCE;
            Scheduler io2 = Schedulers.io();
            Intrinsics.checkNotNullExpressionValue(io2, "io()");
            Observable subscribeOn = z.subscribeOn(io2);
            Scheduler mainThread = AndroidSchedulers.mainThread();
            Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
            Observable observeOn = subscribeOn.observeOn(mainThread);
            final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.share.manger.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s;
                    s = a0.s((uk0) obj);
                    return s;
                }
            };
            Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.share.manger.t
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    a0.t(Function1.this, obj);
                }
            };
            final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.share.manger.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit u;
                    u = a0.u((Throwable) obj);
                    return u;
                }
            };
            observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.share.manger.v
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    a0.v(Function1.this, obj);
                }
            });
        }
    }

    public static /* synthetic */ Observable l(a0 a0Var, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return a0Var.k(str, num, str2);
    }

    public static /* synthetic */ void r(a0 a0Var, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        a0Var.q(str, str2, num, str3);
    }
}
