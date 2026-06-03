package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u<Output> {
    public final List<r<Output>> a;
    public final List<u<Output>> b;

    static {
        Covode.recordClassIndex(659658);
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this.a, ", ", null, null, 0, null, null, 62, null) + '(' + CollectionsKt___CollectionsKt.joinToString$default(this.b, ";", null, null, 0, null, null, 62, null) + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(List<? extends r<? super Output>> operations, List<? extends u<? super Output>> followedBy) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        Intrinsics.checkNotNullParameter(followedBy, "followedBy");
        this.a = operations;
        this.b = followedBy;
    }
}
