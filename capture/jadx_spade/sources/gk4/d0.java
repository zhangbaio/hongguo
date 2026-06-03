package gk4;

import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.UgcActionObjectType;
import com.dragon.read.rpc.kmp.community.model.i5;
import com.dragon.read.rpc.kmp.community.model.l1;
import com.dragon.read.rpc.kmp.community.model.l5;
import com.dragon.read.rpc.kmp.community.model.t0;
import com.dragon.read.rpc.kmp.community.model.t6;
import com.dragon.read.rpc.kmp.community.model.y6;
import gk4.w;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d0 implements jd4.b, w {
    public static final a o;
    public static final int p;
    public final t72.j a;
    private boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public long l;
    public String m;
    public String n;

    static {
        Covode.recordClassIndex(607822);
        o = new a(null);
        p = 8;
    }

    public /* synthetic */ d0(l5 l5Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(l5Var);
    }

    @Override // gk4.w
    public String getType() {
        return "playlet_comment";
    }

    @Override // gk4.w
    public int r() {
        return 2;
    }

    @Override // gk4.w
    public jd4.b u() {
        return this;
    }

    @Override // gk4.v
    public boolean e() {
        return this.k;
    }

    @Override // gk4.w
    public String getCoverUrl() {
        return this.f;
    }

    @Override // gk4.v
    public long getDiggCount() {
        return this.l;
    }

    @Override // gk4.v
    public String getObjectId() {
        return this.c;
    }

    @Override // gk4.w
    public String getTitleText() {
        return this.h;
    }

    @Override // gk4.w
    public String getUserName() {
        return this.j;
    }

    public boolean isShown() {
        return this.b;
    }

    @Override // gk4.w
    public String m() {
        return this.i;
    }

    @Override // gk4.v
    public int a() {
        return UgcActionObjectType.Comment.getValue();
    }

    @Override // gk4.w
    public String b() {
        return w.a.b(this);
    }

    @Override // gk4.w
    public float d() {
        return w.a.f(this);
    }

    @Override // gk4.w
    public List<com.dragon.read.rpc.kmp.community.model.k> f() {
        return w.a.c(this);
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
    public boolean o() {
        return w.a.j(this);
    }

    @Override // gk4.w
    public List<l1> q() {
        return w.a.g(this);
    }

    @Override // gk4.w
    public boolean s() {
        return w.a.i(this);
    }

    @Override // gk4.v
    public void n(long j) {
        this.l = j;
    }

    public void setShown(boolean z) {
        this.b = z;
    }

    @Override // gk4.v
    public void t(boolean z) {
        this.k = z;
    }

    public final void A(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.j = str;
    }

    public final void B(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.m = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.n = str;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void v(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.h = str;
    }

    public final void w(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.g = str;
    }

    public final void x(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void y(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void z(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(607823);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long b(String argbColor) {
            Intrinsics.checkNotNullParameter(argbColor, "argbColor");
            try {
                return com.dragon.read.kmp.utils.i.e(androidx.compose.ui.graphics.l0.j(com.dragon.read.kmp.utils.k.g(com.dragon.read.kmp.utils.k.a, argbColor, null, 2, null)), null, 2, null);
            } catch (Throwable th) {
                com.dragon.read.kmp.j.a.b("PlayletCommentModel", "parse color failed, use default color", th);
                return l0.a.k(androidx.compose.ui.graphics.l0.b, 0.0f, 0.0f, 0.9f, 0.0f, (Rgb) null, 24, (Object) null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final d0 a(l5 ugcComment) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            boolean z;
            long j;
            i5 i5Var;
            String str8;
            Long l;
            Boolean bool;
            t6 t6Var;
            y6 y6Var;
            t6 t6Var2;
            y6 y6Var2;
            com.dragon.read.rpc.kmp.community.model.i0 i0Var;
            i5 i5Var2;
            i5 i5Var3;
            Intrinsics.checkNotNullParameter(ugcComment, "ugcComment");
            String str9 = null;
            d0 d0Var = new d0(ugcComment, 0 == true ? 1 : 0);
            String str10 = ugcComment.a;
            String str11 = "";
            if (str10 == null) {
                str10 = "";
            }
            d0Var.p(str10);
            com.dragon.read.rpc.kmp.community.model.j0 j0Var = ugcComment.g;
            if (j0Var != null) {
                str = j0Var.d;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            d0Var.x(str);
            com.dragon.read.rpc.kmp.community.model.j0 j0Var2 = ugcComment.g;
            if (j0Var2 != null && (i5Var3 = j0Var2.a) != null) {
                str2 = i5Var3.b;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            d0Var.c(str2);
            com.dragon.read.rpc.kmp.community.model.j0 j0Var3 = ugcComment.g;
            if (j0Var3 != null && (i5Var2 = j0Var3.a) != null) {
                str3 = i5Var2.d;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
            d0Var.y(str3);
            com.dragon.read.rpc.kmp.community.model.j0 j0Var4 = ugcComment.g;
            if (j0Var4 != null) {
                str4 = j0Var4.c;
            } else {
                str4 = null;
            }
            if (str4 == null) {
                str4 = "";
            }
            d0Var.w(str4);
            com.dragon.read.rpc.kmp.community.model.h0 h0Var = ugcComment.b;
            if (h0Var != null && (i0Var = h0Var.g) != null) {
                str5 = i0Var.a;
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str5 = "";
            }
            d0Var.v(str5);
            com.dragon.read.rpc.kmp.community.model.h0 h0Var2 = ugcComment.b;
            if (h0Var2 != null && (t6Var2 = h0Var2.b) != null && (y6Var2 = t6Var2.b) != null) {
                str6 = y6Var2.c;
            } else {
                str6 = null;
            }
            if (str6 == null) {
                str6 = "";
            }
            d0Var.z(str6);
            com.dragon.read.rpc.kmp.community.model.h0 h0Var3 = ugcComment.b;
            if (h0Var3 != null && (t6Var = h0Var3.b) != null && (y6Var = t6Var.b) != null) {
                str7 = y6Var.b;
            } else {
                str7 = null;
            }
            if (str7 == null) {
                str7 = "";
            }
            d0Var.A(str7);
            t0 t0Var = ugcComment.d;
            if (t0Var != null && (bool = t0Var.a) != null) {
                z = bool.booleanValue();
            } else {
                z = false;
            }
            d0Var.k = z;
            com.dragon.read.rpc.kmp.community.model.q0 q0Var = ugcComment.c;
            if (q0Var != null && (l = q0Var.a) != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            d0Var.l = j;
            com.dragon.read.rpc.kmp.community.model.j0 j0Var5 = ugcComment.g;
            if (j0Var5 != null) {
                str9 = j0Var5.k;
            }
            if (str9 == null) {
                str9 = "";
            }
            d0Var.B(str9);
            com.dragon.read.rpc.kmp.community.model.j0 j0Var6 = ugcComment.g;
            if (j0Var6 != null && (i5Var = j0Var6.a) != null && (str8 = i5Var.p) != null) {
                str11 = str8;
            }
            d0Var.l(str11);
            return d0Var;
        }
    }

    private d0(l5 l5Var) {
        this.a = new t72.j(l5Var);
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.m = "";
        this.n = "";
    }
}
