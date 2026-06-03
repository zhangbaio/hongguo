package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface l extends m1 {
    void invoke(Throwable th);

    public static final class a implements l {
        private final Function1<Throwable, Unit> a;

        static {
            Covode.recordClassIndex(658901);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + b0.a(this.a) + '@' + b0.b(this) + ']';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Throwable, Unit> function1) {
            this.a = function1;
        }

        @Override // kotlinx.coroutines.l
        public void invoke(Throwable th) {
            this.a.invoke(th);
        }
    }
}
