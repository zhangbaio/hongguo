package com.dragon.read.kmp.mine.model;

import android.content.Context;
import com.dragon.read.kmp.compose.ToastDuration;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel$toastIfNeed$1", f = "ChangeProfilePageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChangeProfilePageViewModel$toastIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StringBuilder $builder;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangeProfilePageViewModel$toastIfNeed$1(StringBuilder sb, Continuation<? super ChangeProfilePageViewModel$toastIfNeed$1> continuation) {
        super(2, continuation);
        this.$builder = sb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangeProfilePageViewModel$toastIfNeed$1(this.$builder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChangeProfilePageViewModel$toastIfNeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Context b = ig4.f.b();
            if (b != null) {
                String sb = this.$builder.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                ig4.g.d(b, sb, (ToastDuration) null, 4, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
