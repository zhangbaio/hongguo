package com.dragon.read.kmp.widget;

import androidx.compose.ui.text.f3;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.widget.BasicTextFieldWithPlaceHolder_androidKt$BasicTextFieldPlaceHolder$1$1$1", f = "BasicTextFieldWithPlaceHolder.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BasicTextFieldWithPlaceHolder_androidKt$BasicTextFieldPlaceHolder$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o.l $textFieldState;
    final /* synthetic */ String $value;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicTextFieldWithPlaceHolder_androidKt$BasicTextFieldPlaceHolder$1$1$1(o.l lVar, String str, Continuation<? super BasicTextFieldWithPlaceHolder_androidKt$BasicTextFieldPlaceHolder$1$1$1> continuation) {
        super(2, continuation);
        this.$textFieldState = lVar;
        this.$value = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BasicTextFieldWithPlaceHolder_androidKt$BasicTextFieldPlaceHolder$1$1$1(this.$textFieldState, this.$value, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BasicTextFieldWithPlaceHolder_androidKt$BasicTextFieldPlaceHolder$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual(this.$textFieldState.h().toString(), this.$value)) {
                o.l lVar = this.$textFieldState;
                String str = this.$value;
                o.f o = lVar.o();
                try {
                    long j = o.e;
                    o.k(0, o.h(), str);
                    o.r(f3.c(j, 0, str.length()));
                    lVar.d(o);
                } finally {
                    lVar.f();
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
