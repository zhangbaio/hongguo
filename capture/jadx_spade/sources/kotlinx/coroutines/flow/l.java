package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class l implements SharingStarted {
    static {
        Covode.recordClassIndex(659171);
    }

    public String toString() {
        return "SharingStarted.Eagerly";
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.flowOf(SharingCommand.START);
    }
}
