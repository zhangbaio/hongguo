package com.dragon.read.kmp.story.impl.feeds.progress;

import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mn0.g;
import np4.e;
import op4.c;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressService$syncStoryProgress$1$1$1", f = "StoryProgressService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryProgressService$syncStoryProgress$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $pagePos;
    final /* synthetic */ boolean $showToast;
    final /* synthetic */ c $storyChapter;
    int label;
    final /* synthetic */ StoryProgressService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryProgressService$syncStoryProgress$1$1$1(boolean z, c cVar, g gVar, StoryProgressService storyProgressService, Continuation<? super StoryProgressService$syncStoryProgress$1$1$1> continuation) {
        super(2, continuation);
        this.$showToast = z;
        this.$storyChapter = cVar;
        this.$pagePos = gVar;
        this.this$0 = storyProgressService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryProgressService$syncStoryProgress$1$1$1(this.$showToast, this.$storyChapter, this.$pagePos, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryProgressService$syncStoryProgress$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KmpStoryClient kmpStoryClient;
        float f;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$showToast) {
                b1.a.D("已定位到上次阅读位置");
            }
            e eVar = (e) CollectionsKt___CollectionsKt.getOrNull(this.$storyChapter.c, this.$pagePos.a);
            if (eVar != null) {
                StoryProgressService storyProgressService = this.this$0;
                g gVar = this.$pagePos;
                kmpStoryClient = storyProgressService.b;
                float f2 = gVar.c;
                f = storyProgressService.a;
                kmpStoryClient.z(eVar, (int) (f2 * f), false);
                return Unit.INSTANCE;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
