package bn6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g<T> implements e<T> {
    private final e<T> a;
    private final Function1<T, Boolean> b;
    private final boolean c;

    static {
        Covode.recordClassIndex(659631);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(e<? super T> formatter, Function1<? super T, Boolean> allSubFormatsNegative, boolean z) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        Intrinsics.checkNotNullParameter(allSubFormatsNegative, "allSubFormatsNegative");
        this.a = formatter;
        this.b = allSubFormatsNegative;
        this.c = z;
    }

    @Override // bn6.e
    public void a(T t, Appendable builder, boolean z) {
        Character ch;
        boolean z2;
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!z && this.b.invoke(t).booleanValue()) {
            ch = '-';
        } else if (this.c) {
            ch = '+';
        } else {
            ch = null;
        }
        if (ch != null) {
            builder.append(ch.charValue());
        }
        e<T> eVar = this.a;
        if (!z && (ch == null || ch.charValue() != '-')) {
            z2 = false;
        } else {
            z2 = true;
        }
        eVar.a(t, builder, z2);
    }
}
