package com.dragon.read.kmp.reader.ui.menu.moresettings;

import androidx.compose.foundation.gestures.s2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.ui.menu.ui.PullDownBoxKt;
import com.dragon.read.reader.f1;
import com.dragon.read.reader.m3;
import com.ss.ttm.player.MediaPlayer;
import i25.u0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProgressTypePanelKt {
    static {
        Covode.recordClassIndex(608619);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(org.jetbrains.compose.resources.i iVar, boolean z, Function1 function1, int i, Composer composer, int i2) {
        d(iVar, z, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(y yVar, Function1 function1, int i, Composer composer, int i2) {
        f(yVar, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(y yVar, Function1 function1, int i, Composer composer, int i2) {
        f(yVar, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ y a;
        final /* synthetic */ cm4.i b;
        final /* synthetic */ Function1<Integer, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        a(y yVar, cm4.i iVar, Function1<? super Integer, Unit> function1) {
            this.a = yVar;
            this.b = iVar;
            this.c = function1;
        }

        /* renamed from: com.dragon.read.kmp.reader.ui.menu.moresettings.ProgressTypePanelKt$a$a, reason: collision with other inner class name */
        static final class C0053a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ y a;
            final /* synthetic */ cm4.i b;
            final /* synthetic */ Function1<Integer, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            C0053a(y yVar, cm4.i iVar, Function1<? super Integer, Unit> function1) {
                this.a = yVar;
                this.b = iVar;
                this.c = function1;
            }

            /* renamed from: com.dragon.read.kmp.reader.ui.menu.moresettings.ProgressTypePanelKt$a$a$a, reason: collision with other inner class name */
            static final class C0054a implements Function4<androidx.compose.foundation.layout.r, s2, Composer, Integer, Unit> {
                final /* synthetic */ y a;
                final /* synthetic */ cm4.i b;
                final /* synthetic */ Function1<Integer, Unit> c;

                /* JADX WARN: Multi-variable type inference failed */
                C0054a(y yVar, cm4.i iVar, Function1<? super Integer, Unit> function1) {
                    this.a = yVar;
                    this.b = iVar;
                    this.c = function1;
                }

                /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v23 ??, still in use, count: 1, list:
                      (r1v23 ?? I:java.lang.Object) from 0x0176: INVOKE (r53v0 ?? I:androidx.compose.runtime.Composer), (r1v23 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:313)
                    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
                    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
                    	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
                    	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
                    */
                public final void g(
                /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v23 ??, still in use, count: 1, list:
                      (r1v23 ?? I:java.lang.Object) from 0x0176: INVOKE (r53v0 ?? I:androidx.compose.runtime.Composer), (r1v23 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:313)
                    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
                    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
                    	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
                    */
                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r51v0 ??
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
                    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    */

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit j(Function1 function1) {
                    function1.invoke(Boolean.TRUE);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit o(Function1 function1) {
                    function1.invoke(Boolean.FALSE);
                    return Unit.INSTANCE;
                }

                private static final int l(MutableState<Integer> mutableState) {
                    return ((Number) mutableState.getValue()).intValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit h(com.dragon.read.kmp.reader.ui.menu.ui.c cVar, y yVar) {
                    cVar.a(yVar, true);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit i(Function1 function1, boolean z) {
                    function1.invoke(Boolean.FALSE);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit k(Function1 function1, boolean z) {
                    function1.invoke(Boolean.TRUE);
                    return Unit.INSTANCE;
                }

                private static final void m(MutableState<Integer> mutableState, int i) {
                    mutableState.setValue(Integer.valueOf(i));
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, s2 s2Var, Composer composer, Integer num) {
                    g(rVar, s2Var, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit n(cm4.i iVar, CoroutineScope coroutineScope, Function1 function1, com.dragon.read.kmp.reader.ui.menu.ui.c cVar, y yVar, MutableState mutableState, boolean z) {
                    m(mutableState, ProgressTypePanelKt.k(iVar, z, coroutineScope));
                    function1.invoke(Integer.valueOf(l(mutableState)));
                    cVar.a(yVar, true);
                    return Unit.INSTANCE;
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
                        ComposerKt.traceEventStart(-1279749107, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ProgressTypePanel.<anonymous>.<anonymous> (ProgressTypePanel.kt:83)");
                    }
                    y yVar = this.a;
                    PullDownBoxKt.l(yVar, null, null, androidx.compose.runtime.internal.t.e(-1516549140, true, new C0054a(yVar, this.b, this.c), composer, 54), composer, 3072, 6);
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
                    ComposerKt.traceEventStart(40059228, i, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ProgressTypePanel.<anonymous> (ProgressTypePanel.kt:82)");
                }
                com.dragon.read.kmp.reader.state.t.f(androidx.compose.runtime.internal.t.e(-1279749107, true, new C0053a(this.a, this.b, this.c), composer, 54), composer, 6);
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
    public static final int k(cm4.i iVar, boolean z, CoroutineScope coroutineScope) {
        int i;
        String str;
        lm4.i f = iVar.f().f();
        int j = f.j();
        if (z) {
            i = 2;
        } else {
            i = 1;
        }
        if (j != i) {
            f.M(i);
            u0.a.X();
            kotlinx.coroutines.i.e(coroutineScope, null, null, new ProgressTypePanelKt$updateProgressType$1(null), 3, null);
            um4.a aVar = um4.a.a;
            boolean a2 = iVar.a().a();
            String b = iVar.a().b();
            if (z) {
                str = "count";
            } else {
                str = "percent";
            }
            aVar.b(a2, b, "reader_progress", new ym4.a("result", str));
            com.dragon.read.kmp.k.a("ProgressTypePanel", "update selectTypeState to " + i);
            return i;
        }
        com.dragon.read.kmp.k.a("ProgressTypePanel", "update selectTypeState is " + j);
        return j;
    }

    public static final void f(final y params, final Function1<? super Integer, Unit> onProgressTypeChanged, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(onProgressTypeChanged, "onProgressTypeChanged");
        Composer startRestartGroup = composer.startRestartGroup(-1990047631);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(params)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onProgressTypeChanged)) {
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
                ComposerKt.traceEventStart(-1990047631, i2, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ProgressTypePanel (ProgressTypePanel.kt:79)");
            }
            cm4.i a2 = cm4.j.a(startRestartGroup, 0);
            if (a2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.p
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit g;
                            g = ProgressTypePanelKt.g(y.this, onProgressTypeChanged, i, (Composer) obj, ((Integer) obj2).intValue());
                            return g;
                        }
                    });
                    return;
                }
                return;
            }
            ym4.f.c("ProgressTypePanel", params, androidx.compose.runtime.internal.t.e(40059228, true, new a(params, a2, onProgressTypeChanged), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h;
                    h = ProgressTypePanelKt.h(y.this, onProgressTypeChanged, i, (Composer) obj, ((Integer) obj2).intValue());
                    return h;
                }
            });
        }
    }

    public static final /* synthetic */ void i(org.jetbrains.compose.resources.i iVar, boolean z, Function1 function1, Composer composer, int i) {
        d(iVar, z, function1, composer, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final org.jetbrains.compose.resources.i iVar, final boolean z, final Function1<? super Boolean, Unit> function1, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        long o;
        long O0;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(997541582);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(iVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(997541582, i2, -1, "com.dragon.read.kmp.reader.ui.menu.moresettings.ItemTitle (ProgressTypePanel.kt:219)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 22;
            Modifier h = SizeKt.h(SizeKt.i(aVar, x0.i.g(f)), 0.0f, 1, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, h);
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
            g5.e(b, i6, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            String c = org.jetbrains.compose.resources.j.c(iVar, startRestartGroup, i2 & 14);
            if (z) {
                startRestartGroup.startReplaceGroup(-2101760321);
                o = ((zl4.b) startRestartGroup.consume(zl4.r.w())).u();
            } else {
                startRestartGroup.startReplaceGroup(-2101758973);
                o = ((zl4.b) startRestartGroup.consume(zl4.r.w())).o();
            }
            startRestartGroup.endReplaceGroup();
            a6.j(c, boxScopeInstance.b(aVar, aVar2.h()), o, x0.x.h(16), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3072, 0, 131056);
            wg4.n nVar = new wg4.n(((zl4.b) startRestartGroup.consume(zl4.r.w())).u(), org.jetbrains.compose.resources.c.b(f1.j(m3.a), startRestartGroup, 0), (DefaultConstructorMarker) null);
            if (pm4.q.a.a(((Number) startRestartGroup.consume(zl4.r.A())).intValue())) {
                startRestartGroup.startReplaceGroup(-2101742622);
                O0 = ((qg4.n) startRestartGroup.consume(zl4.r.s())).i1();
            } else {
                startRestartGroup.startReplaceGroup(-2101741086);
                O0 = ((qg4.n) startRestartGroup.consume(zl4.r.s())).O0();
            }
            startRestartGroup.endReplaceGroup();
            wg4.w wVar = new wg4.w(O0, (DefaultConstructorMarker) null);
            float g = x0.i.g(f);
            float g2 = x0.i.g(f);
            Modifier b3 = boxScopeInstance.b(aVar, aVar2.f());
            int i7 = i2 >> 3;
            composer2 = startRestartGroup;
            wg4.r.d(z, function1, nVar, wVar, g, g2, b3, startRestartGroup, (i7 & 14) | 221184 | (i7 & 112), 0);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e2;
                    e2 = ProgressTypePanelKt.e(iVar, z, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e2;
                }
            });
        }
    }
}
