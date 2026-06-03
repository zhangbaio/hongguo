package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public static final int d;
    public final m a;
    public final List<k> b;
    public final boolean c;

    static {
        Covode.recordClassIndex(611256);
        d = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.areEqual(this.a, lVar.a) && Intrinsics.areEqual(this.b, lVar.b) && this.c == lVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + androidx.compose.animation.m.a(this.c);
    }

    public String toString() {
        return "SideBarRecentWatchParams(titleParams=" + this.a + ", recentWatchItemList=" + this.b + ", isGridStyle=" + this.c + ')';
    }

    public l(m titleParams, List<k> recentWatchItemList, boolean z) {
        Intrinsics.checkNotNullParameter(titleParams, "titleParams");
        Intrinsics.checkNotNullParameter(recentWatchItemList, "recentWatchItemList");
        this.a = titleParams;
        this.b = recentWatchItemList;
        this.c = z;
    }

    public /* synthetic */ l(m mVar, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mVar, list, (i & 4) != 0 ? false : z);
    }
}
