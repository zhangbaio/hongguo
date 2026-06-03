package ym4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.performance.reporter.SimpleKPerfReporter;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.StateFlow;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    private static final SimpleKPerfReporter a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(String str, gk4.f fVar, StateFlow stateFlow, Function2 function2, int i, Composer composer, int i2) {
        e(str, fVar, stateFlow, function2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final SimpleKPerfReporter d() {
        return a;
    }

    static {
        Covode.recordClassIndex(608688);
        a = new SimpleKPerfReporter(new Function2() { // from class: ym4.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit c;
                c = i.c((String) obj, (String) obj2);
                return c;
            }
        });
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
                    ComposerKt.traceEventStart(1238289363, i, -1, "com.dragon.read.kmp.report.kmpPerfWrapper.<anonymous> (KmpPerformanceReporter.android.kt:23)");
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(String eventName, String jsonData) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        d dVar = (d) eo0.c.a.a(Reflection.getOrCreateKotlinClass(d.class));
        if (dVar != null) {
            dVar.onReport(eventName, new JSONObject(jsonData));
        }
        return Unit.INSTANCE;
    }

    public static final void e(final String name, final gk4.f param, final StateFlow<Long> launchTimeFlow, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(launchTimeFlow, "launchTimeFlow");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1140749759);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(name)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(param)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(launchTimeFlow)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        if ((i2 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1140749759, i2, -1, "com.dragon.read.kmp.report.kmpPerfWrapper (KmpPerformanceReporter.android.kt:21)");
            }
            ao0.n.j(name, param.a(), a, false, new ao0.d(launchTimeFlow), androidx.compose.runtime.internal.t.e(1238289363, true, new a(content), startRestartGroup, 54), startRestartGroup, (i2 & 14) | 196608 | (SimpleKPerfReporter.e << 6) | (ao0.d.b << 12), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: ym4.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = i.f(name, param, launchTimeFlow, content, i, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }
}
