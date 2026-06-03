package kr4;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    private static final LogHelper a;

    static {
        Covode.recordClassIndex(611541);
        a = new LogHelper("JSONObjectConverter");
    }

    public static String b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.toString();
        } catch (Exception e) {
            a.e("fail to convertToString, obj=%s, error=%s", new Object[]{jSONObject, Log.getStackTraceString(e)});
            return null;
        }
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            a.e("fail to convertToObject, value=%s, error=%s", new Object[]{str, Log.getStackTraceString(e)});
            return null;
        }
    }
}
