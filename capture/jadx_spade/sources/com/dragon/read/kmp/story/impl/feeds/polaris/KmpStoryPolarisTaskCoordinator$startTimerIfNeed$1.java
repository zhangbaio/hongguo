package com.dragon.read.kmp.story.impl.feeds.polaris;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator$startTimerIfNeed$1", f = "KmpStoryPolarisTaskCoordinator.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryPolarisTaskCoordinator$startTimerIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $interval;
    final /* synthetic */ cp4.c $svc;
    int label;
    final /* synthetic */ KmpStoryPolarisTaskCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryPolarisTaskCoordinator$startTimerIfNeed$1(long j, KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator, cp4.c cVar, Continuation<? super KmpStoryPolarisTaskCoordinator$startTimerIfNeed$1> continuation) {
        super(2, continuation);
        this.$interval = j;
        this.this$0 = kmpStoryPolarisTaskCoordinator;
        this.$svc = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryPolarisTaskCoordinator$startTimerIfNeed$1(this.$interval, this.this$0, this.$svc, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryPolarisTaskCoordinator$startTimerIfNeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0058  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0024 -> B:5:0x0027). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            goto L27
        L10:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L18:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
        L1c:
            long r3 = r8.$interval
            r8.label = r2
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r3, r8)
            if (r1 != r0) goto L27
            return r0
        L27:
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r1 = r8.this$0
            long r3 = com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.d(r1)
            long r5 = r8.$interval
            long r3 = r3 + r5
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.h(r1, r3)
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r1 = r8.this$0
            long r3 = com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.c(r1)
            long r5 = r8.$interval
            long r3 = r3 + r5
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.g(r1, r3)
            cp4.c r1 = r8.$svc
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r3 = r8.this$0
            long r3 = com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.c(r3)
            long r5 = r8.$interval
            r1.onStoryPageTimerChange(r3, r5)
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r1 = r8.this$0
            long r3 = com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.e(r1)
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L76
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r1 = r8.this$0
            long r3 = com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.d(r1)
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r1 = r8.this$0
            long r5 = com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.e(r1)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L76
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r0 = r8.this$0
            r1 = 0
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.i(r0, r1)
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r8 = r8.this$0
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.f(r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L76:
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator r1 = r8.this$0
            com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator.f(r1)
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator$startTimerIfNeed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
