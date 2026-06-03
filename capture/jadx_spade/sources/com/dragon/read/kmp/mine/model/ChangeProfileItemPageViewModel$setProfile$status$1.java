package com.dragon.read.kmp.mine.model;

import androidx.compose.runtime.MutableState;
import com.bytedance.kmp.reading.model.ya0;
import com.dragon.read.kmp.mine.profile.VerifyStatus;
import com.dragon.read.kmp.mine.profile.b2;
import com.dragon.read.kmp.mine.profile.w;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.model.ChangeProfileItemPageViewModel$setProfile$status$1", f = "ChangeProfileItemPageViewModel.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChangeProfileItemPageViewModel$setProfile$status$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b2>, Object> {
    final /* synthetic */ String $avatarUrl;
    final /* synthetic */ String $bizUserId;
    final /* synthetic */ String $description;
    final /* synthetic */ int $gender;
    final /* synthetic */ String $profileCover;
    final /* synthetic */ String $userName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChangeProfileItemPageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangeProfileItemPageViewModel$setProfile$status$1(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, int i, String str, String str2, String str3, String str4, String str5, Continuation<? super ChangeProfileItemPageViewModel$setProfile$status$1> continuation) {
        super(2, continuation);
        this.this$0 = changeProfileItemPageViewModel;
        this.$gender = i;
        this.$userName = str;
        this.$description = str2;
        this.$avatarUrl = str3;
        this.$bizUserId = str4;
        this.$profileCover = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChangeProfileItemPageViewModel$setProfile$status$1 changeProfileItemPageViewModel$setProfile$status$1 = new ChangeProfileItemPageViewModel$setProfile$status$1(this.this$0, this.$gender, this.$userName, this.$description, this.$avatarUrl, this.$bizUserId, this.$profileCover, continuation);
        changeProfileItemPageViewModel$setProfile$status$1.L$0 = obj;
        return changeProfileItemPageViewModel$setProfile$status$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super b2> continuation) {
        return ((ChangeProfileItemPageViewModel$setProfile$status$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.mine.model.ChangeProfileItemPageViewModel$setProfile$status$1$1", f = "ChangeProfileItemPageViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.mine.model.ChangeProfileItemPageViewModel$setProfile$status$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ya0 $data;
        int label;
        final /* synthetic */ ChangeProfileItemPageViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, ya0 ya0Var, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = changeProfileItemPageViewModel;
            this.$data = ya0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            VerifyStatus verifyStatus;
            VerifyStatus verifyStatus2;
            VerifyStatus verifyStatus3;
            VerifyStatus verifyStatus4;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutableState<VerifyStatus> mutableState = this.this$0.a.c;
                Integer num = this.$data.f;
                if (num == null || (verifyStatus = w.a(num.intValue())) == null) {
                    verifyStatus = VerifyStatus.NOT_VERIFY;
                }
                mutableState.setValue(verifyStatus);
                MutableState<VerifyStatus> mutableState2 = this.this$0.a.e;
                Integer num2 = this.$data.g;
                if (num2 == null || (verifyStatus2 = w.a(num2.intValue())) == null) {
                    verifyStatus2 = VerifyStatus.NOT_VERIFY;
                }
                mutableState2.setValue(verifyStatus2);
                MutableState<VerifyStatus> mutableState3 = this.this$0.a.h;
                Integer num3 = this.$data.h;
                if (num3 == null || (verifyStatus3 = w.a(num3.intValue())) == null) {
                    verifyStatus3 = VerifyStatus.NOT_VERIFY;
                }
                mutableState3.setValue(verifyStatus3);
                MutableState<VerifyStatus> mutableState4 = this.this$0.a.j;
                Integer num4 = this.$data.l;
                if (num4 == null || (verifyStatus4 = w.a(num4.intValue())) == null) {
                    verifyStatus4 = VerifyStatus.NOT_VERIFY;
                }
                mutableState4.setValue(verifyStatus4);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x0093, code lost:
    
        if (kotlin.Result.m779isFailureimpl(r0) != false) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r41) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.model.ChangeProfileItemPageViewModel$setProfile$status$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
