package ws3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.ClientReqType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final int b;
    public ClientReqType a = ClientReqType.Other;

    static {
        Covode.recordClassIndex(599163);
        b = 8;
    }

    public final void a(ClientReqType clientReqType) {
        Intrinsics.checkNotNullParameter(clientReqType, "clientReqType");
        this.a = clientReqType;
    }
}
