package gk4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final int b;
    public final List<n> a;

    static {
        Covode.recordClassIndex(607799);
        b = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final o a(List<n> channels) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        return new o(channels);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o) && Intrinsics.areEqual(this.a, ((o) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ChannelOrderState(channels=" + this.a + ')';
    }

    public o(List<n> channels) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        this.a = channels;
    }

    public /* synthetic */ o(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
