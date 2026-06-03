package bl4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt;
import com.dragon.read.rpc.kmp.community.model.r4;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    static {
        Covode.recordClassIndex(608047);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(androidx.compose.foundation.layout.r rVar, ll4.d dVar, int i, int i2, Composer composer, int i3) {
        e(rVar, dVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(androidx.compose.foundation.layout.r rVar, ll4.d dVar, int i, int i2, Composer composer, int i3) {
        g(rVar, dVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(androidx.compose.foundation.layout.r rVar, ll4.d dVar, int i, int i2, Composer composer, int i3) {
        k(rVar, dVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    private static final boolean i(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(tl4.l lVar, ll4.d dVar, int i) {
        lVar.v(dVar, i);
        return Unit.INSTANCE;
    }

    private static final void e(final androidx.compose.foundation.layout.r rVar, final ll4.d dVar, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        String stackTraceToString;
        long k;
        List listOf;
        String str;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1385575231);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i3 = i5 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(dVar)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1385575231, i3, -1, "com.dragon.read.kmp.profile.container.ReservationBottomMask (ReservationExtend.kt:87)");
            }
            try {
                r4 r4Var = dVar.h.m;
                com.dragon.read.kmp.utils.k kVar = com.dragon.read.kmp.utils.k.a;
                if (r4Var != null) {
                    str = r4Var.h;
                } else {
                    str = null;
                }
                k = com.dragon.read.kmp.utils.i.e(androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.k.g(kVar, str, null, 2, null)), null, 2, null);
            } catch (Exception e) {
                com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
                StringBuilder sb = new StringBuilder();
                sb.append("updateBottomMaskViewColor: ");
                sb.append(e.getMessage());
                sb.append(", stack: ");
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e);
                sb.append(stackTraceToString);
                com.dragon.read.kmp.j.c(jVar, "GuestProfileOneTabViewModel", sb.toString(), (Throwable) null, 4, (Object) null);
                k = l0.a.k(androidx.compose.ui.graphics.l0.b, 0.0f, 0.0f, 0.9f, 0.0f, (Rgb) null, 24, (Object) null);
            }
            Modifier i6 = SizeKt.i(SizeKt.h(rVar.b(Modifier.Companion, androidx.compose.ui.e.a.b()), 0.0f, 1, (Object) null), x0.i.g(60));
            c0.a aVar = androidx.compose.ui.graphics.c0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(k, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(k, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(k, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))});
            androidx.compose.foundation.layout.m.b(BackgroundKt.b(i6, c0.a.p(aVar, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (f2) null, 0.0f, 6, (Object) null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bl4.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = r.f(rVar, dVar, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }

    public static final void k(final androidx.compose.foundation.layout.r rVar, final ll4.d itemModel, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        androidx.compose.foundation.layout.r rVar2;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(77515940);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(itemModel)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        int i8 = i3;
        if ((i8 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i8 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(77515940, i8, -1, "com.dragon.read.kmp.profile.container.ReservationExtend (ReservationExtend.kt:41)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier a = rVar.a(aVar);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i9 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a);
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
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i9, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            androidx.compose.foundation.layout.r rVar3 = BoxScopeInstance.a;
            startRestartGroup.startReplaceGroup(1102908019);
            r4 r4Var = itemModel.h.m;
            if (r4Var != null) {
                z2 = Intrinsics.areEqual(r4Var.n, Boolean.TRUE);
            } else {
                z2 = false;
            }
            if (z2) {
                Painter b3 = org.jetbrains.compose.resources.c.b(b4.O(d4.a), startRestartGroup, 0);
                Modifier s = SizeKt.s(rVar3.b(aVar, aVar2.e()), x0.i.g(24));
                rVar2 = rVar3;
                i4 = i8;
                z0.c(b3, (String) null, s, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, startRestartGroup, 48, 120);
            } else {
                rVar2 = rVar3;
                i4 = i8;
            }
            startRestartGroup.endReplaceGroup();
            int i10 = (i4 & 112) | 6;
            int i11 = (i4 & 896) | i10;
            e(rVar2, itemModel, i, startRestartGroup, i11);
            m.j(rVar2, itemModel, startRestartGroup, i10);
            g(rVar2, itemModel, i, startRestartGroup, i11);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bl4.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = r.l(rVar, itemModel, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    private static final void g(final androidx.compose.foundation.layout.r rVar, final ll4.d dVar, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        boolean z2;
        String str;
        long r;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-536877892);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(dVar)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-536877892, i3, -1, "com.dragon.read.kmp.profile.container.ReservationButton (ReservationExtend.kt:59)");
            }
            final tl4.l lVar = (tl4.l) startRestartGroup.consume(ProfileTabPagerKt.E());
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e e = aVar.e();
            Modifier b = rVar.b(Modifier.Companion, aVar.b());
            float f = 8;
            Modifier c = ig4.i.c(SizeKt.h(androidx.compose.foundation.layout.f2.v(b, x0.i.g(f), 0.0f, x0.i.g(f), x0.i.g(f), 2, (Object) null), 0.0f, 1, (Object) null), x0.i.d(x0.i.g(f)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
            og4.a aVar2 = og4.a.a;
            Modifier d = BackgroundKt.d(c, aVar2.d().I(), (f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed = startRestartGroup.changed(lVar) | startRestartGroup.changedInstance(dVar);
            if ((i3 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3 = z2 | changed;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: bl4.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit h;
                        h = r.h(tl4.l.this, dVar, i);
                        return h;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier v = androidx.compose.foundation.layout.f2.v(ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), 0.0f, x0.i.g(f), 0.0f, x0.i.g(f), 5, (Object) null);
            p0 i7 = androidx.compose.foundation.layout.m.i(e, false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, v);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i7, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                b2.updateRememberedValue(Integer.valueOf(a));
                b2.apply(Integer.valueOf(a), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            MutableState<Boolean> R = dVar.R();
            if (i(R)) {
                str = "已预约";
            } else {
                str = "立即预约";
            }
            if (i(R)) {
                r = n0.d(2164260863L);
            } else {
                r = aVar2.d().r();
            }
            composer2 = startRestartGroup;
            a6.j(str, (Modifier) null, r, x0.x.h(12), (androidx.compose.ui.text.font.y) null, new androidx.compose.ui.text.font.c0(500), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199680, 3120, 120786);
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
            endRestartGroup.a(new Function2() { // from class: bl4.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = r.j(rVar, dVar, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }
}
