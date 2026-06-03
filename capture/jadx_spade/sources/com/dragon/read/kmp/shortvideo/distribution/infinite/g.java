package com.dragon.read.kmp.shortvideo.distribution.infinite;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.shortvideo.distribution.infinite.f;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public final MutableState<List<d>> a;
    public final MutableState<Set<String>> b;
    public final List<c> c;
    public Integer d;
    public Set<f> e;
    public boolean f;
    public final MutableState<String> g;
    public final MutableState<String> h;

    static {
        Covode.recordClassIndex(609029);
    }

    public g() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "InfiniteFilterData(outFilterData=" + this.a + ", selectItems=" + this.b + ", innerFilterData=" + this.c + ')';
    }

    public final void c() {
        this.b.setValue(new LinkedHashSet());
    }

    public final Integer l() {
        int i = 0;
        for (Object obj : (Iterable) this.a.getValue()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (n(((d) obj).b.b)) {
                return Integer.valueOf(i);
            }
            i = i2;
        }
        return null;
    }

    public final d k() {
        int i = 0;
        for (Object obj : this.c) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int i3 = 0;
            for (Object obj2 : ((c) obj).c) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                d dVar = (d) obj2;
                if (n(dVar.b.b)) {
                    return dVar;
                }
                i3 = i4;
            }
            i = i2;
        }
        return null;
    }

    public final String m() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((Iterable) this.a.getValue()).iterator();
        int i = 0;
        while (true) {
            String str = "";
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            d dVar = (d) next;
            if (n(dVar.b.b)) {
                String str2 = dVar.b.b;
                if (str2 != null) {
                    str = str2;
                }
                arrayList.add(str);
            }
            i = i2;
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }

    public final boolean n(String str) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains((Iterable) this.b.getValue(), str);
        return contains;
    }

    public final void b(String item) {
        Intrinsics.checkNotNullParameter(item, "item");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll((Collection) this.b.getValue());
        linkedHashSet.add(item);
        this.b.setValue(linkedHashSet);
    }

    public final void d(List<c> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        List<c> list2 = this.c;
        list2.clear();
        list2.addAll(list);
    }

    public final void f(d filterItem) {
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        Iterator<T> it2 = this.e.iterator();
        while (it2.hasNext()) {
            f.a.d((f) it2.next(), filterItem, null, 2, null);
        }
    }

    public final void g(List<d> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        this.a.setValue(list);
    }

    public final void h(d filterItem) {
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        Iterator<T> it2 = this.e.iterator();
        while (it2.hasNext()) {
            ((f) it2.next()).d(filterItem);
        }
    }

    public final void i(d filterItem) {
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        Iterator<T> it2 = this.e.iterator();
        while (it2.hasNext()) {
            ((f) it2.next()).e(filterItem);
        }
    }

    public final void o(f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.e.contains(listener)) {
            this.e.add(listener);
        }
    }

    public final void p(f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.e.contains(listener)) {
            this.e.remove(listener);
        }
    }

    public final void a(Set<String> set) {
        boolean z;
        Set<String> set2 = set;
        if (set2 != null && !set2.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll((Collection) this.b.getValue());
        linkedHashSet.addAll(set2);
        this.b.setValue(linkedHashSet);
    }

    public final void j(boolean z, FilterType filterType) {
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        Iterator<T> it2 = this.e.iterator();
        while (it2.hasNext()) {
            ((f) it2.next()).b(z, filterType);
        }
    }

    public final void e(d filterItem, FilterType filterType) {
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        Iterator<T> it2 = this.e.iterator();
        while (it2.hasNext()) {
            ((f) it2.next()).a(filterItem, filterType);
        }
    }

    public g(MutableState<List<d>> outFilterData, MutableState<Set<String>> selectItems, List<c> innerFilterData) {
        Intrinsics.checkNotNullParameter(outFilterData, "outFilterData");
        Intrinsics.checkNotNullParameter(selectItems, "selectItems");
        Intrinsics.checkNotNullParameter(innerFilterData, "innerFilterData");
        this.a = outFilterData;
        this.b = selectItems;
        this.c = innerFilterData;
        this.e = new LinkedHashSet();
        this.g = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ g(MutableState mutableState, MutableState mutableState2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt.mutableStateOf$default(new ArrayList(), (SnapshotMutationPolicy) null, 2, (Object) null) : mutableState, (i & 2) != 0 ? SnapshotStateKt.mutableStateOf$default(new LinkedHashSet(), (SnapshotMutationPolicy) null, 2, (Object) null) : mutableState2, (i & 4) != 0 ? new ArrayList() : list);
    }
}
