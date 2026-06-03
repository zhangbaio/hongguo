package bp4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import yo4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a implements c {
    public static final int c = 0;
    private final String a;
    private final String b;

    static {
        Covode.recordClassIndex(609178);
    }

    @Override // yo4.c
    public String c() {
        return this.a;
    }

    @Override // yo4.c
    public String getChapterId() {
        return this.b;
    }

    public a(String storyId, String chapterId) {
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        this.a = storyId;
        this.b = chapterId;
    }
}
