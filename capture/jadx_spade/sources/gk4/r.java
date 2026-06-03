package gk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UseStatus;
import com.bytedance.kmp.ugc.model.UgcActionObjectType;
import com.dragon.read.rpc.kmp.community.model.l1;
import com.dragon.read.rpc.kmp.community.model.n7;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.dragon.read.rpc.kmp.community.model.y6;
import gk4.w;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r extends o0 implements w {
    public static final int r;
    private final v6 h;
    private long i;
    private boolean j;
    private final boolean k;
    private final y6 l;
    private final List<com.dragon.read.rpc.kmp.community.model.k> m;
    private final String n;
    private final String o;
    public boolean p;
    public boolean q;

    static {
        Covode.recordClassIndex(607804);
        r = 8;
    }

    @Override // gk4.w
    public String getType() {
        return "视频";
    }

    @Override // gk4.w
    public int r() {
        return 0;
    }

    @Override // gk4.w
    public jd4.b u() {
        return this;
    }

    @Override // gk4.w
    public String b() {
        return this.n;
    }

    @Override // gk4.v
    public boolean e() {
        return this.j;
    }

    @Override // gk4.v
    public long getDiggCount() {
        return this.i;
    }

    @Override // gk4.w
    public boolean o() {
        return this.p;
    }

    @Override // gk4.w
    public boolean s() {
        return this.q;
    }

    @Override // gk4.v
    public int a() {
        return UgcActionObjectType.Book.getValue();
    }

    @Override // gk4.w
    public boolean g() {
        return w.a.a(this);
    }

    @Override // gk4.w
    public String getCoverUrl() {
        return y();
    }

    @Override // gk4.w
    public int i() {
        return w.a.e(this);
    }

    @Override // gk4.w
    public boolean j() {
        return w.a.k(this);
    }

    @Override // gk4.w
    public int k() {
        return w.a.d(this);
    }

    @Override // gk4.w
    public float d() {
        if (this.k) {
            return 0.71428573f;
        }
        return 1.3333334f;
    }

    @Override // gk4.w
    public List<com.dragon.read.rpc.kmp.community.model.k> f() {
        List<com.dragon.read.rpc.kmp.community.model.k> list = this.m;
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    @Override // gk4.v
    public String getObjectId() {
        v6 v6Var = this.h;
        if (v6Var != null) {
            return v6Var.a;
        }
        return null;
    }

    @Override // gk4.w
    public String getUserName() {
        String str;
        y6 y6Var = this.l;
        if (y6Var == null || (str = y6Var.b) == null) {
            return "";
        }
        return str;
    }

    @Override // gk4.w
    public String m() {
        String str;
        y6 y6Var = this.l;
        if (y6Var == null || (str = y6Var.c) == null) {
            return "";
        }
        return str;
    }

    @Override // gk4.w
    public List<l1> q() {
        n7 n7Var;
        v6 v6Var = this.h;
        if (v6Var != null && (n7Var = v6Var.e) != null) {
            return n7Var.a;
        }
        return null;
    }

    @Override // gk4.w
    public String getTitleText() {
        if (H().getValue() == UseStatus.OfflineStatus.getValue()) {
            return "****";
        }
        String K = K();
        if (K == null) {
            return "";
        }
        return K;
    }

    @Override // gk4.w
    public String h() {
        String str = this.o;
        if (Intrinsics.areEqual(str, "pugc_preview_video")) {
            return "预告";
        }
        if (Intrinsics.areEqual(str, "pugc_push_video")) {
            return "高光";
        }
        return "视频";
    }

    @Override // gk4.v
    public void n(long j) {
        this.i = j;
    }

    @Override // gk4.v
    public void t(boolean z) {
        this.j = z;
    }

    @Override // gk4.o0, bl4.a
    public ym4.a w(int i) {
        ym4.a w = super.w(i);
        w.g("profile_user_id", this.c);
        w.g("like_count", Long.valueOf(getDiggCount()));
        return w;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(String targetUserId, v6 v6Var, com.dragon.read.seriessdk.rpc.kmp.model.n0 n0Var, boolean z, long j, boolean z2, boolean z3, y6 y6Var, List<com.dragon.read.rpc.kmp.community.model.k> list, String actorName, String str) {
        super(targetUserId, v6Var, n0Var, z);
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(actorName, "actorName");
        this.h = v6Var;
        this.i = j;
        this.j = z2;
        this.k = z3;
        this.l = y6Var;
        this.m = list;
        this.n = actorName;
        this.o = str;
    }
}
