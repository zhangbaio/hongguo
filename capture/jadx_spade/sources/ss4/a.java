package ss4;

import com.bytedance.covode.number.Covode;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
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
public abstract class a extends XCoreIDLBridgeMethod<b, c> {
    public static final C0269a c;
    public static final int d;

    @XBridgeModelExtension
    private static final Map<String, Object> e;

    @XBridgeMethodName(name = "readingHideSeriesNonStandardAd", params = {"planId", "materialId", "type", "need_resume_play"}, results = {"code", "msg"})
    private final String a = "readingHideSeriesNonStandardAd";

    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    private final IDLXBridgeMethod.Access b = IDLXBridgeMethod.Access.PRIVATE;

    /* renamed from: ss4.a$a, reason: collision with other inner class name */
    public static final class C0269a {
        static {
            Covode.recordClassIndex(612462);
        }

        private C0269a() {
        }

        public /* synthetic */ C0269a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "materialId", required = true)
        String getMaterialId();

        @XBridgeParamField(isGetter = true, keyPath = "need_resume_play", required = false)
        Boolean getNeedResumePlay();

        @XBridgeParamField(isGetter = true, keyPath = "planId", required = true)
        String getPlanId();

        @XBridgeStringEnum(option = {"pause", "series"})
        @XBridgeParamField(defaultValue = @XBridgeDefaultValue(stringValue = "series", type = DefaultType.STRING), isEnum = true, isGetter = true, keyPath = "type", required = false)
        String getType();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isEnum = true, isGetter = true, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        Number getCode();

        @XBridgeParamField(isGetter = true, keyPath = "msg", required = false)
        String getMsg();

        @XBridgeParamField(isEnum = true, isGetter = false, keyPath = "code", required = true)
        @XBridgeIntEnum(option = {1, 0, -1, -2})
        void setCode(Number number);

        @XBridgeParamField(isGetter = false, keyPath = "msg", required = false)
        void setMsg(String str);
    }

    public IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    static {
        Map<String, Object> mapOf;
        Covode.recordClassIndex(612461);
        c = new C0269a(null);
        d = 8;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("TicketID", "38859"));
        e = mapOf;
    }
}
