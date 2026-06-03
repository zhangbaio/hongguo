package com.dragon.read.kmp.utils;

import a0.f;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.g2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.x30;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s0 {
    public static final s0 a;
    private static final Lazy b;
    public static final int c;

    private s0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.i e() {
        return new com.dragon.read.kmp.i("ShortSeriesCoverTagUtil");
    }

    private final com.dragon.read.kmp.i c() {
        return (com.dragon.read.kmp.i) b.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609564);
        a = new s0();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.utils.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.dragon.read.kmp.i e;
                e = s0.e();
                return e;
            }
        });
        b = lazy;
        c = 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<androidx.compose.ui.graphics.l0> b(java.util.List<java.lang.String> r5) {
        /*
            r4 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L38
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L38
            r0.<init>()     // Catch: java.lang.Throwable -> L38
            if (r5 == 0) goto L37
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L38
        Ld:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L37
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L38
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L24
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L38
            if (r2 != 0) goto L22
            goto L24
        L22:
            r2 = 0
            goto L25
        L24:
            r2 = 1
        L25:
            if (r2 != 0) goto Ld
            com.dragon.read.kmp.utils.k r2 = com.dragon.read.kmp.utils.k.a     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = "#4D000000"
            long r1 = r2.f(r1, r3)     // Catch: java.lang.Throwable -> L38
            androidx.compose.ui.graphics.l0 r1 = androidx.compose.ui.graphics.l0.j(r1)     // Catch: java.lang.Throwable -> L38
            r0.add(r1)     // Catch: java.lang.Throwable -> L38
            goto Ld
        L37:
            return r0
        L38:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r5)
            java.lang.Throwable r5 = kotlin.Result.m776exceptionOrNullimpl(r5)
            if (r5 == 0) goto L56
            com.dragon.read.kmp.utils.s0 r5 = com.dragon.read.kmp.utils.s0.a
            com.dragon.read.kmp.i r5 = r5.c()
            java.lang.String r0 = "getColor error"
            r1 = 2
            r2 = 0
            com.dragon.read.kmp.i.c(r5, r0, r2, r1, r2)
        L56:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.s0.b(java.util.List):java.util.List");
    }

    public final Modifier d(Modifier modifier, x30 x30Var, Theme theme, float f, long j) {
        androidx.compose.ui.graphics.c0 h;
        Object firstOrNull;
        long g;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (x30Var == null) {
            return BackgroundKt.d(ig4.i.c(modifier, x0.i.d(f), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), j, (f2) null, 2, (Object) null);
        }
        gk4.i0 a2 = gk4.i0.d.a(x30Var);
        List<androidx.compose.ui.graphics.l0> b2 = b(a2.b);
        List<androidx.compose.ui.graphics.l0> b3 = b(a2.c);
        if (!com.dragon.read.kmp.service.d1.d(theme) || b3.isEmpty()) {
            b3 = b2;
        }
        if (b3.isEmpty()) {
            b3.add(androidx.compose.ui.graphics.l0.j(j));
        }
        Modifier c2 = ig4.i.c(modifier, x0.i.d(f), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
        if (b3.size() <= 1) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) b3);
            androidx.compose.ui.graphics.l0 l0Var = (androidx.compose.ui.graphics.l0) firstOrNull;
            if (l0Var != null) {
                g = l0Var.x();
            } else {
                g = androidx.compose.ui.graphics.l0.b.g();
            }
            h = new g2(g, (DefaultConstructorMarker) null);
        } else {
            c0.a aVar = androidx.compose.ui.graphics.c0.b;
            f.a aVar2 = a0.f.b;
            h = c0.a.h(aVar, b3, aVar2.c(), aVar2.a(), 0, 8, (Object) null);
        }
        return BackgroundKt.b(c2, h, (f2) null, 0.0f, 6, (Object) null);
    }
}
