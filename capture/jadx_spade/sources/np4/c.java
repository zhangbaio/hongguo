package np4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.us;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c extends bp4.a {
    public static final int f;
    public String d;
    public List<us> e;

    static {
        Covode.recordClassIndex(609319);
        f = 8;
    }

    @Override // yo4.c
    public int i() {
        return 60;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    @Override // yo4.c
    public String a(int i) {
        return c() + "_title_" + i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String storyId, String chapterId) {
        super(storyId, chapterId);
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        this.d = "";
        this.e = new ArrayList();
    }
}
