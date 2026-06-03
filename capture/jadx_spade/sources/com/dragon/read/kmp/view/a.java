package com.dragon.read.kmp.view;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.v2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function3<v2, Composer, Integer, Unit> b;

    public final Function3<v2, Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(609586);
        a = new a();
        b = androidx.compose.runtime.internal.t.c(-1471688644, false, C0078a.a);
    }

    /* renamed from: com.dragon.read.kmp.view.a$a, reason: collision with other inner class name */
    static final class C0078a implements Function3<v2, Composer, Integer, Unit> {
        public static final C0078a a = new C0078a();

        C0078a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(v2 v2Var, Composer composer, Integer num) {
            a(v2Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(v2 TextButton, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1471688644, i, -1, "com.dragon.read.kmp.view.ComposableSingletons$MainUpdateDialogViewKmpKt.lambda$-1471688644.<anonymous> (MainUpdateDialogViewKmp.kt:161)");
                }
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(com.dragon.read.component.biz.impl.update.d.b(com.dragon.read.component.biz.impl.update.h.a), composer, 0), "退出 ", SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, composer, 432, 248);
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
