package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b<Receiver> extends e<Receiver> {
    private final String c;

    static {
        Covode.recordClassIndex(659637);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String expected) {
        super(Integer.valueOf(expected.length()), "the predefined string " + expected, null);
        Intrinsics.checkNotNullParameter(expected, "expected");
        this.c = expected;
    }

    @Override // kotlinx.datetime.internal.format.parser.e
    public g a(Receiver receiver, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (Intrinsics.areEqual(input.subSequence(i, i2).toString(), this.c)) {
            return null;
        }
        return new g.e(this.c);
    }
}
