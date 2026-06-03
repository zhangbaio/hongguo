package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DayOfWeekNames {
    public static final a b;
    private static final DayOfWeekNames c;
    private static final DayOfWeekNames d;
    public final List<String> a;

    public static final class a {
        static {
            Covode.recordClassIndex(659478);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DayOfWeekNames a() {
            return DayOfWeekNames.d;
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this.a, ", ", "DayOfWeekNames(", ")", 0, null, DayOfWeekNames$toString$1.INSTANCE, 24, null);
    }

    static {
        List listOf;
        List listOf2;
        Covode.recordClassIndex(659477);
        b = new a(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
        c = new DayOfWeekNames(listOf);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
        d = new DayOfWeekNames(listOf2);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DayOfWeekNames) && Intrinsics.areEqual(this.a, ((DayOfWeekNames) obj).a)) {
            return true;
        }
        return false;
    }

    public DayOfWeekNames(List<String> names) {
        boolean z;
        IntRange indices;
        boolean z2;
        Intrinsics.checkNotNullParameter(names, "names");
        this.a = names;
        if (names.size() == 7) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            indices = CollectionsKt__CollectionsKt.getIndices(names);
            Iterator<Integer> it2 = indices.iterator();
            while (it2.hasNext()) {
                int nextInt = ((IntIterator) it2).nextInt();
                if (this.a.get(nextInt).length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    for (int i = 0; i < nextInt; i++) {
                        if (!(!Intrinsics.areEqual(this.a.get(nextInt), this.a.get(i)))) {
                            throw new IllegalArgumentException(("Day-of-week names must be unique, but '" + this.a.get(nextInt) + "' was repeated").toString());
                        }
                    }
                } else {
                    throw new IllegalArgumentException("A day-of-week name can not be empty".toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("Day of week names must contain exactly 7 elements".toString());
    }
}
