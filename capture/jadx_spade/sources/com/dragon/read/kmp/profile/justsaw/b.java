package com.dragon.read.kmp.profile.justsaw;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static final Lazy b;
    private static boolean c;
    public static final int d;

    private b() {
    }

    public final boolean d() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xn0.b e() {
        return xn0.c.a("Guest-Album-Just-Saw");
    }

    private final xn0.b b() {
        return (xn0.b) b.getValue();
    }

    public final boolean c() {
        return b().getBoolean("just_saw_first_anim_played", false);
    }

    public final void f() {
        b().d("just_saw_first_anim_played", true);
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(608194);
        a = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.profile.justsaw.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xn0.b e;
                e = b.e();
                return e;
            }
        });
        b = lazy;
        d = 8;
    }
}
