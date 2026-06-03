package com.dragon.read.kmp.view;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function5<Integer, String, Function0<Unit>, Composer, Integer, Unit> c;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    public final Function5<Integer, String, Function0<Unit>, Composer, Integer, Unit> b() {
        return c;
    }

    static {
        Covode.recordClassIndex(609588);
        a = new c();
        b = androidx.compose.runtime.internal.t.c(-1297813460, false, a.a);
        c = androidx.compose.runtime.internal.t.c(-1602953820, false, b.a);
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
                    ComposerKt.traceEventStart(-1297813460, i, -1, "com.dragon.read.kmp.view.ComposableSingletons$RelationSeriesDialogViewKt.lambda$-1297813460.<anonymous> (RelationSeriesDialogView.kt:242)");
                }
                Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, f);
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
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                mg4.q.j(composer, 0);
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

    static final class b implements Function5<Integer, String, Function0<? extends Unit>, Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Function0<? extends Unit> function0, Composer composer, Integer num2) {
            a(num.intValue(), str, function0, composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(int i, String msg, Function0<Unit> retry, Composer composer, int i2) {
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(retry, "retry");
            if ((i2 & 384) == 0) {
                if (composer.changedInstance(retry)) {
                    i3 = 256;
                } else {
                    i3 = 128;
                }
                i2 |= i3;
            }
            if ((i2 & 1153) != 1152) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1602953820, i2, -1, "com.dragon.read.kmp.view.ComposableSingletons$RelationSeriesDialogViewKt.lambda$-1602953820.<anonymous> (RelationSeriesDialogView.kt:249)");
                }
                Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, f);
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
                g5.e(b, i4, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                mg4.k.k(new mg4.b((String) null, retry, (String) null, (Function0) null, (androidx.compose.ui.graphics.l0) null, 29, (DefaultConstructorMarker) null), true, composer, 48, 0);
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
}
