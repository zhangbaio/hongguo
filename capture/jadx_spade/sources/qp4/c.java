package qp4;

import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.d0;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function0;
import pp4.d;
import pp4.f;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    private static final ProvidableCompositionLocal<Integer> a;
    private static final ProvidableCompositionLocal<d> b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d c() {
        return f.a;
    }

    public static final ProvidableCompositionLocal<d> e() {
        return b;
    }

    public static final ProvidableCompositionLocal<Integer> f() {
        return a;
    }

    static {
        Covode.recordClassIndex(609365);
        a = d0.h((SnapshotMutationPolicy) null, new Function0() { // from class: qp4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int d;
                d = c.d();
                return Integer.valueOf(d);
            }
        }, 1, (Object) null);
        b = d0.j(new Function0() { // from class: qp4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                d c;
                c = c.c();
                return c;
            }
        });
    }
}
