package com.dragon.read.kmp.shortvideo.distribution.page.view;

import androidx.compose.ui.text.font.j;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1$fontFamilyValue$1", f = "RankingNumberView.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class RankingNumberViewKt$RankingNumberView$1$1$fontFamilyValue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super j>, Object> {
    int label;

    RankingNumberViewKt$RankingNumberView$1$1$fontFamilyValue$1(Continuation<? super RankingNumberViewKt$RankingNumberView$1$1$fontFamilyValue$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RankingNumberViewKt$RankingNumberView$1$1$fontFamilyValue$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super j> continuation) {
        return ((RankingNumberViewKt$RankingNumberView$1$1$fontFamilyValue$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
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
            obj = dd4.a.a("Oswald-Medium", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
