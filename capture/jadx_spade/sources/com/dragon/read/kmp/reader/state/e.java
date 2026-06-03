package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public final boolean a;

    static {
        Covode.recordClassIndex(608572);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.a == ((e) obj).a;
    }

    public int hashCode() {
        return androidx.compose.animation.m.a(this.a);
    }

    public String toString() {
        return "DerivedSplitModeLocals(isInSplitMode=" + this.a + ')';
    }

    public e(boolean z) {
        this.a = z;
    }
}
