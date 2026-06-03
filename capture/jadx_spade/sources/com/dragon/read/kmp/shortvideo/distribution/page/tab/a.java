package com.dragon.read.kmp.shortvideo.distribution.page.tab;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final LoadStatus a;
    public final LoadStatus b;

    static {
        Covode.recordClassIndex(609074);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.a.<init>():void");
    }

    public static /* synthetic */ a b(a aVar, LoadStatus loadStatus, LoadStatus loadStatus2, int i, Object obj) {
        if ((i & 1) != 0) {
            loadStatus = aVar.a;
        }
        if ((i & 2) != 0) {
            loadStatus2 = aVar.b;
        }
        return aVar.a(loadStatus, loadStatus2);
    }

    public final a a(LoadStatus loadSate, LoadStatus filterLoadSate) {
        Intrinsics.checkNotNullParameter(loadSate, "loadSate");
        Intrinsics.checkNotNullParameter(filterLoadSate, "filterLoadSate");
        return new a(loadSate, filterLoadSate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "PageTabUiState(loadSate=" + this.a + ", filterLoadSate=" + this.b + ')';
    }

    public a(LoadStatus loadSate, LoadStatus filterLoadSate) {
        Intrinsics.checkNotNullParameter(loadSate, "loadSate");
        Intrinsics.checkNotNullParameter(filterLoadSate, "filterLoadSate");
        this.a = loadSate;
        this.b = filterLoadSate;
    }

    public /* synthetic */ a(LoadStatus loadStatus, LoadStatus loadStatus2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LoadStatus.Loading : loadStatus, (i & 2) != 0 ? LoadStatus.Content : loadStatus2);
    }
}
