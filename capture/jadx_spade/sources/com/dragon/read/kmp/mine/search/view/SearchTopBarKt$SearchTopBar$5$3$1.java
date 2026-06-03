package com.dragon.read.kmp.mine.search.view;

import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.u2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.search.view.SearchTopBarKt$SearchTopBar$5$3$1", f = "SearchTopBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SearchTopBarKt$SearchTopBar$5$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ u2 $keyboardController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchTopBarKt$SearchTopBar$5$3$1(FocusRequester focusRequester, u2 u2Var, Continuation<? super SearchTopBarKt$SearchTopBar$5$3$1> continuation) {
        super(2, continuation);
        this.$focusRequester = focusRequester;
        this.$keyboardController = u2Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchTopBarKt$SearchTopBar$5$3$1(this.$focusRequester, this.$keyboardController, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchTopBarKt$SearchTopBar$5$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FocusRequester.f(this.$focusRequester, 0, 1, (Object) null);
            u2 u2Var = this.$keyboardController;
            if (u2Var != null) {
                u2Var.show();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
