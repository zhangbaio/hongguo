package com.dragon.read.kmp.reader.detail.catalog;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int b;
    public final List<a> a;

    static {
        Covode.recordClassIndex(608378);
        b = 8;
    }

    public final b a(List<a> chapters) {
        Intrinsics.checkNotNullParameter(chapters, "chapters");
        return new b(chapters);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && Intrinsics.areEqual(this.a, ((b) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "BookDetailCatalogData(chapters=" + this.a + ')';
    }

    public b(List<a> chapters) {
        Intrinsics.checkNotNullParameter(chapters, "chapters");
        this.a = chapters;
    }
}
