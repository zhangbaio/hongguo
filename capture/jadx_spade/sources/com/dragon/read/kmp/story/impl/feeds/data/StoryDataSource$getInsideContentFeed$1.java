package com.dragon.read.kmp.story.impl.feeds.data;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource", f = "StoryDataSource.kt", i = {}, l = {293}, m = "getInsideContentFeed-gIAlu-s", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryDataSource$getInsideContentFeed$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StoryDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryDataSource$getInsideContentFeed$1(StoryDataSource storyDataSource, Continuation<? super StoryDataSource$getInsideContentFeed$1> continuation) {
        super(continuation);
        this.this$0 = storyDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object a = this.this$0.a(null, this);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return a == coroutine_suspended ? a : Result.m772boximpl(a);
    }
}
