package qo4;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;
    private static final Lazy b;
    public static final int c;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xn0.b d() {
        return xn0.c.a("SelectTabGuide");
    }

    private final xn0.b b() {
        return (xn0.b) b.getValue();
    }

    public final void e() {
        b().storeString("select_tab_guide_shown", "1");
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609111);
        a = new e();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: qo4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xn0.b d;
                d = e.d();
                return d;
            }
        });
        b = lazy;
        c = 8;
    }

    public final boolean c() {
        return Intrinsics.areEqual(b().getString("select_tab_guide_shown", ""), "1");
    }
}
