package wl6;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class d extends XCoreIDLBridgeMethod<b, Object> {
    public static final a c;

    @XBridgeModelExtension
    private static final Map<String, Object> d;

    @XBridgeMethodName(name = "original.originUpdateSeries", params = {"type", "albumId", "albumName"})
    private final String a = "original.originUpdateSeries";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access b = IDLXBridgeMethod.Access.PRIVATE;

    public static final class a {
        static {
            Covode.recordClassIndex(656064);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "albumId", required = false)
        String getAlbumId();

        @XBridgeParamField(isGetter = true, keyPath = "albumName", required = false)
        String getAlbumName();

        @XBridgeParamField(isGetter = true, keyPath = "thumbUrl", required = false)
        String getThumbUrl();

        @XBridgeParamField(isGetter = true, keyPath = "type", required = true)
        Number getType();

        @XBridgeParamField(isGetter = true, keyPath = "videoCount", required = false)
        Number getVideoCount();
    }

    public IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    static {
        Map<String, Object> mapOf;
        Covode.recordClassIndex(656063);
        c = new a(null);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("TicketID", "37980"));
        d = mapOf;
    }
}
