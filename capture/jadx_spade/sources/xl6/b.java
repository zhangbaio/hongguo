package xl6;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.xs.originalsass.hybird.service.IOriginalService;
import kotlin.jvm.internal.Intrinsics;
import wl6.b;

@XBridgeMethod(name = "original.openVideoPlayer", owner = "wangsheng.5")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends wl6.b {
    static {
        Covode.recordClassIndex(656092);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void handle(IBDXBridgeContext bridgeContext, b.InterfaceC0285b params, CompletionBlock<b.c> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IOriginalService a = IOriginalService.Companion.a();
        if (a != null) {
            a.handleOpenVideoPlayer(bridgeContext, params, callback);
        }
    }
}
