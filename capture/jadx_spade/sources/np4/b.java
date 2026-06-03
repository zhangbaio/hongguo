package np4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends bp4.a {
    public static final int d;

    static {
        Covode.recordClassIndex(609318);
        d = bp4.a.c;
    }

    @Override // yo4.c
    public int i() {
        return 8;
    }

    @Override // yo4.c
    public String a(int i) {
        return c() + "_divider_" + i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String storyId, String firstChapterId) {
        super(storyId, firstChapterId);
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(firstChapterId, "firstChapterId");
    }
}
