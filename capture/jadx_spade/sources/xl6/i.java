package xl6;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.xs.originalsass.hybird.service.IOriginalService;
import kotlin.jvm.internal.Intrinsics;
import wl6.i;

@XBridgeMethod(name = "original.stopUploadVideo", owner = "")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class i extends wl6.i {
    static {
        Covode.recordClassIndex(656101);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void handle(IBDXBridgeContext bridgeContext, i.b params, CompletionBlock<i.c> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IOriginalService a = IOriginalService.Companion.a();
        if (a != null) {
            a.handleStopUploadVideo(bridgeContext, params, callback);
        }
    }
}
