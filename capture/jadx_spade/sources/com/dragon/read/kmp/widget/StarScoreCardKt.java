package com.dragon.read.kmp.widget;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.e;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StarScoreCardKt {
    static {
        Covode.recordClassIndex(609666);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(int i, int i2, y1 y1Var, y1 y1Var2, y1 y1Var3, Function1 function1, Function2 function2, s1 s1Var, Function1 function12, boolean z, boolean z2, boolean z3, float f, float f2, e.e eVar, Modifier modifier, int i3, int i4, int i5, Composer composer, int i6) {
        g(i, i2, y1Var, y1Var2, y1Var3, function1, function2, s1Var, function12, z, z2, z3, f, f2, eVar, modifier, composer, x2.a(i3 | 1), x2.a(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(int i, int i2, y1 y1Var, y1 y1Var2, y1 y1Var3, Function1 function1, Function2 function2, s1 s1Var, Function1 function12, boolean z, boolean z2, boolean z3, float f, float f2, e.e eVar, Modifier modifier, int i3, int i4, int i5, Composer composer, int i6) {
        g(i, i2, y1Var, y1Var2, y1Var3, function1, function2, s1Var, function12, z, z2, z3, f, f2, eVar, modifier, composer, x2.a(i3 | 1), x2.a(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(y1 y1Var, Modifier modifier, int i, int i2, Composer composer, int i3) {
        s(y1Var, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(boolean z) {
        return Unit.INSTANCE;
    }

    private static final a0.h[] i(MutableState<a0.h[]> mutableState) {
        return (a0.h[]) mutableState.getValue();
    }

    private static final a0.h[] r(MutableState<a0.h[]> mutableState) {
        return (a0.h[]) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    private static final int o(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    private static final boolean p(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> a;

        a(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1896549116, i, -1, "com.dragon.read.kmp.widget.StarScoreCard.<anonymous> (StarScoreCard.kt:184)");
                }
                this.a.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final class b implements androidx.compose.ui.window.l {
        final /* synthetic */ x0.e a;
        final /* synthetic */ a0.h b;
        final /* synthetic */ s1 c;

        b(x0.e eVar, a0.h hVar, s1 s1Var) {
            this.a = eVar;
            this.b = hVar;
            this.c = s1Var;
        }

        public long a(x0.r anchorBounds, long j, LayoutDirection layoutDirection, long j2) {
            Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            this.a.x0(this.c.a());
            MathKt__MathJVMKt.roundToInt(Float.intBitsToFloat((int) (this.b.h() >> 32)));
            int i = ((int) (j2 >> 32)) / 2;
            return x0.p.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(int i, MutableState mutableState, MutableState mutableState2, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        r(mutableState)[i] = androidx.compose.ui.layout.x.a(it2);
        i(mutableState2)[i] = androidx.compose.ui.layout.x.c(it2);
        return Unit.INSTANCE;
    }

    private static final androidx.compose.ui.window.l w(s1 s1Var, a0.h hVar, Composer composer, int i) {
        boolean z;
        composer.startReplaceGroup(-427651981);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-427651981, i, -1, "com.dragon.read.kmp.widget.rememberPopupProvider (StarScoreCard.kt:209)");
        }
        x0.e eVar = (x0.e) composer.consume(CompositionLocalsKt.f());
        x0.e eVar2 = (x0.e) composer.consume(CompositionLocalsKt.f());
        composer.startReplaceGroup(-1746271574);
        boolean z2 = false;
        if ((((i & 14) ^ 6) > 4 && composer.changed(s1Var)) || (i & 6) == 4) {
            z = true;
        } else {
            z = false;
        }
        if ((((i & 112) ^ 48) > 32 && composer.changed(hVar)) || (i & 48) == 32) {
            z2 = true;
        }
        boolean changed = z | z2 | composer.changed(eVar2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new b(eVar, hVar, s1Var);
            composer.updateRememberedValue(rememberedValue);
        }
        b bVar = (b) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(boolean z, int i, MutableState mutableState, androidx.compose.ui.input.pointer.e0 scope, float f) {
        int i2;
        boolean z2;
        int i3;
        int coerceIn;
        boolean z3;
        Intrinsics.checkNotNullParameter(scope, "$this$scope");
        int length = r(mutableState).length;
        int i4 = 0;
        while (true) {
            i2 = 1;
            if (i4 < length) {
                if (!(!r9[i4].q())) {
                    z2 = false;
                    break;
                }
                i4++;
            } else {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            return 0;
        }
        a0.h[] r = r(mutableState);
        int length2 = r.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i5 = length2 - 1;
                if (r[length2].a <= f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    break;
                }
                if (i5 < 0) {
                    break;
                }
                length2 = i5;
            }
        }
        length2 = -1;
        if (length2 == -1) {
            return 0;
        }
        if (!z) {
            i3 = (length2 * 2) + 2;
        } else {
            a0.h hVar = r(mutableState)[length2];
            int i6 = length2 * 2;
            if (f > Float.intBitsToFloat((int) (hVar.h() >> 32))) {
                i2 = 2;
            }
            i3 = i6 + i2;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(i3, 0, i * 2);
        return coerceIn;
    }

    private static final void s(final y1 y1Var, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(1712371466);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(y1Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1712371466, i3, -1, "com.dragon.read.kmp.widget.StarScoreItem (StarScoreCard.kt:193)");
            }
            androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i7, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            androidx.compose.foundation.z0.c(org.jetbrains.compose.resources.c.b(y1Var.a, startRestartGroup, 0), (String) null, boxScopeInstance.a(Modifier.Companion), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, y1Var.b, startRestartGroup, 48, 56);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.e2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t;
                    t = StarScoreCardKt.t(y1.this, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return t;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(final int r32, final int r33, final com.dragon.read.kmp.widget.y1 r34, final com.dragon.read.kmp.widget.y1 r35, final com.dragon.read.kmp.widget.y1 r36, final kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, com.dragon.read.kmp.widget.s1 r39, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r40, boolean r41, boolean r42, boolean r43, float r44, float r45, androidx.compose.foundation.layout.e.e r46, androidx.compose.ui.Modifier r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.StarScoreCardKt.g(int, int, com.dragon.read.kmp.widget.y1, com.dragon.read.kmp.widget.y1, com.dragon.read.kmp.widget.y1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, com.dragon.read.kmp.widget.s1, kotlin.jvm.functions.Function1, boolean, boolean, boolean, float, float, androidx.compose.foundation.layout.e$e, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
