package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.text.SimpleDateFormat;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class by {
    private static String a;

    /* renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f175a;

    static {
        Covode.recordClassIndex(655399);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f175a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static gi a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gi giVar = new gi();
        giVar.d("category_push_stat");
        giVar.a("push_sdk_stat_channel");
        giVar.a(1L);
        giVar.b(str);
        giVar.a(true);
        giVar.b(System.currentTimeMillis());
        giVar.g(bm.a(context).m195a());
        giVar.e("com.xiaomi.xmsf");
        giVar.f("");
        giVar.c("push_stat");
        return giVar;
    }
}
