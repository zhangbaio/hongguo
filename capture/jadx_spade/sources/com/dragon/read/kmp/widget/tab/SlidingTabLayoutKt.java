package com.dragon.read.kmp.widget.tab;

import a0.f;
import a0.l;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.e0;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.g;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.x;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import x0.j;
import x0.w;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SlidingTabLayoutKt {
    static {
        Covode.recordClassIndex(609694);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PagerState pagerState, List list, Modifier modifier, long j, float f, float f2, TabAlignment tabAlignment, float f3, float f4, float f5, float f6, long j2, long j3, long j4, long j5, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        e(pagerState, list, modifier, j, f, f2, tabAlignment, f3, f4, f5, f6, j2, j3, j4, j5, function1, composer, x2.a(i | 1), x2.a(i2), i3);
        return Unit.INSTANCE;
    }

    private static final long f(MutableState<w> mutableState) {
        return ((w) mutableState.getValue()).l();
    }

    private static final long i(MutableState<l0> mutableState) {
        return ((l0) mutableState.getValue()).x();
    }

    private static final float l(PagerState pagerState, int i) {
        float v = pagerState.v();
        if (i == pagerState.u()) {
            return 1.0f - Math.abs(v);
        }
        if (i == pagerState.u() + 1) {
            if (v > 0.0f) {
                return v;
            }
        } else if (i == pagerState.u() - 1 && v < 0.0f) {
            return -v;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function1 function1, int i, CoroutineScope coroutineScope, PagerState pagerState) {
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
        i.e(coroutineScope, null, null, new SlidingTabLayoutKt$SlidingTabLayout$3$1$3$1$1(pagerState, i, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(e0 e0Var, int i, x0.e eVar, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        e0Var.put(Integer.valueOf(i), new e(eVar.w1(Float.intBitsToFloat((int) (x.e(it2) >> 32))), eVar.v1((int) (it2.a() >> 32)), null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(e0 e0Var, List list, PagerState pagerState, x0.e eVar, long j, float f, float f2, androidx.compose.ui.graphics.drawscope.c drawWithContent) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.E1();
        if (e0Var.size() == list.size()) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                e eVar2 = (e) e0Var.get(Integer.valueOf(i));
                if (eVar2 == null) {
                    float f3 = 0;
                    eVar2 = new e(x0.i.g(f3), x0.i.g(f3), null);
                }
                arrayList.add(eVar2);
            }
            float v = pagerState.v();
            int u = pagerState.u();
            e eVar3 = (e) arrayList.get(u);
            if (v > 0.0f) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtMost(u + 1, CollectionsKt__CollectionsKt.getLastIndex(list));
            } else {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(u - 1, 0);
            }
            e eVar4 = (e) arrayList.get(coerceAtLeast);
            float f4 = eVar3.a;
            float f5 = eVar3.b;
            float f6 = 2;
            float M0 = eVar.M0(x0.i.g(j.b(x0.i.g(f4 + x0.i.g(f5 / f6)), x0.i.g(eVar4.a + x0.i.g(eVar4.b / f6)), Math.abs(v)) - x0.i.g(f / f6)));
            float M02 = eVar.M0(f);
            float intBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.e() & 4294967295L)) - eVar.M0(f2);
            DrawScope.-CC.p(drawWithContent, j, f.e((Float.floatToRawIntBits(intBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(M0) << 32)), l.d((Float.floatToRawIntBits(r0) & 4294967295L) | (Float.floatToRawIntBits(M02) << 32)), 0.0f, (g) null, (m0) null, 0, 120, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final androidx.compose.foundation.pager.PagerState r82, final java.util.List<java.lang.String> r83, androidx.compose.ui.Modifier r84, final long r85, float r87, float r88, com.dragon.read.kmp.widget.tab.TabAlignment r89, float r90, float r91, float r92, float r93, final long r94, final long r96, final long r98, long r100, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r102, androidx.compose.runtime.Composer r103, final int r104, final int r105, final int r106) {
        /*
            Method dump skipped, instructions count: 2030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.tab.SlidingTabLayoutKt.e(androidx.compose.foundation.pager.PagerState, java.util.List, androidx.compose.ui.Modifier, long, float, float, com.dragon.read.kmp.widget.tab.TabAlignment, float, float, float, float, long, long, long, long, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
