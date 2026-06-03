package bn6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c<T> implements e<T> {
    private final String a;

    static {
        Covode.recordClassIndex(659626);
    }

    public c(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.a = string;
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.append(this.a);
    }
}
