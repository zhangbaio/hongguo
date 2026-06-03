package com.dragon.read.kmp.story.impl.feeds.page.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.k0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w0.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    static {
        Covode.recordClassIndex(609328);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, float f, float f2, float f3, Modifier modifier, int i, int i2, Composer composer, int i3) {
        d(str, f, f2, f3, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(np4.d dVar, kp4.b bVar, int i, Composer composer, int i2) {
        f(dVar, bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(kp4.b bVar) {
        String str;
        ym4.a aVar = new ym4.a();
        aVar.g("post_position", "bookcard");
        bVar.f.a.p(aVar);
        ym4.k d = k0.a.b().d("post_position", "bookcard");
        String bookId = bVar.d().getBookId();
        String str2 = bVar.d().d;
        String str3 = bVar.d().m;
        Integer genreType = bVar.d().getGenreType();
        if (genreType != null) {
            str = genreType.toString();
        } else {
            str = null;
        }
        i(bookId, str2, str3, str, d);
        return Unit.INSTANCE;
    }

    public static final void f(final np4.d page, final kp4.b story, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        String str;
        String joinToString$default;
        boolean z2;
        com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar;
        Composer composer3;
        androidx.compose.foundation.layout.e eVar;
        Modifier modifier;
        boolean z3;
        Composer composer4;
        com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar2;
        List listOf;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(story, "story");
        Composer startRestartGroup = composer.startRestartGroup(1497143705);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(page)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(story)) {
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
                ComposerKt.traceEventStart(1497143705, i2, -1, "com.dragon.read.kmp.story.impl.feeds.page.view.KmpBookCardPageView (KmpBookCardPageView.kt:40)");
            }
            String str2 = page.d;
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit g;
                        g = w.g(kp4.b.this);
                        return g;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            String str3 = page.e;
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            page.e();
            List<String> e = page.e();
            if (e.isEmpty()) {
                joinToString$default = "";
            } else {
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(e, "·", null, null, 0, null, null, 62, null);
            }
            Modifier modifier2 = Modifier.Companion;
            float f = 16;
            Modifier u = f2.u(SizeKt.h(modifier2, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(0), x0.i.g(f), x0.i.g(f));
            e.a aVar = androidx.compose.ui.e.a;
            p0 i5 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, u);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i5, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier a3 = androidx.compose.ui.draw.e.a(SizeKt.h(modifier2, 0.0f, 1, (Object) null), k.g.c(x0.i.g(8)));
            com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar3 = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
            float f2 = 12;
            Modifier r = f2.r(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.d(a3, cVar3.b(startRestartGroup, 6).o(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function0, 15, (Object) null), x0.i.g(f2));
            e.c i6 = aVar.i();
            androidx.compose.foundation.layout.e eVar2 = androidx.compose.foundation.layout.e.a;
            p0 b3 = r2.b(eVar2.h(), i6, startRestartGroup, 48);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, r);
            Function0 a5 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a5);
            } else {
                startRestartGroup.useNode();
            }
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, b3, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                b4.updateRememberedValue(Integer.valueOf(a4));
                b4.apply(Integer.valueOf(a4), b5);
            }
            g5.e(b4, e3, companion.d());
            w2 w2Var = w2.b;
            float f3 = 36;
            float f4 = 50;
            Modifier u2 = SizeKt.u(modifier2, x0.i.g(f3), x0.i.g(f4));
            p0 i7 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e4 = ComposedModifierKt.e(startRestartGroup, u2);
            Function0 a7 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b6 = g5.b(startRestartGroup);
            g5.e(b6, i7, companion.c());
            g5.e(b6, currentCompositionLocalMap3, companion.e());
            Function2 b7 = companion.b();
            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a6))) {
                b6.updateRememberedValue(Integer.valueOf(a6));
                b6.apply(Integer.valueOf(a6), b7);
            }
            g5.e(b6, e4, companion.d());
            float f5 = 4;
            d(page.f, x0.i.g(f3), x0.i.g(f4), x0.i.g(f5), null, startRestartGroup, 3504, 16);
            startRestartGroup.startReplaceGroup(474271825);
            if (page.d().length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                c0.a aVar2 = androidx.compose.ui.graphics.c0.b;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(l0.b.g()), l0.j(cVar3.b(startRestartGroup, 6).A())});
                Modifier b8 = BackgroundKt.b(SizeKt.h(boxScopeInstance.b(modifier2, aVar.b()), 0.0f, 1, (Object) null), c0.a.p(aVar2, listOf, 0.0f, 0.0f, 0, 14, (Object) null), k.g.e(0.0f, 0.0f, x0.i.g(f5), x0.i.g(f5), 3, (Object) null), 0.0f, 4, (Object) null);
                p0 i8 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
                int a8 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e5 = ComposedModifierKt.e(startRestartGroup, b8);
                Function0 a9 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a9);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b9 = g5.b(startRestartGroup);
                g5.e(b9, i8, companion.c());
                g5.e(b9, currentCompositionLocalMap4, companion.e());
                Function2 b10 = companion.b();
                if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a8))) {
                    b9.updateRememberedValue(Integer.valueOf(a8));
                    b9.apply(Integer.valueOf(a8), b10);
                }
                g5.e(b9, e5, companion.d());
                modifier = modifier2;
                cVar = cVar3;
                eVar = eVar2;
                composer3 = startRestartGroup;
                a6.j(page.d(), f2.v(boxScopeInstance.b(modifier2, aVar.d()), x0.i.g(f5), 0.0f, 0.0f, x0.i.g(2), 6, (Object) null), cVar3.b(startRestartGroup, 6).r(), x0.x.h(9), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer3, 199680, 0, 131024);
                composer3.endNode();
            } else {
                cVar = cVar3;
                composer3 = startRestartGroup;
                eVar = eVar2;
                modifier = modifier2;
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            Modifier modifier3 = modifier;
            Composer composer5 = composer3;
            a3.a(SizeKt.x(modifier3, x0.i.g(f2)), composer5, 6);
            Modifier a10 = u2.a(w2Var, modifier3, 1.0f, false, 2, (Object) null);
            p0 a11 = androidx.compose.foundation.layout.x.a(eVar.p(x0.i.g(f5)), aVar.k(), composer5, 6);
            int a12 = j.a(androidx.compose.runtime.i.b(composer5, 0));
            e0 currentCompositionLocalMap5 = composer5.getCurrentCompositionLocalMap();
            Modifier e6 = ComposedModifierKt.e(composer5, a10);
            Function0 a13 = companion.a();
            if (!(composer5.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer5.startReusableNode();
            if (composer5.getInserting()) {
                composer5.createNode(a13);
            } else {
                composer5.useNode();
            }
            Composer b11 = g5.b(composer5);
            g5.e(b11, a11, companion.c());
            g5.e(b11, currentCompositionLocalMap5, companion.e());
            Function2 b12 = companion.b();
            if (b11.getInserting() || !Intrinsics.areEqual(b11.rememberedValue(), Integer.valueOf(a12))) {
                b11.updateRememberedValue(Integer.valueOf(a12));
                b11.apply(Integer.valueOf(a12), b12);
            }
            g5.e(b11, e6, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar4 = cVar;
            long g = cVar4.b(composer5, 6).g();
            long h = x0.x.h(14);
            c0.a aVar3 = androidx.compose.ui.text.font.c0.b;
            androidx.compose.ui.text.font.c0 d = aVar3.d();
            s.a aVar4 = w0.s.b;
            a6.j(str, (Modifier) null, g, h, (androidx.compose.ui.text.font.y) null, d, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, composer5, 199680, 3120, 120786);
            composer5.startReplaceGroup(-1789146089);
            if (joinToString$default.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                composer4 = composer5;
                cVar2 = cVar4;
                a6.j(joinToString$default, (Modifier) null, cVar4.b(composer5, 6).N(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, composer4, 3072, 3120, 120818);
            } else {
                composer4 = composer5;
                cVar2 = cVar4;
            }
            composer4.endReplaceGroup();
            composer4.endNode();
            Modifier x = SizeKt.x(modifier3, x0.i.g(f));
            Composer composer6 = composer4;
            a3.a(x, composer6, 6);
            com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar5 = cVar2;
            composer2 = composer6;
            a6.j("继续阅读", f2.s(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.d(androidx.compose.ui.draw.e.a(modifier3, k.g.c(x0.i.g(24))), cVar5.b(composer6, 6).Q(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function0, 15, (Object) null), x0.i.g(f2), x0.i.g(6)), cVar5.b(composer6, 6).f(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar3.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 131024);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.page.view.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h2;
                    h2 = w.h(np4.d.this, story, i, (Composer) obj, ((Integer) obj2).intValue());
                    return h2;
                }
            });
        }
    }

    public static final void i(String str, String str2, String str3, String str4, ym4.k kVar) {
        com.dragon.read.kmp.reader.utils.o oVar = new com.dragon.read.kmp.reader.utils.o(ig4.f.b(), str, str2, str3);
        oVar.f(str4);
        oVar.c(true);
        oVar.h(false);
        if (kVar != null) {
            oVar.i(kVar);
        }
        oVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void d(final java.lang.String r17, final float r18, final float r19, final float r20, androidx.compose.ui.Modifier r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.page.view.w.d(java.lang.String, float, float, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
