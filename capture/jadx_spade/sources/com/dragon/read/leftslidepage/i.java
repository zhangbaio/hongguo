package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final int c;
    public final m a;
    public final List<r> b;

    static {
        Covode.recordClassIndex(611253);
        c = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.a, iVar.a) && Intrinsics.areEqual(this.b, iVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SideBarGameParams(titleParams=" + this.a + ", gameItemList=" + this.b + ')';
    }

    public i(m titleParams, List<r> gameItemList) {
        Intrinsics.checkNotNullParameter(titleParams, "titleParams");
        Intrinsics.checkNotNullParameter(gameItemList, "gameItemList");
        this.a = titleParams;
        this.b = gameItemList;
    }
}
