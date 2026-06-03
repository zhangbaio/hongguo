package com.dragon.read.kmp.mine.account;

import androidx.compose.runtime.n1;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.u2;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.account.ChangePhonePageKt$VerifyPhonePage$1$1", f = "ChangePhonePage.kt", i = {0}, l = {294}, m = "invokeSuspend", n = {"key"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChangePhonePageKt$VerifyPhonePage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $codeFocusRequester;
    final /* synthetic */ Set<String> $focusedSteps;
    final /* synthetic */ u2 $keyboardController;
    final /* synthetic */ FocusRequester $phoneFocusRequester;
    final /* synthetic */ StepKey $stepKey;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangePhonePageKt$VerifyPhonePage$1$1(StepKey stepKey, Set<String> set, FocusRequester focusRequester, FocusRequester focusRequester2, u2 u2Var, Continuation<? super ChangePhonePageKt$VerifyPhonePage$1$1> continuation) {
        super(2, continuation);
        this.$stepKey = stepKey;
        this.$focusedSteps = set;
        this.$phoneFocusRequester = focusRequester;
        this.$codeFocusRequester = focusRequester2;
        this.$keyboardController = u2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangePhonePageKt$VerifyPhonePage$1$1(this.$stepKey, this.$focusedSteps, this.$phoneFocusRequester, this.$codeFocusRequester, this.$keyboardController, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChangePhonePageKt$VerifyPhonePage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(long j) {
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            String name = this.$stepKey.name();
            if (!this.$focusedSteps.contains(name)) {
                Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.mine.account.m0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ChangePhonePageKt$VerifyPhonePage$1$1.invokeSuspend$lambda$0(((Long) obj2).longValue());
                        return invokeSuspend$lambda$0;
                    }
                };
                this.L$0 = name;
                this.label = 1;
                if (n1.c(function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = name;
            }
            return Unit.INSTANCE;
        }
        StepKey stepKey = this.$stepKey;
        if (stepKey != StepKey.OLD_PHONE && stepKey != StepKey.NEW_PHONE) {
            FocusRequester.f(this.$codeFocusRequester, 0, 1, (Object) null);
        } else {
            FocusRequester.f(this.$phoneFocusRequester, 0, 1, (Object) null);
        }
        u2 u2Var = this.$keyboardController;
        if (u2Var != null) {
            u2Var.show();
        }
        this.$focusedSteps.add(str);
        return Unit.INSTANCE;
    }
}
