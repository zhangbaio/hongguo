package oo4;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements b {
    public static final e b;
    private static final Lazy c;
    public static final int d;
    private final /* synthetic */ b a = f.a();

    @Override // oo4.b
    public void a(String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.a.a(from);
    }

    @Override // oo4.b
    public void b(String listName, String str) {
        Intrinsics.checkNotNullParameter(listName, "listName");
        this.a.b(listName, str);
    }

    @Override // oo4.b
    public void c() {
        this.a.c();
    }

    @Override // oo4.b
    public void cancel() {
        this.a.cancel();
    }

    @Override // oo4.b
    public void startTrace() {
        this.a.startTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b e() {
        return f.a();
    }

    private e() {
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609104);
        b = new e();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: oo4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b e;
                e = e.e();
                return e;
            }
        });
        c = lazy;
        d = 8;
    }
}
