package com.dragon.read.kmp.profile.justsaw;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel$scrollToVideoIndex$1", f = "ProfileTabJustSawViewModel.kt", i = {}, l = {170, 171}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileTabJustSawViewModel$scrollToVideoIndex$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ProfileTabJustSawViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileTabJustSawViewModel$scrollToVideoIndex$1(ProfileTabJustSawViewModel profileTabJustSawViewModel, Continuation<? super ProfileTabJustSawViewModel$scrollToVideoIndex$1> continuation) {
        super(2, continuation);
        this.this$0 = profileTabJustSawViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileTabJustSawViewModel$scrollToVideoIndex$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileTabJustSawViewModel$scrollToVideoIndex$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0060 A[EDGE_INSN: B:33:0x0060->B:34:0x0060 BREAK  A[LOOP:0: B:22:0x0039->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[LOOP:0: B:22:0x0039->B:40:?, LOOP_END, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L21
            if (r1 == r5) goto L1d
            if (r1 != r3) goto L15
            kotlin.ResultKt.throwOnFailure(r11)
            goto L93
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1d:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L82
        L21:
            kotlin.ResultKt.throwOnFailure(r11)
            com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel r11 = r10.this$0
            com.dragon.read.kmp.compose.common.list.ScrollableListState r11 = com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel.d(r11)
            if (r11 != 0) goto L2f
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L2f:
            java.util.List r1 = r11.i()
            com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel r6 = r10.this$0
            java.util.Iterator r1 = r1.iterator()
        L39:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L5f
            java.lang.Object r7 = r1.next()
            com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState r8 = com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel.b(r6)
            if (r8 == 0) goto L5b
            com.dragon.read.kmp.compose.common.list.ScrollableListState r8 = r8.k()
            if (r8 == 0) goto L5b
            int r9 = com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel.c(r6, r7)
            int r8 = r8.c()
            if (r9 != r8) goto L5b
            r8 = 1
            goto L5c
        L5b:
            r8 = 0
        L5c:
            if (r8 == 0) goto L39
            goto L60
        L5f:
            r7 = r2
        L60:
            if (r7 == 0) goto L71
            com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel r1 = r10.this$0
            long r6 = com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel.e(r1, r7)
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r6 = r6 & r8
            int r1 = (int) r6
            int r1 = r1 / r3
            goto L72
        L71:
            r1 = 0
        L72:
            com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel r6 = r10.this$0
            int r6 = com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel.f(r6)
            int r1 = -r1
            r10.label = r5
            java.lang.Object r11 = r11.k(r6, r1, r10)
            if (r11 != r0) goto L82
            return r0
        L82:
            com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel r11 = r10.this$0
            com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState r11 = com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel.b(r11)
            if (r11 == 0) goto L93
            r10.label = r3
            java.lang.Object r11 = com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState.f(r11, r4, r10, r5, r2)
            if (r11 != r0) goto L93
            return r0
        L93:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel$scrollToVideoIndex$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
