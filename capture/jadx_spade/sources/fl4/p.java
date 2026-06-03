package fl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.v;
import gk4.j0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.serialization.internal.a1;
import kotlinx.serialization.internal.v2;
import yn0.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public static final p a;
    private static final Lazy b;
    private static final Lazy c;
    private static final Lazy d;
    private static final Lazy e;
    public static final int f;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xn0.b t() {
        return xn0.c.a("SeriesFollowCache");
    }

    private final b l() {
        return (b) d.getValue();
    }

    private final Map<String, r> m() {
        return (Map) c.getValue();
    }

    private final xn0.b o() {
        return (xn0.b) b.getValue();
    }

    private final i p() {
        return (i) e.getValue();
    }

    public final void h() {
        m().clear();
        o().storeString("follow_record", "");
    }

    public final void i() {
        p().a.clear();
        p().b = 0L;
        o().storeString("follow_user_filter", "");
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Covode.recordClassIndex(608096);
        a = new p();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: fl4.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xn0.b t;
                t = p.t();
                return t;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: fl4.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Map k;
                k = p.k();
                return k;
            }
        });
        c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: fl4.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b j;
                j = p.j();
                return j;
            }
        });
        d = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: fl4.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                i u;
                u = p.u();
                return u;
            }
        });
        e = lazy4;
        f = 8;
    }

    public final void g() {
        l().b = 0L;
        l().d(TuplesKt.to(com.dragon.read.kmp.utils.o.a.e(), 0));
        x(l());
    }

    public final List<String> n() {
        int i = j0.Companion.a().g;
        int size = p().a.size();
        boolean z = false;
        if (1 <= i && i < size) {
            z = true;
        }
        if (z) {
            return CollectionsKt___CollectionsKt.toList(p().a.subList(size - i, size));
        }
        return CollectionsKt___CollectionsKt.toList(p().a);
    }

    public final boolean s() {
        j0 a2 = j0.Companion.a();
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        long j = p().b;
        if (j > 0 && epochMilliseconds - j < a2.h * 1000) {
            return false;
        }
        p().b = epochMilliseconds;
        z(epochMilliseconds);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b j() {
        boolean z;
        Object m773constructorimpl;
        String string = a.o().getString("follow_frequency", "");
        v vVar = v.a;
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
                m773constructorimpl = Result.m773constructorimpl(c2.c(en6.a.u(b.Companion.serializer()), string));
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
        b bVar = (b) obj;
        if (bVar == null) {
            return new b(TuplesKt.to(com.dragon.read.kmp.utils.o.a.e(), 0), 0L);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map k() {
        boolean z;
        Object m773constructorimpl;
        String string = a.o().getString("follow_record", "");
        v vVar = v.a;
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
                m773constructorimpl = Result.m773constructorimpl(c2.c(en6.a.u(new a1(v2.a, r.Companion.serializer())), string));
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
        Map map = (Map) obj;
        if (map == null) {
            return new LinkedHashMap();
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i u() {
        boolean z;
        Object m773constructorimpl;
        String string = a.o().getString("follow_user_filter", "");
        v vVar = v.a;
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
                m773constructorimpl = Result.m773constructorimpl(c2.c(en6.a.u(i.Companion.serializer()), string));
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
        i iVar = (i) obj;
        if (iVar == null) {
            return new i((List) null, 0L, 3, (DefaultConstructorMarker) null);
        }
        return iVar;
    }

    public final boolean r(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        j0 a2 = j0.Companion.a();
        r rVar = m().get(userId);
        if (rVar == null) {
            return false;
        }
        int size = rVar.b.size();
        int i = a2.e;
        if (i <= 0 || size < i) {
            return false;
        }
        return true;
    }

    private final void x(b bVar) {
        Object m773constructorimpl;
        String a2;
        try {
            Result.Companion companion = Result.Companion;
            v vVar = v.a;
            if (bVar == null) {
                a2 = "";
            } else {
                gn6.a c2 = com.dragon.read.kmp.base.h.c();
                c2.getSerializersModule();
                a2 = c2.a(b.Companion.serializer(), bVar);
            }
            m773constructorimpl = Result.m773constructorimpl(a2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        String str = (String) m773constructorimpl;
        if (str != null) {
            a.o().storeString("follow_frequency", str);
        }
    }

    private final void y(r rVar) {
        Object m773constructorimpl;
        String a2;
        m().put(rVar.a, rVar);
        try {
            Result.Companion companion = Result.Companion;
            v vVar = v.a;
            Map<String, r> m = m();
            if (m == null) {
                a2 = "";
            } else {
                gn6.a c2 = com.dragon.read.kmp.base.h.c();
                c2.getSerializersModule();
                a2 = c2.a(new a1(v2.a, r.Companion.serializer()), m);
            }
            m773constructorimpl = Result.m773constructorimpl(a2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        String str = (String) m773constructorimpl;
        if (str != null) {
            a.o().storeString("follow_record", str);
        }
    }

    private final void z(long j) {
        Object m773constructorimpl;
        String a2;
        p().b = j;
        try {
            Result.Companion companion = Result.Companion;
            v vVar = v.a;
            i p = p();
            if (p == null) {
                a2 = "";
            } else {
                gn6.a c2 = com.dragon.read.kmp.base.h.c();
                c2.getSerializersModule();
                a2 = c2.a(i.Companion.serializer(), p);
            }
            m773constructorimpl = Result.m773constructorimpl(a2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        String str = (String) m773constructorimpl;
        if (str != null) {
            a.o().storeString("follow_user_filter", str);
        }
    }

    public final void v(String userId) {
        List mutableListOf;
        r put;
        List<s> list;
        List<s> list2;
        Intrinsics.checkNotNullParameter(userId, "userId");
        final long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        if (m().containsKey(userId)) {
            put = m().get(userId);
            if (put != null && (list2 = put.b) != null) {
                CollectionsKt__MutableCollectionsKt.removeAll((List) list2, new Function1() { // from class: fl4.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean w;
                        w = p.w(epochMilliseconds, (s) obj);
                        return Boolean.valueOf(w);
                    }
                });
            }
            if (put != null && (list = put.b) != null) {
                list.add(new s(epochMilliseconds));
            }
        } else {
            Map<String, r> m = m();
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new s(epochMilliseconds));
            put = m.put(userId, new r(userId, mutableListOf, 0L));
        }
        if (put != null) {
            a.y(put);
        }
    }

    public final void f(List<String> list) {
        Object m773constructorimpl;
        String a2;
        Intrinsics.checkNotNullParameter(list, "list");
        p().a.addAll(list);
        int i = j0.Companion.a().g;
        if (i > 0 && p().a.size() > i) {
            List list2 = CollectionsKt___CollectionsKt.toList(p().a.subList(p().a.size() - i, p().a.size()));
            p().a.clear();
            p().a.addAll(list2);
        }
        try {
            Result.Companion companion = Result.Companion;
            v vVar = v.a;
            i p = p();
            if (p == null) {
                a2 = "";
            } else {
                gn6.a c2 = com.dragon.read.kmp.base.h.c();
                c2.getSerializersModule();
                a2 = c2.a(i.Companion.serializer(), p);
            }
            m773constructorimpl = Result.m773constructorimpl(a2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        String str = (String) m773constructorimpl;
        if (str != null) {
            a.o().storeString("follow_user_filter", str);
        }
    }

    public final boolean q(String targetUserId) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        String e2 = com.dragon.read.kmp.utils.o.a.e();
        j0 a2 = j0.Companion.a();
        Pair<String, Integer> pair = l().a;
        String component1 = pair.component1();
        int intValue = pair.component2().intValue();
        if (!Intrinsics.areEqual(component1, e2)) {
            l().d(TuplesKt.to(e2, 0));
        } else if (intValue >= a2.a) {
            return false;
        }
        long j = l().b;
        if (j > 0 && epochMilliseconds - j < a2.b * 1000) {
            return false;
        }
        r rVar = m().get(targetUserId);
        if (rVar == null) {
            rVar = new r(targetUserId, (List) null, 0L, 6, (DefaultConstructorMarker) null);
        }
        long j2 = rVar.c;
        if (j2 > 0 && epochMilliseconds - j2 < a2.c * 1000) {
            return false;
        }
        rVar.c = epochMilliseconds;
        y(rVar);
        l().d(TuplesKt.to(e2, Integer.valueOf(l().a.getSecond().intValue() + 1)));
        l().b = epochMilliseconds;
        x(l());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(long j, s it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        if (j - it2.a > j0.Companion.a().d * 24 * 60 * 60 * 1000) {
            return true;
        }
        return false;
    }
}
