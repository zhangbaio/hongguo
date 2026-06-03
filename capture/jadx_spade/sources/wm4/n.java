package wm4;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.bookmall.l5;
import com.dragon.read.component.biz.impl.bookmall.r4;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.service.d1;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w0.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    static {
        Covode.recordClassIndex(608669);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(o oVar, int i, Composer composer, int i2) {
        A(oVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(int i, Composer composer, int i2) {
        m(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(o oVar, int i, Composer composer, int i2) {
        p(oVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(u uVar, int i, Composer composer, int i2) {
        r(uVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(o oVar, int i, Composer composer, int i2) {
        w(oVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(t tVar) {
        tVar.Q0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o n(State<o> state) {
        return (o) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(t tVar) {
        tVar.Q0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(t tVar) {
        tVar.Q0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(t tVar) {
        tVar.T0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(t tVar, u uVar) {
        tVar.S0(uVar);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ State<o> a;

        a(State<o> state) {
            this.a = state;
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
                    ComposerKt.traceEventStart(-1394707609, i, -1, "com.dragon.read.kmp.relatedwrok.RelatedWork2ColCard.<anonymous> (RelatedWork2ColCard.kt:55)");
                }
                n.A(n.n(this.a), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void m(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(-69589320);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-69589320, i, -1, "com.dragon.read.kmp.relatedwrok.RelatedWork2ColCard (RelatedWork2ColCard.kt:51)");
            }
            pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(-1394707609, true, new a(FlowExtKt.b(((t) f2.d.b(t.class, (ViewModelStoreOwner) null, (String) null, (ViewModelProvider.Factory) null, (CreationExtras) null, startRestartGroup, 0, 30)).a, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7)), startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: wm4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = n.o(i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(t tVar, u uVar, Context context) {
        tVar.R0(uVar, context);
        return Unit.INSTANCE;
    }

    private static final void p(final o oVar, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-420229713);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(oVar)) {
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
                ComposerKt.traceEventStart(-420229713, i2, -1, "com.dragon.read.kmp.relatedwrok.RelatedWork2ColCardContentArea (RelatedWork2ColCard.kt:152)");
            }
            Iterator<u> it2 = oVar.f.iterator();
            while (it2.hasNext()) {
                r(it2.next(), startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: wm4.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = n.q(o.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(final o oVar, Composer composer, final int i) {
        int i2;
        boolean z;
        long x;
        Modifier modifier;
        float f;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1535687413);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(oVar)) {
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
                ComposerKt.traceEventStart(1535687413, i2, -1, "com.dragon.read.kmp.relatedwrok.RelatedWork2ColCardUi (RelatedWork2ColCard.kt:61)");
            }
            boolean d = d1.d((Theme) startRestartGroup.consume(rg4.e.l()));
            final t tVar = (t) f2.d.b(t.class, (ViewModelStoreOwner) null, (String) null, (ViewModelProvider.Factory) null, (CreationExtras) null, startRestartGroup, 0, 30);
            Modifier modifier2 = Modifier.Companion;
            Modifier a2 = androidx.compose.ui.draw.e.a(SizeKt.h(modifier2, 0.0f, 1, (Object) null), k.g.c(x0.i.g(oVar.b)));
            l0 l0Var = oVar.g;
            startRestartGroup.startReplaceGroup(-1673133525);
            if (l0Var == null) {
                x = og4.a.a.h(startRestartGroup, og4.a.b).w();
            } else {
                x = l0Var.x();
            }
            startRestartGroup.endReplaceGroup();
            Modifier d2 = BackgroundKt.d(a2, x, (f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(tVar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: wm4.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit B;
                        B = n.B(t.this);
                        return B;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: wm4.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit C;
                        C = n.C();
                        return C;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier3 = ClickableKt.combinedClickable-hoGz1lA$default(d2, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 239, (Object) null);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i4 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier3);
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
            g5.e(b, i4, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                b.updateRememberedValue(Integer.valueOf(a3));
                b.apply(Integer.valueOf(a3), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            startRestartGroup.startReplaceGroup(-1065436895);
            if (!d) {
                f = 0.0f;
                modifier = modifier2;
                LoadImageKt.g(oVar.c, "related work card background", (com.dragon.read.kmp.compose.common.image.n) null, SizeKt.i(SizeKt.h(modifier2, 0.0f, 1, (Object) null), x0.i.g(oVar.d)), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 48, 116);
            } else {
                modifier = modifier2;
                f = 0.0f;
            }
            startRestartGroup.endReplaceGroup();
            Modifier s = androidx.compose.foundation.layout.f2.s(SizeKt.h(modifier, f, 1, (Object) null), x0.i.g(12), x0.i.g(16));
            p0 a5 = x.a(androidx.compose.foundation.layout.e.a.i(), aVar.k(), startRestartGroup, 0);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
            c0 c0Var = c0.b;
            int i5 = i2 & 14;
            w(oVar, startRestartGroup, i5);
            p(oVar, startRestartGroup, i5);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: wm4.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit D;
                    D = n.D(o.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return D;
                }
            });
        }
    }

    private static final void r(final u uVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        org.jetbrains.compose.resources.b L;
        long x;
        long x2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1849471943);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(uVar)) {
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
                ComposerKt.traceEventStart(-1849471943, i2, -1, "com.dragon.read.kmp.relatedwrok.RelatedWork2ColCardItem (RelatedWork2ColCard.kt:161)");
            }
            boolean d = d1.d((Theme) startRestartGroup.consume(rg4.e.l()));
            final t tVar = (t) f2.d.b(t.class, (ViewModelStoreOwner) null, (String) null, (ViewModelProvider.Factory) null, (CreationExtras) null, startRestartGroup, 0, 30);
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.g());
            Modifier.a aVar = Modifier.Companion;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(uVar.f), 7, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(tVar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: wm4.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit s;
                        s = n.s(t.this);
                        return s;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changedInstance2 = startRestartGroup.changedInstance(tVar) | startRestartGroup.changedInstance(uVar) | startRestartGroup.changedInstance(context);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: wm4.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit t;
                        t = n.t(t.this, uVar, context);
                        return t;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.combinedClickable-hoGz1lA$default(v, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 239, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance3 = startRestartGroup.changedInstance(tVar) | startRestartGroup.changedInstance(uVar);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: wm4.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit u;
                        u = n.u(t.this, uVar);
                        return u;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier b = hk4.c.b(modifier, uVar, (Function0) rememberedValue3);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.e h = eVar.h();
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 b2 = r2.b(h, aVar2.l(), startRestartGroup, 0);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, b);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e, companion.d());
            w2 w2Var = w2.b;
            if (d) {
                L = r4.K(l5.a);
            } else {
                L = r4.L(l5.a);
            }
            String str = uVar.b;
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            nVar.e = L;
            Unit unit = Unit.INSTANCE;
            LoadImageKt.g(str, "related work card item cover", nVar, androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.x(aVar, x0.i.g(44)), x0.i.g(61)), k.g.c(x0.i.g(6))), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 48, 112);
            Modifier v2 = androidx.compose.foundation.layout.f2.v(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), x0.i.g(8), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            p0 a4 = x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, v2);
            Function0 a6 = companion.a();
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
            g5.e(b5, a4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                b5.updateRememberedValue(Integer.valueOf(a5));
                b5.apply(Integer.valueOf(a5), b6);
            }
            g5.e(b5, e2, companion.d());
            c0 c0Var = c0.b;
            float f = 4;
            Modifier v3 = androidx.compose.foundation.layout.f2.v(aVar, 0.0f, 0.0f, 0.0f, x0.i.g(f), 7, (Object) null);
            String str2 = uVar.c;
            l0 l0Var = uVar.h;
            startRestartGroup.startReplaceGroup(-1786425079);
            if (l0Var == null) {
                x = og4.a.a.h(startRestartGroup, og4.a.b).k();
            } else {
                x = l0Var.x();
            }
            startRestartGroup.endReplaceGroup();
            long h2 = x0.x.h(14);
            c0.a aVar3 = androidx.compose.ui.text.font.c0.b;
            androidx.compose.ui.text.font.c0 e3 = aVar3.e();
            s.a aVar4 = w0.s.b;
            a6.j(str2, v3, x, h2, (y) null, e3, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199728, 3120, 120784);
            Modifier v4 = androidx.compose.foundation.layout.f2.v(aVar, 0.0f, 0.0f, 0.0f, x0.i.g(f), 7, (Object) null);
            String str3 = uVar.d;
            l0 l0Var2 = uVar.i;
            startRestartGroup.startReplaceGroup(-1786413010);
            if (l0Var2 == null) {
                x2 = og4.a.a.h(startRestartGroup, og4.a.b).X0();
            } else {
                x2 = l0Var2.x();
            }
            startRestartGroup.endReplaceGroup();
            a6.j(str3, v4, x2, x0.x.h(12), (y) null, aVar3.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199728, 3120, 120784);
            composer2 = startRestartGroup;
            a6.j(uVar.e, aVar, og4.a.a.h(startRestartGroup, og4.a.b).Y(), x0.x.h(12), (y) null, aVar3.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199728, 3120, 120784);
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
            endRestartGroup.a(new Function2() { // from class: wm4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v5;
                    v5 = n.v(u.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return v5;
                }
            });
        }
    }

    private static final void w(final o oVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        m0 m0Var;
        long x;
        long x2;
        org.jetbrains.compose.resources.b N;
        long x3;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1892601227);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(oVar)) {
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
                ComposerKt.traceEventStart(1892601227, i2, -1, "com.dragon.read.kmp.relatedwrok.RelatedWork2ColCardTopArea (RelatedWork2ColCard.kt:100)");
            }
            boolean d = d1.d((Theme) startRestartGroup.consume(rg4.e.l()));
            final t tVar = (t) f2.d.b(t.class, (ViewModelStoreOwner) null, (String) null, (ViewModelProvider.Factory) null, (CreationExtras) null, startRestartGroup, 0, 30);
            startRestartGroup.startReplaceGroup(2018622577);
            l0 l0Var = oVar.h;
            if (l0Var != null) {
                m0.a aVar = m0.b;
                if (l0Var == null) {
                    x3 = og4.a.a.h(startRestartGroup, og4.a.b).k();
                } else {
                    x3 = l0Var.x();
                }
                m0Var = aVar.b(x3, androidx.compose.ui.graphics.y.a.z());
            } else {
                m0Var = null;
            }
            startRestartGroup.endReplaceGroup();
            Modifier.a aVar2 = Modifier.Companion;
            float f = 12;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar2, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(f), 7, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(tVar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: wm4.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit x4;
                        x4 = n.x(t.this);
                        return x4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance2 = startRestartGroup.changedInstance(tVar);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: wm4.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit y;
                        y = n.y(t.this);
                        return y;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.combinedClickable-hoGz1lA$default(v, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 239, (Object) null);
            e.a aVar3 = androidx.compose.ui.e.a;
            p0 i4 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
            g5.e(b, i4, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier b3 = boxScopeInstance.b(SizeKt.F(aVar2, (e.b) null, false, 3, (Object) null), aVar3.h());
            String str = oVar.a;
            l0 l0Var2 = oVar.h;
            startRestartGroup.startReplaceGroup(119339835);
            if (l0Var2 == null) {
                x = og4.a.a.h(startRestartGroup, og4.a.b).k();
            } else {
                x = l0Var2.x();
            }
            long j = x;
            startRestartGroup.endReplaceGroup();
            long h = x0.x.h(14);
            c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
            androidx.compose.ui.text.font.c0 a4 = aVar4.a();
            s.a aVar5 = w0.s.b;
            a6.j(str, b3, j, h, (y) null, a4, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar5.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 3120, 120784);
            startRestartGroup.startReplaceGroup(119347819);
            if (oVar.e) {
                Modifier b4 = boxScopeInstance.b(SizeKt.F(aVar2, (e.b) null, false, 3, (Object) null), aVar3.f());
                p0 b5 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar3.l(), startRestartGroup, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, b4);
                Function0 a6 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a6);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b6 = g5.b(startRestartGroup);
                g5.e(b6, b5, companion.c());
                g5.e(b6, currentCompositionLocalMap2, companion.e());
                Function2 b7 = companion.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a5))) {
                    b6.updateRememberedValue(Integer.valueOf(a5));
                    b6.apply(Integer.valueOf(a5), b7);
                }
                g5.e(b6, e2, companion.d());
                w2 w2Var = w2.b;
                Modifier b8 = w2Var.b(SizeKt.F(aVar2, (e.b) null, false, 3, (Object) null), aVar3.i());
                l0 l0Var3 = oVar.h;
                startRestartGroup.startReplaceGroup(1381168700);
                if (l0Var3 == null) {
                    x2 = og4.a.a.h(startRestartGroup, og4.a.b).k();
                } else {
                    x2 = l0Var3.x();
                }
                startRestartGroup.endReplaceGroup();
                a6.j("更多", b8, x2, x0.x.h(12), (y) null, aVar4.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar5.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 3120, 120784);
                if (d) {
                    N = r4.M(l5.a);
                } else {
                    N = r4.N(l5.a);
                }
                composer2 = startRestartGroup;
                z0.g(org.jetbrains.compose.resources.c.a(N, composer2, 0), "related work card more icon", w2Var.b(SizeKt.u(aVar2, x0.i.g(f), x0.i.g(f)), aVar3.i()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0Var, 0, composer2, 48, 184);
                composer2.endNode();
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
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: wm4.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit z2;
                    z2 = n.z(o.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return z2;
                }
            });
        }
    }
}
