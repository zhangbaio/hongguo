package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel$followTipsOnVisible$1", f = "GuestProfileViewModel.kt", i = {}, l = {1152}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class GuestProfileViewModel$followTipsOnVisible$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    int label;
    final /* synthetic */ GuestProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestProfileViewModel$followTipsOnVisible$1(long j, GuestProfileViewModel guestProfileViewModel, Continuation<? super GuestProfileViewModel$followTipsOnVisible$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
        this.this$0 = guestProfileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuestProfileViewModel$followTipsOnVisible$1(this.$delayTime, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuestProfileViewModel$followTipsOnVisible$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean z;
        boolean v0;
        Pair pair;
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
            long j = this.$delayTime;
            this.label = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        z = this.this$0.v;
        if (z) {
            g0 g0Var = (g0) this.this$0.j.getValue();
            boolean z2 = false;
            if (g0Var != null && c0.c(g0Var)) {
                z2 = true;
            }
            if (z2 && fl4.p.a.q(this.this$0.r0())) {
                v0 = this.this$0.v0();
                if (!v0) {
                    pair = this.this$0.B;
                    if (pair == null) {
                        this.this$0.B = TuplesKt.to(Boxing.boxBoolean(true), Boxing.boxInt(2));
                    }
                } else {
                    this.this$0.y.setValue(TuplesKt.to(Boxing.boxBoolean(true), Boxing.boxInt(2)));
                    this.this$0.c1();
                }
                return Unit.INSTANCE;
            }
        }
        this.this$0.D = true;
        return Unit.INSTANCE;
    }
}
