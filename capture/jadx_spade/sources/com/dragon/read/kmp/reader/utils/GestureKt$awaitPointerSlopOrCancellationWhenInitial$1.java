package com.dragon.read.kmp.reader.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.utils.GestureKt", f = "Gesture.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {196, 230}, m = "awaitPointerSlopOrCancellationWhenInitial-92xelkU", n = {"$this$awaitPointerSlopOrCancellationWhenInitial_u2d92xelkU", "pointerDirectionConfig", "pass", "onPointerSlopReached", "pointer", "triggerOnMainAxisSlop", "touchSlop", "totalMainPositionChange", "totalCrossPositionChange", "$this$awaitPointerSlopOrCancellationWhenInitial_u2d92xelkU", "pointerDirectionConfig", "pass", "onPointerSlopReached", "pointer", "dragEvent", "triggerOnMainAxisSlop", "touchSlop", "totalMainPositionChange", "totalCrossPositionChange"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "F$0", "F$1", "F$2"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GestureKt$awaitPointerSlopOrCancellationWhenInitial$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    float F$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    GestureKt$awaitPointerSlopOrCancellationWhenInitial$1(Continuation<? super GestureKt$awaitPointerSlopOrCancellationWhenInitial$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return GestureKt.e(null, 0L, 0, null, false, null, null, this);
    }
}
