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
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class g extends XCoreIDLBridgeMethod<b, c> {
    public static final a c;

    @XBridgeModelExtension
    private static final Map<String, Object> d;

    @XBridgeMethodName(name = "original.publishVideoWork", params = {"text", "path", "scene", "publishApps", "cover", "duration", "localCover", "isAiGenerated"})
    private final String a = "original.publishVideoWork";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access b = IDLXBridgeMethod.Access.PRIVATE;

    public static final class a {
        static {
            Covode.recordClassIndex(656076);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "cover", required = false)
        String getCover();

        @XBridgeParamField(isGetter = true, keyPath = "duration", required = true)
        Number getDuration();

        @XBridgeParamField(isGetter = true, keyPath = "localCover", required = false)
        String getLocalCover();

        @XBridgeParamField(isGetter = true, keyPath = "path", required = true)
        String getPath();

        @XBridgeParamField(isGetter = true, keyPath = "publishApps", primitiveClassType = String.class, required = false)
        List<String> getPublishApps();

        @XBridgeParamField(isGetter = true, keyPath = "scene", required = true)
        String getScene();

        @XBridgeParamField(isGetter = true, keyPath = "text", required = true)
        String getText();

        @XBridgeParamField(isGetter = true, keyPath = "isAiGenerated", required = false)
        Boolean isAiGenerated();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    public IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    static {
        Map<String, Object> mapOf;
        Covode.recordClassIndex(656075);
        c = new a(null);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("TicketID", "38854"));
        d = mapOf;
    }
}
