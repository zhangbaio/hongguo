package vl4;

import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.dragon.read.seriessdk.rpc.kmp.model.n0;
import gk4.o0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends o0 {
    public static final int h;

    static {
        Covode.recordClassIndex(608200);
        h = 8;
    }

    @Override // gk4.o0, bl4.a
    public org.jetbrains.compose.resources.b E() {
        return b4.R(d4.a);
    }

    @Override // gk4.o0, bl4.a
    public ym4.a w(int i) {
        ym4.a w = super.w(i);
        w.g("profile_tab_name", "other_video");
        return w;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String targetUserId, v6 ugcVideoData, n0 n0Var, boolean z) {
        super(targetUserId, ugcVideoData, n0Var, z);
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(ugcVideoData, "ugcVideoData");
    }
}
