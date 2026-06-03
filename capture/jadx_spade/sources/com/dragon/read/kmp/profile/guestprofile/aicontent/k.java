package com.dragon.read.kmp.profile.guestprofile.aicontent;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.d0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a3;
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
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import c54.b4;
import c54.d4;
import c54.e4;
import c54.f4;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608111);
            int[] iArr = new int[AiGeneratedVideoGenerationState.values().length];
            try {
                iArr[AiGeneratedVideoGenerationState.GENERATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AiGeneratedVideoGenerationState.GENERATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AiGeneratedVideoGenerationState.FAILED_AND_UN_RETRYABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AiGeneratedVideoGenerationState.FAILED_AND_RETRYABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608110);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(org.jetbrains.compose.resources.b bVar, int i, Composer composer, int i2) {
        z(bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(int i, Composer composer, int i2) {
        j(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(l lVar, int i, Composer composer, int i2) {
        m(lVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(l lVar, int i, Composer composer, int i2) {
        o(lVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(l lVar, Modifier modifier, int i, Composer composer, int i2) {
        s(lVar, modifier, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(l lVar, Modifier modifier, int i, Composer composer, int i2) {
        u(lVar, modifier, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(float f, int i, Composer composer, int i2) {
        w(f, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l k(State<l> state) {
        return (l) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(AiGeneratedVideoViewModel aiGeneratedVideoViewModel) {
        aiGeneratedVideoViewModel.Y0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(AiGeneratedVideoViewModel aiGeneratedVideoViewModel) {
        aiGeneratedVideoViewModel.Z0();
        return Unit.INSTANCE;
    }

    private static final float x(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    public static final c0 C(int i) {
        long b2 = n0.b(i);
        return c0.a.q(c0.b, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), l0.j(l0.n(b2, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(0.8f), l0.j(l0.n(b2, 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(1.0f), l0.j(l0.n(b2, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null)))}, 0.0f, 0.0f, 0, 14, (Object) null);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ State<l> a;

        a(State<l> state) {
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
                    ComposerKt.traceEventStart(1077079526, i, -1, "com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideo2ColCard.<anonymous> (AiGeneratedVideo2ColCard.kt:84)");
                }
                k.o(k.k(this.a), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void j(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-373659595);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-373659595, i, -1, "com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideo2ColCard (AiGeneratedVideo2ColCard.kt:80)");
            }
            t tVar = new t();
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(1077079526, true, new a(FlowExtKt.b(((AiGeneratedVideoViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(AiGeneratedVideoViewModel.class), c, (String) null, tVar, creationExtras, startRestartGroup, 0, 0)).b, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7)), startRestartGroup, 54), startRestartGroup, 48);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = k.l(i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    private static final void m(final l lVar, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(175321990);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(lVar)) {
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
                ComposerKt.traceEventStart(175321990, i2, -1, "com.dragon.read.kmp.profile.guestprofile.aicontent.AiGeneratedVideo2ColCardMiddleIconUi (AiGeneratedVideo2ColCard.kt:189)");
            }
            int i4 = b.a[lVar.n.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3 && i4 != 4) {
                        startRestartGroup.startReplaceGroup(337892348);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(337773587);
                        z(b4.a(d4.a), startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                    }
                } else {
                    startRestartGroup.startReplaceGroup(337536623);
                    z(b4.b(d4.a), startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
            } else {
                startRestartGroup.startReplaceGroup(337375888);
                w(lVar.o, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = k.n(l.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    public static final void w(final float f, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(274953372);
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
                ComposerKt.traceEventStart(274953372, i2, -1, "com.dragon.read.kmp.profile.guestprofile.aicontent.CircularProgressWithText (AiGeneratedVideo2ColCard.kt:235)");
            }
            State e = AnimateAsStateKt.e(f, androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null), 0.0f, "progressAnimation", (Function1) null, startRestartGroup, (i2 & 14) | 3120, 20);
            Modifier.a aVar = Modifier.Companion;
            float f2 = 34;
            Modifier i4 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f2));
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, i4);
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
            g5.e(b2, i5, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier b4 = boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(f2)), aVar2.e());
            og4.a aVar3 = og4.a.a;
            int i6 = og4.a.b;
            float f3 = 2;
            a3.l(1.0f, b4, aVar3.h(startRestartGroup, i6).g0(), x0.i.g(f3), 0L, 0, startRestartGroup, 3078, 48);
            Modifier b5 = boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(f2)), aVar2.e());
            composer2 = startRestartGroup;
            a3.l(x(e), b5, aVar3.h(composer2, i6).r(), x0.i.g(f3), 0L, 0, composer2, 3072, 48);
            Modifier b6 = boxScopeInstance.b(aVar, aVar2.e());
            StringBuilder sb = new StringBuilder();
            sb.append((int) (x(e) * 100));
            sb.append('%');
            a6.j(sb.toString(), b6, aVar3.h(composer2, i6).r(), x.h(10), (y) null, androidx.compose.ui.text.font.c0.b.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131024);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y;
                    y = k.y(f, i, (Composer) obj, ((Integer) obj2).intValue());
                    return y;
                }
            });
        }
    }

    public static final void z(final org.jetbrains.compose.resources.b iconRes, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(iconRes, "iconRes");
        Composer startRestartGroup = composer.startRestartGroup(1577083090);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(iconRes)) {
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
                ComposerKt.traceEventStart(1577083090, i2, -1, "com.dragon.read.kmp.profile.guestprofile.aicontent.GeneratedStateIcon (AiGeneratedVideo2ColCard.kt:222)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 32;
            Modifier i4 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f));
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, i4);
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
            g5.e(b2, i5, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            z0.g(org.jetbrains.compose.resources.c.a(iconRes, startRestartGroup, i2 & 14), "GeneratedStateIcon", BoxScopeInstance.a.b(SizeKt.s(aVar, x0.i.g(f)), aVar2.e()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, startRestartGroup, 48, 248);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit A;
                    A = k.A(iconRes, i, (Composer) obj, ((Integer) obj2).intValue());
                    return A;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c9, code lost:
    
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final com.dragon.read.kmp.profile.guestprofile.aicontent.l r42, androidx.compose.runtime.Composer r43, final int r44) {
        /*
            Method dump skipped, instructions count: 1188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.aicontent.k.o(com.dragon.read.kmp.profile.guestprofile.aicontent.l, androidx.compose.runtime.Composer, int):void");
    }

    public static final void s(final l viewState, final Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-728227056);
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 17) != 16) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-728227056, i2, -1, "com.dragon.read.kmp.profile.guestprofile.aicontent.BottomPreviewButton (AiGeneratedVideo2ColCard.kt:275)");
            }
            float f = 10;
            Modifier h = SizeKt.h(f2.v(modifier, x0.i.g(f), 0.0f, x0.i.g(f), x0.i.g(f), 2, (Object) null), 0.0f, 1, (Object) null);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i4 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
            Modifier a4 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(32)), k.g.c(x0.i.g(8)));
            og4.a aVar2 = og4.a.a;
            int i5 = og4.a.b;
            Modifier d = BackgroundKt.d(a4, aVar2.h(startRestartGroup, i5).N0(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            p0 i6 = androidx.compose.foundation.layout.m.i(aVar.e(), false);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, d);
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
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, i6, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                b4.updateRememberedValue(Integer.valueOf(a5));
                b4.apply(Integer.valueOf(a5), b5);
            }
            g5.e(b4, e2, companion.d());
            String c = org.jetbrains.compose.resources.j.c(f4.a(e4.a), startRestartGroup, 0);
            long h2 = x.h(14);
            androidx.compose.ui.text.font.c0 i7 = androidx.compose.ui.text.font.c0.b.i();
            long r = aVar2.h(startRestartGroup, i5).r();
            composer2 = startRestartGroup;
            a6.j(c, (Modifier) null, r, h2, (y) null, i7, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t;
                    t = k.t(l.this, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return t;
                }
            });
        }
    }

    public static final void u(final l viewState, final Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(382785164);
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 17) != 16) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(382785164, i2, -1, "com.dragon.read.kmp.profile.guestprofile.aicontent.BottomRetryCreateButton (AiGeneratedVideo2ColCard.kt:297)");
            }
            float f = 10;
            Modifier h = SizeKt.h(f2.v(modifier, x0.i.g(f), 0.0f, x0.i.g(f), x0.i.g(f), 2, (Object) null), 0.0f, 1, (Object) null);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i4 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
            Modifier a4 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(32)), k.g.c(x0.i.g(8)));
            og4.a aVar2 = og4.a.a;
            int i5 = og4.a.b;
            Modifier d = BackgroundKt.d(a4, aVar2.h(startRestartGroup, i5).r(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            p0 i6 = androidx.compose.foundation.layout.m.i(aVar.e(), false);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, d);
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
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, i6, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                b4.updateRememberedValue(Integer.valueOf(a5));
                b4.apply(Integer.valueOf(a5), b5);
            }
            g5.e(b4, e2, companion.d());
            String c = org.jetbrains.compose.resources.j.c(f4.x(e4.a), startRestartGroup, 0);
            long h2 = x.h(14);
            androidx.compose.ui.text.font.c0 i7 = androidx.compose.ui.text.font.c0.b.i();
            long T2 = aVar2.h(startRestartGroup, i5).T2();
            composer2 = startRestartGroup;
            a6.j(c, (Modifier) null, T2, h2, (y) null, i7, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v;
                    v = k.v(l.this, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return v;
                }
            });
        }
    }
}
