package com.dragon.read.kmp.reader.bookcover.epub;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t2;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.b2;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.ui.util.ScreenUtils;
import com.dragon.read.kmp.reader.bookcover.InsertState;
import com.dragon.read.kmp.reader.bookcover.epub.a1;
import com.dragon.read.kmp.reader.state.BookCoverViewModelKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a1 {
    private static final float a;
    private static final float b;
    private static final float c;
    private static final float d;
    private static final long e;
    private static final String f;
    private static final String g;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(e eVar, int i, Composer composer, int i2) {
        b(eVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(608277);
        a = x0.i.g(37);
        b = x0.i.g(8);
        float f2 = 32;
        c = x0.i.g(x0.i.g(f2) + x0.i.g(12));
        d = x0.i.g(x0.i.g(x0.i.g(16) + x0.i.g(28)) + x0.i.g(f2));
        e = x0.x.h(23);
        f = "book_info_page";
        g = "copyright_info_page";
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ long a;
        final /* synthetic */ com.dragon.read.kmp.reader.state.a b;
        final /* synthetic */ e c;
        final /* synthetic */ MutableState<Boolean> d;

        a(long j, com.dragon.read.kmp.reader.state.a aVar, e eVar, MutableState<Boolean> mutableState) {
            this.a = j;
            this.b = aVar;
            this.c = eVar;
            this.d = mutableState;
        }

        /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a, reason: collision with other inner class name */
        static final class C0036a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
            final /* synthetic */ long a;
            final /* synthetic */ com.dragon.read.kmp.reader.state.a b;
            final /* synthetic */ com.dragon.read.kmp.reader.bookcover.epub.e c;
            final /* synthetic */ MutableState<Boolean> d;

            C0036a(long j, com.dragon.read.kmp.reader.state.a aVar, com.dragon.read.kmp.reader.bookcover.epub.e eVar, MutableState<Boolean> mutableState) {
                this.a = j;
                this.b = aVar;
                this.c = eVar;
                this.d = mutableState;
            }

            /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a$a, reason: collision with other inner class name */
            static final class C0037a implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ String a;
                final /* synthetic */ com.dragon.read.kmp.reader.bookcover.epub.e b;
                final /* synthetic */ Integer c;

                C0037a(String str, com.dragon.read.kmp.reader.bookcover.epub.e eVar, Integer num) {
                    this.a = str;
                    this.b = eVar;
                    this.c = num;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit c(com.dragon.read.kmp.reader.bookcover.epub.e eVar) {
                    eVar.c();
                    return Unit.INSTANCE;
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
                            ComposerKt.traceEventStart(-2067748966, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:131)");
                        }
                        composer.startMovableGroup(1463103135, this.a);
                        String str = a1.f;
                        composer.startReplaceGroup(5004770);
                        boolean changedInstance = composer.changedInstance(this.b);
                        final com.dragon.read.kmp.reader.bookcover.epub.e eVar = this.b;
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.z0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit c;
                                    c = a1.a.C0036a.C0037a.c(e.this);
                                    return c;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceGroup();
                        bm4.o.n(null, str, (Function0) rememberedValue, false, this.c, composer, 48, 9);
                        composer.endMovableGroup();
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
            public static final Unit g(MutableState mutableState) {
                a1.d(mutableState, false);
                return Unit.INSTANCE;
            }

            /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a$c */
            static final class c implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ String a;
                final /* synthetic */ com.dragon.read.kmp.reader.state.a b;
                final /* synthetic */ MutableState<Boolean> c;

                c(String str, com.dragon.read.kmp.reader.state.a aVar, MutableState<Boolean> mutableState) {
                    this.a = str;
                    this.b = aVar;
                    this.c = mutableState;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit e(com.dragon.read.kmp.reader.state.a aVar) {
                    s0.a.c(aVar.a, "publishing_house", a1.f);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    c(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit d(com.dragon.read.kmp.reader.state.a aVar, MutableState mutableState) {
                    a1.d(mutableState, true);
                    s0.a.c(aVar.a, "publishing_info_popup", a1.f);
                    return Unit.INSTANCE;
                }

                public final void c(Composer composer, int i) {
                    boolean z;
                    if ((i & 3) != 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composer.shouldExecute(z, i & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2102902049, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:95)");
                        }
                        composer.startMovableGroup(2040728801, this.a);
                        composer.startReplaceGroup(-1633490746);
                        boolean changedInstance = composer.changedInstance(this.b);
                        final com.dragon.read.kmp.reader.state.a aVar = this.b;
                        final MutableState<Boolean> mutableState = this.c;
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.b1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit d;
                                    d = a1.a.C0036a.c.d(com.dragon.read.kmp.reader.state.a.this, mutableState);
                                    return d;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        Function0 function0 = (Function0) rememberedValue;
                        composer.endReplaceGroup();
                        composer.startReplaceGroup(5004770);
                        boolean changedInstance2 = composer.changedInstance(this.b);
                        final com.dragon.read.kmp.reader.state.a aVar2 = this.b;
                        Object rememberedValue2 = composer.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.c1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit e;
                                    e = a1.a.C0036a.c.e(com.dragon.read.kmp.reader.state.a.this);
                                    return e;
                                }
                            };
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        composer.endReplaceGroup();
                        bm4.x.g(null, function0, (Function0) rememberedValue2, 0, composer, 0, 9);
                        composer.endMovableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }

            /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a$b */
            static final class b implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ String a;
                final /* synthetic */ boolean b;
                final /* synthetic */ int c;
                final /* synthetic */ Function2<Composer, Integer, Unit> d;

                b(String str, boolean z, int i, Function2<? super Composer, ? super Integer, Unit> function2) {
                    this.a = str;
                    this.b = z;
                    this.c = i;
                    this.d = function2;
                }

                /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a$b$a, reason: collision with other inner class name */
                static final class C0038a implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ Function2<Composer, Integer, Unit> a;

                    C0038a(Function2<? super Composer, ? super Integer, Unit> function2) {
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
                                ComposerKt.traceEventStart(1523771362, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:193)");
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

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    a(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void a(Composer composer, int i) {
                    boolean z;
                    int i2;
                    if ((i & 3) != 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composer.shouldExecute(z, i & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1945533685, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:190)");
                        }
                        composer.startMovableGroup(1347098814, this.a);
                        if (this.b) {
                            i2 = -this.c;
                        } else {
                            i2 = this.c;
                        }
                        androidx.compose.runtime.d0.c(zl4.r.v().provides(Integer.valueOf(i2)), androidx.compose.runtime.internal.t.e(1523771362, true, new C0038a(this.d), composer, 54), composer, t2.i | 48);
                        composer.endMovableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }

            /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a$d */
            static final class d implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ String a;
                final /* synthetic */ int b;
                final /* synthetic */ Function2<Composer, Integer, Unit> c;

                d(String str, int i, Function2<? super Composer, ? super Integer, Unit> function2) {
                    this.a = str;
                    this.b = i;
                    this.c = function2;
                }

                /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a$d$a, reason: collision with other inner class name */
                static final class C0039a implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ Function2<Composer, Integer, Unit> a;

                    C0039a(Function2<? super Composer, ? super Integer, Unit> function2) {
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
                                ComposerKt.traceEventStart(174144444, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:164)");
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
                            ComposerKt.traceEventStart(555075855, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:162)");
                        }
                        composer.startMovableGroup(851953285, this.a);
                        androidx.compose.runtime.d0.c(zl4.r.v().provides(Integer.valueOf(this.b)), androidx.compose.runtime.internal.t.e(174144444, true, new C0039a(this.c), composer, 54), composer, t2.i | 48);
                        composer.endMovableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }

            /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a$e */
            static final class e implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ String a;
                final /* synthetic */ int b;
                final /* synthetic */ Function2<Composer, Integer, Unit> c;

                e(String str, int i, Function2<? super Composer, ? super Integer, Unit> function2) {
                    this.a = str;
                    this.b = i;
                    this.c = function2;
                }

                /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.a1$a$a$e$a, reason: collision with other inner class name */
                static final class C0040a implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ Function2<Composer, Integer, Unit> a;

                    C0040a(Function2<? super Composer, ? super Integer, Unit> function2) {
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
                                ComposerKt.traceEventStart(-2012539199, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:178)");
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
                            ComposerKt.traceEventStart(1417459220, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:176)");
                        }
                        composer.startMovableGroup(673678786, this.a);
                        androidx.compose.runtime.d0.c(zl4.r.v().provides(Integer.valueOf(-this.b)), androidx.compose.runtime.internal.t.e(-2012539199, true, new C0040a(this.c), composer, 54), composer, t2.i | 48);
                        composer.endMovableGroup();
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
            public static final Unit h(com.dragon.read.kmp.reader.state.a aVar, MutableState mutableState) {
                s0.a.c(aVar.a, "author_profile", a1.g);
                a1.d(mutableState, false);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit i(com.dragon.read.kmp.reader.state.a aVar, MutableState mutableState) {
                s0.a.c(aVar.a, "publishing_house", a1.g);
                a1.d(mutableState, false);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
                f(vVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void f(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
                int i2;
                boolean z;
                boolean z2;
                int i3;
                boolean z3;
                boolean z4;
                float g;
                x0.i d2;
                float g2;
                int i4;
                Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                if ((i & 6) == 0) {
                    if (composer.changed(BoxWithConstraints)) {
                        i4 = 4;
                    } else {
                        i4 = 2;
                    }
                    i2 = i | i4;
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
                        ComposerKt.traceEventStart(503368008, i2, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous>.<anonymous> (SecondBookCoverKmpView.kt:56)");
                    }
                    Modifier.a aVar = Modifier.Companion;
                    androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.f(aVar, 0.0f, 1, (Object) null), this.a, (f2) null, 2, (Object) null), composer, 0);
                    composer.startReplaceGroup(-1594642417);
                    ScreenUtils screenUtils = ScreenUtils.a;
                    if (screenUtils.i(ig4.f.a(composer, 0)) && !((Boolean) composer.consume(zl4.r.z())).booleanValue()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    composer.endReplaceGroup();
                    if (z2) {
                        i3 = 64;
                    } else {
                        i3 = 20;
                    }
                    float g3 = x0.i.g(i3);
                    float f = BoxWithConstraints.f();
                    x0.e eVar = (x0.e) composer.consume(CompositionLocalsKt.f());
                    int r6 = xf4.e.p3.a().H5().r6();
                    float g4 = x0.i.g(eVar.v1(r6) + a1.a);
                    final int x0 = eVar.x0(a1.a) + r6;
                    e.a aVar2 = androidx.compose.ui.e.a;
                    e.b g5 = aVar2.g();
                    Modifier t = androidx.compose.foundation.layout.f2.t(androidx.compose.foundation.layout.f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), 0.0f, g4, 0.0f, 0.0f, 13, (Object) null), g3, 0.0f, 2, (Object) null);
                    final com.dragon.read.kmp.reader.state.a aVar3 = this.b;
                    final com.dragon.read.kmp.reader.bookcover.epub.e eVar2 = this.c;
                    final MutableState<Boolean> mutableState = this.d;
                    androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), g5, composer, 48);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer, t);
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
                    g5.e(b2, a, companion.c());
                    g5.e(b2, currentCompositionLocalMap, companion.e());
                    Function2 b3 = companion.b();
                    if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                        b2.updateRememberedValue(Integer.valueOf(a2));
                        b2.apply(Integer.valueOf(a2), b3);
                    }
                    g5.e(b2, e2, companion.d());
                    androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                    qm4.a a4 = cm4.m.a(composer, 0);
                    String str = aVar3.a;
                    if (str == null) {
                        str = "";
                    }
                    Pair<Function2<Composer, Integer, Unit>, State<InsertState>> a5 = a4.a(str);
                    final Function2<Composer, Integer, Unit> component1 = a5.component1();
                    State<InsertState> component2 = a5.component2();
                    final boolean c2 = aVar3.c();
                    if (!c2 && component2.getValue() == InsertState.INSERT) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!c2 && component2.getValue() != InsertState.INSERT) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    final int M0 = (int) ((x0.e) composer.consume(CompositionLocalsKt.f())).M0(f);
                    final String str2 = "showComment_" + c2;
                    Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                    composer.startReplaceGroup(-1224400529);
                    boolean changed = composer.changed(str2) | composer.changedInstance(aVar3) | composer.changed(z3) | composer.changed(M0) | composer.changed(x0) | composer.changed(c2) | composer.changed(z4) | composer.changedInstance(eVar2) | composer.changed(component1);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        final boolean z5 = z3;
                        final boolean z6 = z4;
                        rememberedValue = new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.u0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                androidx.compose.ui.layout.r0 j;
                                j = a1.a.C0036a.j(str2, z5, M0, x0, c2, z6, aVar3, mutableState, eVar2, component1, (b2) obj, (x0.b) obj2);
                                return j;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    SubcomposeLayoutKt.a(h, (Function2) rememberedValue, composer, 6, 0);
                    boolean c3 = a1.c(mutableState);
                    composer.startReplaceGroup(5004770);
                    Object rememberedValue2 = composer.rememberedValue();
                    Composer.Companion companion2 = Composer.Companion;
                    if (rememberedValue2 == companion2.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.v0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit g6;
                                g6 = a1.a.C0036a.g(mutableState);
                                return g6;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    Function0 function0 = (Function0) rememberedValue2;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(-1633490746);
                    boolean changedInstance = composer.changedInstance(aVar3);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changedInstance || rememberedValue3 == companion2.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.w0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit h2;
                                h2 = a1.a.C0036a.h(com.dragon.read.kmp.reader.state.a.this, mutableState);
                                return h2;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    Function0 function02 = (Function0) rememberedValue3;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(-1633490746);
                    boolean changedInstance2 = composer.changedInstance(aVar3);
                    Object rememberedValue4 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == companion2.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.reader.bookcover.epub.x0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit i5;
                                i5 = a1.a.C0036a.i(com.dragon.read.kmp.reader.state.a.this, mutableState);
                                return i5;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue4);
                    }
                    composer.endReplaceGroup();
                    o.e(c3, function0, function02, (Function0) rememberedValue4, eVar2, composer, 48, 0);
                    a3.a(androidx.compose.foundation.layout.a0.a(c0Var, aVar, 1.0f, false, 2, (Object) null), composer, 0);
                    a3.a(SizeKt.i(aVar, x0.i.g(32)), composer, 6);
                    bm4.r0.c(composer, 0);
                    Context a6 = com.dragon.read.kmp.util.kotlin.b.a();
                    composer.startReplaceGroup(-2030689674);
                    if (a6 == null) {
                        d2 = null;
                    } else {
                        int c4 = screenUtils.c(a6);
                        composer.startReplaceGroup(-2030685972);
                        if (c4 > 0) {
                            g = screenUtils.j(c4, composer, ScreenUtils.b << 3);
                        } else {
                            g = x0.i.g(12);
                        }
                        composer.endReplaceGroup();
                        d2 = x0.i.d(g);
                    }
                    composer.endReplaceGroup();
                    if (d2 != null) {
                        g2 = d2.m();
                    } else {
                        g2 = x0.i.g(12);
                    }
                    a3.a(SizeKt.i(aVar, g2), composer, 0);
                    composer.endNode();
                    if (((am4.c) composer.consume(zl4.r.x())).b) {
                        bm4.o0.c(this.a, BoxWithConstraints.b(aVar, aVar2.h()), true, composer, 384, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit k(p1 p1Var, int i, p1 p1Var2, p1 p1Var3, p1.a layout) {
                int i2;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                int i3 = 0;
                if (p1Var != null) {
                    p1.a.N(layout, p1Var, 0, 0, 0.0f, 4, (Object) null);
                    i2 = p1Var.b + 0;
                } else {
                    i2 = 0;
                }
                if (p1Var != null) {
                    i3 = i;
                }
                int i4 = i2 + i3;
                if (p1Var2 != null) {
                    p1.a.N(layout, p1Var2, 0, i4, 0.0f, 4, (Object) null);
                    i4 += p1Var2.b + i;
                }
                int i5 = i4;
                if (p1Var3 != null) {
                    p1.a.N(layout, p1Var3, 0, i5, 0.0f, 4, (Object) null);
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0117  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x01cb  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x01e7  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x01ef  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x01f4  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x01f8 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0223  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x024e  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0255  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x025b  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x0262  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x025d  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0258  */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0252  */
            /* JADX WARN: Removed duplicated region for block: B:70:0x01ea  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x01e4  */
            /* JADX WARN: Removed duplicated region for block: B:79:0x0131  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public static final androidx.compose.ui.layout.r0 j(java.lang.String r25, boolean r26, int r27, int r28, boolean r29, boolean r30, com.dragon.read.kmp.reader.state.a r31, androidx.compose.runtime.MutableState r32, com.dragon.read.kmp.reader.bookcover.epub.e r33, kotlin.jvm.functions.Function2 r34, androidx.compose.ui.layout.b2 r35, x0.b r36) {
                /*
                    Method dump skipped, instructions count: 643
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.bookcover.epub.a1.a.C0036a.j(java.lang.String, boolean, int, int, boolean, boolean, com.dragon.read.kmp.reader.state.a, androidx.compose.runtime.MutableState, com.dragon.read.kmp.reader.bookcover.epub.e, kotlin.jvm.functions.Function2, androidx.compose.ui.layout.b2, x0.b):androidx.compose.ui.layout.r0");
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
                    ComposerKt.traceEventStart(-227593998, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView.<anonymous> (SecondBookCoverKmpView.kt:55)");
                }
                androidx.compose.foundation.layout.u.c(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), (androidx.compose.ui.e) null, false, androidx.compose.runtime.internal.t.e(503368008, true, new C0036a(this.a, this.b, this.c, this.d), composer, 54), composer, 3078, 6);
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
    public static final boolean c(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void b(final e event, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(event, "event");
        Composer startRestartGroup = composer.startRestartGroup(1715868803);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(event);
            } else {
                changedInstance = startRestartGroup.changedInstance(event);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(1715868803, i2, -1, "com.dragon.read.kmp.reader.bookcover.epub.SecondBookCoverKmpView (SecondBookCoverKmpView.kt:48)");
            }
            com.dragon.read.kmp.reader.state.b b2 = BookCoverViewModelKt.b(startRestartGroup, 0);
            com.dragon.read.kmp.reader.state.a aVar = (com.dragon.read.kmp.reader.state.a) b2.b.getValue();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            com.dragon.read.kmp.reader.state.t.f(androidx.compose.runtime.internal.t.e(-227593998, true, new a(((androidx.compose.ui.graphics.l0) b2.f.getValue()).x(), aVar, event, (MutableState) rememberedValue), startRestartGroup, 54), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.bookcover.epub.t0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e2;
                    e2 = a1.e(e.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((((((i - i2) - i3) - i4) - i5) - i6) - i7, 0);
        return coerceAtLeast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(int i, int i2, int i3, int i4, int i5, int i6, float f2) {
        float coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((((i - i2) - i3) - i4) - i5) - i6, 0.0f);
        return Math.max(1, (int) Math.floor(coerceAtLeast / f2));
    }
}
