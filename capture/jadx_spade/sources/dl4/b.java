package dl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    Single<List<Object>> a(String str, FilterOptionHeaderType filterOptionHeaderType);

    Single<List<Object>> b(String str, String str2, FilterOptionHeaderType filterOptionHeaderType);

    void c(String str);

    Boolean d();

    boolean f();

    void g(int i);

    boolean k();

    void onDestroy();

    void reset();

    public static final class a {
        static {
            Covode.recordClassIndex(608074);
        }

        public static int b(b bVar) {
            return 18;
        }

        public static void c(b bVar, int i) {
        }

        public static boolean d(b bVar) {
            return false;
        }

        public static void e(b bVar) {
        }

        public static void f(b bVar) {
        }

        public static void g(b bVar, String justSawVid) {
            Intrinsics.checkNotNullParameter(justSawVid, "justSawVid");
        }

        public static /* synthetic */ Single a(b bVar, String str, String str2, FilterOptionHeaderType filterOptionHeaderType, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "";
                }
                return bVar.b(str, str2, filterOptionHeaderType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchDataList");
        }
    }
}
