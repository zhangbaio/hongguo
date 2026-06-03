package bn6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i<T> implements e<T> {
    private final e<T> a;
    private final int b;

    static {
        Covode.recordClassIndex(659633);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(e<? super T> formatter, int i) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        this.a = formatter;
        this.b = i;
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        StringBuilder sb = new StringBuilder();
        this.a.a(t, sb, z);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "let(...)");
        int length = this.b - sb2.length();
        for (int i = 0; i < length; i++) {
            builder.append(' ');
        }
        builder.append(sb2);
    }
}
