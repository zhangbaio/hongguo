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
public final class MonthNames {
    public static final a b;
    private static final MonthNames c;
    private static final MonthNames d;
    public final List<String> a;

    public static final class a {
        static {
            Covode.recordClassIndex(659506);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MonthNames a() {
            return MonthNames.d;
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this.a, ", ", "MonthNames(", ")", 0, null, MonthNames$toString$1.INSTANCE, 24, null);
    }

    static {
        List listOf;
        List listOf2;
        Covode.recordClassIndex(659505);
        b = new a(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        c = new MonthNames(listOf);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        d = new MonthNames(listOf2);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof MonthNames) && Intrinsics.areEqual(this.a, ((MonthNames) obj).a)) {
            return true;
        }
        return false;
    }

    public MonthNames(List<String> names) {
        boolean z;
        IntRange indices;
        boolean z2;
        Intrinsics.checkNotNullParameter(names, "names");
        this.a = names;
        if (names.size() == 12) {
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
                            throw new IllegalArgumentException(("Month names must be unique, but '" + this.a.get(nextInt) + "' was repeated").toString());
                        }
                    }
                } else {
                    throw new IllegalArgumentException("A month name can not be empty".toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("Month names must contain exactly 12 elements".toString());
    }
}
