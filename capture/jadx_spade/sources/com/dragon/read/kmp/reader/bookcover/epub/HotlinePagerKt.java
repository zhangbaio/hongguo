package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.v2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.y1;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.font.Font;
import com.dragon.read.kmp.reader.state.BookCoverViewModelKt;
import com.dragon.read.kmp.service.KmpFontServiceKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w0.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HotlinePagerKt {
    static {
        Covode.recordClassIndex(608275);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function1 function1, Function1 function12, int i, Composer composer, int i2) {
        d(function1, function12, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function1 function1, Function1 function12, int i, Composer composer, int i2) {
        d(function1, function12, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class c implements Function0<Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.state.a a;
        final /* synthetic */ com.dragon.read.kmp.reader.state.i b;
        final /* synthetic */ int c;
        final /* synthetic */ Function1<com.dragon.read.kmp.reader.state.i, Unit> d;

        /* JADX WARN: Multi-variable type inference failed */
        c(com.dragon.read.kmp.reader.state.a aVar, com.dragon.read.kmp.reader.state.i iVar, int i, Function1<? super com.dragon.read.kmp.reader.state.i, Unit> function1) {
            this.a = aVar;
            this.b = iVar;
            this.c = i;
            this.d = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            s0 s0Var = s0.a;
            s0.b(s0Var, this.a.a, String.valueOf(this.b.p), String.valueOf(this.b.o), null, null, this.c, 24, null);
            this.d.invoke(this.b);
            s0Var.c(this.a.a, "book_quote", "book_cover_page");
        }
    }

    static final class d implements Function0<Unit> {
        final /* synthetic */ Function1<com.dragon.read.kmp.reader.state.i, Unit> a;
        final /* synthetic */ com.dragon.read.kmp.reader.state.i b;
        final /* synthetic */ com.dragon.read.kmp.reader.state.a c;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super com.dragon.read.kmp.reader.state.i, Unit> function1, com.dragon.read.kmp.reader.state.i iVar, com.dragon.read.kmp.reader.state.a aVar) {
            this.a = function1;
            this.b = iVar;
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.a.invoke(this.b);
            s0.a.c(this.c.a, "book_quote_landing_page", "book_cover_page");
        }
    }

    public static final class e implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public e(List list) {
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

    static final class a implements Function3<v2, Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.state.i a;
        final /* synthetic */ am4.c b;
        final /* synthetic */ long c;

        a(com.dragon.read.kmp.reader.state.i iVar, am4.c cVar, long j) {
            this.a = iVar;
            this.b = cVar;
            this.c = j;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(v2 v2Var, Composer composer, Integer num) {
            a(v2Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(v2 BookCoverPagerCard, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(BookCoverPagerCard, "$this$BookCoverPagerCard");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1547262323, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.HotlinePager.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HotlinePager.kt:114)");
                }
                a6.j(this.a.b + "人划线 · 第" + this.a.n + (char) 31456, (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, new g3(androidx.compose.ui.graphics.l0.n(this.c, 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), this.b.t, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777212, (DefaultConstructorMarker) null), composer, 0, 0, 65534);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.reader.state.i a;
        final /* synthetic */ am4.c b;
        final /* synthetic */ long c;

        b(com.dragon.read.kmp.reader.state.i iVar, am4.c cVar, long j) {
            this.a = iVar;
            this.b = cVar;
            this.c = j;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r BookCoverPagerCard, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(BookCoverPagerCard, "$this$BookCoverPagerCard");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2026184188, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.HotlinePager.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HotlinePager.kt:96)");
                }
                String str = this.a.a;
                long j = this.b.s;
                long h = x0.x.h(32);
                g3 g3Var = new g3(this.c, j, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, x0.x.h(2), (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, h, (w0.q) null, (androidx.compose.ui.text.l0) null, new w0.g(g.a.b.a(), g.d.b.a(), (DefaultConstructorMarker) null), 0, 0, (w0.r) null, 15597436, (DefaultConstructorMarker) null);
                a6.j(str, (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) KmpFontServiceKt.a(Font.FZShengShiKaiShuS_DB_GB.getFontFamily(), composer, 0).getValue(), 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 2, 0, (Function1) null, g3Var, composer, 0, 3120, 55230);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final class f implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ am4.c b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ com.dragon.read.kmp.reader.state.a f;
        final /* synthetic */ Function1 g;
        final /* synthetic */ Function1 h;

        public f(List list, am4.c cVar, long j, long j2, long j3, com.dragon.read.kmp.reader.state.a aVar, Function1 function1, Function1 function12) {
            this.a = list;
            this.b = cVar;
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = aVar;
            this.g = function1;
            this.h = function12;
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
                i3 = i2 | i5;
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
                int i6 = (i3 & 112) | (i3 & 14);
                com.dragon.read.kmp.reader.state.i iVar = (com.dragon.read.kmp.reader.state.i) this.a.get(i);
                composer.startReplaceGroup(168186534);
                am4.c cVar = this.b;
                boolean z5 = cVar.f;
                float f = cVar.w;
                float f2 = cVar.r;
                long j = this.c;
                long j2 = this.d;
                long j3 = this.e;
                androidx.compose.runtime.internal.a e = androidx.compose.runtime.internal.t.e(-1547262323, true, new a(iVar, cVar, j), composer, 54);
                androidx.compose.runtime.internal.a e2 = androidx.compose.runtime.internal.t.e(2026184188, true, new b(iVar, this.b, this.c), composer, 54);
                composer.startReplaceGroup(-1224400529);
                boolean changedInstance = composer.changedInstance(this.f);
                int i7 = (i6 & 896) ^ 384;
                if ((i7 > 256 && composer.changedInstance(iVar)) || (i6 & 384) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z6 = changedInstance | z2;
                if ((((i6 & 112) ^ 48) > 32 && composer.changed(i)) || (i6 & 48) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean changed = z6 | z3 | composer.changed(this.g);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new c(this.f, iVar, i, this.g);
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-1746271574);
                boolean changed2 = composer.changed(this.h);
                if ((i7 > 256 && composer.changedInstance(iVar)) || (i6 & 384) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean changedInstance2 = changed2 | z4 | composer.changedInstance(this.f);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new d(this.h, iVar, this.f);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                wg4.i.c(z5, f, f2, "更多书摘", "书摘", j, j2, j3, (Function2) null, e, e2, function0, (Function0) rememberedValue2, composer, 805334016, 6, 256);
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

    public static final void d(final Function1<? super com.dragon.read.kmp.reader.state.i, Unit> onQuoteClick, final Function1<? super com.dragon.read.kmp.reader.state.i, Unit> onMoreClick, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        long n;
        long n2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onQuoteClick, "onQuoteClick");
        Intrinsics.checkNotNullParameter(onMoreClick, "onMoreClick");
        Composer startRestartGroup = composer.startRestartGroup(1588526027);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(onQuoteClick)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onMoreClick)) {
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
                ComposerKt.traceEventStart(1588526027, i2, -1, "com.dragon.read.kmp.reader.bookcover.epub.HotlinePager (HotlinePager.kt:37)");
            }
            com.dragon.read.kmp.reader.state.b b2 = BookCoverViewModelKt.b(startRestartGroup, 0);
            final com.dragon.read.kmp.reader.state.a aVar = (com.dragon.read.kmp.reader.state.a) b2.b.getValue();
            final long x = ((androidx.compose.ui.graphics.l0) b2.d.getValue()).x();
            List<com.dragon.read.kmp.reader.state.i> list = aVar.t;
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(list);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = aVar.t;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final List list2 = (List) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (!(!aVar.t.isEmpty())) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.o0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit e2;
                            e2 = HotlinePagerKt.e(Function1.this, onMoreClick, i, (Composer) obj, ((Integer) obj2).intValue());
                            return e2;
                        }
                    });
                    return;
                }
                return;
            }
            LazyListState c2 = androidx.compose.foundation.lazy.y0.c(0, 0, startRestartGroup, 0, 3);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new LinkedHashSet();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Set set = (Set) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            final am4.c cVar = (am4.c) startRestartGroup.consume(zl4.r.x());
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changed2 = startRestartGroup.changed(c2) | startRestartGroup.changedInstance(list2) | startRestartGroup.changedInstance(set) | startRestartGroup.changedInstance(aVar);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new HotlinePagerKt$HotlinePager$2$1(c2, list2, set, aVar, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(c2, list2, (Function2) rememberedValue3, startRestartGroup, 0);
            zl4.s sVar = zl4.s.a;
            int i5 = zl4.s.b;
            boolean a2 = pm4.r.a(sVar.c(startRestartGroup, i5));
            startRestartGroup.startReplaceGroup(1860169703);
            if (a2) {
                n = sVar.b(startRestartGroup, i5).q();
            } else {
                n = androidx.compose.ui.graphics.l0.n(x, 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1860173635);
            if (a2) {
                n2 = ((zl4.b) startRestartGroup.consume(zl4.r.w())).c(startRestartGroup, 0);
            } else {
                n2 = androidx.compose.ui.graphics.l0.n(androidx.compose.ui.graphics.l0.b.i(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            final long j = n2;
            startRestartGroup.endReplaceGroup();
            e.f p = androidx.compose.foundation.layout.e.a.p(x0.i.g(12));
            i2 h = f2.h(cVar.m, 0.0f, 2, (Object) null);
            Modifier then = Modifier.Companion.then(com.dragon.read.kmp.reader.utils.l.b(startRestartGroup, 0));
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changedInstance = startRestartGroup.changedInstance(list2) | startRestartGroup.changedInstance(cVar) | startRestartGroup.changed(x) | startRestartGroup.changed(j) | startRestartGroup.changed(n) | startRestartGroup.changedInstance(aVar);
            final long j2 = n;
            if ((i2 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = changedInstance | z2;
            if ((i2 & 112) == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z5 = z4 | z3;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue4 == companion.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.reader.bookcover.epub.p0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit f2;
                        f2 = HotlinePagerKt.f(list2, cVar, x, j, j2, aVar, onQuoteClick, onMoreClick, (androidx.compose.foundation.lazy.o0) obj);
                        return f2;
                    }
                };
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue4 = function1;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            androidx.compose.foundation.lazy.d.e(then, c2, h, false, p, (e.c) null, (l1) null, false, (y1) null, (Function1) rememberedValue4, composer2, 24576, 488);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = HotlinePagerKt.g(Function1.this, onMoreClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(List list, am4.c cVar, long j, long j2, long j3, com.dragon.read.kmp.reader.state.a aVar, Function1 function1, Function1 function12, androidx.compose.foundation.lazy.o0 LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyRow.f(list.size(), (Function1) null, new e(list), androidx.compose.runtime.internal.t.c(2039820996, true, new f(list, cVar, j, j2, j3, aVar, function1, function12)));
        return Unit.INSTANCE;
    }
}
