package fr4;

import android.text.TextUtils;
import com.bytedance.admetaversesdk.adbase.entity.banner.AdModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.reader.util.JSONUtils;
import com.google.gson.reflect.TypeToken;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    private static final LogHelper a;

    /* renamed from: fr4.a$a, reason: collision with other inner class name */
    class C0158a extends TypeToken<AdModel> {
        C0158a() {
        }
    }

    static {
        Covode.recordClassIndex(611489);
        a = new LogHelper("ChapterStringConverter", 4);
    }

    public static String b(AdModel adModel) {
        if (adModel == null) {
            return null;
        }
        return JSONUtils.toJson(adModel);
    }

    public static AdModel a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (AdModel) JSONUtils.fromJson(str, new C0158a().getType());
        } catch (Exception e) {
            a.e("fail to convertToObject," + e.getMessage(), new Object[0]);
            return null;
        }
    }
}
