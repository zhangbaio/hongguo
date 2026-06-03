package bn6;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<T> implements e<T> {
    private final Function1<T, an6.a> a;
    private final int b;
    private final int c;
    private final List<Integer> d;

    static {
        Covode.recordClassIndex(659627);
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        int b = this.a.invoke(t).b(this.c);
        int i = 0;
        while (this.c > this.b + i) {
            int i2 = i + 1;
            if (b % an6.d.b()[i2] != 0) {
                break;
            } else {
                i = i2;
            }
        }
        int intValue = this.d.get((this.c - i) - 1).intValue();
        if (i >= intValue) {
            i -= intValue;
        }
        String substring = String.valueOf((b / an6.d.b()[i]) + an6.d.b()[this.c - i]).substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        builder.append(substring);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super T, an6.a> number, int i, int i2, List<Integer> zerosToAdd) {
        boolean z;
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        this.a = number;
        this.b = i;
        this.c = i2;
        this.d = zerosToAdd;
        boolean z2 = false;
        if (1 <= i && i < 10) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i <= i2 && i2 < 10) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            throw new IllegalArgumentException(("The maximum number of digits (" + i2 + ") is not in range " + i + "..9").toString());
        }
        throw new IllegalArgumentException(("The minimum number of digits (" + i + ") is not in range 1..9").toString());
    }
}
