package com.dragon.read.kmp.mine.model;

import com.dragon.read.kmp.mine.profile.ProfileItemType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel$onSave$2", f = "ChangeProfilePageViewModel.kt", i = {1}, l = {185, 196}, m = "invokeSuspend", n = {"status"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChangeProfilePageViewModel$onSave$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needAutoClosePage;
    final /* synthetic */ ProfileItemType $profileItemType;
    Object L$0;
    int label;
    final /* synthetic */ ChangeProfilePageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangeProfilePageViewModel$onSave$2(ChangeProfilePageViewModel changeProfilePageViewModel, boolean z, ProfileItemType profileItemType, Continuation<? super ChangeProfilePageViewModel$onSave$2> continuation) {
        super(2, continuation);
        this.this$0 = changeProfilePageViewModel;
        this.$needAutoClosePage = z;
        this.$profileItemType = profileItemType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangeProfilePageViewModel$onSave$2(this.this$0, this.$needAutoClosePage, this.$profileItemType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChangeProfilePageViewModel$onSave$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00a0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r6.L$0
            com.dragon.read.kmp.mine.profile.c2 r0 = (com.dragon.read.kmp.mine.profile.c2) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L99
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1f:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L31
        L23:
            kotlin.ResultKt.throwOnFailure(r7)
            com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel r7 = r6.this$0
            r6.label = r3
            java.lang.Object r7 = com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel.K0(r7, r6)
            if (r7 != r0) goto L31
            return r0
        L31:
            com.dragon.read.kmp.mine.profile.c2 r7 = (com.dragon.read.kmp.mine.profile.c2) r7
            com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel r1 = r6.this$0
            com.dragon.read.kmp.mine.profile.y r1 = r1.b
            r1.j(r7)
            int r1 = r7.a
            if (r1 != 0) goto Lad
            com.dragon.read.kmp.j r1 = com.dragon.read.kmp.j.a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "onSave success, needAutoClosePage = "
            r4.append(r5)
            boolean r5 = r6.$needAutoClosePage
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "ChangeProfilePageViewModel"
            r1.d(r5, r4)
            boolean r1 = r6.$needAutoClosePage
            if (r1 == 0) goto L61
            zm4.d r1 = zm4.d.a
            r1.b()
        L61:
            com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel r1 = r6.this$0
            boolean r1 = r1.z1()
            if (r1 == 0) goto Lc3
            com.dragon.read.kmp.mine.profile.ProfileItemType r1 = r6.$profileItemType
            com.dragon.read.kmp.mine.profile.ProfileItemType r4 = com.dragon.read.kmp.mine.profile.ProfileItemType.GENDER
            if (r1 != r4) goto L9a
            com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel r1 = r6.this$0
            androidx.compose.material.n2 r1 = com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel.F0(r1)
            r4 = 0
            if (r1 == 0) goto L80
            boolean r1 = r1.m()
            if (r1 != r3) goto L80
            r1 = 1
            goto L81
        L80:
            r1 = 0
        L81:
            if (r1 == 0) goto L9a
            com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel r1 = r6.this$0
            r1.o = r4
            androidx.compose.material.n2 r1 = com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel.F0(r1)
            if (r1 == 0) goto L9a
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r1 = r1.l(r6)
            if (r1 != r0) goto L98
            return r0
        L98:
            r0 = r7
        L99:
            r7 = r0
        L9a:
            com.dragon.read.kmp.mine.profile.ProfileItemType r0 = r6.$profileItemType
            com.dragon.read.kmp.mine.profile.ProfileItemType r1 = com.dragon.read.kmp.mine.profile.ProfileItemType.AVATAR
            if (r0 != r1) goto La5
            com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel r1 = r6.this$0
            r1.n1(r0, r3)
        La5:
            com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel r0 = r6.this$0
            com.dragon.read.kmp.mine.profile.ProfileItemType r1 = r6.$profileItemType
            com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel.H0(r0, r1, r7)
            goto Lc3
        Lad:
            java.lang.String r7 = r7.c
            if (r7 == 0) goto Lc3
            boolean r0 = kotlin.text.StringsKt.isBlank(r7)
            r0 = r0 ^ r3
            if (r0 == 0) goto Lc3
            android.content.Context r0 = ig4.f.b()
            if (r0 == 0) goto Lc3
            r1 = 4
            r2 = 0
            ig4.g.d(r0, r7, r2, r1, r2)
        Lc3:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel$onSave$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
