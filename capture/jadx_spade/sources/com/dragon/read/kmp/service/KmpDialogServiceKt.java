package com.dragon.read.kmp.service;

import androidx.compose.foundation.gestures.s2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpDialogServiceKt {
    private static final Map<String, Function2<Composer, Integer, Unit>> a;
    private static final Map<String, MutableState<s2>> b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, int i, Composer composer, int i2) {
        d(str, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, int i, Composer composer, int i2) {
        i(str, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, int i, Composer composer, int i2) {
        i(str, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(608879);
        a = new LinkedHashMap();
        b = new LinkedHashMap();
    }

    public static final void h(String key) {
        boolean z;
        Intrinsics.checkNotNullParameter(key, "key");
        if (key.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Iterator<T> it2 = a.keySet().iterator();
            while (it2.hasNext()) {
                r0.c((String) it2.next());
            }
            a.clear();
            b.clear();
            return;
        }
        r0.c(key);
        a.remove(key);
        b.remove(key);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ Function3<g, Composer, Integer, Unit> b;
        final /* synthetic */ g c;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Function3<? super g, ? super Composer, ? super Integer, Unit> function3, g gVar) {
            this.a = str;
            this.b = function3;
            this.c = gVar;
        }

        /* renamed from: com.dragon.read.kmp.service.KmpDialogServiceKt$a$a, reason: collision with other inner class name */
        static final class C0059a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ Function3<g, Composer, Integer, Unit> a;
            final /* synthetic */ g b;

            /* JADX WARN: Multi-variable type inference failed */
            C0059a(Function3<? super g, ? super Composer, ? super Integer, Unit> function3, g gVar) {
                this.a = function3;
                this.b = gVar;
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
                        ComposerKt.traceEventStart(437581432, i, -1, "com.dragon.read.kmp.service.showNativeDialog.<anonymous>.<anonymous> (KmpDialogService.kt:52)");
                    }
                    this.a.invoke(this.b, composer, 0);
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
                    ComposerKt.traceEventStart(-478331513, i, -1, "com.dragon.read.kmp.service.showNativeDialog.<anonymous> (KmpDialogService.kt:50)");
                }
                KmpDialogServiceKt.i(this.a, composer, 0);
                pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(437581432, true, new C0059a(this.b, this.c), composer, 54), composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final String l(g1 g1Var, Function3<? super g, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        String valueOf = String.valueOf(content.hashCode());
        if (g1Var == null) {
            g1Var = new g1(false, false, null, false, 15, null);
        }
        a.put(valueOf, androidx.compose.runtime.internal.t.c(-478331513, true, new a(valueOf, content, new g(valueOf))));
        b.put(valueOf, SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null));
        g1Var.b(valueOf);
        r0.d(g1Var);
        return valueOf;
    }

    public static final void d(final String key, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(key, "key");
        Composer startRestartGroup = composer.startRestartGroup(-1275251501);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(key)) {
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
                ComposerKt.traceEventStart(-1275251501, i2, -1, "com.dragon.read.kmp.service.NativeDialogContainer (KmpDialogService.kt:180)");
            }
            Modifier.a aVar = Modifier.Companion;
            androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, aVar);
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
            g5.e(b2, i4, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Function2<Composer, Integer, Unit> function2 = a.get(key);
            startRestartGroup.startReplaceGroup(1939160725);
            if (function2 != null) {
                function2.invoke(startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.service.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e2;
                    e2 = KmpDialogServiceKt.e(key, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final String str, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1116366892);
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
                ComposerKt.traceEventStart(1116366892, i2, -1, "com.dragon.read.kmp.service.handleNestScroll (KmpDialogService.kt:62)");
            }
            MutableState<s2> mutableState = b.get(str);
            if (mutableState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.service.n0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit j;
                            j = KmpDialogServiceKt.j(str, i, (Composer) obj, ((Integer) obj2).intValue());
                            return j;
                        }
                    });
                    return;
                }
                return;
            }
            s2 s2Var = (s2) mutableState.getValue();
            if (s2Var != null) {
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(s2Var);
                if ((i2 & 14) != 4) {
                    z2 = false;
                }
                boolean z3 = changedInstance | z2;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new KmpDialogServiceKt$handleNestScroll$2$1(s2Var, str, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(s2Var, (Function2) rememberedValue, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.service.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = KmpDialogServiceKt.k(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    public static /* synthetic */ String m(g1 g1Var, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            g1Var = null;
        }
        return l(g1Var, function3);
    }
}
