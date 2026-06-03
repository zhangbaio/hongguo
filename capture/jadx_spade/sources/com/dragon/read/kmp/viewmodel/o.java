package com.dragon.read.kmp.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.e0;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import gk4.f0;
import gk4.g0;
import gk4.h0;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class o extends ViewModel implements kd4.a, kd4.b, xm4.b {
    public static final int i;
    public final xm4.a a;
    public f0 b;
    private final e0<String, Boolean> c;
    private final e0<String, Boolean> d;
    public g0 e;
    private final MutableState f;
    private final MutableState g;
    public MutableStateFlow<Long> h;

    static {
        Covode.recordClassIndex(609601);
        i = 8;
    }

    public abstract void J0(g0 g0Var, Function1<? super f0, Unit> function1, Function1<? super Throwable, Unit> function12);

    public void x0() {
    }

    public final g0 E0() {
        return this.a.getParams();
    }

    @Override // xm4.b
    public boolean F() {
        return G0();
    }

    public final long F0() {
        return ((Number) this.g.getValue()).longValue();
    }

    public final boolean G0() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    protected void onCleared() {
        super.onCleared();
        kd4.c.d(this);
        kd4.e.b(this);
    }

    public void refresh() {
        List<h0> list;
        f0 f0Var = this.b;
        if (f0Var != null && (list = f0Var.c) != null) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                ((h0) it2.next()).setShown(false);
            }
        }
        if (!Intrinsics.areEqual(this.e, E0())) {
            L0(false);
            this.b = null;
            M0(F0() + 1);
        } else {
            com.dragon.read.kmp.j.a.d("RelationSeriesViewModel", "RelationSeriesViewModel refresh params not change " + E0());
        }
        MutableStateFlow<Long> mutableStateFlow = this.h;
        mutableStateFlow.setValue(Long.valueOf(mutableStateFlow.getValue().longValue() + 1));
    }

    public final Boolean I0(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        return (Boolean) this.d.get(seriesId);
    }

    public final void L0(boolean z) {
        this.f.setValue(Boolean.valueOf(z));
    }

    public final void M0(long j) {
        this.g.setValue(Long.valueOf(j));
    }

    public final boolean H0(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Object obj = this.c.get(seriesId);
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public o(xm4.a iDepend) {
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.a = iDepend;
        this.c = SnapshotStateKt.mutableStateMapOf();
        this.d = SnapshotStateKt.mutableStateMapOf();
        this.f = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.g = SnapshotStateKt.mutableStateOf$default(0L, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = StateFlowKt.MutableStateFlow(0L);
        kd4.c.c(this);
        kd4.e.a(this);
    }

    protected final void N0(List<h0> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.c.clear();
        for (h0 h0Var : list) {
            if (!h0Var.f()) {
                e0<String, Boolean> e0Var = this.c;
                String str = h0Var.d;
                e0Var.put(str, Boolean.valueOf(kd4.c.b(str)));
            }
        }
    }

    public void O(List<Pair<String, Boolean>> reserveStateList) {
        Intrinsics.checkNotNullParameter(reserveStateList, "reserveStateList");
        this.d.clear();
        Iterator<T> it2 = reserveStateList.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            this.d.put((String) pair.component1(), Boolean.valueOf(((Boolean) pair.component2()).booleanValue()));
        }
    }

    protected final void O0(List<h0> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        for (h0 h0Var : list) {
            if (!h0Var.f()) {
                e0<String, Boolean> e0Var = this.c;
                String str = h0Var.d;
                e0Var.put(str, Boolean.valueOf(kd4.c.b(str)));
            }
        }
    }

    public void V(List<String> seriesIds) {
        Intrinsics.checkNotNullParameter(seriesIds, "seriesIds");
        for (String str : seriesIds) {
            if (this.c.containsKey(str)) {
                this.c.put(str, Boolean.FALSE);
            }
        }
    }

    public void b0(List<String> seriesList) {
        Intrinsics.checkNotNullParameter(seriesList, "seriesList");
        for (String str : seriesList) {
            if (this.c.containsKey(str)) {
                this.c.put(str, Boolean.TRUE);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void K0(o oVar, g0 g0Var, Function1 function1, Function1 function12, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                function1 = null;
            }
            if ((i2 & 4) != 0) {
                function12 = null;
            }
            oVar.J0(g0Var, function1, function12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
    }
}
