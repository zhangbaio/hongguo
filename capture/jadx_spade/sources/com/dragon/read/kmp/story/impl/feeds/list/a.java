package com.dragon.read.kmp.story.impl.feeds.list;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a {
    public static final int h;
    private final c a;
    public final SnapshotStateList<yo4.c> b;
    public boolean c;
    public boolean d;
    private final MutableState<FootLoadingState> e;
    private final Map<String, yo4.c> f;
    public final State<FootLoadingState> g;

    static {
        Covode.recordClassIndex(609297);
        h = 8;
    }

    public final List<yo4.c> d() {
        return this.b;
    }

    public final void g() {
        k(FootLoadingState.INIT);
    }

    public final void h() {
        k(FootLoadingState.ERROR);
    }

    public final void i() {
        k(FootLoadingState.NOT_MORE);
    }

    public final void j() {
        k(FootLoadingState.LOADING);
    }

    public final void f() {
        Function0<Unit> function0 = this.a.a;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean e() {
        Function0<Boolean> function0 = this.a.b;
        if (function0 != null) {
            return function0.invoke().booleanValue();
        }
        return false;
    }

    public final void a(List<? extends yo4.c> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.b.addAll(data);
    }

    public final void k(FootLoadingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.e.setValue(state);
    }

    public a(c loadMoreConfig) {
        Intrinsics.checkNotNullParameter(loadMoreConfig, "loadMoreConfig");
        this.a = loadMoreConfig;
        this.b = SnapshotStateKt.mutableStateListOf();
        MutableState<FootLoadingState> mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(FootLoadingState.GONE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = mutableStateOf$default;
        this.f = new LinkedHashMap();
        this.g = mutableStateOf$default;
    }

    public final void b(List<? extends yo4.c> data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        SnapshotStateList<yo4.c> snapshotStateList = this.b;
        if (z) {
            this.f.clear();
            snapshotStateList.clear();
        }
        snapshotStateList.addAll(data);
    }

    public static /* synthetic */ void c(a aVar, List list, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            aVar.b(list, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchData");
    }
}
