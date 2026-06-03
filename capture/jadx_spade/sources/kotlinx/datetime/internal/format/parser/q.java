package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class q {
    static {
        Covode.recordClassIndex(659655);
    }

    public static final <T> u<T> c(List<? extends u<? super T>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        u uVar = new u(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList());
        if (!list.isEmpty()) {
            ListIterator<? extends u<? super T>> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                uVar = d(listIterator.previous(), uVar);
            }
        }
        return e(uVar, CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(l it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return "position " + it2.a + ": '" + it2.b.invoke() + '\'';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(List<l> list) {
        Appendable joinTo$default;
        if (list.size() == 1) {
            return "Position " + list.get(0).a + ": " + list.get(0).b.invoke();
        }
        joinTo$default = CollectionsKt___CollectionsKt.joinTo$default(list, new StringBuilder(list.size() * 33), ", ", "Errors: ", null, 0, null, new Function1() { // from class: kotlinx.datetime.internal.format.parser.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence g;
                g = q.g((l) obj);
                return g;
            }
        }, 56, null);
        String sb = ((StringBuilder) joinTo$default).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    private static final <T> u<T> d(u<? super T> uVar, u<? super T> uVar2) {
        if (uVar.b.isEmpty()) {
            return new u<>(CollectionsKt___CollectionsKt.plus((Collection) uVar.a, (Iterable) uVar2.a), uVar2.b);
        }
        List<r<? super T>> list = uVar.a;
        List<u<? super T>> list2 = uVar.b;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList.add(d((u) it2.next(), uVar2));
        }
        return new u<>(list, arrayList);
    }

    private static final <T> u<T> e(u<? super T> uVar, List<c0<T>> list) {
        Object firstOrNull;
        boolean z;
        boolean z2;
        Object firstOrNull2;
        u uVar2;
        List drop;
        Collection listOf;
        ArrayList arrayList = new ArrayList();
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        List list2 = null;
        for (r<? super T> rVar : uVar.a) {
            if (rVar instanceof k) {
                if (list2 != null) {
                    list2.addAll(((k) rVar).a);
                } else {
                    list2 = CollectionsKt___CollectionsKt.toMutableList(((k) rVar).a);
                }
            } else if (rVar instanceof c0) {
                mutableList.add(rVar);
            } else {
                if (list2 != null) {
                    arrayList.add(new k(list2));
                    list2 = null;
                }
                arrayList.add(rVar);
            }
        }
        List<u<? super T>> list3 = uVar.b;
        List<u> arrayList2 = new ArrayList();
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            u e = e((u) it2.next(), mutableList);
            if (e.a.isEmpty()) {
                listOf = e.b;
                if (listOf.isEmpty()) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(e);
                }
            } else {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(e);
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, listOf);
        }
        if (arrayList2.isEmpty()) {
            arrayList2 = CollectionsKt__CollectionsJVMKt.listOf(new u(mutableList, CollectionsKt__CollectionsKt.emptyList()));
        }
        if (list2 == null) {
            return new u<>(arrayList, arrayList2);
        }
        if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
            Iterator<T> it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ((u) it4.next()).a);
                r rVar2 = (r) firstOrNull;
                z = false;
                if (rVar2 != null && (rVar2 instanceof k)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            arrayList.add(new k(list2));
            return new u<>(arrayList, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        for (u uVar3 : arrayList2) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) uVar3.a);
            r rVar3 = (r) firstOrNull2;
            if (rVar3 instanceof k) {
                List listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new k(CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) ((k) rVar3).a)));
                drop = CollectionsKt___CollectionsKt.drop(uVar3.a, 1);
                uVar2 = new u(CollectionsKt___CollectionsKt.plus((Collection) listOf2, (Iterable) drop), uVar3.b);
            } else if (rVar3 == null) {
                uVar2 = new u(CollectionsKt__CollectionsJVMKt.listOf(new k(list2)), uVar3.b);
            } else {
                uVar2 = new u(CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt__CollectionsJVMKt.listOf(new k(list2)), (Iterable) uVar3.a), uVar3.b);
            }
            arrayList3.add(uVar2);
        }
        return new u<>(arrayList, arrayList3);
    }
}
