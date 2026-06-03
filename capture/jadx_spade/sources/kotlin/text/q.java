package kotlin.text;

import com.bytedance.covode.number.Covode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class q extends StringsKt__IndentKt {
    static {
        Covode.recordClassIndex(658778);
    }

    private static final Regex toRegex(Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "<this>");
        return new Regex(pattern);
    }
}
