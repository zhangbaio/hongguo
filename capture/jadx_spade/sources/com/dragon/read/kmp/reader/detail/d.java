package com.dragon.read.kmp.reader.detail;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.DetailSource;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public final String a;
    public final DetailSource b;
    public final boolean c;
    public final v2 d;
    public final String e;
    public final String f;

    static {
        Covode.recordClassIndex(608363);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.a, dVar.a) && this.b == dVar.b && this.c == dVar.c && Intrinsics.areEqual(this.d, dVar.d) && Intrinsics.areEqual(this.e, dVar.e) && Intrinsics.areEqual(this.f, dVar.f);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        DetailSource detailSource = this.b;
        int hashCode2 = (((hashCode + (detailSource == null ? 0 : detailSource.hashCode())) * 31) + androidx.compose.animation.m.a(this.c)) * 31;
        v2 v2Var = this.d;
        int hashCode3 = (hashCode2 + (v2Var == null ? 0 : v2Var.hashCode())) * 31;
        String str = this.e;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BookDetailLoadArgs(bookId=" + this.a + ", source=" + this.b + ", isFromReader=" + this.c + ", onClose=" + this.d + ", aliasName=" + this.e + ", frozeBookCoverUrl=" + this.f + ')';
    }

    public d(String bookId, DetailSource detailSource, boolean z, v2 v2Var, String str, String str2) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.a = bookId;
        this.b = detailSource;
        this.c = z;
        this.d = v2Var;
        this.e = str;
        this.f = str2;
    }
}
