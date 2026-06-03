package bn6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k<T> implements e<T> {
    private final Function1<T, Integer> a;
    private final int b;

    static {
        Covode.recordClassIndex(659635);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Function1<? super T, Integer> number, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(number, "number");
        this.a = number;
        this.b = i;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i <= 9) {
                return;
            }
            throw new IllegalArgumentException(("The minimum number of digits (" + i + ") exceeds the length of an Int").toString());
        }
        throw new IllegalArgumentException(("The minimum number of digits (" + i + ") is negative").toString());
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        String valueOf = String.valueOf(this.a.invoke(t).intValue());
        int length = this.b - valueOf.length();
        for (int i = 0; i < length; i++) {
            builder.append('0');
        }
        builder.append(valueOf);
    }
}
