package bn6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j<T> implements e<T> {
    private final Function1<T, String> a;

    static {
        Covode.recordClassIndex(659634);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super T, String> string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.a = string;
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.append(this.a.invoke(t));
    }
}
