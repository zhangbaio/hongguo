package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ad;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dj {
    private static volatile dj a;

    /* renamed from: a, reason: collision with other field name */
    private Context f260a;

    /* renamed from: a, reason: collision with other field name */
    private a f261a;

    public interface a {
        void a();
    }

    static {
        Covode.recordClassIndex(655445);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m274a() {
        ad.a(this.f260a).a(new Runnable() { // from class: com.xiaomi.push.dj.1
            @Override // java.lang.Runnable
            public void run() {
                dj.this.b();
            }
        });
    }

    private boolean a() {
        Application application;
        try {
            Context context = this.f260a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new dd(this.f260a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        ad a2 = ad.a(this.f260a);
        com.xiaomi.push.service.ah a3 = com.xiaomi.push.service.ah.a(this.f260a);
        SharedPreferences sharedPreferences = this.f260a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < 172800000) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(gj.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(gj.StorageCollectionFrequency.a(), 86400));
            a2.a(new dl(this.f260a, a4), a4, 0);
        }
        if (j.m631a(this.f260a) && (aVar = this.f261a) != null) {
            aVar.a();
        }
        if (a3.a(gj.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(a3, a2, true);
    }

    private dj(Context context) {
        this.f260a = context;
    }

    public static int a(int i) {
        return Math.max(60, i);
    }

    public static dj a(Context context) {
        if (a == null) {
            synchronized (dj.class) {
                if (a == null) {
                    a = new dj(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.push.service.ah ahVar, ad adVar, boolean z) {
        if (ahVar.a(gj.UploadSwitch.a(), true)) {
            dm dmVar = new dm(this.f260a);
            if (z) {
                adVar.a((ad.a) dmVar, a(ahVar.a(gj.UploadFrequency.a(), 86400)));
            } else {
                adVar.m134a((ad.a) dmVar);
            }
        }
    }
}
