package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1 extends SuspendLambda implements Function2<m<kp4.b>, Continuation<? super m<kp4.b>>, Object> {
    final /* synthetic */ CoroutineScope $$this$launch;
    final /* synthetic */ Deferred<m<kp4.b>> $networkFirstStoryDeferred;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1(KmpStoryFeedsVM kmpStoryFeedsVM, CoroutineScope coroutineScope, Deferred<? extends m<kp4.b>> deferred, Continuation<? super KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
        this.$$this$launch = coroutineScope;
        this.$networkFirstStoryDeferred = deferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1 kmpStoryFeedsVM$loadData$1$firstStoryResult$1$1 = new KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1(this.this$0, this.$$this$launch, this.$networkFirstStoryDeferred, continuation);
        kmpStoryFeedsVM$loadData$1$firstStoryResult$1$1.L$0 = obj;
        return kmpStoryFeedsVM$loadData$1$firstStoryResult$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(m<kp4.b> mVar, Continuation<? super m<kp4.b>> continuation) {
        return ((KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1) create(mVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {397, 401}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$loadData$1$firstStoryResult$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Deferred<m<kp4.b>> $networkFirstStoryDeferred;
        int label;
        final /* synthetic */ KmpStoryFeedsVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Deferred<? extends m<kp4.b>> deferred, KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$networkFirstStoryDeferred = deferred;
            this.this$0 = kmpStoryFeedsVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$networkFirstStoryDeferred, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            tp4.b bVar;
            Object l1;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                Deferred<m<kp4.b>> deferred = this.$networkFirstStoryDeferred;
                this.label = 1;
                obj = deferred.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            m mVar = (m) obj;
            if (mVar.b()) {
                bVar = this.this$0.e;
                bVar.d("silent refresh first story success");
                kp4.b bVar2 = (kp4.b) mVar.b;
                if (bVar2 != null) {
                    KmpStoryFeedsVM kmpStoryFeedsVM = this.this$0;
                    this.label = 2;
                    l1 = kmpStoryFeedsVM.l1(bVar2, this);
                    if (l1 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        tp4.b bVar;
        tp4.b bVar2;
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
            m mVar = (m) this.L$0;
            if (mVar.b()) {
                bVar2 = this.this$0.e;
                bVar2.d("loadData use preload data");
                kotlinx.coroutines.i.e(this.$$this$launch, null, null, new AnonymousClass1(this.$networkFirstStoryDeferred, this.this$0, null), 3, null);
                return mVar;
            }
            bVar = this.this$0.e;
            bVar.d("loadData preload failed, wait network");
            Deferred<m<kp4.b>> deferred = this.$networkFirstStoryDeferred;
            this.label = 1;
            obj = deferred.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return (m) obj;
    }
}
