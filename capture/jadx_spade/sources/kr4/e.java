package kr4;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.LogHelper;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    private static final LogHelper a;

    class a extends TypeToken<List<String>> {
        a() {
        }
    }

    static {
        Covode.recordClassIndex(611542);
        a = new LogHelper("JSONObjectConverter");
    }

    public static String b(List<String> list) {
        if (list == null) {
            return null;
        }
        return JSONUtils.toJson(list);
    }

    public static List<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (List) JSONUtils.fromJson(str, new a().getType());
        } catch (Exception e) {
            a.e("fail to convertToObject, value=%s, error=%s", new Object[]{str, Log.getStackTraceString(e)});
            return null;
        }
    }
}
