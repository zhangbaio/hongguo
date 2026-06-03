package gp4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class b extends bp4.a {
    public static final int d;

    static {
        Covode.recordClassIndex(609248);
        d = bp4.a.c;
    }

    public abstract int b();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String storyId, String chapterId) {
        super(storyId, chapterId);
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
    }
}
