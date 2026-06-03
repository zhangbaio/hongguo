package com.dragon.read.kmp.widget.slidetab;

import androidx.compose.animation.core.i;
import androidx.compose.animation.core.j;
import androidx.compose.animation.core.m0;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.k2;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.v2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.b2;
import androidx.compose.ui.layout.n0;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.layout.r0;
import androidx.compose.ui.layout.s0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.widget.slidetab.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    private static final float a;
    private static final i<Float> b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(int i, Modifier modifier, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        b(i, modifier, j, j2, f, function3, function2, function22, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(609691);
        a = x0.i.g(30);
        b = j.n(250, 0, m0.c(), 2, (Object) null);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ Function2<Composer, Integer, Unit> b;
        final /* synthetic */ Function2<Composer, Integer, Unit> c;
        final /* synthetic */ Function3<List<f>, Composer, Integer, Unit> d;
        final /* synthetic */ int e;

        /* JADX WARN: Multi-variable type inference failed */
        a(float f, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<f>, ? super Composer, ? super Integer, Unit> function3, int i) {
            this.a = f;
            this.b = function2;
            this.c = function22;
            this.d = function3;
            this.e = i;
        }

        /* renamed from: com.dragon.read.kmp.widget.slidetab.e$a$a, reason: collision with other inner class name */
        static final class C0084a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ Function3<List<f>, Composer, Integer, Unit> a;
            final /* synthetic */ List<f> b;

            /* JADX WARN: Multi-variable type inference failed */
            C0084a(Function3<? super List<f>, ? super Composer, ? super Integer, Unit> function3, List<f> list) {
                this.a = function3;
                this.b = list;
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
                        ComposerKt.traceEventStart(-1672292625, i, -1, "com.dragon.read.kmp.widget.slidetab.SlideTabLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SlideTabLayout.kt:121)");
                    }
                    this.a.invoke(this.b, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
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
                    ComposerKt.traceEventStart(-505211982, i, -1, "com.dragon.read.kmp.widget.slidetab.SlideTabLayout.<anonymous> (SlideTabLayout.kt:65)");
                }
                v2 d = k2.d(0, composer, 0, 1);
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                    composer.updateRememberedValue(rememberedValue);
                }
                CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(d) | composer.changed(coroutineScope);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new ScrollableTabData(d, coroutineScope);
                    composer.updateRememberedValue(rememberedValue2);
                }
                final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                composer.endReplaceGroup();
                Modifier b = androidx.compose.ui.draw.e.b(androidx.compose.foundation.selection.b.b(k2.c(SizeKt.D(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), androidx.compose.ui.e.a.h(), false, 2, (Object) null), d, false, (l1) null, false, 14, (Object) null)));
                composer.startReplaceGroup(-1224400529);
                boolean changed2 = composer.changed(this.a) | composer.changed(this.b) | composer.changed(this.c) | composer.changed(this.d) | composer.changedInstance(scrollableTabData) | composer.changed(this.e);
                final float f = this.a;
                final Function2<Composer, Integer, Unit> function2 = this.b;
                final Function2<Composer, Integer, Unit> function22 = this.c;
                final int i2 = this.e;
                final Function3<List<f>, Composer, Integer, Unit> function3 = this.d;
                Object rememberedValue3 = composer.rememberedValue();
                if (changed2 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function2() { // from class: com.dragon.read.kmp.widget.slidetab.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            r0 d2;
                            d2 = e.a.d(f, function2, function22, scrollableTabData, i2, function3, (b2) obj, (x0.b) obj2);
                            return d2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                SubcomposeLayoutKt.a(b, (Function2) rememberedValue3, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r0 d(float f, Function2 function2, final Function2 function22, final ScrollableTabData scrollableTabData, final int i, final Function3 function3, final b2 SubcomposeLayout, final x0.b bVar) {
            Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
            int x0 = SubcomposeLayout.x0(e.a);
            final int x02 = SubcomposeLayout.x0(f);
            long d = x0.b.d(bVar.r(), x0, 0, 0, 0, 14, (Object) null);
            List I1 = SubcomposeLayout.I1(TabSlots.Tabs, function2);
            final ArrayList arrayList = new ArrayList(I1.size());
            int size = I1.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(((n0) I1.get(i2)).L(d));
            }
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = x02 * 2;
            final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                p1 p1Var = (p1) arrayList.get(i3);
                ref$IntRef.element += p1Var.a;
                ref$IntRef2.element = Math.max(ref$IntRef2.element, p1Var.b);
            }
            return s0.b(SubcomposeLayout, ref$IntRef.element, ref$IntRef2.element, (Map) null, new Function1() { // from class: com.dragon.read.kmp.widget.slidetab.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit e;
                    e = e.a.e(x02, arrayList, SubcomposeLayout, function22, scrollableTabData, i, bVar, ref$IntRef, ref$IntRef2, function3, (p1.a) obj);
                    return e;
                }
            }, 4, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(int i, List list, b2 b2Var, Function2 function2, ScrollableTabData scrollableTabData, int i2, x0.b bVar, Ref$IntRef ref$IntRef, Ref$IntRef ref$IntRef2, Function3 function3, p1.a layout) {
            Intrinsics.checkNotNullParameter(layout, "$this$layout");
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i3 = i;
            for (int i4 = 0; i4 < size; i4++) {
                p1 p1Var = (p1) list.get(i4);
                p1.a.N(layout, p1Var, i3, 0, 0.0f, 4, (Object) null);
                arrayList.add(new f(layout.v1(i3), layout.v1(p1Var.a), null));
                i3 += p1Var.a;
            }
            List I1 = b2Var.I1(TabSlots.Divider, function2);
            int size2 = I1.size();
            for (int i5 = 0; i5 < size2; i5++) {
                n0 n0Var = (n0) I1.get(i5);
                long r = bVar.r();
                int i6 = ref$IntRef.element;
                p1 L = n0Var.L(x0.b.d(r, i6, i6, 0, 0, 8, (Object) null));
                p1.a.N(layout, L, 0, ref$IntRef2.element - L.b, 0.0f, 4, (Object) null);
            }
            List I12 = b2Var.I1(TabSlots.Indicator, t.c(-1672292625, true, new C0084a(function3, arrayList)));
            int size3 = I12.size();
            for (int i7 = 0; i7 < size3; i7++) {
                p1.a.N(layout, ((n0) I12.get(i7)).L(x0.b.b.c(ref$IntRef.element, ref$IntRef2.element)), 0, 0, 0.0f, 4, (Object) null);
            }
            scrollableTabData.c(b2Var, i, arrayList, i2);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final int r27, androidx.compose.ui.Modifier r28, long r29, long r31, float r33, kotlin.jvm.functions.Function3<? super java.util.List<com.dragon.read.kmp.widget.slidetab.f>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.slidetab.e.b(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
