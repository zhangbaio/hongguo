package com.dragon.read.kmp.mine.profile;

import androidx.compose.material.n2;
import androidx.compose.runtime.MutableState;
import com.bytedance.kmp.reading.model.Gender;
import com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.profile.MineChangeProfilePageKt$NewGenderBottomDialog$1$1$1$1$1", f = "MineChangeProfilePage.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class MineChangeProfilePageKt$NewGenderBottomDialog$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Gender> $selectedGender$delegate;
    final /* synthetic */ n2 $sheetState;
    final /* synthetic */ a0 $userInfo;
    final /* synthetic */ ChangeProfilePageViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MineChangeProfilePageKt$NewGenderBottomDialog$1$1$1$1$1(a0 a0Var, ChangeProfilePageViewModel changeProfilePageViewModel, n2 n2Var, MutableState<Gender> mutableState, Continuation<? super MineChangeProfilePageKt$NewGenderBottomDialog$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$userInfo = a0Var;
        this.$viewModel = changeProfilePageViewModel;
        this.$sheetState = n2Var;
        this.$selectedGender$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MineChangeProfilePageKt$NewGenderBottomDialog$1$1$1$1$1(this.$userInfo, this.$viewModel, this.$sheetState, this.$selectedGender$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MineChangeProfilePageKt$NewGenderBottomDialog$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
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
            MineChangeProfilePageKt.O0(this.$selectedGender$delegate, (Gender) this.$userInfo.f.getValue());
            this.$viewModel.o = false;
            n2 n2Var = this.$sheetState;
            this.label = 1;
            if (n2Var.l(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
