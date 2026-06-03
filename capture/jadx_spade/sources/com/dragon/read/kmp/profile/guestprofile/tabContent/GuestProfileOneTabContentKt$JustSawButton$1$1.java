package com.dragon.read.kmp.profile.guestprofile.tabContent;

import androidx.compose.runtime.MutableState;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.list.ScrollableListState;
import com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$JustSawButton$1$1", f = "GuestProfileOneTabContent.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABEL_HARDWARE_DECODE_AUDIO}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileOneTabContentKt$JustSawButton$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CollapsibleListState $collapsingState;
    final /* synthetic */ ProfileTabJustSawViewModel $justSawViewModel;
    final /* synthetic */ ScrollableListState $scrollListState;
    final /* synthetic */ MutableState<ql4.a> $tabLoadState$delegate;
    final /* synthetic */ tl4.l $tabViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileOneTabContentKt$JustSawButton$1$1(ProfileTabJustSawViewModel profileTabJustSawViewModel, tl4.l lVar, ScrollableListState scrollableListState, CollapsibleListState collapsibleListState, MutableState<ql4.a> mutableState, Continuation<? super GuestProfileOneTabContentKt$JustSawButton$1$1> continuation) {
        super(2, continuation);
        this.$justSawViewModel = profileTabJustSawViewModel;
        this.$tabViewModel = lVar;
        this.$scrollListState = scrollableListState;
        this.$collapsingState = collapsibleListState;
        this.$tabLoadState$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileOneTabContentKt$JustSawButton$1$1(this.$justSawViewModel, this.$tabViewModel, this.$scrollListState, this.$collapsingState, this.$tabLoadState$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuestProfileOneTabContentKt$JustSawButton$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ql4.a C;
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
            C = GuestProfileOneTabContentKt.C(this.$tabLoadState$delegate);
            if (ql4.b.a(C)) {
                this.label = 1;
                if (DelayKt.delay(400L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        ProfileTabJustSawViewModel profileTabJustSawViewModel = this.$justSawViewModel;
        tl4.l lVar = this.$tabViewModel;
        profileTabJustSawViewModel.u(lVar.h.a, this.$scrollListState, this.$collapsingState, lVar.e);
        return Unit.INSTANCE;
    }
}
