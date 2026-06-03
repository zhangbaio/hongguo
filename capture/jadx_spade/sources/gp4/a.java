package gp4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a implements yo4.a {
    private final String a;

    static {
        Covode.recordClassIndex(609246);
    }

    public String a() {
        return this.a;
    }

    public a(String storyId) {
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        this.a = storyId;
    }
}
