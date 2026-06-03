package xl6;

import com.bytedance.covode.number.Covode;
import com.bytedance.router.SmartRoute;
import com.bytedance.router.SmartRouter;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wl6.c;

@XBridgeMethod(name = "original.openVideoWorkCoverEditPage", owner = "wangsheng.5")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c extends wl6.c {
    public static final a e;

    public static final class a {
        static {
            Covode.recordClassIndex(656094);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(656093);
        e = new a(null);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void handle(IBDXBridgeContext bridgeContext, c.b params, CompletionBlock<Object> callback) {
        float f;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SmartRoute withParam = SmartRouter.buildRoute(bridgeContext.getOwnerActivity(), "//originEditVideoWorkCover").withParam("route_preview_video_cover_img_url", params.getThumbUrl());
        Number aspectRatio = params.getAspectRatio();
        if (aspectRatio != null) {
            f = aspectRatio.floatValue();
        } else {
            f = 0.7145709f;
        }
        withParam.withParam("route_edit_cover_w_h_ratio", f).open();
    }
}
