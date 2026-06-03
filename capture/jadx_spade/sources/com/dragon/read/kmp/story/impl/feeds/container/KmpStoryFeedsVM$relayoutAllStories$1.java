package com.dragon.read.kmp.story.impl.feeds.container;

import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$relayoutAllStories$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$relayoutAllStories$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $completion;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$relayoutAllStories$1(KmpStoryFeedsVM kmpStoryFeedsVM, Function0<Unit> function0, Continuation<? super KmpStoryFeedsVM$relayoutAllStories$1> continuation) {
        super(1, continuation);
        this.this$0 = kmpStoryFeedsVM;
        this.$completion = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new KmpStoryFeedsVM$relayoutAllStories$1(this.this$0, this.$completion, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$relayoutAllStories$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job job;
        Job e;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            job = this.this$0.u;
            KmpStoryFeedsVM kmpStoryFeedsVM = this.this$0;
            e = kotlinx.coroutines.i.e(kmpStoryFeedsVM.d, null, null, new AnonymousClass1(job, kmpStoryFeedsVM, this.$completion, null), 3, null);
            kmpStoryFeedsVM.u = e;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$relayoutAllStories$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$relayoutAllStories$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $completion;
        final /* synthetic */ Job $previousJob;
        int label;
        final /* synthetic */ KmpStoryFeedsVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Job job, KmpStoryFeedsVM kmpStoryFeedsVM, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$previousJob = job;
            this.this$0 = kmpStoryFeedsVM;
            this.$completion = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$previousJob, this.this$0, this.$completion, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$relayoutAllStories$1$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {294}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$relayoutAllStories$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<kp4.b> $allStories;
            final /* synthetic */ Function0<Unit> $completion;
            final /* synthetic */ kp4.b $currentStory;
            final /* synthetic */ Ref$ObjectRef<List<com.dragon.read.kmp.story.impl.feeds.data.b>> $storyContentList;
            int label;
            final /* synthetic */ KmpStoryFeedsVM this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00721(List<kp4.b> list, KmpStoryFeedsVM kmpStoryFeedsVM, Ref$ObjectRef<List<com.dragon.read.kmp.story.impl.feeds.data.b>> ref$ObjectRef, kp4.b bVar, Function0<Unit> function0, Continuation<? super C00721> continuation) {
                super(2, continuation);
                this.$allStories = list;
                this.this$0 = kmpStoryFeedsVM;
                this.$storyContentList = ref$ObjectRef;
                this.$currentStory = bVar;
                this.$completion = function0;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00721(this.$allStories, this.this$0, this.$storyContentList, this.$currentStory, this.$completion, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    for (kp4.b bVar2 : this.$allStories) {
                        bVar = this.this$0.r;
                        this.$storyContentList.element.add(op4.b.i(bVar, bVar2.d(), bVar2.e, null, false, false, true, 24, null));
                    }
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    C00731 c00731 = new C00731(this.$allStories, this.$storyContentList, this.this$0, this.$currentStory, this.$completion, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, c00731, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$relayoutAllStories$1$1$1$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {297, 302, 303}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$relayoutAllStories$1$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C00731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ List<kp4.b> $allStories;
                final /* synthetic */ Function0<Unit> $completion;
                final /* synthetic */ kp4.b $currentStory;
                final /* synthetic */ Ref$ObjectRef<List<com.dragon.read.kmp.story.impl.feeds.data.b>> $storyContentList;
                Object L$0;
                int label;
                final /* synthetic */ KmpStoryFeedsVM this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00731(List<kp4.b> list, Ref$ObjectRef<List<com.dragon.read.kmp.story.impl.feeds.data.b>> ref$ObjectRef, KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, Function0<Unit> function0, Continuation<? super C00731> continuation) {
                    super(2, continuation);
                    this.$allStories = list;
                    this.$storyContentList = ref$ObjectRef;
                    this.this$0 = kmpStoryFeedsVM;
                    this.$currentStory = bVar;
                    this.$completion = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00731(this.$allStories, this.$storyContentList, this.this$0, this.$currentStory, this.$completion, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0094 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:9:0x0099  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                    /*
                        r8 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r8.label
                        r2 = 3
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L2c
                        if (r1 == r4) goto L24
                        if (r1 == r3) goto L1f
                        if (r1 != r2) goto L17
                        kotlin.ResultKt.throwOnFailure(r9)
                        r9 = r8
                        goto L95
                    L17:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L1f:
                        kotlin.ResultKt.throwOnFailure(r9)
                        r9 = r8
                        goto L8a
                    L24:
                        java.lang.Object r1 = r8.L$0
                        java.util.Iterator r1 = (java.util.Iterator) r1
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L36
                    L2c:
                        kotlin.ResultKt.throwOnFailure(r9)
                        java.util.List<kp4.b> r9 = r8.$allStories
                        java.util.Iterator r9 = r9.iterator()
                        r1 = r9
                    L36:
                        r9 = r8
                    L37:
                        boolean r5 = r1.hasNext()
                        if (r5 == 0) goto L62
                        java.lang.Object r5 = r1.next()
                        kp4.b r5 = (kp4.b) r5
                        kotlin.jvm.internal.Ref$ObjectRef<java.util.List<com.dragon.read.kmp.story.impl.feeds.data.b>> r6 = r9.$storyContentList
                        T r6 = r6.element
                        java.util.List r6 = (java.util.List) r6
                        java.util.List<kp4.b> r7 = r9.$allStories
                        int r7 = r7.indexOf(r5)
                        java.lang.Object r6 = r6.get(r7)
                        com.dragon.read.kmp.story.impl.feeds.data.b r6 = (com.dragon.read.kmp.story.impl.feeds.data.b) r6
                        com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r7 = r9.this$0
                        r9.L$0 = r1
                        r9.label = r4
                        java.lang.Object r5 = r7.N1(r5, r6, r9)
                        if (r5 != r0) goto L37
                        return r0
                    L62:
                        com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r1 = r9.this$0
                        com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient r1 = r1.k
                        kp4.b r4 = r9.$currentStory
                        r5 = 0
                        r1.y(r4, r5)
                        com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r1 = r9.this$0
                        com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressService r1 = com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.T0(r1)
                        kp4.b r4 = r9.$currentStory
                        r1.e(r4, r5)
                        com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r1 = r9.this$0
                        com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.d1(r1, r5)
                        r1 = 0
                        r9.L$0 = r1
                        r9.label = r3
                        r3 = 100
                        java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r3, r9)
                        if (r1 != r0) goto L8a
                        return r0
                    L8a:
                        com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM r1 = r9.this$0
                        r9.label = r2
                        java.lang.Object r1 = com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.c1(r1, r9)
                        if (r1 != r0) goto L95
                        return r0
                    L95:
                        kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r9.$completion
                        if (r9 == 0) goto L9c
                        r9.invoke()
                    L9c:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$relayoutAllStories$1.AnonymousClass1.C00721.C00731.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        }

        /* JADX WARN: Type inference failed for: r15v13, types: [T, java.util.ArrayList] */
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
                Job job = this.$previousJob;
                if (job != null) {
                    this.label = 1;
                    if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            List<kp4.b> j = this.this$0.k.j();
            kp4.b value = this.this$0.l.getValue();
            if (j.isEmpty() || value == null) {
                Function0<Unit> function0 = this.$completion;
                if (function0 != null) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
            this.this$0.g2(value);
            this.this$0.t = true;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = new ArrayList();
            kotlinx.coroutines.i.e(this.this$0.d, Dispatchers.getIO(), null, new C00721(j, this.this$0, ref$ObjectRef, value, this.$completion, null), 2, null);
            return Unit.INSTANCE;
        }
    }
}
