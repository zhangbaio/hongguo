package com.dragon.read.kmp.star_fans;

import com.bytedance.kmp.network.KmpNetworkManager;
import com.bytedance.kmp.network.KmpNetworkManagerImpl;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.JsonObject;

@DebugMetadata(c = "com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1", f = "CommunityStartTaskPrefetch.kt", i = {}, l = {IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JsonObject>, Object> {
    final /* synthetic */ String $actorUid;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1(String str, Continuation<? super CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1> continuation) {
        super(2, continuation);
        this.$actorUid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1(this.$actorUid, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super JsonObject> continuation) {
        return ((CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Map mapOf;
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
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("enter_from", "profile"), TuplesKt.to("target_id", this.$actorUid));
            KmpNetworkManagerImpl b = KmpNetworkManager.a.b();
            CoroutineDispatcher io2 = Dispatchers.getIO();
            CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1 communityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1 = new CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1("https://api5-normal-sinfonlinea.fqnovel.com/luckycat/novel/v1/unify/hongguo_actor_fans_ranklist/page_data", mapOf, null, null, b, null);
            this.label = 1;
            obj = BuildersKt.withContext(io2, communityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1$invokeSuspend$$inlined$get$default$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
