package sm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class h {
    public final String a;
    public final String b;
    public final String c;
    private final String d;

    static {
        Covode.recordClassIndex(608613);
    }

    public final String getType() {
        return this.d;
    }

    public h(String name, String str, String reportContent, String type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reportContent, "reportContent");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = name;
        this.b = str;
        this.c = reportContent;
        this.d = type;
    }
}
