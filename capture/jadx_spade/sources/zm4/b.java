package zm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.router.PageRecorderCreateType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int f;
    public final PageRecorderCreateType a;
    public String b;
    public String c;
    public String d;
    public Map<String, ? extends Object> e;

    static {
        Covode.recordClassIndex(608706);
        f = 8;
    }

    public b(PageRecorderCreateType createType) {
        Intrinsics.checkNotNullParameter(createType, "createType");
        this.a = createType;
    }
}
