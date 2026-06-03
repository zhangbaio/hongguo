package com.dragon.read.kmp.reader.font;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.material.n2;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontItemMultiTypeKt$FontItemMultiType$1$1 implements PointerInputEventHandler {
    final /* synthetic */ CoroutineScope a;
    final /* synthetic */ a0 b;
    final /* synthetic */ Function0<Boolean> c;
    final /* synthetic */ n2 d;
    final /* synthetic */ Function0<Unit> e;

    FontItemMultiTypeKt$FontItemMultiType$1$1(CoroutineScope coroutineScope, a0 a0Var, Function0<Boolean> function0, n2 n2Var, Function0<Unit> function02) {
        this.a = coroutineScope;
        this.b = a0Var;
        this.c = function0;
        this.d = n2Var;
        this.e = function02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function0 function0, a0.f fVar) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final Object invoke(androidx.compose.ui.input.pointer.e0 e0Var, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        final CoroutineScope coroutineScope = this.a;
        final a0 a0Var = this.b;
        final Function0<Boolean> function0 = this.c;
        final n2 n2Var = this.d;
        Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.reader.font.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c;
                c = FontItemMultiTypeKt$FontItemMultiType$1$1.c(CoroutineScope.this, a0Var, function0, n2Var, (a0.f) obj);
                return c;
            }
        };
        final Function0<Unit> function02 = this.e;
        Object m = TapGestureDetectorKt.m(e0Var, (Function1) null, function1, (Function3) null, new Function1() { // from class: com.dragon.read.kmp.reader.font.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d;
                d = FontItemMultiTypeKt$FontItemMultiType$1$1.d(Function0.this, (a0.f) obj);
                return d;
            }
        }, continuation, 5, (Object) null);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (m == coroutine_suspended) {
            return m;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(CoroutineScope coroutineScope, a0 a0Var, Function0 function0, n2 n2Var, a0.f fVar) {
        kotlinx.coroutines.i.e(coroutineScope, null, null, new FontItemMultiTypeKt$FontItemMultiType$1$1$1$1(a0Var, function0, n2Var, null), 3, null);
        return Unit.INSTANCE;
    }
}
