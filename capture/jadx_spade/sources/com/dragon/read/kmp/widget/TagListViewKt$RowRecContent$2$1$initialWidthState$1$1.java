package com.dragon.read.kmp.widget;

import androidx.compose.runtime.s2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.dragon.read.kmp.widget.TagListViewKt$RowRecContent$2$1$initialWidthState$1$1", f = "TagListView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class TagListViewKt$RowRecContent$2$1$initialWidthState$1$1 extends SuspendLambda implements Function2<s2<Float>, Continuation<? super Unit>, Object> {
    int label;

    TagListViewKt$RowRecContent$2$1$initialWidthState$1$1(Continuation<? super TagListViewKt$RowRecContent$2$1$initialWidthState$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TagListViewKt$RowRecContent$2$1$initialWidthState$1$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(s2<Float> s2Var, Continuation<? super Unit> continuation) {
        return ((TagListViewKt$RowRecContent$2$1$initialWidthState$1$1) create(s2Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
