package com.dragon.read.kmp.story.impl.feeds.container;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    public static final int d;
    public yo4.c a;
    public int b;
    public int c;

    static {
        Covode.recordClassIndex(609264);
        d = 8;
    }

    public s() {
        this(null, 0, 0, 7, null);
    }

    public final s a(yo4.c cVar, int i, int i2) {
        return new s(cVar, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Intrinsics.areEqual(this.a, sVar.a) && this.b == sVar.b && this.c == sVar.c;
    }

    public int hashCode() {
        yo4.c cVar = this.a;
        return ((((cVar == null ? 0 : cVar.hashCode()) * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "StoryPageInfo(currentPage=" + this.a + ", adapterIndex=" + this.b + ", storyIndex=" + this.c + ')';
    }

    public s(yo4.c cVar, int i, int i2) {
        this.a = cVar;
        this.b = i;
        this.c = i2;
    }

    public /* synthetic */ s(yo4.c cVar, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : cVar, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? -1 : i2);
    }
}
