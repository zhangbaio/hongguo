package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.c0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class OptionalFormatStructure<T> implements q<T> {
    public final String a;
    public final n<T> b;
    private final List<a<T, ? extends Object>> c;

    static {
        Covode.recordClassIndex(659611);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Optional(" + this.a + ", " + this.b + ')';
    }

    @Override // kotlinx.datetime.internal.format.n
    public kotlinx.datetime.internal.format.parser.u<T> a() {
        List listOf;
        List listOf2;
        List listOf3;
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        kotlinx.datetime.internal.format.parser.u[] uVarArr = new kotlinx.datetime.internal.format.parser.u[2];
        uVarArr[0] = this.b.a();
        kotlinx.datetime.internal.format.parser.u[] uVarArr2 = new kotlinx.datetime.internal.format.parser.u[2];
        uVarArr2[0] = new j(this.a).a();
        if (this.c.isEmpty()) {
            listOf = CollectionsKt__CollectionsKt.emptyList();
        } else {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new c0(new Function1() { // from class: kotlinx.datetime.internal.format.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit d;
                    d = OptionalFormatStructure.d(OptionalFormatStructure.this, obj);
                    return d;
                }
            }));
        }
        uVarArr2[1] = new kotlinx.datetime.internal.format.parser.u(listOf, CollectionsKt__CollectionsKt.emptyList());
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) uVarArr2);
        uVarArr[1] = kotlinx.datetime.internal.format.parser.q.c(listOf2);
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) uVarArr);
        return new kotlinx.datetime.internal.format.parser.u<>(emptyList, listOf3);
    }

    @Override // kotlinx.datetime.internal.format.n
    public bn6.e<T> b() {
        List listOf;
        bn6.e<T> b = this.b.b();
        List<a<T, ? extends Object>> list = this.c;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            arrayList.add(new g(aVar.b, new OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1(aVar.a)));
        }
        s a2 = t.a(arrayList);
        if (a2 instanceof w) {
            return new bn6.c(this.a);
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(new OptionalFormatStructure$formatter$1(a2), new bn6.c(this.a)), TuplesKt.to(new OptionalFormatStructure$formatter$2(w.a), b)});
        return new bn6.b(listOf);
    }

    private static final class a<T, E> {
        public static final C0227a c;
        private final b<T, E> a;
        private final E b;

        static {
            Covode.recordClassIndex(659612);
            c = new C0227a(null);
        }

        public /* synthetic */ a(b bVar, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(bVar, obj);
        }

        /* renamed from: kotlinx.datetime.internal.format.OptionalFormatStructure$a$a, reason: collision with other inner class name */
        public static final class C0227a {
            static {
                Covode.recordClassIndex(659613);
            }

            private C0227a() {
            }

            public /* synthetic */ C0227a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final <T, E> a<T, E> a(m<? super T, E> field) {
                boolean z;
                Intrinsics.checkNotNullParameter(field, "field");
                E a = field.a();
                if (a != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return new a<>(field.b(), a, null);
                }
                throw new IllegalArgumentException(("The field '" + field.getName() + "' does not define a default value").toString());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private a(b<? super T, E> bVar, E e) {
            this.a = bVar;
            this.b = e;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof OptionalFormatStructure) {
            OptionalFormatStructure optionalFormatStructure = (OptionalFormatStructure) obj;
            if (Intrinsics.areEqual(this.a, optionalFormatStructure.a) && Intrinsics.areEqual(this.b, optionalFormatStructure.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(OptionalFormatStructure this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (a<T, ? extends Object> aVar : this$0.c) {
            ((a) aVar).a.c(obj, ((a) aVar).b);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OptionalFormatStructure(String onZero, n<? super T> format) {
        List b;
        List distinct;
        Intrinsics.checkNotNullParameter(onZero, "onZero");
        Intrinsics.checkNotNullParameter(format, "format");
        this.a = onZero;
        this.b = format;
        b = o.b(format);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(b, 10));
        Iterator<T> it2 = b.iterator();
        while (it2.hasNext()) {
            arrayList.add(((k) it2.next()).c());
        }
        distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(distinct, 10));
        Iterator<T> it4 = distinct.iterator();
        while (it4.hasNext()) {
            arrayList2.add(a.c.a((m) it4.next()));
        }
        this.c = arrayList2;
    }
}
