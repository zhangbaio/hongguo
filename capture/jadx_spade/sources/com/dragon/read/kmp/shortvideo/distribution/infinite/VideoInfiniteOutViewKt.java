package com.dragon.read.kmp.shortvideo.distribution.infinite;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.layout.j1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoInfiniteOutViewKt {
    static {
        Covode.recordClassIndex(609033);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar, Modifier modifier, float f2, boolean z, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        j(gVar, dVar, modifier, f2, z, z2, z3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(LazyListState lazyListState, float f2, int i, Composer composer, int i2) {
        l(lazyListState, f2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, MutableState mutableState, LazyListState lazyListState, Function0 function0, Function1 function1, Function1 function12, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        p(gVar, mutableState, lazyListState, function0, function1, function12, z, z2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, MutableState mutableState, LazyListState lazyListState, Function0 function0, Function1 function1, Function1 function12, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        p(gVar, mutableState, lazyListState, function0, function1, function12, z, z2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function0<Unit> {
        final /* synthetic */ Function1<com.dragon.read.kmp.shortvideo.distribution.infinite.d, Unit> a;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.d b;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g c;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super com.dragon.read.kmp.shortvideo.distribution.infinite.d, Unit> function1, com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar, com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar) {
            this.a = function1;
            this.b = dVar;
            this.c = gVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Function1<com.dragon.read.kmp.shortvideo.distribution.infinite.d, Unit> function1 = this.a;
            if (function1 != null) {
                function1.invoke(this.b);
            }
            this.c.i(this.b);
        }
    }

    static final class b implements Function0<Unit> {
        final /* synthetic */ Function1<com.dragon.read.kmp.shortvideo.distribution.infinite.d, Unit> a;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.d b;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super com.dragon.read.kmp.shortvideo.distribution.infinite.d, Unit> function1, com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar, com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar) {
            this.a = function1;
            this.b = dVar;
            this.c = gVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Function1<com.dragon.read.kmp.shortvideo.distribution.infinite.d, Unit> function1 = this.a;
            if (function1 != null) {
                function1.invoke(this.b);
            }
            this.c.h(this.b);
        }
    }

    public static final class e implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public e(List list) {
            this.a = list;
        }

        public final Object a(int i) {
            this.a.get(i);
            return null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(LazyListState lazyListState) {
        return lazyListState.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(LazyListState lazyListState) {
        return lazyListState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    static final class c implements Function1<x0.t, Unit> {
        final /* synthetic */ Map<Integer, Integer> a;
        final /* synthetic */ int b;

        c(Map<Integer, Integer> map, int i) {
            this.a = map;
            this.b = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(x0.t tVar) {
            a(tVar.j());
            return Unit.INSTANCE;
        }

        public final void a(long j) {
            this.a.put(Integer.valueOf(this.b), Integer.valueOf((int) (j >> 32)));
        }
    }

    public static final class d implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public d(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }

        public final Object a(int i) {
            return this.a.invoke(Integer.valueOf(i), this.b.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object s(int i, com.dragon.read.kmp.shortvideo.distribution.infinite.d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.b.b + data.b.c;
    }

    public static final class g implements androidx.compose.ui.input.nestedscroll.b {
        g() {
        }

        public long Y(long j, long j2, int i) {
            return j2;
        }

        public /* synthetic */ long Y1(long j, int i) {
            return androidx.compose.ui.input.nestedscroll.a.d(this, j, i);
        }

        public /* synthetic */ Object k0(long j, Continuation continuation) {
            return androidx.compose.ui.input.nestedscroll.a.c(this, j, continuation);
        }

        public Object a1(long j, long j2, Continuation<? super x0.z> continuation) {
            return x0.z.b(j2);
        }
    }

    public static final class f implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ com.dragon.read.kmp.shortvideo.distribution.infinite.g b;
        final /* synthetic */ Function1 c;
        final /* synthetic */ Function1 d;
        final /* synthetic */ Map e;
        final /* synthetic */ float f;
        final /* synthetic */ boolean g;
        final /* synthetic */ boolean h;

        public f(List list, com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, Function1 function1, Function1 function12, Map map, float f, boolean z, boolean z2) {
            this.a = list;
            this.b = gVar;
            this.c = function1;
            this.d = function12;
            this.e = map;
            this.f = f;
            this.g = z;
            this.h = z2;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            boolean z2;
            boolean z3;
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
            boolean z4 = false;
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int i6 = (i3 & 112) | (i3 & 14);
                com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar = (com.dragon.read.kmp.shortvideo.distribution.infinite.d) this.a.get(i);
                composer.startReplaceGroup(1817895917);
                com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar = this.b;
                Modifier.a aVar = Modifier.Companion;
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(this.c);
                int i7 = (i6 & 896) ^ 384;
                if ((i7 > 256 && composer.changed(dVar)) || (i6 & 384) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changed2 = changed | z2 | composer.changed(this.b);
                Object rememberedValue = composer.rememberedValue();
                if (changed2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(this.c, dVar, this.b);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier d = tc4.i.d(aVar, (Function0) null, (Function0) rememberedValue, 1, (Object) null);
                composer.startReplaceGroup(-1746271574);
                boolean changed3 = composer.changed(this.d);
                if ((i7 > 256 && composer.changed(dVar)) || (i6 & 384) == 256) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean changed4 = changed3 | z3 | composer.changed(this.b);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new b(this.d, dVar, this.b);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changedInstance = composer.changedInstance(this.e);
                if ((((i6 & 112) ^ 48) > 32 && composer.changed(i)) || (i6 & 48) == 32) {
                    z4 = true;
                }
                boolean z5 = changedInstance | z4;
                Object rememberedValue3 = composer.rememberedValue();
                if (z5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new c(this.e, i);
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                VideoInfiniteOutViewKt.j(gVar, dVar, j1.a(modifier, (Function1) rememberedValue3), this.f, this.g, this.h, h.j(this.b), composer, (i6 >> 3) & 112, 0);
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

    private static final void l(final LazyListState lazyListState, final float f2, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        long j;
        List listOf;
        List listOf2;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(656037632);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(f2)) {
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
                ComposerKt.traceEventStart(656037632, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.infinite.ListShadow (VideoInfiniteOutView.kt:289)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean m;
                        m = VideoInfiniteOutViewKt.m(lazyListState);
                        return Boolean.valueOf(m);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            State state = (State) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean n;
                        n = VideoInfiniteOutViewKt.n(lazyListState);
                        return Boolean.valueOf(n);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            State state2 = (State) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                ko4.a c3 = ((ko4.b) seriesRankViewModel.d.getValue()).c(Integer.valueOf(seriesRankViewModel.n));
                if (fq4.a.a.a()) {
                    j = c3.b;
                } else {
                    j = c3.a;
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier i5 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), f2);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, i5);
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
                g5.e(b2, i6, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                startRestartGroup.startReplaceGroup(46419799);
                if (((Boolean) state.getValue()).booleanValue()) {
                    Modifier d2 = SizeKt.d(SizeKt.x(boxScopeInstance.b(aVar, aVar2.h()), x0.i.g(12)), 0.0f, 1, (Object) null);
                    c0.a aVar3 = c0.b;
                    listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(l0.n(j, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), l0.j(l0.b.g())});
                    a3.a(BackgroundKt.b(d2, c0.a.d(aVar3, listOf2, 0.0f, 0.0f, 0, 14, (Object) null), (f2) null, 0.0f, 6, (Object) null), startRestartGroup, 0);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(46435301);
                if (((Boolean) state2.getValue()).booleanValue()) {
                    Modifier d3 = SizeKt.d(SizeKt.x(boxScopeInstance.b(aVar, aVar2.f()), x0.i.g(12)), 0.0f, 1, (Object) null);
                    c0.a aVar4 = c0.b;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(l0.b.g()), l0.j(l0.n(j, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))});
                    a3.a(BackgroundKt.b(d3, c0.a.d(aVar4, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (f2) null, 0.0f, 6, (Object) null), startRestartGroup, 0);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = VideoInfiniteOutViewKt.o(lazyListState, f2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(MutableState mutableState, com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, Function1 function1, Function1 function12, Map map, float f2, boolean z, boolean z2, o0 LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        List list = (List) mutableState.getValue();
        LazyRow.f(list.size(), new d(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.infinite.z
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object s;
                s = VideoInfiniteOutViewKt.s(((Integer) obj).intValue(), (d) obj2);
                return s;
            }
        }, list), new e(list), androidx.compose.runtime.internal.t.c(2039820996, true, new f(list, gVar, function1, function12, map, f2, z, z2)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0136, code lost:
    
        r4 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r15, new java.lang.String[]{"年"}, false, 2, 2, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final com.dragon.read.kmp.shortvideo.distribution.infinite.g r38, final com.dragon.read.kmp.shortvideo.distribution.infinite.d r39, androidx.compose.ui.Modifier r40, float r41, boolean r42, final boolean r43, final boolean r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 1401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.infinite.VideoInfiniteOutViewKt.j(com.dragon.read.kmp.shortvideo.distribution.infinite.g, com.dragon.read.kmp.shortvideo.distribution.infinite.d, androidx.compose.ui.Modifier, float, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x0602, code lost:
    
        if (r0 == null) goto L255;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void p(final com.dragon.read.kmp.shortvideo.distribution.infinite.g r44, final androidx.compose.runtime.MutableState<java.lang.Integer> r45, androidx.compose.foundation.lazy.LazyListState r46, kotlin.jvm.functions.Function0<kotlin.Unit> r47, kotlin.jvm.functions.Function1<? super com.dragon.read.kmp.shortvideo.distribution.infinite.d, kotlin.Unit> r48, kotlin.jvm.functions.Function1<? super com.dragon.read.kmp.shortvideo.distribution.infinite.d, kotlin.Unit> r49, final boolean r50, final boolean r51, androidx.compose.runtime.Composer r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 1785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.infinite.VideoInfiniteOutViewKt.p(com.dragon.read.kmp.shortvideo.distribution.infinite.g, androidx.compose.runtime.MutableState, androidx.compose.foundation.lazy.LazyListState, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
