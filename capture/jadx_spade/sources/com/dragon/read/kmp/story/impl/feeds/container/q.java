package com.dragon.read.kmp.story.impl.feeds.container;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.z0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.story.impl.feeds.container.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    static {
        Covode.recordClassIndex(609262);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(LoadStatus loadStatus, mg4.b bVar, Function0 function0, Function2 function2, int i, int i2, Composer composer, int i3) {
        b(loadStatus, bVar, function0, function2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function0<Unit> a;

        a(Function0<Unit> function0) {
            this.a = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        private static final Function0<Unit> d(MutableState<Function0<Unit>> mutableState) {
            return (Function0) mutableState.getValue();
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
                    ComposerKt.traceEventStart(-294425237, i, -1, "com.dragon.read.kmp.story.impl.feeds.container.StoryLoadLayout.<anonymous> (StoryLoadLayout.kt:45)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier a = WindowInsetsPadding_androidKt.a(SizeKt.f(aVar, 0.0f, 1, (Object) null));
                final Function0<Unit> function0 = this.a;
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, a);
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
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, f);
                Function0 a5 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a5);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, i3, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                mg4.q.j(composer, 0);
                composer.endNode();
                composer.startReplaceGroup(1849434622);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.container.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = q.a.c(Function0.this);
                            return c;
                        }
                    }, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composer.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                composer.endReplaceGroup();
                Modifier i4 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(54));
                com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
                float f2 = 16;
                Modifier v = f2.v(BackgroundKt.d(i4, cVar.b(composer, 6).z(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f2), 0.0f, x0.i.g(f2), 0.0f, 10, (Object) null);
                p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a6 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, v);
                Function0 a7 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a7);
                } else {
                    composer.useNode();
                }
                Composer b5 = g5.b(composer);
                g5.e(b5, i5, companion.c());
                g5.e(b5, currentCompositionLocalMap3, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a6))) {
                    b5.updateRememberedValue(Integer.valueOf(a6));
                    b5.apply(Integer.valueOf(a6), b6);
                }
                g5.e(b5, e3, companion.d());
                z0.g(org.jetbrains.compose.resources.c.a(d2.N(f2.a.a), composer, 0), "返回", ClickableKt.clickable-oSLSa3U$default(boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(24)), aVar2.h()), true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, d(mutableState), 14, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, cVar.b(composer, 6).k(), 0, 2, (Object) null), 0, composer, 48, 184);
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
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> a;

        b(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.a = function2;
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
                    ComposerKt.traceEventStart(-114304657, i, -1, "com.dragon.read.kmp.story.impl.feeds.container.StoryLoadLayout.<anonymous> (StoryLoadLayout.kt:76)");
                }
                Function2<Composer, Integer, Unit> function2 = this.a;
                if (function2 != null) {
                    function2.invoke(composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final com.dragon.read.kmp.compose.common.load.LoadStatus r21, mg4.b r22, final kotlin.jvm.functions.Function0<kotlin.Unit> r23, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.q.b(com.dragon.read.kmp.compose.common.load.LoadStatus, mg4.b, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
