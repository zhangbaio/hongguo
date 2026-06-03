package com.dragon.read.kmp.story.impl.feeds.filter;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.snapshots.e0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$4$1", f = "KmpFeedFilterLayout.kt", i = {}, l = {176, 180, 186}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $estimatedItemWidth;
    final /* synthetic */ e0<Integer, Integer> $itemWidths;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ int $selectedIndex;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$4$1(int i, LazyListState lazyListState, e0<Integer, Integer> e0Var, int i2, Continuation<? super KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$4$1> continuation) {
        super(2, continuation);
        this.$selectedIndex = i;
        this.$listState = lazyListState;
        this.$itemWidths = e0Var;
        this.$estimatedItemWidth = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$4$1(this.$selectedIndex, this.$listState, this.$itemWidths, this.$estimatedItemWidth, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 1
            r4 = 2
            if (r1 == 0) goto L26
            if (r1 == r3) goto L22
            if (r1 == r4) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.throwOnFailure(r12)
            goto L87
        L16:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1e:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L58
        L22:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L36
        L26:
            kotlin.ResultKt.throwOnFailure(r12)
            int r12 = r11.$selectedIndex
            if (r12 < 0) goto L87
            r11.label = r3
            java.lang.Object r12 = kotlinx.coroutines.YieldKt.yield(r11)
            if (r12 != r0) goto L36
            return r0
        L36:
            androidx.compose.foundation.lazy.LazyListState r12 = r11.$listState
            androidx.compose.foundation.lazy.x r12 = r12.x()
            int r1 = r12.c()
            int r12 = r12.b()
            int r1 = r1 - r12
            if (r1 > 0) goto L5b
            androidx.compose.foundation.lazy.LazyListState r5 = r11.$listState
            int r6 = r11.$selectedIndex
            r7 = 0
            r9 = 2
            r10 = 0
            r11.label = r4
            r8 = r11
            java.lang.Object r12 = androidx.compose.foundation.lazy.LazyListState.q(r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L58
            return r0
        L58:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L5b:
            androidx.compose.runtime.snapshots.e0<java.lang.Integer, java.lang.Integer> r12 = r11.$itemWidths
            int r3 = r11.$selectedIndex
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            java.lang.Object r12 = r12.get(r3)
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L70
            int r12 = r12.intValue()
            goto L72
        L70:
            int r12 = r11.$estimatedItemWidth
        L72:
            int r1 = r1 - r12
            r12 = 0
            int r12 = kotlin.ranges.RangesKt.coerceAtLeast(r1, r12)
            int r12 = r12 / r4
            androidx.compose.foundation.lazy.LazyListState r1 = r11.$listState
            int r3 = r11.$selectedIndex
            int r12 = -r12
            r11.label = r2
            java.lang.Object r12 = r1.p(r3, r12, r11)
            if (r12 != r0) goto L87
            return r0
        L87:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.filter.KmpFeedFilterLayoutKt$KmpFeedFilterLayout$1$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
