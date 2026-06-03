package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a0<Output> implements r<Output> {
    private final Function2<Output, Boolean, Unit> a;
    private final boolean b;
    private final String c;

    static {
        Covode.recordClassIndex(659661);
    }

    public String toString() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(a0 this$0, char c) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Expected " + this$0.c + " but got " + c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(Function2<? super Output, ? super Boolean, Unit> isNegativeSetter, boolean z, String whatThisExpects) {
        Intrinsics.checkNotNullParameter(isNegativeSetter, "isNegativeSetter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.a = isNegativeSetter;
        this.b = z;
        this.c = whatThisExpects;
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public Object a(Output output, CharSequence input, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (i >= input.length()) {
            return m.a.b(i);
        }
        final char charAt = input.charAt(i);
        if (charAt == '-') {
            this.a.invoke(output, Boolean.TRUE);
            return m.a.b(i + 1);
        }
        if (charAt == '+' && this.b) {
            this.a.invoke(output, Boolean.FALSE);
            return m.a.b(i + 1);
        }
        return m.a.a(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String c;
                c = a0.c(a0.this, charAt);
                return c;
            }
        });
    }
}
