package kotlinx.datetime.format;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
/* synthetic */ class DayOfWeekNames$toString$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final DayOfWeekNames$toString$1 INSTANCE = new DayOfWeekNames$toString$1();

    DayOfWeekNames$toString$1() {
        super(1, String.class, "toString", "toString()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.toString();
    }
}
