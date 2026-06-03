package ll4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.x30;
import com.dragon.read.rpc.kmp.community.model.b6;
import com.dragon.read.rpc.kmp.community.model.l1;
import com.dragon.read.rpc.kmp.community.model.r4;
import com.dragon.read.seriessdk.rpc.kmp.model.n0;
import com.dragon.read.seriessdk.rpc.kmp.model.q;
import com.dragon.read.seriessdk.rpc.kmp.model.v1;
import gk4.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends o0 implements com.dragon.read.kmp.subscribe.a {
    public static final int k;
    public final b6 h;
    public final n0 i;
    private final Lazy j;

    static {
        Covode.recordClassIndex(608135);
        k = 8;
    }

    @Override // gk4.o0, bl4.a
    public String A() {
        return "series";
    }

    @Override // gk4.o0, bl4.a
    public String C() {
        return null;
    }

    @Override // gk4.o0, bl4.a
    public org.jetbrains.compose.resources.b E() {
        return null;
    }

    @Override // gk4.o0, bl4.a
    public String F() {
        return null;
    }

    @Override // gk4.o0, bl4.a
    public String G() {
        r4 r4Var;
        String str;
        b6 b6Var = this.h;
        if (b6Var == null || (r4Var = b6Var.m) == null || (str = r4Var.a) == null) {
            return "";
        }
        return str;
    }

    @Override // gk4.o0, bl4.a
    public String K() {
        r4 r4Var;
        b6 b6Var = this.h;
        if (b6Var != null && (r4Var = b6Var.m) != null) {
            return r4Var.c;
        }
        return null;
    }

    public final MutableState<Boolean> R() {
        return (MutableState) this.j.getValue();
    }

    @Override // gk4.o0, bl4.a
    public String y() {
        r4 r4Var;
        String str;
        b6 b6Var = this.h;
        if (b6Var == null || (r4Var = b6Var.m) == null || (str = r4Var.b) == null) {
            return "";
        }
        return str;
    }

    @Override // gk4.o0, bl4.a
    public String z() {
        v1 v1Var;
        List list;
        Object firstOrNull;
        n0 n0Var = this.i;
        if (n0Var != null && (v1Var = n0Var.a) != null && (list = v1Var.g) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            q qVar = (q) firstOrNull;
            if (qVar != null) {
                return qVar.a;
            }
        }
        return null;
    }

    @Override // gk4.o0, bl4.a
    public List<String> J() {
        r4 r4Var;
        List list;
        b6 b6Var = this.h;
        if (b6Var != null && (r4Var = b6Var.m) != null && (list = r4Var.f) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String str = ((l1) it2.next()).b;
                if (str == null) {
                    str = "";
                }
                arrayList.add(str);
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // bl4.a
    public x30 N() {
        l1 l1Var;
        r4 r4Var = this.h.m;
        if (r4Var != null && (l1Var = r4Var.e) != null) {
            return new x30(l1Var.b, l1Var.c, l1Var.d, (String) null, (String) null, (Boolean) null, l1Var.e, l1Var.f, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, 524088, (DefaultConstructorMarker) null);
        }
        return null;
    }

    public final void Q(boolean z) {
        R().setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState S(d dVar) {
        boolean z;
        Boolean bool;
        r4 r4Var = dVar.h.m;
        if (r4Var != null && (bool = r4Var.g) != null) {
            z = bool.booleanValue();
        } else {
            z = false;
        }
        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    @Override // gk4.o0, bl4.a
    public ym4.a w(int i) {
        String str;
        ym4.a v = v(i);
        r4 r4Var = this.h.m;
        String str2 = null;
        if (r4Var != null) {
            str = r4Var.a;
        } else {
            str = null;
        }
        v.g("virtual_src_material_id", str);
        v.g("profile_tab_name", "profile_starred_video");
        v.g("card_position", "actor_page");
        if (r4Var != null) {
            str2 = r4Var.c;
        }
        v.g("material_name", str2);
        return v;
    }

    @Override // com.dragon.read.kmp.subscribe.a
    public void c(String seriesId, boolean z) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        if (Intrinsics.areEqual(G(), seriesId)) {
            Q(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String targetUserId, b6 ugcMixData, n0 n0Var) {
        super(targetUserId, ugcMixData.g, n0Var, false, 8, null);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(ugcMixData, "ugcMixData");
        this.h = ugcMixData;
        this.i = n0Var;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ll4.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MutableState S;
                S = d.S(d.this);
                return S;
            }
        });
        this.j = lazy;
    }
}
