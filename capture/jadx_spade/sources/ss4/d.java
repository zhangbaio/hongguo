package ss4;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.ss.android.messagebus.BusProvider;
import kotlin.jvm.internal.Intrinsics;
import ss4.a;

@XBridgeMethod(name = "readingHideSeriesNonStandardAd", owner = "chenhaobin")
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends a {
    public static final int f;

    static {
        Covode.recordClassIndex(612477);
        f = 8;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void handle(IBDXBridgeContext bridgeContext, a.b params, CompletionBlock<a.c> callback) {
        int i;
        boolean z;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity != null) {
            i = ownerActivity.hashCode();
        } else {
            i = 0;
        }
        String planId = params.getPlanId();
        String materialId = params.getMaterialId();
        String type = params.getType();
        Boolean needResumePlay = params.getNeedResumePlay();
        if (needResumePlay != null) {
            z = needResumePlay.booleanValue();
        } else {
            z = false;
        }
        BusProvider.post(new rs4.a(planId, materialId, i, type, z));
        a.c createXModel = XBridgeKTXKt.createXModel(a.c.class);
        a.c cVar = createXModel;
        cVar.setCode(0);
        cVar.setMsg("success");
        CompletionBlock.DefaultImpls.onSuccess$default(callback, createXModel, (String) null, 2, (Object) null);
    }
}
