package com.dragon.read.kmp.reader.ui.menu.ui;

import androidx.compose.animation.core.Animatable;
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

@DebugMetadata(c = "com.dragon.read.kmp.reader.ui.menu.ui.PullDownBoxKt$PullDownBox$show$1$1$1", f = "PullDownBox.kt", i = {}, l = {106, 107}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class PullDownBoxKt$PullDownBox$show$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ s2<Float> $animation;
    final /* synthetic */ MutableState<Float> $height$delegate;
    final /* synthetic */ float $minOffset;
    final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> $offsetY;
    final /* synthetic */ sm4.d $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullDownBoxKt$PullDownBox$show$1$1$1(sm4.d dVar, Animatable<Float, androidx.compose.animation.core.m> animatable, float f, s2<Float> s2Var, MutableState<Float> mutableState, Continuation<? super PullDownBoxKt$PullDownBox$show$1$1$1> continuation) {
        super(2, continuation);
        this.$params = dVar;
        this.$offsetY = animatable;
        this.$minOffset = f;
        this.$animation = s2Var;
        this.$height$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullDownBoxKt$PullDownBox$show$1$1$1(this.$params, this.$offsetY, this.$minOffset, this.$animation, this.$height$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PullDownBoxKt$PullDownBox$show$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        float w;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            sm4.b bVar = this.$params.a;
            if (bVar != null) {
                bVar.onShow();
            }
            Animatable<Float, androidx.compose.animation.core.m> animatable = this.$offsetY;
            w = PullDownBoxKt.w(this.$height$delegate);
            Float boxFloat = Boxing.boxFloat(w);
            this.label = 1;
            if (animatable.r(boxFloat, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Animatable<Float, androidx.compose.animation.core.m> animatable2 = this.$offsetY;
        Float boxFloat2 = Boxing.boxFloat(this.$minOffset);
        s2<Float> s2Var = this.$animation;
        this.label = 2;
        if (Animatable.f(animatable2, boxFloat2, s2Var, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
