package com.dragon.read.kmp.profile.guestprofile.aicontent;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel$startProgressUpdate$1", f = "AiGeneratedVideoViewModelFactory.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class AiGeneratedVideoViewModel$startProgressUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AiGeneratedVideoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AiGeneratedVideoViewModel$startProgressUpdate$1(AiGeneratedVideoViewModel aiGeneratedVideoViewModel, Continuation<? super AiGeneratedVideoViewModel$startProgressUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = aiGeneratedVideoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AiGeneratedVideoViewModel$startProgressUpdate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AiGeneratedVideoViewModel$startProgressUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0032 -> B:5:0x0035). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            r27 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r27
            int r2 = r1.label
            r3 = 1
            if (r2 == 0) goto L1a
            if (r2 != r3) goto L12
            kotlin.ResultKt.throwOnFailure(r28)
            r2 = r1
            goto L35
        L12:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L1a:
            kotlin.ResultKt.throwOnFailure(r28)
            r2 = r1
        L1e:
            com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel r4 = r2.this$0
            kotlin.random.Random$Default r4 = com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel.L0(r4)
            r5 = 3000(0xbb8, double:1.482E-320)
            r7 = 9001(0x2329, double:4.447E-320)
            long r4 = r4.nextLong(r5, r7)
            r2.label = r3
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r2)
            if (r4 != r0) goto L35
            return r0
        L35:
            com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel r4 = r2.this$0
            kotlinx.coroutines.flow.MutableStateFlow r4 = com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel.M0(r4)
        L3b:
            java.lang.Object r5 = r4.getValue()
            r7 = r5
            com.dragon.read.kmp.profile.guestprofile.aicontent.l r7 = (com.dragon.read.kmp.profile.guestprofile.aicontent.l) r7
            r6 = r7
            float r7 = r7.o
            r8 = 1008981770(0x3c23d70a, float:0.01)
            float r7 = r7 + r8
            r15 = 1063675494(0x3f666666, float:0.9)
            float r21 = java.lang.Math.min(r7, r15)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r26 = 1063675494(0x3f666666, float:0.9)
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 114687(0x1bfff, float:1.60711E-40)
            r25 = 0
            com.dragon.read.kmp.profile.guestprofile.aicontent.l r6 = com.dragon.read.kmp.profile.guestprofile.aicontent.l.b(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            boolean r5 = r4.compareAndSet(r5, r6)
            if (r5 == 0) goto L3b
            com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel r4 = r2.this$0
            com.dragon.read.kmp.profile.guestprofile.aicontent.l r4 = com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel.K0(r4)
            if (r4 == 0) goto L92
            com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel r5 = r2.this$0
            kotlinx.coroutines.flow.MutableStateFlow r5 = com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel.M0(r5)
            java.lang.Object r5 = r5.getValue()
            com.dragon.read.kmp.profile.guestprofile.aicontent.l r5 = (com.dragon.read.kmp.profile.guestprofile.aicontent.l) r5
            float r5 = r5.o
            r4.o = r5
        L92:
            com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel r4 = r2.this$0
            kotlinx.coroutines.flow.MutableStateFlow r4 = com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel.M0(r4)
            java.lang.Object r4 = r4.getValue()
            com.dragon.read.kmp.profile.guestprofile.aicontent.l r4 = (com.dragon.read.kmp.profile.guestprofile.aicontent.l) r4
            float r4 = r4.o
            int r4 = (r4 > r26 ? 1 : (r4 == r26 ? 0 : -1))
            if (r4 < 0) goto L1e
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideoViewModel$startProgressUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
