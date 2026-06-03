package bm4;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.b1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.b2;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.a3;
import androidx.compose.ui.text.b3;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.y2;
import androidx.compose.ui.unit.LayoutDirection;
import bm4.o;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.bookcover.epub.d1;
import com.dragon.read.kmp.reader.bookcover.epub.s0;
import com.dragon.read.kmp.reader.state.BookCoverViewModelKt;
import com.dragon.read.kmp.reader.state.TagStyle;
import com.dragon.read.reader.f1;
import com.dragon.read.reader.m3;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    static {
        Covode.recordClassIndex(608279);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(List list, boolean z, int i, Composer composer, int i2) {
        x(list, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(long j, int i, Composer composer, int i2) {
        B(j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(long j, int i, Composer composer, int i2) {
        D(j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, String str, Function0 function0, boolean z, Integer num, int i, int i2, Composer composer, int i3) {
        n(modifier, str, function0, z, num, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(com.dragon.read.kmp.reader.state.w wVar, boolean z, int i, Composer composer, int i2) {
        q(wVar, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Modifier modifier, List list, boolean z, int i, int i2, Composer composer, int i3) {
        t(modifier, list, z, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(com.dragon.read.kmp.reader.state.w wVar) {
        boolean z;
        String str = wVar.b;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            dm4.r.b.b(str);
        }
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ Integer b;
        final /* synthetic */ long c;
        final /* synthetic */ Function0<Unit> d;
        final /* synthetic */ String e;

        a(boolean z, Integer num, long j, Function0<Unit> function0, String str) {
            this.a = z;
            this.b = num;
            this.c = j;
            this.d = function0;
            this.e = str;
        }

        /* renamed from: bm4.o$a$a, reason: collision with other inner class name */
        static final class C0009a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ androidx.compose.foundation.layout.v a;
            final /* synthetic */ List<com.dragon.read.kmp.reader.state.w> b;
            final /* synthetic */ boolean c;
            final /* synthetic */ Integer d;
            final /* synthetic */ String e;
            final /* synthetic */ long f;
            final /* synthetic */ long g;
            final /* synthetic */ long h;
            final /* synthetic */ Function0<Unit> i;
            final /* synthetic */ com.dragon.read.kmp.reader.state.a j;
            final /* synthetic */ String k;

            C0009a(androidx.compose.foundation.layout.v vVar, List<com.dragon.read.kmp.reader.state.w> list, boolean z, Integer num, String str, long j, long j2, long j3, Function0<Unit> function0, com.dragon.read.kmp.reader.state.a aVar, String str2) {
                this.a = vVar;
                this.b = list;
                this.c = z;
                this.d = num;
                this.e = str;
                this.f = j;
                this.g = j2;
                this.h = j3;
                this.i = function0;
                this.j = aVar;
                this.k = str2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                b(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r17v6, types: [java.lang.Object, java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
            public final void b(Composer composer, int i) {
                boolean z;
                int i2;
                Object obj;
                x0.e eVar;
                boolean z2;
                int coerceAtLeast;
                float coerceAtLeast2;
                String take;
                boolean isWhitespace;
                boolean z3;
                long n;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-998548560, i, -1, "com.dragon.read.kmp.reader.bookcover.view.KmpAbstractSectionView.<anonymous>.<anonymous> (KmpAbstractSectionView.kt:96)");
                    }
                    x0.e eVar2 = (x0.e) composer.consume(CompositionLocalsKt.f());
                    int M0 = (int) eVar2.M0(x0.i.g(this.a.g() - x0.i.g(32)));
                    float f = 16;
                    Modifier v = f2.v(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, x0.i.g(f), 0.0f, 0.0f, 13, (Object) null);
                    List<com.dragon.read.kmp.reader.state.w> list = this.b;
                    boolean z4 = this.c;
                    Integer num = this.d;
                    String str = this.e;
                    long j = this.f;
                    long j2 = this.g;
                    long j3 = this.h;
                    final Function0<Unit> function0 = this.i;
                    final com.dragon.read.kmp.reader.state.a aVar = this.j;
                    final String str2 = this.k;
                    androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, v);
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
                    g5.e(b, a, companion.c());
                    g5.e(b, currentCompositionLocalMap, companion.e());
                    Function2 b2 = companion.b();
                    if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                        b.updateRememberedValue(Integer.valueOf(a2));
                        b.apply(Integer.valueOf(a2), b2);
                    }
                    g5.e(b, e, companion.d());
                    androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                    o.x(list, z4, composer, 0);
                    if (num != null) {
                        i2 = num.intValue();
                    } else {
                        i2 = 2;
                    }
                    Object obj2 = "";
                    if (str == null) {
                        str = "";
                    }
                    a3 a4 = b3.a(0, composer, 0, 1);
                    g3 g3Var = new g3(0L, j, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, j2, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646141, (DefaultConstructorMarker) null);
                    composer.startReplaceGroup(-1633490746);
                    boolean changed = composer.changed(M0) | composer.changed(i2);
                    Object rememberedValue = composer.rememberedValue();
                    if (!changed && rememberedValue != Composer.Companion.getEmpty()) {
                        eVar = eVar2;
                        obj = null;
                    } else {
                        obj = null;
                        eVar = eVar2;
                        rememberedValue = x0.i.d(eVar.v1((int) (a3.d(a4, new androidx.compose.ui.text.e("...更多", (List) null, 2, (DefaultConstructorMarker) null), g3Var, w0.s.b.a(), false, 1, (List) null, x0.c.b(0, 0, 0, 0, 15, (Object) null), (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1952, (Object) null).c >> 32)));
                        composer.updateRememberedValue(rememberedValue);
                    }
                    float m = ((x0.i) rememberedValue).m();
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(5004770);
                    boolean changed2 = composer.changed(m);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = Float.valueOf(eVar.M0(x0.i.g(m + x0.i.g(f))));
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    float floatValue = ((Number) rememberedValue2).floatValue();
                    composer.endReplaceGroup();
                    ?? r17 = obj;
                    long b3 = x0.c.b(0, M0, 0, 0, 13, (Object) null);
                    composer.startReplaceGroup(-1746271574);
                    boolean changed3 = composer.changed(M0) | composer.changed(str) | composer.changed(i2);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = a3.d(a4, new androidx.compose.ui.text.e(str, (List) r17, 2, (DefaultConstructorMarker) r17), g3Var, w0.s.b.a(), true, i2, (List) null, b3, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1952, (Object) null);
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    y2 y2Var = (y2) rememberedValue3;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(-1224400529);
                    boolean changed4 = composer.changed(str) | composer.changed(y2Var) | composer.changed(floatValue) | composer.changed(i2);
                    Object rememberedValue4 = composer.rememberedValue();
                    if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                        if (a3.d(a4, new androidx.compose.ui.text.e(str, (List) r17, 2, (DefaultConstructorMarker) r17), g3Var, w0.s.b.a(), true, i2 + 1, (List) null, b3, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1952, (Object) null).k() > i2) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            rememberedValue4 = new Pair(str, Boolean.FALSE);
                        } else {
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i2 - 1, 0);
                            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(((int) (y2Var.c >> 32)) - floatValue, 0.0f);
                            float s = y2Var.s(coerceAtLeast);
                            float j4 = s + ((y2Var.j(coerceAtLeast) - s) / 2.0f);
                            take = StringsKt___StringsKt.take(str, y2Var.t(a0.f.e((Float.floatToRawIntBits(coerceAtLeast2) << 32) | (Float.floatToRawIntBits(j4) & 4294967295L))));
                            int length = take.length() - 1;
                            if (length >= 0) {
                                while (true) {
                                    int i3 = length - 1;
                                    char charAt = take.charAt(length);
                                    isWhitespace = CharsKt__CharJVMKt.isWhitespace(charAt);
                                    if (!isWhitespace && charAt != '\n' && charAt != '\r') {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        obj2 = take.subSequence(0, length + 1);
                                        break;
                                    } else if (i3 < 0) {
                                        break;
                                    } else {
                                        length = i3;
                                    }
                                }
                            }
                            rememberedValue4 = new Pair(obj2.toString() + "...", Boolean.TRUE);
                        }
                        composer.updateRememberedValue(rememberedValue4);
                    }
                    Pair pair = (Pair) rememberedValue4;
                    composer.endReplaceGroup();
                    String str3 = (String) pair.component1();
                    boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
                    Modifier.a aVar2 = Modifier.Companion;
                    Modifier h = SizeKt.h(aVar2, 0.0f, 1, (Object) r17);
                    e.a aVar3 = androidx.compose.ui.e.a;
                    androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                    int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer, h);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                    Function0 a6 = companion2.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a6);
                    } else {
                        composer.useNode();
                    }
                    Composer b4 = g5.b(composer);
                    g5.e(b4, i4, companion2.c());
                    g5.e(b4, currentCompositionLocalMap2, companion2.e());
                    Function2 b5 = companion2.b();
                    if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                        b4.updateRememberedValue(Integer.valueOf(a5));
                        b4.apply(Integer.valueOf(a5), b5);
                    }
                    g5.e(b4, e2, companion2.d());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                    a6.j(str3, SizeKt.h(f2.v(f2.r(aVar2, x0.i.g(f)), 0.0f, x0.i.g(0), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) r17), j3, j, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, j2, w0.s.b.a(), false, i2, 0, (Function1) null, (g3) null, composer, 48, 48, 119792);
                    composer.startReplaceGroup(1982890418);
                    if (booleanValue) {
                        Modifier v2 = f2.v(boxScopeInstance.b(aVar2, aVar3.c()), 0.0f, 0.0f, x0.i.g(f), x0.i.g(f), 3, (Object) null);
                        composer.startReplaceGroup(-1746271574);
                        boolean changed5 = composer.changed(function0) | composer.changedInstance(aVar) | composer.changed(str2);
                        Object rememberedValue5 = composer.rememberedValue();
                        if (changed5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new Function0() { // from class: bm4.n
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit c;
                                    c = o.a.C0009a.c(Function0.this, aVar, str2);
                                    return c;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue5);
                        }
                        composer.endReplaceGroup();
                        Modifier modifier = ClickableKt.clickable-oSLSa3U$default(v2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue5, 15, (Object) null);
                        androidx.compose.ui.layout.p0 b6 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar3.i(), composer, 48);
                        int a7 = j.a(androidx.compose.runtime.i.b(composer, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                        Modifier e3 = ComposedModifierKt.e(composer, modifier);
                        Function0 a8 = companion2.a();
                        if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                            androidx.compose.runtime.i.d();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(a8);
                        } else {
                            composer.useNode();
                        }
                        Composer b7 = g5.b(composer);
                        g5.e(b7, b6, companion2.c());
                        g5.e(b7, currentCompositionLocalMap3, companion2.e());
                        Function2 b8 = companion2.b();
                        if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a7))) {
                            b7.updateRememberedValue(Integer.valueOf(a7));
                            b7.apply(Integer.valueOf(a7), b8);
                        }
                        g5.e(b7, e3, companion2.d());
                        w2 w2Var = w2.b;
                        if (z4) {
                            n = androidx.compose.ui.graphics.n0.d(2578954167L);
                        } else {
                            n = androidx.compose.ui.graphics.l0.n(j3, 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        }
                        a6.j("更多", (Modifier) null, n, j, (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, j2, 0, false, 0, 0, (Function1) null, (g3) null, composer, 196614, 0, 130002);
                        composer.endNode();
                    }
                    composer.endReplaceGroup();
                    composer.endNode();
                    composer.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c(Function0 function0, com.dragon.read.kmp.reader.state.a aVar, String str) {
                function0.invoke();
                s0.a.c(aVar.a, "abstract_more", str);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            long h;
            int i3;
            int i4;
            Modifier B;
            long n;
            int i5;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i2 = i | i5;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1800949043, i2, -1, "com.dragon.read.kmp.reader.bookcover.view.KmpAbstractSectionView.<anonymous> (KmpAbstractSectionView.kt:71)");
                }
                com.dragon.read.kmp.reader.state.a aVar = (com.dragon.read.kmp.reader.state.a) BookCoverViewModelKt.c(composer, 0).getValue();
                List<com.dragon.read.kmp.reader.state.j> list = aVar.w;
                List<com.dragon.read.kmp.reader.state.g> list2 = aVar.x;
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(list) | composer.changed(list2);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = d1.b(d1.a, aVar.w, aVar.x, null, 4, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                List list3 = (List) rememberedValue;
                composer.endReplaceGroup();
                boolean a = pm4.r.a(zl4.s.a.c(composer, zl4.s.b));
                if (am4.a.g(composer, 0)) {
                    h = x0.x.h(18);
                } else {
                    h = x0.x.h(14);
                }
                if (am4.a.g(composer, 0)) {
                    i3 = 30;
                } else {
                    i3 = 23;
                }
                long h2 = x0.x.h(i3);
                String str = aVar.i;
                Modifier.a aVar2 = Modifier.Companion;
                Modifier h3 = SizeKt.h(aVar2, 0.0f, 1, (Object) null);
                if (this.a) {
                    B = SizeKt.d(aVar2, 0.0f, 1, (Object) null);
                    i4 = 0;
                } else {
                    i4 = 0;
                    B = SizeKt.B(aVar2, (e.c) null, false, 3, (Object) null);
                }
                Modifier then = h3.then(B);
                float g = x0.i.g(i4);
                k.f c = k.g.c(x0.i.g(12));
                composer.startReplaceGroup(-159764432);
                if (a) {
                    n = ((zl4.b) composer.consume(zl4.r.w())).c(composer, 0);
                } else {
                    n = androidx.compose.ui.graphics.l0.n(androidx.compose.ui.graphics.l0.b.i(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
                composer.endReplaceGroup();
                androidx.compose.material.w.a(then, c, n, 0L, (androidx.compose.foundation.w) null, g, androidx.compose.runtime.internal.t.e(-998548560, true, new C0009a(BoxWithConstraints, list3, a, this.b, str, h, h2, this.c, this.d, aVar, this.e), composer, 54), composer, 1769472, 24);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ com.dragon.read.kmp.reader.state.w b;
        final /* synthetic */ long c;

        b(float f, com.dragon.read.kmp.reader.state.w wVar, long j) {
            this.a = f;
            this.b = wVar;
            this.c = j;
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
                    ComposerKt.traceEventStart(877821634, i, -1, "com.dragon.read.kmp.reader.bookcover.view.TagChip.<anonymous> (KmpAbstractSectionView.kt:346)");
                }
                e.c i2 = androidx.compose.ui.e.a.i();
                Modifier.a aVar = Modifier.Companion;
                Modifier s = f2.s(aVar, this.a, x0.i.g(5));
                com.dragon.read.kmp.reader.state.w wVar = this.b;
                long j = this.c;
                androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), i2, composer, 48);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, s);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a2);
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
                composer.startReplaceGroup(-854043722);
                TagStyle tagStyle = wVar.d;
                TagStyle tagStyle2 = TagStyle.WHEAT;
                if (tagStyle == tagStyle2) {
                    o.B(j, composer, 0);
                    androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar, x0.i.g(1)), composer, 6);
                }
                composer.endReplaceGroup();
                a6.j(wVar.a, (Modifier) null, j, x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                composer.startReplaceGroup(-854034185);
                if (wVar.d == tagStyle2) {
                    androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar, x0.i.g(1)), composer, 6);
                    o.D(j, composer, 0);
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

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.state.w a;
        final /* synthetic */ boolean b;

        c(com.dragon.read.kmp.reader.state.w wVar, boolean z) {
            this.a = wVar;
            this.b = z;
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
                    ComposerKt.traceEventStart(-629702151, i, -1, "com.dragon.read.kmp.reader.bookcover.view.TagRowLimited.<anonymous>.<anonymous>.<anonymous>.<anonymous> (KmpAbstractSectionView.kt:283)");
                }
                o.q(this.a, this.b, composer, com.dragon.read.kmp.reader.state.w.e);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class d implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ b2 a;
        final /* synthetic */ int b;
        final /* synthetic */ List<com.dragon.read.kmp.reader.state.w> c;
        final /* synthetic */ boolean d;

        d(b2 b2Var, int i, List<com.dragon.read.kmp.reader.state.w> list, boolean z) {
            this.a = b2Var;
            this.b = i;
            this.c = list;
            this.d = z;
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
                    ComposerKt.traceEventStart(1128720298, i, -1, "com.dragon.read.kmp.reader.bookcover.view.TitleWithTagsRow.<anonymous>.<anonymous>.<anonymous> (KmpAbstractSectionView.kt:251)");
                }
                o.t(SizeKt.x(Modifier.Companion, this.a.v1(this.b)), this.c, this.d, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class e implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ long a;

        e(long j) {
            this.a = j;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            int i2;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(238178664, i, -1, "com.dragon.read.kmp.reader.bookcover.view.TitleWithTagsRow.<anonymous>.<anonymous>.<anonymous> (KmpAbstractSectionView.kt:235)");
                }
                if (am4.a.g(composer, 0)) {
                    i2 = 20;
                } else {
                    i2 = 16;
                }
                a6.j("简介", f2.v(Modifier.Companion, x0.i.g(4), 0.0f, x0.i.g(8), 0.0f, 10, (Object) null), this.a, x0.x.h(i2), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 196662, 0, 131024);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    private static final Modifier K(Modifier modifier, final Function0<Unit> function0) {
        return ClickableKt.clickable-O2vRcR0$default(modifier, androidx.compose.foundation.interaction.h.a(), (b1) null, false, (String) null, (Role) null, new Function0() { // from class: bm4.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit L;
                L = o.L(Function0.this);
                return L;
            }
        }, 28, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(List list, int i, p1.a layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        int i2 = 0;
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            p1 p1Var = (p1) obj;
            p1.a.N(layout, p1Var, i3, 0, 0.0f, 4, (Object) null);
            i3 += p1Var.a;
            if (i2 != CollectionsKt__CollectionsKt.getLastIndex(list)) {
                i3 += i;
            }
            i2 = i4;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(final long j, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-2019191540);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(j)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2019191540, i2, -1, "com.dragon.read.kmp.reader.bookcover.view.WheatIconLeft (KmpAbstractSectionView.kt:368)");
            }
            composer2 = startRestartGroup;
            z0.c(org.jetbrains.compose.resources.c.b(f1.h(m3.a), startRestartGroup, 0), (String) null, SizeKt.u(Modifier.Companion, x0.i.g(8), x0.i.g(14)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, j, 0, 2, (Object) null), composer2, 432, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bm4.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit C;
                    C = o.C(j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return C;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final long j, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1509637635);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(j)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1509637635, i2, -1, "com.dragon.read.kmp.reader.bookcover.view.WheatIconRight (KmpAbstractSectionView.kt:378)");
            }
            composer2 = startRestartGroup;
            z0.c(org.jetbrains.compose.resources.c.b(f1.i(m3.a), startRestartGroup, 0), (String) null, SizeKt.u(Modifier.Companion, x0.i.g(8), x0.i.g(14)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, j, 0, 2, (Object) null), composer2, 432, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bm4.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit E;
                    E = o.E(j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return E;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.layout.r0 u(List list, boolean z, b2 SubcomposeLayout, x0.b bVar) {
        int i;
        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
        final int x0 = SubcomposeLayout.x0(x0.i.g(4));
        final ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (Object obj : list) {
            int i5 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            p1 L = ((androidx.compose.ui.layout.n0) CollectionsKt___CollectionsKt.first(SubcomposeLayout.I1("tag_" + i3, androidx.compose.runtime.internal.t.c(-629702151, true, new c((com.dragon.read.kmp.reader.state.w) obj, z))))).L(x0.b.d(bVar.r(), 0, 0, 0, 0, 10, (Object) null));
            if (arrayList.isEmpty()) {
                i = L.a;
            } else {
                i = i4 + x0 + L.a;
            }
            if (i <= x0.b.l(bVar.r())) {
                if (!arrayList.isEmpty()) {
                    i4 += x0;
                }
                arrayList.add(L);
                i4 += L.a;
                int i6 = L.b;
                if (i6 > i2) {
                    i2 = i6;
                }
            }
            i3 = i5;
        }
        return androidx.compose.ui.layout.s0.b(SubcomposeLayout, x0.b.l(bVar.r()), i2, (Map) null, new Function1() { // from class: bm4.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit v;
                v = o.v(arrayList, x0, (p1.a) obj2);
                return v;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final List<com.dragon.read.kmp.reader.state.w> list, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-879100279);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z3 = true;
        if ((i2 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-879100279, i2, -1, "com.dragon.read.kmp.reader.bookcover.view.TitleWithTagsRow (KmpAbstractSectionView.kt:221)");
            }
            final long x = ((androidx.compose.ui.graphics.l0) BookCoverViewModelKt.b(startRestartGroup, 0).d.getValue()).x();
            Modifier h = SizeKt.h(f2.t(Modifier.Companion, x0.i.g(16), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed = startRestartGroup.changed(x) | startRestartGroup.changedInstance(list);
            if ((i2 & 112) != 32) {
                z3 = false;
            }
            boolean z4 = changed | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function2() { // from class: bm4.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        androidx.compose.ui.layout.r0 y;
                        y = o.y(x, list, z, (b2) obj, (x0.b) obj2);
                        return y;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            SubcomposeLayoutKt.a(h, (Function2) rememberedValue, startRestartGroup, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bm4.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit A;
                    A = o.A(list, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return A;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final com.dragon.read.kmp.reader.state.w wVar, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        boolean z3;
        long n;
        int i3;
        boolean changedInstance;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(173303173);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(wVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(wVar);
            }
            if (changedInstance) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(173303173, i2, -1, "com.dragon.read.kmp.reader.bookcover.view.TagChip (KmpAbstractSectionView.kt:317)");
            }
            long x = ((androidx.compose.ui.graphics.l0) BookCoverViewModelKt.b(startRestartGroup, 0).d.getValue()).x();
            if (wVar.d == TagStyle.HIGHLIGHT) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                n = androidx.compose.ui.graphics.n0.b(867730955);
            } else if (z) {
                n = androidx.compose.ui.graphics.n0.b(263698359);
            } else {
                n = androidx.compose.ui.graphics.l0.n(androidx.compose.ui.graphics.l0.b.a(), 0.03f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            if (z3) {
                x = androidx.compose.ui.graphics.n0.d(4290283019L);
            } else if (z) {
                x = androidx.compose.ui.graphics.n0.d(4290493371L);
            }
            float g = x0.i.g(8);
            k.f c2 = k.g.c(x0.i.g(4));
            float g2 = x0.i.g(0);
            boolean z4 = false;
            Modifier F = SizeKt.F(SizeKt.b(Modifier.Companion, 0.0f, x0.i.g(24), 1, (Object) null), (e.b) null, false, 3, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i2 & 14) == 4 || ((8 & i2) != 0 && startRestartGroup.changedInstance(wVar))) {
                z4 = true;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: bm4.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit r;
                        r = o.r(com.dragon.read.kmp.reader.state.w.this);
                        return r;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            androidx.compose.material.w.a(K(F, (Function0) rememberedValue), c2, n, 0L, (androidx.compose.foundation.w) null, g2, androidx.compose.runtime.internal.t.e(877821634, true, new b(g, wVar, x), startRestartGroup, 54), startRestartGroup, 1769472, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bm4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit s;
                    s = o.s(com.dragon.read.kmp.reader.state.w.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return s;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.layout.r0 y(long j, List list, boolean z, b2 SubcomposeLayout, x0.b bVar) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
        float f = 4;
        final int x0 = SubcomposeLayout.x0(x0.i.g(f));
        final int x02 = SubcomposeLayout.x0(x0.i.g(f));
        final p1 L = ((androidx.compose.ui.layout.n0) CollectionsKt___CollectionsKt.first(SubcomposeLayout.I1("title", androidx.compose.runtime.internal.t.c(238178664, true, new e(j))))).L(x0.b.d(bVar.r(), 0, 0, 0, 0, 10, (Object) null));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((x0.b.l(bVar.r()) - (L.a - x02)) - x0, 0);
        final p1 L2 = ((androidx.compose.ui.layout.n0) CollectionsKt___CollectionsKt.first(SubcomposeLayout.I1("tags", androidx.compose.runtime.internal.t.c(1128720298, true, new d(SubcomposeLayout, coerceAtLeast, list, z))))).L(x0.b.d(bVar.r(), 0, coerceAtLeast, 0, 0, 8, (Object) null));
        final int max = Math.max(L.b, L2.b);
        return androidx.compose.ui.layout.s0.b(SubcomposeLayout, x0.b.l(bVar.r()), max, (Map) null, new Function1() { // from class: bm4.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z2;
                z2 = o.z(x02, L, max, x0, L2, (p1.a) obj);
                return z2;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(int i, p1 p1Var, int i2, int i3, p1 p1Var2, p1.a layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        int i4 = -i;
        p1.a.N(layout, p1Var, i4, (i2 - p1Var.b) / 2, 0.0f, 4, (Object) null);
        p1.a.N(layout, p1Var2, i4 + (p1Var.a - i) + i3, (i2 - p1Var2.b) / 2, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Modifier modifier, final List<com.dragon.read.kmp.reader.state.w> list, final boolean z, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(208659691);
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        boolean z3 = true;
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (i7 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(208659691, i3, -1, "com.dragon.read.kmp.reader.bookcover.view.TagRowLimited (KmpAbstractSectionView.kt:273)");
            }
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance = startRestartGroup.changedInstance(list);
            if ((i3 & 896) != 256) {
                z3 = false;
            }
            boolean z4 = changedInstance | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function2() { // from class: bm4.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        androidx.compose.ui.layout.r0 u;
                        u = o.u(list, z, (b2) obj, (x0.b) obj2);
                        return u;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            SubcomposeLayoutKt.a(modifier, (Function2) rememberedValue, startRestartGroup, i3 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bm4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w;
                    w = o.w(modifier2, list, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return w;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n(androidx.compose.ui.Modifier r19, final java.lang.String r20, kotlin.jvm.functions.Function0<kotlin.Unit> r21, boolean r22, java.lang.Integer r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bm4.o.n(androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function0, boolean, java.lang.Integer, androidx.compose.runtime.Composer, int, int):void");
    }
}
