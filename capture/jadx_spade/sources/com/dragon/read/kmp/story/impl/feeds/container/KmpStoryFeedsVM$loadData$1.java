package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadData$1", f = "KmpStoryFeedsVM.kt", i = {0, 1}, l = {904, 420, 431}, m = "invokeSuspend", n = {"networkFeedDeferred", "networkFeedDeferred"}, s = {"L$0", "L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$loadData$1(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KmpStoryFeedsVM$loadData$1 kmpStoryFeedsVM$loadData$1 = new KmpStoryFeedsVM$loadData$1(this.this$0, continuation);
        kmpStoryFeedsVM$loadData$1.L$0 = obj;
        return kmpStoryFeedsVM$loadData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$loadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadData$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {423}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadData$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ m<kp4.b> $firstStoryResult;
        Object L$0;
        int label;
        final /* synthetic */ KmpStoryFeedsVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(m<kp4.b> mVar, KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$firstStoryResult = mVar;
            this.this$0 = kmpStoryFeedsVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$firstStoryResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            kp4.b bVar;
            KmpStoryFeedsVM kmpStoryFeedsVM;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    kmpStoryFeedsVM = (KmpStoryFeedsVM) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (this.$firstStoryResult.b() && (bVar = this.$firstStoryResult.b) != null) {
                    KmpStoryFeedsVM kmpStoryFeedsVM2 = this.this$0;
                    this.L$0 = kmpStoryFeedsVM2;
                    this.label = 1;
                    obj = kmpStoryFeedsVM2.l1(bVar, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    kmpStoryFeedsVM = kmpStoryFeedsVM2;
                }
                this.this$0.e2(this.$firstStoryResult);
                return Unit.INSTANCE;
            }
            kmpStoryFeedsVM.c2((kp4.b) obj);
            this.this$0.e2(this.$firstStoryResult);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c7 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
