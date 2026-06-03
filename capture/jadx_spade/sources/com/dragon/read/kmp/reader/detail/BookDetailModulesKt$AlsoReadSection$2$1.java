package com.dragon.read.kmp.reader.detail;

import androidx.compose.animation.core.Animatable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailModulesKt$AlsoReadSection$2$1", f = "BookDetailModules.kt", i = {}, l = {754, 758, 759}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailModulesKt$AlsoReadSection$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isRefreshing;
    final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> $rotation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailModulesKt$AlsoReadSection$2$1(boolean z, Animatable<Float, androidx.compose.animation.core.m> animatable, Continuation<? super BookDetailModulesKt$AlsoReadSection$2$1> continuation) {
        super(2, continuation);
        this.$isRefreshing = z;
        this.$rotation = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailModulesKt$AlsoReadSection$2$1(this.$isRefreshing, this.$rotation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailModulesKt$AlsoReadSection$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x007b -> B:8:0x0048). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 0
            r3 = 3
            r4 = 1
            r5 = 2
            if (r1 == 0) goto L27
            if (r1 == r4) goto L23
            if (r1 == r5) goto L1e
            if (r1 != r3) goto L16
            kotlin.ResultKt.throwOnFailure(r15)
            goto L47
        L16:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L1e:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            goto L6f
        L23:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L44
        L27:
            kotlin.ResultKt.throwOnFailure(r15)
            boolean r15 = r14.$isRefreshing
            if (r15 != 0) goto L47
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.m> r6 = r14.$rotation
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 14
            r13 = 0
            r14.label = r4
            r11 = r14
            java.lang.Object r15 = androidx.compose.animation.core.Animatable.f(r6, r7, r8, r9, r10, r11, r12, r13)
            if (r15 != r0) goto L44
            return r0
        L44:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L47:
            r15 = r14
        L48:
            boolean r1 = r15.$isRefreshing
            if (r1 == 0) goto L7e
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.m> r6 = r15.$rotation
            r1 = 1135869952(0x43b40000, float:360.0)
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            androidx.compose.animation.core.d0 r1 = androidx.compose.animation.core.m0.d()
            r4 = 0
            r8 = 500(0x1f4, float:7.0E-43)
            r9 = 0
            androidx.compose.animation.core.s2 r8 = androidx.compose.animation.core.j.n(r8, r9, r1, r5, r4)
            r9 = 0
            r10 = 0
            r12 = 12
            r13 = 0
            r15.label = r5
            r11 = r15
            java.lang.Object r1 = androidx.compose.animation.core.Animatable.f(r6, r7, r8, r9, r10, r11, r12, r13)
            if (r1 != r0) goto L6f
            return r0
        L6f:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.m> r1 = r15.$rotation
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r15.label = r3
            java.lang.Object r1 = r1.r(r4, r15)
            if (r1 != r0) goto L48
            return r0
        L7e:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.BookDetailModulesKt$AlsoReadSection$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
