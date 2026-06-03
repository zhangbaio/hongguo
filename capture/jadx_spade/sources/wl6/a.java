package wl6;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a extends XCoreIDLBridgeMethod<b, c> {
    public static final C0284a c;

    @XBridgeModelExtension
    private static final Map<String, Object> d;

    @XBridgeMethodName(name = "original.appendVideoWorkList", params = {"videoList", "hasMore", "status", "cursor"})
    private final String a = "original.appendVideoWorkList";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access b = IDLXBridgeMethod.Access.PRIVATE;

    /* renamed from: wl6.a$a, reason: collision with other inner class name */
    public static final class C0284a {
        static {
            Covode.recordClassIndex(656050);
        }

        private C0284a() {
        }

        public /* synthetic */ C0284a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "cursor", required = true)
        String getCursor();

        @XBridgeParamField(isGetter = true, keyPath = "hasMore", required = true)
        boolean getHasMore();

        @XBridgeParamField(isGetter = true, keyPath = "status", required = true)
        Number getStatus();

        @XBridgeParamField(isGetter = true, keyPath = "videoList", nestedClassType = d.class, required = true)
        List<d> getVideoList();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    public interface d extends XBaseModel {
        @XBridgeParamField(isGetter = true, keyPath = "avatar", required = true)
        String getAvatar();

        @XBridgeParamField(isGetter = true, keyPath = "cover", required = false)
        String getCover();

        @XBridgeParamField(isGetter = true, keyPath = "desc", required = true)
        String getDesc();

        @XBridgeParamField(isGetter = true, keyPath = "extra", required = false)
        Object getExtra();

        @XBridgeParamField(isGetter = true, keyPath = "itemId", required = true)
        String getItemId();

        @XBridgeParamField(isGetter = true, keyPath = "userName", required = true)
        String getUserName();

        @XBridgeParamField(isGetter = true, keyPath = "videoVertical", required = false)
        Number getVideoVertical();
    }

    public IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    static {
        Map<String, Object> mapOf;
        Covode.recordClassIndex(656049);
        c = new C0284a(null);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("TicketID", "37946"));
        d = mapOf;
    }
}
