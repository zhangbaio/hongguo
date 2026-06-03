package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SharingStarted {
    public static final Companion Companion;

    static {
        Covode.recordClassIndex(659168);
        Companion = Companion.$$INSTANCE;
    }

    Flow<SharingCommand> command(StateFlow<Integer> stateFlow);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        private static final SharingStarted Eagerly;
        private static final SharingStarted Lazily;

        private Companion() {
        }

        public final SharingStarted getEagerly() {
            return Eagerly;
        }

        public final SharingStarted getLazily() {
            return Lazily;
        }

        static {
            Covode.recordClassIndex(659169);
            $$INSTANCE = new Companion();
            Eagerly = new l();
            Lazily = new StartedLazily();
        }

        public final SharingStarted WhileSubscribed(long j, long j2) {
            return new StartedWhileSubscribed(j, j2);
        }

        public static /* synthetic */ SharingStarted WhileSubscribed$default(Companion companion, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            if ((i & 2) != 0) {
                j2 = Long.MAX_VALUE;
            }
            return companion.WhileSubscribed(j, j2);
        }
    }
}
