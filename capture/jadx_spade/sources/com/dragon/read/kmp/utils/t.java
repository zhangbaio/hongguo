package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t<T> extends a<T> {
    public static final int b;
    public final Throwable a;

    static {
        Covode.recordClassIndex(609539);
        b = 8;
    }

    public String toString() {
        return "Fail(error=" + this.a + ')';
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Reflection.getOrCreateKotlinClass(this.a.getClass()), this.a.getMessage()});
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Throwable error) {
        super(null);
        Intrinsics.checkNotNullParameter(error, "error");
        this.a = error;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        Throwable th = ((t) obj).a;
        if (this.a.getClass() != th.getClass() || !Intrinsics.areEqual(this.a.getMessage(), th.getMessage())) {
            return false;
        }
        return true;
    }
}
