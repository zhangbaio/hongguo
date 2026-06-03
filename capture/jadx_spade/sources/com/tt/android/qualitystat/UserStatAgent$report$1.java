package com.tt.android.qualitystat;

import com.tt.android.qualitystat.base.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tj6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class UserStatAgent$report$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ g $param;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserStatAgent$report$1(g gVar) {
        super(0);
        this.$param = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        d.c.d(this.$param);
    }
}
