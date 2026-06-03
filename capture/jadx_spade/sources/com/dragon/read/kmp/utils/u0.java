package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u0<T> extends a<T> {
    public final T a;

    static {
        Covode.recordClassIndex(609567);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u0) && Intrinsics.areEqual(this.a, ((u0) obj).a);
    }

    public int hashCode() {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "Success(value=" + this.a + ')';
    }

    public T c() {
        return this.a;
    }

    public u0(T t) {
        super(null);
        this.a = t;
    }
}
