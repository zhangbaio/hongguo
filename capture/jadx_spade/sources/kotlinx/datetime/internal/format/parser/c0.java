package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c0<Output> implements r<Output> {
    private final Function1<Output, Unit> a;

    static {
        Covode.recordClassIndex(659664);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c0(Function1<? super Output, Unit> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.a = operation;
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public Object a(Output output, CharSequence input, int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.a.invoke(output);
        return m.a.b(i);
    }
}
