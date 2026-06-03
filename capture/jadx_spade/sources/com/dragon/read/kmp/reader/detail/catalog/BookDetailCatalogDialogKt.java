package com.dragon.read.kmp.reader.detail.catalog;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.t3;
import com.dragon.read.kmp.reader.detail.p2;
import com.dragon.read.kmp.reader.detail.r2;
import com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel;
import com.dragon.read.kmp.widget.CommonLayoutKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import x0.x;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookDetailCatalogDialogKt {
    static {
        Covode.recordClassIndex(608379);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(t3 t3Var, s sVar, String str, float f, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        k(t3Var, sVar, str, f, function0, function02, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(a aVar, Function0 function0, int i, Composer composer, int i2) {
        o(aVar, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(String str, int i, Composer composer, int i2) {
        r(str, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(String str, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        t(str, function0, function02, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(a aVar, int i, Composer composer, int i2) {
        x(aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, s sVar, Function0 function0) {
        String str2;
        Map mapOf;
        ym4.o oVar = ym4.o.a;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("book_id", str);
        if (sVar.b) {
            str2 = "desc_order";
        } else {
            str2 = "asc_order";
        }
        pairArr[1] = TuplesKt.to("clicked_content", str2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        oVar.d("click_novel_page", new ym4.a((Map<String, ? extends Object>) mapOf));
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final String str, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(826551345);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        boolean z2 = true;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(826551345, i2, -1, "com.dragon.read.kmp.reader.detail.catalog.FixedSubTitle (BookDetailCatalogDialog.kt:250)");
            }
            Modifier t = f2.t(SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(50)), x0.i.g(20), 0.0f, 2, (Object) null);
            p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.h(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, t);
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
            g5.e(b, i4, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            startRestartGroup.startReplaceGroup(-474110864);
            if (str.length() <= 0) {
                z2 = false;
            }
            if (z2) {
                composer2 = startRestartGroup;
                a6.j(str, (Modifier) null, og4.a.a.c().b(startRestartGroup, og4.a.b).h(), x.h(15), (y) null, c0.b.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, (i2 & 14) | 199680, 3120, 120786);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.catalog.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit s;
                    s = BookDetailCatalogDialogKt.s(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    return s;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final a aVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1635057224);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(aVar)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1635057224, i2, -1, "com.dragon.read.kmp.reader.detail.catalog.VolumeRow (BookDetailCatalogDialog.kt:275)");
            }
            Modifier.a aVar2 = Modifier.Companion;
            Modifier h = SizeKt.h(aVar2, 0.0f, 1, (Object) null);
            og4.a aVar3 = og4.a.a;
            og4.a c = aVar3.c();
            int i4 = og4.a.b;
            Modifier t = f2.t(BackgroundKt.d(h, c.b(startRestartGroup, i4).z(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(20), 0.0f, 2, (Object) null);
            p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, t);
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
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            composer2 = startRestartGroup;
            a6.j(aVar.c, f2.t(aVar2, 0.0f, x0.i.g(12), 1, (Object) null), aVar3.c().b(startRestartGroup, i4).h(), x.h(13), (y) null, c0.b.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 2, 0, (Function1) null, (g3) null, composer2, 199728, 3120, 120784);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.catalog.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y;
                    y = BookDetailCatalogDialogKt.y(a.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return y;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(BookDetailViewModel bookDetailViewModel, String str, Function1 resolve, Function1 reject) {
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        bookDetailViewModel.O0(str, resolve, reject);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final com.dragon.read.kmp.reader.detail.catalog.a r44, final kotlin.jvm.functions.Function0<kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47) {
        /*
            Method dump skipped, instructions count: 841
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.catalog.BookDetailCatalogDialogKt.o(com.dragon.read.kmp.reader.detail.catalog.a, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    private static final void t(final String str, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1677308662);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        int i6 = i2;
        if ((i6 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1677308662, i6, -1, "com.dragon.read.kmp.reader.detail.catalog.Header (BookDetailCatalogDialog.kt:206)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier i7 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(64));
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, i7);
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
            g5.e(b, i8, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            float f = 20;
            Modifier b3 = boxScopeInstance.b(SizeKt.s(f2.v(aVar, x0.i.g(f), 0.0f, 0.0f, 0.0f, 14, (Object) null), x0.i.g(24)), aVar2.h());
            startRestartGroup.startReplaceGroup(5004770);
            if ((i6 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.catalog.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit u;
                        u = BookDetailCatalogDialogKt.u(Function0.this);
                        return u;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(b3, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            e1 a3 = org.jetbrains.compose.resources.c.a(d2.f(f2.a.a), startRestartGroup, 0);
            m0.a aVar3 = m0.b;
            og4.a aVar4 = og4.a.a;
            og4.a c = aVar4.c();
            int i9 = og4.a.b;
            z0.g(a3, (String) null, modifier, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar3, c.b(startRestartGroup, i9).F3(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
            Modifier b4 = boxScopeInstance.b(aVar, aVar2.e());
            long F3 = aVar4.c().b(startRestartGroup, i9).F3();
            long h = x.h(18);
            c0.a aVar5 = c0.b;
            a6.j("目录", b4, F3, h, (y) null, aVar5.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 3120, 120784);
            Modifier v = androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(aVar, aVar2.f()), 0.0f, 0.0f, x0.i.g(f), 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i6 & 896) == 256) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.detail.catalog.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit v2;
                        v2 = BookDetailCatalogDialogKt.v(Function0.this);
                        return v2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j(str, ClickableKt.clickable-oSLSa3U$default(v, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), aVar4.c().b(startRestartGroup, i9).F3(), x.h(14), (y) null, aVar5.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, (i6 & 14) | 199680, 0, 131024);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.catalog.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w;
                    w = BookDetailCatalogDialogKt.w(str, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                    return w;
                }
            });
        }
    }

    public static final void k(final t3 bookInfo, final s state, final String subTitle, final float f, final Function0<Unit> onDismissRequest, final Function0<Unit> onToggleOrder, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        String str;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(bookInfo, "bookInfo");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(onToggleOrder, "onToggleOrder");
        Composer startRestartGroup = composer.startRestartGroup(-203447536);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(bookInfo)) {
                i8 = 4;
            } else {
                i8 = 2;
            }
            i2 = i8 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(state)) {
                i7 = 32;
            } else {
                i7 = 16;
            }
            i2 |= i7;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(subTitle)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i2 |= i6;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(f)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i2 |= i5;
        }
        if ((i & 24576) == 0) {
            if (startRestartGroup.changedInstance(onDismissRequest)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i2 |= i4;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changedInstance(onToggleOrder)) {
                i3 = 131072;
            } else {
                i3 = 65536;
            }
            i2 |= i3;
        }
        if ((74899 & i2) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-203447536, i2, -1, "com.dragon.read.kmp.reader.detail.catalog.BookDetailCatalogSheetContent (BookDetailCatalogDialog.kt:77)");
            }
            BookDetailViewModel.a aVar = new BookDetailViewModel.a();
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final BookDetailViewModel bookDetailViewModel = (BookDetailViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(BookDetailViewModel.class), c, (String) null, aVar, creationExtras, startRestartGroup, 0, 0);
                String str2 = bookInfo.e;
                if (str2 == null) {
                    str2 = "";
                }
                final String str3 = str2;
                p2 p2Var = (p2) startRestartGroup.consume(r2.c());
                Modifier.a aVar2 = Modifier.Companion;
                float f2 = 16;
                Modifier a = androidx.compose.ui.draw.e.a(SizeKt.h(SizeKt.i(aVar2, f), 0.0f, 1, (Object) null), k.g.e(x0.i.g(f2), x0.i.g(f2), 0.0f, 0.0f, 12, (Object) null));
                og4.a aVar3 = og4.a.a;
                og4.a c2 = aVar3.c();
                int i9 = og4.a.b;
                Modifier d = BackgroundKt.d(a, c2.b(startRestartGroup, i9).z(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, d);
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
                g5.e(b, a2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                    b.updateRememberedValue(Integer.valueOf(a3));
                    b.apply(Integer.valueOf(a3), b2);
                }
                g5.e(b, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                if (state.b) {
                    str = "倒序";
                } else {
                    str = "正序";
                }
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changed = startRestartGroup.changed(str3) | startRestartGroup.changedInstance(state);
                if ((458752 & i2) == 131072) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z3 = changed | z2;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.catalog.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit l;
                            l = BookDetailCatalogDialogKt.l(str3, state, onToggleOrder);
                            return l;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                t(str, onDismissRequest, (Function0) rememberedValue, startRestartGroup, (i2 >> 9) & 112);
                androidx.compose.material.p0.b(SizeKt.i(aVar2, x0.i.g(0.5f)), aVar3.c().h(startRestartGroup, i9).p2(), 0.0f, 0.0f, startRestartGroup, 6, 12);
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(bookDetailViewModel) | startRestartGroup.changed(str3);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function2() { // from class: com.dragon.read.kmp.reader.detail.catalog.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit m;
                            m = BookDetailCatalogDialogKt.m(BookDetailViewModel.this, str3, (Function1) obj, (Function1) obj2);
                            return m;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                t tVar = t.a;
                composer2 = startRestartGroup;
                CommonLayoutKt.i((Function2) rememberedValue2, null, null, tVar.c(), null, tVar.a(), androidx.compose.runtime.internal.t.e(1482895813, true, new BookDetailCatalogDialogKt$BookDetailCatalogSheetContent$1$3(str3, state, subTitle, p2Var, bookInfo), composer2, 54), composer2, 1772544, 22);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        androidx.compose.runtime.t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.catalog.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = BookDetailCatalogDialogKt.n(bookInfo, state, subTitle, f, onDismissRequest, onToggleOrder, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }
}
