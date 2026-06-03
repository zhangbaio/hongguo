package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.service.am;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ep {
    static {
        Covode.recordClassIndex(655497);
    }

    public static void a(String str, String str2, ez ezVar) {
        eq eqVar = new eq();
        eqVar.c(str2);
        eqVar.a(Integer.parseInt(str));
        eqVar.a("UBND", (String) null);
        ezVar.b(eqVar);
    }

    public static void a(am.b bVar, String str, ez ezVar) {
        String str2;
        String a;
        Cdo.c cVar = new Cdo.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            cVar.d(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        if (bVar.f935a) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        cVar.b(str2);
        if (!TextUtils.isEmpty(bVar.d)) {
            cVar.c(bVar.d);
        } else {
            cVar.c("XIAOMI-SASL");
        }
        eq eqVar = new eq();
        eqVar.c(bVar.f936b);
        eqVar.a(Integer.parseInt(bVar.g));
        eqVar.b(bVar.f933a);
        eqVar.a("BIND", (String) null);
        eqVar.a(eqVar.e());
        com.xiaomi.channel.commonutils.logger.b.m54a("[Slim]: bind id=" + eqVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f936b);
        hashMap.put("id", eqVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f935a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            hashMap.put("client_attrs", bVar.e);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            hashMap.put("cloud_attrs", bVar.f);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (!bVar.d.equals("XIAOMI-PASS") && !bVar.d.equals("XMPUSH-PASS")) {
            bVar.d.equals("XIAOMI-SASL");
            a = null;
        } else {
            a = ay.a(bVar.d, null, hashMap, bVar.h);
        }
        cVar.f(a);
        eqVar.a(cVar.m378a(), (String) null);
        ezVar.b(eqVar);
    }
}
