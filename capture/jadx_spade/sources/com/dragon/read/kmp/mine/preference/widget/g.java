package com.dragon.read.kmp.mine.preference.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.v2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.lazy.y0;
import androidx.compose.foundation.y1;
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
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.i00;
import com.bytedance.kmp.reading.model.j00;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel;
import com.dragon.read.kmp.service.b1;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    private static final int a;

    public static final class a implements Function1 {
        public static final a a = new a();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(j00 j00Var) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(List list, List list2, int i, Composer composer, int i2) {
        g(list, list2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(v2 v2Var, String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        j(v2Var, str, z, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(CollapsibleListState collapsibleListState, int i, Composer composer, int i2) {
        m(collapsibleListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(607723);
        a = b1.a.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final class b implements Function1<Integer, Object> {
        final /* synthetic */ Function1 a;
        final /* synthetic */ List b;

        public b(Function1 function1, List list) {
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
    public static final Unit h(WatchPreferenceViewModel watchPreferenceViewModel, Object obj) {
        watchPreferenceViewModel.X0(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(WatchPreferenceViewModel watchPreferenceViewModel, o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        List<j00> list = watchPreferenceViewModel.a.e;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        LazyColumn.f(list.size(), (Function1) null, new b(a.a, list), t.c(802480018, true, new c(list, list)));
        return Unit.INSTANCE;
    }

    public static final void m(final CollapsibleListState collapsingState, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
        Composer startRestartGroup = composer.startRestartGroup(-943038135);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(collapsingState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsingState);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(-943038135, i2, -1, "com.dragon.read.kmp.mine.preference.widget.WatchPreferenceContentLayout (WatchPreferenceContentLayout.kt:37)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final WatchPreferenceViewModel watchPreferenceViewModel = (WatchPreferenceViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(WatchPreferenceViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                LazyListState c3 = y0.c(0, 0, startRestartGroup, 0, 3);
                CollapsibleListState.r(collapsingState, new int[]{0}, c3, (LazyGridState) null, (LazyStaggeredGridState) null, 12, (Object) null);
                Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance2 = startRestartGroup.changedInstance(watchPreferenceViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.mine.preference.widget.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit n;
                            n = g.n(WatchPreferenceViewModel.this, (o0) obj);
                            return n;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                androidx.compose.foundation.lazy.d.c(h, c3, (i2) null, false, (e.m) null, (e.b) null, (l1) null, false, (y1) null, (Function1) rememberedValue, composer2, 6, 508);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.preference.widget.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = g.o(collapsingState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    public static final class c implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ List b;

        public c(List list, List list2) {
            this.a = list;
            this.b = list2;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            float f;
            String str;
            List list;
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
                j00 j00Var = (j00) this.a.get(i);
                composer.startReplaceGroup(-343230912);
                if (this.b.indexOf(j00Var) == 0) {
                    f = 7;
                } else {
                    f = 10;
                }
                float g = x0.i.g(f);
                composer.startReplaceGroup(-1814856593);
                Modifier.a aVar = Modifier.Companion;
                a3.a(SizeKt.i(aVar, g), composer, 0);
                composer.endReplaceGroup();
                String str2 = j00Var.a;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                a6.j(str, (Modifier) null, og4.a.a.h(composer, og4.a.b).h(), x.h(12), (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 130546);
                float g2 = x0.i.g(10);
                composer.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(aVar, g2), composer, 0);
                composer.endReplaceGroup();
                List list2 = j00Var.d;
                if (list2 != null) {
                    list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        String str3 = ((i00) it2.next()).b;
                        if (str3 == null) {
                            str3 = "";
                        }
                        list.add(str3);
                    }
                } else {
                    list = null;
                }
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                List list3 = j00Var.d;
                if (list3 == null) {
                    list3 = CollectionsKt__CollectionsKt.emptyList();
                }
                g.g(list, list3, composer, 0);
                composer.startReplaceGroup(-11056930);
                if (this.b.indexOf(j00Var) == this.b.size() - 1) {
                    float g3 = x0.i.g(64);
                    composer.startReplaceGroup(-1814856593);
                    a3.a(SizeKt.i(Modifier.Companion, g3), composer, 0);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
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

    public static final <T> void g(final List<String> contentList, final List<? extends T> preferenceData, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        List chunked;
        List chunked2;
        String str;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(contentList, "contentList");
        Intrinsics.checkNotNullParameter(preferenceData, "preferenceData");
        Composer startRestartGroup = composer.startRestartGroup(22061295);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(contentList)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(preferenceData)) {
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
                ComposerKt.traceEventStart(22061295, i2, -1, "com.dragon.read.kmp.mine.preference.widget.PreferenceContentGridLayout (WatchPreferenceContentLayout.kt:62)");
            }
            int i5 = 6;
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final WatchPreferenceViewModel watchPreferenceViewModel = (WatchPreferenceViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(WatchPreferenceViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                float f = 0.0f;
                Object obj = null;
                Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
                p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
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
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, a2, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                    b2.updateRememberedValue(Integer.valueOf(a3));
                    b2.apply(Integer.valueOf(a3), b3);
                }
                g5.e(b2, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                int i6 = a;
                chunked = CollectionsKt___CollectionsKt.chunked(preferenceData, i6);
                chunked2 = CollectionsKt___CollectionsKt.chunked(contentList, i6);
                startRestartGroup.startReplaceGroup(-738482297);
                int i7 = 0;
                for (T t : chunked) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    List list = (List) t;
                    Modifier h2 = SizeKt.h(Modifier.Companion, f, 1, obj);
                    p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.p(x0.i.g(12)), androidx.compose.ui.e.a.l(), startRestartGroup, i5);
                    int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                    e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(startRestartGroup, h2);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                    Function0 a6 = companion2.a();
                    if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(a6);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer b5 = g5.b(startRestartGroup);
                    g5.e(b5, b4, companion2.c());
                    g5.e(b5, currentCompositionLocalMap2, companion2.e());
                    Function2 b6 = companion2.b();
                    if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                        b5.updateRememberedValue(Integer.valueOf(a5));
                        b5.apply(Integer.valueOf(a5), b6);
                    }
                    g5.e(b5, e2, companion2.d());
                    w2 w2Var = w2.b;
                    startRestartGroup.startReplaceGroup(-919424908);
                    int i9 = 0;
                    for (final T t2 : list) {
                        int i10 = i9 + 1;
                        if (i9 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        boolean O0 = watchPreferenceViewModel.O0(t2);
                        List list2 = (List) CollectionsKt___CollectionsKt.getOrNull(chunked2, i7);
                        if (list2 != null) {
                            str = (String) CollectionsKt___CollectionsKt.getOrNull(list2, i9);
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "";
                        }
                        String str2 = str;
                        startRestartGroup.startReplaceGroup(-1633490746);
                        boolean changedInstance = startRestartGroup.changedInstance(watchPreferenceViewModel) | startRestartGroup.changedInstance(t2);
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.preference.widget.c
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit h3;
                                    h3 = g.h(WatchPreferenceViewModel.this, t2);
                                    return h3;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        j(w2Var, str2, O0, (Function0) rememberedValue, startRestartGroup, 6);
                        i7 = i7;
                        i9 = i10;
                        chunked2 = chunked2;
                    }
                    int i11 = i7;
                    List list3 = chunked2;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-919413437);
                    int size = list.size();
                    int i12 = a;
                    if (size < i12) {
                        int size2 = i12 - list.size();
                        for (int i13 = 0; i13 < size2; i13++) {
                            a3.a(u2.a(w2Var, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                        }
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.startReplaceGroup(-738455399);
                    if (i11 < chunked.size() - 1) {
                        float g = x0.i.g(10);
                        startRestartGroup.startReplaceGroup(-1814856593);
                        a3.a(SizeKt.i(Modifier.Companion, g), startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                    i7 = i8;
                    chunked2 = list3;
                    f = 0.0f;
                    obj = null;
                    i5 = 6;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.preference.widget.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit i14;
                    i14 = g.i(contentList, preferenceData, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return i14;
                }
            });
        }
    }

    public static final void j(final v2 v2Var, final String title, final boolean z, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        long o;
        boolean z3;
        long k;
        c0 e;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(v2Var, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-950905723);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(v2Var)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(title)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(onClick)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        int i7 = i2;
        if ((i7 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i7 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950905723, i7, -1, "com.dragon.read.kmp.mine.preference.widget.PreferenceSelectorItem (WatchPreferenceContentLayout.kt:93)");
            }
            Modifier a2 = androidx.compose.ui.draw.e.a(u2.a(v2Var, Modifier.Companion, 1.0f, false, 2, (Object) null), k.g.c(x0.i.g(6)));
            if (z) {
                startRestartGroup.startReplaceGroup(1007643410);
                o = og4.a.a.h(startRestartGroup, og4.a.b).x();
            } else {
                startRestartGroup.startReplaceGroup(1007644683);
                o = og4.a.a.h(startRestartGroup, og4.a.b).o();
            }
            startRestartGroup.endReplaceGroup();
            Modifier d = BackgroundKt.d(a2, o, (f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i7 & 7168) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.preference.widget.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit k2;
                        k2 = g.k(Function0.this);
                        return k2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier t = androidx.compose.foundation.layout.f2.t(ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), 0.0f, x0.i.g(12), 1, (Object) null);
            p0 i8 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i8, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (z) {
                startRestartGroup.startReplaceGroup(-421647818);
                k = og4.a.a.h(startRestartGroup, og4.a.b).f();
            } else {
                startRestartGroup.startReplaceGroup(-421646608);
                k = og4.a.a.h(startRestartGroup, og4.a.b).k();
            }
            startRestartGroup.endReplaceGroup();
            long h = x.h(14);
            int a5 = w0.h.b.a();
            c0.a aVar = c0.b;
            if (z) {
                e = aVar.i();
            } else {
                e = aVar.e();
            }
            composer2 = startRestartGroup;
            a6.j(title, (Modifier) null, k, h, (y) null, e, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a5), 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, (14 & (i7 >> 3)) | 3072, 3072, 122322);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.preference.widget.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = g.l(v2Var, title, z, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }
}
