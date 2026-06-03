package com.dragon.read.kmp.mine.account;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.n1;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.u2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.account.ChangePhonePageKt$PhoneInput$1$1", f = "ChangePhonePage.kt", i = {}, l = {741}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChangePhonePageKt$PhoneInput$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ u2 $keyboardController;
    final /* synthetic */ MutableState<Boolean> $requestFocusAfterClear$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangePhonePageKt$PhoneInput$1$1(FocusRequester focusRequester, u2 u2Var, MutableState<Boolean> mutableState, Continuation<? super ChangePhonePageKt$PhoneInput$1$1> continuation) {
        super(2, continuation);
        this.$focusRequester = focusRequester;
        this.$keyboardController = u2Var;
        this.$requestFocusAfterClear$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangePhonePageKt$PhoneInput$1$1(this.$focusRequester, this.$keyboardController, this.$requestFocusAfterClear$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChangePhonePageKt$PhoneInput$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(long j) {
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean f0;
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
            f0 = ChangePhonePageKt.f0(this.$requestFocusAfterClear$delegate);
            if (f0) {
                Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.mine.account.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ChangePhonePageKt$PhoneInput$1$1.invokeSuspend$lambda$0(((Long) obj2).longValue());
                        return invokeSuspend$lambda$0;
                    }
                };
                this.label = 1;
                if (n1.c(function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        FocusRequester.f(this.$focusRequester, 0, 1, (Object) null);
        u2 u2Var = this.$keyboardController;
        if (u2Var != null) {
            u2Var.show();
        }
        ChangePhonePageKt.g0(this.$requestFocusAfterClear$delegate, false);
        return Unit.INSTANCE;
    }
}
