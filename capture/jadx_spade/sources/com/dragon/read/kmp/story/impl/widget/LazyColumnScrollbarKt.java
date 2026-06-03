package com.dragon.read.kmp.story.impl.widget;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.x;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.v1;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.t;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LazyColumnScrollbarKt {
    static {
        Covode.recordClassIndex(609429);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(LazyListState lazyListState, Modifier modifier, float f, float f2, float f3, int i, int i2, Composer composer, int i3) {
        i(lazyListState, modifier, f, f2, f3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(LazyListState lazyListState, Modifier modifier, float f, float f2, float f3, int i, int i2, Composer composer, int i3) {
        i(lazyListState, modifier, f, f2, f3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(LazyListState lazyListState, Modifier modifier, float f, float f2, float f3, int i, int i2, Composer composer, int i3) {
        i(lazyListState, modifier, f, f2, f3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> B(State<? extends Function0<Unit>> state) {
        return (Function0) state.getValue();
    }

    private static final float k(v1 v1Var) {
        return v1Var.getFloatValue();
    }

    private static final q n(State<q> state) {
        return (q) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Float, Job> x(State<? extends Function1<? super Float, ? extends Job>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Float, Boolean> z(State<? extends Function1<? super Float, Boolean>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final boolean H(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final float o(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float p(State<x0.i> state) {
        return ((x0.i) state.getValue()).m();
    }

    private static final float r(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float t(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float u(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q m(LazyListState lazyListState) {
        int i;
        x x = lazyListState.x();
        List h = x.h();
        if (h.isEmpty()) {
            return null;
        }
        int f = x.f();
        int u = lazyListState.u();
        int v = lazyListState.v();
        float a = (int) (x.a() & 4294967295L);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = h.iterator();
        while (true) {
            boolean z = true;
            i = 0;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((androidx.compose.foundation.lazy.o) next).getSize() <= 0.2f * a) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            h = arrayList;
        }
        Iterator it4 = h.iterator();
        while (it4.hasNext()) {
            i += ((androidx.compose.foundation.lazy.o) it4.next()).getSize();
        }
        float size = i / h.size();
        if (size <= 0.0f) {
            return null;
        }
        return new q(size, f * size, (u * size) + v, a);
    }

    private static final void l(v1 v1Var, float f) {
        v1Var.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(float f, v1 v1Var) {
        l(v1Var, f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(float f, State state, float f2) {
        if (f2 >= f && f2 <= f + t(state)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(long j, float f, long j2, State state, androidx.compose.ui.graphics.drawscope.f Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float intBitsToFloat = Float.intBitsToFloat((int) (Canvas.e() >> 32));
        long e = a0.f.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L));
        float t = t(state);
        float f2 = 2;
        DrawScope.-CC.r(Canvas, j, e, a0.l.d((Float.floatToRawIntBits(t) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32)), a0.a.b((Float.floatToRawIntBits(r0) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat / f2) << 32)), (androidx.compose.ui.graphics.drawscope.g) null, 0.0f, (m0) null, 0, 240, (Object) null);
        float M0 = Canvas.M0(x0.i.g(4));
        float M02 = Canvas.M0(x0.i.g(1));
        float M03 = (float) ((intBitsToFloat / 2.0d) - (Canvas.M0(x0.i.g(6)) / 2.0d));
        float t2 = f + (t(state) / f2);
        float f3 = M0 / f2;
        float M04 = Canvas.M0(x0.i.g(0.6f));
        float M05 = Canvas.M0(x0.i.g(0.8f));
        float M06 = Canvas.M0(x0.i.g(2.4f));
        float M07 = Canvas.M0(x0.i.g(3.0f));
        float M08 = Canvas.M0(x0.i.g(3.2f));
        float M09 = Canvas.M0(x0.i.g(3.6f));
        float M010 = Canvas.M0(x0.i.g(5.0f));
        float M011 = Canvas.M0(x0.i.g(5.4f));
        Path a = t.a();
        E(a, M05, Canvas, M04, M06, M08, M07, M09, M011, M010, M03, t2 - f3, M02, true);
        DrawScope.-CC.m(Canvas, a, j2, 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (m0) null, 0, 60, (Object) null);
        Path a2 = t.a();
        E(a2, M05, Canvas, M04, M06, M08, M07, M09, M011, M010, M03, t2 + f3, M02, false);
        DrawScope.-CC.m(Canvas, a2, j2, 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (m0) null, 0, 60, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job w(float f, float f2, float f3, float f4, LazyListState lazyListState, CoroutineScope coroutineScope, v1 v1Var, float f5) {
        float coerceIn;
        int coerceIn2;
        Job e;
        float k = k(v1Var) + f5;
        float f6 = 0.0f;
        coerceIn = RangesKt___RangesKt.coerceIn(k, 0.0f, f);
        l(v1Var, coerceIn);
        if (f > 0.0f) {
            f6 = k(v1Var) / f;
        }
        coerceIn2 = RangesKt___RangesKt.coerceIn((int) Math.floor(r8), 0, lazyListState.x().f() - 1);
        e = kotlinx.coroutines.i.e(coroutineScope, null, null, new LazyColumnScrollbarKt$StoryFeedsScrollbar$onDragDelta$2$1$1(lazyListState, coerceIn2, (int) ((((f6 * (f2 - f3)) / f4) - coerceIn2) * f4), null), 3, null);
        return e;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final androidx.compose.foundation.lazy.LazyListState r41, androidx.compose.ui.Modifier r42, float r43, float r44, float r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.widget.LazyColumnScrollbarKt.i(androidx.compose.foundation.lazy.LazyListState, androidx.compose.ui.Modifier, float, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void E(Path path, float f, androidx.compose.ui.graphics.drawscope.f fVar, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z) {
        int i;
        if (z) {
            i = -1;
        } else {
            i = 1;
        }
        float f12 = f9 + f11;
        path.moveTo(f12, f10);
        float f13 = i;
        float f14 = (f13 * f) + f10;
        path.e(f9 + f, (fVar.M0(x0.i.g(0.4f)) * f13) + f10, f9 + f2, f14);
        float f15 = (f13 * f4) + f10;
        path.lineTo(f9 + f3, f15);
        path.e(f9 + f5, (fVar.M0(x0.i.g(3.4f)) * f13) + f10, f9 + f6, f15);
        path.lineTo(f9 + f7, f14);
        path.e(f9 + fVar.M0(x0.i.g(5.2f)), (fVar.M0(x0.i.g(0.4f)) * f13) + f10, f9 + f8, (f13 * 0.0f) + f10);
        path.lineTo(f12, f10);
        path.close();
    }
}
