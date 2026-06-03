package com.dragon.read.kmp.story.impl.widget.follow;

import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public final String a;
    public final org.jetbrains.compose.resources.b b;
    public final long c;
    public final long d;

    static {
        Covode.recordClassIndex(609432);
    }

    public /* synthetic */ h(String str, org.jetbrains.compose.resources.b bVar, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bVar, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.a, hVar.a) && Intrinsics.areEqual(this.b, hVar.b) && l0.p(this.c, hVar.c) && l0.p(this.d, hVar.d);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        org.jetbrains.compose.resources.b bVar = this.b;
        return ((((hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31) + l0.v(this.c)) * 31) + l0.v(this.d);
    }

    public String toString() {
        return "KmpStoryFollowData(text=" + this.a + ", imageResource=" + this.b + ", bgColor=" + ((Object) l0.w(this.c)) + ", textColor=" + ((Object) l0.w(this.d)) + ')';
    }

    private h(String text, org.jetbrains.compose.resources.b bVar, long j, long j2) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = text;
        this.b = bVar;
        this.c = j;
        this.d = j2;
    }
}
