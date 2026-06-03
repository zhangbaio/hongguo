package com.dragon.read.kmp.story.impl.feeds.actionbar.menu;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.lazy.y0;
import androidx.compose.foundation.y1;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.readingSetting.v;
import com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.k;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryMenuDialogKt {
    private static String a;

    public static final class b implements Function1 {
        public static final b a = new b();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(fp4.c cVar) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(h hVar, Function0 function0, int i, Composer composer, int i2) {
        e(hVar, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.INSTANCE;
    }

    static final class a implements Function0<Unit> {
        final /* synthetic */ fp4.c a;
        final /* synthetic */ Function0<Unit> b;

        a(fp4.c cVar, Function0<Unit> function0) {
            this.a = cVar;
            this.b = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.a.e.invoke();
            if (this.a.c) {
                this.b.invoke();
            }
        }
    }

    static {
        Covode.recordClassIndex(609232);
        a = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final class c implements Function1<Integer, Object> {
        final /* synthetic */ Function1 a;
        final /* synthetic */ List b;

        public c(Function1 function1, List list) {
            this.a = function1;
            this.b = list;
        }

        public final Object a(int i) {
            return this.a.invoke(this.b.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h o(kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM) {
        List mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new v(bVar, kmpStoryFeedsVM), new com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.d(bVar));
        return new h(mutableListOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h p(kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM) {
        List mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new v(bVar, kmpStoryFeedsVM), new k(bVar));
        return new h(mutableListOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(h hVar, Function0 function0, o0 LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        List<fp4.c> list = hVar.a;
        LazyRow.f(list.size(), (Function1) null, new c(b.a, list), t.c(802480018, true, new d(list, function0)));
        return Unit.INSTANCE;
    }

    public static final class d implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ Function0 b;

        public d(List list, Function0 function0) {
            this.a = list;
            this.b = function0;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(fVar)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i2 | i5;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 |= i4;
            }
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                fp4.c cVar2 = (fp4.c) this.a.get(i);
                composer.startReplaceGroup(744307423);
                Modifier.a aVar = Modifier.Companion;
                float f = 56;
                Modifier d = SizeKt.d(SizeKt.x(aVar, i.g(f)), 0.0f, 1, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changedInstance = composer.changedInstance(cVar2) | composer.changed(this.b);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(cVar2, this.b);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 a = x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.g(), composer, 48);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
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
                c0 c0Var = c0.b;
                Modifier a4 = androidx.compose.ui.draw.e.a(SizeKt.s(aVar, i.g(f)), k.g.c(i.g(28)));
                com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar3 = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
                Modifier d2 = BackgroundKt.d(a4, cVar3.b(composer, 6).m(), (f2) null, 2, (Object) null);
                p0 i6 = m.i(aVar2.e(), false);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, d2);
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
                g5.e(b3, i6, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                org.jetbrains.compose.resources.b bVar = cVar2.b;
                composer.startReplaceGroup(-2072277601);
                if (bVar == null) {
                    cVar = cVar3;
                } else {
                    cVar = cVar3;
                    z0.g(org.jetbrains.compose.resources.c.a(bVar, composer, 0), cVar2.a, SizeKt.s(aVar, i.g(32)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, cVar3.b(composer, 6).g(), 0, 2, (Object) null), 0, composer, 384, 184);
                }
                composer.endReplaceGroup();
                composer.endNode();
                a3.a(SizeKt.i(aVar, i.g(6)), composer, 6);
                a6.j(cVar2.a, (Modifier) null, cVar.b(composer, 6).q(), x0.x.h(12), (y) null, (androidx.compose.ui.text.font.c0) null, (j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 130546);
                composer.endNode();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final h hVar, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        long z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1278858595);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(hVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1278858595, i2, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.StoryMenuDialogContent (StoryMenuDialog.kt:137)");
            }
            LazyListState c2 = y0.c(0, 0, startRestartGroup, 0, 3);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changed = startRestartGroup.changed(c2) | startRestartGroup.changedInstance(hVar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new StoryMenuDialogKt$StoryMenuDialogContent$1$1(c2, hVar, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(c2, (Function2) rememberedValue, startRestartGroup, 0);
            Modifier.a aVar = Modifier.Companion;
            float f = 12;
            Modifier a2 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), hVar.a()), k.g.e(i.g(f), i.g(f), 0.0f, 0.0f, 12, (Object) null));
            com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
            if (cVar.a(startRestartGroup, 6) == 1) {
                startRestartGroup.startReplaceGroup(-622411167);
                z2 = cVar.b(startRestartGroup, 6).l();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-622409499);
                z2 = cVar.b(startRestartGroup, 6).z();
                startRestartGroup.endReplaceGroup();
            }
            Modifier d2 = BackgroundKt.d(a2, z2, (f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit i5;
                        i5 = StoryMenuDialogKt.i();
                        return i5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i5 = m.i(aVar2.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a4 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a4);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i5, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier f2 = SizeKt.f(aVar, 0.0f, 1, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            p0 a5 = x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, f2);
            Function0 a7 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, a5, companion2.c());
            g5.e(b4, currentCompositionLocalMap2, companion2.e());
            Function2 b5 = companion2.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                b4.updateRememberedValue(Integer.valueOf(a6));
                b4.apply(Integer.valueOf(a6), b5);
            }
            g5.e(b4, e2, companion2.d());
            c0 c0Var = c0.b;
            a3.a(SizeKt.i(aVar, i.g(24)), startRestartGroup, 6);
            Modifier i6 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), i.g(78));
            i2 h = androidx.compose.foundation.layout.f2.h(i.g(20), 0.0f, 2, (Object) null);
            float f3 = 16;
            e.f p = eVar.p(i.g(f3));
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance = startRestartGroup.changedInstance(hVar);
            int i7 = i2 & 112;
            if (i7 == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z5 = changedInstance | z3;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit g;
                        g = StoryMenuDialogKt.g(h.this, function0, (o0) obj);
                        return g;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            androidx.compose.foundation.lazy.d.e(i6, c2, h, false, p, (e.c) null, (l1) null, false, (y1) null, (Function1) rememberedValue3, startRestartGroup, 24966, 488);
            a3.a(SizeKt.i(aVar, i.g(f3)), startRestartGroup, 6);
            Modifier i8 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), i.g(54));
            startRestartGroup.startReplaceGroup(5004770);
            if (i7 == 32) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit f4;
                        f4 = StoryMenuDialogKt.f(Function0.this);
                        return f4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(i8, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null);
            p0 i9 = m.i(aVar2.e(), false);
            int a8 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, modifier2);
            Function0 a9 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a9);
            } else {
                startRestartGroup.useNode();
            }
            Composer b6 = g5.b(startRestartGroup);
            g5.e(b6, i9, companion2.c());
            g5.e(b6, currentCompositionLocalMap3, companion2.e());
            Function2 b7 = companion2.b();
            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a8))) {
                b6.updateRememberedValue(Integer.valueOf(a8));
                b6.apply(Integer.valueOf(a8), b7);
            }
            g5.e(b6, e3, companion2.d());
            composer2 = startRestartGroup;
            a6.j("取消", (Modifier) null, cVar.b(startRestartGroup, 6).g(), x0.x.h(16), (y) null, (androidx.compose.ui.text.font.c0) null, (j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3078, 0, 130546);
            composer2.endNode();
            composer2.endNode();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.menu.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h2;
                    h2 = StoryMenuDialogKt.h(h.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return h2;
                }
            });
        }
    }
}
