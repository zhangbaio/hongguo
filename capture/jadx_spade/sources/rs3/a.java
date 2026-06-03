package rs3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasClientReqType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final int a;
    public final int b;
    public final SaasClientReqType c;
    public final int d;

    static {
        Covode.recordClassIndex(599056);
    }

    public a(int i, int i2, SaasClientReqType saasClientReqType, int i3) {
        Intrinsics.checkNotNullParameter(saasClientReqType, "saasClientReqType");
        this.a = i;
        this.b = i2;
        this.c = saasClientReqType;
        this.d = i3;
    }
}
