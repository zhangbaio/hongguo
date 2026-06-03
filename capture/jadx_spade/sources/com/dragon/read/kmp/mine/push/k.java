package com.dragon.read.kmp.mine.push;

import a0.l;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.mine.push.k;
import com.dragon.read.kmp.service.b1;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pg4.p;
import pg4.t;
import ym4.o;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    static {
        Covode.recordClassIndex(607745);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(int i, Composer composer, int i2) {
        j(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(boolean z, Function1 function1, Modifier modifier, float f, float f2, float f3, long j, long j2, long j3, long j4, int i, int i2, Composer composer, int i3) {
        l(z, function1, modifier, f, f2, f3, j, j2, j3, j4, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(long j, int i, Composer composer, int i2) {
        q(j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(String str, Modifier modifier, boolean z, Function1 function1, int i, Composer composer, int i2) {
        s(str, modifier, z, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(int i, Composer composer, int i2) {
        u(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class b implements gk4.f {
        private final long a;

        @Override // gk4.f
        public long a() {
            return this.a;
        }

        b(long j) {
            this.a = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v() {
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    private static final Function0<Unit> w(MutableState<Function0<Unit>> mutableState) {
        return (Function0) mutableState.getValue();
    }

    private static final float m(State<x0.i> state) {
        return ((x0.i) state.getValue()).m();
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ State<List<Boolean>> b;
        final /* synthetic */ com.dragon.read.kmp.mine.model.f c;

        /* JADX WARN: Multi-variable type inference failed */
        a(float f, State<? extends List<Boolean>> state, com.dragon.read.kmp.mine.model.f fVar) {
            this.a = f;
            this.b = state;
            this.c = fVar;
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
                    ComposerKt.traceEventStart(1951777330, i, -1, "com.dragon.read.kmp.mine.push.ChangeInnerPushContent.<anonymous> (InnerPushPage.kt:76)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                og4.a aVar2 = og4.a.a;
                int i2 = og4.a.b;
                Modifier v = f2.v(BackgroundKt.d(f, aVar2.h(composer, i2).p3(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), 0.0f, x0.i.g(this.a), 0.0f, 0.0f, 13, (Object) null);
                State<List<Boolean>> state = this.b;
                final com.dragon.read.kmp.mine.model.f fVar = this.c;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i3 = eVar.i();
                e.a aVar3 = androidx.compose.ui.e.a;
                p0 a = x.a(i3, aVar3.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, v);
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
                Composer b = g5.b(composer);
                g5.e(b, a, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                c0 c0Var = c0.b;
                k.u(composer, 0);
                float f2 = 16;
                a3.a(SizeKt.i(aVar, x0.i.g(f2)), composer, 6);
                Modifier c = BackgroundKt.c(f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f2), 0.0f, 2, (Object) null), aVar2.h(composer, i2).w(), k.g.c(x0.i.g(8)));
                p0 a4 = x.a(eVar.i(), aVar3.k(), composer, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, c);
                Function0 a6 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a6);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, a4, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                composer.startReplaceGroup(355367345);
                int size = ((Collection) state.getValue()).size();
                for (final int i4 = 0; i4 < size; i4++) {
                    String str = fVar.c.get(i4);
                    Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
                    boolean booleanValue = ((Boolean) ((List) state.getValue()).get(i4)).booleanValue();
                    composer.startReplaceGroup(-1633490746);
                    boolean changedInstance = composer.changedInstance(fVar) | composer.changed(i4);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function1() { // from class: com.dragon.read.kmp.mine.push.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit c2;
                                c2 = k.a.c(com.dragon.read.kmp.mine.model.f.this, i4, ((Boolean) obj).booleanValue());
                                return c2;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    k.s(str, h, booleanValue, (Function1) rememberedValue, composer, 48);
                }
                composer.endReplaceGroup();
                composer.endNode();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(com.dragon.read.kmp.mine.model.f fVar, int i, boolean z) {
            String str;
            fVar.H0(i, z);
            o oVar = o.a;
            ym4.a aVar = new ym4.a();
            aVar.g("clicked_content", fVar.c.get(i));
            if (!z) {
                str = "open";
            } else {
                str = "close";
            }
            aVar.g("result", str);
            Unit unit = Unit.INSTANCE;
            oVar.d("click_mine_setting_element", aVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(1234796609);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1234796609, i, -1, "com.dragon.read.kmp.mine.push.ChangeInnerPushContent (InnerPushPage.kt:71)");
            }
            com.dragon.read.kmp.mine.model.g gVar = new com.dragon.read.kmp.mine.model.g();
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                com.dragon.read.kmp.mine.model.f fVar = (com.dragon.read.kmp.mine.model.f) f2.d.c(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.mine.model.f.class), c, (String) null, gVar, creationExtras, startRestartGroup, 0, 0);
                State collectAsState = SnapshotStateKt.collectAsState(fVar.b, (CoroutineContext) null, startRestartGroup, 0, 1);
                p.e(new pg4.h((t) null, (t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(1951777330, true, new a(b1.a.s(), collectAsState, fVar), startRestartGroup, 54), startRestartGroup, 48);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.push.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = k.k(i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1325656131);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1325656131, i, -1, "com.dragon.read.kmp.mine.push.TitleBar (InnerPushPage.kt:100)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: com.dragon.read.kmp.mine.push.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit v;
                        v = k.v();
                        return v;
                    }
                }, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.a aVar = Modifier.Companion;
            float f = 16;
            Modifier v = f2.v(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(44)), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i2 = m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
            g5.e(b2, i2, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            e1 a4 = com.dragon.read.kmp.compose.common.image.e.a(d2.N(f2.a.a), startRestartGroup, 0);
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(24)), aVar2.h()), true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, w(mutableState), 14, (Object) null);
            m0.a aVar3 = m0.b;
            og4.a aVar4 = og4.a.a;
            int i3 = og4.a.b;
            z0.g(a4, "返回键", modifier, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar3, aVar4.h(startRestartGroup, i3).k(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
            a6.j("关注的人通知", boxScopeInstance.b(aVar, aVar2.e()), aVar4.h(startRestartGroup, i3).C(), x0.x.h(18), (y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131024);
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(1849434622);
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.push.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean x;
                        x = k.x();
                        return Boolean.valueOf(x);
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            ig4.e.e((Function0) rememberedValue2, w(mutableState), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.push.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y;
                    y = k.y(i, (Composer) obj, ((Integer) obj2).intValue());
                    return y;
                }
            });
        }
    }

    public static final void q(final long j, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1551956305);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(j)) {
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
                ComposerKt.traceEventStart(-1551956305, i2, -1, "com.dragon.read.kmp.mine.push.InnerPushPage (InnerPushPage.kt:56)");
            }
            ym4.f.c("InnerPushPage", new b(j), ComposableSingletons$InnerPushPageKt.a.a(), startRestartGroup, 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.push.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r;
                    r = k.r(j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return r;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final String str, final Modifier modifier, final boolean z, final Function1<? super Boolean, Unit> function1, Composer composer, final int i) {
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1199288581);
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
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        if ((i2 & 1155) != 1154) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1199288581, i2, -1, "com.dragon.read.kmp.mine.push.NotifyItemLayout (InnerPushPage.kt:139)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier s = androidx.compose.foundation.layout.f2.s(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(50)), x0.i.g(20), x0.i.g(14));
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i6 = m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i6, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            androidx.compose.ui.text.font.c0 h = androidx.compose.ui.text.font.c0.b.h();
            long h2 = x0.x.h(16);
            og4.a aVar3 = og4.a.a;
            int i7 = og4.a.b;
            a6.j(str, boxScopeInstance.b(aVar, aVar2.h()), aVar3.h(startRestartGroup, i7).k(), h2, (y) null, h, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, (i2 & 14) | 199680, 0, 131024);
            long H0 = aVar3.h(startRestartGroup, i7).H0();
            long A2 = aVar3.h(startRestartGroup, i7).A2();
            long S = aVar3.h(startRestartGroup, i7).S();
            long S2 = aVar3.h(startRestartGroup, i7).S();
            Modifier b4 = boxScopeInstance.b(aVar, aVar2.f());
            int i8 = i2 >> 6;
            l(z, function1, b4, 0.0f, 0.0f, 0.0f, H0, A2, S, S2, startRestartGroup, (i8 & 14) | (i8 & 112), 56);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.push.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t;
                    t = k.t(str, modifier, z, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return t;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z, long j, long j2, float f, float f2, long j3, long j4, float f3, State state, androidx.compose.ui.graphics.drawscope.f Canvas) {
        long j5;
        long j6;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        if (!z) {
            j5 = j;
        } else {
            j5 = j2;
        }
        float M0 = Canvas.M0(f);
        float M02 = Canvas.M0(f2);
        long d = l.d((Float.floatToRawIntBits(M0) << 32) | (Float.floatToRawIntBits(M02) & 4294967295L));
        float f4 = 2;
        float M03 = Canvas.M0(f2) / f4;
        DrawScope.-CC.r(Canvas, j5, 0L, d, a0.a.b((Float.floatToRawIntBits(M03) << 32) | (Float.floatToRawIntBits(M03) & 4294967295L)), (androidx.compose.ui.graphics.drawscope.g) null, 0.0f, (m0) null, 0, 242, (Object) null);
        if (!z) {
            j6 = j3;
        } else {
            j6 = j4;
        }
        float M04 = Canvas.M0(f3) / f4;
        float M05 = Canvas.M0(m(state));
        float M06 = Canvas.M0(f2) / f4;
        DrawScope.-CC.g(Canvas, j6, M04, a0.f.e((Float.floatToRawIntBits(M05) << 32) | (Float.floatToRawIntBits(M06) & 4294967295L)), 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (m0) null, 0, 120, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x03c7, code lost:
    
        if (r10.changed(r12) == false) goto L231;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void l(final boolean r41, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r42, androidx.compose.ui.Modifier r43, float r44, float r45, float r46, long r47, long r49, long r51, long r53, androidx.compose.runtime.Composer r55, final int r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1167
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.push.k.l(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, float, float, float, long, long, long, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
