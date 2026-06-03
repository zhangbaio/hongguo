package com.dragon.read.kmp.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(609625);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Modifier modifier, c cVar, int i, int i2, Composer composer, int i3) {
        b(modifier, cVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            org.jetbrains.compose.resources.b h;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-690631146, i, -1, "com.dragon.read.kmp.widget.AudioIconBgWrapperCover.<anonymous> (AudioIconBgWrapperCover.kt:48)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier a = androidx.compose.ui.draw.e.a(SizeKt.f(aVar, 0.0f, 1, (Object) null), k.g.c(this.a.d));
                c cVar = this.a;
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, a);
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
                LoadImageKt.g(cVar.a, "Continue Watch Double Card Cover Blur Bg", (com.dragon.read.kmp.compose.common.image.n) null, BlurKt.c(SizeKt.i(SizeKt.x(aVar, cVar.b), cVar.c), x0.i.g(25), (androidx.compose.ui.draw.b) null, 2, (Object) null), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer, 48, 116);
                iy2.e0 e0Var = iy2.e0.a;
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(iy2.c0.i(e0Var), composer, 0), "Play icon background", SizeKt.f(aVar, 0.0f, 1, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, composer, 432, 248);
                if (cVar.f) {
                    h = iy2.c0.g(e0Var);
                } else {
                    h = iy2.c0.h(e0Var);
                }
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(h, composer, 0), "Play icon", boxScopeInstance.b(SizeKt.s(aVar, cVar.e), aVar2.e()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, composer, 48, 248);
                composer.startReplaceGroup(-1768612725);
                og4.a aVar3 = og4.a.a;
                int i3 = og4.a.b;
                if (com.dragon.read.kmp.service.d1.d(aVar3.e(composer, i3))) {
                    androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.f(aVar, 0.0f, 1, (Object) null), aVar3.h(composer, i3).V1(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
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

    public static final void b(Modifier modifier, final c config, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        int i4;
        int i5;
        boolean z;
        Composer composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(config, "config");
        Composer startRestartGroup = composer.startRestartGroup(-645252045);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(config)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i6 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-645252045, i3, -1, "com.dragon.read.kmp.widget.AudioIconBgWrapperCover (AudioIconBgWrapperCover.kt:38)");
            }
            Modifier modifier4 = modifier3;
            composer2 = startRestartGroup;
            androidx.compose.material.w.a(SizeKt.i(SizeKt.x(modifier3, config.b), config.c), k.g.c(config.d), androidx.compose.ui.graphics.l0.b.g(), 0L, (androidx.compose.foundation.w) null, x0.i.g(0), androidx.compose.runtime.internal.t.e(-690631146, true, new a(config), startRestartGroup, 54), startRestartGroup, 1794432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = b.c(modifier2, config, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
