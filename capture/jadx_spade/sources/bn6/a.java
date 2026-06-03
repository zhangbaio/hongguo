package bn6;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a<T> implements e<T> {
    private final List<e<T>> a;

    static {
        Covode.recordClassIndex(659624);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends e<? super T>> formatters) {
        Intrinsics.checkNotNullParameter(formatters, "formatters");
        this.a = formatters;
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Iterator<e<T>> it2 = this.a.iterator();
        while (it2.hasNext()) {
            it2.next().a(t, builder, z);
        }
    }
}
