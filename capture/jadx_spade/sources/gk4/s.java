package gk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.UgcActionObjectType;
import com.dragon.read.rpc.kmp.community.model.l1;
import com.dragon.read.rpc.kmp.community.model.m2;
import com.dragon.read.rpc.kmp.community.model.y6;
import gk4.w;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class s extends e implements w {
    public static final int r;
    private boolean j;
    private final y6 k;
    private final m2 l;
    private final List<com.dragon.read.rpc.kmp.community.model.k> m;
    private final String n;
    private final List<l1> o;
    public boolean p;
    public boolean q;

    static {
        Covode.recordClassIndex(607805);
        r = 8;
    }

    @Override // gk4.w
    public String getType() {
        return "图文";
    }

    @Override // gk4.w
    public int r() {
        return 1;
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

    @Override // gk4.w
    public String getCoverUrl() {
        return this.b;
    }

    @Override // gk4.v
    public long getDiggCount() {
        return this.e;
    }

    @Override // gk4.v
    public String getObjectId() {
        return this.a;
    }

    @Override // gk4.w
    public String getTitleText() {
        return this.c;
    }

    @Override // gk4.w
    public boolean o() {
        return this.p;
    }

    @Override // gk4.w
    public List<l1> q() {
        return this.o;
    }

    @Override // gk4.w
    public boolean s() {
        return this.q;
    }

    @Override // gk4.v
    public int a() {
        return UgcActionObjectType.VideoSeriesPost.getValue();
    }

    @Override // gk4.w
    public boolean g() {
        return w.a.a(this);
    }

    @Override // gk4.w
    public String h() {
        return w.a.h(this);
    }

    @Override // gk4.w
    public boolean j() {
        return w.a.k(this);
    }

    @Override // gk4.w
    public List<com.dragon.read.rpc.kmp.community.model.k> f() {
        List<com.dragon.read.rpc.kmp.community.model.k> list = this.m;
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    @Override // gk4.w
    public String getUserName() {
        String str;
        y6 y6Var = this.k;
        if (y6Var == null || (str = y6Var.b) == null) {
            return "";
        }
        return str;
    }

    @Override // gk4.w
    public int i() {
        Integer num;
        m2 m2Var = this.l;
        if (m2Var != null && (num = m2Var.b) != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // gk4.w
    public int k() {
        Integer num;
        m2 m2Var = this.l;
        if (m2Var != null && (num = m2Var.c) != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // gk4.w
    public String m() {
        String str;
        y6 y6Var = this.k;
        if (y6Var == null || (str = y6Var.c) == null) {
            return "";
        }
        return str;
    }

    @Override // gk4.w
    public float d() {
        int i;
        m2 m2Var = this.l;
        if (m2Var == null) {
            return 0.71428573f;
        }
        Integer num = m2Var.b;
        int i2 = 0;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        Integer num2 = this.l.c;
        if (num2 != null) {
            i2 = num2.intValue();
        }
        if (i <= i2) {
            return 0.71428573f;
        }
        return 1.3333334f;
    }

    @Override // gk4.v
    public void n(long j) {
        this.e = j;
    }

    @Override // gk4.v
    public void t(boolean z) {
        this.j = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(String postId, String cover, String title, String authorId, long j, String targetUserId, boolean z, y6 y6Var, m2 m2Var, List<com.dragon.read.rpc.kmp.community.model.k> list, String actorName, List<l1> list2) {
        super(postId, cover, title, authorId, j, targetUserId);
        Intrinsics.checkNotNullParameter(postId, "postId");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(authorId, "authorId");
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(actorName, "actorName");
        this.j = z;
        this.k = y6Var;
        this.l = m2Var;
        this.m = list;
        this.n = actorName;
        this.o = list2;
    }
}
