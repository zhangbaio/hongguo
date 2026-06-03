package com.dragon.read.kmp.profile.component;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function2<Composer, Integer, Unit> b;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(608036);
        a = new a();
        b = androidx.compose.runtime.internal.t.c(863087899, false, C0026a.a);
    }

    /* renamed from: com.dragon.read.kmp.profile.component.a$a, reason: collision with other inner class name */
    static final class C0026a implements Function2<Composer, Integer, Unit> {
        public static final C0026a a = new C0026a();

        C0026a() {
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
                    ComposerKt.traceEventStart(863087899, i, -1, "com.dragon.read.kmp.profile.component.ComposableSingletons$TagTitleIconLayoutKt.lambda$863087899.<anonymous> (TagTitleIconLayout.kt:152)");
                }
                a3.a(SizeKt.s(Modifier.Companion, x0.i.g(0)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }
}
