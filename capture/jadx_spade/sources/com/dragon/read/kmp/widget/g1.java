package com.dragon.read.kmp.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.widget.g1;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g1 {
    static {
        Covode.recordClassIndex(609654);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(List list, float f, Function2 function2, int i, Composer composer, int i2) {
        f(list, f, function2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(z0 z0Var, float f, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        h(z0Var, f, modifier, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(List list, Modifier modifier, float f, float f2, float f3, float f4, androidx.compose.ui.graphics.l0 l0Var, String str, long j, long j2, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        k(list, modifier, f, f2, f3, f4, l0Var, str, j, j2, function2, composer, x2.a(i | 1), x2.a(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(String str, long j, long j2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m(str, j, j2, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(boolean z) {
        return Unit.INSTANCE;
    }

    private static final long r(Composer composer, int i) {
        long d;
        composer.startReplaceGroup(-584379392);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-584379392, i, -1, "com.dragon.read.kmp.widget.defaultContainerBackground (GroupCoverView.kt:215)");
        }
        if (og4.a.a.e(composer, og4.a.b) == Theme.DARK) {
            d = androidx.compose.ui.graphics.n0.d(4280953386L);
        } else {
            d = androidx.compose.ui.graphics.n0.d(4294309365L);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return d;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ List<z0> a;
        final /* synthetic */ float b;
        final /* synthetic */ Function2<Integer, Boolean, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<z0> list, float f, Function2<? super Integer, ? super Boolean, Unit> function2) {
            this.a = list;
            this.b = f;
            this.c = function2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function2 function2, int i, boolean z) {
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i), Boolean.valueOf(z));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            b(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            final int i4 = 0;
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-545121455, i2, -1, "com.dragon.read.kmp.widget.GroupCoverGrid.<anonymous> (GroupCoverView.kt:131)");
                }
                float g = x0.i.g(BoxWithConstraints.g() * 0.4f);
                float g2 = x0.i.g(BoxWithConstraints.f() * 0.4f);
                float f = 2;
                float f2 = 3;
                float g3 = x0.i.g(x0.i.g(BoxWithConstraints.g() - x0.i.g(g * f)) / f2);
                float g4 = x0.i.g(x0.i.g(BoxWithConstraints.f() - x0.i.g(f * g2)) / f2);
                List<z0> list = this.a;
                float f3 = this.b;
                final Function2<Integer, Boolean, Unit> function2 = this.c;
                for (Object obj : list) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    z0 z0Var = (z0) obj;
                    Modifier u = SizeKt.u(androidx.compose.foundation.layout.u1.e(Modifier.Companion, x0.i.g(x0.i.g(x0.i.g(g + g3) * (i4 % 2)) + g3), x0.i.g(x0.i.g(x0.i.g(g2 + g4) * (i4 / 2)) + g4)), g, g2);
                    composer.startReplaceGroup(-1633490746);
                    boolean changed = composer.changed(function2) | composer.changed(i4);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function1() { // from class: com.dragon.read.kmp.widget.f1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                Unit c;
                                c = g1.a.c(Function2.this, i4, ((Boolean) obj2).booleanValue());
                                return c;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    g1.h(z0Var, f3, u, (Function1) rememberedValue, composer, 0, 0);
                    i4 = i5;
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

    static final class b implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ k.f c;
        final /* synthetic */ long d;
        final /* synthetic */ List<z0> e;
        final /* synthetic */ float f;
        final /* synthetic */ Function2<Integer, Boolean, Unit> g;
        final /* synthetic */ String h;
        final /* synthetic */ long i;
        final /* synthetic */ long j;

        /* JADX WARN: Multi-variable type inference failed */
        b(float f, float f2, k.f fVar, long j, List<z0> list, float f3, Function2<? super Integer, ? super Boolean, Unit> function2, String str, long j2, long j3) {
            this.a = f;
            this.b = f2;
            this.c = fVar;
            this.d = j;
            this.e = list;
            this.f = f3;
            this.g = function2;
            this.h = str;
            this.i = j2;
            this.j = j3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1480299977, i2, -1, "com.dragon.read.kmp.widget.GroupCoverView.<anonymous> (GroupCoverView.kt:81)");
                }
                androidx.compose.ui.graphics.e1 a = org.jetbrains.compose.resources.c.a(iy2.c0.f(iy2.e0.a), composer, 0);
                androidx.compose.ui.layout.i b = androidx.compose.ui.layout.i.a.b();
                Modifier.a aVar = Modifier.Companion;
                androidx.compose.foundation.z0.g(a, (String) null, androidx.compose.ui.draw.e.a(androidx.compose.foundation.layout.u1.e(BoxWithConstraints.a(aVar), this.a, this.b), this.c), (androidx.compose.ui.e) null, b, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, composer, 24624, 232);
                Modifier d = BackgroundKt.d(androidx.compose.ui.draw.e.a(BoxWithConstraints.a(aVar), this.c), this.d, (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                List<z0> list = this.e;
                float f = this.f;
                Function2<Integer, Boolean, Unit> function2 = this.g;
                String str = this.h;
                long j = this.i;
                long j2 = this.j;
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, d);
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
                g5.e(b2, i4, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                boolean z2 = false;
                g1.f(CollectionsKt___CollectionsKt.take(list, 4), f, function2, composer, 0);
                composer.startReplaceGroup(938476667);
                if (str == null || str.length() == 0) {
                    z2 = true;
                }
                if (!z2) {
                    g1.m(str, j, j2, androidx.compose.foundation.layout.f2.r(boxScopeInstance.b(aVar, aVar2.n()), x0.i.g(4)), composer, 0, 0);
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
    public static final void f(final List<z0> list, final float f, final Function2<? super Integer, ? super Boolean, Unit> function2, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1945688965);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(f)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1945688965, i2, -1, "com.dragon.read.kmp.widget.GroupCoverGrid (GroupCoverView.kt:129)");
            }
            androidx.compose.foundation.layout.u.c(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), (androidx.compose.ui.e) null, false, androidx.compose.runtime.internal.t.e(-545121455, true, new a(list, f, function2), startRestartGroup, 54), startRestartGroup, 3078, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = g1.g(list, f, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final com.dragon.read.kmp.widget.z0 r27, final float r28, androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.g1.h(com.dragon.read.kmp.widget.z0, float, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(final java.lang.String r33, final long r34, final long r36, androidx.compose.ui.Modifier r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.g1.m(java.lang.String, long, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k(final java.util.List<com.dragon.read.kmp.widget.z0> r33, androidx.compose.ui.Modifier r34, float r35, float r36, float r37, float r38, androidx.compose.ui.graphics.l0 r39, java.lang.String r40, long r41, long r43, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.g1.k(java.util.List, androidx.compose.ui.Modifier, float, float, float, float, androidx.compose.ui.graphics.l0, java.lang.String, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
