package com.dragon.read.kmp.vip.impl.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.v;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.f4;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.runtime.z1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.e;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.k0;
import androidx.compose.ui.text.m2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCouponKt;
import java.util.Map;
import k.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.Clock;
import nl3.b0;
import nl3.d0;
import nl3.z;
import s0.f;
import w0.h;
import w0.p;
import x0.i;
import zl4.r;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ChapterEndVipCouponKt {
    static {
        Covode.recordClassIndex(609610);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, String str2, long j, long j2, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        b(str, str2, j, j2, function0, function02, function03, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function0<Unit> a;
        final /* synthetic */ String b;
        final /* synthetic */ z1 c;
        final /* synthetic */ Function0<Unit> d;
        final /* synthetic */ long e;
        final /* synthetic */ String f;

        a(Function0<Unit> function0, String str, z1 z1Var, Function0<Unit> function02, long j, String str2) {
            this.a = function0;
            this.b = str;
            this.c = z1Var;
            this.d = function02;
            this.e = j;
            this.f = str2;
        }

        /* renamed from: com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCouponKt$a$a, reason: collision with other inner class name */
        static final class C0081a implements Function3<v, Composer, Integer, Unit> {
            final /* synthetic */ Function0<Unit> a;
            final /* synthetic */ String b;
            final /* synthetic */ z1 c;
            final /* synthetic */ Function0<Unit> d;
            final /* synthetic */ long e;
            final /* synthetic */ String f;

            C0081a(Function0<Unit> function0, String str, z1 z1Var, Function0<Unit> function02, long j, String str2) {
                this.a = function0;
                this.b = str;
                this.c = z1Var;
                this.d = function02;
                this.e = j;
                this.f = str2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit d(Function0 function0) {
                function0.invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit e(Function0 function0) {
                function0.invoke();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(v vVar, Composer composer, Integer num) {
                c(vVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void c(v BoxWithConstraints, Composer composer, int i) {
                int i2;
                boolean z;
                int i3;
                Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                if ((i & 6) == 0) {
                    if (composer.changed(BoxWithConstraints)) {
                        i3 = 4;
                    } else {
                        i3 = 2;
                    }
                    i2 = i | i3;
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
                        ComposerKt.traceEventStart(1285781502, i2, -1, "com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCoupon.<anonymous>.<anonymous> (ChapterEndVipCoupon.kt:79)");
                    }
                    float f = 100;
                    float f2 = 20;
                    float g = i.g(i.g(i.g(BoxWithConstraints.g() - i.g(f)) - i.g(f2)) - i.g((float) 0.5d));
                    Modifier.a aVar = Modifier.Companion;
                    Modifier i4 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), i.g(72));
                    composer.startReplaceGroup(5004770);
                    boolean changed = composer.changed(this.a);
                    final Function0<Unit> function0 = this.a;
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.vip.impl.ui.b
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit d;
                                d = ChapterEndVipCouponKt.a.C0081a.d(Function0.this);
                                return d;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    Modifier modifier = ClickableKt.clickable-oSLSa3U$default(i4, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                    String str = this.b;
                    z1 z1Var = this.c;
                    final Function0<Unit> function02 = this.d;
                    long j = this.e;
                    String str2 = this.f;
                    e.a aVar2 = e.a;
                    p0 i5 = m.i(aVar2.o(), false);
                    int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, modifier);
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
                    Composer b = g5.b(composer);
                    g5.e(b, i5, companion.c());
                    g5.e(b, currentCompositionLocalMap, companion.e());
                    Function2 b2 = companion.b();
                    if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                        b.updateRememberedValue(Integer.valueOf(a));
                        b.apply(Integer.valueOf(a), b2);
                    }
                    g5.e(b, e, companion.d());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                    Modifier f3 = SizeKt.f(f2.t(aVar, i.g(f2), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
                    e.c i6 = aVar2.i();
                    androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                    p0 b3 = r2.b(eVar.h(), i6, composer, 48);
                    int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer, f3);
                    Function0 a4 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a4);
                    } else {
                        composer.useNode();
                    }
                    Composer b4 = g5.b(composer);
                    g5.e(b4, b3, companion.c());
                    g5.e(b4, currentCompositionLocalMap2, companion.e());
                    Function2 b5 = companion.b();
                    if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a3))) {
                        b4.updateRememberedValue(Integer.valueOf(a3));
                        b4.apply(Integer.valueOf(a3), b5);
                    }
                    g5.e(b4, e2, companion.d());
                    float f4 = 8;
                    Modifier v = f2.v(BackgroundKt.c(SizeKt.d(u2.a(w2.b, aVar, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), ((zl4.b) composer.consume(r.w())).v((ReaderBgColorType) composer.consume(r.u())), g.c(i.g(f4))), i.g(16), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    p0 b6 = r2.b(eVar.h(), aVar2.i(), composer, 48);
                    int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(composer, v);
                    Function0 a6 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a6);
                    } else {
                        composer.useNode();
                    }
                    Composer b7 = g5.b(composer);
                    g5.e(b7, b6, companion.c());
                    g5.e(b7, currentCompositionLocalMap3, companion.e());
                    Function2 b8 = companion.b();
                    if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a5))) {
                        b7.updateRememberedValue(Integer.valueOf(a5));
                        b7.apply(Integer.valueOf(a5), b8);
                    }
                    g5.e(b7, e3, companion.d());
                    Modifier i7 = SizeKt.i(SizeKt.x(aVar, i.g(46)), i.g(30));
                    b0 b0Var = b0.a;
                    z0.g(org.jetbrains.compose.resources.c.a(z.a(b0Var), composer, 0), (String) null, i7, (e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 432, 248);
                    float f5 = 12;
                    Modifier v2 = f2.v(aVar, i.g(f5), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    p0 a7 = x.a(eVar.i(), aVar2.k(), composer, 0);
                    int a8 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                    Modifier e4 = ComposedModifierKt.e(composer, v2);
                    Function0 a9 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a9);
                    } else {
                        composer.useNode();
                    }
                    Composer b9 = g5.b(composer);
                    g5.e(b9, a7, companion.c());
                    g5.e(b9, currentCompositionLocalMap4, companion.e());
                    Function2 b10 = companion.b();
                    if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a8))) {
                        b9.updateRememberedValue(Integer.valueOf(a8));
                        b9.apply(Integer.valueOf(a8), b10);
                    }
                    g5.e(b9, e4, companion.d());
                    c0 c0Var = c0.b;
                    a6.j(str, (Modifier) null, ((zl4.b) composer.consume(r.w())).o(), x0.x.h(14), (y) null, (androidx.compose.ui.text.font.c0) null, (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                    StringBuilder sb = new StringBuilder();
                    sb.append(ChapterEndVipCouponKt.i(ChapterEndVipCouponKt.c(z1Var)));
                    nl3.c0 c0Var2 = nl3.c0.a;
                    sb.append(org.jetbrains.compose.resources.j.c(d0.a(c0Var2), composer, 0));
                    a6.j(sb.toString(), (Modifier) null, ((zl4.b) composer.consume(r.w())).q(), x0.x.h(12), (y) null, (androidx.compose.ui.text.font.c0) null, (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                    composer.endNode();
                    composer.endNode();
                    Modifier c = BackgroundKt.c(SizeKt.d(SizeKt.x(aVar, i.g(f)), 0.0f, 1, (Object) null), ((zl4.b) composer.consume(r.w())).v((ReaderBgColorType) composer.consume(r.u())), g.c(i.g(f4)));
                    p0 i8 = m.i(aVar2.o(), false);
                    int a10 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                    Modifier e5 = ComposedModifierKt.e(composer, c);
                    Function0 a11 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a11);
                    } else {
                        composer.useNode();
                    }
                    Composer b11 = g5.b(composer);
                    g5.e(b11, i8, companion.c());
                    g5.e(b11, currentCompositionLocalMap5, companion.e());
                    Function2 b12 = companion.b();
                    if (b11.getInserting() || !Intrinsics.areEqual(b11.rememberedValue(), Integer.valueOf(a10))) {
                        b11.updateRememberedValue(Integer.valueOf(a10));
                        b11.apply(Integer.valueOf(a10), b12);
                    }
                    g5.e(b11, e5, companion.d());
                    Modifier b13 = boxScopeInstance.b(aVar, aVar2.e());
                    p0 a12 = x.a(eVar.i(), aVar2.g(), composer, 48);
                    int a13 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
                    Modifier e6 = ComposedModifierKt.e(composer, b13);
                    Function0 a14 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a14);
                    } else {
                        composer.useNode();
                    }
                    Composer b14 = g5.b(composer);
                    g5.e(b14, a12, companion.c());
                    g5.e(b14, currentCompositionLocalMap6, companion.e());
                    Function2 b15 = companion.b();
                    if (b14.getInserting() || !Intrinsics.areEqual(b14.rememberedValue(), Integer.valueOf(a13))) {
                        b14.updateRememberedValue(Integer.valueOf(a13));
                        b14.apply(Integer.valueOf(a13), b15);
                    }
                    g5.e(b14, e6, companion.d());
                    composer.startReplaceGroup(-2021268496);
                    e.b bVar = new e.b(0, 1, (DefaultConstructorMarker) null);
                    int o = bVar.o(new m2(((zl4.b) composer.consume(r.w())).u(), x0.x.h(20), androidx.compose.ui.text.font.c0.b.a(), (y) null, (androidx.compose.ui.text.font.z) null, (j) null, (String) null, 0L, (w0.a) null, (p) null, (f) null, 0L, (w0.i) null, (e2) null, (k0) null, (androidx.compose.ui.graphics.drawscope.g) null, 65528, (DefaultConstructorMarker) null));
                    try {
                        bVar.h(str2);
                        Unit unit = Unit.INSTANCE;
                        bVar.m(o);
                        composer.startReplaceGroup(-2021250953);
                        o = bVar.o(new m2(((zl4.b) composer.consume(r.w())).u(), x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (y) null, (androidx.compose.ui.text.font.z) null, (j) null, (String) null, 0L, (w0.a) null, (p) null, (f) null, 0L, (w0.i) null, (e2) null, (k0) null, (androidx.compose.ui.graphics.drawscope.g) null, 65532, (DefaultConstructorMarker) null));
                        try {
                            bVar.h(org.jetbrains.compose.resources.j.c(d0.c(c0Var2), composer, 0));
                            bVar.m(o);
                            composer.endReplaceGroup();
                            androidx.compose.ui.text.e q = bVar.q();
                            composer.endReplaceGroup();
                            a6.k(q, (Modifier) null, 0L, 0L, (y) null, (androidx.compose.ui.text.font.c0) null, (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, (g3) null, composer, 0, 0, 262142);
                            a6.j(org.jetbrains.compose.resources.j.c(d0.b(c0Var2), composer, 0) + (j / 100), f2.v(aVar, 0.0f, i.g(2), 0.0f, 0.0f, 13, (Object) null), ((zl4.b) composer.consume(r.w())).q(), x0.x.h(12), (y) null, (androidx.compose.ui.text.font.c0) null, (j) null, 0L, (w0.i) null, (h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3120, 0, 131056);
                            composer.endNode();
                            Modifier b16 = boxScopeInstance.b(SizeKt.s(f2.r(aVar, i.g(f4)), i.g(f5)), aVar2.n());
                            composer.startReplaceGroup(5004770);
                            boolean changed2 = composer.changed(function02);
                            Object rememberedValue2 = composer.rememberedValue();
                            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.vip.impl.ui.c
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit e7;
                                        e7 = ChapterEndVipCouponKt.a.C0081a.e(Function0.this);
                                        return e7;
                                    }
                                };
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            composer.endReplaceGroup();
                            z0.g(org.jetbrains.compose.resources.c.a(z.b(b0Var), composer, 0), (String) null, ClickableKt.clickable-oSLSa3U$default(b16, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, ((zl4.b) composer.consume(r.w())).q(), 0, 2, (Object) null), 0, composer, 48, 184);
                            composer.endNode();
                            composer.endNode();
                            z0.g(org.jetbrains.compose.resources.c.a(z.c(b0Var), composer, 0), (String) null, u1.f(SizeKt.i(SizeKt.x(f2.v(aVar, 0.0f, i.g(11), 0.0f, 0.0f, 13, (Object) null), i.g(1)), i.g(48)), g, 0.0f, 2, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 48, 248);
                            composer.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        } finally {
                        }
                    } finally {
                    }
                }
                composer.skipToGroupEnd();
            }
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
                    ComposerKt.traceEventStart(1848724392, i, -1, "com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCoupon.<anonymous> (ChapterEndVipCoupon.kt:78)");
                }
                u.c(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), (androidx.compose.ui.e) null, false, t.e(1285781502, true, new C0081a(this.a, this.b, this.c, this.d, this.e, this.f), composer, 54), composer, 3078, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long c(z1 z1Var) {
        return z1Var.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(long j) {
        long j2 = 3600;
        long j3 = 60;
        return StringsKt__StringsKt.padStart(String.valueOf(j / j2), 2, '0') + ':' + StringsKt__StringsKt.padStart(String.valueOf((j % j2) / j3), 2, '0') + ':' + StringsKt__StringsKt.padStart(String.valueOf(j % j3), 2, '0');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(z1 z1Var, long j) {
        z1Var.setLongValue(j);
    }

    public static final void b(final String title, final String discount, final long j, final long j2, final Function0<Unit> timeoutCallback, final Function0<Unit> onClick, final Function0<Unit> onCloseClick, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(timeoutCallback, "timeoutCallback");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer startRestartGroup = composer.startRestartGroup(-971444935);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(title)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i2 = i9 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(discount)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i2 |= i8;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(j)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i2 |= i7;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(j2)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i2 |= i6;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(timeoutCallback)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i2 |= i5;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changedInstance(onClick)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i2 |= i4;
        }
        if ((1572864 & i) == 0) {
            if (startRestartGroup.changedInstance(onCloseClick)) {
                i3 = 1048576;
            } else {
                i3 = 524288;
            }
            i2 |= i3;
        }
        boolean z2 = false;
        if ((599187 & i2) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-971444935, i2, -1, "com.dragon.read.kmp.vip.impl.ui.ChapterEndVipCoupon (ChapterEndVipCoupon.kt:58)");
            }
            long epochSeconds = Clock.System.INSTANCE.now().getEpochSeconds();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = f4.a(j2 - epochSeconds);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            z1 z1Var = (z1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (c(z1Var) <= 0) {
                timeoutCallback.invoke();
            }
            Long valueOf = Long.valueOf(j2);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((57344 & i2) == 16384) {
                z2 = true;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new ChapterEndVipCouponKt$ChapterEndVipCoupon$1$1(timeoutCallback, z1Var, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, startRestartGroup, (i2 >> 9) & 14);
            composer2 = startRestartGroup;
            com.dragon.read.kmp.reader.state.t.f(t.e(1848724392, true, new a(onClick, title, z1Var, onCloseClick, j, discount), composer2, 54), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.vip.impl.ui.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = ChapterEndVipCouponKt.e(title, discount, j, j2, timeoutCallback, onClick, onCloseClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }
}
