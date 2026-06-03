package com.dragon.read.kmp.reader.ui.menu.ui;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.s2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.u1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.m0;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class PullDownBoxKt$PullDownBox$6$1$measurable$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Animatable<Float, androidx.compose.animation.core.m> a;
    final /* synthetic */ sm4.d b;
    final /* synthetic */ PointerEventPass c;
    final /* synthetic */ c d;
    final /* synthetic */ Function0<Unit> e;
    final /* synthetic */ Function0<Job> f;
    final /* synthetic */ CoroutineScope g;
    final /* synthetic */ State<Float> h;
    final /* synthetic */ Function4<androidx.compose.foundation.layout.r, s2, Composer, Integer, Unit> i;
    final /* synthetic */ s2 j;

    /* JADX WARN: Multi-variable type inference failed */
    PullDownBoxKt$PullDownBox$6$1$measurable$1(Animatable<Float, androidx.compose.animation.core.m> animatable, sm4.d dVar, PointerEventPass pointerEventPass, c cVar, Function0<Unit> function0, Function0<? extends Job> function02, CoroutineScope coroutineScope, State<Float> state, Function4<? super androidx.compose.foundation.layout.r, ? super s2, ? super Composer, ? super Integer, Unit> function4, s2 s2Var) {
        this.a = animatable;
        this.b = dVar;
        this.c = pointerEventPass;
        this.d = cVar;
        this.e = function0;
        this.f = function02;
        this.g = coroutineScope;
        this.h = state;
        this.i = function4;
        this.j = s2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        c(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(sm4.d dVar, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        a0.h c = androidx.compose.ui.layout.x.c(it2);
        dVar.c.a(c.a, c.b, c.c, c.d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.p d(Animatable animatable, x0.e offset) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        roundToInt = MathKt__MathJVMKt.roundToInt(((Number) animatable.k()).floatValue());
        return x0.p.c(x0.p.f((roundToInt & 4294967295L) | (0 << 32)));
    }

    public final void c(Composer composer, int i) {
        boolean z;
        if ((i & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (composer.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-685747311, i, -1, "com.dragon.read.kmp.reader.ui.menu.ui.PullDownBox.<anonymous>.<anonymous>.<anonymous> (PullDownBox.kt:157)");
            }
            Modifier B = SizeKt.B(SizeKt.h(BackgroundKt.d(Modifier.Companion, l0.b.g(), (f2) null, 2, (Object) null), 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null);
            composer.startReplaceGroup(5004770);
            boolean changedInstance = composer.changedInstance(this.a);
            final Animatable<Float, androidx.compose.animation.core.m> animatable = this.a;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.ui.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        x0.p d;
                        d = PullDownBoxKt$PullDownBox$6$1$measurable$1.d(animatable, (x0.e) obj);
                        return d;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier c = u1.c(B, (Function1) rememberedValue);
            composer.startReplaceGroup(5004770);
            boolean changed = composer.changed(this.b);
            final sm4.d dVar = this.b;
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.ui.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e;
                        e = PullDownBoxKt$PullDownBox$6$1$measurable$1.e(sm4.d.this, (androidx.compose.ui.layout.w) obj);
                        return e;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            Modifier a = d1.a(c, (Function1) rememberedValue2);
            PointerEventPass pointerEventPass = this.c;
            composer.startReplaceGroup(-1224400529);
            boolean changedInstance2 = composer.changedInstance(this.d) | composer.changed(this.b) | composer.changed(this.e) | composer.changedInstance(this.a) | composer.changed(this.f) | composer.changedInstance(this.g) | composer.changed(this.c.ordinal());
            PointerEventPass pointerEventPass2 = this.c;
            c cVar = this.d;
            sm4.d dVar2 = this.b;
            Function0<Unit> function0 = this.e;
            Animatable<Float, androidx.compose.animation.core.m> animatable2 = this.a;
            Function0<Job> function02 = this.f;
            State<Float> state = this.h;
            CoroutineScope coroutineScope = this.g;
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new PullDownBoxKt$PullDownBox$6$1$measurable$1$3$1(pointerEventPass2, cVar, dVar2, function0, animatable2, function02, state, coroutineScope);
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            Modifier c2 = m0.c(a, pointerEventPass, (PointerInputEventHandler) rememberedValue3);
            Function4<androidx.compose.foundation.layout.r, s2, Composer, Integer, Unit> function4 = this.i;
            s2 s2Var = this.j;
            p0 i2 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
            e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(composer, c2);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(a3);
            } else {
                composer.useNode();
            }
            Composer b = g5.b(composer);
            g5.e(b, i2, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            function4.invoke(BoxScopeInstance.a, s2Var, composer, 6);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
