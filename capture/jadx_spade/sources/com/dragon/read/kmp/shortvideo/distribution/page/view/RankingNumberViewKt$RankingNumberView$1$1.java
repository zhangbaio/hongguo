package com.dragon.read.kmp.shortvideo.distribution.page.view;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.font.j;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1", f = "RankingNumberView.kt", i = {}, l = {61, 64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class RankingNumberViewKt$RankingNumberView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<j> $fontFamily;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RankingNumberViewKt$RankingNumberView$1$1(MutableState<j> mutableState, Continuation<? super RankingNumberViewKt$RankingNumberView$1$1> continuation) {
        super(2, continuation);
        this.$fontFamily = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RankingNumberViewKt$RankingNumberView$1$1(this.$fontFamily, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RankingNumberViewKt$RankingNumberView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1$1", f = "RankingNumberView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<j> $fontFamily;
        final /* synthetic */ j $fontFamilyValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableState<j> mutableState, j jVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$fontFamily = mutableState;
            this.$fontFamilyValue = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$fontFamily, this.$fontFamilyValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map map;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$fontFamily.setValue(this.$fontFamilyValue);
                map = RankingNumberViewKt.a;
                map.put("Oswald-Medium", this.$fontFamilyValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1f
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r7)
            goto L58
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L42
        L1f:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.Map r7 = com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt.g()
            java.lang.String r1 = "Oswald-Medium"
            java.lang.Object r7 = r7.get(r1)
            androidx.compose.ui.text.font.j r7 = (androidx.compose.ui.text.font.j) r7
            if (r7 != 0) goto L58
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1$fontFamilyValue$1 r1 = new com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1$fontFamilyValue$1
            r1.<init>(r2)
            r6.label = r4
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6)
            if (r7 != r0) goto L42
            return r0
        L42:
            androidx.compose.ui.text.font.j r7 = (androidx.compose.ui.text.font.j) r7
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1$1 r4 = new com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1$1
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.font.j> r5 = r6.$fontFamily
            r4.<init>(r5, r7, r2)
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r6)
            if (r7 != r0) goto L58
            return r0
        L58:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt$RankingNumberView$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
