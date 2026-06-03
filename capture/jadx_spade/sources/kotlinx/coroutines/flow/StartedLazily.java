package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class StartedLazily implements SharingStarted {
    static {
        Covode.recordClassIndex(659172);
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.flow(new StartedLazily$command$1(stateFlow, null));
    }
}
