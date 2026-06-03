package xn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.share2.absettings.UgShareConfig;
import com.dragon.read.base.share2.absettings.WeiboShareChannelConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w implements zn4.e {
    public static final w a;

    static {
        Covode.recordClassIndex(608958);
        a = new w();
    }

    private w() {
    }

    @Override // zn4.e
    public boolean ba() {
        return UgShareConfig.a.a().isRequestShareEntrance;
    }

    @Override // zn4.e
    public boolean g8() {
        return WeiboShareChannelConfig.a.a().isEnable;
    }

    @Override // zn4.e
    public Map<String, String> getRequestSharkParam() {
        Map<String, String> requestSharkParam = NsCommonDepend.IMPL.getRequestSharkParam();
        Intrinsics.checkNotNullExpressionValue(requestSharkParam, "getRequestSharkParam(...)");
        return requestSharkParam;
    }

    @Override // zn4.e
    public String ea(String originUrl) {
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        String str = (String) hp2.h.a.B(originUrl).getSecond();
        if (str != null) {
            return str;
        }
        return originUrl;
    }
}
