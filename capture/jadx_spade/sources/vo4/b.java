package vo4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends a {
    public final String d;

    static {
        Covode.recordClassIndex(609141);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String actionKey, long j, String name, long j2) {
        super(j, name, j2);
        Intrinsics.checkNotNullParameter(actionKey, "actionKey");
        Intrinsics.checkNotNullParameter(name, "name");
        this.d = actionKey;
    }
}
