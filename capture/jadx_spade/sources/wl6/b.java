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
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC0285b, c> {
    public static final a c;

    @XBridgeModelExtension
    private static final Map<String, Object> d;

    @XBridgeMethodName(name = "original.openVideoPlayer", params = {"videoList", "hasMore", "itemId", "cursor", "showDelete", "showEdit"})
    private final String a = "original.openVideoPlayer";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access b = IDLXBridgeMethod.Access.PRIVATE;

    public static final class a {
        static {
            Covode.recordClassIndex(656055);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @XBridgeParamModel
    /* renamed from: wl6.b$b, reason: collision with other inner class name */
    public interface InterfaceC0285b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "cursor", required = true)
        String getCursor();

        @XBridgeParamField(isGetter = true, keyPath = "hasMore", required = true)
        boolean getHasMore();

        @XBridgeParamField(isGetter = true, keyPath = "itemId", required = true)
        String getItemId();

        @XBridgeParamField(isGetter = true, keyPath = "showDelete", required = false)
        Boolean getShowDelete();

        @XBridgeParamField(isGetter = true, keyPath = "showEdit", required = false)
        Boolean getShowEdit();

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
        Covode.recordClassIndex(656054);
        c = new a(null);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("TicketID", "37942"));
        d = mapOf;
    }
}
