package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class cu {
    private final String a = "power_consumption_stats";
    private final String b = "off_up_ct";
    private final String c = "off_dn_ct";
    private final String d = "off_ping_ct";
    private final String e = "off_pong_ct";
    private final String f = "off_dur";
    private final String g = "on_up_ct";
    private final String h = "on_dn_ct";
    private final String i = "on_ping_ct";
    private final String j = "on_pong_ct";
    private final String k = "on_dur";
    private final String l = "start_time";
    private final String m = "end_time";
    private final String n = "xmsf_vc";
    private final String o = "android_vc";
    private final String p = "uuid";

    static {
        Covode.recordClassIndex(655426);
    }

    public void a(Context context, ct ctVar) {
        if (ctVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("off_up_ct", Integer.valueOf(ctVar.a()));
        hashMap.put("off_dn_ct", Integer.valueOf(ctVar.b()));
        hashMap.put("off_ping_ct", Integer.valueOf(ctVar.c()));
        hashMap.put("off_pong_ct", Integer.valueOf(ctVar.d()));
        hashMap.put("off_dur", Long.valueOf(ctVar.m258a()));
        hashMap.put("on_up_ct", Integer.valueOf(ctVar.e()));
        hashMap.put("on_dn_ct", Integer.valueOf(ctVar.f()));
        hashMap.put("on_ping_ct", Integer.valueOf(ctVar.g()));
        hashMap.put("on_pong_ct", Integer.valueOf(ctVar.h()));
        hashMap.put("on_dur", Long.valueOf(ctVar.m259b()));
        hashMap.put("start_time", Long.valueOf(ctVar.m260c()));
        hashMap.put("end_time", Long.valueOf(ctVar.m261d()));
        hashMap.put("xmsf_vc", Integer.valueOf(ctVar.i()));
        hashMap.put("android_vc", Integer.valueOf(ctVar.j()));
        hashMap.put("uuid", com.xiaomi.push.service.q.m746a(context));
        eg.a().a("power_consumption_stats", hashMap);
    }
}
