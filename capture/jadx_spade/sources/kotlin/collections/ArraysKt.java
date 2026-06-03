package kotlin.collections;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ArraysKt extends ArraysKt___ArraysKt {
    static {
        Covode.recordClassIndex(658170);
    }

    public static /* bridge */ /* synthetic */ Appendable joinTo$default(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        Appendable joinTo;
        joinTo = ArraysKt___ArraysKt.joinTo(objArr, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : function1);
        return joinTo;
    }

    private ArraysKt() {
    }
}
