package ht3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.SaaSVideoDetailData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final int d;
    public final String a;
    public final SaaSVideoDetailData b;
    public final boolean c;

    static {
        Covode.recordClassIndex(599229);
        d = 8;
    }

    public o(String uploadScene, SaaSVideoDetailData data, boolean z) {
        Intrinsics.checkNotNullParameter(uploadScene, "uploadScene");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = uploadScene;
        this.b = data;
        this.c = z;
    }
}
