package com.dragon.read.kmp.widget;

import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t2;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r1 {
    static {
        Covode.recordClassIndex(609658);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Modifier modifier, LazyListState lazyListState, androidx.compose.foundation.layout.i2 i2Var, boolean z, e.m mVar, e.b bVar, androidx.compose.foundation.gestures.l1 l1Var, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        c(modifier, lazyListState, i2Var, z, mVar, bVar, l1Var, z2, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function2 function2, int i, Composer composer, int i2) {
        e(function2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ LazyListState b;
        final /* synthetic */ androidx.compose.foundation.layout.i2 c;
        final /* synthetic */ boolean d;
        final /* synthetic */ e.m e;
        final /* synthetic */ e.b f;
        final /* synthetic */ androidx.compose.foundation.gestures.l1 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ Function1<androidx.compose.foundation.lazy.o0, Unit> i;

        a(Modifier modifier, LazyListState lazyListState, androidx.compose.foundation.layout.i2 i2Var, boolean z, e.m mVar, e.b bVar, androidx.compose.foundation.gestures.l1 l1Var, boolean z2, Function1<? super androidx.compose.foundation.lazy.o0, Unit> function1) {
            this.a = modifier;
            this.b = lazyListState;
            this.c = i2Var;
            this.d = z;
            this.e = mVar;
            this.f = bVar;
            this.g = l1Var;
            this.h = z2;
            this.i = function1;
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
                    ComposerKt.traceEventStart(108701166, i, -1, "com.dragon.read.kmp.widget.NoOverscrollLazyColumn.<anonymous> (NoOverscrollStyle.android.kt:31)");
                }
                androidx.compose.foundation.lazy.d.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, (androidx.compose.foundation.y1) null, this.i, composer, 0, 256);
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
                    ComposerKt.traceEventStart(1630165930, i, -1, "com.dragon.read.kmp.widget.NoOverscrollLazyStyle.<anonymous> (NoOverscrollStyle.android.kt:51)");
                }
                this.a.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void e(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(569562858);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(content)) {
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
                ComposerKt.traceEventStart(569562858, i2, -1, "com.dragon.read.kmp.widget.NoOverscrollLazyStyle (NoOverscrollStyle.android.kt:47)");
            }
            androidx.compose.runtime.d0.c(androidx.compose.foundation.x1.c().provides((Object) null), androidx.compose.runtime.internal.t.e(1630165930, true, new b(content), startRestartGroup, 54), startRestartGroup, t2.i | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.p1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = r1.f(Function2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(androidx.compose.ui.Modifier r24, androidx.compose.foundation.lazy.LazyListState r25, androidx.compose.foundation.layout.i2 r26, boolean r27, androidx.compose.foundation.layout.e.m r28, androidx.compose.ui.e.b r29, androidx.compose.foundation.gestures.l1 r30, boolean r31, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.o0, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.r1.c(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.i2, boolean, androidx.compose.foundation.layout.e$m, androidx.compose.ui.e$b, androidx.compose.foundation.gestures.l1, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
