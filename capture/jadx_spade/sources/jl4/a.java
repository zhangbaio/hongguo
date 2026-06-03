package jl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.v6;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements jd4.b {
    public static final int c;
    public final v6 a;
    private boolean b;

    static {
        Covode.recordClassIndex(608123);
        c = 8;
    }

    public boolean isShown() {
        return this.b;
    }

    public void setShown(boolean z) {
        this.b = z;
    }

    public a(v6 ugcVideoData) {
        Intrinsics.checkNotNullParameter(ugcVideoData, "ugcVideoData");
        this.a = ugcVideoData;
    }
}
