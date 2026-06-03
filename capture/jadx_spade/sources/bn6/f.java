package bn6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.m;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f<T> implements e<T> {
    private final Function1<T, Integer> a;
    private final int b;
    private final int c;

    static {
        Covode.recordClassIndex(659630);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super T, Integer> number, int i, int i2) {
        Intrinsics.checkNotNullParameter(number, "number");
        this.a = number;
        this.b = i;
        this.c = i2;
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        boolean z2;
        String repeat;
        Intrinsics.checkNotNullParameter(builder, "builder");
        int intValue = this.a.invoke(t).intValue();
        int i = an6.d.b()[this.b];
        int i2 = intValue - this.c;
        if (i2 >= 0 && i2 < i) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            String valueOf = String.valueOf(intValue % an6.d.b()[this.b]);
            repeat = StringsKt__StringsJVMKt.repeat("0", Math.max(0, this.b - valueOf.length()));
            m.append(builder, repeat, valueOf);
        } else {
            if (intValue >= 0) {
                builder.append("+");
            }
            builder.append(String.valueOf(intValue));
        }
    }
}
