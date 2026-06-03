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

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderKt$SelectTabGuideBubble$2$1", f = "ProfileTabPageHeader.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileTabPageHeaderKt$SelectTabGuideBubble$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ int $selectTabIndex;
    final /* synthetic */ MutableState<Boolean> $showGuide$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileTabPageHeaderKt$SelectTabGuideBubble$2$1(PagerState pagerState, int i, MutableState<Boolean> mutableState, Continuation<? super ProfileTabPageHeaderKt$SelectTabGuideBubble$2$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$selectTabIndex = i;
        this.$showGuide$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileTabPageHeaderKt$SelectTabGuideBubble$2$1(this.$pagerState, this.$selectTabIndex, this.$showGuide$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileTabPageHeaderKt$SelectTabGuideBubble$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.b0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int u;
                    u = pagerState.u();
                    return Integer.valueOf(u);
                }
            });
            a aVar = new a(this.$selectTabIndex, this.$showGuide$delegate);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ int a;
        final /* synthetic */ MutableState<Boolean> b;

        a(int i, MutableState<Boolean> mutableState) {
            this.a = i;
            this.b = mutableState;
        }

        public final Object a(int i, Continuation<? super Unit> continuation) {
            if (i == this.a) {
                ProfileTabPageHeaderKt.x(this.b, false);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return a(((Number) obj).intValue(), continuation);
        }
    }
}
