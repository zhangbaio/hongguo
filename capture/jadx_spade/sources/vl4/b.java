package vl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.b6;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.dragon.read.seriessdk.rpc.kmp.model.n0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends wl4.b {
    public static final a f;
    public static final int g;
    private static String h;
    private final boolean e;

    public static final class a {
        static {
            Covode.recordClassIndex(608202);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608201);
        f = new a(null);
        g = 8;
    }

    @Override // wl4.b, wl4.a
    public ProfileTab e() {
        if (this.e) {
            return ProfileTab.Video;
        }
        return ProfileTab.PugcVideo;
    }

    public b(boolean z) {
        super(false, null, 3, null);
        this.e = z;
    }

    @Override // wl4.b, wl4.a
    public Object b(String targetUserId, b6 b6Var, n0 n0Var) {
        v6 v6Var;
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        String str = null;
        if (b6Var == null || (v6Var = b6Var.g) == null) {
            return null;
        }
        String str2 = h;
        v6 v6Var2 = b6Var.g;
        if (v6Var2 != null) {
            str = v6Var2.a;
        }
        return new vl4.a(targetUserId, v6Var, n0Var, Intrinsics.areEqual(str2, str));
    }
}
