package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bg implements Runnable {
    static {
        Covode.recordClassIndex(655375);
    }

    private bg() {
    }

    private static class a {
        public SharedPreferences a;

        /* renamed from: a, reason: collision with other field name */
        private final String f146a = "dc_job_result_time_26";

        static {
            Covode.recordClassIndex(655376);
        }

        private a() {
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m186a() {
            if (System.currentTimeMillis() - this.a.getLong("dc_job_result_time_26", 0L) > 0) {
                return true;
            }
            return false;
        }

        private long a() {
            long currentTimeMillis = System.currentTimeMillis();
            Random random = new Random(currentTimeMillis);
            return (((currentTimeMillis / 86400000) + 1) * 86400000) + (random.nextInt(3) * 86400000) + random.nextInt(46800000);
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m185a() {
            long j = this.a.getLong("dc_job_result_time_26", 0L);
            long currentTimeMillis = System.currentTimeMillis() - j;
            if (currentTimeMillis >= 0) {
                this.a.edit().putLong("dc_job_result_time_26", j + (((currentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }

        public a(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            this.a = sharedPreferences;
            long j = sharedPreferences.getLong("dc_job_result_time_26", 0L);
            if (j <= 0 || j - System.currentTimeMillis() > 259200000) {
                this.a.edit().putLong("dc_job_result_time_26", a()).apply();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        bc bcVar;
        int size;
        String str;
        String str2;
        bc bcVar2;
        Iterator<Map.Entry<String, ?>> it2;
        be beVar;
        bf bfVar;
        bf bfVar2;
        be beVar2;
        List<NotificationChannel> m689a;
        String str3;
        be beVar3;
        String str4 = "mipush_";
        String str5 = "com.xiaomi.xmsf";
        final Context m640a = q.m640a();
        if (m640a != null) {
            bc bcVar3 = new bc();
            bb bbVar = new bb(50L, 1000L);
            try {
                Map<String, ?> all = q.m640a().getSharedPreferences("pref_registered_pkg_names", 0).getAll();
                if (all != null && !all.isEmpty()) {
                    Set<String> keySet = all.keySet();
                    if (keySet.contains("com.xiaomi.xmsf")) {
                        size = keySet.size() - 1;
                    } else {
                        size = keySet.size();
                    }
                    bcVar3.a(size);
                    bf bfVar3 = new bf();
                    bfVar3.put("c", bcVar3.m183a());
                    Set<Map.Entry<String, ?>> entrySet = all.entrySet();
                    be beVar4 = new be();
                    Iterator<Map.Entry<String, ?>> it4 = entrySet.iterator();
                    bf bfVar4 = bfVar3;
                    be beVar5 = beVar4;
                    while (it4.hasNext()) {
                        Map.Entry<String, ?> next = it4.next();
                        final String key = next.getKey();
                        String str6 = (String) next.getValue();
                        if (!TextUtils.isEmpty(key) && !str5.equals(key) && !TextUtils.isEmpty(str6)) {
                            bf bfVar5 = new bf();
                            bfVar5.put("a", str6);
                            bfVar5.put("s", (String) bbVar.a(new Callable<String>() { // from class: com.xiaomi.push.bg.1
                                @Override // java.util.concurrent.Callable
                                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                public String call() {
                                    return String.valueOf(com.xiaomi.push.service.a.a(m640a, key));
                                }
                            }));
                            if (Build.VERSION.SDK_INT >= 26 && (m689a = com.xiaomi.push.service.af.a(m640a, key).m689a()) != null && !m689a.isEmpty()) {
                                be beVar6 = new be();
                                str2 = str5;
                                it2 = it4;
                                bfVar2 = bfVar4;
                                bcVar3.b(m689a.size());
                                Iterator<NotificationChannel> it5 = m689a.iterator();
                                while (it5.hasNext()) {
                                    final NotificationChannel next2 = it5.next();
                                    String id = next2.getId();
                                    bf bfVar6 = new bf();
                                    Iterator<NotificationChannel> it6 = it5;
                                    bc bcVar4 = bcVar3;
                                    if (id.startsWith(str4)) {
                                        beVar3 = beVar5;
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(str4);
                                            sb.append(key);
                                            str3 = str4;
                                            sb.append("_");
                                            String replace = id.replace(sb.toString(), "");
                                            bfVar6.put("t", 1);
                                            bfVar6.put("c", replace);
                                        } catch (Exception e) {
                                            e = e;
                                            bcVar = bcVar4;
                                        }
                                    } else {
                                        str3 = str4;
                                        beVar3 = beVar5;
                                        if (id.startsWith("mipush|")) {
                                            String replace2 = id.replace("mipush|" + key + "|", "");
                                            bfVar6.put("t", 2);
                                            bfVar6.put("c", replace2);
                                        }
                                    }
                                    bfVar6.put("s", (String) bbVar.a(new Callable() { // from class: com.xiaomi.push.bg.2
                                        @Override // java.util.concurrent.Callable
                                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                        public String call() {
                                            return String.valueOf(com.xiaomi.push.service.f.a(m640a, key, next2));
                                        }
                                    }));
                                    beVar6.put(bfVar6);
                                    beVar5 = beVar3;
                                    it5 = it6;
                                    bcVar3 = bcVar4;
                                    str4 = str3;
                                }
                                str = str4;
                                bcVar2 = bcVar3;
                                bfVar5.put("c", beVar6);
                                beVar2 = beVar5;
                            } else {
                                str = str4;
                                str2 = str5;
                                bcVar2 = bcVar3;
                                it2 = it4;
                                bfVar2 = bfVar4;
                                beVar2 = beVar5;
                            }
                            beVar2.put(bfVar5);
                            bf bfVar7 = bfVar2;
                            bfVar7.put("d", beVar2);
                            bfVar = bfVar7;
                            beVar = beVar2;
                        } else {
                            str = str4;
                            str2 = str5;
                            bcVar2 = bcVar3;
                            it2 = it4;
                            bfVar = bfVar4;
                            beVar = beVar5;
                        }
                        if (bfVar.a() > 30720) {
                            bcVar2.m184a();
                            bcVar = bcVar2;
                            try {
                                bcVar.c(bfVar.a());
                                a(m640a, bfVar, bcVar);
                                bf bfVar8 = new bf();
                                bfVar8.put("c", bcVar.m183a());
                                bfVar = bfVar8;
                                beVar = new be();
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } else {
                            bcVar = bcVar2;
                        }
                        bcVar3 = bcVar;
                        str5 = str2;
                        it4 = it2;
                        str4 = str;
                        bfVar4 = bfVar;
                        beVar5 = beVar;
                    }
                    bcVar = bcVar3;
                    if (beVar5.length() > 0) {
                        bcVar.m184a();
                        bcVar.c(bfVar4.a());
                        a(m640a, bfVar4, bcVar);
                    }
                } else {
                    bcVar = bcVar3;
                }
                e = null;
            } catch (Exception e3) {
                e = e3;
                bcVar = bcVar3;
            }
            a(bcVar, bbVar, e);
        }
    }

    public static void a(Context context) {
        if (context != null && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            a aVar = new a(context);
            if (aVar.m186a()) {
                new Thread(new bg()).start();
                aVar.m185a();
            }
        }
    }

    private void a(Context context, bf bfVar, bc bcVar) {
        gi giVar = new gi();
        giVar.d("category_app_channel_info");
        giVar.c("app_channel_info");
        giVar.b(bfVar.toString());
        giVar.a(false);
        giVar.a(1L);
        giVar.a("xmsf_channel");
        giVar.b(System.currentTimeMillis());
        giVar.g("com.xiaomi.xmsf");
        giVar.e("com.xiaomi.xmsf");
        giVar.f(com.xiaomi.push.service.az.a());
        com.xiaomi.push.service.ba.a(context, giVar);
    }

    private void a(bc bcVar, bb bbVar, Exception exc) {
        HashMap hashMap = new HashMap();
        String m746a = com.xiaomi.push.service.q.m746a(q.m640a());
        if (!TextUtils.isEmpty(m746a)) {
            hashMap.put("uuid", m746a);
        }
        hashMap.put("appCount", Long.valueOf(bcVar.m183a()));
        hashMap.put("channels", Long.valueOf(bcVar.b()));
        hashMap.put("packCount", Long.valueOf(bcVar.c()));
        hashMap.put("totalSize", Long.valueOf(bcVar.d()));
        hashMap.put("isBatch", Integer.valueOf(bcVar.a()));
        hashMap.put("maxCallTime", Long.valueOf(bbVar.a()));
        hashMap.put("minCallTime", Long.valueOf(bbVar.b()));
        hashMap.put("callAvg", Long.valueOf(bbVar.c()));
        hashMap.put("duration", Long.valueOf(bbVar.d()));
        if (exc != null) {
            hashMap.put("exception", exc.toString());
        }
        eg.a().a("app_switch_upload", hashMap);
    }
}
