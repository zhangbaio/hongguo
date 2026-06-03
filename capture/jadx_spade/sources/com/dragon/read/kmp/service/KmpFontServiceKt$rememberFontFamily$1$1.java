package com.dragon.read.kmp.service;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.service.KmpFontServiceKt$rememberFontFamily$1$1", f = "KmpFontService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpFontServiceKt$rememberFontFamily$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fontFamily;
    final /* synthetic */ MutableState<androidx.compose.ui.text.font.j> $fontFamilyState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpFontServiceKt$rememberFontFamily$1$1(String str, MutableState<androidx.compose.ui.text.font.j> mutableState, Continuation<? super KmpFontServiceKt$rememberFontFamily$1$1> continuation) {
        super(2, continuation);
        this.$fontFamily = str;
        this.$fontFamilyState = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpFontServiceKt$rememberFontFamily$1$1(this.$fontFamily, this.$fontFamilyState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpFontServiceKt$rememberFontFamily$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            s0 s0Var = s0.a;
            String str = this.$fontFamily;
            final MutableState<androidx.compose.ui.text.font.j> mutableState = this.$fontFamilyState;
            s0Var.b(str, new Function1() { // from class: com.dragon.read.kmp.service.t0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = KmpFontServiceKt$rememberFontFamily$1$1.invokeSuspend$lambda$0(mutableState, (androidx.compose.ui.text.font.j) obj2);
                    return invokeSuspend$lambda$0;
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MutableState mutableState, androidx.compose.ui.text.font.j jVar) {
        if (jVar != null) {
            mutableState.setValue(jVar);
        }
        return Unit.INSTANCE;
    }
}
