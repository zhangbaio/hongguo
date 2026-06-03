package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class x<Output> implements r<Output> {
    public final String a;

    static {
        Covode.recordClassIndex(659659);
    }

    public String toString() {
        return '\'' + this.a + '\'';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(x this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return "Unexpected end of input: yet to parse '" + this$0.a + '\'';
    }

    public x(String string) {
        boolean z;
        Intrinsics.checkNotNullParameter(string, "string");
        this.a = string;
        if (string.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!an6.f.b(string.charAt(0))) {
                if (!an6.f.b(string.charAt(string.length() - 1))) {
                    return;
                }
                throw new IllegalArgumentException(("String '" + string + "' ends with a digit").toString());
            }
            throw new IllegalArgumentException(("String '" + string + "' starts with a digit").toString());
        }
        throw new IllegalArgumentException("Empty string is not allowed".toString());
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public Object a(Output output, final CharSequence input, final int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (this.a.length() + i > input.length()) {
            return m.a.a(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String d;
                    d = x.d(x.this);
                    return d;
                }
            });
        }
        int length = this.a.length();
        for (final int i2 = 0; i2 < length; i2++) {
            if (input.charAt(i + i2) != this.a.charAt(i2)) {
                return m.a.a(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String e;
                        e = x.e(x.this, input, i, i2);
                        return e;
                    }
                });
            }
        }
        return m.a.b(i + this.a.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(x this$0, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(input, "$input");
        return "Expected " + this$0.a + " but got " + input.subSequence(i, i2 + i + 1).toString();
    }
}
