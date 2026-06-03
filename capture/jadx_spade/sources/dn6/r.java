package dn6;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.r2;
import kotlinx.serialization.internal.y1;
import kotlinx.serialization.internal.z1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class r {
    private static final r2<? extends Object> a;
    private static final r2<Object> b;
    private static final y1<? extends Object> c;
    private static final y1<Object> d;

    static {
        Covode.recordClassIndex(659792);
        a = kotlinx.serialization.internal.o.a(new Function1() { // from class: dn6.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                KSerializer k;
                k = r.k((KClass) obj);
                return k;
            }
        });
        b = kotlinx.serialization.internal.o.a(new Function1() { // from class: dn6.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                KSerializer l;
                l = r.l((KClass) obj);
                return l;
            }
        });
        c = kotlinx.serialization.internal.o.b(new Function2() { // from class: dn6.n
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                KSerializer g;
                g = r.g((KClass) obj, (List) obj2);
                return g;
            }
        });
        d = kotlinx.serialization.internal.o.b(new Function2() { // from class: dn6.o
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                KSerializer i;
                i = r.i((KClass) obj, (List) obj2);
                return i;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier h(List list) {
        return ((KType) list.get(0)).getClassifier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier j(List list) {
        return ((KType) list.get(0)).getClassifier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer k(KClass it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        KSerializer e = s.e(it2);
        if (e == null) {
            if (z1.l(it2)) {
                return new e(it2);
            }
            return null;
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer l(KClass it2) {
        KSerializer u;
        Intrinsics.checkNotNullParameter(it2, "it");
        kotlinx.serialization.internal.b e = s.e(it2);
        if (e == null) {
            if (z1.l(it2)) {
                e = new e(it2);
            } else {
                e = null;
            }
        }
        if (e == null || (u = en6.a.u(e)) == null) {
            return null;
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer g(KClass clazz, final List types) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List<KSerializer<Object>> g = s.g(kotlinx.serialization.modules.d.a(), types, true);
        Intrinsics.checkNotNull(g);
        return s.b(clazz, g, new Function0() { // from class: dn6.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KClassifier h;
                h = r.h(types);
                return h;
            }
        });
    }

    public static final KSerializer<Object> m(KClass<Object> clazz, boolean z) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!z) {
            KSerializer<Object> a2 = a.a(clazz);
            if (a2 == null) {
                return null;
            }
            return a2;
        }
        return b.a(clazz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer i(KClass clazz, final List types) {
        KSerializer u;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List<KSerializer<Object>> g = s.g(kotlinx.serialization.modules.d.a(), types, true);
        Intrinsics.checkNotNull(g);
        KSerializer<? extends Object> b2 = s.b(clazz, g, new Function0() { // from class: dn6.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KClassifier j;
                j = r.j(types);
                return j;
            }
        });
        if (b2 == null || (u = en6.a.u(b2)) == null) {
            return null;
        }
        return u;
    }

    public static final Object n(KClass<Object> clazz, List<? extends KType> types, boolean z) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        if (!z) {
            return c.a(clazz, types);
        }
        return d.a(clazz, types);
    }
}
