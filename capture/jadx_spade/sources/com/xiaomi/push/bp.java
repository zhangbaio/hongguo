package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.bv;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bp extends br {
    static {
        Covode.recordClassIndex(655385);
    }

    private void a(long j) {
        String[] strArr = ((bv.d) this).f174a;
        if (strArr != null && strArr.length > 0) {
            strArr[0] = String.valueOf(j);
        }
    }

    @Override // com.xiaomi.push.bv.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = bz.a(m198a());
            long j = bn.f156a;
            if (a > j) {
                long j2 = (long) ((((a - j) * 1.2d) / j) * longValue);
                a(j2);
                bm.a(context).a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
                super.a(context, obj);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
        }
    }

    public static bp a(Context context, String str, int i) {
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        String m196a = bv.a(context).m196a(str);
        if (TextUtils.isEmpty(m196a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m196a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new bp(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    public bp(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }
}
