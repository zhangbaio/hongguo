package dm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface j {

    public static final class a {
        static {
            Covode.recordClassIndex(608317);
        }

        public static void a(j jVar, String event, ym4.a args) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(args, "args");
        }
    }

    void a(String str, ym4.a aVar);
}
