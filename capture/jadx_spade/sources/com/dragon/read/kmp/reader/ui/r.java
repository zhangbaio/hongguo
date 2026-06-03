package com.dragon.read.kmp.reader.ui;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.b1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.ui.r;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    static {
        Covode.recordClassIndex(608593);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(List list, int i, Function1 function1, long j, long j2, long j3, long j4, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        c(list, i, function1, j, j2, j3, j4, modifier, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(List list, int i, Function1 function1, long j, long j2, long j3, long j4, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        c(list, i, function1, j, j2, j3, j4, modifier, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ List<String> b;
        final /* synthetic */ int c;
        final /* synthetic */ long d;
        final /* synthetic */ Function1<Integer, Unit> e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;

        /* JADX WARN: Multi-variable type inference failed */
        a(float f, List<String> list, int i, long j, Function1<? super Integer, Unit> function1, long j2, long j3) {
            this.a = f;
            this.b = list;
            this.c = i;
            this.d = j;
            this.e = function1;
            this.f = j2;
            this.g = j3;
        }

        private static final float c(State<x0.i> state) {
            return ((x0.i) state.getValue()).m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(Function1 function1, int i) {
            function1.invoke(Integer.valueOf(i));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            b(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            long j;
            int i3;
            int i4;
            Composer composer2 = composer;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer2.changed(BoxWithConstraints)) {
                    i4 = 4;
                } else {
                    i4 = 2;
                }
                i2 = i | i4;
            } else {
                i2 = i;
            }
            int i5 = 1;
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer2.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-861416212, i2, -1, "com.dragon.read.kmp.reader.ui.MultipleOptionsView.<anonymous> (MultipleOptionsView.kt:65)");
                }
                float g = x0.i.g(x0.i.g(BoxWithConstraints.g() - x0.i.g(this.a * 2)) / this.b.size());
                Object obj = null;
                State d = AnimateAsStateKt.d(x0.i.g(this.c * g), androidx.compose.animation.core.j.n(300, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null), (String) null, (Function1) null, composer, 48, 12);
                Modifier.a aVar = Modifier.Companion;
                float f = 0.0f;
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.d(SizeKt.x(f2.r(u1.f(aVar, c(d), 0.0f, 2, (Object) null), this.a), g), 0.0f, 1, (Object) null), k.g.c(x0.i.g(6))), this.d, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer2, 0);
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                List<String> list = this.b;
                final Function1<Integer, Unit> function1 = this.e;
                int i6 = this.c;
                long j2 = this.f;
                long j3 = this.g;
                p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.l(), composer2, 0);
                int a = j.a(androidx.compose.runtime.i.b(composer2, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer2, h);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer2.createNode(a2);
                } else {
                    composer.useNode();
                }
                Composer b2 = g5.b(composer);
                g5.e(b2, b, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e, companion.d());
                w2 w2Var = w2.b;
                composer2.startReplaceGroup(625933774);
                final int i7 = 0;
                for (Object obj2 : list) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    String str = (String) obj2;
                    Modifier d2 = SizeKt.d(u2.a(w2Var, Modifier.Companion, 1.0f, false, 2, (Object) null), f, i5, obj);
                    composer2.startReplaceGroup(1849434622);
                    Object rememberedValue = composer.rememberedValue();
                    Composer.Companion companion2 = Composer.Companion;
                    if (rememberedValue == companion2.getEmpty()) {
                        rememberedValue = androidx.compose.foundation.interaction.h.a();
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    androidx.compose.foundation.interaction.i iVar = (androidx.compose.foundation.interaction.i) rememberedValue;
                    composer.endReplaceGroup();
                    composer2.startReplaceGroup(-1633490746);
                    boolean changed = composer2.changed(function1) | composer2.changed(i7);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changed || rememberedValue2 == companion2.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.ui.q
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit d3;
                                d3 = r.a.d(Function1.this, i7);
                                return d3;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    Modifier modifier = ClickableKt.clickable-O2vRcR0$default(d2, iVar, (b1) null, false, (String) null, (Role) null, (Function0) rememberedValue2, 28, (Object) null);
                    p0 i9 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                    int a3 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                    e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer2, modifier);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.o0;
                    Function0 a4 = companion3.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer2.createNode(a4);
                    } else {
                        composer.useNode();
                    }
                    Composer b4 = g5.b(composer);
                    g5.e(b4, i9, companion3.c());
                    g5.e(b4, currentCompositionLocalMap2, companion3.e());
                    Function2 b5 = companion3.b();
                    if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a3))) {
                        b4.updateRememberedValue(Integer.valueOf(a3));
                        b4.apply(Integer.valueOf(a3), b5);
                    }
                    g5.e(b4, e2, companion3.d());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                    int a5 = w0.h.b.a();
                    long h2 = x0.x.h(12);
                    if (i6 == i7) {
                        j = j2;
                    } else {
                        j = j3;
                    }
                    if (i6 == i7) {
                        i3 = 500;
                    } else {
                        i3 = 400;
                    }
                    a6.j(str, (Modifier) null, j, h2, (androidx.compose.ui.text.font.y) null, r.g(i3, false, 2, obj), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a5), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 130514);
                    composer.endNode();
                    composer2 = composer;
                    i7 = i8;
                    function1 = function1;
                    j2 = j2;
                    j3 = j3;
                    obj = obj;
                    i6 = i6;
                    f = 0.0f;
                    i5 = 1;
                }
                composer.endReplaceGroup();
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

    private static final androidx.compose.ui.text.font.c0 f(int i, boolean z) {
        if (com.dragon.read.kmp.reader.services.x.a.f().o7()) {
            if (i >= 500 && z) {
                return androidx.compose.ui.text.font.c0.b.a();
            }
            return androidx.compose.ui.text.font.c0.b.e();
        }
        return new androidx.compose.ui.text.font.c0(i);
    }

    static /* synthetic */ androidx.compose.ui.text.font.c0 g(int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return f(i, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final java.util.List<java.lang.String> r29, final int r30, final kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r31, long r32, long r34, long r36, long r38, androidx.compose.ui.Modifier r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.ui.r.c(java.util.List, int, kotlin.jvm.functions.Function1, long, long, long, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
