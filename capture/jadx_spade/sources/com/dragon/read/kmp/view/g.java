package com.dragon.read.kmp.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.v2;
import androidx.compose.material.a6;
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
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.uicontext.appstyle.ThemeType;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.kmp.view.g;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w0.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    static {
        Covode.recordClassIndex(609590);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(String str, Function0 function0, Modifier modifier, List list, g3 g3Var, Modifier modifier2, int i, int i2, Composer composer, int i3) {
        c(str, function0, modifier, list, g3Var, modifier2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(gk4.p0 p0Var, bj4.a aVar, bj4.b bVar, int i, Composer composer, int i2) {
        e(p0Var, aVar, bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final void l() {
        m("show", null);
        com.dragon.read.kmp.j.a.d("MainUpdateDialogKmp", "MainUpdateDialogKmp onShow");
    }

    private static final void i(bj4.a aVar) {
        if (aVar != null) {
            aVar.onFinish();
        }
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ gk4.p0 a;
        final /* synthetic */ bj4.a b;
        final /* synthetic */ bj4.b c;
        final /* synthetic */ String d;

        b(gk4.p0 p0Var, bj4.a aVar, bj4.b bVar, String str) {
            this.a = p0Var;
            this.b = aVar;
            this.c = bVar;
            this.d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(Composer composer, int i) {
            boolean z;
            String str;
            Composer composer2;
            String str2;
            List listOf;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1598167481, i, -1, "com.dragon.read.kmp.view.MainUpdateDialogViewKmp.<anonymous> (MainUpdateDialogViewKmp.kt:73)");
                }
                com.dragon.read.kmp.j.a.d("MainUpdateDialogKmp", "MainUpdateDialogKmp: 创建NovelUiStyle完成，创建box");
                Modifier.a aVar = Modifier.Companion;
                Modifier x = SizeKt.x(aVar, x0.i.g(280));
                og4.a aVar2 = og4.a.a;
                int i2 = og4.a.b;
                float f = 8;
                Modifier a = androidx.compose.ui.draw.e.a(BackgroundKt.c(x, aVar2.h(composer, i2).D(), k.g.c(x0.i.g(f))), k.g.c(x0.i.g(f)));
                final gk4.p0 p0Var = this.a;
                final bj4.a aVar3 = this.b;
                final bj4.b bVar = this.c;
                String str3 = this.d;
                e.a aVar4 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(aVar4.o(), false);
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
                g5.e(b, i3, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar4.k(), composer, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, aVar);
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
                g5.e(b3, a4, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                String str4 = p0Var.h;
                if (str4 != null) {
                    str = StringUtilsKt.takeIfNotEmpty(str4);
                } else {
                    str = null;
                }
                coil3.compose.p.a(str, "Update Banner", SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(140)), new androidx.compose.ui.graphics.painter.a(org.jetbrains.compose.resources.c.a(com.dragon.read.component.biz.impl.update.d.a(com.dragon.read.component.biz.impl.update.h.a), composer, 0), 0L, 0L, 6, (DefaultConstructorMarker) null), (Painter) null, (Painter) null, (Function1) null, (Function1) null, (Function1) null, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, false, (coil3.compose.h) null, composer, 432, 0, 65520);
                Modifier t = f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(28), 0.0f, 2, (Object) null);
                androidx.compose.ui.layout.p0 a7 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar4.g(), composer, 48);
                int a8 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, t);
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
                Composer b5 = g5.b(composer);
                g5.e(b5, a7, companion.c());
                g5.e(b5, currentCompositionLocalMap3, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a8))) {
                    b5.updateRememberedValue(Integer.valueOf(a8));
                    b5.apply(Integer.valueOf(a8), b6);
                }
                g5.e(b5, e3, companion.d());
                String str5 = p0Var.g;
                if (str5 == null) {
                    str5 = "更新版本，海量短剧免费看";
                }
                long k = aVar2.h(composer, i2).k();
                long h = x0.x.h(18);
                androidx.compose.ui.text.font.c0 a10 = androidx.compose.ui.text.font.c0.b.a();
                h.a aVar5 = w0.h.b;
                float f2 = 24;
                float f3 = 12;
                a6.j(str5, SizeKt.i(SizeKt.x(f2.v(aVar, 0.0f, x0.i.g(f2), 0.0f, x0.i.g(f3), 5, (Object) null), x0.i.g(224)), x0.i.g(f2)), k, h, (androidx.compose.ui.text.font.y) null, a10, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar5.a()), 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer, 199728, 3072, 122320);
                if (str3 == null) {
                    str2 = "同时解锁小说一键生图新玩法，还原小说名场面";
                    composer2 = composer;
                } else {
                    composer2 = composer;
                    str2 = str3;
                }
                float f4 = 16;
                a6.j(str2, SizeKt.x(f2.v(aVar, 0.0f, 0.0f, 0.0f, x0.i.g(f4), 7, (Object) null), x0.i.g(215)), aVar2.h(composer2, i2).j(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar5.a()), x0.x.h(22), 0, false, 2, 0, (Function1) null, (g3) null, composer, 3120, 3078, 121328);
                composer.endNode();
                Modifier b7 = c0Var.b(f2.v(aVar, 0.0f, 0.0f, 0.0f, x0.i.g(32), 7, (Object) null), aVar4.g());
                androidx.compose.ui.layout.p0 a11 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar4.k(), composer, 0);
                int a12 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(composer, b7);
                Function0 a13 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a13);
                } else {
                    composer.useNode();
                }
                Composer b8 = g5.b(composer);
                g5.e(b8, a11, companion.c());
                g5.e(b8, currentCompositionLocalMap4, companion.e());
                Function2 b9 = companion.b();
                if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a12))) {
                    b8.updateRememberedValue(Integer.valueOf(a12));
                    b8.apply(Integer.valueOf(a12), b9);
                }
                g5.e(b8, e4, companion.d());
                String a14 = com.dragon.read.kmp.v.a.a();
                composer.startReplaceGroup(-1746271574);
                boolean changedInstance = composer.changedInstance(p0Var) | composer.changedInstance(aVar3) | composer.changedInstance(bVar);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.view.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d;
                            d = g.b.d(gk4.p0.this, aVar3, bVar);
                            return d;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                Modifier a15 = androidx.compose.ui.draw.e.a(c0Var.b(SizeKt.x(SizeKt.B(aVar, (e.c) null, false, 3, (Object) null), x0.i.g(178)), aVar4.g()), k.g.c(x0.i.g(18)));
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(aVar2.d().L()), androidx.compose.ui.graphics.l0.j(aVar2.d().c())});
                g.c(a14, function0, a15, listOf, null, null, composer, 6, 48);
                composer.endNode();
                composer.endNode();
                composer.startReplaceGroup(-1746271574);
                boolean changedInstance2 = composer.changedInstance(p0Var) | composer.changedInstance(aVar3) | composer.changedInstance(bVar);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.view.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e5;
                            e5 = g.b.e(gk4.p0.this, aVar3, bVar);
                            return e5;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                androidx.compose.material.v.g((Function0) rememberedValue2, SizeKt.s(f2.r(boxScopeInstance.b(aVar, aVar4.n()), x0.i.g(f3)), x0.i.g(f4)), false, (androidx.compose.foundation.interaction.i) null, (androidx.compose.material.s) null, (androidx.compose.ui.graphics.f2) null, (androidx.compose.foundation.w) null, (androidx.compose.material.p) null, f2.f(x0.i.g(0)), com.dragon.read.kmp.view.a.a.a(), composer, 905969664, 252);
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
        public static final Unit d(gk4.p0 p0Var, bj4.a aVar, bj4.b bVar) {
            g.k(p0Var, aVar, bVar);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(gk4.p0 p0Var, bj4.a aVar, bj4.b bVar) {
            g.j(p0Var, aVar, bVar);
            return Unit.INSTANCE;
        }
    }

    private static final void m(String str, String str2) {
        ym4.a aVar = new ym4.a();
        try {
            Result.Companion companion = Result.Companion;
            aVar.g("event_belong", "video");
            aVar.g("event_type", str);
            aVar.g("event_page", "video");
            aVar.g("event_module", "popup");
            if (StringUtilsKt.a(str2)) {
                aVar.g("action_type", str2);
            }
            ym4.o.a.d("test_invitation_popup", aVar);
            Result.m773constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m773constructorimpl(ResultKt.createFailure(th));
        }
    }

    static final class a implements Function3<v2, Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ List<androidx.compose.ui.graphics.l0> b;
        final /* synthetic */ String c;
        final /* synthetic */ Modifier d;
        final /* synthetic */ g3 e;

        a(Modifier modifier, List<androidx.compose.ui.graphics.l0> list, String str, Modifier modifier2, g3 g3Var) {
            this.a = modifier;
            this.b = list;
            this.c = str;
            this.d = modifier2;
            this.e = g3Var;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(v2 v2Var, Composer composer, Integer num) {
            a(v2Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(v2 TextButton, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1713189269, i, -1, "com.dragon.read.kmp.view.GradientTextButton.<anonymous> (MainUpdateDialogViewKmp.kt:193)");
                }
                Modifier b = BackgroundKt.b(this.a, c0.a.d(androidx.compose.ui.graphics.c0.b, this.b, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
                androidx.compose.ui.e e = androidx.compose.ui.e.a.e();
                String str = this.c;
                Modifier modifier = this.d;
                g3 g3Var = this.e;
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(e, false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, b);
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
                g5.e(b2, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                a6.j(str, modifier, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, g3Var, composer, 0, 0, 65532);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(gk4.p0 p0Var, bj4.a aVar, bj4.b bVar) {
        m("click", "cancel");
        com.dragon.read.kmp.j.a.d("MainUpdateDialogKmp", "MainUpdateDialogKmp click CANCEL");
        if (bVar != null) {
            bVar.a();
        }
        i(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(gk4.p0 p0Var, bj4.a aVar, bj4.b bVar) {
        m("click", "agree");
        com.dragon.read.kmp.j.a.d("MainUpdateDialogKmp", "MainUpdateDialogKmp click UPDATE");
        if (aVar != null) {
            aVar.onConsume();
        }
        if (p0Var.b) {
            if (bVar != null) {
                bVar.b();
            }
            i(aVar);
        } else {
            if (bVar != null) {
                bVar.c();
            }
            if (!p0Var.d || !p0Var.a) {
                i(aVar);
            }
        }
    }

    public static final void e(final gk4.p0 data, final bj4.a aVar, final bj4.b bVar, Composer composer, final int i) {
        int i2;
        boolean z;
        String str;
        int i3;
        int i4;
        boolean changedInstance;
        int i5;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(245503946);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(data);
            } else {
                changedInstance = startRestartGroup.changedInstance(data);
            }
            if (changedInstance) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(aVar)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(bVar)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(245503946, i2, -1, "com.dragon.read.kmp.view.MainUpdateDialogViewKmp (MainUpdateDialogViewKmp.kt:60)");
            }
            com.dragon.read.kmp.j.a.d("MainUpdateDialogKmp", "创建MainUpdateDialogViewKmp");
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (!((Boolean) mutableState.getValue()).booleanValue()) {
                l();
                mutableState.setValue(Boolean.TRUE);
            }
            if (data.c) {
                str = data.f;
            } else {
                str = data.e;
            }
            pg4.p.f(new pg4.i((pg4.a) null, ThemeType.APP, (Theme) null, 5, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(1598167481, true, new b(data, aVar, bVar, str), startRestartGroup, 54), startRestartGroup, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = g.f(gk4.p0.this, aVar, bVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final java.lang.String r48, final kotlin.jvm.functions.Function0<kotlin.Unit> r49, final androidx.compose.ui.Modifier r50, final java.util.List<androidx.compose.ui.graphics.l0> r51, androidx.compose.ui.text.g3 r52, androidx.compose.ui.Modifier r53, androidx.compose.runtime.Composer r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.view.g.c(java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, java.util.List, androidx.compose.ui.text.g3, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
