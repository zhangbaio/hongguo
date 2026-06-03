package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.animation.core.Animatable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2$1$1$1", f = "ProfileTabPageHeader.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $selected;
    final /* synthetic */ long $selectedColor;
    final /* synthetic */ Animatable<androidx.compose.ui.graphics.l0, androidx.compose.animation.core.p> $textColor;
    final /* synthetic */ long $unSelectedColor;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2$1$1$1(Animatable<androidx.compose.ui.graphics.l0, androidx.compose.animation.core.p> animatable, boolean z, long j, long j2, Continuation<? super ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2$1$1$1> continuation) {
        super(2, continuation);
        this.$textColor = animatable;
        this.$selected = z;
        this.$selectedColor = j;
        this.$unSelectedColor = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2$1$1$1(this.$textColor, this.$selected, this.$selectedColor, this.$unSelectedColor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        long j;
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
            Animatable<androidx.compose.ui.graphics.l0, androidx.compose.animation.core.p> animatable = this.$textColor;
            if (this.$selected) {
                j = this.$selectedColor;
            } else {
                j = this.$unSelectedColor;
            }
            androidx.compose.ui.graphics.l0 j2 = androidx.compose.ui.graphics.l0.j(j);
            this.label = 1;
            if (Animatable.f(animatable, j2, (androidx.compose.animation.core.i) null, (Object) null, (Function1) null, this, 14, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
