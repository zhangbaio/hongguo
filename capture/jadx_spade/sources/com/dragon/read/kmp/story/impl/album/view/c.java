package com.dragon.read.kmp.story.impl.album.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.font.z;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.l0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.us;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w0.p;
import w0.q;
import w0.r;
import w0.s;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(609218);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(com.dragon.read.kmp.story.impl.album.c cVar, com.dragon.read.kmp.story.impl.album.a aVar, com.dragon.read.kmp.story.impl.album.viewmodel.a aVar2, int i, Composer composer, int i2) {
        b(cVar, aVar, aVar2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function3<us, Composer, Integer, Unit> {
        final /* synthetic */ pp4.d a;

        a(pp4.d dVar) {
            this.a = dVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(us usVar, Composer composer, Integer num) {
            a(usVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(us tagInfo, Composer composer, int i) {
            long o;
            Intrinsics.checkNotNullParameter(tagInfo, "tagInfo");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(247598817, i, -1, "com.dragon.read.kmp.story.impl.album.view.StoryAlbumDetailView.<anonymous>.<anonymous>.<anonymous> (StoryAlbumDetailView.kt:70)");
            }
            boolean areEqual = Intrinsics.areEqual(tagInfo.c, Boolean.TRUE);
            Modifier i2 = SizeKt.i(Modifier.Companion, x0.i.g(18));
            pp4.d dVar = this.a;
            if (areEqual) {
                o = dVar.n();
            } else {
                o = dVar.o();
            }
            float f = 4;
            Modifier t = f2.t(BackgroundKt.c(i2, o, k.g.c(x0.i.g(f))), x0.i.g(f), 0.0f, 2, (Object) null);
            androidx.compose.ui.e e = androidx.compose.ui.e.a.e();
            pp4.d dVar2 = this.a;
            p0 i3 = m.i(e, false);
            int a = j.a(androidx.compose.runtime.i.b(composer, 0));
            e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(composer, t);
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
            String str = tagInfo.a;
            if (str == null) {
                str = "";
            }
            a6.j(str, (Modifier) null, 0L, 0L, (y) null, (c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, 0L, s.b.b(), false, 1, 0, (Function1) null, c.e(dVar2, areEqual, composer, 0, 0), composer, 0, 3120, 55294);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g3 e(pp4.d dVar, boolean z, Composer composer, int i, int i2) {
        boolean z2;
        long j;
        composer.startReplaceGroup(1961072396);
        if ((i2 & 2) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1961072396, i, -1, "com.dragon.read.kmp.story.impl.album.view.tagTextStyle (StoryAlbumDetailView.kt:101)");
        }
        if (z2) {
            j = dVar.u();
        } else {
            j = dVar.j();
        }
        g3 g3Var = new g3(j, x.h(12), (c0) null, (y) null, (z) null, (j) null, (String) null, 0L, (w0.a) null, (p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, x.h(16), (q) null, (l0) null, (w0.g) null, 0, 0, (r) null, 16646140, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return g3Var;
    }

    public static final void b(final com.dragon.read.kmp.story.impl.album.c albumData, final com.dragon.read.kmp.story.impl.album.a depend, final com.dragon.read.kmp.story.impl.album.viewmodel.a feedListState, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        Composer composer3;
        Modifier modifier;
        boolean z3;
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(albumData, "albumData");
        Intrinsics.checkNotNullParameter(depend, "depend");
        Intrinsics.checkNotNullParameter(feedListState, "feedListState");
        Composer startRestartGroup = composer.startRestartGroup(2102473047);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(albumData)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(feedListState)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i2 |= i5;
        }
        if ((i2 & 131) != 130) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2102473047, i2, -1, "com.dragon.read.kmp.story.impl.album.view.StoryAlbumDetailView (StoryAlbumDetailView.kt:34)");
            }
            pp4.d a2 = pp4.e.a(feedListState.h);
            Modifier modifier3 = Modifier.Companion;
            Modifier h = SizeKt.h(modifier3, 0.0f, 1, (Object) null);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i7 = m.i(aVar.m(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, h);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a4 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a4);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i7, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                b.updateRememberedValue(Integer.valueOf(a3));
                b.apply(Integer.valueOf(a3), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier h2 = SizeKt.h(modifier3, 0.0f, 1, (Object) null);
            p0 a5 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar.k(), startRestartGroup, 0);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, h2);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, a5, companion.c());
            g5.e(b3, currentCompositionLocalMap2, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a6))) {
                b3.updateRememberedValue(Integer.valueOf(a6));
                b3.apply(Integer.valueOf(a6), b4);
            }
            g5.e(b3, e2, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            a3.a(SizeKt.i(modifier3, x0.i.g(24)), startRestartGroup, 6);
            String str = albumData.c;
            if (str == null) {
                str = "合集";
            }
            a6.j(str, (Modifier) null, a2.k(), x.h(20), (y) null, c0.b.a(), (j) null, 0L, (w0.i) null, (w0.h) null, x.h(24), 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 6, 130002);
            String str2 = albumData.a;
            startRestartGroup.startReplaceGroup(2048886494);
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                a3.a(SizeKt.i(modifier3, x0.i.g(12)), startRestartGroup, 6);
                modifier = modifier3;
                composer3 = startRestartGroup;
                a6.j(str2, (Modifier) null, a2.j(), x.h(14), (y) null, (c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer3, 3072, 0, 131058);
            } else {
                composer3 = startRestartGroup;
                modifier = modifier3;
            }
            composer3.endReplaceGroup();
            List<us> list = albumData.d;
            composer2 = composer3;
            composer2.startReplaceGroup(2048899039);
            if (list != null && !list.isEmpty()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
                i3 = 12;
                modifier2 = modifier;
                i4 = 6;
                a3.a(SizeKt.i(modifier2, x0.i.g(12)), composer2, 6);
                com.dragon.read.kmp.story.impl.widget.h.d(SizeKt.h(modifier2, 0.0f, 1, (Object) null), list, t.e(247598817, true, new a(a2), composer2, 54), com.dragon.read.kmp.story.impl.album.view.a.a.a(), composer2, 3462);
            } else {
                modifier2 = modifier;
                i3 = 12;
                i4 = 6;
            }
            composer2.endReplaceGroup();
            a3.a(SizeKt.i(modifier2, x0.i.g(i3)), composer2, i4);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.album.view.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = c.c(com.dragon.read.kmp.story.impl.album.c.this, depend, feedListState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
