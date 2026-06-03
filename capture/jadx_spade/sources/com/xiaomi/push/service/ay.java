package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ay implements aa {
    private static volatile ay a;

    /* renamed from: a, reason: collision with other field name */
    private long f955a;

    /* renamed from: a, reason: collision with other field name */
    Context f956a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f957a;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f959a = false;

    /* renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, a> f958a = new ConcurrentHashMap<>();

    static {
        Covode.recordClassIndex(655700);
    }

    public static abstract class a implements Runnable {
        long a;

        /* renamed from: a, reason: collision with other field name */
        String f960a;

        static {
            Covode.recordClassIndex(655701);
        }

        abstract void a(ay ayVar);

        @Override // java.lang.Runnable
        public void run() {
            if (ay.a != null) {
                Context context = ay.a.f956a;
                if (!com.xiaomi.push.at.c(context)) {
                    return;
                }
                if (System.currentTimeMillis() - ay.a.f957a.getLong(":ts-" + this.f960a, 0L) > this.a || com.xiaomi.push.aa.a(context)) {
                    com.xiaomi.push.o.a(ay.a.f957a.edit().putLong(":ts-" + this.f960a, System.currentTimeMillis()));
                    a(ay.a);
                }
            }
        }

        a(String str, long j) {
            this.f960a = str;
            this.a = j;
        }
    }

    @Override // com.xiaomi.push.service.aa
    /* renamed from: a, reason: collision with other method in class */
    public void mo716a() {
        if (this.f959a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f955a < 3600000) {
            return;
        }
        this.f955a = currentTimeMillis;
        this.f959a = true;
        com.xiaomi.push.ad.a(this.f956a).a(new Runnable() { // from class: com.xiaomi.push.service.ay.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it2 = ay.this.f958a.values().iterator();
                    while (it2.hasNext()) {
                        ((a) it2.next()).run();
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m54a("Sync job exception :" + e.getMessage());
                }
                ay.this.f959a = false;
            }
        }, (int) (Math.random() * 10.0d));
    }

    private ay(Context context) {
        this.f956a = context.getApplicationContext();
        this.f957a = context.getSharedPreferences("sync", 0);
    }

    public static ay a(Context context) {
        if (a == null) {
            synchronized (ay.class) {
                if (a == null) {
                    a = new ay(context);
                }
            }
        }
        return a;
    }

    public void a(a aVar) {
        if (this.f958a.putIfAbsent(aVar.f960a, aVar) == null) {
            com.xiaomi.push.ad.a(this.f956a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public String a(String str, String str2) {
        return this.f957a.getString(str + ":" + str2, "");
    }

    public void a(String str, String str2, String str3) {
        com.xiaomi.push.o.a(a.f957a.edit().putString(str + ":" + str2, str3));
    }
}
