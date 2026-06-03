package com.dragon.read.kmp.reader.detail;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public final String a;
    public final String b;
    public final boolean c;
    public final IntroTagType d;

    static {
        Covode.recordClassIndex(608362);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b) && this.c == cVar.c && this.d == cVar.d;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + androidx.compose.animation.m.a(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "BookDetailIntroTagUiModel(text=" + this.a + ", schema=" + this.b + ", highlighted=" + this.c + ", type=" + this.d + ')';
    }

    public final IntroTagType getType() {
        return this.d;
    }

    public c(String text, String str, boolean z, IntroTagType type) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = text;
        this.b = str;
        this.c = z;
        this.d = type;
    }
}
