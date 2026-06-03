package com.vivo.push.util;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(655191);
    }

    public static boolean a(long j, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            t.a("ClientReportUtil", "reportParams is null");
            return false;
        }
        com.vivo.push.b.y yVar = new com.vivo.push.b.y(j);
        yVar.a(hashMap);
        yVar.e();
        com.vivo.push.m.a().a(yVar);
        return true;
    }

    public static boolean a(long j, long j2) {
        t.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        com.vivo.push.b.y yVar = new com.vivo.push.b.y(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j));
        String a = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put("remoteAppId", a);
        }
        yVar.a(hashMap);
        com.vivo.push.m.a().a(yVar);
        return true;
    }
}
