package com.dragon.read.kmp.reader.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.utils.GestureKt", f = "Gesture.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {283, 319}, m = "awaitVerticalPointerSlopOrCancellationInPass-pn7EDYM", n = {"pass", "onTouchSlopReached", "$this$awaitPointerSlopOrCancellationWhenInitial_u2d92xelkU_u24default$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "pass", "onTouchSlopReached", "$this$awaitPointerSlopOrCancellationWhenInitial_u2d92xelkU_u24default$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$3", "L$4", "L$5", "I$0", "F$0", "F$1", "F$2"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GestureKt$awaitVerticalPointerSlopOrCancellationInPass$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    GestureKt$awaitVerticalPointerSlopOrCancellationInPass$1(Continuation<? super GestureKt$awaitVerticalPointerSlopOrCancellationInPass$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GestureKt.f(null, 0L, 0, null, null, this);
    }
}
