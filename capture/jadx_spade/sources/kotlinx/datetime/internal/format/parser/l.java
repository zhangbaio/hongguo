package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l {
    public final int a;
    public final Function0<String> b;

    static {
        Covode.recordClassIndex(659649);
    }

    public l(int i, Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.a = i;
        this.b = message;
    }
}
