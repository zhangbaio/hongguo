package wl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.UgcCommentGroupTypeOutter;
import com.dragon.read.rpc.kmp.community.model.UgcRelativeType;
import com.dragon.read.rpc.kmp.community.model.b6;
import com.dragon.read.rpc.kmp.community.model.d3;
import com.dragon.read.rpc.kmp.community.model.e6;
import com.dragon.read.rpc.kmp.community.model.f3;
import com.dragon.read.rpc.kmp.community.model.g3;
import com.dragon.read.rpc.kmp.community.model.h0;
import com.dragon.read.rpc.kmp.community.model.i3;
import com.dragon.read.rpc.kmp.community.model.k7;
import com.dragon.read.rpc.kmp.community.model.l5;
import com.dragon.read.rpc.kmp.community.model.m2;
import com.dragon.read.rpc.kmp.community.model.n7;
import com.dragon.read.rpc.kmp.community.model.o7;
import com.dragon.read.rpc.kmp.community.model.r7;
import com.dragon.read.rpc.kmp.community.model.t6;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.dragon.read.rpc.kmp.community.model.y6;
import com.dragon.read.seriessdk.rpc.kmp.model.n0;
import gk4.d0;
import gk4.o0;
import gk4.r;
import gk4.s;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wl4.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b implements a {
    public static final int d;
    public final boolean a;
    private final String b;
    public String c;

    static {
        Covode.recordClassIndex(608217);
        d = 8;
    }

    @Override // wl4.a
    public boolean d() {
        return true;
    }

    @Override // wl4.a
    public ProfileTab f() {
        return null;
    }

    @Override // wl4.a
    public boolean h() {
        return true;
    }

    @Override // wl4.a
    public ProfileTab e() {
        return ProfileTab.Video;
    }

    @Override // wl4.a
    public String a() {
        return a.C0283a.a(this);
    }

    @Override // wl4.a
    public String g() {
        return a.C0283a.b(this);
    }

    @Override // wl4.a
    public void c(String justSawVid) {
        Intrinsics.checkNotNullParameter(justSawVid, "justSawVid");
        this.c = justSawVid;
    }

    private final Object i(l5 l5Var) {
        Integer num;
        if (l5Var == null) {
            return null;
        }
        h0 h0Var = l5Var.b;
        if (h0Var != null) {
            num = h0Var.e;
        } else {
            num = null;
        }
        int value = UgcCommentGroupTypeOutter.Book.getValue();
        if (num == null || num.intValue() != value) {
            return null;
        }
        return d0.o.a(l5Var);
    }

    public b(boolean z, String actorName) {
        Intrinsics.checkNotNullParameter(actorName, "actorName");
        this.a = z;
        this.b = actorName;
        this.c = "";
    }

    @Override // wl4.a
    public Object b(String targetUserId, b6 b6Var, n0 n0Var) {
        e6 e6Var;
        v6 v6Var;
        String str;
        String str2;
        String str3;
        String str4;
        Integer num;
        t6 t6Var;
        String str5;
        m2 m2Var;
        e6 e6Var2;
        v6 v6Var2;
        String str6;
        boolean z;
        y6 y6Var;
        List list;
        String str7;
        k7 k7Var;
        t6 t6Var2;
        k7 k7Var2;
        Boolean bool;
        Boolean bool2;
        Integer num2;
        String str8;
        String str9;
        String str10;
        y6 y6Var2;
        m2 m2Var2;
        List list2;
        List list3;
        t6 t6Var3;
        Boolean bool3;
        Integer num3;
        t6 t6Var4;
        String str11;
        m2 m2Var3;
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        long j = 0;
        String str12 = "";
        String str13 = null;
        if (this.a) {
            if (b6Var != null) {
                e6Var2 = b6Var.d;
            } else {
                e6Var2 = null;
            }
            if (b6Var != null) {
                v6Var2 = b6Var.g;
            } else {
                v6Var2 = null;
            }
            boolean z2 = false;
            if (e6Var2 != null) {
                d3 d3Var = e6Var2.b;
                if (d3Var == null || (m2Var3 = d3Var.j) == null || (str8 = m2Var3.k) == null) {
                    str8 = "";
                }
                if (d3Var == null || (str9 = d3Var.g) == null) {
                    str9 = "";
                }
                if (d3Var == null || (t6Var4 = d3Var.c) == null || (str11 = t6Var4.a) == null) {
                    str10 = "";
                } else {
                    str10 = str11;
                }
                g3 g3Var = e6Var2.c;
                if (g3Var != null && (num3 = g3Var.c) != null) {
                    j = num3.intValue();
                }
                long j2 = j;
                String str14 = e6Var2.a;
                if (str14 != null) {
                    str12 = str14;
                }
                i3 i3Var = e6Var2.d;
                if (i3Var != null && (bool3 = i3Var.b) != null) {
                    z2 = bool3.booleanValue();
                }
                d3 d3Var2 = e6Var2.b;
                if (d3Var2 != null && (t6Var3 = d3Var2.c) != null) {
                    y6Var2 = t6Var3.b;
                } else {
                    y6Var2 = null;
                }
                if (d3Var2 != null) {
                    m2Var2 = d3Var2.j;
                } else {
                    m2Var2 = null;
                }
                f3 f3Var = e6Var2.e;
                if (f3Var != null) {
                    list2 = f3Var.Q;
                } else {
                    list2 = null;
                }
                String str15 = this.b;
                if (f3Var != null) {
                    list3 = f3Var.R;
                } else {
                    list3 = null;
                }
                return new s(str12, str8, str9, str10, j2, targetUserId, z2, y6Var2, m2Var2, list2, str15, list3);
            }
            if (v6Var2 != null) {
                o7 o7Var = v6Var2.c;
                if (o7Var != null && (num2 = o7Var.c) != null) {
                    j = num2.intValue();
                }
                long j3 = j;
                r7 r7Var = v6Var2.d;
                if (r7Var != null && (bool2 = r7Var.a) != null) {
                    z2 = bool2.booleanValue();
                }
                String str16 = this.c;
                v6 v6Var3 = b6Var.g;
                if (v6Var3 != null) {
                    str6 = v6Var3.a;
                } else {
                    str6 = null;
                }
                boolean areEqual = Intrinsics.areEqual(str16, str6);
                v6 v6Var4 = b6Var.g;
                if (v6Var4 != null && (k7Var2 = v6Var4.b) != null && (bool = k7Var2.h) != null) {
                    z = bool.booleanValue();
                } else {
                    z = true;
                }
                v6 v6Var5 = b6Var.g;
                if (v6Var5 != null && (k7Var = v6Var5.b) != null && (t6Var2 = k7Var.e) != null) {
                    y6Var = t6Var2.b;
                } else {
                    y6Var = null;
                }
                n7 n7Var = v6Var2.e;
                if (n7Var != null) {
                    list = n7Var.o;
                } else {
                    list = null;
                }
                String str17 = this.b;
                if (n7Var != null) {
                    str7 = n7Var.p;
                } else {
                    str7 = null;
                }
                return new r(targetUserId, v6Var2, n0Var, areEqual, j3, z2, z, y6Var, list, str17, str7);
            }
            if (b6Var != null) {
                Integer num4 = b6Var.a;
                int value = UgcRelativeType.Comment.getValue();
                if (num4 != null && num4.intValue() == value) {
                    z2 = true;
                }
            }
            if (!z2) {
                return null;
            }
            return i(b6Var.b);
        }
        if (b6Var != null) {
            e6Var = b6Var.d;
        } else {
            e6Var = null;
        }
        if (e6Var != null) {
            d3 d3Var3 = e6Var.b;
            if (d3Var3 == null || (m2Var = d3Var3.j) == null || (str = m2Var.k) == null) {
                str = "";
            }
            if (d3Var3 == null || (str2 = d3Var3.g) == null) {
                str2 = "";
            }
            if (d3Var3 == null || (t6Var = d3Var3.c) == null || (str5 = t6Var.a) == null) {
                str3 = "";
            } else {
                str3 = str5;
            }
            g3 g3Var2 = e6Var.c;
            if (g3Var2 != null && (num = g3Var2.c) != null) {
                j = num.intValue();
            }
            long j4 = j;
            String str18 = e6Var.a;
            if (str18 == null) {
                str4 = "";
            } else {
                str4 = str18;
            }
            return new gk4.n0(str4, str, str2, str3, j4, targetUserId);
        }
        if (b6Var == null || (v6Var = b6Var.g) == null) {
            return null;
        }
        String str19 = this.c;
        v6 v6Var6 = b6Var.g;
        if (v6Var6 != null) {
            str13 = v6Var6.a;
        }
        return new o0(targetUserId, v6Var, n0Var, Intrinsics.areEqual(str19, str13));
    }

    public /* synthetic */ b(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
    }
}
