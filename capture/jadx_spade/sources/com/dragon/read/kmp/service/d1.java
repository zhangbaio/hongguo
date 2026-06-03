package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d1 {
    private static final Lazy a;

    public static final float c() {
        return ((x0.i) a.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.i i() {
        return x0.i.d(x0.i.g(b1.a.s()));
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(608892);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.service.c1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x0.i i;
                i = d1.i();
                return i;
            }
        });
        a = lazy;
    }

    public static final int b(int i) {
        return b1.a.e(i);
    }

    public static final float g(int i) {
        return b1.a.y(i);
    }

    public static final float h(int i) {
        return b1.a.E(i);
    }

    public static final boolean d(Theme theme) {
        Intrinsics.checkNotNullParameter(theme, "<this>");
        if (theme == Theme.DARK) {
            return true;
        }
        return false;
    }

    public static final boolean e(Theme theme) {
        Intrinsics.checkNotNullParameter(theme, "<this>");
        return !d(theme);
    }

    public static final Theme f(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Theme theme = Theme.LIGHT;
        if (!Intrinsics.areEqual(str, theme.getResSuffix())) {
            Theme theme2 = Theme.DARK;
            if (Intrinsics.areEqual(str, theme2.getResSuffix())) {
                return theme2;
            }
            return theme;
        }
        return theme;
    }
}
