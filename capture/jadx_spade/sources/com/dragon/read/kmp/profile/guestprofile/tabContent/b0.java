package com.dragon.read.kmp.profile.guestprofile.tabContent;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.guestprofile.tabContent.data.FootLoadingState;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 {
    public final SnapshotStateList<Object> a = SnapshotStateKt.mutableStateListOf();
    private final MutableState<FootLoadingState> b;
    public final State<FootLoadingState> c;

    static {
        Covode.recordClassIndex(608146);
    }

    public b0() {
        MutableState<FootLoadingState> mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(FootLoadingState.INIT, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.b = mutableStateOf$default;
        this.c = mutableStateOf$default;
    }

    public final void a(List<? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a.addAll(data);
    }

    public final void c(FootLoadingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.b.setValue(state);
    }

    public final void b(List<? extends Object> data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        SnapshotStateList<Object> snapshotStateList = this.a;
        if (z) {
            snapshotStateList.clear();
        }
        snapshotStateList.addAll(data);
    }
}
