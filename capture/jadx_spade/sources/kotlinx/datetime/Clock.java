package kotlinx.datetime;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Clock {
    Instant now();

    public static final class System implements Clock {
        public static final System INSTANCE;

        static {
            Covode.recordClassIndex(659376);
            INSTANCE = new System();
        }

        private System() {
        }

        @Override // kotlinx.datetime.Clock
        public Instant now() {
            return Instant.Companion.f();
        }
    }
}
