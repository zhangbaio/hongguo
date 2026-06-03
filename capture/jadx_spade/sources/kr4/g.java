package kr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.local.db.entity.PageInfo;
import com.google.gson.reflect.TypeToken;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g {
    static {
        Covode.recordClassIndex(611544);
    }

    class a extends TypeToken<PageInfo> {
        a() {
        }
    }

    public static String a(PageInfo pageInfo) {
        if (pageInfo == null) {
            return "";
        }
        return JSONUtils.toJson(pageInfo);
    }

    public static PageInfo b(String str) {
        return (PageInfo) JSONUtils.fromJson(str, new a().getType());
    }
}
