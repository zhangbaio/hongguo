package kr4;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.LogHelper;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    private static final LogHelper a;

    class a extends TypeToken<HashMap<String, String>> {
        a() {
        }
    }

    static {
        Covode.recordClassIndex(611543);
        a = new LogHelper("JSONObjectConverter");
    }

    public static String b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return JSONUtils.toJson(map);
    }

    public static Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (Map) JSONUtils.fromJson(str, new a().getType());
        } catch (Exception e) {
            a.e("fail to convertToObject, value=%s, error=%s", new Object[]{str, Log.getStackTraceString(e)});
            return null;
        }
    }
}
