package com.dragon.read.kmp.star_fans;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CommunityStartTaskPrefetch {
    public static final CommunityStartTaskPrefetch a;

    static {
        Covode.recordClassIndex(609148);
        a = new CommunityStartTaskPrefetch();
    }

    private CommunityStartTaskPrefetch() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(2:10|11)(2:21|22))(3:23|(1:25)(1:32)|(2:27|28)(2:29|(1:31)))|12|13|(2:15|16)(2:18|19)))|35|6|7|(0)(0)|12|13|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x002e, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
    
        r0 = kotlin.Result.Companion;
        r13 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r13));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r12, kotlin.coroutines.Continuation<? super kotlinx.serialization.json.JsonObject> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$1
            if (r0 == 0) goto L13
            r0 = r13
            com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$1 r0 = (com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$1 r0 = new com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r12 = r0.L$0
            java.lang.String r12 = (java.lang.String) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L2e
            goto L69
        L2e:
            r13 = move-exception
            goto L70
        L30:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L38:
            kotlin.ResultKt.throwOnFailure(r13)
            int r13 = r12.length()
            if (r13 != 0) goto L43
            r13 = 1
            goto L44
        L43:
            r13 = 0
        L44:
            if (r13 == 0) goto L53
            com.dragon.read.kmp.j r5 = com.dragon.read.kmp.j.a
            java.lang.String r6 = "CommunityStartTaskPrefetch"
            java.lang.String r7 = "prefetch ignored, actorUid is empty"
            r8 = 0
            r9 = 4
            r10 = 0
            com.dragon.read.kmp.j.f(r5, r6, r7, r8, r9, r10)
            return r3
        L53:
            kotlin.Result$Companion r13 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L2e
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L2e
            com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1 r2 = new com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch$prefetchActorFansRanklistPageData$2$1     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r12, r3)     // Catch: java.lang.Throwable -> L2e
            r0.L$0 = r12     // Catch: java.lang.Throwable -> L2e
            r0.label = r4     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r13, r2, r0)     // Catch: java.lang.Throwable -> L2e
            if (r13 != r1) goto L69
            return r1
        L69:
            kotlinx.serialization.json.JsonObject r13 = (kotlinx.serialization.json.JsonObject) r13     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r13 = kotlin.Result.m773constructorimpl(r13)     // Catch: java.lang.Throwable -> L2e
            goto L7a
        L70:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r13 = kotlin.Result.m773constructorimpl(r13)
        L7a:
            java.lang.Throwable r0 = kotlin.Result.m776exceptionOrNullimpl(r13)
            if (r0 != 0) goto L82
            r3 = r13
            goto L9a
        L82:
            com.dragon.read.kmp.j r13 = com.dragon.read.kmp.j.a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "prefetch actor fans ranklist page data failed, actorUid="
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = "CommunityStartTaskPrefetch"
            r13.b(r1, r12, r0)
        L9a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
