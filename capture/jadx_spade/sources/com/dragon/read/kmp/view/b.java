package com.dragon.read.kmp.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.e90;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function3<e90, Composer, Integer, Unit> c;
    private static Function2<Composer, Integer, Unit> d;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    public final Function3<e90, Composer, Integer, Unit> b() {
        return c;
    }

    public final Function2<Composer, Integer, Unit> c() {
        return d;
    }

    static {
        Covode.recordClassIndex(609587);
        a = new b();
        b = androidx.compose.runtime.internal.t.c(1277412533, false, a.a);
        c = androidx.compose.runtime.internal.t.c(1409140586, false, C0079b.a);
        d = androidx.compose.runtime.internal.t.c(1595506738, false, c.a);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
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
                    ComposerKt.traceEventStart(1277412533, i, -1, "com.dragon.read.kmp.view.ComposableSingletons$RelationSeriesDialogItemKt.lambda$1277412533.<anonymous> (RelationSeriesDialogItem.kt:207)");
                }
                float f = 3;
                float f2 = 2;
                a3.a(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.s(f2.v(Modifier.Companion, x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null), x0.i.g(f2)), k.g.c(x0.i.g(f2))), og4.a.a.h(composer, og4.a.b).h(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        public static final c a = new c();

        c() {
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
                    ComposerKt.traceEventStart(1595506738, i, -1, "com.dragon.read.kmp.view.ComposableSingletons$RelationSeriesDialogItemKt.lambda$1595506738.<anonymous> (RelationSeriesDialogItem.kt:311)");
                }
                float g = x0.i.g(4);
                composer.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(Modifier.Companion, g), composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* renamed from: com.dragon.read.kmp.view.b$b, reason: collision with other inner class name */
    static final class C0079b implements Function3<e90, Composer, Integer, Unit> {
        public static final C0079b a = new C0079b();

        C0079b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(e90 e90Var, Composer composer, Integer num) {
            a(e90Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(e90 secondaryInfo, Composer composer, int i) {
            long h;
            Intrinsics.checkNotNullParameter(secondaryInfo, "secondaryInfo");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1409140586, i, -1, "com.dragon.read.kmp.view.ComposableSingletons$RelationSeriesDialogItemKt.lambda$1409140586.<anonymous> (RelationSeriesDialogItem.kt:197)");
            }
            String str = secondaryInfo.a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            int b = w0.s.b.b();
            long h2 = x0.x.h(12);
            long h3 = x0.x.h(12);
            if (Intrinsics.areEqual(secondaryInfo.c, Boolean.TRUE)) {
                composer.startReplaceGroup(1269416179);
                h = og4.a.a.h(composer, og4.a.b).p();
            } else {
                composer.startReplaceGroup(1269417328);
                h = og4.a.a.h(composer, og4.a.b).h();
            }
            composer.endReplaceGroup();
            a6.j(str2, (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b, false, 1, 0, (Function1) null, new g3(h, h2, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, h3, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null), composer, 0, 3120, 55294);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
