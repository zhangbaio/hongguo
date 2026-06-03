package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public final int a;
    public final ReaderBgColorType b;

    static {
        Covode.recordClassIndex(608570);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DerivedBackgroundLocals(background=" + this.a + ", backgroundType=" + this.b + ')';
    }

    public c(int i, ReaderBgColorType backgroundType) {
        Intrinsics.checkNotNullParameter(backgroundType, "backgroundType");
        this.a = i;
        this.b = backgroundType;
    }
}
