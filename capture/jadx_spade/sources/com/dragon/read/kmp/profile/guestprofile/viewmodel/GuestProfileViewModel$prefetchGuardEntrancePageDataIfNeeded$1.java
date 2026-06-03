package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1", f = "GuestProfileViewModel.kt", i = {}, l = {472, 481}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actorUid;
    final /* synthetic */ String $currentUserId;
    final /* synthetic */ long $taskPrefetchTimestamp;
    int label;
    final /* synthetic */ GuestProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1(String str, GuestProfileViewModel guestProfileViewModel, String str2, long j, Continuation<? super GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1> continuation) {
        super(2, continuation);
        this.$actorUid = str;
        this.this$0 = guestProfileViewModel;
        this.$currentUserId = str2;
        this.$taskPrefetchTimestamp = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1(this.$actorUid, this.this$0, this.$currentUserId, this.$taskPrefetchTimestamp, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0095  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.throwOnFailure(r11)
            goto L91
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1b:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L2f
        L1f:
            kotlin.ResultKt.throwOnFailure(r11)
            com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch r11 = com.dragon.read.kmp.star_fans.CommunityStartTaskPrefetch.a
            java.lang.String r1 = r10.$actorUid
            r10.label = r3
            java.lang.Object r11 = r11.a(r1, r10)
            if (r11 != r0) goto L2f
            return r0
        L2f:
            r6 = r11
            kotlinx.serialization.json.JsonObject r6 = (kotlinx.serialization.json.JsonObject) r6
            if (r6 != 0) goto L37
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L37:
            com.dragon.read.kmp.service.c0 r11 = com.dragon.read.kmp.service.c0.a
            java.lang.String r11 = r11.getUserId()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r1 = r10.this$0
            kotlinx.coroutines.flow.MutableStateFlow<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> r1 = r1.l
            java.lang.Object r1 = r1.getValue()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r1 = (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) r1
            com.bytedance.kmp.reading.model.eo r5 = r1.a
            if (r5 != 0) goto L4e
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L4e:
            com.bytedance.kmp.reading.model.cj0 r1 = r5.a
            if (r1 == 0) goto L5a
            com.bytedance.kmp.reading.model.ok0 r3 = r1.b
            if (r3 == 0) goto L5a
            java.lang.String r3 = r3.a
            if (r3 != 0) goto L60
        L5a:
            if (r1 == 0) goto L5f
            java.lang.String r3 = r1.a
            goto L60
        L5f:
            r3 = 0
        L60:
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r1 = r10.this$0
            boolean r1 = com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.G(r1)
            if (r1 != 0) goto Lab
            java.lang.String r1 = r10.$currentUserId
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r1)
            if (r11 == 0) goto Lab
            java.lang.String r11 = r10.$actorUid
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r11)
            if (r11 != 0) goto L79
            goto Lab
        L79:
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getDefault()
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1$schema$1 r1 = new com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1$schema$1
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r4 = r10.this$0
            long r7 = r10.$taskPrefetchTimestamp
            r9 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r9)
            r10.label = r2
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r1, r10)
            if (r11 != r0) goto L91
            return r0
        L91:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto La8
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r0 = r10.this$0
            java.lang.String r1 = r10.$currentUserId
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.N(r0, r1)
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r0 = r10.this$0
            java.lang.String r1 = r10.$actorUid
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.L(r0, r1)
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r0 = r10.this$0
            com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel.M(r0, r11)
        La8:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lab:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$prefetchGuardEntrancePageDataIfNeeded$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
