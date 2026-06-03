package com.dragon.read.kmp.widget.tab;

import androidx.compose.animation.core.i;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.v2;
import androidx.compose.runtime.snapshots.e0;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.widget.tab.SlidingTabLayoutKt$SlidingTabLayout$1$1", f = "SlidingTabLayout.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SlidingTabLayoutKt$SlidingTabLayout$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ x0.e $density;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ v2 $scrollState;
    final /* synthetic */ e0<Integer, e> $tabPositions;
    final /* synthetic */ List<String> $titles;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlidingTabLayoutKt$SlidingTabLayout$1$1(e0<Integer, e> e0Var, List<String> list, PagerState pagerState, v2 v2Var, x0.e eVar, Continuation<? super SlidingTabLayoutKt$SlidingTabLayout$1$1> continuation) {
        super(2, continuation);
        this.$tabPositions = e0Var;
        this.$titles = list;
        this.$pagerState = pagerState;
        this.$scrollState = v2Var;
        this.$density = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SlidingTabLayoutKt$SlidingTabLayout$1$1(this.$tabPositions, this.$titles, this.$pagerState, this.$scrollState, this.$density, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SlidingTabLayoutKt$SlidingTabLayout$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        float coerceIn;
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
            if (this.$tabPositions.size() != this.$titles.size()) {
                return Unit.INSTANCE;
            }
            e eVar = (e) this.$tabPositions.get(Boxing.boxInt(this.$pagerState.u()));
            if (eVar == null) {
                return Unit.INSTANCE;
            }
            int t = this.$scrollState.t();
            x0.e eVar2 = this.$density;
            coerceIn = RangesKt___RangesKt.coerceIn((eVar2.M0(eVar.a) + (eVar2.M0(eVar.b) / 2)) - (t / 2), 0.0f, this.$scrollState.r());
            this.label = 1;
            if (v2.o(this.$scrollState, (int) coerceIn, (i) null, this, 2, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
