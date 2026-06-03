package ll4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.l1;
import com.dragon.read.rpc.kmp.community.model.n7;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.dragon.read.seriessdk.rpc.kmp.model.n0;
import com.dragon.read.seriessdk.rpc.kmp.model.q;
import com.dragon.read.seriessdk.rpc.kmp.model.v1;
import gk4.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends o0 {
    public static final int j;
    private final v6 h;
    private final n0 i;

    static {
        Covode.recordClassIndex(608134);
        j = 8;
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
        List list;
        boolean z;
        n7 n7Var = this.h.e;
        if (n7Var != null) {
            list = n7Var.a;
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return new ArrayList();
        }
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

    @Override // gk4.o0, bl4.a
    public ym4.a w(int i) {
        ym4.a w = super.w(i);
        w.g("profile_tab_name", "profile_starred_video");
        w.g("profile_user_id", this.c);
        return w;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String targetUserId, v6 ugcVideoData, n0 n0Var) {
        super(targetUserId, ugcVideoData, n0Var, false, 8, null);
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(ugcVideoData, "ugcVideoData");
        this.h = ugcVideoData;
        this.i = n0Var;
    }
}
