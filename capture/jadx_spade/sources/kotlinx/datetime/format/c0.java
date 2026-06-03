package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.DecimalFractionFieldFormatDirective;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c0 extends DecimalFractionFieldFormatDirective<g1> {
    public static final a g;
    private static final List<Integer> h;
    private static final List<Integer> i;
    private final int e;
    private final int f;

    public static final class a {
        static {
            Covode.recordClassIndex(659481);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public int hashCode() {
        return (this.e * 31) + this.f;
    }

    static {
        List<Integer> listOf;
        List<Integer> listOf2;
        Covode.recordClassIndex(659480);
        g = new a(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        h = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{2, 1, 0, 2, 1, 0, 2, 1, 0});
        i = listOf2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (this.e == c0Var.e && this.f == c0Var.f) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(int i2, int i3, List<Integer> zerosToAdd) {
        super(TimeFields.a.a(), i2, i3, zerosToAdd);
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        this.e = i2;
        this.f = i3;
    }

    public /* synthetic */ c0(int i2, int i3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, (i4 & 4) != 0 ? h : list);
    }
}
