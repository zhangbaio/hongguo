package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ef;
import com.xiaomi.push.eg;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class at {
    private final ConcurrentHashMap<String, c> a = new ConcurrentHashMap<>();

    static {
        Covode.recordClassIndex(655691);
    }

    private static class b {
        private static final at a;

        static {
            Covode.recordClassIndex(655693);
            a = new at();
        }
    }

    public static class a extends XMPushService.j {
        static {
            Covode.recordClassIndex(655692);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "RecordTimeManager clear";
        }

        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo383a() {
            at.a().m708a();
        }
    }

    public static at a() {
        return b.a;
    }

    private static class c {
        long a;
        long b;
        long c;
        long d;

        static {
            Covode.recordClassIndex(655694);
        }

        private c() {
        }

        public long a() {
            long j = this.c;
            long j2 = this.b;
            if (j > j2) {
                return j - j2;
            }
            return 0L;
        }

        public long b() {
            long j = this.d;
            long j2 = this.c;
            if (j > j2) {
                return j - j2;
            }
            return 0L;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m708a() {
        if (!this.a.isEmpty()) {
            Iterator<Map.Entry<String, c>> it2 = this.a.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, c> next = it2.next();
                if (next != null && next.getValue() != null) {
                    c value = next.getValue();
                    if (Math.abs(SystemClock.elapsedRealtime() - value.b) > 10000) {
                        a(next.getKey(), value);
                        it2.remove();
                    }
                } else {
                    it2.remove();
                }
            }
        }
    }

    public void a(String str, long j) {
        c cVar = this.a.get(str);
        if (cVar != null) {
            cVar.c = j;
        }
    }

    public void b(String str, long j) {
        c remove = this.a.remove(str);
        if (remove != null) {
            remove.d = j;
            a(str, remove);
        }
    }

    private void a(String str, c cVar) {
        if (!TextUtils.isEmpty(str) && cVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("xmsfVC", Long.valueOf(cVar.a));
            hashMap.put("packetId", str);
            hashMap.put("pTime", Long.valueOf(cVar.a()));
            hashMap.put("bTime", Long.valueOf(cVar.b()));
            eg.a().a(new ef("msg_process_time", hashMap));
        }
    }

    public void a(String str, long j, long j2) {
        c cVar = new c();
        cVar.a = j2;
        cVar.b = j;
        this.a.put(str, cVar);
    }
}
