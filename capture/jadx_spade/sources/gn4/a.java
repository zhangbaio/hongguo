package gn4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.x7;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a extends c {
    public static final int p;
    private final MutableState<Boolean> n;
    private final MutableState<Boolean> o;

    static {
        Covode.recordClassIndex(608761);
        p = 8;
    }

    public final boolean h() {
        return ((Boolean) this.n.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) this.o.getValue()).booleanValue();
    }

    public final void j(boolean z) {
        this.n.setValue(Boolean.valueOf(z));
    }

    public final void k(boolean z) {
        this.o.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(x7 cellViewData) {
        super(cellViewData);
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        Boolean bool = Boolean.FALSE;
        this.n = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.o = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
