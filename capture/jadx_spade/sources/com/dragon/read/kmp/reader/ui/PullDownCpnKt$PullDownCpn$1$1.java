package com.dragon.read.kmp.reader.ui;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.s2;
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

@DebugMetadata(c = "com.dragon.read.kmp.reader.ui.PullDownCpnKt$PullDownCpn$1$1", f = "PullDownCpn.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class PullDownCpnKt$PullDownCpn$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ s2<Float> $animation;
    final /* synthetic */ float $maxOffsetPx;
    final /* synthetic */ float $minOffset;
    final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> $offsetY;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullDownCpnKt$PullDownCpn$1$1(Animatable<Float, androidx.compose.animation.core.m> animatable, float f, CoroutineScope coroutineScope, float f2, s2<Float> s2Var, Continuation<? super PullDownCpnKt$PullDownCpn$1$1> continuation) {
        super(2, continuation);
        this.$offsetY = animatable;
        this.$maxOffsetPx = f;
        this.$scope = coroutineScope;
        this.$minOffset = f2;
        this.$animation = s2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullDownCpnKt$PullDownCpn$1$1(this.$offsetY, this.$maxOffsetPx, this.$scope, this.$minOffset, this.$animation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PullDownCpnKt$PullDownCpn$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.reader.ui.PullDownCpnKt$PullDownCpn$1$1$1", f = "PullDownCpn.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.reader.ui.PullDownCpnKt$PullDownCpn$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ s2<Float> $animation;
        final /* synthetic */ float $minOffset;
        final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> $offsetY;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Animatable<Float, androidx.compose.animation.core.m> animatable, float f, s2<Float> s2Var, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$offsetY = animatable;
            this.$minOffset = f;
            this.$animation = s2Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$offsetY, this.$minOffset, this.$animation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Animatable<Float, androidx.compose.animation.core.m> animatable = this.$offsetY;
                Float boxFloat = Boxing.boxFloat(this.$minOffset);
                s2<Float> s2Var = this.$animation;
                this.label = 1;
                if (Animatable.f(animatable, boxFloat, s2Var, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
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
            Animatable<Float, androidx.compose.animation.core.m> animatable = this.$offsetY;
            Float boxFloat = Boxing.boxFloat(this.$maxOffsetPx);
            this.label = 1;
            if (animatable.r(boxFloat, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        kotlinx.coroutines.i.e(this.$scope, null, null, new AnonymousClass1(this.$offsetY, this.$minOffset, this.$animation, null), 3, null);
        return Unit.INSTANCE;
    }
}
