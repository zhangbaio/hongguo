package ht3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public final String a;
    public final Boolean b;

    static {
        Covode.recordClassIndex(599215);
    }

    public c(String postId, Boolean bool) {
        Intrinsics.checkNotNullParameter(postId, "postId");
        this.a = postId;
        this.b = bool;
    }

    public /* synthetic */ c(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Boolean.FALSE : bool);
    }
}
