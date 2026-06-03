package dm4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface h {

    public static final class a {
        static {
            Covode.recordClassIndex(608313);
        }

        public static void a(h hVar, Context context, String str, boolean z, String str2) {
        }

        public static void b(h hVar, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        public static void c(h hVar, String bookId) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
        }
    }

    void a(Context context, String str, boolean z, String str2);

    void b(String str);

    void c(String str);
}
