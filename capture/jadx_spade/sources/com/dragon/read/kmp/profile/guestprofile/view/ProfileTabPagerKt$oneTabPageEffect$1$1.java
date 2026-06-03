package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt$oneTabPageEffect$1$1", f = "ProfileTabPager.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileTabPagerKt$oneTabPageEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isFirstLanding$delegate;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 $subPageViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileTabPagerKt$oneTabPageEffect$1$1(PagerState pagerState, com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 e0Var, MutableState<Boolean> mutableState, Continuation<? super ProfileTabPagerKt$oneTabPageEffect$1$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$subPageViewModel = e0Var;
        this.$isFirstLanding$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileTabPagerKt$oneTabPageEffect$1$1(this.$pagerState, this.$subPageViewModel, this.$isFirstLanding$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileTabPagerKt$oneTabPageEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final PagerState pagerState = this.$pagerState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.m0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int u;
                    u = pagerState.u();
                    return Integer.valueOf(u);
                }
            }));
            a aVar = new a(this.$subPageViewModel, this.$isFirstLanding$delegate);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 a;
        final /* synthetic */ MutableState<Boolean> b;

        a(com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 e0Var, MutableState<Boolean> mutableState) {
            this.a = e0Var;
            this.b = mutableState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Number) obj).intValue(), continuation);
        }

        public final Object a(int i, Continuation<? super Unit> continuation) {
            boolean H;
            com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 e0Var = this.a;
            H = ProfileTabPagerKt.H(this.b);
            e0Var.h(i, H);
            ProfileTabPagerKt.I(this.b, false);
            return Unit.INSTANCE;
        }
    }
}
