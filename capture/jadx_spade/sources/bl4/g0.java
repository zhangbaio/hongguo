package bl4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UseStatus;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g0 {

    public static final class c implements DisposableEffectResult {
        public void dispose() {
        }
    }

    static {
        Covode.recordClassIndex(608049);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(List list, long j, int i, int i2, Composer composer, int i3) {
        h(list, j, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(bl4.a aVar, int i, Composer composer, int i2) {
        j(aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(bl4.a aVar, Modifier modifier, Function0 function0, Function0 function02, Function4 function4, Function3 function3, int i, int i2, Composer composer, int i3) {
        l(aVar, modifier, function0, function02, function4, function3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult n(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new c();
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ long a;

        a(long j) {
            this.a = j;
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
                    ComposerKt.traceEventStart(371101053, i, -1, "com.dragon.read.kmp.profile.container.BuildTagLayout.<anonymous>.<anonymous> (VideoListItem3Column.kt:111)");
                }
                float f = 3;
                float f2 = 2;
                a3.a(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.s(f2.v(Modifier.Companion, x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null), x0.i.g(f2)), k.g.c(x0.i.g(f2))), this.a, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function3<String, Composer, Integer, Unit> {
        final /* synthetic */ long a;

        b(long j) {
            this.a = j;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Composer composer, Integer num) {
            a(str, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(String content, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(content, "content");
            if ((i & 6) == 0) {
                if (composer.changed(content)) {
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
                    ComposerKt.traceEventStart(-808588275, i2, -1, "com.dragon.read.kmp.profile.container.BuildTagLayout.<anonymous>.<anonymous> (VideoListItem3Column.kt:103)");
                }
                a6.j(content, (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, g0.s(this.a, composer, 0, 0), composer, i2 & 14, 3120, 55294);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void j(final bl4.a itemModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        String K;
        int i3;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(323472485);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(itemModel)) {
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
                ComposerKt.traceEventStart(323472485, i2, -1, "com.dragon.read.kmp.profile.container.MainInfo (VideoListItem3Column.kt:129)");
            }
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(itemModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                if (itemModel.H().getValue() == UseStatus.OfflineStatus.getValue()) {
                    K = "****";
                } else {
                    K = itemModel.K();
                    if (K == null) {
                        K = "";
                    }
                }
                rememberedValue = K;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int b2 = w0.s.b.b();
            composer2 = startRestartGroup;
            a6.j((String) rememberedValue, f2.v(Modifier.Companion, 0.0f, x0.i.g(8), 0.0f, 0.0f, 13, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(14), b2, false, 1, 0, (Function1) null, (g3) null, composer2, 3120, 3126, 119792);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bl4.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = g0.k(a.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g3 s(long j, Composer composer, int i, int i2) {
        long j2;
        composer.startReplaceGroup(-1502939544);
        if ((i2 & 1) != 0) {
            j2 = og4.a.a.h(composer, og4.a.b).h();
        } else {
            j2 = j;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1502939544, i, -1, "com.dragon.read.kmp.profile.container.tagTextStyle (VideoListItem3Column.kt:121)");
        }
        g3 g3Var = new g3(j2, x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, x0.x.h(12), (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return g3Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        if ((r25 & 2) != 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final java.util.List<java.lang.String> r20, long r21, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bl4.g0.h(java.util.List, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void l(final bl4.a r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function0<kotlin.Unit> r32, kotlin.jvm.functions.Function0<kotlin.Unit> r33, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.r, ? super bl4.a, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.r, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 919
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bl4.g0.l(bl4.a, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function4, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
