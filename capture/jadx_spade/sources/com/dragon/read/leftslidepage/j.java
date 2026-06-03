package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public static final int c;
    public final m a;
    public final List<t> b;

    static {
        Covode.recordClassIndex(611254);
        c = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ j b(j jVar, m mVar, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            mVar = jVar.a;
        }
        if ((i & 2) != 0) {
            list = jVar.b;
        }
        return jVar.a(mVar, list);
    }

    public final j a(m titleParams, List<t> msgItemList) {
        Intrinsics.checkNotNullParameter(titleParams, "titleParams");
        Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        return new j(titleParams, msgItemList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Intrinsics.areEqual(this.a, jVar.a) && Intrinsics.areEqual(this.b, jVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SideBarMsgParams(titleParams=" + this.a + ", msgItemList=" + this.b + ')';
    }

    public j(m titleParams, List<t> msgItemList) {
        Intrinsics.checkNotNullParameter(titleParams, "titleParams");
        Intrinsics.checkNotNullParameter(msgItemList, "msgItemList");
        this.a = titleParams;
        this.b = msgItemList;
    }
}
