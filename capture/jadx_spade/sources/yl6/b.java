package yl6;

import com.bytedance.covode.number.Covode;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    public static final b a;

    static {
        Covode.recordClassIndex(656106);
        a = new b();
    }

    private b() {
    }

    private final Map<String, Object> f(Map<String, ? extends Object> map) {
        Map<String, Object> mapOf;
        if (map != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("data", map));
            return mapOf;
        }
        return null;
    }

    public final void b(Map<String, ? extends Object> map) {
        Event event = new Event("original.onVideoWorkCoverEditSuccess", System.currentTimeMillis(), (XReadableMap) null, 4, (DefaultConstructorMarker) null);
        event.setMapParams(a.f(map));
        EventCenter.enqueueEvent(event);
    }

    public final void c(Map<String, ? extends Object> map) {
        Event event = new Event("original.triggerPublishButtonClick", System.currentTimeMillis(), (XReadableMap) null, 4, (DefaultConstructorMarker) null);
        event.setMapParams(a.f(map));
        EventCenter.enqueueEvent(event);
    }

    public final void a(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        bridgeContext.sendEvent("original.deleteVideoWork", map);
    }

    public final void d(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        bridgeContext.sendEvent("original.updateVideoWorkList", map);
    }

    public final void e(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        bridgeContext.sendEvent("original.updateVideoUploadStatus", map);
    }
}
