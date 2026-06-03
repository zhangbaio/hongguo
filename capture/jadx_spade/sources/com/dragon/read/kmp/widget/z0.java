package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z0 {
    public final String a;
    public final String b;
    public final BookType c;
    public final boolean d;

    static {
        Covode.recordClassIndex(609653);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return Intrinsics.areEqual(this.a, z0Var.a) && Intrinsics.areEqual(this.b, z0Var.b) && this.c == z0Var.c && this.d == z0Var.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + androidx.compose.animation.m.a(this.d);
    }

    public String toString() {
        return "GroupCoverParams(coverUrl=" + this.a + ", bookId=" + this.b + ", bookType=" + this.c + ", isPlaying=" + this.d + ')';
    }

    public z0(String coverUrl, String bookId, BookType bookType, boolean z) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(bookType, "bookType");
        this.a = coverUrl;
        this.b = bookId;
        this.c = bookType;
        this.d = z;
    }

    public /* synthetic */ z0(String str, String str2, BookType bookType, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? BookType.READ : bookType, (i & 8) != 0 ? false : z);
    }
}
