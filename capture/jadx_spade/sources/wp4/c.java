package wp4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.UgcRelativeType;
import com.bytedance.kmp.ugc.model.bm;
import com.bytedance.kmp.ugc.model.o6;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int b;
    public final o6 a;

    static {
        Covode.recordClassIndex(609391);
        b = 8;
    }

    public String b() {
        String b2;
        xp4.a a = a();
        if (a == null || (b2 = a.b()) == null) {
            return "";
        }
        return b2;
    }

    public final xp4.a a() {
        bm bmVar;
        Integer num = this.a.a;
        int value = UgcRelativeType.Post.getValue();
        if (num == null || num.intValue() != value || (bmVar = this.a.c) == null) {
            return null;
        }
        return new yp4.b(bmVar);
    }

    public String toString() {
        return "FeedContentData(key=" + b() + ", dataType=" + this.a.a + ')';
    }

    public c(o6 data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }
}
