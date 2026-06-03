package dm4;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    Object a(String str, String str2, Continuation<? super Unit> continuation);

    Object b(String str, String str2, Continuation<? super Boolean> continuation);

    public static final class a {
        static {
            Covode.recordClassIndex(608305);
        }

        public static Object a(b bVar, String str, String str2, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        public static Object b(b bVar, String str, String str2, Continuation<? super Boolean> continuation) {
            return Boxing.boxBoolean(false);
        }
    }
}
