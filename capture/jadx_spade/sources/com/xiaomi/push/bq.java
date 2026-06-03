package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.bv;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bq extends bv.b<Long> {
    private long a;

    /* renamed from: a, reason: collision with other field name */
    private String f159a;

    static {
        Covode.recordClassIndex(655386);
    }

    @Override // com.xiaomi.push.bv.a
    /* renamed from: a */
    public Object mo197a() {
        return Long.valueOf(this.a);
    }

    public static bq a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new bq(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.bv.b
    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.bv.b
    public void a(Context context, List<Long> list) {
        if (context != null && list != null && list.size() > 0) {
            this.a = list.get(0).longValue();
        }
    }

    public bq(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.a = 0L;
        this.f159a = str6;
    }
}
