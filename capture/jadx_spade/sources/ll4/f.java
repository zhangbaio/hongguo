package ll4;

import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.x30;
import com.dragon.read.kmp.utils.i0;
import com.dragon.read.rpc.kmp.community.model.VideoContentType;
import com.dragon.read.rpc.kmp.community.model.l1;
import com.dragon.read.rpc.kmp.community.model.n7;
import com.dragon.read.rpc.kmp.community.model.o7;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends o0 implements at5.g {
    public static final int j;
    private final v6 h;
    private final n0 i;

    static {
        Covode.recordClassIndex(608137);
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

    public String p() {
        return this.h.a;
    }

    public Integer l() {
        return Integer.valueOf(VideoContentType.ShortSeriesPlay.getValue());
    }

    @Override // gk4.o0, bl4.a
    public org.jetbrains.compose.resources.b E() {
        int i;
        Integer num;
        o7 o7Var = this.h.c;
        if (o7Var != null && (num = o7Var.b) != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        if (i <= 0) {
            return null;
        }
        return b4.q(d4.a);
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
    public String F() {
        int i;
        Integer num;
        o7 o7Var = this.h.c;
        if (o7Var != null && (num = o7Var.b) != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        if (i <= 0) {
            return null;
        }
        return i0.a.a(i) + "热度";
    }

    @Override // bl4.a
    public x30 N() {
        l1 l1Var;
        n7 n7Var = this.h.e;
        if (n7Var != null && (l1Var = n7Var.r) != null) {
            return new x30(l1Var.b, l1Var.c, l1Var.d, (String) null, (String) null, (Boolean) null, l1Var.e, l1Var.f, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, 524088, (DefaultConstructorMarker) null);
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
        String str;
        ym4.a w = super.w(i);
        if (N() != null) {
            x30 N = N();
            if (N != null) {
                str = N.a;
            } else {
                str = null;
            }
            w.g("upper_right_info", str);
        }
        w.g("profile_tab_name", "profile_starred_video");
        w.g("profile_user_id", this.c);
        return w;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String targetUserId, v6 ugcVideoData, n0 n0Var) {
        super(targetUserId, ugcVideoData, n0Var, false, 8, null);
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(ugcVideoData, "ugcVideoData");
        this.h = ugcVideoData;
        this.i = n0Var;
    }
}
