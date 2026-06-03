package kr4;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.google.gson.reflect.TypeToken;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class h {
    static {
        Covode.recordClassIndex(611545);
    }

    class a extends TypeToken<Set<String>> {
        a() {
        }
    }

    public static String a(Set<String> set) {
        return JSONUtils.toJson(set);
    }

    public static Set<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (Set) JSONUtils.fromJson(str, new a().getType());
    }
}
