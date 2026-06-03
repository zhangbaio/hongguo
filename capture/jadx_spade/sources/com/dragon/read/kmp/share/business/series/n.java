package com.dragon.read.kmp.share.business.series;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserEventReportType;
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
import com.bytedance.kmp.reading.model.fe0;
import com.bytedance.kmp.reading.model.fq;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xn4.f0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n extends rn4.q {
    public static final int g;

    static {
        Covode.recordClassIndex(608918);
        g = 8;
    }

    public final o l() {
        un4.a aVar = this.a;
        if (aVar instanceof o) {
            return (o) aVar;
        }
        return null;
    }

    public void c() {
        yn4.b bVar;
        final o l = l();
        if (l != null) {
            o l2 = l();
            ArrayList arrayList = null;
            if (l2 != null) {
                l2.k = null;
            }
            o l3 = l();
            if (l3 != null) {
                l3.l = null;
            }
            f0 f0Var = f0.a;
            List<bh1.a> list = this.c;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            this.e = new wn4.l(f0Var.a(l, list, new Function1() { // from class: com.dragon.read.kmp.share.business.series.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit n;
                    n = n.n(n.this, l, (bh1.a) obj);
                    return n;
                }
            }), l());
            un4.a aVar = this.a;
            if (aVar != null && (bVar = aVar.h) != null) {
                List<bh1.a> list2 = this.c;
                if (list2 != null) {
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it2 = list2.iterator();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(uk0 uk0Var) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Throwable th) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final un4.h o(n nVar) {
        wn4.l lVar;
        wn4.k kVar = nVar.e;
        if (kVar instanceof wn4.l) {
            lVar = (wn4.l) kVar;
        } else {
            lVar = null;
        }
        if (lVar == null) {
            return null;
        }
        return lVar.x();
    }

    public final String m(o oVar) {
        e0 e0Var;
        e0 e0Var2;
        boolean z = false;
        if (oVar != null && (e0Var2 = oVar.o) != null && e0Var2.p) {
            z = true;
        }
        if (z) {
            e0 e0Var3 = oVar.o;
            if (e0Var3 == null) {
                return null;
            }
            return e0Var3.k;
        }
        if (oVar == null || (e0Var = oVar.o) == null) {
            return null;
        }
        return e0Var.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    public final void p(String str, String str2) {
        if (str2 != null && str != null) {
            Observable z = UserApiService.z(UserApiService.a, new tk0(Integer.valueOf(UserEventReportType.ShareCount.getValue()), (yf0) null, (m8) null, (l8) null, (b4) null, (List) null, (gg0) null, (Integer) null, (cs) null, (uf0) null, (n8) null, (t4) null, (xs) null, (b6) null, (com.bytedance.kmp.reading.model.m) null, (b50) null, (a4) null, (zb0) null, (gj) null, (dm0) null, (y3) null, (b60) null, (ee0) null, (j9) null, (lc0) null, (se0) null, new hb0(Long.valueOf(Long.parseLong(str)), str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 252, (DefaultConstructorMarker) null), (z8) null, (b20) null, (fe0) null, (fq) null, (a20) null, (rp) null, (ue0) null, (q3) null, (a6) null, (bc0) null, (f2) null, (nl0) null, -67108866, 127, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
            KSchedulers kSchedulers = KSchedulers.INSTANCE;
            Scheduler io2 = Schedulers.io();
            Intrinsics.checkNotNullExpressionValue(io2, "io()");
            Observable subscribeOn = z.subscribeOn(io2);
            Scheduler mainThread = AndroidSchedulers.mainThread();
            Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
            Observable observeOn = subscribeOn.observeOn(mainThread);
            final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.share.business.series.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit q;
                    q = n.q((uk0) obj);
                    return q;
                }
            };
            Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.share.business.series.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    n.r(Function1.this, obj);
                }
            };
            final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.share.business.series.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s;
                    s = n.s((Throwable) obj);
                    return s;
                }
            };
            observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.share.business.series.m
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    n.t(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final n nVar, o oVar, bh1.a channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        String m = nVar.m(oVar);
        if (m == null) {
            m = "";
        }
        nVar.p(m, channel.a);
        o l = nVar.l();
        if (l != null) {
            l.l = new Function0() { // from class: com.dragon.read.kmp.share.business.series.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    un4.h o;
                    o = n.o(n.this);
                    return o;
                }
            };
        }
        Function3<? super bh1.a, Object, ? super String, Unit> function3 = nVar.d;
        if (function3 != null) {
            function3.invoke(channel, oVar, "long_image");
        }
        return Unit.INSTANCE;
    }
}
