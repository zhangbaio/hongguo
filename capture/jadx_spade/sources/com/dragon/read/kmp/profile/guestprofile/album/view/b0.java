package com.dragon.read.kmp.profile.guestprofile.album.view;

import android.content.Context;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt;
import com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt;
import com.dragon.read.kmp.utils.k0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 {
    static {
        Covode.recordClassIndex(608131);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(jl4.b bVar, int i, int i2, Composer composer, int i3) {
        g(bVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(jl4.b bVar, int i, int i2, Composer composer, int i3) {
        g(bVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(String str, int i, boolean z, List list, float f, int i2, int i3, Composer composer, int i4) {
        o(str, i, z, list, f, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z) {
        n(aVar, zVar, i, z, true, null, 32, null);
        return Unit.INSTANCE;
    }

    public static final void g(final jl4.b itemModel, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        boolean z2;
        hl4.a aVar;
        boolean z3;
        int i4;
        hl4.a aVar2;
        final boolean z4;
        boolean z5;
        boolean z6;
        float f;
        String str;
        boolean z7;
        int i5;
        com.dragon.read.rpc.kmp.community.model.z zVar;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(123130069);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(itemModel)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(i)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(123130069, i3, -1, "com.dragon.read.kmp.profile.guestprofile.album.view.AlbumSingleItem (AlbumSingleItem.kt:52)");
            }
            final com.dragon.read.rpc.kmp.community.model.z zVar2 = itemModel.a;
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = Boolean.valueOf(il4.a.Companion.a().a);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            boolean booleanValue = ((Boolean) rememberedValue).booleanValue();
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = Boolean.valueOf(il4.a.Companion.a().c());
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            boolean booleanValue2 = ((Boolean) rememberedValue2).booleanValue();
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = Boolean.valueOf(il4.a.Companion.a().b());
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            boolean booleanValue3 = ((Boolean) rememberedValue3).booleanValue();
            startRestartGroup.endReplaceGroup();
            if (Intrinsics.areEqual(zVar2.j, Boolean.TRUE) && booleanValue) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object consume = startRestartGroup.consume(ProfileTabPagerKt.E());
            if (consume instanceof hl4.a) {
                aVar = (hl4.a) consume;
            } else {
                aVar = null;
            }
            if (aVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.v
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit j;
                            j = b0.j(jl4.b.this, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return j;
                        }
                    });
                    return;
                }
                return;
            }
            final Context a = ig4.f.a(startRestartGroup, 0);
            Modifier.a aVar3 = Modifier.Companion;
            Modifier t = f2.t(SizeKt.h(aVar3, 0.0f, 1, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changed = startRestartGroup.changed(aVar) | startRestartGroup.changedInstance(zVar2);
            int i8 = i3 & 112;
            if (i8 == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean changed2 = changed | z3 | startRestartGroup.changed(z2) | startRestartGroup.changedInstance(a);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed2 && rememberedValue4 != companion.getEmpty()) {
                i4 = i8;
                aVar2 = aVar;
                z4 = z2;
                z5 = booleanValue3;
            } else {
                i4 = i8;
                final hl4.a aVar4 = aVar;
                aVar2 = aVar;
                z4 = z2;
                z5 = booleanValue3;
                Function0 function0 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit k;
                        k = b0.k(hl4.a.this, zVar2, a, i, z4);
                        return k;
                    }
                };
                startRestartGroup.updateRememberedValue(function0);
                rememberedValue4 = function0;
            }
            startRestartGroup.endReplaceGroup();
            Modifier e = com.dragon.read.kmp.utils.g.e(t, false, 0L, null, null, (Function0) rememberedValue4, startRestartGroup, 6, 15);
            startRestartGroup.startReplaceGroup(-1224400529);
            final hl4.a aVar5 = aVar2;
            boolean changed3 = startRestartGroup.changed(aVar5) | startRestartGroup.changedInstance(zVar2);
            int i9 = i4;
            if (i9 == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            final boolean z8 = z4;
            boolean changed4 = changed3 | z6 | startRestartGroup.changed(z8);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed4 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit l;
                        l = b0.l(hl4.a.this, zVar2, i, z8);
                        return l;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            Modifier i0 = GuestProfileOneTabContentKt.i0(e, itemModel, (Function0) rememberedValue5);
            e.a aVar6 = androidx.compose.ui.e.a;
            e.c i10 = aVar6.i();
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            p0 b = r2.b(eVar.h(), i10, startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, i0);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a3 = companion2.a();
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
            g5.e(b2, b, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion2.d());
            w2 w2Var = w2.b;
            float f2 = 60;
            xs4.f f3 = og4.a.a.f(startRestartGroup, og4.a.b);
            if (f3 != null) {
                f = f3.b;
            } else {
                f = 1.0f;
            }
            float g = x0.i.g(f2 * f);
            float f4 = 8;
            Modifier b4 = AspectRatioKt.b(SizeKt.x(ig4.i.c(aVar3, x0.i.d(x0.i.g(f4)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), g), 0.71428573f, false, 2, (Object) null);
            p0 i11 = androidx.compose.foundation.layout.m.i(aVar6.o(), false);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, b4);
            Function0 a5 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a5);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, i11, companion2.c());
            g5.e(b5, currentCompositionLocalMap2, companion2.e());
            Function2 b6 = companion2.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                b5.updateRememberedValue(Integer.valueOf(a4));
                b5.apply(Integer.valueOf(a4), b6);
            }
            g5.e(b5, e3, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            String str2 = zVar2.d;
            if (str2 == null) {
                str2 = "";
            }
            f.e(g, 0.71428573f, str2, 0.0f, startRestartGroup, 48, 8);
            String str3 = aVar5.a.u;
            startRestartGroup.startReplaceGroup(412750323);
            if (Intrinsics.areEqual(str3, zVar2.a)) {
                bl4.m.m(boxScopeInstance, x0.x.h(12), startRestartGroup, 54, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            float f5 = 12;
            float g2 = x0.i.g(f5);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar3, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            Modifier a6 = u2.a(w2Var, aVar3, 1.0f, false, 2, (Object) null);
            p0 b7 = r2.b(eVar.h(), aVar6.i(), startRestartGroup, 54);
            int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e4 = ComposedModifierKt.e(startRestartGroup, a6);
            Function0 a8 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a8);
            } else {
                startRestartGroup.useNode();
            }
            Composer b8 = g5.b(startRestartGroup);
            g5.e(b8, b7, companion2.c());
            g5.e(b8, currentCompositionLocalMap3, companion2.e());
            Function2 b9 = companion2.b();
            if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a7))) {
                b8.updateRememberedValue(Integer.valueOf(a7));
                b8.apply(Integer.valueOf(a7), b9);
            }
            g5.e(b8, e4, companion2.d());
            String str4 = zVar2.b;
            if (str4 == null) {
                str = "";
            } else {
                str = str4;
            }
            o(str, 2, z8, f.g(zVar2, booleanValue2, z5), x0.i.g(f4), startRestartGroup, 24624, 0);
            startRestartGroup.endNode();
            float g3 = x0.i.g(f5);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar3, g3), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            String str5 = zVar2.a;
            if (str5 == null) {
                str5 = "";
            }
            final boolean f0 = aVar5.f0(str5);
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changed5 = startRestartGroup.changed(aVar5) | startRestartGroup.changedInstance(zVar2);
            if (i9 == 32) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean changed6 = changed5 | z7 | startRestartGroup.changed(z8) | startRestartGroup.changed(f0);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (!changed6 && rememberedValue6 != companion.getEmpty()) {
                composer2 = startRestartGroup;
                zVar = zVar2;
                i5 = 0;
            } else {
                composer2 = startRestartGroup;
                i5 = 0;
                zVar = zVar2;
                Function0 function02 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit h;
                        h = b0.h(f0, aVar5, zVar2, i, z8);
                        return h;
                    }
                };
                composer2.updateRememberedValue(function02);
                rememberedValue6 = function02;
            }
            composer2.endReplaceGroup();
            c.c(zVar, f0, (Function0) rememberedValue6, composer2, i5);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i12;
                    i12 = b0.i(jl4.b.this, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return i12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(boolean z, hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z2) {
        String str;
        if (z) {
            str = "cancel_favorite";
        } else {
            str = "favorite";
        }
        m(aVar, zVar, i, z2, false, str);
        kl4.a aVar2 = kl4.a.a;
        boolean z3 = !z;
        rl4.c cVar = aVar.a;
        String str2 = zVar.a;
        if (str2 == null) {
            str2 = "";
        }
        aVar2.a(z3, cVar, str2, "profile_horizontal_playlist_card", i + 1, Intrinsics.areEqual(zVar.j, Boolean.TRUE) ? 1 : 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, Context context, int i, boolean z) {
        m(aVar, zVar, i, z, false, "playlist_title");
        ym4.k g = k0.a.b().d("profile_user_id", aVar.a.i).d("position", "profile_horizontal_playlist_card").g(rl4.d.a(aVar.a));
        String str = zVar.a;
        if (str == null) {
            str = "";
        }
        com.dragon.read.kmp.u.l(str, g, context, (String) null, 8, (Object) null);
        return Unit.INSTANCE;
    }

    private static final void m(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z, boolean z2, String str) {
        kl4.a aVar2 = kl4.a.a;
        rl4.c cVar = aVar.a;
        String str2 = zVar.a;
        if (str2 == null) {
            str2 = "";
        }
        aVar2.b(z2, cVar, str2, "profile_horizontal_playlist_card", i + 1, z ? 1 : 0, str);
    }

    static /* synthetic */ void n(hl4.a aVar, com.dragon.read.rpc.kmp.community.model.z zVar, int i, boolean z, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            str = null;
        }
        m(aVar, zVar, i, z, z2, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final java.lang.String r36, int r37, final boolean r38, final java.util.List<com.bytedance.kmp.reading.model.e90> r39, final float r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 837
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.album.view.b0.o(java.lang.String, int, boolean, java.util.List, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
