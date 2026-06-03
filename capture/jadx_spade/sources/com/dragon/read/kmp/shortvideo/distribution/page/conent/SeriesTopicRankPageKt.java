package com.dragon.read.kmp.shortvideo.distribution.page.conent;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.p90;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesTopicRankPageKt {
    static {
        Covode.recordClassIndex(609063);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(int i, Composer composer, int i2) {
        f(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PagerState pagerState, int i, Composer composer, int i2) {
        i(pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(PagerState pagerState, int i, Composer composer, int i2) {
        k(pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(int i, int i2, Composer composer, int i3) {
        m(i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(SeriesRankViewModel seriesRankViewModel) {
        return seriesRankViewModel.e.size();
    }

    public static final void f(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-2040083517);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2040083517, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesTopicRankPage (SeriesTopicRankPage.kt:43)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                int i2 = seriesRankViewModel.n;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(seriesRankViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.z1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            int g;
                            g = SeriesTopicRankPageKt.g(SeriesRankViewModel.this);
                            return Integer.valueOf(g);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                PagerState n = androidx.compose.foundation.pager.e1.n(i2, 0.0f, (Function0) rememberedValue, startRestartGroup, 0, 2);
                Integer valueOf = Integer.valueOf(n.u());
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(seriesRankViewModel) | startRestartGroup.changed(n);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new SeriesTopicRankPageKt$SeriesTopicRankPage$1$1(seriesRankViewModel, n, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, startRestartGroup, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, f);
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
                g5.e(b, i3, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                SeriesNormalRankPageKt.C(n.u(), null, startRestartGroup, 0, 2);
                m(n.u(), startRestartGroup, 0);
                SeriesNormalRankPageKt.M(n, x0.i.g(18), null, startRestartGroup, 48, 4);
                Modifier v = androidx.compose.foundation.layout.f2.v(androidx.compose.foundation.layout.f2.v(aVar, 0.0f, com.dragon.read.kmp.service.d1.c(), 0.0f, 0.0f, 13, (Object) null), 0.0f, x0.i.g(70), 0.0f, 0.0f, 13, (Object) null);
                androidx.compose.ui.layout.p0 a3 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.k(), startRestartGroup, 0);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, v);
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
                Composer b3 = g5.b(startRestartGroup);
                g5.e(b3, a3, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                k(n, startRestartGroup, 0);
                SeriesNormalRankPageKt.j0(n, null, startRestartGroup, 0, 2);
                startRestartGroup.endNode();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h;
                    h = SeriesTopicRankPageKt.h(i, (Composer) obj, ((Integer) obj2).intValue());
                    return h;
                }
            });
        }
    }

    public static final void i(final PagerState pagerState, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        int i3;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer startRestartGroup = composer.startRestartGroup(1905758402);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(pagerState)) {
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
                ComposerKt.traceEventStart(1905758402, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SideTabTitleBarInfiniteStyle (SeriesTopicRankPage.kt:114)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                long t0 = SeriesNormalRankPageKt.t0(pagerState.u(), seriesRankViewModel, startRestartGroup, 0);
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, x0.i.g(38), 0.0f, 11, (Object) null);
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                com.dragon.read.kmp.widget.v0.b(null, x0.i.g(16), t0, false, false, androidx.compose.runtime.internal.t.e(1108953308, true, new Function2<Composer, Integer, Unit>() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesTopicRankPageKt$SideTabTitleBarInfiniteStyle$1$1

                    /* renamed from: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesTopicRankPageKt$SideTabTitleBarInfiniteStyle$1$1$1, reason: invalid class name */
                    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ SeriesRankViewModel a;
                        final /* synthetic */ PagerState b;
                        final /* synthetic */ CoroutineScope c;

                        AnonymousClass1(SeriesRankViewModel seriesRankViewModel, PagerState pagerState, CoroutineScope coroutineScope) {
                            this.a = seriesRankViewModel;
                            this.b = pagerState;
                            this.c = coroutineScope;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            c(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit d(SeriesRankViewModel seriesRankViewModel, io4.b bVar) {
                            no4.a.j(seriesRankViewModel.f, true, bVar.f(), bVar.k, null, 8, null);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r13v0 */
                        /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
                        /* JADX WARN: Type inference failed for: r13v3 */
                        public final void c(Composer composer, int i) {
                            boolean z;
                            boolean z2;
                            boolean z3 = false;
                            ?? r13 = 1;
                            if ((i & 3) != 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (composer.shouldExecute(z, i & 1)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(563478810, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SideTabTitleBarInfiniteStyle.<anonymous>.<anonymous>.<anonymous> (SeriesTopicRankPage.kt:132)");
                                }
                                final SeriesRankViewModel seriesRankViewModel = this.a;
                                List<io4.b> list = seriesRankViewModel.e;
                                PagerState pagerState = this.b;
                                CoroutineScope coroutineScope = this.c;
                                int i2 = 0;
                                for (Object obj : list) {
                                    int i3 = i2 + 1;
                                    if (i2 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final io4.b bVar = (io4.b) obj;
                                    if (pagerState.u() == i2) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    Modifier d = SizeKt.d(SizeKt.F(androidx.compose.foundation.layout.f2.v(Modifier.Companion, 0.0f, 0.0f, x0.i.g(6), 0.0f, 11, (Object) null), (e.b) null, z3, 3, (Object) null), 0.0f, (int) r13, (Object) null);
                                    composer.startReplaceGroup(-1633490746);
                                    boolean changedInstance = composer.changedInstance(seriesRankViewModel) | composer.changed(bVar);
                                    Object rememberedValue = composer.rememberedValue();
                                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0090: CONSTRUCTOR (r8v2 'rememberedValue' java.lang.Object) = 
                                              (r12v1 'seriesRankViewModel' com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel A[DONT_INLINE])
                                              (r2v7 'bVar' io4.b A[DONT_INLINE])
                                             A[MD:(com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel, io4.b):void (m)] (LINE:34013328) call: com.dragon.read.kmp.shortvideo.distribution.page.conent.e2.<init>(com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel, io4.b):void type: CONSTRUCTOR in method: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesTopicRankPageKt$SideTabTitleBarInfiniteStyle$1$1.1.c(androidx.compose.runtime.Composer, int):void, file: D:\code\hongguo\capture\classes6.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:207)
                                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.dragon.read.kmp.shortvideo.distribution.page.conent.e2, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:305)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 35 more
                                            */
                                        /*
                                            Method dump skipped, instructions count: 299
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesTopicRankPageKt$SideTabTitleBarInfiniteStyle$1$1.AnonymousClass1.c(androidx.compose.runtime.Composer, int):void");
                                    }

                                    /* renamed from: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesTopicRankPageKt$SideTabTitleBarInfiniteStyle$1$1$1$a */
                                    static final class a implements Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit> {
                                        final /* synthetic */ io4.b a;
                                        final /* synthetic */ int b;
                                        final /* synthetic */ PagerState c;

                                        a(io4.b bVar, int i, PagerState pagerState) {
                                            this.a = bVar;
                                            this.b = i;
                                            this.c = pagerState;
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.b0 b0Var, Composer composer, Integer num) {
                                            a(b0Var, composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void a(androidx.compose.foundation.layout.b0 Tab, Composer composer, int i) {
                                            boolean z;
                                            long k;
                                            androidx.compose.ui.text.font.c0 h;
                                            long o;
                                            Intrinsics.checkNotNullParameter(Tab, "$this$Tab");
                                            if ((i & 17) != 16) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (composer.shouldExecute(z, i & 1)) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(415526638, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SideTabTitleBarInfiniteStyle.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SeriesTopicRankPage.kt:146)");
                                                }
                                                String f = this.a.f();
                                                if (this.b == this.c.u()) {
                                                    composer.startReplaceGroup(-110853415);
                                                    k = og4.a.a.h(composer, og4.a.b).f();
                                                } else {
                                                    composer.startReplaceGroup(-110852205);
                                                    k = og4.a.a.h(composer, og4.a.b).k();
                                                }
                                                composer.endReplaceGroup();
                                                long j = k;
                                                long h2 = x0.x.h(14);
                                                long h3 = x0.x.h(20);
                                                if (this.b == this.c.u()) {
                                                    h = androidx.compose.ui.text.font.c0.b.a();
                                                } else {
                                                    h = androidx.compose.ui.text.font.c0.b.h();
                                                }
                                                androidx.compose.ui.text.font.c0 c0Var = h;
                                                Modifier a = androidx.compose.ui.draw.e.a(Modifier.Companion, k.g.c(x0.i.g(8)));
                                                if (this.b == this.c.u()) {
                                                    composer.startReplaceGroup(-110839173);
                                                    o = og4.a.a.h(composer, og4.a.b).x();
                                                } else {
                                                    composer.startReplaceGroup(-110837900);
                                                    o = og4.a.a.h(composer, og4.a.b).o();
                                                }
                                                composer.endReplaceGroup();
                                                a6.j(f, androidx.compose.foundation.layout.f2.s(BackgroundKt.d(a, o, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(14), x0.i.g(5)), j, h2, (androidx.compose.ui.text.font.y) null, c0Var, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), h3, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 6, 129488);
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
                                    public static final Unit e(CoroutineScope coroutineScope, SeriesRankViewModel seriesRankViewModel, io4.b bVar, PagerState pagerState, int i) {
                                        kotlinx.coroutines.i.e(coroutineScope, null, null, new SeriesTopicRankPageKt$SideTabTitleBarInfiniteStyle$1$1$1$1$2$1$1(pagerState, i, null), 3, null);
                                        no4.a.j(seriesRankViewModel.f, false, bVar.f(), bVar.k, null, 8, null);
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    a(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void a(Composer composer2, int i5) {
                                    boolean z2;
                                    if ((i5 & 3) != 2) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (composer2.shouldExecute(z2, i5 & 1)) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1108953308, i5, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SideTabTitleBarInfiniteStyle.<anonymous>.<anonymous> (SeriesTopicRankPage.kt:125)");
                                        }
                                        int u = pagerState.u();
                                        Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                                        float g = x0.i.g(16);
                                        d dVar = d.a;
                                        com.dragon.read.kmp.widget.slidetab.e.b(u, f, 0L, 0L, g, dVar.a(), dVar.b(), androidx.compose.runtime.internal.t.e(563478810, true, new AnonymousClass1(seriesRankViewModel, pagerState, coroutineScope), composer2, 54), composer2, 14377008, 12);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, startRestartGroup, 54), startRestartGroup, 196656, 25);
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
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.d2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit j;
                                j = SeriesTopicRankPageKt.j(pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return j;
                            }
                        });
                    }
                }

                private static final void k(final PagerState pagerState, Composer composer, final int i) {
                    int i2;
                    boolean z;
                    CreationExtras creationExtras;
                    int i3;
                    Composer startRestartGroup = composer.startRestartGroup(-878044034);
                    if ((i & 6) == 0) {
                        if (startRestartGroup.changed(pagerState)) {
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
                            ComposerKt.traceEventStart(-878044034, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.TopicTabTitleLayout (SeriesTopicRankPage.kt:78)");
                        }
                        HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
                        if (c != null) {
                            if (c instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            boolean z2 = ((ko4.b) seriesRankViewModel.d.getValue()).b;
                            Modifier i4 = SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(38));
                            androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.n(), false);
                            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier e = ComposedModifierKt.e(startRestartGroup, i4);
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
                            i(pagerState, startRestartGroup, i2 & 14);
                            startRestartGroup.startReplaceGroup(-1498186770);
                            if (!z2) {
                                SeriesNormalRankPageKt.Z(((ko4.b) seriesRankViewModel.d.getValue()).d, x0.i.g(16), startRestartGroup, 48, 0);
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
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.c2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit l;
                                l = SeriesTopicRankPageKt.l(pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return l;
                            }
                        });
                    }
                }

                private static final void m(final int i, Composer composer, final int i2) {
                    int i3;
                    boolean z;
                    Composer composer2;
                    CreationExtras creationExtras;
                    String str;
                    p90 p90Var;
                    int i4;
                    Composer startRestartGroup = composer.startRestartGroup(1471034974);
                    if ((i2 & 6) == 0) {
                        if (startRestartGroup.changed(i)) {
                            i4 = 4;
                        } else {
                            i4 = 2;
                        }
                        i3 = i4 | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i3 & 3) != 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (startRestartGroup.shouldExecute(z, i3 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1471034974, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.TopicTitleLayout (SeriesTopicRankPage.kt:96)");
                        }
                        HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
                        if (c != null) {
                            if (c instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            io4.b bVar = (io4.b) CollectionsKt___CollectionsKt.getOrNull(((SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0)).e, i);
                            if (bVar == null || (p90Var = bVar.a) == null || (str = p90Var.a) == null) {
                                str = "";
                            }
                            String str2 = str;
                            Modifier f = SizeKt.f(androidx.compose.foundation.layout.f2.v(androidx.compose.foundation.layout.f2.v(Modifier.Companion, 0.0f, com.dragon.read.kmp.service.d1.c(), 0.0f, 0.0f, 13, (Object) null), 0.0f, x0.i.g(10), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
                            androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.m(), false);
                            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier e = ComposedModifierKt.e(startRestartGroup, f);
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
                            a6.j(str2, (Modifier) null, og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(18), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.b2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit n;
                                n = SeriesTopicRankPageKt.n(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return n;
                            }
                        });
                    }
                }
            }
