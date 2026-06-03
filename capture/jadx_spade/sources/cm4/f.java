package cm4;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final int d;
    private final Lazy a;
    private final Lazy b;
    private final Lazy c;

    static {
        Covode.recordClassIndex(608288);
        d = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.reader.services.a h() {
        return xf4.f.r3.interceptorProvider();
    }

    private final com.dragon.read.kmp.reader.services.a f() {
        return (com.dragon.read.kmp.reader.services.a) this.a.getValue();
    }

    public final qm4.a e() {
        return (qm4.a) this.c.getValue();
    }

    public final qm4.b g() {
        return (qm4.b) this.b.getValue();
    }

    public f() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: cm4.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.dragon.read.kmp.reader.services.a h;
                h = f.h();
                return h;
            }
        });
        this.a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: cm4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qm4.b i;
                i = f.i(f.this);
                return i;
            }
        });
        this.b = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: cm4.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qm4.a d2;
                d2 = f.d(f.this);
                return d2;
            }
        });
        this.c = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qm4.a d(f fVar) {
        com.dragon.read.kmp.reader.services.a f = fVar.f();
        if (f != null) {
            return f.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qm4.b i(f fVar) {
        com.dragon.read.kmp.reader.services.a f = fVar.f();
        if (f != null) {
            return f.a();
        }
        return null;
    }
}
