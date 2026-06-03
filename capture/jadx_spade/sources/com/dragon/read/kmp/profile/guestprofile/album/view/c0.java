package com.dragon.read.kmp.profile.guestprofile.album.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.e90;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {
    public static final c0 a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function3<e90, Composer, Integer, Unit> c;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    public final Function3<e90, Composer, Integer, Unit> b() {
        return c;
    }

    static {
        Covode.recordClassIndex(608132);
        a = new c0();
        b = androidx.compose.runtime.internal.t.c(-387908285, false, a.a);
        c = androidx.compose.runtime.internal.t.c(1785100270, false, b.a);
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
                    ComposerKt.traceEventStart(-387908285, i, -1, "com.dragon.read.kmp.profile.guestprofile.album.view.ComposableSingletons$AlbumSingleItemKt.lambda$-387908285.<anonymous> (AlbumSingleItem.kt:202)");
                }
                float f = 4;
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

    static final class b implements Function3<e90, Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(e90 e90Var, Composer composer, Integer num) {
            a(e90Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(e90 secondaryInfo, Composer composer, int i) {
            String str;
            l0 j;
            long x;
            String str2;
            long x2;
            long j2;
            Intrinsics.checkNotNullParameter(secondaryInfo, "secondaryInfo");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1785100270, i, -1, "com.dragon.read.kmp.profile.guestprofile.album.view.ComposableSingletons$AlbumSingleItemKt.lambda$1785100270.<anonymous> (AlbumSingleItem.kt:190)");
            }
            Map map = secondaryInfo.v;
            l0 l0Var = null;
            if (map != null) {
                str = (String) map.get("text_color");
            } else {
                str = null;
            }
            composer.startReplaceGroup(1789411563);
            if (str == null) {
                j = null;
            } else {
                j = l0.j(com.dragon.read.kmp.utils.k.a.h(str, og4.a.a.h(composer, og4.a.b).h()));
            }
            composer.endReplaceGroup();
            composer.startReplaceGroup(1789410292);
            if (j == null) {
                x = og4.a.a.h(composer, og4.a.b).h();
            } else {
                x = j.x();
            }
            composer.endReplaceGroup();
            Map map2 = secondaryInfo.v;
            if (map2 != null) {
                str2 = (String) map2.get("dark_text_color");
            } else {
                str2 = null;
            }
            composer.startReplaceGroup(1789417195);
            if (str2 != null) {
                l0Var = l0.j(com.dragon.read.kmp.utils.k.a.h(str2, og4.a.a.h(composer, og4.a.b).h()));
            }
            composer.endReplaceGroup();
            composer.startReplaceGroup(1789415769);
            if (l0Var == null) {
                x2 = og4.a.a.h(composer, og4.a.b).h();
            } else {
                x2 = l0Var.x();
            }
            composer.endReplaceGroup();
            String str3 = secondaryInfo.a;
            if (str3 == null) {
                str3 = "";
            }
            int b = w0.s.b.b();
            long h = x0.x.h(12);
            long h2 = x0.x.h(12);
            if (pm4.r.a(((Number) composer.consume(zl4.r.A())).intValue())) {
                j2 = x2;
            } else {
                j2 = x;
            }
            a6.j(str3, (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b, false, 1, 0, (Function1) null, new g3(j2, h, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, h2, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null), composer, 0, 3120, 55294);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
