package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
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

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt$pageEffect$3$1", f = "SeriesGuestProfilePage.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesGuestProfilePageKt$pageEffect$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ GuestProfileViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesGuestProfilePageKt$pageEffect$3$1(PagerState pagerState, GuestProfileViewModel guestProfileViewModel, Continuation<? super SeriesGuestProfilePageKt$pageEffect$3$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$viewModel = guestProfileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesGuestProfilePageKt$pageEffect$3$1(this.$pagerState, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesGuestProfilePageKt$pageEffect$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.h3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int u;
                    u = pagerState.u();
                    return Integer.valueOf(u);
                }
            }));
            a aVar = new a(this.$viewModel);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ GuestProfileViewModel a;

        a(GuestProfileViewModel guestProfileViewModel) {
            this.a = guestProfileViewModel;
        }

        public final Object a(int i, Continuation<? super Unit> continuation) {
            this.a.J0(i);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Number) obj).intValue(), continuation);
        }
    }
}
