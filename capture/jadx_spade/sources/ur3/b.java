package ur3;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.SaasReadingBookType;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public a a;
    public List<Integer> b;

    static {
        Covode.recordClassIndex(598827);
    }

    public static final class a {
        public final String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public SaasReadingBookType i;
        public List<? extends SecondaryInfo> j;
        public String k;
        public String l;

        static {
            Covode.recordClassIndex(598828);
        }

        public a(String bookId) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            this.a = bookId;
        }
    }
}
