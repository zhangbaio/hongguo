package com.dragon.read.kmp.reader.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.utils.GestureKt", f = "Gesture.kt", i = {0, 0, 0, 0, 0}, l = {275}, m = "verticalDragInPass-TUCjRT4", n = {"pass", "onDrag", "$this$dragInPass_u2dqUu0H6M$iv", "$this$awaitDragOrUpInPass_u2dTUCjRT4$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GestureKt$verticalDragInPass$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    GestureKt$verticalDragInPass$1(Continuation<? super GestureKt$verticalDragInPass$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GestureKt.o(null, 0L, null, null, this);
    }
}
