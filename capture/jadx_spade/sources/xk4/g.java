package xk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.CandidateDataType;
import com.bytedance.kmp.reading.model.a30;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.fn;
import com.bytedance.kmp.reading.model.j7;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.vl;
import com.bytedance.kmp.reading.model.wl;
import com.bytedance.kmp.reading.model.x7;
import com.bytedance.kmp.reading.model.xl;
import com.bytedance.kmp.reading.rpc.BookApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.utils.h0;
import gk4.f0;
import gk4.g0;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jd4.c;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final g a;
    private static final a<String, BehaviorSubject<f0>> b;
    private static Disposable c;
    public static final int d;

    private g() {
    }

    private static final class a<K, V> implements Map<K, V>, KMutableMap {
        private final LinkedHashMap<K, V> a;
        private final int b;

        static {
            Covode.recordClassIndex(608014);
        }

        public Set<Map.Entry<K, V>> a() {
            Set<Map.Entry<K, V>> entrySet = this.a.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
            return entrySet;
        }

        public Set<K> c() {
            Set<K> keySet = this.a.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
            return keySet;
        }

        @Override // java.util.Map
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.a.containsValue(obj);
        }

        public int d() {
            return this.a.size();
        }

        public Collection<V> e() {
            Collection<V> values = this.a.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            return values;
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.a.get(obj);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> from) {
            Intrinsics.checkNotNullParameter(from, "from");
            this.a.putAll(from);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            return this.a.remove(obj);
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            return a();
        }

        @Override // java.util.Map
        public final /* bridge */ Set<K> keySet() {
            return c();
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return d();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<V> values() {
            return e();
        }

        public a(LinkedHashMap<K, V> map, int i) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
            this.b = i;
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            if (this.a.size() >= this.b && !this.a.containsKey(k)) {
                Set<Map.Entry<K, V>> entrySet = this.a.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
                this.a.remove(((Map.Entry) CollectionsKt___CollectionsKt.first(entrySet)).getKey());
            }
            return this.a.put(k, v);
        }

        public /* synthetic */ a(LinkedHashMap linkedHashMap, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? new LinkedHashMap() : linkedHashMap, (i2 & 2) != 0 ? 10 : i);
        }
    }

    public final void x() {
        b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Covode.recordClassIndex(608013);
        a = new g();
        b = new a<>(null, 10, 1, 0 == true ? 1 : 0);
        d = 8;
    }

    private final String i(int i) {
        zg4.a aVar = zg4.a.a;
        if (i == aVar.c()) {
            return "single_col_same_ip_series";
        }
        if (i == aVar.a() || i == aVar.b()) {
            return "actor_brand_related_video";
        }
        return null;
    }

    public final f0 h(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        BehaviorSubject<f0> behaviorSubject = b.get(seriesId);
        if (behaviorSubject != null) {
            return behaviorSubject.getValue();
        }
        return null;
    }

    public final BehaviorSubject<f0> n(g0 params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BehaviorSubject<f0> behaviorSubject = b.get(params.b);
        if (behaviorSubject == null) {
            return s(params);
        }
        return behaviorSubject;
    }

    private final c.a o(x7 x7Var) {
        Object firstOrNull;
        List list = x7Var.w;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            d1 d1Var = (d1) firstOrNull;
            if (d1Var != null) {
                c.a aVar = new c.a();
                String str = d1Var.d;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                aVar.b(str);
                String str3 = d1Var.c;
                if (str3 != null) {
                    str2 = str3;
                }
                aVar.a(str2);
                aVar.d = d1Var.X;
                return aVar;
            }
            return null;
        }
        return null;
    }

    public final int m(f0 model) {
        int i;
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.d != null) {
            i = 80;
        } else {
            i = 20;
        }
        int i2 = i + 22 + 16;
        int i3 = 0;
        for (Object obj : model.c) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            i2 += 98;
            if (i3 < model.c.size() - 1) {
                i2 += 20;
            }
            i3 = i4;
        }
        return i2;
    }

    public final BehaviorSubject<f0> s(final g0 params) {
        Intrinsics.checkNotNullParameter(params, "params");
        final String str = params.b;
        a<String, BehaviorSubject<f0>> aVar = b;
        BehaviorSubject<f0> behaviorSubject = aVar.get(str);
        if (behaviorSubject == null) {
            com.bytedance.kmp.rxkmp.a aVar2 = com.bytedance.kmp.rxkmp.a.a;
            behaviorSubject = BehaviorSubject.create();
            Intrinsics.checkNotNullExpressionValue(behaviorSubject, "create()");
            aVar.put(str, behaviorSubject);
        }
        final BehaviorSubject<f0> behaviorSubject2 = behaviorSubject;
        if (!behaviorSubject2.hasValue()) {
            fn fnVar = new fn(10, i(params.a), (String) null, str, (Boolean) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (String) null, (String) null, (Short) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, str, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Long) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, -16777228, 524287, (DefaultConstructorMarker) null);
            Disposable disposable = c;
            if (disposable != null) {
                disposable.dispose();
            }
            Observable r = BookApiService.r(BookApiService.a, fnVar, (zn0.g) null, 2, (Object) null);
            KSchedulers kSchedulers = KSchedulers.INSTANCE;
            Scheduler io2 = Schedulers.io();
            Intrinsics.checkNotNullExpressionValue(io2, "io()");
            Observable subscribeOn = r.subscribeOn(io2);
            Scheduler mainThread = AndroidSchedulers.mainThread();
            Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
            Observable observeOn = subscribeOn.observeOn(mainThread);
            final Function1 function1 = new Function1() { // from class: xk4.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit t;
                    t = g.t(g0.this, behaviorSubject2, (xl) obj);
                    return t;
                }
            };
            Consumer consumer = new Consumer() { // from class: xk4.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    g.u(Function1.this, obj);
                }
            };
            final Function1 function12 = new Function1() { // from class: xk4.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit v;
                    v = g.v(str, behaviorSubject2, (Throwable) obj);
                    return v;
                }
            };
            c = observeOn.subscribe(consumer, new Consumer() { // from class: xk4.d
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    g.w(Function1.this, obj);
                }
            });
            return behaviorSubject2;
        }
        return behaviorSubject2;
    }

    public final Observable<f0> j(final g0 params) {
        f0 f0Var;
        Intrinsics.checkNotNullParameter(params, "params");
        String str = params.b;
        BehaviorSubject<f0> behaviorSubject = b.get(str);
        if (behaviorSubject != null) {
            f0Var = behaviorSubject.getValue();
        } else {
            f0Var = null;
        }
        if (f0Var == null) {
            j.c(j.a, "RelationSeriesDataService", "[loadMore] no data in cache", (Throwable) null, 4, (Object) null);
            com.bytedance.kmp.rxkmp.b bVar = com.bytedance.kmp.rxkmp.b.a;
            Observable<f0> error = Observable.error(new Throwable("no data in cache"));
            Intrinsics.checkNotNullExpressionValue(error, "error(throwable)");
            return error;
        }
        if (!f0Var.a()) {
            j.c(j.a, "RelationSeriesDataService", "[loadMore] no more data", (Throwable) null, 4, (Object) null);
            com.bytedance.kmp.rxkmp.b bVar2 = com.bytedance.kmp.rxkmp.b.a;
            Observable<f0> error2 = Observable.error(new Throwable("invalid paging params"));
            Intrinsics.checkNotNullExpressionValue(error2, "error(throwable)");
            return error2;
        }
        Long l = f0Var.i;
        Intrinsics.checkNotNull(f0Var.f);
        final f0 f0Var2 = f0Var;
        Observable h = BookApiService.h(BookApiService.a, new vl(l, Long.valueOf(r4.intValue()), (Long) null, (Integer) null, str, (Long) null, (Integer) null, (Long) null, (Integer) null, (Integer) null, Long.valueOf(h0.l(params.c, 0L, 1, null)), (Long) null, f0Var.h, (String) null, (Long) null, (Integer) null, (Long) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (Long) null, (Integer) null, (Long) null, (Long) null, (String) null, (Long) null, (Integer) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (Long) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (a30) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (List) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (List) null, (Integer) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (List) null, (Boolean) null, (String) null, (String) null, (Boolean) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, -5140, -1, -1, 131071, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = h.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: xk4.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ObservableSource k;
                k = g.k(g0.this, f0Var2, (wl) obj);
                return k;
            }
        };
        Observable<f0> flatMap = observeOn.flatMap(new Function() { // from class: xk4.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource l2;
                l2 = g.l(Function1.this, obj);
                return l2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource l(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (ObservableSource) function1.invoke(p0);
    }

    private final void g(f0 f0Var, f0 f0Var2) {
        f0Var.c.addAll(f0Var2.c);
        f0Var.g = f0Var2.g;
        f0Var.f = f0Var2.f;
        f0Var.h = f0Var2.h;
    }

    private final f0 p(g0 g0Var, wl wlVar) {
        x7 x7Var;
        j7 j7Var = wlVar.c;
        String str = null;
        if (j7Var != null) {
            x7Var = j7Var.a;
        } else {
            x7Var = null;
        }
        if (j7Var != null) {
            str = j7Var.d;
        }
        return q(g0Var, x7Var, str);
    }

    private final f0 r(g0 g0Var, xl xlVar) {
        x7 x7Var;
        String str;
        Long l;
        Object firstOrNull;
        List list = xlVar.c;
        String str2 = null;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            x7Var = (x7) firstOrNull;
        } else {
            x7Var = null;
        }
        if (x7Var != null) {
            str = x7Var.I2;
        } else {
            str = null;
        }
        f0 q = q(g0Var, x7Var, str);
        if (q != null) {
            if (x7Var != null) {
                l = x7Var.a;
            } else {
                l = null;
            }
            q.i = l;
        }
        if (q != null) {
            if (x7Var != null) {
                str2 = x7Var.c;
            }
            q.e = str2;
        }
        return q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(String str, BehaviorSubject behaviorSubject, Throwable th) {
        j.a.b("RelationSeriesDataService", "[preload] preload relation series data failed", th);
        b.remove(str);
        behaviorSubject.onError(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource k(g0 g0Var, f0 f0Var, wl it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        bc4.b.d(bc4.b.a, it2.a, it2.b, it2.c, false, 0, 24, (Object) null);
        g gVar = a;
        f0 p = gVar.p(g0Var, it2);
        if (p != null) {
            gVar.g(f0Var, p);
            com.bytedance.kmp.rxkmp.b bVar = com.bytedance.kmp.rxkmp.b.a;
            Observable just = Observable.just(p);
            Intrinsics.checkNotNullExpressionValue(just, "just(t)");
            return just;
        }
        com.bytedance.kmp.rxkmp.b bVar2 = com.bytedance.kmp.rxkmp.b.a;
        Observable error = Observable.error(new Throwable("[loadMore] parse relation series data failed"));
        Intrinsics.checkNotNullExpressionValue(error, "error(throwable)");
        return error;
    }

    private final f0 q(g0 g0Var, x7 x7Var, String str) {
        boolean z;
        CandidateDataType candidateDataType;
        if (x7Var == null) {
            return null;
        }
        List list = x7Var.v;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<om0> list2 = x7Var.v;
        if (list2 != null) {
            for (om0 om0Var : list2) {
                Integer num = x7Var.G0;
                if (num != null) {
                    candidateDataType = jd4.a.a(num.intValue());
                } else {
                    candidateDataType = null;
                }
                arrayList.add(new gk4.h0(new jd4.c(om0Var, candidateDataType, false)));
            }
        }
        return new f0(g0Var.b, g0Var.c, arrayList, o(x7Var), null, x7Var.n2, Intrinsics.areEqual(x7Var.o2, Boolean.TRUE), str, null, 272, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(g0 g0Var, BehaviorSubject behaviorSubject, xl xlVar) {
        bc4.b.d(bc4.b.a, xlVar.a, xlVar.b, xlVar.c, false, 0, 24, (Object) null);
        g gVar = a;
        Intrinsics.checkNotNull(xlVar);
        f0 r = gVar.r(g0Var, xlVar);
        if (r != null) {
            j.a.d("RelationSeriesDataService", "[preload] preload success, data size = " + r.c.size());
            behaviorSubject.onNext(r);
        } else {
            behaviorSubject.onError(new Throwable("[preload] parse relation series data failed"));
        }
        return Unit.INSTANCE;
    }
}
