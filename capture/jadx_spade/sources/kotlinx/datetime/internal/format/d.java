package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> {
    private final List<q<T>> a = new ArrayList();

    static {
        Covode.recordClassIndex(659592);
    }

    public final h<T> b() {
        return new h<>(this.a);
    }

    public final void a(n<? super T> format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (format instanceof q) {
            this.a.add(format);
        } else {
            if (format instanceof h) {
                Iterator<T> it2 = ((h) format).a.iterator();
                while (it2.hasNext()) {
                    this.a.add((q) it2.next());
                }
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
