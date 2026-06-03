package com.dragon.read.kmp.mine.preference.widget;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.x;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.dl;
import com.bytedance.kmp.reading.model.k00;
import com.dragon.read.component.biz.impl.mine.x6;
import com.dragon.read.component.biz.impl.mine.y6;
import com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import w0.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    static {
        Covode.recordClassIndex(607724);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(float f, int i, Composer composer, int i2) {
        b(f, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final void b(final float f, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        List list;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-2028346238);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(f)) {
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
                ComposerKt.traceEventStart(-2028346238, i2, -1, "com.dragon.read.kmp.mine.preference.widget.WatchPreferenceHeaderLayout (WatchPreferenceHeaderLayout.kt:24)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                WatchPreferenceViewModel watchPreferenceViewModel = (WatchPreferenceViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(WatchPreferenceViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier v = f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, f, 0.0f, 0.0f, 13, (Object) null);
                p0 a = x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 48);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                g5.e(b, a, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                c0 c0Var = c0.b;
                float g = x0.i.g(24);
                startRestartGroup.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(aVar, g), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                x6 x6Var = x6.a;
                String c2 = org.jetbrains.compose.resources.j.c(y6.t(x6Var), startRestartGroup, 0);
                h.a aVar2 = w0.h.b;
                int a4 = aVar2.a();
                long h = x0.x.h(20);
                c0.a aVar3 = androidx.compose.ui.text.font.c0.b;
                androidx.compose.ui.text.font.c0 i4 = aVar3.i();
                og4.a aVar4 = og4.a.a;
                int i5 = og4.a.b;
                a6.j(c2, (Modifier) null, aVar4.h(startRestartGroup, i5).k(), h, (y) null, i4, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a4), 0L, 0, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 3072, 122322);
                Modifier v2 = f2.v(aVar, 0.0f, x0.i.g(4), 0.0f, 0.0f, 13, (Object) null);
                composer2 = startRestartGroup;
                a6.j(org.jetbrains.compose.resources.j.c(y6.y(x6Var), composer2, 0), v2, aVar4.h(composer2, i5).h(), x0.x.h(12), (y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar2.a()), 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, 3120, 3072, 122352);
                float g2 = x0.i.g(36);
                composer2.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(aVar, g2), composer2, 0);
                composer2.endReplaceGroup();
                k00 k00Var = watchPreferenceViewModel.a.d;
                composer2.startReplaceGroup(-1133184720);
                if (k00Var != null) {
                    String str = k00Var.a;
                    if (str == null) {
                        str = "";
                    }
                    a6.j(str, (Modifier) null, aVar4.h(composer2, i5).k(), x0.x.h(16), (y) null, aVar3.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar2.a()), 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, 199680, 3072, 122322);
                    float g3 = x0.i.g(16);
                    composer2.startReplaceGroup(-1814856593);
                    a3.a(SizeKt.i(aVar, g3), composer2, 0);
                    composer2.endReplaceGroup();
                    List list2 = k00Var.b;
                    if (list2 != null) {
                        list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            String str2 = ((dl) it2.next()).a;
                            if (str2 == null) {
                                str2 = "";
                            }
                            list.add(str2);
                        }
                    } else {
                        list = null;
                    }
                    if (list == null) {
                        list = CollectionsKt__CollectionsKt.emptyList();
                    }
                    List list3 = k00Var.b;
                    if (list3 == null) {
                        list3 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    g.g(list, list3, composer2, 0);
                    float g4 = x0.i.g(15);
                    composer2.startReplaceGroup(-1814856593);
                    a3.a(SizeKt.i(Modifier.Companion, g4), composer2, 0);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
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
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.preference.widget.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c3;
                    c3 = i.c(f, i, (Composer) obj, ((Integer) obj2).intValue());
                    return c3;
                }
            });
        }
    }
}
