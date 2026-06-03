package com.dragon.read.kmp.reader.font;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.b;
import androidx.compose.foundation.lazy.grid.m1;
import androidx.compose.foundation.y1;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.a6;
import androidx.compose.material.n2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import com.dragon.read.kmp.reader.font.FontListCpnKt;
import com.dragon.read.kmp.reader.ui.PullDownCpnKt;
import com.dragon.read.reader.n3;
import com.dragon.read.reader.o3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import rm4.a;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FontListCpnKt {
    private static int a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(r0 r0Var, int i, Composer composer, int i2) {
        g(r0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(r0 r0Var, Context context, v0 v0Var, w0 w0Var, boolean z, Function1 function1, n2 n2Var, int i, Composer composer, int i2) {
        l(r0Var, context, v0Var, w0Var, z, function1, n2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(r0 r0Var, int i, Composer composer, int i2) {
        p(r0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final int t() {
        return a;
    }

    static {
        int i;
        Covode.recordClassIndex(608433);
        if (com.dragon.read.kmp.reader.services.x.a.e().f7()) {
            i = 405;
        } else {
            i = 361;
        }
        a = i;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ r0 a;
        final /* synthetic */ Context b;
        final /* synthetic */ v0 c;
        final /* synthetic */ w0 d;
        final /* synthetic */ n2 e;
        final /* synthetic */ MutableState<Boolean> f;

        a(r0 r0Var, Context context, v0 v0Var, w0 w0Var, n2 n2Var, MutableState<Boolean> mutableState) {
            this.a = r0Var;
            this.b = context;
            this.c = v0Var;
            this.d = w0Var;
            this.e = n2Var;
            this.f = mutableState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(r0 r0Var) {
            a.C0260a.a(r0Var.a, false, 1, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(MutableState mutableState, boolean z) {
            FontListCpnKt.i(mutableState, z);
            return Unit.INSTANCE;
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
                    ComposerKt.traceEventStart(592410704, i, -1, "com.dragon.read.kmp.reader.font.FontList.<anonymous> (FontListCpn.kt:101)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier d = BackgroundKt.d(SizeKt.f(aVar, 0.0f, 1, (Object) null), androidx.compose.ui.graphics.l0.b.g(), (f2) null, 2, (Object) null);
                androidx.compose.ui.e b = androidx.compose.ui.e.a.b();
                final r0 r0Var = this.a;
                Context context = this.b;
                v0 v0Var = this.c;
                w0 w0Var = this.d;
                n2 n2Var = this.e;
                final MutableState<Boolean> mutableState = this.f;
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(b, false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, d);
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
                g5.e(b2, i2, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(r0Var);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.font.h0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d2;
                            d2 = FontListCpnKt.a.d(r0.this);
                            return d2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                androidx.compose.foundation.layout.m.b(ClickableKt.clickable-oSLSa3U$default(f, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), composer, 0);
                boolean h = FontListCpnKt.h(mutableState);
                composer.startReplaceGroup(5004770);
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.font.i0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit e2;
                            e2 = FontListCpnKt.a.e(mutableState, ((Boolean) obj).booleanValue());
                            return e2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                FontListCpnKt.l(r0Var, context, v0Var, w0Var, h, (Function1) rememberedValue2, n2Var, composer, (n2.e << 18) | 196608);
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

    static final class b implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        final /* synthetic */ long a;
        final /* synthetic */ w0 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ float d;
        final /* synthetic */ Function1<Boolean, Unit> e;
        final /* synthetic */ LazyGridState f;
        final /* synthetic */ v0 g;
        final /* synthetic */ n2 h;
        final /* synthetic */ r0 i;

        /* JADX WARN: Multi-variable type inference failed */
        b(long j, w0 w0Var, boolean z, float f, Function1<? super Boolean, Unit> function1, LazyGridState lazyGridState, v0 v0Var, n2 n2Var, r0 r0Var) {
            this.a = j;
            this.b = w0Var;
            this.c = z;
            this.d = f;
            this.e = function1;
            this.f = lazyGridState;
            this.g = v0Var;
            this.h = n2Var;
            this.i = r0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(r0 r0Var) {
            a.C0260a.a(r0Var.a, false, 1, null);
            return Unit.INSTANCE;
        }

        static final class a implements Function4<androidx.compose.foundation.lazy.grid.w, Integer, Composer, Integer, Unit> {
            final /* synthetic */ v0 a;
            final /* synthetic */ boolean b;
            final /* synthetic */ w0 c;
            final /* synthetic */ n2 d;

            a(v0 v0Var, boolean z, w0 w0Var, n2 n2Var) {
                this.a = v0Var;
                this.b = z;
                this.c = w0Var;
                this.d = n2Var;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit g(v0 v0Var, h hVar) {
                v0Var.j(hVar);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit h(v0 v0Var, h hVar) {
                v0Var.m(hVar);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit i(v0 v0Var, h hVar) {
                v0Var.j(hVar);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean j(v0 v0Var, h hVar) {
                return v0Var.l(hVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit k(v0 v0Var, h hVar) {
                v0Var.m(hVar);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Integer num, Composer composer, Integer num2) {
                f(wVar, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void f(androidx.compose.foundation.lazy.grid.w items, int i, Composer composer, int i2) {
                int i3;
                boolean z;
                int i4;
                Intrinsics.checkNotNullParameter(items, "$this$items");
                if ((i2 & 48) == 0) {
                    if (composer.changed(i)) {
                        i4 = 32;
                    } else {
                        i4 = 16;
                    }
                    i3 = i4 | i2;
                } else {
                    i3 = i2;
                }
                if ((i3 & 145) != 144) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i3 & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(369986161, i3, -1, "com.dragon.read.kmp.reader.font.FontListContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FontListCpn.kt:253)");
                    }
                    final h hVar = this.a.f.get(i);
                    a0 n = this.a.n(hVar, this.b, this.c.e, composer, 0);
                    if (this.c.e) {
                        composer.startReplaceGroup(1371952553);
                        w0 w0Var = this.c;
                        composer.startReplaceGroup(-1633490746);
                        boolean changedInstance = composer.changedInstance(this.a) | composer.changed(hVar);
                        final v0 v0Var = this.a;
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.font.m0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit g;
                                    g = FontListCpnKt.b.a.g(v0.this, hVar);
                                    return g;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        Function0 function0 = (Function0) rememberedValue;
                        composer.endReplaceGroup();
                        composer.startReplaceGroup(-1633490746);
                        boolean changedInstance2 = composer.changedInstance(this.a) | composer.changed(hVar);
                        final v0 v0Var2 = this.a;
                        Object rememberedValue2 = composer.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.font.n0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit h;
                                    h = FontListCpnKt.b.a.h(v0.this, hVar);
                                    return h;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        composer.endReplaceGroup();
                        p.j(n, w0Var, function0, (Function0) rememberedValue2, composer, 0);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(1372320430);
                        w0 w0Var2 = this.c;
                        n2 n2Var = this.d;
                        composer.startReplaceGroup(-1633490746);
                        boolean changedInstance3 = composer.changedInstance(this.a) | composer.changed(hVar);
                        final v0 v0Var3 = this.a;
                        Object rememberedValue3 = composer.rememberedValue();
                        if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.reader.font.o0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit i5;
                                    i5 = FontListCpnKt.b.a.i(v0.this, hVar);
                                    return i5;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue3);
                        }
                        Function0 function02 = (Function0) rememberedValue3;
                        composer.endReplaceGroup();
                        composer.startReplaceGroup(-1633490746);
                        boolean changedInstance4 = composer.changedInstance(this.a) | composer.changed(hVar);
                        final v0 v0Var4 = this.a;
                        Object rememberedValue4 = composer.rememberedValue();
                        if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.reader.font.p0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    boolean j;
                                    j = FontListCpnKt.b.a.j(v0.this, hVar);
                                    return Boolean.valueOf(j);
                                }
                            };
                            composer.updateRememberedValue(rememberedValue4);
                        }
                        Function0 function03 = (Function0) rememberedValue4;
                        composer.endReplaceGroup();
                        composer.startReplaceGroup(-1633490746);
                        boolean changedInstance5 = composer.changedInstance(this.a) | composer.changed(hVar);
                        final v0 v0Var5 = this.a;
                        Object rememberedValue5 = composer.rememberedValue();
                        if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.reader.font.q0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit k;
                                    k = FontListCpnKt.b.a.k(v0.this, hVar);
                                    return k;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue5);
                        }
                        composer.endReplaceGroup();
                        FontItemMultiTypeKt.m(n, w0Var2, n2Var, function02, function03, (Function0) rememberedValue5, composer, n2.e << 6);
                        composer.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            d(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object g(v0 v0Var, boolean z, int i) {
            return v0Var.f.get(i).a + z;
        }

        public final void d(androidx.compose.foundation.layout.r PullDownCpn, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(PullDownCpn, "$this$PullDownCpn");
            if ((i & 6) == 0) {
                if (composer.changed(PullDownCpn)) {
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
                    ComposerKt.traceEventStart(1534157580, i2, -1, "com.dragon.read.kmp.reader.font.FontListContent.<anonymous> (FontListCpn.kt:180)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier i4 = SizeKt.i(BackgroundKt.d(aVar, this.a, (f2) null, 2, (Object) null), x0.i.g(FontListCpnKt.t()));
                float f = this.d;
                final w0 w0Var = this.b;
                final boolean z2 = this.c;
                Function1<Boolean, Unit> function1 = this.e;
                LazyGridState lazyGridState = this.f;
                final v0 v0Var = this.g;
                final n2 n2Var = this.h;
                final r0 r0Var = this.i;
                e.m i5 = androidx.compose.foundation.layout.e.a.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(i5, aVar2.k(), composer, 0);
                int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, i4);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
                Composer b = g5.b(composer);
                g5.e(b, a2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                    b.updateRememberedValue(Integer.valueOf(a3));
                    b.apply(Integer.valueOf(a3), b2);
                }
                g5.e(b, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                Modifier i6 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(56));
                androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, i6);
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
                Composer b3 = g5.b(composer);
                g5.e(b3, i7, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                float f2 = 20;
                float f3 = 24;
                Modifier s = SizeKt.s(androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(aVar, aVar2.h()), x0.i.g(f2), 0.0f, 0.0f, 0.0f, 14, (Object) null), x0.i.g(f3));
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(r0Var);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.font.j0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e3;
                            e3 = FontListCpnKt.b.e(r0.this);
                            return e3;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, modifier);
                Function0 a8 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a8);
                } else {
                    composer.useNode();
                }
                Composer b5 = g5.b(composer);
                g5.e(b5, i8, companion.c());
                g5.e(b5, currentCompositionLocalMap3, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a7))) {
                    b5.updateRememberedValue(Integer.valueOf(a7));
                    b5.apply(Integer.valueOf(a7), b6);
                }
                g5.e(b5, e3, companion.d());
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(d2.g(f2.a.a), composer, 0), (String) null, boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(f3)), aVar2.e()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, ((zl4.b) composer.consume(zl4.r.w())).o(), 0, 2, (Object) null), 0, composer, 48, 184);
                composer.endNode();
                a6.j(org.jetbrains.compose.resources.j.c(o3.n(n3.a), composer, 0), boxScopeInstance.b(aVar, aVar2.e()), ((zl4.b) composer.consume(zl4.r.w())).o(), x0.x.h(18), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131024);
                composer.startReplaceGroup(1311574890);
                if (!w0Var.g && com.dragon.read.kmp.reader.services.x.a.e().f7()) {
                    f.j(z2, boxScopeInstance.b(androidx.compose.foundation.layout.f2.v(aVar, 0.0f, 0.0f, x0.i.g(f2), 0.0f, 11, (Object) null), aVar2.f()), function1, composer, 0, 0);
                }
                composer.endReplaceGroup();
                composer.endNode();
                float g = x0.i.g(f - x0.i.g(51));
                composer.startReplaceGroup(1326099259);
                if (w0Var.g && com.dragon.read.kmp.reader.services.x.a.e().f7()) {
                    f.e(z2, null, function1, composer, 0, 2);
                    g = x0.i.g(f - x0.i.g(100));
                }
                composer.endReplaceGroup();
                b.a aVar3 = new b.a(w0Var.f);
                float f4 = 11;
                Modifier b7 = c0Var.b(androidx.compose.foundation.layout.f2.v(SizeKt.i(androidx.compose.foundation.layout.f2.v(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(f4), 0.0f, x0.i.g(f4), 0.0f, 10, (Object) null), g), 0.0f, 0.0f, 0.0f, x0.i.g(16), 7, (Object) null), aVar2.g());
                composer.startReplaceGroup(-1224400529);
                boolean changedInstance2 = composer.changedInstance(v0Var) | composer.changed(z2) | composer.changed(w0Var) | composer.changedInstance(n2Var);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.font.k0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit f5;
                            f5 = FontListCpnKt.b.f(v0.this, z2, w0Var, n2Var, (androidx.compose.foundation.lazy.grid.w0) obj);
                            return f5;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                androidx.compose.foundation.lazy.grid.i.c(aVar3, b7, lazyGridState, (i2) null, false, (e.m) null, (e.e) null, (l1) null, false, (y1) null, (Function1) rememberedValue2, composer, 0, 0, 1016);
                composer.endNode();
                if (!this.b.g && !this.c && com.dragon.read.kmp.reader.services.x.a.e().f7()) {
                    a6.j("因版权问题部分书暂不支持繁体", PullDownCpn.b(androidx.compose.foundation.layout.f2.v(aVar, 0.0f, 0.0f, 0.0f, x0.i.g(f2), 7, (Object) null), aVar2.b()), ((zl4.b) composer.consume(zl4.r.w())).q(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3078, 0, 131056);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(final v0 v0Var, final boolean z, w0 w0Var, n2 n2Var, androidx.compose.foundation.lazy.grid.w0 LazyVerticalGrid) {
            Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
            androidx.compose.foundation.lazy.grid.v0.b(LazyVerticalGrid, v0Var.f.size(), new Function1() { // from class: com.dragon.read.kmp.reader.font.l0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object g;
                    g = FontListCpnKt.b.g(v0.this, z, ((Integer) obj).intValue());
                    return g;
                }
            }, (Function2) null, (Function1) null, androidx.compose.runtime.internal.t.c(369986161, true, new a(v0Var, z, w0Var, n2Var)), 12, (Object) null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(MutableState mutableState, boolean z) {
        i(mutableState, z);
        return Unit.INSTANCE;
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ r0 a;

        c(r0 r0Var) {
            this.a = r0Var;
        }

        static final class a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ r0 a;

            a(r0 r0Var) {
                this.a = r0Var;
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
                        ComposerKt.traceEventStart(1897367897, i, -1, "com.dragon.read.kmp.reader.font.FontListCpn.<anonymous>.<anonymous> (FontListCpn.kt:71)");
                    }
                    FontListCpnKt.g(this.a, composer, 0);
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
                    ComposerKt.traceEventStart(1793661160, i, -1, "com.dragon.read.kmp.reader.font.FontListCpn.<anonymous> (FontListCpn.kt:70)");
                }
                com.dragon.read.kmp.reader.state.t.f(androidx.compose.runtime.internal.t.e(1897367897, true, new a(this.a), composer, 54), composer, 6);
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
    public static final Unit n(Function1 function1, Context context, boolean z) {
        if (!z) {
            function1.invoke(Boolean.TRUE);
        }
        function1.invoke(Boolean.valueOf(com.dragon.read.kmp.reader.services.x.a.e().e8(context)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final Context context, final Function1 function1, boolean z) {
        String str;
        boolean z2 = !z;
        com.dragon.read.kmp.reader.services.x.a.e().g2(context, z2, new Function1() { // from class: com.dragon.read.kmp.reader.font.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n;
                n = FontListCpnKt.n(Function1.this, context, ((Boolean) obj).booleanValue());
                return n;
            }
        });
        ym4.o oVar = ym4.o.a;
        if (z2) {
            str = "traditional";
        } else {
            str = "simplified";
        }
        oVar.a("font_config", new ym4.a("clicked_content", str));
        return Unit.INSTANCE;
    }

    public static final void p(final r0 params, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Composer startRestartGroup = composer.startRestartGroup(345476285);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(params);
            } else {
                changedInstance = startRestartGroup.changedInstance(params);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(345476285, i2, -1, "com.dragon.read.kmp.reader.font.FontListCpn (FontListCpn.kt:68)");
            }
            ym4.f.c("FontListCpn", params, androidx.compose.runtime.internal.t.e(1793661160, true, new c(params), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = FontListCpnKt.q(r0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }

    public static final void g(final r0 params, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Composer startRestartGroup = composer.startRestartGroup(394675730);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(params);
            } else {
                changedInstance = startRestartGroup.changedInstance(params);
            }
            if (changedInstance) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        boolean z2 = false;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(394675730, i2, -1, "com.dragon.read.kmp.reader.font.FontList (FontListCpn.kt:80)");
            }
            Context a2 = ig4.f.a(startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(com.dragon.read.kmp.reader.services.x.a.e().e8(a2)), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            boolean h = h(mutableState);
            startRestartGroup.startReplaceGroup(-1746271574);
            int i4 = i2 & 14;
            if (i4 == 4 || ((i2 & 8) != 0 && startRestartGroup.changed(params))) {
                z2 = true;
            }
            boolean changed = startRestartGroup.changed(a2) | z2 | startRestartGroup.changed(h);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new v0(params, a2, h(mutableState));
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final v0 v0Var = (v0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            final n2 H = ModalBottomSheetKt.H(ModalBottomSheetValue.Hidden, (androidx.compose.animation.core.i) null, (Function1) null, true, startRestartGroup, 3078, 6);
            w0 g = v0Var.g();
            if (!g.e) {
                startRestartGroup.startReplaceGroup(-1835103690);
                a = params.d() / 2;
                ModalBottomSheetKt.p(androidx.compose.runtime.internal.t.e(1830484969, true, new Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit>() { // from class: com.dragon.read.kmp.reader.font.FontListCpnKt$FontList$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.b0 b0Var, Composer composer3, Integer num) {
                        a(b0Var, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void a(androidx.compose.foundation.layout.b0 ModalBottomSheetLayout, Composer composer3, int i5) {
                        boolean z3;
                        Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
                        if ((i5 & 17) != 16) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composer3.shouldExecute(z3, i5 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1830484969, i5, -1, "com.dragon.read.kmp.reader.font.FontList.<anonymous> (FontListCpn.kt:97)");
                            }
                            v0 v0Var2 = v0.this;
                            composer3.startReplaceGroup(5004770);
                            boolean changedInstance2 = composer3.changedInstance(v0Var2);
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new FontListCpnKt$FontList$1$1$1(v0Var2);
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceGroup();
                            FontItemMultiTypeKt.i((Function0) SnapshotStateKt.rememberUpdatedState((KFunction) rememberedValue3, composer3, 0).getValue(), H, composer3, n2.e << 3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54), SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(params.d())), H, false, (androidx.compose.ui.graphics.f2) null, 0.0f, androidx.compose.ui.graphics.l0.b.g(), 0L, 0L, androidx.compose.runtime.internal.t.e(592410704, true, new a(params, a2, v0Var, g, H, mutableState), startRestartGroup, 54), startRestartGroup, (n2.e << 6) | 806879238, 440);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceGroup(-1833739690);
                boolean h2 = h(mutableState);
                startRestartGroup.startReplaceGroup(5004770);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.reader.font.c0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit j;
                            j = FontListCpnKt.j(mutableState, ((Boolean) obj).booleanValue());
                            return j;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                l(params, a2, v0Var, g, h2, (Function1) rememberedValue3, H, startRestartGroup, i4 | 196608 | (n2.e << 18));
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = FontListCpnKt.k(r0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    public static final void l(final r0 params, final Context context, final v0 stateHolder, final w0 fontUiConfig, final boolean z, final Function1<? super Boolean, Unit> onSimplifiedChanged, final n2 bottomSheetState, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        boolean z3;
        boolean changedInstance;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean changedInstance2;
        int i9;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stateHolder, "stateHolder");
        Intrinsics.checkNotNullParameter(fontUiConfig, "fontUiConfig");
        Intrinsics.checkNotNullParameter(onSimplifiedChanged, "onSimplifiedChanged");
        Intrinsics.checkNotNullParameter(bottomSheetState, "bottomSheetState");
        Composer startRestartGroup = composer.startRestartGroup(830174078);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance2 = startRestartGroup.changed(params);
            } else {
                changedInstance2 = startRestartGroup.changedInstance(params);
            }
            if (changedInstance2) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i2 = i9 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(context)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i2 |= i8;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(stateHolder)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i2 |= i7;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(fontUiConfig)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i2 |= i6;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changed(z)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i2 |= i5;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changedInstance(onSimplifiedChanged)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i2 |= i4;
        }
        if ((1572864 & i) == 0) {
            if ((2097152 & i) == 0) {
                changedInstance = startRestartGroup.changed(bottomSheetState);
            } else {
                changedInstance = startRestartGroup.changedInstance(bottomSheetState);
            }
            if (changedInstance) {
                i3 = 1048576;
            } else {
                i3 = 524288;
            }
            i2 |= i3;
        }
        if ((599187 & i2) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(830174078, i2, -1, "com.dragon.read.kmp.reader.font.FontListContent (FontListCpn.kt:148)");
            }
            long m = ((zl4.b) startRestartGroup.consume(zl4.r.w())).m((ReaderBgColorType) startRestartGroup.consume(zl4.r.u()));
            float g = x0.i.g(a);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance3 = startRestartGroup.changedInstance(context);
            if ((i2 & 458752) == 131072) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z4 = changedInstance3 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.reader.font.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit m2;
                        m2 = FontListCpnKt.m(context, onSimplifiedChanged, ((Boolean) obj).booleanValue());
                        return m2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            LazyGridState g2 = m1.g(0, 0, startRestartGroup, 0, 3);
            boolean c2 = params.c();
            y0 y0Var = params.a;
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance4 = startRestartGroup.changedInstance(y0Var);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new FontListCpnKt$FontListContent$1$1(y0Var);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            y0 y0Var2 = params.a;
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance5 = startRestartGroup.changedInstance(y0Var2);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new FontListCpnKt$FontListContent$2$1(y0Var2);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1932084917);
            float M0 = ((x0.e) startRestartGroup.consume(CompositionLocalsKt.f())).M0(g);
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            PullDownCpnKt.c(c2, function0, (Function0) ((KFunction) rememberedValue3), M0, 0.0f, g2, androidx.compose.runtime.internal.t.e(1534157580, true, new b(m, fontUiConfig, z, g, function1, g2, stateHolder, bottomSheetState, params), composer2, 54), composer2, 1572864, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.font.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = FontListCpnKt.o(r0.this, context, stateHolder, fontUiConfig, z, onSimplifiedChanged, bottomSheetState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }
}
