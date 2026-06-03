package com.dragon.read.kmp.share.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.lazy.grid.v0;
import androidx.compose.foundation.lazy.grid.w0;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.b1;
import ec4.h0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 {
    static {
        Covode.recordClassIndex(608990);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(String str, List list, Function1 function1, boolean z, int i, Composer composer, int i2) {
        h(str, list, function1, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(bh1.a aVar, Function1 function1, boolean z, boolean z2, b0 b0Var, int i, int i2, Composer composer, int i3) {
        j(aVar, function1, z, z2, b0Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(List list, Function1 function1, boolean z, boolean z2, b0 b0Var, int i, int i2, int i3, Composer composer, int i4) {
        m(list, function1, z, z2, b0Var, i, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(List list, String str, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        p(list, str, i, function1, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final b0 s(List<bh1.a> shareChannelList) {
        int i;
        int i2;
        float f;
        double d2;
        double d3;
        float size;
        int size2;
        float f2;
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        h0.b bVar = h0.Companion;
        if (bVar.a().b) {
            int e = xn4.h0.a.e();
            if (bVar.a().c) {
                i = 50;
            } else {
                i = 48;
            }
            if (bVar.a().d) {
                i2 = 12;
            } else {
                i2 = 14;
            }
            int i3 = 65;
            if (b1.a.f() > 1.0f) {
                i3 = (int) ((65 * r0.f() * 0.96d) + 1);
            }
            if (e >= 600) {
                return new b0(80, i, i2, 4.0f, 0, false, null, 112, null);
            }
            float f3 = e;
            float f4 = i3;
            float f5 = 24;
            if (f3 >= (5.5f * f4) + f5) {
                if (shareChannelList.size() <= 5 && shareChannelList.size() >= 4) {
                    size = (e - (shareChannelList.size() * i3)) - 8;
                    size2 = shareChannelList.size();
                    f2 = size / (size2 - 1);
                } else {
                    d2 = (e - (i3 * 5.5d)) - 8;
                    d3 = 5.0f;
                    f2 = (float) (d2 / d3);
                }
            } else if (f3 >= (f4 * 4.5f) + f5) {
                if (shareChannelList.size() <= 4 && shareChannelList.size() >= 4) {
                    size = (e - (shareChannelList.size() * i3)) - 8;
                    size2 = shareChannelList.size();
                    f2 = size / (size2 - 1);
                } else {
                    d2 = (e - (i3 * 4.5d)) - 8;
                    d3 = 4.0f;
                    f2 = (float) (d2 / d3);
                }
            } else {
                f = 4.0f;
                return new b0(i3, i, i2, f, 0, false, null, 112, null);
            }
            f = f2;
            return new b0(i3, i, i2, f, 0, false, null, 112, null);
        }
        return new b0(60, 48, 12, 20.0f, 0, false, null, 112, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1, bh1.a aVar) {
        function1.invoke(aVar);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;

        a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            long j;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1204876789, i, -1, "com.dragon.read.kmp.share.view.ShareChannelPanel.<anonymous>.<anonymous> (ShareChannelPanel.kt:61)");
                }
                long h = x0.x.h(16);
                c0 a = c0.b.a();
                if (this.a) {
                    j = 4294967295L;
                } else {
                    j = 4278190080L;
                }
                a6.j(this.b, f2.v(Modifier.Companion, x0.i.g(16), x0.i.g(8), 0.0f, 0.0f, 12, (Object) null), n0.d(j), h, (androidx.compose.ui.text.font.y) null, a, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199728, 0, 131024);
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
        final /* synthetic */ bh1.a a;
        final /* synthetic */ b0 b;
        final /* synthetic */ boolean c;

        b(bh1.a aVar, b0 b0Var, boolean z) {
            this.a = aVar;
            this.b = b0Var;
            this.c = z;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            long j;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-517288758, i, -1, "com.dragon.read.kmp.share.view.ShareIcon.<anonymous>.<anonymous> (ShareChannelPanel.kt:175)");
                }
                String str = this.a.b;
                long h = x0.x.h(this.b.c);
                if (this.c) {
                    j = 2583691263L;
                } else {
                    j = 2986344448L;
                }
                a6.j(str, (Modifier) null, n0.d(j), h, (androidx.compose.ui.text.font.y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 0, 0, 131058);
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
    public static final Unit q(List list, Function1 function1, w0 LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        v0.b(LazyVerticalGrid, list.size(), (Function1) null, (Function2) null, (Function1) null, androidx.compose.runtime.internal.t.c(-1093693005, true, new d(list, function1)), 14, (Object) null);
        return Unit.INSTANCE;
    }

    static final class c implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List<bh1.a> a;
        final /* synthetic */ Function1<bh1.a, Unit> b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;
        final /* synthetic */ b0 e;

        c(List<bh1.a> list, Function1<? super bh1.a, Unit> function1, boolean z, boolean z2, b0 b0Var) {
            this.a = list;
            this.b = function1;
            this.c = z;
            this.d = z2;
            this.e = b0Var;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f items, int i, Composer composer, int i2) {
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i3 = 32;
                } else {
                    i3 = 16;
                }
                i2 |= i3;
            }
            if ((i2 & 145) != 144) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1463719238, i2, -1, "com.dragon.read.kmp.share.view.ShareIconList.<anonymous>.<anonymous>.<anonymous> (ShareChannelPanel.kt:133)");
                }
                a0.j(this.a.get(i), this.b, this.c, this.d, this.e, composer, bh1.a.f, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class d implements Function4<androidx.compose.foundation.lazy.grid.w, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List<bh1.a> a;
        final /* synthetic */ Function1<bh1.a, Unit> b;

        d(List<bh1.a> list, Function1<? super bh1.a, Unit> function1) {
            this.a = list;
            this.b = function1;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Integer num, Composer composer, Integer num2) {
            a(wVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.grid.w items, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            Intrinsics.checkNotNullParameter(items, "$this$items");
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 = i2 | i4;
            } else {
                i3 = i2;
            }
            if ((i3 & 145) != 144) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1093693005, i3, -1, "com.dragon.read.kmp.share.view.ShortSeriesShareLandDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShareChannelPanel.kt:198)");
                }
                a0.j(this.a.get(i), this.b, true, true, new b0(80, 52, 14, 16.0f, 0, false, null, 112, null), composer, bh1.a.f | 3456, 0);
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
    public static final Unit n(List list, Function1 function1, boolean z, boolean z2, b0 b0Var, o0 LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        androidx.compose.foundation.lazy.n0.b(LazyRow, list.size(), (Function1) null, (Function1) null, androidx.compose.runtime.internal.t.c(1463719238, true, new c(list, function1, z, z2, b0Var)), 6, (Object) null);
        return Unit.INSTANCE;
    }

    public static final void h(final String title, final List<bh1.a> shareChannelList, final Function1<? super bh1.a, Unit> onClickListener, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Composer startRestartGroup = composer.startRestartGroup(350938982);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(title)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i2 = i7 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(shareChannelList)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i2 |= i6;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(onClickListener)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i2 |= i5;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i2 |= i4;
        }
        if ((i2 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(350938982, i2, -1, "com.dragon.read.kmp.share.view.ShareChannelPanel (ShareChannelPanel.kt:46)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 12;
            Modifier a2 = androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), k.g.e(x0.i.g(f), x0.i.g(f), 0.0f, 0.0f, 12, (Object) null));
            e.m i8 = androidx.compose.foundation.layout.e.a.i();
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 a3 = androidx.compose.foundation.layout.x.a(i8, aVar2.k(), startRestartGroup, 0);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a2);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, a3, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                b2.updateRememberedValue(Integer.valueOf(a4));
                b2.apply(Integer.valueOf(a4), b3);
            }
            g5.e(b2, e, companion.d());
            float f2 = 8;
            Modifier b4 = androidx.compose.foundation.layout.c0.b.b(androidx.compose.ui.draw.e.a(SizeKt.u(f2.v(aVar, 0.0f, x0.i.g(f2), 0.0f, x0.i.g(f2), 5, (Object) null), x0.i.g(36), x0.i.g(4)), k.g.c(x0.i.g(2))), aVar2.g());
            if (z) {
                i3 = 452984831;
            } else {
                i3 = 436207616;
            }
            androidx.compose.foundation.layout.m.b(BackgroundKt.d(b4, n0.b(i3), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
            pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(-1204876789, true, new a(z, title), startRestartGroup, 54), startRestartGroup, 48, 1);
            int i9 = i2 >> 3;
            m(shareChannelList, onClickListener, z, z, s(shareChannelList), 0, startRestartGroup, (i9 & 896) | (i9 & 14) | (i9 & 112) | (i2 & 7168), 32);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.share.view.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i10;
                    i10 = a0.i(title, shareChannelList, onClickListener, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i10;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void p(final java.util.List<bh1.a> r35, java.lang.String r36, final int r37, final kotlin.jvm.functions.Function1<? super bh1.a, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.view.a0.p(java.util.List, java.lang.String, int, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c8, code lost:
    
        if ((r35 & 16) != 0) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final bh1.a r28, final kotlin.jvm.functions.Function1<? super bh1.a, kotlin.Unit> r29, final boolean r30, final boolean r31, com.dragon.read.kmp.share.view.b0 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.view.a0.j(bh1.a, kotlin.jvm.functions.Function1, boolean, boolean, com.dragon.read.kmp.share.view.b0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(final java.util.List<bh1.a> r29, final kotlin.jvm.functions.Function1<? super bh1.a, kotlin.Unit> r30, final boolean r31, final boolean r32, com.dragon.read.kmp.share.view.b0 r33, int r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.view.a0.m(java.util.List, kotlin.jvm.functions.Function1, boolean, boolean, com.dragon.read.kmp.share.view.b0, int, androidx.compose.runtime.Composer, int, int):void");
    }
}
