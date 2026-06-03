package com.dragon.read.kmp.star_fans;

import com.bytedance.kmp.network.KmpNetworkManagerImpl;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonObject;

@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl$get$2", f = "KmpNetworkManagerImpl.kt", i = {1, 2, 2, 3}, l = {157, 394, 403, 406}, m = "invokeSuspend", n = {"request", "request", "response$iv", "body$iv"}, s = {"L$0", "L$0", "L$1", "L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JsonObject>, Object> {
    final /* synthetic */ Map $header;
    final /* synthetic */ Map $queries;
    final /* synthetic */ zn0.g $requestContext;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ KmpNetworkManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1(String str, Map map, Map map2, zn0.g gVar, KmpNetworkManagerImpl kmpNetworkManagerImpl, Continuation continuation) {
        super(2, continuation);
        this.$url = str;
        this.$queries = map;
        this.$header = map2;
        this.$requestContext = gVar;
        this.this$0 = kmpNetworkManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1(this.$url, this.$queries, this.$header, this.$requestContext, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super JsonObject> continuation) {
        return ((CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00f2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
