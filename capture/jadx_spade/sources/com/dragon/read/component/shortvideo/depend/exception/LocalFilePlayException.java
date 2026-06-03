package com.dragon.read.component.shortvideo.depend.exception;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LocalFilePlayException extends RuntimeException {
    static {
        Covode.recordClassIndex(599186);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalFilePlayException(String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ LocalFilePlayException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }
}
