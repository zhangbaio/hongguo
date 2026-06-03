package np4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.d6;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends bp4.a {
    public static final int e;
    public d6 d;

    static {
        Covode.recordClassIndex(609317);
        e = 8;
    }

    @Override // yo4.c
    public int i() {
        return 64;
    }

    @Override // yo4.c
    public String a(int i) {
        return c() + "_author_" + i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String storyId, String lastChapterId) {
        super(storyId, lastChapterId);
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(lastChapterId, "lastChapterId");
    }
}
