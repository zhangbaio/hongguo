package dn6;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.a1;
import kotlinx.serialization.internal.a2;
import kotlinx.serialization.internal.c1;
import kotlinx.serialization.internal.n2;
import kotlinx.serialization.internal.o0;
import kotlinx.serialization.internal.q0;
import kotlinx.serialization.internal.z1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class u {
    static {
        Covode.recordClassIndex(659795);
    }

    public static final KSerializer<Object> g(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return s.d(kotlinx.serialization.modules.d.a(), type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClassifier j(List list) {
        return ((KType) list.get(0)).getClassifier();
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> k(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer<T> b = z1.b(kClass);
        if (b == null) {
            return n2.b(kClass);
        }
        return b;
    }

    private static final <T> KSerializer<T> e(KSerializer<T> kSerializer, boolean z) {
        if (z) {
            return en6.a.u(kSerializer);
        }
        Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer<Object> l(kotlinx.serialization.modules.c cVar, KType type) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return i(cVar, type, false);
    }

    private static final KSerializer<? extends Object> c(KClass<Object> kClass, List<? extends KSerializer<Object>> list) {
        KSerializer[] kSerializerArr = (KSerializer[]) list.toArray(new KSerializer[0]);
        return z1.d(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final KSerializer<?> d(kotlinx.serialization.modules.c module, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        KSerializer<?> c = kotlinx.serialization.modules.c.c(module, kClass, null, 2, null);
        if (c != null) {
            return c;
        }
        a2.f(kClass);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<Object> h(kotlinx.serialization.modules.c cVar, KType type) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> i = i(cVar, type, true);
        if (i != null) {
            return i;
        }
        z1.p(a2.c(type));
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<? extends Object> f(KClass<Object> kClass, List<? extends KSerializer<Object>> serializers, Function0<? extends KClassifier> elementClassifierIfArray) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(serializers, "serializers");
        Intrinsics.checkNotNullParameter(elementClassifierIfArray, "elementClassifierIfArray");
        KSerializer<? extends Object> b = b(kClass, serializers, elementClassifierIfArray);
        if (b == null) {
            return c(kClass, serializers);
        }
        return b;
    }

    public static final List<KSerializer<Object>> m(kotlinx.serialization.modules.c cVar, List<? extends KType> typeArguments, boolean z) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (z) {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(typeArguments, 10));
            Iterator<T> it2 = typeArguments.iterator();
            while (it2.hasNext()) {
                arrayList.add(s.d(cVar, (KType) it2.next()));
            }
        } else {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(typeArguments, 10));
            Iterator<T> it4 = typeArguments.iterator();
            while (it4.hasNext()) {
                KSerializer<Object> f = s.f(cVar, (KType) it4.next());
                if (f == null) {
                    return null;
                }
                arrayList.add(f);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlinx.serialization.KSerializer<java.lang.Object> i(kotlinx.serialization.modules.c r6, kotlin.reflect.KType r7, boolean r8) {
        /*
            kotlin.reflect.KClass r0 = kotlinx.serialization.internal.a2.c(r7)
            boolean r1 = r7.isMarkedNullable()
            java.util.List r7 = r7.getArguments()
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r3)
            r2.<init>(r3)
            java.util.Iterator r7 = r7.iterator()
        L1b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L2f
            java.lang.Object r3 = r7.next()
            kotlin.reflect.KTypeProjection r3 = (kotlin.reflect.KTypeProjection) r3
            kotlin.reflect.KType r3 = kotlinx.serialization.internal.a2.g(r3)
            r2.add(r3)
            goto L1b
        L2f:
            boolean r7 = r2.isEmpty()
            r3 = 2
            r4 = 0
            if (r7 == 0) goto L49
            boolean r7 = kotlinx.serialization.internal.z1.l(r0)
            if (r7 == 0) goto L44
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.modules.c.c(r6, r0, r4, r3, r4)
            if (r7 == 0) goto L44
            goto L4f
        L44:
            kotlinx.serialization.KSerializer r7 = dn6.r.m(r0, r1)
            goto L5e
        L49:
            boolean r7 = r6.d()
            if (r7 == 0) goto L51
        L4f:
            r7 = r4
            goto L5e
        L51:
            java.lang.Object r7 = dn6.r.n(r0, r2, r1)
            boolean r5 = kotlin.Result.m779isFailureimpl(r7)
            if (r5 == 0) goto L5c
            r7 = r4
        L5c:
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
        L5e:
            if (r7 == 0) goto L61
            return r7
        L61:
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L82
            kotlinx.serialization.KSerializer r7 = dn6.s.e(r0)
            if (r7 != 0) goto La7
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.modules.c.c(r6, r0, r4, r3, r4)
            if (r7 != 0) goto La7
            boolean r6 = kotlinx.serialization.internal.z1.l(r0)
            if (r6 == 0) goto L80
            dn6.e r6 = new dn6.e
            r6.<init>(r0)
        L7e:
            r7 = r6
            goto La7
        L80:
            r7 = r4
            goto La7
        L82:
            java.util.List r7 = dn6.s.g(r6, r2, r8)
            if (r7 != 0) goto L89
            return r4
        L89:
            dn6.t r8 = new dn6.t
            r8.<init>()
            kotlinx.serialization.KSerializer r8 = dn6.s.b(r0, r7, r8)
            if (r8 != 0) goto La6
            kotlinx.serialization.KSerializer r7 = r6.b(r0, r7)
            if (r7 != 0) goto La7
            boolean r6 = kotlinx.serialization.internal.z1.l(r0)
            if (r6 == 0) goto L80
            dn6.e r6 = new dn6.e
            r6.<init>(r0)
            goto L7e
        La6:
            r7 = r8
        La7:
            if (r7 == 0) goto Lad
            kotlinx.serialization.KSerializer r4 = e(r7, r1)
        Lad:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dn6.u.i(kotlinx.serialization.modules.c, kotlin.reflect.KType, boolean):kotlinx.serialization.KSerializer");
    }

    private static final KSerializer<? extends Object> b(KClass<Object> kClass, List<? extends KSerializer<Object>> list, Function0<? extends KClassifier> function0) {
        if (!Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Collection.class)) && !Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(List.class)) && !Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(List.class)) && !Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(ArrayList.class))) {
            if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(HashSet.class))) {
                return new q0(list.get(0));
            }
            if (!Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Set.class)) && !Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Set.class)) && !Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(HashMap.class))) {
                    return new o0(list.get(0), list.get(1));
                }
                if (!Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.class)) && !Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.class)) && !Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
                    if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.Entry.class))) {
                        return en6.a.j(list.get(0), list.get(1));
                    }
                    if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Pair.class))) {
                        return en6.a.m(list.get(0), list.get(1));
                    }
                    if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Triple.class))) {
                        return en6.a.p(list.get(0), list.get(1), list.get(2));
                    }
                    if (z1.o(kClass)) {
                        KClassifier invoke = function0.invoke();
                        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                        return en6.a.a((KClass) invoke, list.get(0));
                    }
                    return null;
                }
                return new a1(list.get(0), list.get(1));
            }
            return new c1(list.get(0));
        }
        return new kotlinx.serialization.internal.f(list.get(0));
    }
}
