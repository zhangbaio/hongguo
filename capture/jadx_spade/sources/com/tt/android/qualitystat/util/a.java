package com.tt.android.qualitystat.util;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class a implements Runnable {
    private final /* synthetic */ Function0 a;

    a(Function0 function0) {
        this.a = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.a.invoke(), "invoke(...)");
    }
}
