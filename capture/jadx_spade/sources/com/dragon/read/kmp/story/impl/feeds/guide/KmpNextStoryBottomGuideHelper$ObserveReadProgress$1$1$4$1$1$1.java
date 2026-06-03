package com.dragon.read.kmp.story.impl.feeds.guide;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$4$1$1$1", f = "KmpNextStoryBottomGuideHelper.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$4$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KmpNextStoryBottomGuideHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$4$1$1$1(KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper, Continuation<? super KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$4$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpNextStoryBottomGuideHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$4$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$4$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        tp4.b bVar;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        bVar = this.this$0.o;
        StringBuilder sb = new StringBuilder();
        sb.append("当前篇");
        str = this.this$0.e;
        sb.append(str);
        sb.append(" 引导展现时间结束，执行消失逻辑");
        bVar.d(sb.toString());
        this.this$0.J();
        return Unit.INSTANCE;
    }
}
