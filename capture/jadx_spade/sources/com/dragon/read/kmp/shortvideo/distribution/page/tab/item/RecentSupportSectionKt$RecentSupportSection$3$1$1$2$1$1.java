package com.dragon.read.kmp.shortvideo.distribution.page.tab.item;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.RecentSupportSectionKt$RecentSupportSection$3$1$1$2$1$1", f = "RecentSupportSection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class RecentSupportSectionKt$RecentSupportSection$3$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ io4.f $item;
    final /* synthetic */ Function2<io4.f, Integer, Unit> $onCardShow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RecentSupportSectionKt$RecentSupportSection$3$1$1$2$1$1(Function2<? super io4.f, ? super Integer, Unit> function2, io4.f fVar, int i, Continuation<? super RecentSupportSectionKt$RecentSupportSection$3$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$onCardShow = function2;
        this.$item = fVar;
        this.$index = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RecentSupportSectionKt$RecentSupportSection$3$1$1$2$1$1(this.$onCardShow, this.$item, this.$index, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RecentSupportSectionKt$RecentSupportSection$3$1$1$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onCardShow.invoke(this.$item, Boxing.boxInt(this.$index));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
