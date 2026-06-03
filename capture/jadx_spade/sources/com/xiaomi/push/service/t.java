package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.fh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class t {
    private static ArrayList<Pair<String, byte[]>> a;

    /* renamed from: a, reason: collision with other field name */
    private static final Map<String, byte[]> f1009a;

    static {
        Covode.recordClassIndex(655741);
        f1009a = new HashMap();
        a = new ArrayList<>();
    }

    public static void a(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (a) {
                arrayList = a;
                a = new ArrayList<>();
            }
            boolean a2 = com.xiaomi.push.r.a();
            Iterator<Pair<String, byte[]>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Pair<String, byte[]> next = it2.next();
                w.a(xMPushService, (String) next.first, (byte[]) next.second);
                if (!a2) {
                    try {
                        ThreadMonitor.sleepMonitor(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        } catch (fh e) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        Map<String, byte[]> map = f1009a;
        synchronized (map) {
            com.xiaomi.channel.commonutils.logger.b.m54a("pending registration request. " + str);
            map.put(str, bArr);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (a) {
            a.add(new Pair<>(str, bArr));
            if (a.size() > 50) {
                a.remove(0);
            }
        }
    }

    public static void a(XMPushService xMPushService, boolean z) {
        try {
            Map<String, byte[]> map = f1009a;
            synchronized (map) {
                for (String str : map.keySet()) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("processing pending registration request. " + str);
                    w.a(xMPushService, str, f1009a.get(str));
                    if (z && !com.xiaomi.push.r.a()) {
                        try {
                            ThreadMonitor.sleepMonitor(200L);
                        } catch (Exception unused) {
                        }
                    }
                }
                f1009a.clear();
            }
        } catch (fh e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. " + e);
            xMPushService.a(10, e);
        }
    }

    public static void a(Context context, int i, String str) {
        Map<String, byte[]> map = f1009a;
        synchronized (map) {
            for (String str2 : map.keySet()) {
                com.xiaomi.channel.commonutils.logger.b.m54a("notify registration error. " + str2);
                a(context, str2, f1009a.get(str2), i, str);
            }
            f1009a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, w.a(str));
    }
}
