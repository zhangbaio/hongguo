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
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class c extends XCoreIDLBridgeMethod<b, InterfaceC0271c> {
    public static final a c;
    public static final int d;

    @XBridgeModelExtension
    private static final Map<String, Object> e;

    @XBridgeMethodName(name = "readingOpenAdPage", params = {"schema", "fallback", "extra", "type"})
    private final String a = "readingOpenAdPage";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access b = IDLXBridgeMethod.Access.PRIVATE;

    public static final class a {
        static {
            Covode.recordClassIndex(612473);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "extra", required = false)
        Map<String, Object> getExtra();

        @XBridgeParamField(isGetter = true, keyPath = "fallback", required = false)
        String getFallback();

        @XBridgeParamField(isGetter = true, keyPath = "schema", required = true)
        String getSchema();

        @XBridgeStringEnum(option = {"series", "pause"})
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "type", required = false)
        String getType();
    }

    @XBridgeResultModel
    /* renamed from: ss4.c$c, reason: collision with other inner class name */
    public interface InterfaceC0271c extends XBaseResultModel {
    }

    public IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    static {
        Map<String, Object> mapOf;
        Covode.recordClassIndex(612472);
        c = new a(null);
        d = 8;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("TicketID", "38899"));
        e = mapOf;
    }
}
