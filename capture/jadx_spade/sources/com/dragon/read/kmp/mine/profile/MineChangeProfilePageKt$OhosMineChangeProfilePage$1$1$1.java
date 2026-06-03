package com.dragon.read.kmp.mine.profile;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.profile.MineChangeProfilePageKt$OhosMineChangeProfilePage$1$1$1", f = "MineChangeProfilePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class MineChangeProfilePageKt$OhosMineChangeProfilePage$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a2 $param;
    final /* synthetic */ a0 $userInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MineChangeProfilePageKt$OhosMineChangeProfilePage$1$1$1(a0 a0Var, a2 a2Var, Continuation<? super MineChangeProfilePageKt$OhosMineChangeProfilePage$1$1$1> continuation) {
        super(2, continuation);
        this.$userInfo = a0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MineChangeProfilePageKt$OhosMineChangeProfilePage$1$1$1(this.$userInfo, null, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MineChangeProfilePageKt$OhosMineChangeProfilePage$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableState<String> mutableState = this.$userInfo.a;
        throw null;
    }
}
