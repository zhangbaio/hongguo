package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface z0 {
    void invoke(Throwable th);

    public static final class a implements z0 {
        private final Function1<Throwable, Unit> a;

        static {
            Covode.recordClassIndex(658990);
        }

        public String toString() {
            return "InternalCompletionHandler.UserSupplied[" + b0.a(this.a) + '@' + b0.b(this) + ']';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Throwable, Unit> function1) {
            this.a = function1;
        }

        @Override // kotlinx.coroutines.z0
        public void invoke(Throwable th) {
            this.a.invoke(th);
        }
    }
}
