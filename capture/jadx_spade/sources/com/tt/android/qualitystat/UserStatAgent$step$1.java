package com.tt.android.qualitystat;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import sj6.b;
import tj6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class UserStatAgent$step$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ g $param;
    final /* synthetic */ b $scene;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserStatAgent$step$1(b bVar, g gVar) {
        super(0);
        this.$scene = bVar;
        this.$param = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.tt.android.qualitystat.duration.a.b.f(this.$scene, this.$param);
    }
}
