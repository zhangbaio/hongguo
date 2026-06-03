package kotlinx.serialization.descriptors;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.a2;
import kotlinx.serialization.internal.h2;
import kotlinx.serialization.internal.n;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c implements SerialDescriptor, n {
    private final String a;
    private final d b;
    private final int c;
    private final List<Annotation> d;
    private final Set<String> e;
    private final String[] f;
    private final SerialDescriptor[] g;
    private final List<Annotation>[] h;
    private final boolean[] i;
    private final Map<String, Integer> j;
    private final SerialDescriptor[] k;
    private final Lazy l;

    static {
        Covode.recordClassIndex(659821);
    }

    public Set<String> a() {
        return this.e;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public d getKind() {
        return this.b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.a;
    }

    public int hashCode() {
        return e();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return SerialDescriptor.a.c(this);
    }

    private final int e() {
        return ((Number) this.l.getValue()).intValue();
    }

    public String toString() {
        IntRange until;
        until = RangesKt___RangesKt.until(0, getElementsCount());
        return CollectionsKt___CollectionsKt.joinToString$default(until, ", ", getSerialName() + '(', ")", 0, null, new Function1() { // from class: fn6.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence f;
                f = kotlinx.serialization.descriptors.c.f(kotlinx.serialization.descriptors.c.this, ((Integer) obj).intValue());
                return f;
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(c cVar) {
        return h2.a(cVar, cVar.k);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getElementAnnotations(int i) {
        return this.h[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int i) {
        return this.g[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int i) {
        return this.f[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int i) {
        return this.i[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual(getSerialName(), serialDescriptor.getSerialName()) && Arrays.equals(this.k, ((c) obj).k) && getElementsCount() == serialDescriptor.getElementsCount()) {
                int elementsCount = getElementsCount();
                for (int i = 0; i < elementsCount; i++) {
                    if (Intrinsics.areEqual(getElementDescriptor(i).getSerialName(), serialDescriptor.getElementDescriptor(i).getSerialName()) && Intrinsics.areEqual(getElementDescriptor(i).getKind(), serialDescriptor.getElementDescriptor(i).getKind())) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f(c cVar, int i) {
        return cVar.getElementName(i) + ": " + cVar.getElementDescriptor(i).getSerialName();
    }

    public c(String serialName, d kind, int i, List<? extends SerialDescriptor> typeParameters, fn6.a builder) {
        HashSet hashSet;
        boolean[] booleanArray;
        Iterable<IndexedValue> withIndex;
        Map<String, Integer> map;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.a = serialName;
        this.b = kind;
        this.c = i;
        this.d = builder.b;
        hashSet = CollectionsKt___CollectionsKt.toHashSet(builder.c);
        this.e = hashSet;
        String[] strArr = (String[]) builder.c.toArray(new String[0]);
        this.f = strArr;
        this.g = a2.b(builder.e);
        this.h = (List[]) builder.f.toArray(new List[0]);
        booleanArray = CollectionsKt___CollectionsKt.toBooleanArray(builder.g);
        this.i = booleanArray;
        withIndex = ArraysKt___ArraysKt.withIndex(strArr);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10));
        for (IndexedValue indexedValue : withIndex) {
            arrayList.add(TuplesKt.to(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex())));
        }
        map = MapsKt__MapsKt.toMap(arrayList);
        this.j = map;
        this.k = a2.b(typeParameters);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: fn6.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int d;
                d = kotlinx.serialization.descriptors.c.d(kotlinx.serialization.descriptors.c.this);
                return Integer.valueOf(d);
            }
        });
        this.l = lazy;
    }
}
