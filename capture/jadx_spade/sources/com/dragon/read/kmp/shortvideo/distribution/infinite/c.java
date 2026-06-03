package com.dragon.read.kmp.shortvideo.distribution.infinite;

import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public final String a;
    public final String b;
    public final List<d> c;
    public int d;
    public MutableState<Boolean> e;

    static {
        Covode.recordClassIndex(609024);
    }

    public c() {
        this(null, null, null, 0, null, 31, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c) && this.d == cVar.d && Intrinsics.areEqual(this.e, cVar.e);
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "FilterGroupItem(rowName=" + this.a + ", type=" + this.b + ", selectorList=" + this.c + ", maxShowCount=" + this.d + ", needExpand=" + this.e + ')';
    }

    public final String getType() {
        return this.b;
    }

    public c(String rowName, String type, List<d> selectorList, int i, MutableState<Boolean> needExpand) {
        Intrinsics.checkNotNullParameter(rowName, "rowName");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(selectorList, "selectorList");
        Intrinsics.checkNotNullParameter(needExpand, "needExpand");
        this.a = rowName;
        this.b = type;
        this.c = selectorList;
        this.d = i;
        this.e = needExpand;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(java.lang.String r4, java.lang.String r5, java.util.List r6, int r7, androidx.compose.runtime.MutableState r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            java.lang.String r0 = ""
            if (r10 == 0) goto L8
            r10 = r0
            goto L9
        L8:
            r10 = r4
        L9:
            r4 = r9 & 2
            if (r4 == 0) goto Le
            goto Lf
        Le:
            r0 = r5
        Lf:
            r4 = r9 & 4
            if (r4 == 0) goto L17
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L17:
            r1 = r6
            r4 = r9 & 8
            if (r4 == 0) goto L1f
            r7 = -1
            r2 = -1
            goto L20
        L1f:
            r2 = r7
        L20:
            r4 = r9 & 16
            if (r4 == 0) goto L2c
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r5 = 0
            r6 = 2
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt.mutableStateOf$default(r4, r5, r6, r5)
        L2c:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r0
            r7 = r1
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.infinite.c.<init>(java.lang.String, java.lang.String, java.util.List, int, androidx.compose.runtime.MutableState, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
