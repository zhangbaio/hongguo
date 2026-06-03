package bn6;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b<T> implements e<T> {
    private final List<Pair<Function1<T, Boolean>, e<T>>> a;

    static {
        Covode.recordClassIndex(659625);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends Pair<? extends Function1<? super T, Boolean>, ? extends e<? super T>>> formatters) {
        Intrinsics.checkNotNullParameter(formatters, "formatters");
        this.a = formatters;
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (Pair<Function1<T, Boolean>, e<T>> pair : this.a) {
            Function1<T, Boolean> component1 = pair.component1();
            e<T> component2 = pair.component2();
            if (component1.invoke(t).booleanValue()) {
                component2.a(t, builder, z);
                return;
            }
        }
    }
}
