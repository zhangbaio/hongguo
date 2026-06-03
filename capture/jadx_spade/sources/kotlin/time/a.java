package kotlin.time;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a {
    Instant now();

    /* renamed from: kotlin.time.a$a, reason: collision with other inner class name */
    public static final class C0208a implements a {
        public static final C0208a a;

        static {
            Covode.recordClassIndex(658802);
            a = new C0208a();
        }

        private C0208a() {
        }

        @Override // kotlin.time.a
        public Instant now() {
            return i.b();
        }
    }
}
