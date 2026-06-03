package com.dragon.read.kmp.story.impl.feeds.container;

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

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$foldStory$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {722}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$foldStory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kp4.b $story;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$foldStory$1(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, Continuation<? super KmpStoryFeedsVM$foldStory$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
        this.$story = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFeedsVM$foldStory$1(this.this$0, this.$story, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$foldStory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$foldStory$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {723}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$foldStory$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kp4.b $story;
        final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.data.b $storyContent;
        int label;
        final /* synthetic */ KmpStoryFeedsVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, com.dragon.read.kmp.story.impl.feeds.data.b bVar2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = kmpStoryFeedsVM;
            this.$story = bVar;
            this.$storyContent = bVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$story, this.$storyContent, continuation);
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
                KmpStoryFeedsVM kmpStoryFeedsVM = this.this$0;
                kp4.b bVar = this.$story;
                com.dragon.read.kmp.story.impl.feeds.data.b bVar2 = this.$storyContent;
                this.label = 1;
                if (kmpStoryFeedsVM.N1(bVar, bVar2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            KmpStoryClient kmpStoryClient = this.this$0.k;
            kmpStoryClient.x(kmpStoryClient.g(this.$story), false);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        op4.b bVar;
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
            bVar = this.this$0.r;
            com.dragon.read.kmp.story.impl.feeds.data.e d = this.$story.d();
            kp4.b bVar2 = this.$story;
            com.dragon.read.kmp.story.impl.feeds.data.b i2 = op4.b.i(bVar, d, bVar2.e, bVar2.b.d, false, true, false, 40, null);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$story, i2, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
