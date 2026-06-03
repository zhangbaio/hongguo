package com.xiaomi.push.service;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.gd;
import com.xiaomi.push.ge;
import com.xiaomi.push.gi;
import com.xiaomi.push.gr;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class o implements gd {
    private final XMPushService a;

    static {
        Covode.recordClassIndex(655730);
    }

    public o(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if ("com.xiaomi.xmsf".equals(str)) {
            return "1000271";
        }
        return this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.gd
    public void a(final List<gi> list, final String str, final String str2) {
        this.a.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.o.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "Send tiny data.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo383a() {
                String a = o.this.a(str);
                ArrayList<hd> a2 = az.a(list, str, a, 32768);
                if (a2 != null) {
                    Iterator<hd> it2 = a2.iterator();
                    while (it2.hasNext()) {
                        hd next = it2.next();
                        next.a("uploadWay", "longXMPushService");
                        ha a3 = w.a(str, a, next, ge.Notification);
                        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
                            if (a3.m533a() == null) {
                                gr grVar = new gr();
                                grVar.a("-1");
                                a3.a(grVar);
                            }
                            a3.m533a().b("ext_traffic_source_pkg", str2);
                        }
                        o.this.a.a(str, ho.a(a3), true);
                    }
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            }
        });
    }
}
