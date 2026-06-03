package com.dragon.read.kmp.reader.detail;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.x2;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import com.dragon.read.kmp.reader.detail.a;
import com.dragon.read.kmp.reader.detail.b;
import com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookDetailPageKt {
    private static final ProvidableCompositionLocal<com.dragon.read.kmp.community.bookcomment.z> a;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Covode.recordClassIndex(608366);
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[BookType.values().length];
            try {
                iArr2[BookType.LISTEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[BookType.SHORT_SERIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BookType.READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(d dVar, int i, Composer composer, int i2) {
        k(dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.community.bookcomment.z z() {
        return null;
    }

    public static final ProvidableCompositionLocal<com.dragon.read.kmp.community.bookcomment.z> E() {
        return a;
    }

    public static final class a implements DisposableEffectResult {
        final /* synthetic */ LifecycleOwner a;
        final /* synthetic */ LifecycleEventObserver b;

        public void dispose() {
            this.a.getLifecycle().removeObserver(this.b);
        }

        public a(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver) {
            this.a = lifecycleOwner;
            this.b = lifecycleEventObserver;
        }
    }

    static {
        Covode.recordClassIndex(608365);
        a = androidx.compose.runtime.d0.h((SnapshotMutationPolicy) null, new Function0() { // from class: com.dragon.read.kmp.reader.detail.a1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.dragon.read.kmp.community.bookcomment.z z;
                z = BookDetailPageKt.z();
                return z;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n2 l(State<n2> state) {
        return (n2) state.getValue();
    }

    private static final float p(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float r(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int v(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    private static final int G(String str) {
        float[] fArr = new float[3];
        try {
            com.dragon.read.kmp.util.kotlin.e.j(str, fArr);
        } catch (Throwable unused) {
            fArr = new float[]{0.0f, 0.0f, 0.25f};
        }
        return com.dragon.read.kmp.util.kotlin.e.a(fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float q(State state) {
        float coerceAtLeast;
        float coerceIn;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(com.dragon.read.kmp.service.d1.b(80), 1.0f);
        coerceIn = RangesKt___RangesKt.coerceIn(p(state) / coerceAtLeast, 0.0f, 1.0f);
        return coerceIn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(State state) {
        float coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(com.dragon.read.kmp.service.d1.b(80), 1.0f);
        if (p(state) > coerceAtLeast) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u(State state) {
        float coerceAtLeast;
        float coerceIn;
        int roundToInt;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(com.dragon.read.kmp.service.d1.b(220), 1.0f);
        coerceIn = RangesKt___RangesKt.coerceIn(p(state), 0.0f, coerceAtLeast);
        roundToInt = MathKt__MathJVMKt.roundToInt(-coerceIn);
        return roundToInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(a.b bVar) {
        String str;
        String str2;
        String str3;
        Context context = bVar.getContext();
        int i = b.b[bVar.c.ordinal()];
        String str4 = "";
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    com.bytedance.kmp.reading.model.d1 d1Var = bVar.d.b;
                    if (d1Var == null || (str = d1Var.d) == null) {
                        str = "";
                    }
                    if (d1Var != null && (str3 = d1Var.C) != null) {
                        str4 = str3;
                    }
                    if (d1Var != null) {
                        str2 = d1Var.J;
                    } else {
                        str2 = null;
                    }
                    new com.dragon.read.kmp.reader.utils.o(context, bVar.b, str, str4).i(bVar.e).f(str2).a();
                    return;
                }
                return;
            }
            tb4.h.a.c(new tb4.p((String) null, (String) null, bVar.b, bVar.e, (Integer) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Long) null, (String) null, (Boolean) null, (Integer) null, (Boolean) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Long) null, (Float) null, (Boolean) null, (Integer) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Long) null, (Integer) null, (Boolean) null, (Boolean) null, (Integer) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (Integer) null, (String) null, (Integer) null, (Boolean) null, (Boolean) null, -13, Integer.MAX_VALUE, (DefaultConstructorMarker) null));
            return;
        }
        b55.a aVar = new b55.a(bVar.b);
        aVar.c = bVar.e;
        aVar.b = "";
        aVar.d = "cover";
        aVar.e = true;
        aVar.i = true;
        aVar.h = true;
        ct2.n.Z0.P2().E(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float o(LazyListState lazyListState, androidx.compose.runtime.snapshots.e0 e0Var) {
        float coerceAtLeast;
        float coerceAtLeast2;
        int i;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(com.dragon.read.kmp.service.d1.b(220), 1.0f);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(com.dragon.read.kmp.service.d1.b(80), 1.0f);
        float max = Math.max(coerceAtLeast, coerceAtLeast2);
        int u = lazyListState.u();
        float v = lazyListState.v();
        for (int i2 = 0; i2 < u; i2++) {
            Integer num = (Integer) e0Var.get(Integer.valueOf(i2));
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            v += i;
            if (v >= max) {
                break;
            }
        }
        return v;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0382, code lost:
    
        if (r15 == r16.getEmpty()) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x03a8, code lost:
    
        if (r15 == r16.getEmpty()) goto L130;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k(final com.dragon.read.kmp.reader.detail.d r35, androidx.compose.runtime.Composer r36, final int r37) {
        /*
            Method dump skipped, instructions count: 1315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.BookDetailPageKt.k(com.dragon.read.kmp.reader.detail.d, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(boolean z, CoroutineScope coroutineScope, BookDetailViewModel bookDetailViewModel, androidx.compose.material.n2 n2Var) {
        if (!z) {
            bookDetailViewModel.K0(b.d.a);
        } else {
            kotlinx.coroutines.i.e(coroutineScope, null, null, new BookDetailPageKt$BookDetailPage$5$1$1(n2Var, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult m(LifecycleOwner lifecycleOwner, final p2 p2Var, final d dVar, final State state, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.dragon.read.kmp.reader.detail.j1
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                BookDetailPageKt.n(p2.this, dVar, state, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new a(lifecycleOwner, lifecycleEventObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(p2 p2Var, d dVar, State state, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = b.a[event.ordinal()];
        if (i != 1) {
            if (i == 2) {
                p2Var.m(dVar.a, (ym4.k) state.getValue());
                return;
            }
            return;
        }
        p2Var.k(dVar.a, (ym4.k) state.getValue());
    }
}
