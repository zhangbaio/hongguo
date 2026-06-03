package fr4;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.reader.util.JSONUtils;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    private static final LogHelper a;

    class a extends TypeToken<List<Object>> {
        a() {
        }
    }

    static {
        Covode.recordClassIndex(611490);
        a = new LogHelper("RangeInfoStringConverter");
    }

    public static String b(List<Object> list) {
        if (list == null) {
            return null;
        }
        return JSONUtils.toJson(list);
    }

    public static List<Object> a(String str) {
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
