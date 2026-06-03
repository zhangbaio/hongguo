package zq4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface s {
    boolean a();

    u b(Function0<Unit> function0);

    List<l> c(String str);

    u d(Function1<? super p, Unit> function1);

    f e();

    n f();

    u g(boolean z, Function0<Unit> function0);

    Context getContext();

    t getReaderConfig();

    v getUiService();

    void h(u uVar);

    boolean i();

    boolean j(String str);

    boolean k(String str);

    c l();

    u m(g gVar);

    public static final class a {
        static {
            Covode.recordClassIndex(611428);
        }

        public static /* synthetic */ u a(s sVar, boolean z, Function0 function0, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return sVar.g(z, function0);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerTaskEndListener");
        }
    }
}
