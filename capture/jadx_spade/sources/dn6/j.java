package dn6;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.a;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.encoding.Encoder;

@InternalSerializationApi
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j<T> extends kotlinx.serialization.internal.b<T> {
    private final KClass<T> a;
    private List<? extends Annotation> b;
    private final Lazy c;
    private final Map<KClass<? extends T>, KSerializer<? extends T>> d;
    private final Map<String, KSerializer<? extends T>> e;

    static {
        Covode.recordClassIndex(659783);
    }

    public KClass<T> g() {
        return this.a;
    }

    public static final class a implements Grouping<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>, String> {
        final /* synthetic */ Iterable a;

        @Override // kotlin.collections.Grouping
        public Iterator<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>> sourceIterator() {
            return this.a.iterator();
        }

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // kotlin.collections.Grouping
        public String keyOf(Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> entry) {
            return entry.getValue().getDescriptor().getSerialName();
        }
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor k(String str, final j jVar) {
        return SerialDescriptorsKt.buildSerialDescriptor(str, a.b.a, new SerialDescriptor[0], new Function1() { // from class: dn6.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l;
                l = j.l(j.this, (fn6.a) obj);
                return l;
            }
        });
    }

    public DeserializationStrategy<T> e(kotlinx.serialization.encoding.c decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        KSerializer<? extends T> kSerializer = this.e.get(str);
        if (kSerializer != null) {
            return kSerializer;
        }
        return super.e(decoder, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(j jVar, fn6.a buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        for (Map.Entry<String, KSerializer<? extends T>> entry : jVar.e.entrySet()) {
            fn6.a.b(buildSerialDescriptor, entry.getKey(), entry.getValue().getDescriptor(), null, false, 12, null);
        }
        return Unit.INSTANCE;
    }

    public SerializationStrategy<T> f(Encoder encoder, T value) {
        KSerializer<? extends T> f;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        KSerializer<? extends T> kSerializer = this.d.get(Reflection.getOrCreateKotlinClass(value.getClass()));
        if (kSerializer != null) {
            f = kSerializer;
        } else {
            f = super.f(encoder, value);
        }
        if (f == null) {
            return null;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final j jVar, fn6.a buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        fn6.a.b(buildSerialDescriptor, "type", en6.a.I(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        fn6.a.b(buildSerialDescriptor, "value", SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Sealed<" + jVar.g().getSimpleName() + '>', d.a.a, new SerialDescriptor[0], new Function1() { // from class: dn6.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m;
                m = j.m(j.this, (fn6.a) obj);
                return m;
            }
        }), null, false, 12, null);
        buildSerialDescriptor.c(jVar.b);
        return Unit.INSTANCE;
    }

    public j(final String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, KSerializer<? extends T>[] subclassSerializers) {
        Lazy lazy;
        List zip;
        Map<KClass<? extends T>, KSerializer<? extends T>> map;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        this.a = baseClass;
        this.b = CollectionsKt__CollectionsKt.emptyList();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: dn6.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SerialDescriptor k;
                k = j.k(serialName, this);
                return k;
            }
        });
        this.c = lazy;
        if (subclasses.length == subclassSerializers.length) {
            zip = ArraysKt___ArraysKt.zip(subclasses, subclassSerializers);
            map = MapsKt__MapsKt.toMap(zip);
            this.d = map;
            Grouping aVar = new a(map.entrySet());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<T> sourceIterator = aVar.sourceIterator();
            while (sourceIterator.hasNext()) {
                T next = sourceIterator.next();
                Object keyOf = aVar.keyOf(next);
                Object obj = linkedHashMap.get(keyOf);
                if (obj == null) {
                    linkedHashMap.containsKey(keyOf);
                }
                Map.Entry entry = (Map.Entry) next;
                Map.Entry entry2 = (Map.Entry) obj;
                String str = (String) keyOf;
                if (entry2 == null) {
                    linkedHashMap.put(keyOf, entry);
                } else {
                    throw new IllegalStateException(("Multiple sealed subclasses of '" + g() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
                }
            }
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
            }
            this.e = linkedHashMap2;
            return;
        }
        throw new IllegalArgumentException("All subclasses of sealed class " + g().getSimpleName() + " should be marked @Serializable");
    }
}
