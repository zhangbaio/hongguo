package com.dragon.read.kmp.reader.detail.catalog;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    public static final int d;
    public final boolean a;
    public final boolean b;
    public final List<a> c;

    static {
        Covode.recordClassIndex(608381);
        d = 8;
    }

    public s() {
        this(false, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ s b(s sVar, boolean z, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sVar.a;
        }
        if ((i & 2) != 0) {
            z2 = sVar.b;
        }
        if ((i & 4) != 0) {
            list = sVar.c;
        }
        return sVar.a(z, z2, list);
    }

    public final s a(boolean z, boolean z2, List<a> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new s(z, z2, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.a == sVar.a && this.b == sVar.b && Intrinsics.areEqual(this.c, sVar.c);
    }

    public int hashCode() {
        return (((androidx.compose.animation.m.a(this.a) * 31) + androidx.compose.animation.m.a(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "BookDetailCatalogUiState(isVisible=" + this.a + ", isAscending=" + this.b + ", items=" + this.c + ')';
    }

    public s(boolean z, boolean z2, List<a> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.a = z;
        this.b = z2;
        this.c = items;
    }

    public /* synthetic */ s(boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
