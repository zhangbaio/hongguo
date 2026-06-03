package kotlin.text;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l {
    static {
        Covode.recordClassIndex(658773);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRange h(java.util.regex.MatchResult matchResult) {
        IntRange until;
        until = RangesKt___RangesKt.until(matchResult.start(), matchResult.end());
        return until;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Iterable<? extends d> iterable) {
        Iterator<? extends d> it2 = iterable.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i |= it2.next().getValue();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchResult g(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new i(matcher, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRange i(java.util.regex.MatchResult matchResult, int i) {
        IntRange until;
        until = RangesKt___RangesKt.until(matchResult.start(i), matchResult.end(i));
        return until;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MatchResult f(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new i(matcher, charSequence);
    }
}
