package com.dragon.read.kmp.profile.justsaw;

import androidx.compose.animation.core.s2;
import androidx.compose.foundation.v2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.justsaw.JustSawViewKt$JustSawView$4$1", f = "JustSawView.kt", i = {}, l = {136, 137, 138, 139, 140, 141, 144}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class JustSawViewKt$JustSawView$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ s2<Float> $animationSpec;
    final /* synthetic */ int $iconSizePx;
    final /* synthetic */ v2 $scrollState;
    final /* synthetic */ i $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JustSawViewKt$JustSawView$4$1(i iVar, v2 v2Var, int i, s2<Float> s2Var, Continuation<? super JustSawViewKt$JustSawView$4$1> continuation) {
        super(2, continuation);
        this.$state = iVar;
        this.$scrollState = v2Var;
        this.$iconSizePx = i;
        this.$animationSpec = s2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JustSawViewKt$JustSawView$4$1(this.$state, this.$scrollState, this.$iconSizePx, this.$animationSpec, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((JustSawViewKt$JustSawView$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 0
            switch(r1) {
                case 0: goto L30;
                case 1: goto L2c;
                case 2: goto L28;
                case 3: goto L24;
                case 4: goto L20;
                case 5: goto L1c;
                case 6: goto L17;
                case 7: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L12:
            kotlin.ResultKt.throwOnFailure(r6)
            goto Lad
        L17:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L93
        L1c:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L85
        L20:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L77
        L24:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L6b
        L28:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5d
        L2c:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L30:
            kotlin.ResultKt.throwOnFailure(r6)
            com.dragon.read.kmp.profile.justsaw.i r6 = r5.$state
            boolean r6 = r6.b()
            if (r6 == 0) goto L99
            com.dragon.read.kmp.profile.justsaw.i r6 = r5.$state
            boolean r6 = r6.d()
            if (r6 != 0) goto L99
            r6 = 1
            r5.label = r6
            r3 = 400(0x190, double:1.976E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r6 != r0) goto L4f
            return r0
        L4f:
            androidx.compose.foundation.v2 r6 = r5.$scrollState
            int r1 = r5.$iconSizePx
            r3 = 2
            r5.label = r3
            java.lang.Object r6 = r6.u(r1, r5)
            if (r6 != r0) goto L5d
            return r0
        L5d:
            androidx.compose.foundation.v2 r6 = r5.$scrollState
            androidx.compose.animation.core.s2<java.lang.Float> r1 = r5.$animationSpec
            r3 = 3
            r5.label = r3
            java.lang.Object r6 = r6.n(r2, r1, r5)
            if (r6 != r0) goto L6b
            return r0
        L6b:
            r6 = 4
            r5.label = r6
            r3 = 100
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r5)
            if (r6 != r0) goto L77
            return r0
        L77:
            androidx.compose.foundation.v2 r6 = r5.$scrollState
            int r1 = r5.$iconSizePx
            r3 = 5
            r5.label = r3
            java.lang.Object r6 = r6.u(r1, r5)
            if (r6 != r0) goto L85
            return r0
        L85:
            androidx.compose.foundation.v2 r6 = r5.$scrollState
            androidx.compose.animation.core.s2<java.lang.Float> r1 = r5.$animationSpec
            r3 = 6
            r5.label = r3
            java.lang.Object r6 = r6.n(r2, r1, r5)
            if (r6 != r0) goto L93
            return r0
        L93:
            com.dragon.read.kmp.profile.justsaw.i r6 = r5.$state
            r6.f()
            goto Lad
        L99:
            com.dragon.read.kmp.profile.justsaw.i r6 = r5.$state
            boolean r6 = r6.b()
            if (r6 != 0) goto Lad
            androidx.compose.foundation.v2 r6 = r5.$scrollState
            r1 = 7
            r5.label = r1
            java.lang.Object r6 = r6.u(r2, r5)
            if (r6 != r0) goto Lad
            return r0
        Lad:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.justsaw.JustSawViewKt$JustSawView$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
