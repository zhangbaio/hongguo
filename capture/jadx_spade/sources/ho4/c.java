package ho4;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    private static final Lazy a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final a b() {
        return (a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
    }

    public static final a c() {
        return (a) a.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609022);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ho4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                a b;
                b = c.b();
                return b;
            }
        });
        a = lazy;
    }
}
