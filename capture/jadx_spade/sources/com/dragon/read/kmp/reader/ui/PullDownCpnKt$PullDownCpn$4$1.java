package com.dragon.read.kmp.reader.ui;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.s2;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.e0;
import com.dragon.read.kmp.reader.utils.GestureKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class PullDownCpnKt$PullDownCpn$4$1 implements PointerInputEventHandler {
    final /* synthetic */ PointerEventPass a;
    final /* synthetic */ Function0<Unit> b;
    final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> c;
    final /* synthetic */ float d;
    final /* synthetic */ CoroutineScope e;
    final /* synthetic */ float f;
    final /* synthetic */ s2<Float> g;

    PullDownCpnKt$PullDownCpn$4$1(PointerEventPass pointerEventPass, Function0<Unit> function0, Animatable<Float, androidx.compose.animation.core.m> animatable, float f, CoroutineScope coroutineScope, float f2, s2<Float> s2Var) {
        this.a = pointerEventPass;
        this.b = function0;
        this.c = animatable;
        this.d = f;
        this.e = coroutineScope;
        this.f = f2;
        this.g = s2Var;
    }

    public final Object invoke(e0 e0Var, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        final Function0<Unit> function0 = this.b;
        final Animatable<Float, androidx.compose.animation.core.m> animatable = this.c;
        final float f = this.d;
        final CoroutineScope coroutineScope = this.e;
        final float f2 = this.f;
        final s2<Float> s2Var = this.g;
        Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d;
                d = PullDownCpnKt$PullDownCpn$4$1.d(Function0.this, animatable, f, coroutineScope, f2, s2Var, ((Float) obj).floatValue());
                return d;
            }
        };
        final CoroutineScope coroutineScope2 = this.e;
        final Animatable<Float, androidx.compose.animation.core.m> animatable2 = this.c;
        final float f3 = this.f;
        final s2<Float> s2Var2 = this.g;
        Function0 function02 = new Function0() { // from class: com.dragon.read.kmp.reader.ui.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e;
                e = PullDownCpnKt$PullDownCpn$4$1.e(CoroutineScope.this, animatable2, f3, s2Var2);
                return e;
            }
        };
        final Animatable<Float, androidx.compose.animation.core.m> animatable3 = this.c;
        final CoroutineScope coroutineScope3 = this.e;
        Object h = GestureKt.h(e0Var, null, function1, function02, new Function2() { // from class: com.dragon.read.kmp.reader.ui.w
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit f4;
                f4 = PullDownCpnKt$PullDownCpn$4$1.f(animatable3, coroutineScope3, (androidx.compose.ui.input.pointer.w) obj, ((Float) obj2).floatValue());
                return f4;
            }
        }, this.a, continuation, 1, null);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (h == coroutine_suspended) {
            return h;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(CoroutineScope coroutineScope, Animatable animatable, float f, s2 s2Var) {
        kotlinx.coroutines.i.e(coroutineScope, null, null, new PullDownCpnKt$PullDownCpn$4$1$2$1(animatable, f, s2Var, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Animatable animatable, CoroutineScope coroutineScope, androidx.compose.ui.input.pointer.w change, float f) {
        float coerceAtLeast;
        Intrinsics.checkNotNullParameter(change, "change");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((Number) animatable.k()).floatValue() + f, 0.0f);
        kotlinx.coroutines.i.e(coroutineScope, null, null, new PullDownCpnKt$PullDownCpn$4$1$3$1(animatable, coerceAtLeast, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function0 function0, Animatable animatable, float f, CoroutineScope coroutineScope, float f2, s2 s2Var, float f3) {
        if (f3 < -100.0f) {
            function0.invoke();
        } else if (((Number) animatable.k()).floatValue() <= f) {
            kotlinx.coroutines.i.e(coroutineScope, null, null, new PullDownCpnKt$PullDownCpn$4$1$1$1(animatable, f2, s2Var, null), 3, null);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
