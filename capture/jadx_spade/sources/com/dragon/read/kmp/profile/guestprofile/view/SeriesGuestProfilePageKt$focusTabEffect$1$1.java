package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.pager.PagerState;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.b;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt$focusTabEffect$1$1", f = "SeriesGuestProfilePage.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesGuestProfilePageKt$focusTabEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ GuestProfileViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesGuestProfilePageKt$focusTabEffect$1$1(GuestProfileViewModel guestProfileViewModel, PagerState pagerState, Continuation<? super SeriesGuestProfilePageKt$focusTabEffect$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = guestProfileViewModel;
        this.$pagerState = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesGuestProfilePageKt$focusTabEffect$1$1(this.$viewModel, this.$pagerState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesGuestProfilePageKt$focusTabEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            SharedFlow<com.dragon.read.kmp.profile.guestprofile.viewmodel.b> sharedFlow = this.$viewModel.n;
            a aVar = new a(this.$pagerState);
            this.label = 1;
            if (sharedFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        throw new KotlinNothingValueException();
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ PagerState a;

        a(PagerState pagerState) {
            this.a = pagerState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(com.dragon.read.kmp.profile.guestprofile.viewmodel.b bVar, Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            if (!(bVar instanceof b.a)) {
                return Unit.INSTANCE;
            }
            int i = ((b.a) bVar).a;
            boolean z = false;
            if (i >= 0 && i < this.a.z()) {
                z = true;
            }
            if (!z) {
                return Unit.INSTANCE;
            }
            if (this.a.u() != i) {
                Object U = PagerState.U(this.a, i, 0.0f, continuation, 2, (Object) null);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (U == coroutine_suspended) {
                    return U;
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }
}
