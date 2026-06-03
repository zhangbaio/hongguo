package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.bv;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bs extends bv.e {
    private String a;

    static {
        Covode.recordClassIndex(655388);
    }

    public bs(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = str2;
    }

    public static bs a(Context context, String str, gi giVar) {
        byte[] a = ho.a(giVar);
        if (a != null && a.length > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 0);
            contentValues.put("messageId", "");
            contentValues.put("messageItemId", giVar.d());
            contentValues.put("messageItem", a);
            contentValues.put("appId", bm.a(context).b());
            contentValues.put("packageName", bm.a(context).m195a());
            contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("uploadTimestamp", (Integer) 0);
            return new bs(str, contentValues, "a job build to insert message to db");
        }
        return null;
    }
}
