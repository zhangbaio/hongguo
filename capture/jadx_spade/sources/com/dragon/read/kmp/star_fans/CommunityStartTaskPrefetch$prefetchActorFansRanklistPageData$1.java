package com.dragon.read.kmp.star_fans;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch", f = "CommunityStartTaskPrefetch.kt", i = {0}, l = {28}, m = "prefetchActorFansRanklistPageData", n = {"actorUid"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommunityStartTaskPrefetch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$1(CommunityStartTaskPrefetch communityStartTaskPrefetch, Continuation<? super CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$1> continuation) {
        super(continuation);
        this.this$0 = communityStartTaskPrefetch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
