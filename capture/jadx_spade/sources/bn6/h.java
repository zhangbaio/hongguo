package bn6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h<T> implements e<T> {
    private final Function1<T, Integer> a;
    private final int b;
    private final Integer c;

    static {
        Covode.recordClassIndex(659632);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super T, Integer> number, int i, Integer num) {
        boolean z;
        Intrinsics.checkNotNullParameter(number, "number");
        this.a = number;
        this.b = i;
        this.c = num;
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
        StringBuilder sb = new StringBuilder();
        int intValue = this.a.invoke(t).intValue();
        if (z && intValue < 0) {
            intValue = -intValue;
        }
        if (this.c != null && intValue >= an6.d.b()[this.c.intValue()]) {
            sb.append('+');
        }
        if (Math.abs(intValue) < an6.d.b()[this.b - 1]) {
            if (intValue >= 0) {
                sb.append(intValue + an6.d.b()[this.b]);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb.append(intValue - an6.d.b()[this.b]);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(1), "deleteCharAt(...)");
            }
        } else {
            sb.append(intValue);
        }
        builder.append(sb);
    }
}
