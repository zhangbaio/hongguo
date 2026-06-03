package com.dragon.read.kmp.progress;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public final int a;

    static {
        Covode.recordClassIndex(608224);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return "ChapterProgressSnapshot(percent=" + this.a + ')';
    }

    public c(int i) {
        this.a = i;
    }
}
