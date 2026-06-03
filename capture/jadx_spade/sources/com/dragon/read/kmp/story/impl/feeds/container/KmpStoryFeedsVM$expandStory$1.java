package com.dragon.read.kmp.story.impl.feeds.container;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$expandStory$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {736}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$expandStory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<kp4.b, Unit> $onExpandSuccess;
    final /* synthetic */ kp4.b $story;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    KmpStoryFeedsVM$expandStory$1(kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM, Function1<? super kp4.b, Unit> function1, Continuation<? super KmpStoryFeedsVM$expandStory$1> continuation) {
        super(2, continuation);
        this.$story = bVar;
        this.this$0 = kmpStoryFeedsVM;
        this.$onExpandSuccess = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFeedsVM$expandStory$1(this.$story, this.this$0, this.$onExpandSuccess, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$expandStory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$expandStory$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {737}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$expandStory$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<kp4.b, Unit> $onExpandSuccess;
        final /* synthetic */ kp4.b $story;
        final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.data.b $storyContent;
        int label;
        final /* synthetic */ KmpStoryFeedsVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, com.dragon.read.kmp.story.impl.feeds.data.b bVar2, Function1<? super kp4.b, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = kmpStoryFeedsVM;
            this.$story = bVar;
            this.$storyContent = bVar2;
            this.$onExpandSuccess = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$story, this.$storyContent, this.$onExpandSuccess, continuation);
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
            Function1<kp4.b, Unit> function1 = this.$onExpandSuccess;
            if (function1 != null) {
                function1.invoke(this.$story);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List<op4.c> list;
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
            if (this.$story.k()) {
                list = this.$story.b.d;
            } else {
                list = null;
            }
            bVar = this.this$0.r;
            com.dragon.read.kmp.story.impl.feeds.data.b i2 = op4.b.i(bVar, this.$story.d(), this.$story.e, list, false, false, false, 56, null);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$story, i2, this.$onExpandSuccess, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (!this.$story.k()) {
            this.this$0.Q1(this.$story);
        }
        return Unit.INSTANCE;
    }
}
