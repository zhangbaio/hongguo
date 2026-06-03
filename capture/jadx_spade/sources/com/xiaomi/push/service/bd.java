package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ge;
import com.xiaomi.push.go;
import com.xiaomi.push.hd;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bd implements XMPushService.n {
    private static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static final Map<Integer, Map<String, List<String>>> f971a;

    /* renamed from: a, reason: collision with other field name */
    private static final boolean f972a;

    static {
        Covode.recordClassIndex(655707);
        f972a = Log.isLoggable("UNDatas", 3);
        f971a = new HashMap();
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a */
    public void mo453a() {
        Map<Integer, Map<String, List<String>>> map = f971a;
        if (map.size() > 0) {
            synchronized (map) {
                b();
            }
        }
    }

    private static void b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f971a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(":");
                        List list = (List) map.get(str);
                        if (!com.xiaomi.push.r.a(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(",");
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(";");
                    }
                    hd a2 = a(null, aj.a(), go.NotificationRemoved.f529a, null);
                    a2.a("removed_reason", String.valueOf(num));
                    a2.a("all_delete_msgId_appId", sb.toString());
                    com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(a, a2);
                }
                f971a.remove(num);
            }
        }
    }

    public bd(Context context) {
        a = context;
    }

    private static void a(Context context, final hd hdVar) {
        if (f972a) {
            com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload message notification:" + hdVar);
        }
        com.xiaomi.push.ad.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.bd.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] a2 = ho.a(w.a(hd.this.d(), hd.this.b(), hd.this, ge.Notification));
                if (bd.a instanceof XMPushService) {
                    ((XMPushService) bd.a).a(hd.this.d(), a2, true);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m54a("UNDatas UploadNotificationDatas failed because not xmsf");
                }
            }
        });
    }

    private static hd a(String str, String str2, String str3, String str4) {
        hd hdVar = new hd();
        if (str3 != null) {
            hdVar.c(str3);
        }
        if (str != null) {
            hdVar.b(str);
        }
        if (str2 != null) {
            hdVar.a(str2);
        }
        if (str4 != null) {
            hdVar.d(str4);
        }
        hdVar.a(false);
        return hdVar;
    }
}
