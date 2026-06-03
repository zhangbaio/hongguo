package xl6;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.ss.android.messagebus.BusProvider;
import kotlin.jvm.internal.Intrinsics;
import wl6.d;

@XBridgeMethod(name = "original.originUpdateSeries", owner = "")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d extends wl6.d {
    static {
        Covode.recordClassIndex(656095);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void handle(IBDXBridgeContext bridgeContext, d.b params, CompletionBlock<Object> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BusProvider.post(new yl6.a(params.getType(), params.getAlbumId(), params.getAlbumName(), params.getThumbUrl(), params.getVideoCount()));
    }
}
