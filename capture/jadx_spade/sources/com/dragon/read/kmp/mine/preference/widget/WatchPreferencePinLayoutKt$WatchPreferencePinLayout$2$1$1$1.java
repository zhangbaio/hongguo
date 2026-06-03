package com.dragon.read.kmp.mine.preference.widget;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.kmp.reading.model.j00;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1 implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
    final /* synthetic */ WatchPreferenceViewModel a;
    final /* synthetic */ CollapsibleListState b;
    final /* synthetic */ int c;
    final /* synthetic */ j00 d;
    final /* synthetic */ boolean e;

    WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1(WatchPreferenceViewModel watchPreferenceViewModel, CollapsibleListState collapsibleListState, int i, j00 j00Var, boolean z) {
        this.a = watchPreferenceViewModel;
        this.b = collapsibleListState;
        this.c = i;
        this.d = j00Var;
        this.e = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
        b(fVar, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(WatchPreferenceViewModel watchPreferenceViewModel, CollapsibleListState collapsibleListState, int i) {
        kotlinx.coroutines.i.e(watchPreferenceViewModel.c, null, null, new WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1$1$1$1(collapsibleListState, i, null), 3, null);
        return Unit.INSTANCE;
    }

    public final void b(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
        boolean z;
        c0 e;
        long h;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i & 17) != 16) {
            z = true;
        } else {
            z = false;
        }
        if (composer.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1452882242, i, -1, "com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WatchPreferencePinLayout.kt:48)");
            }
            Modifier t = f2.t(Modifier.Companion, 0.0f, x0.i.g(9), 1, (Object) null);
            composer.startReplaceGroup(-1746271574);
            boolean changedInstance = composer.changedInstance(this.a) | composer.changedInstance(this.b) | composer.changed(this.c);
            final WatchPreferenceViewModel watchPreferenceViewModel = this.a;
            final CollapsibleListState collapsibleListState = this.b;
            final int i2 = this.c;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.preference.widget.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit c;
                        c = WatchPreferencePinLayoutKt$WatchPreferencePinLayout$2$1$1$1.c(WatchPreferenceViewModel.this, collapsibleListState, i2);
                        return c;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            j00 j00Var = this.d;
            boolean z2 = this.e;
            p0 i3 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a = j.a(androidx.compose.runtime.i.b(composer, 0));
            e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(composer, modifier);
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
            g5.e(b, i3, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            String str = j00Var.a;
            if (str == null) {
                str = "";
            }
            int a3 = w0.h.b.a();
            long h2 = x.h(16);
            c0.a aVar = c0.b;
            if (z2) {
                e = aVar.i();
            } else {
                e = aVar.e();
            }
            c0 c0Var = e;
            if (z2) {
                composer.startReplaceGroup(-339592375);
                h = og4.a.a.h(composer, og4.a.b).k();
            } else {
                composer.startReplaceGroup(-339591318);
                h = og4.a.a.h(composer, og4.a.b).h();
            }
            composer.endReplaceGroup();
            a6.j(str, (Modifier) null, h, h2, (y) null, c0Var, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a3), 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer, 3072, 3072, 122322);
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
