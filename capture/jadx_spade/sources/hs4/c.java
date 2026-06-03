package hs4;

import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.IMonitorHookV2;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c implements IMonitorHookV2 {
    public static final a b;
    public static final int c = 0;
    private final String a;

    public static final class a {
        static {
            Covode.recordClassIndex(612339);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612338);
        b = new a(null);
    }

    protected boolean a(hs4.a callerContext) {
        Intrinsics.checkNotNullParameter(callerContext, "callerContext");
        return true;
    }

    public c(String bizTag) {
        Intrinsics.checkNotNullParameter(bizTag, "bizTag");
        this.a = bizTag;
    }

    public final Pair<Boolean, Map<String, Object>> onMonitorCompleted(ImageRequest imageRequest, Object obj, String str, JSONObject jSONObject, boolean z, boolean z2) {
        if (obj instanceof hs4.a) {
            hs4.a aVar = (hs4.a) obj;
            if (Intrinsics.areEqual(this.a, aVar.a) && aVar.c == 1 && !aVar.j) {
                if (!a(aVar)) {
                    Pair<Boolean, Map<String, Object>> create = Pair.create(Boolean.FALSE, null);
                    Intrinsics.checkNotNullExpressionValue(create, "create(...)");
                    return create;
                }
                aVar.j = true;
                HashMap hashMap = new HashMap();
                hashMap.put("business_params", aVar.a());
                Pair<Boolean, Map<String, Object>> create2 = Pair.create(Boolean.TRUE, hashMap);
                Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
                return create2;
            }
        }
        Pair<Boolean, Map<String, Object>> create3 = Pair.create(Boolean.FALSE, null);
        Intrinsics.checkNotNullExpressionValue(create3, "create(...)");
        return create3;
    }
}
