package ym4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.performance.reporter.SimpleKPerfReporter;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(608687);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(String str, gk4.f fVar, Function2 function2, int i, Composer composer, int i2) {
        c(str, fVar, function2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final gk4.f b(long j) {
        return new r(j);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> a;

        a(Function2<? super Composer, ? super Integer, Unit> function2) {
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
                    ComposerKt.traceEventStart(381972775, i, -1, "com.dragon.read.kmp.report.kmpPerfWrapper.<anonymous> (KmpPerformanceReporter.kt:14)");
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

    public static final void c(final String name, final gk4.f param, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1684864531);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(name)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(param)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(content)) {
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
                ComposerKt.traceEventStart(1684864531, i2, -1, "com.dragon.read.kmp.report.kmpPerfWrapper (KmpPerformanceReporter.kt:11)");
            }
            com.dragon.read.kmp.j.a.d("LightTest", "kmpPerfWrapper: " + name + ' ' + param.a());
            ao0.n.j(name, param.a(), i.d(), false, (ao0.d) null, androidx.compose.runtime.internal.t.e(381972775, true, new a(content), startRestartGroup, 54), startRestartGroup, (i2 & 14) | 196608 | (SimpleKPerfReporter.e << 6), 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: ym4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit d;
                    d = f.d(name, param, content, i, (Composer) obj, ((Integer) obj2).intValue());
                    return d;
                }
            });
        }
    }
}
