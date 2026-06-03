package com.ss.ugc.clientai.aiservice.ohr;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class OHRService$shutdown$1$1 extends Lambda implements Function1<c, Unit> {
    public static final OHRService$shutdown$1$1 INSTANCE = new OHRService$shutdown$1$1();

    OHRService$shutdown$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
        invoke2(cVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        it2.b(c.W0.a());
    }
}
