package com.dragon.read.kmp.profile.guestprofile.tabContent;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.d0;
import androidx.compose.animation.core.s2;
import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt$JustSawButton$2$1", f = "GuestProfileOneTabContent.kt", i = {}, l = {424}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileOneTabContentKt$JustSawButton$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $avoidFollowGuide$delegate;
    final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> $bottomPadding;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileOneTabContentKt$JustSawButton$2$1(Animatable<Float, androidx.compose.animation.core.m> animatable, MutableState<Boolean> mutableState, Continuation<? super GuestProfileOneTabContentKt$JustSawButton$2$1> continuation) {
        super(2, continuation);
        this.$bottomPadding = animatable;
        this.$avoidFollowGuide$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileOneTabContentKt$JustSawButton$2$1(this.$bottomPadding, this.$avoidFollowGuide$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuestProfileOneTabContentKt$JustSawButton$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean E;
        float f;
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
            Animatable<Float, androidx.compose.animation.core.m> animatable = this.$bottomPadding;
            E = GuestProfileOneTabContentKt.E(this.$avoidFollowGuide$delegate);
            if (E) {
                f = 102.0f;
            } else {
                f = 36.0f;
            }
            Float boxFloat = Boxing.boxFloat(f);
            s2 n = androidx.compose.animation.core.j.n(200, 0, (d0) null, 6, (Object) null);
            this.label = 1;
            if (Animatable.f(animatable, boxFloat, n, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
