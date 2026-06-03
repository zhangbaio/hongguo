package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class StartedWhileSubscribed implements SharingStarted {
    private final long a;
    private final long b;

    static {
        Covode.recordClassIndex(659173);
    }

    public int hashCode() {
        return (j.a(this.a) * 31) + j.a(this.b);
    }

    public String toString() {
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder(2);
        if (this.a > 0) {
            createListBuilder.add("stopTimeout=" + this.a + "ms");
        }
        if (this.b < Long.MAX_VALUE) {
            createListBuilder.add("replayExpiration=" + this.b + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsJVMKt.build(createListBuilder), null, null, null, 0, null, null, 63, null) + ')';
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(stateFlow, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.a == startedWhileSubscribed.a && this.b == startedWhileSubscribed.b) {
                return true;
            }
        }
        return false;
    }

    public StartedWhileSubscribed(long j, long j2) {
        boolean z;
        this.a = j;
        this.b = j2;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (j2 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
        }
        throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
    }
}
