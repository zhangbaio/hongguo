package hl4;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.e0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jl4.b;
import kd4.c;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tl4.l;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends l implements kd4.a {
    private final e0<String, Boolean> m;

    static {
        Covode.recordClassIndex(608120);
    }

    public void x0() {
    }

    @Override // tl4.l
    public void H() {
        super.H();
        c.d(this);
    }

    @Override // tl4.l
    protected void F(List<? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.F(data);
        g0(data, false);
    }

    @Override // tl4.l
    public void G(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        super.G(scope);
        c.c(this);
    }

    @Override // tl4.l
    protected void y(List<? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.y(data);
        g0(data, true);
    }

    public final boolean f0(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Object obj = this.m.get(seriesId);
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        return ((Boolean) obj).booleanValue();
    }

    public void V(List<String> seriesIds) {
        Intrinsics.checkNotNullParameter(seriesIds, "seriesIds");
        for (String str : seriesIds) {
            if (this.m.containsKey(str)) {
                this.m.put(str, Boolean.FALSE);
            }
        }
    }

    public void b0(List<String> seriesList) {
        Intrinsics.checkNotNullParameter(seriesList, "seriesList");
        for (String str : seriesList) {
            if (this.m.containsKey(str)) {
                this.m.put(str, Boolean.TRUE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(rl4.c tabParam, rl4.a uiConfig) {
        super(tabParam, uiConfig);
        Intrinsics.checkNotNullParameter(tabParam, "tabParam");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        this.m = SnapshotStateKt.mutableStateMapOf();
    }

    private final void g0(List<? extends Object> list, boolean z) {
        if (z) {
            this.m.clear();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((b) it2.next()).a);
        }
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            String str = ((z) it4.next()).a;
            if (str != null) {
                this.m.put(str, Boolean.valueOf(c.b(str)));
            }
        }
    }
}
