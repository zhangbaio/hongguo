package com.dragon.read.kmp.story.impl.feeds.container;

import com.dragon.read.kmp.compose.common.load.LoadStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadMore$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {558, 561, 562, 565}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$loadMore$1(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$loadMore$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFeedsVM$loadMore$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$loadMore$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadMore$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadMore$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ KmpStoryFeedsVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = kmpStoryFeedsVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.j1(LoadStatus.LoadMore);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007b A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #0 {all -> 0x0038, blocks: (B:8:0x0016, B:15:0x0025, B:16:0x0073, B:18:0x007b, B:21:0x0029, B:23:0x005d, B:25:0x0065, B:28:0x0034, B:29:0x0052, B:33:0x003e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:8:0x0016, B:15:0x0025, B:16:0x0073, B:18:0x007b, B:21:0x0029, B:23:0x005d, B:25:0x0065, B:28:0x0034, B:29:0x0052, B:33:0x003e), top: B:2:0x000c }] */
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
            r3 = 4
            r4 = 3
            r5 = 1
            r6 = 2
            r7 = 0
            if (r1 == 0) goto L3b
            if (r1 == r5) goto L34
            if (r1 == r6) goto L29
            if (r1 == r4) goto L23
            if (r1 != r3) goto L1b
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L38
            goto La7
        L1b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L23:
            java.lang.Object r1 = r10.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L38
            goto L73
        L29:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L38
            kotlin.Result r11 = (kotlin.Result) r11     // Catch: java.lang.Throwable -> L38
            java.lang.Object r11 = r11.m782unboximpl()     // Catch: java.lang.Throwable -> L38
        L32:
            r1 = r11
            goto L5d
        L34:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L38
            goto L52
        L38:
            r11 = move-exception
            goto Lb3
        L3b:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L38
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadMore$1$1 r1 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadMore$1$1     // Catch: java.lang.Throwable -> L38
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r8 = r10.this$0     // Catch: java.lang.Throwable -> L38
            r1.<init>(r8, r7)     // Catch: java.lang.Throwable -> L38
            r10.label = r5     // Catch: java.lang.Throwable -> L38
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r1, r10)     // Catch: java.lang.Throwable -> L38
            if (r11 != r0) goto L52
            return r0
        L52:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r11 = r10.this$0     // Catch: java.lang.Throwable -> L38
            r10.label = r6     // Catch: java.lang.Throwable -> L38
            java.lang.Object r11 = com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.X0(r11, r10)     // Catch: java.lang.Throwable -> L38
            if (r11 != r0) goto L32
            return r0
        L5d:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r11 = r10.this$0     // Catch: java.lang.Throwable -> L38
            boolean r5 = kotlin.Result.m780isSuccessimpl(r1)     // Catch: java.lang.Throwable -> L38
            if (r5 == 0) goto L73
            r5 = r1
            com.dragon.read.kmp.story.impl.feeds.data.g r5 = (com.dragon.read.kmp.story.impl.feeds.data.g) r5     // Catch: java.lang.Throwable -> L38
            r10.L$0 = r1     // Catch: java.lang.Throwable -> L38
            r10.label = r4     // Catch: java.lang.Throwable -> L38
            java.lang.Object r11 = com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.Z0(r11, r5, r10)     // Catch: java.lang.Throwable -> L38
            if (r11 != r0) goto L73
            return r0
        L73:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r11 = r10.this$0     // Catch: java.lang.Throwable -> L38
            java.lang.Throwable r4 = kotlin.Result.m776exceptionOrNullimpl(r1)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto La7
            tp4.b r5 = com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.S0(r11)     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r8.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r9 = "loadMore failed, throwable is "
            r8.append(r9)     // Catch: java.lang.Throwable -> L38
            r8.append(r4)     // Catch: java.lang.Throwable -> L38
            java.lang.String r4 = r8.toString()     // Catch: java.lang.Throwable -> L38
            tp4.b.c(r5, r4, r7, r6, r7)     // Catch: java.lang.Throwable -> L38
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L38
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadMore$1$3$1 r5 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadMore$1$3$1     // Catch: java.lang.Throwable -> L38
            r5.<init>(r11, r7)     // Catch: java.lang.Throwable -> L38
            r10.L$0 = r1     // Catch: java.lang.Throwable -> L38
            r10.label = r3     // Catch: java.lang.Throwable -> L38
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r10)     // Catch: java.lang.Throwable -> L38
            if (r11 != r0) goto La7
            return r0
        La7:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r11 = r10.this$0
            xm6.a r11 = com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.V0(r11)
            r11.d(r2)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lb3:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r0 = r10.this$0
            xm6.a r0 = com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.V0(r0)
            r0.d(r2)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadMore$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
