package com.dragon.read.kmp.profile.guestprofile.tabContent;

import com.dragon.read.kmp.compose.common.list.ScrollableListState;
import com.dragon.read.kmp.service.m0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$ScrollEffectListen$1$1", f = "GuestProfileOneTabContent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileOneTabContentKt$ScrollEffectListen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollableListState $scrollableListState;
    final /* synthetic */ tl4.l $tabViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileOneTabContentKt$ScrollEffectListen$1$1(ScrollableListState scrollableListState, tl4.l lVar, Continuation<? super GuestProfileOneTabContentKt$ScrollEffectListen$1$1> continuation) {
        super(2, continuation);
        this.$scrollableListState = scrollableListState;
        this.$tabViewModel = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileOneTabContentKt$ScrollEffectListen$1$1(this.$scrollableListState, this.$tabViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuestProfileOneTabContentKt$ScrollEffectListen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$scrollableListState.j()) {
                if (!this.$tabViewModel.f) {
                    com.dragon.read.kmp.service.q a = m0.a();
                    if (a != null) {
                        a.b0("guest_profile_scroll_kmp");
                    }
                    this.$tabViewModel.f = true;
                }
            } else if (this.$tabViewModel.f) {
                com.dragon.read.kmp.service.q a2 = m0.a();
                if (a2 != null) {
                    a2.H0("guest_profile_scroll_kmp");
                }
                this.$tabViewModel.f = false;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
