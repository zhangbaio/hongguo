package gk4;

import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.i1;
import com.dragon.read.rpc.kmp.community.model.k7;
import com.dragon.read.rpc.kmp.community.model.o7;
import com.dragon.read.rpc.kmp.community.model.t6;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.dragon.read.seriessdk.rpc.kmp.model.v1;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class o0 extends bl4.a {
    public static final int g;
    public final String c;
    private final v6 d;
    private final com.dragon.read.seriessdk.rpc.kmp.model.n0 e;
    public boolean f;

    static {
        Covode.recordClassIndex(607845);
        g = 8;
    }

    @Override // bl4.a
    public String A() {
        return "pugc_material";
    }

    @Override // bl4.a
    public String L() {
        return null;
    }

    @Override // bl4.a
    public String z() {
        return null;
    }

    public Object O() {
        return this.d;
    }

    @Override // bl4.a
    public org.jetbrains.compose.resources.b E() {
        return b4.b0(d4.a);
    }

    @Override // bl4.a
    public List<String> J() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // bl4.a
    public String C() {
        v1 v1Var;
        v1 v1Var2;
        List list;
        Object firstOrNull;
        com.dragon.read.seriessdk.rpc.kmp.model.n0 n0Var = this.e;
        if (n0Var != null && (v1Var2 = n0Var.a) != null && (list = v1Var2.H) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            v1Var = (v1) firstOrNull;
        } else {
            v1Var = null;
        }
        if (v1Var == null) {
            return null;
        }
        return v1Var.s;
    }

    @Override // bl4.a
    public String F() {
        int i;
        o7 o7Var;
        Integer num;
        v6 v6Var = this.d;
        if (v6Var != null && (o7Var = v6Var.c) != null && (num = o7Var.a) != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        return i1.a.a(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0022 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // bl4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String G() {
        /*
            r1 = this;
            com.dragon.read.rpc.kmp.community.model.v6 r0 = r1.d
            if (r0 == 0) goto L8
            java.lang.String r0 = r0.a
            if (r0 != 0) goto L24
        L8:
            com.dragon.read.seriessdk.rpc.kmp.model.n0 r0 = r1.e
            if (r0 == 0) goto L1f
            com.dragon.read.seriessdk.rpc.kmp.model.v1 r0 = r0.a
            if (r0 == 0) goto L1f
            java.util.List r0 = r0.g
            if (r0 == 0) goto L1f
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            com.dragon.read.seriessdk.rpc.kmp.model.q r0 = (com.dragon.read.seriessdk.rpc.kmp.model.q) r0
            if (r0 == 0) goto L1f
            java.lang.String r0 = r0.a
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 != 0) goto L24
            java.lang.String r0 = ""
        L24:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: gk4.o0.G():java.lang.String");
    }

    @Override // bl4.a
    public String I() {
        v1 v1Var;
        List list;
        Object firstOrNull;
        String str;
        v6 v6Var = this.d;
        if (v6Var == null || (str = v6Var.a) == null) {
            com.dragon.read.seriessdk.rpc.kmp.model.n0 n0Var = this.e;
            if (n0Var != null && (v1Var = n0Var.a) != null && (list = v1Var.g) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                com.dragon.read.seriessdk.rpc.kmp.model.q qVar = (com.dragon.read.seriessdk.rpc.kmp.model.q) firstOrNull;
                if (qVar != null) {
                    return qVar.a;
                }
            }
            return null;
        }
        return str;
    }

    @Override // bl4.a
    public String K() {
        v1 v1Var;
        List list;
        Object firstOrNull;
        k7 k7Var;
        String str;
        v6 v6Var = this.d;
        if (v6Var == null || (k7Var = v6Var.b) == null || (str = k7Var.c) == null) {
            com.dragon.read.seriessdk.rpc.kmp.model.n0 n0Var = this.e;
            if (n0Var != null && (v1Var = n0Var.a) != null && (list = v1Var.g) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                com.dragon.read.seriessdk.rpc.kmp.model.q qVar = (com.dragon.read.seriessdk.rpc.kmp.model.q) firstOrNull;
                if (qVar != null) {
                    return qVar.d;
                }
            }
            return null;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0026 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // bl4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String y() {
        /*
            r1 = this;
            com.dragon.read.rpc.kmp.community.model.v6 r0 = r1.d
            if (r0 == 0) goto Lc
            com.dragon.read.rpc.kmp.community.model.k7 r0 = r0.b
            if (r0 == 0) goto Lc
            java.lang.String r0 = r0.b
            if (r0 != 0) goto L28
        Lc:
            com.dragon.read.seriessdk.rpc.kmp.model.n0 r0 = r1.e
            if (r0 == 0) goto L23
            com.dragon.read.seriessdk.rpc.kmp.model.v1 r0 = r0.a
            if (r0 == 0) goto L23
            java.util.List r0 = r0.g
            if (r0 == 0) goto L23
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            com.dragon.read.seriessdk.rpc.kmp.model.q r0 = (com.dragon.read.seriessdk.rpc.kmp.model.q) r0
            if (r0 == 0) goto L23
            java.lang.String r0 = r0.b
            goto L24
        L23:
            r0 = 0
        L24:
            if (r0 != 0) goto L28
            java.lang.String r0 = ""
        L28:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: gk4.o0.y():java.lang.String");
    }

    @Override // bl4.a
    public ym4.a w(int i) {
        String str;
        k7 k7Var;
        t6 t6Var;
        ym4.a w = super.w(i);
        w.g("card_type", "video");
        String K = K();
        String str2 = "";
        if (K == null) {
            K = "";
        }
        w.g("card_title", K);
        v6 v6Var = this.d;
        if (v6Var != null && (k7Var = v6Var.b) != null && (t6Var = k7Var.e) != null) {
            str = t6Var.a;
        } else {
            str = null;
        }
        w.g("card_user_id", str);
        String I = I();
        if (I != null) {
            str2 = I;
        }
        w.g("post_card_id", str2);
        if (this.f) {
            w.g("consumed_type", "just_watch");
        }
        return w;
    }

    public o0(String targetUserId, v6 v6Var, com.dragon.read.seriessdk.rpc.kmp.model.n0 n0Var, boolean z) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        this.c = targetUserId;
        this.d = v6Var;
        this.e = n0Var;
        this.f = z;
    }

    public /* synthetic */ o0(String str, v6 v6Var, com.dragon.read.seriessdk.rpc.kmp.model.n0 n0Var, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, v6Var, n0Var, (i & 8) != 0 ? false : z);
    }
}
