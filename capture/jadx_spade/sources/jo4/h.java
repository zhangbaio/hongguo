package jo4;

import androidx.compose.foundation.lazy.n0;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import jo4.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    static {
        Covode.recordClassIndex(609064);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, Function2 function2, int i, int i2, Composer composer, int i3) {
        h(str, function2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, Function2 function2, int i, int i2, Composer composer, int i3) {
        h(str, function2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(boolean z, String str, Function1 function1, int i, int i2, Composer composer, int i3) {
        n(z, str, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function2 function2) {
        function2.invoke(Boolean.FALSE, Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1) {
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(boolean z, boolean z2) {
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ Function1<Boolean, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Function1<? super Boolean, Unit> function1) {
            this.a = str;
            this.b = function1;
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
                    ComposerKt.traceEventStart(502065767, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.rule.RuleTipsDialog.<anonymous> (RankRuleView.kt:96)");
                }
                String str = this.a;
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(this.b);
                final Function1<Boolean, Unit> function1 = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function2() { // from class: jo4.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit c;
                            c = h.b.c(Function1.this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                h.h(str, (Function2) rememberedValue, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function1 function1, boolean z, boolean z2) {
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(z2));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        n0.a(LazyColumn, (Object) null, (Object) null, t.c(1269902450, true, new a(str)), 3, (Object) null);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
            a(fVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1269902450, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.rule.RankRuleView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RankRuleView.kt:57)");
                }
                long h = x.h(14);
                a6.j(this.a, (Modifier) null, og4.a.a.h(composer, og4.a.b).j(), h, (y) null, (c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, x.h(22), 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 6, 130034);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final java.lang.String r46, kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 1204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jo4.h.h(java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void n(final boolean z, final String str, final Function1<? super Boolean, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        Composer startRestartGroup = composer.startRestartGroup(1054954421);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (i7 != 0) {
                function1 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1054954421, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.rule.RuleTipsDialog (RankRuleView.kt:84)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(5004770);
                if ((i3 & 896) == 256) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: jo4.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit o;
                            o = h.o(Function1.this);
                            return o;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                AndroidDialog_androidKt.a((Function0) rememberedValue, new androidx.compose.ui.window.f(true, true, false), t.e(502065767, true, new b(str, function1), startRestartGroup, 54), startRestartGroup, 432, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Function1<? super Boolean, Unit> function12 = function1;
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: jo4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p;
                    p = h.p(z, str, function12, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return p;
                }
            });
        }
    }
}
