package com.dragon.read.kmp.reader.ui.menu.ui;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.gestures.s2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.x2;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.layout.b2;
import androidx.compose.ui.layout.n0;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.layout.r0;
import androidx.compose.ui.layout.s0;
import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PullDownBoxKt {
    static {
        Covode.recordClassIndex(608644);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(sm4.d dVar, Function0 function0, v vVar, Function4 function4, int i, int i2, Composer composer, int i3) {
        l(dVar, function0, vVar, function4, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        return Unit.INSTANCE;
    }

    public static final class a implements DisposableEffectResult {
        final /* synthetic */ v a;
        final /* synthetic */ s2 b;

        public void dispose() {
            v vVar = this.a;
            if (vVar != null) {
                LazyListState lazyListState = this.b;
                if (lazyListState instanceof LazyListState) {
                    vVar.a = lazyListState.u();
                    this.a.b = this.b.v();
                } else if (lazyListState instanceof LazyGridState) {
                    vVar.a = ((LazyGridState) lazyListState).u();
                    this.a.b = this.b.v();
                }
            }
        }

        public a(v vVar, s2 s2Var) {
            this.a = vVar;
            this.b = s2Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float w(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float z(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final void x(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float y(float f, MutableState mutableState) {
        return w(mutableState) * f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult q(v vVar, s2 s2Var, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new a(vVar, s2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(p1 p1Var, int i, p1.a layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        p1.a.G(layout, p1Var, 0, i, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job p(CoroutineScope coroutineScope, Animatable animatable, float f, androidx.compose.animation.core.s2 s2Var) {
        Job e;
        e = kotlinx.coroutines.i.e(coroutineScope, null, null, new PullDownBoxKt$PullDownBox$halfExpand$1$1$1(animatable, f, s2Var, null), 3, null);
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(sm4.d dVar, Animatable animatable, MutableState mutableState, androidx.compose.ui.graphics.drawscope.f drawBehind) {
        float coerceIn;
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        if (dVar.c() && w(mutableState) > 0.0f) {
            coerceIn = RangesKt___RangesKt.coerceIn(((Number) animatable.k()).floatValue() / w(mutableState), 0.0f, 1.0f);
            DrawScope.-CC.p(drawBehind, l0.n(l0.b.a(), (1 - coerceIn) * 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (m0) null, 0, 126, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job n(CoroutineScope coroutineScope, sm4.d dVar, Animatable animatable, androidx.compose.animation.core.s2 s2Var, MutableState mutableState) {
        Job e;
        e = kotlinx.coroutines.i.e(coroutineScope, null, null, new PullDownBoxKt$PullDownBox$dismiss$1$1$1(dVar, animatable, s2Var, mutableState, null), 3, null);
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job o(CoroutineScope coroutineScope, sm4.d dVar, Animatable animatable, float f, androidx.compose.animation.core.s2 s2Var, MutableState mutableState) {
        Job e;
        e = kotlinx.coroutines.i.e(coroutineScope, null, null, new PullDownBoxKt$PullDownBox$show$1$1$1(dVar, animatable, f, s2Var, mutableState, null), 3, null);
        return e;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x035a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void l(final sm4.d r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, com.dragon.read.kmp.reader.ui.menu.ui.v r36, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.r, ? super androidx.compose.foundation.gestures.s2, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 1072
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.ui.menu.ui.PullDownBoxKt.l(sm4.d, kotlin.jvm.functions.Function0, com.dragon.read.kmp.reader.ui.menu.ui.v, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r0 t(Animatable animatable, sm4.d dVar, PointerEventPass pointerEventPass, c cVar, Function0 function0, Function0 function02, CoroutineScope coroutineScope, State state, Function4 function4, s2 s2Var, MutableState mutableState, b2 SubcomposeLayout, x0.b bVar) {
        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
        boolean z = true;
        final p1 L = ((n0) CollectionsKt___CollectionsKt.first(SubcomposeLayout.I1("measure", androidx.compose.runtime.internal.t.c(-685747311, true, new PullDownBoxKt$PullDownBox$6$1$measurable$1(animatable, dVar, pointerEventPass, cVar, function0, function02, coroutineScope, state, function4, s2Var))))).L(x0.b.d(bVar.r(), 0, 0, 0, 0, 11, (Object) null));
        float w = w(mutableState);
        int i = L.b;
        if (w != i) {
            z = false;
        }
        if (!z) {
            x(mutableState, i);
        }
        int k = x0.b.k(bVar.r());
        final int i2 = k - L.b;
        return s0.b(SubcomposeLayout, L.a, k, (Map) null, new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.ui.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u;
                u = PullDownBoxKt.u(L, i2, (p1.a) obj);
                return u;
            }
        }, 4, (Object) null);
    }
}
