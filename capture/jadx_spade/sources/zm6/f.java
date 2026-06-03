package zm6;

import bytedance.jvm.time.DayOfWeek;
import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {

    public /* synthetic */ class a {
        public static final /* synthetic */ EnumEntries<DayOfWeek> a;

        static {
            Covode.recordClassIndex(659397);
            a = EnumEntriesKt.enumEntries((Enum[]) DayOfWeek.values());
        }
    }

    static {
        Covode.recordClassIndex(659396);
    }

    public static final int b(DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        return dayOfWeek.ordinal() + 1;
    }

    public static final DayOfWeek a(int i) {
        boolean z = false;
        if (1 <= i && i < 8) {
            z = true;
        }
        if (z) {
            return (DayOfWeek) a.a.get(i - 1);
        }
        throw new IllegalArgumentException(("Expected ISO day-of-week number in 1..7, got " + i).toString());
    }
}
