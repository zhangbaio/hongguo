package com.dragon.read.kmp.reader.ui.menu.moresettings;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.gestures.s2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.y1;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.material.p0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t2;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import com.dragon.read.kmp.reader.ui.menu.moresettings.m0;
import com.dragon.read.kmp.reader.ui.menu.ui.PullDownBoxKt;
import com.dragon.read.reader.n3;
import com.dragon.read.reader.o3;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m0 {
    static {
        Covode.recordClassIndex(608621);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(String str, sm4.k kVar, int i, Composer composer, int i2) {
        x(str, kVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(cm4.i iVar, sm4.g gVar, com.dragon.read.kmp.reader.ui.menu.ui.c cVar, int i, Composer composer, int i2) {
        k(iVar, gVar, cVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, int i, Composer composer, int i2) {
        o(vVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, int i, Composer composer, int i2) {
        o(vVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, int i, Composer composer, int i2) {
        s(vVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Modifier modifier, sm4.h hVar, int i, Composer composer, int i2) {
        v(modifier, hVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class d implements DisposableEffectResult {
        final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.model.v a;

        public void dispose() {
            this.a.k = null;
        }

        public d(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar) {
            this.a = vVar;
        }
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.model.v a;
        final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.ui.b b;

        public void dispose() {
            com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar = this.a;
            com.dragon.read.kmp.reader.ui.menu.ui.b bVar = this.b;
            vVar.h = bVar.a;
            vVar.i = bVar.b;
        }

        public b(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, com.dragon.read.kmp.reader.ui.menu.ui.b bVar) {
            this.a = vVar;
            this.b = bVar;
        }
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.model.v a;
        final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.ui.b b;
        final /* synthetic */ cm4.i c;

        a(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, com.dragon.read.kmp.reader.ui.menu.ui.b bVar, cm4.i iVar) {
            this.a = vVar;
            this.b = bVar;
            this.c = iVar;
        }

        /* renamed from: com.dragon.read.kmp.reader.ui.menu.moresettings.m0$a$a, reason: collision with other inner class name */
        static final class C0055a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.model.v a;
            final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.ui.b b;
            final /* synthetic */ cm4.i c;

            C0055a(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, com.dragon.read.kmp.reader.ui.menu.ui.b bVar, cm4.i iVar) {
                this.a = vVar;
                this.b = bVar;
                this.c = iVar;
            }

            /* renamed from: com.dragon.read.kmp.reader.ui.menu.moresettings.m0$a$a$a, reason: collision with other inner class name */
            static final class C0056a implements Function4<androidx.compose.foundation.layout.r, s2, Composer, Integer, Unit> {
                final /* synthetic */ int a;
                final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.model.v b;
                final /* synthetic */ cm4.i c;

                C0056a(int i, com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, cm4.i iVar) {
                    this.a = i;
                    this.b = vVar;
                    this.c = iVar;
                }

                /* renamed from: com.dragon.read.kmp.reader.ui.menu.moresettings.m0$a$a$a$a, reason: collision with other inner class name */
                public static final class C0057a implements Function1<Integer, Object> {
                    final /* synthetic */ List a;

                    public C0057a(List list) {
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
                public static final Unit d(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar) {
                    vVar.b();
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.reader.ui.menu.moresettings.m0$a$a$a$b */
                public static final class b implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
                    final /* synthetic */ List a;
                    final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.model.v b;
                    final /* synthetic */ cm4.i c;
                    final /* synthetic */ List d;

                    public b(List list, com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, cm4.i iVar, List list2) {
                        this.a = list;
                        this.b = vVar;
                        this.c = iVar;
                        this.d = list2;
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
                        a(fVar, num.intValue(), composer, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
                        int i3;
                        boolean z;
                        int i4;
                        int i5;
                        if ((i2 & 6) == 0) {
                            if (composer.changed(fVar)) {
                                i5 = 4;
                            } else {
                                i5 = 2;
                            }
                            i3 = i5 | i2;
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
                                ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                            }
                            sm4.h hVar = (sm4.h) this.a.get(i);
                            composer.startReplaceGroup(-1022376029);
                            if (hVar instanceof sm4.k) {
                                composer.startReplaceGroup(-32978128);
                                m0.x(this.b.f, (sm4.k) hVar, composer, sm4.k.g << 3);
                                composer.endReplaceGroup();
                            } else if (hVar instanceof sm4.g) {
                                composer.startReplaceGroup(-32975001);
                                m0.k(this.c, (sm4.g) hVar, (com.dragon.read.kmp.reader.ui.menu.ui.c) composer.consume(com.dragon.read.kmp.reader.ui.menu.ui.e.c()), composer, cm4.i.a | (sm4.g.g << 3) | (com.dragon.read.kmp.reader.ui.menu.ui.c.d << 6));
                                composer.endReplaceGroup();
                            } else {
                                composer.startReplaceGroup(-32971886);
                                composer.endReplaceGroup();
                                throw new IllegalArgumentException("未知类型，请检查ReaderMoreSettingItem子类实现");
                            }
                            composer.startReplaceGroup(-32967689);
                            if (i != this.d.size() - 1) {
                                p0.b(SizeKt.i(Modifier.Companion, x0.i.g((float) 0.5d)), n0.b(438181923), 0.0f, 0.0f, composer, 54, 12);
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

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, s2 s2Var, Composer composer, Integer num) {
                    c(rVar, s2Var, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit e(List list, com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, cm4.i iVar, o0 LazyColumn) {
                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                    LazyColumn.f(list.size(), (Function1) null, new C0057a(list), androidx.compose.runtime.internal.t.c(2039820996, true, new b(list, vVar, iVar, list)));
                    return Unit.INSTANCE;
                }

                public final void c(androidx.compose.foundation.layout.r PullDownBox, s2 s2Var, Composer composer, int i) {
                    List mutableListOf;
                    Intrinsics.checkNotNullParameter(PullDownBox, "$this$PullDownBox");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(291761571, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ReaderMoreSettingContent.<anonymous>.<anonymous>.<anonymous> (ReaderMoreSetting.kt:90)");
                    }
                    Modifier.a aVar = Modifier.Companion;
                    Modifier i2 = SizeKt.i(BackgroundKt.d(aVar, ((zl4.b) composer.consume(zl4.r.w())).r(composer, 0), (f2) null, 2, (Object) null), x0.i.g(pn4.a.b(this.a)));
                    final com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar = this.b;
                    final cm4.i iVar = this.c;
                    e.m i3 = androidx.compose.foundation.layout.e.a.i();
                    e.a aVar2 = androidx.compose.ui.e.a;
                    androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(i3, aVar2.k(), composer, 0);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, i2);
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
                    Composer b2 = g5.b(composer);
                    g5.e(b2, a, companion.c());
                    g5.e(b2, currentCompositionLocalMap, companion.e());
                    Function2 b3 = companion.b();
                    if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                        b2.updateRememberedValue(Integer.valueOf(a2));
                        b2.apply(Integer.valueOf(a2), b3);
                    }
                    g5.e(b2, e, companion.d());
                    androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                    org.jetbrains.compose.resources.i l = o3.l(n3.a);
                    composer.startReplaceGroup(5004770);
                    boolean changed = composer.changed(vVar);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.k0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit d;
                                d = m0.a.C0055a.C0056a.d(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v.this);
                                return d;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    com.dragon.read.kmp.reader.ui.menu.ui.y.c(null, l, false, (Function0) rememberedValue, composer, 0, 5);
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue2 = composer.rememberedValue();
                    Composer.Companion companion2 = Composer.Companion;
                    if (rememberedValue2 == companion2.getEmpty()) {
                        rememberedValue2 = vVar.g;
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    final List list = (List) rememberedValue2;
                    composer.endReplaceGroup();
                    Intrinsics.checkNotNull(s2Var, "null cannot be cast to non-null type androidx.compose.foundation.lazy.LazyListState");
                    LazyListState lazyListState = (LazyListState) s2Var;
                    composer.startReplaceGroup(-1746271574);
                    boolean changedInstance = composer.changedInstance(list) | composer.changed(vVar) | composer.changedInstance(iVar);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changedInstance || rememberedValue3 == companion2.getEmpty()) {
                        rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.l0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit e2;
                                e2 = m0.a.C0055a.C0056a.e(list, vVar, iVar, (o0) obj);
                                return e2;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    composer.endReplaceGroup();
                    androidx.compose.foundation.lazy.d.c((Modifier) null, lazyListState, (i2) null, false, (e.m) null, (e.b) null, (l1) null, false, (y1) null, (Function1) rememberedValue3, composer, 0, 509);
                    composer.endNode();
                    Modifier h = SizeKt.h(PullDownBox.b(SizeKt.i(aVar, x0.i.g(20)), aVar2.d()), 0.0f, 1, (Object) null);
                    c0.a aVar3 = androidx.compose.ui.graphics.c0.b;
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.b.g()), androidx.compose.ui.graphics.l0.j(((zl4.b) composer.consume(zl4.r.w())).r(composer, 0)));
                    androidx.compose.foundation.layout.m.b(BackgroundKt.b(h, c0.a.h(aVar3, mutableListOf, a0.f.b.c(), a0.f.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(Float.POSITIVE_INFINITY) & 4294967295L)), 0, 8, (Object) null), (f2) null, 0.0f, 6, (Object) null), composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar) {
                vVar.b();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                b(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void b(Composer composer, int i) {
                boolean z;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2014084830, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ReaderMoreSettingContent.<anonymous>.<anonymous> (ReaderMoreSetting.kt:84)");
                    }
                    int f = ScreenUtils.a.f(ig4.f.a(composer, 0)) / 2;
                    com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar = this.a;
                    composer.startReplaceGroup(5004770);
                    boolean changed = composer.changed(this.a);
                    final com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar2 = this.a;
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.j0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit c;
                                c = m0.a.C0055a.c(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v.this);
                                return c;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    PullDownBoxKt.l(vVar, (Function0) rememberedValue, this.b, androidx.compose.runtime.internal.t.e(291761571, true, new C0056a(f, this.a, this.c), composer, 54), composer, 3456, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-429035981, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ReaderMoreSettingContent.<anonymous> (ReaderMoreSetting.kt:83)");
                }
                com.dragon.read.kmp.reader.state.t.f(androidx.compose.runtime.internal.t.e(-2014084830, true, new C0055a(this.a, this.b, this.c), composer, 54), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    private static final sm4.g l(MutableState<sm4.g> mutableState) {
        return (sm4.g) mutableState.getValue();
    }

    private static final sm4.k y(MutableState<sm4.k> mutableState) {
        return (sm4.k) mutableState.getValue();
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.ui.c a;
        final /* synthetic */ com.dragon.read.kmp.reader.ui.menu.moresettings.model.v b;

        c(com.dragon.read.kmp.reader.ui.menu.ui.c cVar, com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar) {
            this.a = cVar;
            this.b = vVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(323788440, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ReaderMoreSettings.<anonymous> (ReaderMoreSetting.kt:146)");
                }
                androidx.compose.ui.e d = androidx.compose.ui.e.a.d();
                com.dragon.read.kmp.reader.ui.menu.ui.c cVar = this.a;
                com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar = this.b;
                Modifier.a aVar = Modifier.Companion;
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(d, false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, aVar);
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
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Function2<Composer, Integer, Unit> b3 = cVar.b();
                if (b3 == null) {
                    composer.startReplaceGroup(114110033);
                    m0.o(vVar, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(114178109);
                    b3.invoke(composer, 0);
                    composer.endReplaceGroup();
                }
                List<sm4.d> c = cVar.c();
                composer.startReplaceGroup(280782483);
                if (!c.isEmpty()) {
                    Iterator<sm4.d> it2 = c.iterator();
                    while (it2.hasNext()) {
                        Function2<Composer, Integer, Unit> d2 = cVar.d(it2.next());
                        composer.startReplaceGroup(280788186);
                        if (d2 != null) {
                            d2.invoke(composer, 0);
                            Unit unit = Unit.INSTANCE;
                        }
                        composer.endReplaceGroup();
                    }
                }
                composer.endReplaceGroup();
                composer.endNode();
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
    public static final DisposableEffectResult q(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, com.dragon.read.kmp.reader.ui.menu.ui.b bVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new b(vVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult u(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v vVar, com.dragon.read.kmp.reader.ui.menu.ui.c cVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        vVar.k = cVar;
        return new d(vVar);
    }

    private static final void D(String str, String str2, boolean z) {
        String str3;
        dm4.s sVar = dm4.s.b;
        ym4.a aVar = new ym4.a();
        aVar.g("clicked_content", str2);
        if (z) {
            str3 = "on";
        } else {
            str3 = "off";
        }
        aVar.g("result", str3);
        aVar.g("book_id", str);
        Unit unit = Unit.INSTANCE;
        sVar.a("click_reader_more_config", aVar);
    }

    public static final void o(final com.dragon.read.kmp.reader.ui.menu.moresettings.model.v param, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(param, "param");
        Composer startRestartGroup = composer.startRestartGroup(-1643591874);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(param)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        boolean z2 = false;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1643591874, i2, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ReaderMoreSettingContent (ReaderMoreSetting.kt:72)");
            }
            cm4.i a2 = cm4.j.a(startRestartGroup, 0);
            if (a2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.b0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit p;
                            p = m0.p(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v.this, i, (Composer) obj, ((Integer) obj2).intValue());
                            return p;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new com.dragon.read.kmp.reader.ui.menu.ui.b(param.h, param.i);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final com.dragon.read.kmp.reader.ui.menu.ui.b bVar = (com.dragon.read.kmp.reader.ui.menu.ui.b) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 14) == 4) {
                z2 = true;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult q;
                        q = m0.q(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v.this, bVar, (DisposableEffectScope) obj);
                        return q;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, startRestartGroup, 6);
            ym4.f.c("ReaderMoreSettings", param, androidx.compose.runtime.internal.t.e(-429035981, true, new a(param, bVar, a2), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r;
                    r = m0.r(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return r;
                }
            });
        }
    }

    public static final void s(final com.dragon.read.kmp.reader.ui.menu.moresettings.model.v param, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(param, "param");
        Composer startRestartGroup = composer.startRestartGroup(-556373160);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(param)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        boolean z2 = false;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-556373160, i2, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ReaderMoreSettings (ReaderMoreSetting.kt:137)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new com.dragon.read.kmp.reader.ui.menu.ui.c();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final com.dragon.read.kmp.reader.ui.menu.ui.c cVar = (com.dragon.read.kmp.reader.ui.menu.ui.c) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 14) == 4) {
                z2 = true;
            }
            boolean changedInstance = startRestartGroup.changedInstance(cVar) | z2;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult u;
                        u = m0.u(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v.this, cVar, (DisposableEffectScope) obj);
                        return u;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, startRestartGroup, 6);
            androidx.compose.runtime.d0.c(com.dragon.read.kmp.reader.ui.menu.ui.e.c().provides(cVar), androidx.compose.runtime.internal.t.e(323788440, true, new c(cVar, param), startRestartGroup, 54), startRestartGroup, t2.i | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t;
                    t = m0.t(com.dragon.read.kmp.reader.ui.menu.moresettings.model.v.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return t;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(sm4.g gVar, cm4.i iVar, com.dragon.read.kmp.reader.ui.menu.ui.c cVar, CoroutineScope coroutineScope) {
        gVar.f.invoke(iVar, cVar, coroutineScope);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0133, code lost:
    
        if (r29 != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void v(final androidx.compose.ui.Modifier r32, final sm4.h r33, androidx.compose.runtime.Composer r34, final int r35) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.ui.menu.moresettings.m0.v(androidx.compose.ui.Modifier, sm4.h, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final String str, final sm4.k kVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        float f;
        boolean z2;
        long d2;
        boolean z3;
        boolean z4;
        boolean changedInstance;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1385189780);
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
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(kVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(kVar);
            }
            if (changedInstance) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1385189780, i2, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.SwitchSetting (ReaderMoreSetting.kt:181)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(kVar, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (kVar.b != null) {
                i3 = 17;
            } else {
                i3 = 14;
            }
            float g = x0.i.g(i3);
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(androidx.compose.foundation.layout.f2.s(aVar, x0.i.g(20), g), 0.0f, 1, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, h);
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
            g5.e(b2, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            v(boxScopeInstance.b(aVar, aVar2.h()), y(mutableState), startRestartGroup, sm4.k.g << 3);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            boolean z5 = y(mutableState).e;
            float g2 = x0.i.g(31);
            float g3 = x0.i.g(18);
            long u = ((zl4.b) startRestartGroup.consume(zl4.r.w())).u();
            if (((Number) startRestartGroup.consume(zl4.r.A())).intValue() == 5) {
                startRestartGroup.startReplaceGroup(1191081186);
                f = g3;
                z2 = z5;
                d2 = com.dragon.read.kmp.reader.ui.d0.d(((zl4.b) startRestartGroup.consume(zl4.r.w())).o(), 0.2f);
                startRestartGroup.endReplaceGroup();
            } else {
                f = g3;
                z2 = z5;
                startRestartGroup.startReplaceGroup(1191176418);
                d2 = com.dragon.read.kmp.reader.ui.d0.d(((zl4.b) startRestartGroup.consume(zl4.r.w())).o(), 0.1f);
                startRestartGroup.endReplaceGroup();
            }
            long j = d2;
            long i7 = ((zl4.b) startRestartGroup.consume(zl4.r.w())).i();
            long i8 = ((zl4.b) startRestartGroup.consume(zl4.r.w())).i();
            Modifier b4 = boxScopeInstance.b(aVar, aVar2.f());
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope);
            if ((i2 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z6 = changedInstance2 | z3;
            if ((i2 & 112) != 32 && ((i2 & 64) == 0 || !startRestartGroup.changedInstance(kVar))) {
                z4 = false;
            } else {
                z4 = true;
            }
            boolean z7 = z6 | z4;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit z8;
                        z8 = m0.z(CoroutineScope.this, str, kVar, mutableState, ((Boolean) obj).booleanValue());
                        return z8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            wg4.v.d(z2, (Function1) rememberedValue3, b4, g2, f, u, j, i7, i8, composer2, 27648, 0);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit A;
                    A = m0.A(str, kVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return A;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(CoroutineScope coroutineScope, String str, sm4.k kVar, MutableState mutableState, boolean z) {
        y(mutableState).f.invoke(Boolean.valueOf(z), ig4.f.b(), coroutineScope);
        D(str, kVar.c, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final cm4.i iVar, final sm4.g gVar, final com.dragon.read.kmp.reader.ui.menu.ui.c cVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        boolean changedInstance;
        int i3;
        boolean changedInstance2;
        int i4;
        boolean changedInstance3;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1552716198);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance3 = startRestartGroup.changed(iVar);
            } else {
                changedInstance3 = startRestartGroup.changedInstance(iVar);
            }
            if (changedInstance3) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance2 = startRestartGroup.changed(gVar);
            } else {
                changedInstance2 = startRestartGroup.changedInstance(gVar);
            }
            if (changedInstance2) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(cVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(cVar);
            }
            if (changedInstance) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        boolean z4 = true;
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1552716198, i2, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.NavigationSetting (ReaderMoreSetting.kt:217)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(gVar, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(androidx.compose.foundation.layout.f2.s(aVar, x0.i.g(20), x0.i.g(16)), 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1224400529);
            if ((i2 & 112) != 32 && ((i2 & 64) == 0 || !startRestartGroup.changedInstance(gVar))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if ((i2 & 14) != 4 && ((i2 & 8) == 0 || !startRestartGroup.changedInstance(iVar))) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean z5 = z2 | z3;
            if ((i2 & 896) != 256 && ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(cVar))) {
                z4 = false;
            }
            boolean changedInstance4 = z5 | z4 | startRestartGroup.changedInstance(coroutineScope);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.e0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit m;
                        m = m0.m(sm4.g.this, iVar, cVar, coroutineScope);
                        return m;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(h, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
            g5.e(b2, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            v(boxScopeInstance.b(aVar, aVar2.h()), l(mutableState), startRestartGroup, sm4.g.g << 3);
            Modifier b4 = boxScopeInstance.b(aVar, aVar2.f());
            androidx.compose.ui.layout.p0 b5 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.l(), startRestartGroup, 0);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, b4);
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
            Composer b6 = g5.b(startRestartGroup);
            g5.e(b6, b5, companion2.c());
            g5.e(b6, currentCompositionLocalMap2, companion2.e());
            Function2 b7 = companion2.b();
            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a4))) {
                b6.updateRememberedValue(Integer.valueOf(a4));
                b6.apply(Integer.valueOf(a4), b7);
            }
            g5.e(b6, e2, companion2.d());
            w2 w2Var = w2.b;
            composer2 = startRestartGroup;
            a6.j(l(mutableState).b(), (Modifier) null, ((zl4.b) startRestartGroup.consume(zl4.r.w())).q(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131058);
            z0.g(org.jetbrains.compose.resources.c.a(d2.h(f2.a.a), composer2, 0), (String) null, w2Var.b(androidx.compose.foundation.layout.f2.v(aVar, x0.i.g(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), aVar2.i()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, ((zl4.b) composer2.consume(zl4.r.w())).q(), 0, 2, (Object) null), 0, composer2, 48, 184);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = m0.n(cm4.i.this, gVar, cVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }
}
