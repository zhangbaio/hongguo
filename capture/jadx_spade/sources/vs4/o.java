package vs4;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final o a;
    private static final String[] b;
    public static final int c;

    private o() {
    }

    static {
        Covode.recordClassIndex(612549);
        a = new o();
        b = new String[]{"tab_name", "category_name", "module_name", "unlimited_position"};
        c = 8;
    }

    public final String a(Map<String, ?> map) {
        String str;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        for (String str2 : b) {
            if (map != null && (obj = map.get(str2)) != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            jSONObject.put(str2, str);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }
}
