package hq4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import hq4.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w0.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    static {
        Covode.recordClassIndex(609669);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(rc4.b bVar, Function0 function0, int i, int i2, Composer composer, int i3) {
        e(bVar, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(String str, String str2, String str3, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        h(str, str2, str3, function0, function02, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, String str2, String str3, Function0 function0, int i, int i2, Composer composer, int i3) {
        j(str, str2, str3, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ Function0<Unit> b;
        final /* synthetic */ String c;
        final /* synthetic */ Function0<Unit> d;
        final /* synthetic */ String e;

        b(String str, Function0<Unit> function0, String str2, Function0<Unit> function02, String str3) {
            this.a = str;
            this.b = function0;
            this.c = str2;
            this.d = function02;
            this.e = str3;
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
                    ComposerKt.traceEventStart(2012011724, i, -1, "com.dragon.read.kmp.widget.dialog.CommonDialogView.<anonymous>.<anonymous> (CommonDialogView.kt:76)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                String str = this.a;
                final Function0<Unit> function0 = this.b;
                String str2 = this.c;
                final Function0<Unit> function02 = this.d;
                String str3 = this.e;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i2 = eVar.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 a = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, h);
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
                Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, h2);
                Function0 a5 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a5);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, i3, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                Modifier t = f2.t(BoxScopeInstance.a.b(SizeKt.h(f2.t(aVar, x0.i.g(28), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), aVar2.e()), 0.0f, x0.i.g(26), 1, (Object) null);
                h.a aVar3 = w0.h.b;
                int a6 = aVar3.a();
                og4.a aVar4 = og4.a.a;
                int i4 = og4.a.b;
                long k = aVar4.h(composer, i4).k();
                long h3 = x0.x.h(16);
                c0.a aVar5 = androidx.compose.ui.text.font.c0.b;
                a6.j(str, t, k, h3, (androidx.compose.ui.text.font.y) null, aVar5.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a6), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 130512);
                composer.endNode();
                a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar4.h(composer, i4).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                Modifier i5 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(54));
                p0 b5 = r2.b(eVar.h(), aVar2.i(), composer, 48);
                int a7 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, i5);
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
                Composer b6 = g5.b(composer);
                g5.e(b6, b5, companion.c());
                g5.e(b6, currentCompositionLocalMap3, companion.e());
                Function2 b7 = companion.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a7))) {
                    b6.updateRememberedValue(Integer.valueOf(a7));
                    b6.apply(Integer.valueOf(a7), b7);
                }
                g5.e(b6, e3, companion.d());
                w2 w2Var = w2.b;
                Modifier a9 = u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(function0);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: hq4.o
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d;
                            d = n.b.d(Function0.this);
                            return d;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                a6.j(str2, ClickableKt.clickable-oSLSa3U$default(a9, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), aVar4.h(composer, i4).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar5.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar3.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 130512);
                a3.a(BackgroundKt.d(SizeKt.u(aVar, x0.i.g(0.5f), x0.i.g(16)), aVar4.h(composer, i4).E(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                Modifier a10 = u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changed2 = composer.changed(function02);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: hq4.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e4;
                            e4 = n.b.e(Function0.this);
                            return e4;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                a6.j(str3, ClickableKt.clickable-oSLSa3U$default(a10, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), aVar4.h(composer, i4).f(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar5.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar3.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 130512);
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
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Function0<Unit> c;
        final /* synthetic */ String d;

        c(String str, String str2, Function0<Unit> function0, String str3) {
            this.a = str;
            this.b = str2;
            this.c = function0;
            this.d = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-516333542, i, -1, "com.dragon.read.kmp.widget.dialog.DescDialogView.<anonymous>.<anonymous> (CommonDialogView.kt:144)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                String str = this.a;
                String str2 = this.b;
                final Function0<Unit> function0 = this.c;
                String str3 = this.d;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i2 = eVar.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 a = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, h);
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
                Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, h2);
                Function0 a5 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a5);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, i3, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier b5 = boxScopeInstance.b(SizeKt.x(f2.v(aVar, 0.0f, x0.i.g(32), 0.0f, x0.i.g(8), 5, (Object) null), x0.i.g(224)), aVar2.e());
                h.a aVar3 = w0.h.b;
                int a6 = aVar3.a();
                og4.a aVar4 = og4.a.a;
                int i4 = og4.a.b;
                long k = aVar4.h(composer, i4).k();
                long h3 = x0.x.h(18);
                c0.a aVar5 = androidx.compose.ui.text.font.c0.b;
                a6.j(str, b5, k, h3, (androidx.compose.ui.text.font.y) null, aVar5.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a6), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 130512);
                composer.endNode();
                Modifier h4 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, h4);
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
                Composer b6 = g5.b(composer);
                g5.e(b6, i5, companion.c());
                g5.e(b6, currentCompositionLocalMap3, companion.e());
                Function2 b7 = companion.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a7))) {
                    b6.updateRememberedValue(Integer.valueOf(a7));
                    b6.apply(Integer.valueOf(a7), b7);
                }
                g5.e(b6, e3, companion.d());
                a6.j(str2, boxScopeInstance.b(SizeKt.x(f2.v(aVar, 0.0f, x0.i.g(15), 0.0f, 0.0f, 13, (Object) null), x0.i.g(227)), aVar2.e()), aVar4.h(composer, i4).j(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar3.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 130544);
                composer.endNode();
                a3.a(androidx.compose.foundation.layout.a0.a(c0Var, aVar, 1.0f, false, 2, (Object) null), composer, 0);
                a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g((float) 0.5d)), aVar4.h(composer, i4).i(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                Modifier i6 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(53));
                p0 b8 = r2.b(eVar.h(), aVar2.i(), composer, 48);
                int a9 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(composer, i6);
                Function0 a10 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a10);
                } else {
                    composer.useNode();
                }
                Composer b9 = g5.b(composer);
                g5.e(b9, b8, companion.c());
                g5.e(b9, currentCompositionLocalMap4, companion.e());
                Function2 b10 = companion.b();
                if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a9))) {
                    b9.updateRememberedValue(Integer.valueOf(a9));
                    b9.apply(Integer.valueOf(a9), b10);
                }
                g5.e(b9, e4, companion.d());
                Modifier a11 = u2.a(w2.b, aVar, 1.0f, false, 2, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(function0);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: hq4.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = n.c.c(Function0.this);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                a6.j(str3, ClickableKt.clickable-oSLSa3U$default(a11, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), aVar4.h(composer, i4).f(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar5.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar3.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 130512);
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
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ rc4.b a;

        a(rc4.b bVar) {
            this.a = bVar;
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
                    ComposerKt.traceEventStart(-1043477654, i, -1, "com.dragon.read.kmp.widget.dialog.CommonAnimatedDialogView.<anonymous> (CommonDialogView.kt:51)");
                }
                rc4.b bVar = this.a;
                n.h(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final rc4.b r18, kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hq4.n.e(rc4.b, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void h(final String title, final String positiveText, final String negativeText, final Function0<Unit> onPositive, final Function0<Unit> onNegative, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(positiveText, "positiveText");
        Intrinsics.checkNotNullParameter(negativeText, "negativeText");
        Intrinsics.checkNotNullParameter(onPositive, "onPositive");
        Intrinsics.checkNotNullParameter(onNegative, "onNegative");
        Composer startRestartGroup = composer.startRestartGroup(906865315);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(title)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i2 = i7 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(positiveText)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i2 |= i6;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(negativeText)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i2 |= i5;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(onPositive)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i2 |= i4;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onNegative)) {
                i3 = 16384;
            } else {
                i3 = 8192;
            }
            i2 |= i3;
        }
        if ((i2 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(906865315, i2, -1, "com.dragon.read.kmp.widget.dialog.CommonDialogView (CommonDialogView.kt:69)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
            p0 i8 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, f);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i8, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            composer2 = startRestartGroup;
            androidx.compose.material.w.a(SizeKt.x(aVar, x0.i.g(280)), k.g.c(x0.i.g(8)), og4.a.a.h(startRestartGroup, og4.a.b).D(), 0L, (androidx.compose.foundation.w) null, 0.0f, androidx.compose.runtime.internal.t.e(2012011724, true, new b(title, onNegative, negativeText, onPositive, positiveText), startRestartGroup, 54), composer2, 1572870, 56);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: hq4.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i9;
                    i9 = n.i(title, positiveText, negativeText, onPositive, onNegative, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i9;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(java.lang.String r18, java.lang.String r19, final java.lang.String r20, final kotlin.jvm.functions.Function0<kotlin.Unit> r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hq4.n.j(java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
