package gk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n0 extends e {
    public static final int j;

    static {
        Covode.recordClassIndex(607843);
        j = 8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(String postId, String cover, String title, String authorId, long j2, String targetUserId) {
        super(postId, cover, title, authorId, j2, targetUserId);
        Intrinsics.checkNotNullParameter(postId, "postId");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(authorId, "authorId");
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
    }
}
