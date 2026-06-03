package com.dragon.read.kmp.story.impl.feeds.container;

import com.dragon.read.kmp.compose.common.load.LoadStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$reloadStory$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {752, 753}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$reloadStory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kp4.b $story;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$reloadStory$1(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, Continuation<? super KmpStoryFeedsVM$reloadStory$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
        this.$story = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFeedsVM$reloadStory$1(this.this$0, this.$story, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$reloadStory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$reloadStory$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {755}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$reloadStory$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ m<com.dragon.read.kmp.story.impl.feeds.data.b> $result;
        final /* synthetic */ kp4.b $story;
        int label;
        final /* synthetic */ KmpStoryFeedsVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(m<com.dragon.read.kmp.story.impl.feeds.data.b> mVar, KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = mVar;
            this.this$0 = kmpStoryFeedsVM;
            this.$story = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$result, this.this$0, this.$story, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
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
                m<com.dragon.read.kmp.story.impl.feeds.data.b> mVar = this.$result;
                if (mVar.b != null && mVar.b()) {
                    KmpStoryFeedsVM kmpStoryFeedsVM = this.this$0;
                    kp4.b bVar = this.$story;
                    com.dragon.read.kmp.story.impl.feeds.data.b bVar2 = this.$result.b;
                    this.label = 1;
                    if (kmpStoryFeedsVM.N1(bVar, bVar2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.this$0.k1(this.$story, LoadStatus.Error);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
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
            KmpStoryFeedsVM kmpStoryFeedsVM = this.this$0;
            kp4.b bVar = this.$story;
            this.label = 1;
            obj = kmpStoryFeedsVM.D1(bVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1((m) obj, this.this$0, this.$story, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
