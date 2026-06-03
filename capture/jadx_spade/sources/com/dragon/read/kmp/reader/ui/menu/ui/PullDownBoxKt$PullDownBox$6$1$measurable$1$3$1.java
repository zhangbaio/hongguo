package com.dragon.read.kmp.reader.ui.menu.ui;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.State;
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
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class PullDownBoxKt$PullDownBox$6$1$measurable$1$3$1 implements PointerInputEventHandler {
    final /* synthetic */ PointerEventPass a;
    final /* synthetic */ c b;
    final /* synthetic */ sm4.d c;
    final /* synthetic */ Function0<Unit> d;
    final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> e;
    final /* synthetic */ Function0<Job> f;
    final /* synthetic */ State<Float> g;
    final /* synthetic */ CoroutineScope h;

    /* JADX WARN: Multi-variable type inference failed */
    PullDownBoxKt$PullDownBox$6$1$measurable$1$3$1(PointerEventPass pointerEventPass, c cVar, sm4.d dVar, Function0<Unit> function0, Animatable<Float, androidx.compose.animation.core.m> animatable, Function0<? extends Job> function02, State<Float> state, CoroutineScope coroutineScope) {
        this.a = pointerEventPass;
        this.b = cVar;
        this.c = dVar;
        this.d = function0;
        this.e = animatable;
        this.f = function02;
        this.g = state;
        this.h = coroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final Object invoke(e0 e0Var, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        final c cVar = this.b;
        final sm4.d dVar = this.c;
        final Function0<Unit> function0 = this.d;
        final Animatable<Float, androidx.compose.animation.core.m> animatable = this.e;
        final Function0<Job> function02 = this.f;
        final State<Float> state = this.g;
        Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.ui.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d;
                d = PullDownBoxKt$PullDownBox$6$1$measurable$1$3$1.d(c.this, dVar, function0, animatable, function02, state, ((Float) obj).floatValue());
                return d;
            }
        };
        final Function0<Job> function03 = this.f;
        Function0 function04 = new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.ui.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e;
                e = PullDownBoxKt$PullDownBox$6$1$measurable$1$3$1.e(Function0.this);
                return e;
            }
        };
        final Animatable<Float, androidx.compose.animation.core.m> animatable2 = this.e;
        final CoroutineScope coroutineScope = this.h;
        Object h = GestureKt.h(e0Var, null, function1, function04, new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.ui.u
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit f;
                f = PullDownBoxKt$PullDownBox$6$1$measurable$1$3$1.f(animatable2, coroutineScope, (androidx.compose.ui.input.pointer.w) obj, ((Float) obj2).floatValue());
                return f;
            }
        }, this.a, continuation, 1, null);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (h == coroutine_suspended) {
            return h;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Animatable animatable, CoroutineScope coroutineScope, androidx.compose.ui.input.pointer.w change, float f) {
        float coerceAtLeast;
        Intrinsics.checkNotNullParameter(change, "change");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((Number) animatable.k()).floatValue() + f, 0.0f);
        kotlinx.coroutines.i.e(coroutineScope, null, null, new PullDownBoxKt$PullDownBox$6$1$measurable$1$3$1$3$1(animatable, coerceAtLeast, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(c cVar, sm4.d dVar, Function0 function0, Animatable animatable, Function0 function02, State state, float f) {
        float z;
        if (f < -100.0f) {
            cVar.a(dVar, true);
            function0.invoke();
        } else {
            float floatValue = ((Number) animatable.k()).floatValue();
            z = PullDownBoxKt.z(state);
            if (floatValue > z) {
                cVar.a(dVar, true);
                function0.invoke();
            } else {
                function02.invoke();
            }
        }
        return Unit.INSTANCE;
    }
}
