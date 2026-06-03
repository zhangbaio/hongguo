package ss4;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.nonstandard.ad.api.NonStandardAdApi;
import com.dragon.read.report.ReportManager;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ss4.c;

@XBridgeMethod(name = "readingOpenAdPage", owner = "chenhaobin")
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends c {
    public static final int g;
    private final LogHelper f = new LogHelper("NonStandardAd#ReadingOpenAdPage");

    static {
        Covode.recordClassIndex(612479);
        g = 8;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void handle(IBDXBridgeContext bridgeContext, c.b params, CompletionBlock<c.InterfaceC0271c> callback) {
        Object obj;
        String str;
        long j;
        Object obj2;
        List<String> list;
        String str2;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map<String, Object> extra = params.getExtra();
        if (extra != null) {
            obj = extra.get("plan_id");
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null) {
            j = Long.parseLong(str);
        } else {
            j = 0;
        }
        Map<String, Object> extra2 = params.getExtra();
        if (extra2 != null) {
            obj2 = extra2.get("click_monitor_links");
        } else {
            obj2 = null;
        }
        if (obj2 instanceof List) {
            list = (List) obj2;
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        String type = params.getType();
        if (type == null) {
            str2 = "";
        } else {
            str2 = type;
        }
        this.f.i("[readingOpenAdPage] planId=" + j + ", extra=" + params.getExtra() + ", type=" + str2, new Object[0]);
        NonStandardAdApi nonStandardAdApi = NonStandardAdApi.IMPL;
        String schema = params.getSchema();
        String fallback = params.getFallback();
        if (fallback == null) {
            fallback = "";
        }
        nonStandardAdApi.handleJumpSchema(schema, fallback, list, j);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, XBridgeKTXKt.createXModel(c.InterfaceC0271c.class), (String) null, 2, (Object) null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("plan_id", j);
        jSONObject.put("clickLinks", list.toString());
        jSONObject.put("schema", params.getSchema());
        jSONObject.put("fallback", params.getFallback());
        jSONObject.put("type", str2);
        ReportManager.onReport("key_nonstandard_patch_ad_click", jSONObject);
    }
}
