package ss4;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.util.kotlin.ConvertKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ss4.b;

@XBridgeMethod(name = "readingNonStandardAdTrack", owner = "chenhaobin")
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends b {
    public static final int f;

    static {
        Covode.recordClassIndex(612478);
        f = 8;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void handle(IBDXBridgeContext bridgeContext, b.InterfaceC0270b params, CompletionBlock<b.c> callback) {
        Object m773constructorimpl;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Result.Companion companion = Result.Companion;
            long longSafely = ConvertKt.toLongSafely(params.getNonStandardAdId());
            if (Intrinsics.areEqual(params.getAction(), "show")) {
                NsAdApi.IMPL.onNonStanderAdShowTrackEvent(longSafely, params.getUrlList());
                callback.onSuccess(XBridgeKTXKt.createXModel(b.c.class), "success");
            } else if (Intrinsics.areEqual(params.getAction(), "click")) {
                NsAdApi.IMPL.onNonStanderAdClickTrackEvent(longSafely, params.getUrlList());
                callback.onSuccess(XBridgeKTXKt.createXModel(b.c.class), "success");
            } else {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -1, "illegal action", (XBaseResultModel) null, 4, (Object) null);
            }
            m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
        if (m776exceptionOrNullimpl != null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -2, "exception=" + m776exceptionOrNullimpl.getMessage(), (XBaseResultModel) null, 4, (Object) null);
        }
    }
}
