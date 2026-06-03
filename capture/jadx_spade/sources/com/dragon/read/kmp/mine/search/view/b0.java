package com.dragon.read.kmp.mine.search.view;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.s80;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 {
    public static final int e;
    public final int a;
    public final hn4.d b;
    public final s80 c;
    public boolean d;

    static {
        Covode.recordClassIndex(607778);
        e = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.a == b0Var.a && Intrinsics.areEqual(this.b, b0Var.b) && Intrinsics.areEqual(this.c, b0Var.c) && this.d == b0Var.d;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + androidx.compose.animation.m.a(this.d);
    }

    public String toString() {
        return "SearchTabParams(expectedNum=" + this.a + ", searchFeedParams=" + this.b + ", feedDefaultData=" + this.c + ", isFirstShow=" + this.d + ')';
    }

    public b0(int i, hn4.d searchFeedParams, s80 feedDefaultData, boolean z) {
        Intrinsics.checkNotNullParameter(searchFeedParams, "searchFeedParams");
        Intrinsics.checkNotNullParameter(feedDefaultData, "feedDefaultData");
        this.a = i;
        this.b = searchFeedParams;
        this.c = feedDefaultData;
        this.d = z;
    }

    public /* synthetic */ b0(int i, hn4.d dVar, s80 s80Var, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, dVar, s80Var, (i2 & 8) != 0 ? true : z);
    }
}
