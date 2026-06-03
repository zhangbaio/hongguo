package com.dragon.read.kmp.shortvideo.distribution.page.tab.item;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
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
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.service.d1;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RecentSupportSectionKt {
    static {
        Covode.recordClassIndex(609082);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, int i, Composer composer, int i2) {
        j(str, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Modifier modifier, io4.f fVar, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        l(modifier, fVar, z, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(List list, boolean z, Function2 function2, Function2 function22, int i, int i2, Composer composer, int i3) {
        o(list, z, function2, function22, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(List list, boolean z, Function2 function2, Function2 function22, int i, int i2, Composer composer, int i3) {
        o(list, z, function2, function22, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(io4.f fVar, int i, Composer composer, int i2) {
        u(fVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function0<Unit> {
        final /* synthetic */ Function2<io4.f, Integer, Unit> a;
        final /* synthetic */ io4.f b;
        final /* synthetic */ int c;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super io4.f, ? super Integer, Unit> function2, io4.f fVar, int i) {
            this.a = function2;
            this.b = fVar;
            this.c = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.a.invoke(this.b, Integer.valueOf(this.c));
        }
    }

    public static final class c implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public c(List list) {
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
    public static final Unit m(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final class b implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public b(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }

        public final Object a(int i) {
            return this.a.invoke(Integer.valueOf(i), this.b.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(io4.f fVar, int i) {
        Intrinsics.checkNotNullParameter(fVar, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object r(int i, io4.f it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return it2.a;
    }

    public static final class e implements androidx.compose.ui.input.nestedscroll.b {
        e() {
        }

        public long Y(long j, long j2, int i) {
            return j2;
        }

        public /* synthetic */ long Y1(long j, int i) {
            return androidx.compose.ui.input.nestedscroll.a.d(this, j, i);
        }

        public /* synthetic */ Object k0(long j, Continuation continuation) {
            return androidx.compose.ui.input.nestedscroll.a.c(this, j, continuation);
        }

        public Object a1(long j, long j2, Continuation<? super x0.z> continuation) {
            return x0.z.b(j2);
        }
    }

    private static final void j(final String str, Composer composer, final int i) {
        int i2;
        boolean z;
        org.jetbrains.compose.resources.b P;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1795394519);
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
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1795394519, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.AvatarLayout (RecentSupportSection.kt:144)");
            }
            boolean d2 = d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
            Modifier.a aVar = Modifier.Companion;
            Modifier s = SizeKt.s(aVar, x0.i.g(40));
            p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier f = SizeKt.f(ig4.i.c(aVar, x0.i.d(x0.i.g(20)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), 0.0f, 1, (Object) null);
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            if (d2) {
                P = d2.O(f2.a.a);
            } else {
                P = d2.P(f2.a.a);
            }
            nVar.e = P;
            LoadImageKt.g(str, (String) null, nVar, f, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, i2 & 14, 114);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = RecentSupportSectionKt.k(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    private static final void u(final io4.f fVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        String str;
        boolean z2;
        Composer composer3;
        int i3;
        og4.a aVar;
        Modifier modifier;
        String str2;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(854627220);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(fVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        boolean z3 = true;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(854627220, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.SubtitleRow (RecentSupportSection.kt:163)");
            }
            if (fVar.e) {
                str = "No." + fVar.d;
            } else {
                str = "暂未上榜";
            }
            e.c i6 = androidx.compose.ui.e.a.i();
            Modifier modifier2 = Modifier.Companion;
            p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.h(), i6, startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier2);
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
            g5.e(b3, e2, companion.d());
            w2 w2Var = w2.b;
            long h = x0.x.h(12);
            og4.a aVar2 = og4.a.a;
            int i7 = og4.a.b;
            a6.j(str, (Modifier) null, aVar2.h(startRestartGroup, i7).h(), h, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 3072, 3072, 122866);
            startRestartGroup.startReplaceGroup(-2131140416);
            if (fVar.f.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                aVar = aVar2;
                a3.a(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.s(androidx.compose.foundation.layout.f2.t(modifier2, x0.i.g(4), 0.0f, 2, (Object) null), x0.i.g(2)), k.g.f()), aVar.h(startRestartGroup, i7).h(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
                i3 = i7;
                modifier = modifier2;
                composer3 = startRestartGroup;
                a6.j(fVar.f, (Modifier) null, aVar.h(startRestartGroup, i7).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer3, 3072, 3072, 122866);
            } else {
                composer3 = startRestartGroup;
                i3 = i7;
                aVar = aVar2;
                modifier = modifier2;
            }
            composer3.endReplaceGroup();
            Composer composer4 = composer3;
            int i8 = i3;
            if (d1.d(aVar.e(composer4, i8))) {
                str2 = fVar.i;
            } else {
                str2 = fVar.h;
            }
            composer4.startReplaceGroup(-2131121647);
            if (str2.length() <= 0) {
                z3 = false;
            }
            if (z3) {
                float g = x0.i.g(2);
                composer4.startReplaceGroup(-344996060);
                Modifier modifier3 = modifier;
                a3.a(SizeKt.x(modifier3, g), composer4, 0);
                composer4.endReplaceGroup();
                i4 = 12;
                LoadImageKt.g(str2, (String) null, (com.dragon.read.kmp.compose.common.image.n) null, SizeKt.s(modifier3, x0.i.g(12)), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer4, 3072, 118);
            } else {
                i4 = 12;
            }
            composer4.endReplaceGroup();
            composer4.startReplaceGroup(-2131115368);
            Long l = fVar.g;
            if (l != null) {
                composer2 = composer4;
                a6.j(l.toString(), (Modifier) null, aVar.h(composer4, i8).h(), x0.x.h(i4), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3072, 122866);
            } else {
                composer2 = composer4;
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v;
                    v = RecentSupportSectionKt.v(io4.f.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return v;
                }
            });
        }
    }

    public static final class d implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ Function2 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Function2 d;

        public d(List list, Function2 function2, boolean z, Function2 function22) {
            this.a = list;
            this.b = function2;
            this.c = z;
            this.d = function22;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
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
            boolean z5 = true;
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int i6 = (i3 & 112) | (i3 & 14);
                io4.f fVar2 = (io4.f) this.a.get(i);
                composer.startReplaceGroup(-1212456427);
                String str = fVar2.a;
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(this.b);
                int i7 = (i6 & 896) ^ 384;
                if ((i7 > 256 && composer.changed(fVar2)) || (i6 & 384) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z6 = changed | z2;
                int i8 = (i6 & 112) ^ 48;
                if ((i8 > 32 && composer.changed(i)) || (i6 & 48) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z7 = z6 | z3;
                Object rememberedValue = composer.rememberedValue();
                if (z7 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new RecentSupportSectionKt$RecentSupportSection$3$1$1$2$1$1(this.b, fVar2, i, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                EffectsKt.LaunchedEffect(str, (Function2) rememberedValue, composer, 0);
                boolean z8 = this.c;
                composer.startReplaceGroup(-1746271574);
                boolean changed2 = composer.changed(this.d);
                if ((i7 > 256 && composer.changed(fVar2)) || (i6 & 384) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z9 = changed2 | z4;
                if ((i8 <= 32 || !composer.changed(i)) && (i6 & 48) != 32) {
                    z5 = false;
                }
                boolean z10 = z9 | z5;
                Object rememberedValue2 = composer.rememberedValue();
                if (z10 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new a(this.d, fVar2, i);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                RecentSupportSectionKt.l(null, fVar2, z8, (Function0) rememberedValue2, composer, (i6 >> 3) & 112, 1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(List list, Function2 function2, boolean z, Function2 function22, androidx.compose.foundation.lazy.o0 LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyRow.f(list.size(), new b(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.w
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object r;
                r = RecentSupportSectionKt.r(((Integer) obj).intValue(), (io4.f) obj2);
                return r;
            }
        }, list), new c(list), androidx.compose.runtime.internal.t.c(2039820996, true, new d(list, function2, z, function22)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Modifier modifier, final io4.f fVar, final boolean z, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        Modifier modifier3;
        long w;
        Composer startRestartGroup = composer.startRestartGroup(-1718125779);
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(fVar)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        int i9 = i3;
        boolean z3 = true;
        if ((i9 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i9 & 1)) {
            if (i8 != 0) {
                modifier2 = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1718125779, i9, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.RecentSupportCard (RecentSupportSection.kt:111)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(-1559595190);
                w = og4.a.a.h(startRestartGroup, og4.a.b).o();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1559546520);
                w = og4.a.a.h(startRestartGroup, og4.a.b).w();
                startRestartGroup.endReplaceGroup();
            }
            float f = 8;
            Modifier d2 = BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.i(modifier2, x0.i.g(56)), k.g.c(x0.i.g(f))), w, (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i9 & 7168) != 2048) {
                z3 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit m;
                        m = RecentSupportSectionKt.m(Function0.this);
                        return m;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier s = androidx.compose.foundation.layout.f2.s(ClickableKt.clickable-oSLSa3U$default(d2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), x0.i.g(f), x0.i.g(f));
            e.a aVar = androidx.compose.ui.e.a;
            e.c i10 = aVar.i();
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            p0 b2 = r2.b(eVar.h(), i10, startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
            g5.e(b3, e2, companion.d());
            w2 w2Var = w2.b;
            j(fVar.c, startRestartGroup, 0);
            float g = x0.i.g(f);
            startRestartGroup.startReplaceGroup(-344996060);
            Modifier.a aVar2 = Modifier.Companion;
            a3.a(SizeKt.x(aVar2, g), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            p0 a4 = androidx.compose.foundation.layout.x.a(eVar.g(), aVar.k(), startRestartGroup, 6);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, aVar2);
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
            g5.e(b5, e3, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            modifier3 = modifier2;
            a6.j(fVar.b, (Modifier) null, og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 3072, 122834);
            u(fVar, startRestartGroup, 14 & (i9 >> 3));
            startRestartGroup.endNode();
            float g2 = x0.i.g(4);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar2, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = RecentSupportSectionKt.n(modifier4, fVar, z, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final java.util.List<io4.f> r38, final boolean r39, final kotlin.jvm.functions.Function2<? super io4.f, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super io4.f, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.RecentSupportSectionKt.o(java.util.List, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
