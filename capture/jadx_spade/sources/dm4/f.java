package dm4;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    private static final Lazy a;

    public static final a c() {
        return (a) a.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(608310);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: dm4.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                a b;
                b = f.b();
                return b;
            }
        });
        a = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a b() {
        a downloadDepend = xf4.d.o3.a().downloadDepend();
        if (downloadDepend != null) {
            return downloadDepend;
        }
        throw new IllegalStateException("downloadDepend is null".toString());
    }
}
