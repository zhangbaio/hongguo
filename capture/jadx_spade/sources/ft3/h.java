package ft3;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import k44.e0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public static final h a;
    private static final Lazy b;

    private h() {
    }

    private final b c() {
        return (b) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b d() {
        return e0.a.d().j4();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(599206);
        a = new h();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ft3.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b d;
                d = h.d();
                return d;
            }
        });
        b = lazy;
    }

    public static final int b(Context context, int i) {
        return a.c().g(context, i);
    }
}
