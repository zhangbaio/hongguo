package ll4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.b6;
import com.dragon.read.rpc.kmp.community.model.r4;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.dragon.read.seriessdk.rpc.kmp.model.n0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g extends wl4.b {
    public static final int h;
    private final boolean e;
    private final ProfileTab f;
    private final ProfileTab g;

    static {
        Covode.recordClassIndex(608138);
        h = 8;
    }

    @Override // wl4.b, wl4.a
    public boolean d() {
        return false;
    }

    @Override // wl4.b, wl4.a
    public boolean h() {
        return false;
    }

    @Override // wl4.b, wl4.a
    public ProfileTab e() {
        return this.f;
    }

    @Override // wl4.b, wl4.a
    public ProfileTab f() {
        return this.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(boolean z, ProfileTab dependProfileTab, ProfileTab profileTab) {
        super(false, null, 3, null);
        Intrinsics.checkNotNullParameter(dependProfileTab, "dependProfileTab");
        this.e = z;
        this.f = dependProfileTab;
        this.g = profileTab;
    }

    @Override // wl4.b, wl4.a
    public Object b(String targetUserId, b6 b6Var, n0 n0Var) {
        r4 r4Var;
        v6 v6Var;
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        if (b6Var != null) {
            r4Var = b6Var.m;
        } else {
            r4Var = null;
        }
        if (r4Var == null) {
            if (b6Var == null || (v6Var = b6Var.g) == null) {
                return null;
            }
            if (this.e) {
                return new b(targetUserId, v6Var, n0Var);
            }
            return new f(targetUserId, v6Var, n0Var);
        }
        if (this.g == ProfileTab.SubscribeWorks) {
            return new e(new d(targetUserId, b6Var, n0Var));
        }
        return new d(targetUserId, b6Var, n0Var);
    }
}
