package com.dragon.read.kmp.reader.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.utils.GestureKt", f = "Gesture.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {268}, m = "dragInPass-qUu0H6M", n = {"$this$dragInPass_u2dqUu0H6M", "onDrag", "motionFromChange", "motionConsumed", "pass", "$this$awaitDragOrUpInPass_u2dTUCjRT4$iv", "pointer$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GestureKt$dragInPass$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    GestureKt$dragInPass$1(Continuation<? super GestureKt$dragInPass$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GestureKt.l(null, 0L, null, null, null, null, this);
    }
}
