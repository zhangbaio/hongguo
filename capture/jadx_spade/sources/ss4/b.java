package ss4;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class b extends XCoreIDLBridgeMethod<InterfaceC0270b, c> {
    public static final a c;
    public static final int d;

    @XBridgeModelExtension
    private static final Map<String, Object> e;

    @XBridgeMethodName(name = "readingNonStandardAdTrack", params = {"nonStandardAdId", "action", "urlList"})
    private final String a = "readingNonStandardAdTrack";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access b = IDLXBridgeMethod.Access.PRIVATE;

    public static final class a {
        static {
            Covode.recordClassIndex(612468);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @XBridgeParamModel
    /* renamed from: ss4.b$b, reason: collision with other inner class name */
    public interface InterfaceC0270b extends XBaseParamModel {
        @XBridgeStringEnum(option = {"show", "click"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "action", required = true)
        String getAction();

        @XBridgeParamField(isGetter = true, keyPath = "nonStandardAdId", required = true)
        String getNonStandardAdId();

        @XBridgeParamField(isGetter = true, keyPath = "urlList", primitiveClassType = String.class, required = true)
        List<String> getUrlList();
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
        Covode.recordClassIndex(612467);
        c = new a(null);
        d = 8;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("TicketID", "36700"));
        e = mapOf;
    }
}
