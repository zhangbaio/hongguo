package dl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.http.exception.ErrorCodeException;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.utils.g0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import dl4.b;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public static final a f;
    public static final int g;
    private final rl4.c a;
    private final com.dragon.read.kmp.i b;
    private ProfileTab c;
    private final g d;
    public b e;

    public static final class a {
        static {
            Covode.recordClassIndex(608081);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608080);
        f = new a(null);
        g = 8;
    }

    public final void y() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.onDestroy();
        }
    }

    public final boolean r() {
        Boolean bool;
        this.b.d("hasMore: profileTab = " + this.c);
        b bVar = this.e;
        if (bVar != null) {
            bool = Boolean.valueOf(bVar.k());
        } else {
            bool = null;
        }
        return g0.a(bool);
    }

    public final boolean x() {
        Boolean bool;
        this.b.d("locatePostExit: profileTab = " + this.c);
        b bVar = this.e;
        if (bVar != null) {
            bool = Boolean.valueOf(bVar.f());
        } else {
            bool = null;
        }
        return g0.a(bool);
    }

    public final boolean z() {
        Boolean bool;
        this.b.d("onlyOnePage: profileTab = " + this.c);
        b bVar = this.e;
        if (bVar != null) {
            bool = bVar.d();
        } else {
            bool = null;
        }
        return g0.b(bool);
    }

    public final Single<List<Object>> s() {
        Single<List<Object>> just;
        rl4.c cVar = this.a;
        String str = cVar.i;
        FilterOptionHeaderType filterOptionHeaderType = cVar.j;
        this.b.d("loadMoreVideoList: profileTab = " + this.c + ", targetUserId = " + str);
        final long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        b bVar = this.e;
        if (bVar == null || (just = bVar.a(str, filterOptionHeaderType)) == null) {
            com.bytedance.kmp.rxkmp.c cVar2 = com.bytedance.kmp.rxkmp.c.a;
            just = Single.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "just(t)");
        }
        final Function1 function1 = new Function1() { // from class: dl4.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t;
                t = r.t(epochMilliseconds, this, (Throwable) obj);
                return t;
            }
        };
        Single<List<Object>> doOnError = just.doOnError(new Consumer() { // from class: dl4.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r.u(Function1.this, obj);
            }
        });
        final Function1 function12 = new Function1() { // from class: dl4.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List v;
                v = r.v(epochMilliseconds, this, (List) obj);
                return v;
            }
        };
        Single map = doOnError.map(new Function() { // from class: dl4.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List w;
                w = r.w(Function1.this, obj);
                return w;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    public r(rl4.c guestProfileTabParams) {
        Intrinsics.checkNotNullParameter(guestProfileTabParams, "guestProfileTabParams");
        this.a = guestProfileTabParams;
        this.b = new com.dragon.read.kmp.i("SeriesGuestProfileOneTabPresenter");
        g gVar = new g();
        this.d = gVar;
        this.c = guestProfileTabParams.b;
        b b = gVar.b(guestProfileTabParams);
        this.e = b;
        if (b != null) {
            b.c(guestProfileTabParams.t);
        }
    }

    public final Single<List<Object>> k(boolean z) {
        Single<List<Object>> just;
        b bVar;
        rl4.c cVar = this.a;
        final String str = cVar.i;
        String str2 = cVar.t;
        final FilterOptionHeaderType filterOptionHeaderType = cVar.j;
        this.b.d("fetchVideoList: profileTab = " + this.c + ", targetUserId = " + str + ", fromFilterOption = " + z);
        final long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        if (z && (bVar = this.e) != null) {
            bVar.reset();
        }
        b bVar2 = this.e;
        if (bVar2 == null || (just = bVar2.b(str, str2, filterOptionHeaderType)) == null) {
            com.bytedance.kmp.rxkmp.c cVar2 = com.bytedance.kmp.rxkmp.c.a;
            just = Single.just(new ArrayList());
            Intrinsics.checkNotNullExpressionValue(just, "just(t)");
        }
        final Function1 function1 = new Function1() { // from class: dl4.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List l;
                l = r.l(r.this, str, filterOptionHeaderType, (List) obj);
                return l;
            }
        };
        Single<R> map = just.map(new Function() { // from class: dl4.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m;
                m = r.m(Function1.this, obj);
                return m;
            }
        });
        final Function1 function12 = new Function1() { // from class: dl4.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n;
                n = r.n(epochMilliseconds, this, (Throwable) obj);
                return n;
            }
        };
        Single doOnError = map.doOnError(new Consumer() { // from class: dl4.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r.o(Function1.this, obj);
            }
        });
        final Function1 function13 = new Function1() { // from class: dl4.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List p;
                p = r.p(epochMilliseconds, this, (List) obj);
                return p;
            }
        };
        Single<List<Object>> map2 = doOnError.map(new Function() { // from class: dl4.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List q;
                q = r.q(Function1.this, obj);
                return q;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "map(...)");
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List q(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List w(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(long j, r rVar, Throwable th) {
        int i;
        Integer num;
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds() - j;
        if (th instanceof ErrorCodeException) {
            i = ((ErrorCodeException) th).getCode();
        } else {
            i = -1;
        }
        yk4.b bVar = yk4.b.a;
        Integer valueOf = Integer.valueOf(i);
        String message = th.getMessage();
        ProfileTab profileTab = rVar.c;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        bVar.f(valueOf, message, epochMilliseconds, num, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List p(long j, r rVar, List it2) {
        Integer num;
        Intrinsics.checkNotNullParameter(it2, "it");
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds() - j;
        yk4.b bVar = yk4.b.a;
        ProfileTab profileTab = rVar.c;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        bVar.f(0, "", epochMilliseconds, num, false);
        return it2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(long j, r rVar, Throwable th) {
        int i;
        Integer num;
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds() - j;
        if (th instanceof ErrorCodeException) {
            i = ((ErrorCodeException) th).getCode();
        } else {
            i = -1;
        }
        yk4.b bVar = yk4.b.a;
        Integer valueOf = Integer.valueOf(i);
        String message = th.getMessage();
        ProfileTab profileTab = rVar.c;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        bVar.f(valueOf, message, epochMilliseconds, num, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List v(long j, r rVar, List it2) {
        Integer num;
        Intrinsics.checkNotNullParameter(it2, "it");
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds() - j;
        yk4.b bVar = yk4.b.a;
        ProfileTab profileTab = rVar.c;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        bVar.f(0, "", epochMilliseconds, num, true);
        return it2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List l(r rVar, String str, FilterOptionHeaderType filterOptionHeaderType, List it2) {
        List emptyList;
        Single a2;
        Intrinsics.checkNotNullParameter(it2, "it");
        ArrayList arrayList = new ArrayList(it2);
        int i = 0;
        while (true) {
            if (!rVar.r() || !(!arrayList.isEmpty()) || arrayList.size() >= 9) {
                break;
            }
            if (i > 9) {
                com.dragon.read.kmp.i.c(rVar.b, "fetchVideoList: profileTab = " + rVar.c + ", targetUserId = " + str + ", reach max times", (Throwable) null, 2, (Object) null);
                break;
            }
            int i2 = i + 1;
            rVar.b.d("fetchVideoList: profileTab = " + rVar.c + ", targetUserId = " + str + ", fetch again because first page size less than 9, fetchTimes = " + i2);
            b bVar = rVar.e;
            if (bVar == null || (a2 = b.a.a(bVar, str, null, filterOptionHeaderType, 2, null)) == null || (emptyList = (List) a2.blockingGet()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            com.dragon.read.kmp.i.f(rVar.b, "fetchVideoList: profileTab = " + rVar.c + ", targetUserId = " + str + ", fetch again next page size is " + emptyList.size() + ", fetchTimes = " + i2, (Throwable) null, 2, (Object) null);
            arrayList.addAll(emptyList);
            i = i2;
        }
        return arrayList;
    }
}
