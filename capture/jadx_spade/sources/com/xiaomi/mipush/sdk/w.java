package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.ad;
import com.xiaomi.push.am;
import com.xiaomi.push.ba;
import com.xiaomi.push.ge;
import com.xiaomi.push.gj;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.hd;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.y;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class w {
    static {
        Covode.recordClassIndex(655324);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(List<String> list) {
        String a = ba.a(d(list));
        if (!TextUtils.isEmpty(a) && a.length() > 4) {
            return a.substring(0, 4).toLowerCase();
        }
        return "";
    }

    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a = ah.a(context).a(gj.SyncInfoFrequency.a(), 1209600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) > a) {
            a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(List<String> list) {
        String str = "";
        if (y.a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }

    public static void a(final Context context, final boolean z) {
        ad.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.w.1
            @Override // java.lang.Runnable
            public void run() {
                com.xiaomi.channel.commonutils.logger.b.m54a("do sync info");
                hd hdVar = new hd(aj.a(), false);
                b m79a = b.m79a(context);
                hdVar.c(go.SyncInfo.f529a);
                hdVar.b(m79a.m80a());
                hdVar.d(context.getPackageName());
                HashMap hashMap = new HashMap();
                hdVar.f668a = hashMap;
                Context context2 = context;
                com.xiaomi.push.k.a(hashMap, "app_version", com.xiaomi.push.g.m456a(context2, context2.getPackageName()));
                Map<String, String> map = hdVar.f668a;
                Context context3 = context;
                com.xiaomi.push.k.a(map, "app_version_code", Integer.toString(com.xiaomi.push.g.a(context3, context3.getPackageName())));
                com.xiaomi.push.k.a(hdVar.f668a, "push_sdk_vn", BuildConfig.VERSION_NAME);
                com.xiaomi.push.k.a(hdVar.f668a, "push_sdk_vc", Integer.toString(50906));
                com.xiaomi.push.k.a(hdVar.f668a, "token", m79a.b());
                if (!com.xiaomi.push.j.m636d()) {
                    String a = ba.a(com.xiaomi.push.i.c(context));
                    String e = com.xiaomi.push.i.e(context);
                    if (!TextUtils.isEmpty(e)) {
                        a = a + "," + e;
                    }
                    if (!TextUtils.isEmpty(a)) {
                        com.xiaomi.push.k.a(hdVar.f668a, "imei_md5", a);
                    }
                }
                am.a(context).a(hdVar.f668a);
                com.xiaomi.push.k.a(hdVar.f668a, "reg_id", m79a.m87c());
                com.xiaomi.push.k.a(hdVar.f668a, "reg_secret", m79a.d());
                com.xiaomi.push.k.a(hdVar.f668a, "accept_time", MiPushClient.getAcceptTime(context).replace(",", "-"));
                if (z) {
                    com.xiaomi.push.k.a(hdVar.f668a, "aliases_md5", w.c(MiPushClient.getAllAlias(context)));
                    com.xiaomi.push.k.a(hdVar.f668a, "topics_md5", w.c(MiPushClient.getAllTopic(context)));
                    com.xiaomi.push.k.a(hdVar.f668a, "accounts_md5", w.c(MiPushClient.getAllUserAccount(context)));
                } else {
                    com.xiaomi.push.k.a(hdVar.f668a, "aliases", w.d(MiPushClient.getAllAlias(context)));
                    com.xiaomi.push.k.a(hdVar.f668a, "topics", w.d(MiPushClient.getAllTopic(context)));
                    com.xiaomi.push.k.a(hdVar.f668a, "user_accounts", w.d(MiPushClient.getAllUserAccount(context)));
                }
                u.a(context).a((u) hdVar, ge.Notification, false, (gr) null);
            }
        });
    }

    public static void a(Context context, hd hdVar) {
        com.xiaomi.channel.commonutils.logger.b.m54a("need to update local info with: " + hdVar.m549a());
        String str = hdVar.m549a().get("accept_time");
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split("-");
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    b.m79a(context).a(true);
                } else {
                    b.m79a(context).a(false);
                }
            }
        }
        String str2 = hdVar.m549a().get("aliases");
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(",")) {
                    MiPushClient.addAlias(context, str3);
                }
            }
        }
        String str4 = hdVar.m549a().get("topics");
        if (str4 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(",")) {
                    MiPushClient.addTopic(context, str5);
                }
            }
        }
        String str6 = hdVar.m549a().get("user_accounts");
        if (str6 != null) {
            MiPushClient.removeAllAccounts(context);
            if (!"".equals(str6)) {
                for (String str7 : str6.split(",")) {
                    MiPushClient.addAccount(context, str7);
                }
            }
        }
    }
}
