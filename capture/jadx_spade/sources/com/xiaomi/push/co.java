package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class co {
    private final String a = "disconnection_event";
    private final String b = "count";
    private final String c = "host";
    private final String d = "network_state";
    private final String e = "reason";
    private final String f = "ping_interval";
    private final String g = "network_type";
    private final String h = "wifi_digest";
    private final String i = "duration";
    private final String j = "disconnect_time";
    private final String k = "connect_time";
    private final String l = "xmsf_vc";
    private final String m = "android_vc";
    private final String n = "uuid";

    static {
        Covode.recordClassIndex(655420);
    }

    public void a(Context context, List<cn> list) {
        if (list != null && list.size() != 0) {
            cm.a("upload size = " + list.size());
            String m746a = com.xiaomi.push.service.q.m746a(context);
            for (cn cnVar : list) {
                HashMap hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(cnVar.a()));
                hashMap.put("host", cnVar.m248a());
                hashMap.put("network_state", Integer.valueOf(cnVar.b()));
                hashMap.put("reason", Integer.valueOf(cnVar.c()));
                hashMap.put("ping_interval", Long.valueOf(cnVar.m247a()));
                hashMap.put("network_type", Integer.valueOf(cnVar.d()));
                hashMap.put("wifi_digest", cnVar.m250b());
                hashMap.put("connected_network_type", Integer.valueOf(cnVar.e()));
                hashMap.put("duration", Long.valueOf(cnVar.m249b()));
                hashMap.put("disconnect_time", Long.valueOf(cnVar.m251c()));
                hashMap.put("connect_time", Long.valueOf(cnVar.m252d()));
                hashMap.put("xmsf_vc", Integer.valueOf(cnVar.f()));
                hashMap.put("android_vc", Integer.valueOf(cnVar.g()));
                hashMap.put("uuid", m746a);
                eg.a().a("disconnection_event", hashMap);
            }
        }
    }
}
