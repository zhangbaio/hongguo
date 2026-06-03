package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ad;
import com.xiaomi.push.bv;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bm {
    private static volatile bm a;

    /* renamed from: a, reason: collision with other field name */
    private Context f149a;

    /* renamed from: a, reason: collision with other field name */
    private bw f151a;

    /* renamed from: a, reason: collision with other field name */
    private bx f152a;
    private String e;
    private String f;

    /* renamed from: a, reason: collision with other field name */
    private final String f153a = "push_stat_sp";

    /* renamed from: b, reason: collision with other field name */
    private final String f154b = "upload_time";

    /* renamed from: c, reason: collision with other field name */
    private final String f155c = "delete_time";
    private final String d = "check_time";

    /* renamed from: a, reason: collision with other field name */
    private ad.a f150a = new ad.a() { // from class: com.xiaomi.push.bm.1
        @Override // com.xiaomi.push.ad.a
        /* renamed from: a */
        public String mo187a() {
            return "10052";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
            if (bm.this.f152a != null) {
                bm.this.f152a.a(bm.this.f149a);
                bm.this.b("upload_time");
            }
        }
    };
    private ad.a b = new ad.a() { // from class: com.xiaomi.push.bm.2
        @Override // com.xiaomi.push.ad.a
        /* renamed from: a */
        public String mo187a() {
            return "10054";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
            bv.a(bm.this.f149a).a(new bo(bm.this.c(), new WeakReference(bm.this.f149a)));
            bm.this.b("check_time");
        }
    };
    private ad.a c = new ad.a() { // from class: com.xiaomi.push.bm.3
        @Override // com.xiaomi.push.ad.a
        /* renamed from: a */
        public String mo187a() {
            return "10053";
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bm.this.f152a != null) {
                bm.this.f152a.b(bm.this.f149a);
                bm.this.b("delete_time");
            }
        }
    };

    static {
        Covode.recordClassIndex(655382);
    }

    public String b() {
        return this.f;
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f151a != null) {
            if (bool.booleanValue()) {
                this.f151a.a(this.f149a, str2, str);
            } else {
                this.f151a.b(this.f149a, str2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f149a.getDatabasePath(bn.f157a).getAbsolutePath();
    }

    private boolean a() {
        return com.xiaomi.push.service.ah.a(this.f149a).a(gj.StatDataSwitch.a(), true);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m195a() {
        return this.e;
    }

    public static bm a(Context context) {
        if (a == null) {
            synchronized (bm.class) {
                if (a == null) {
                    a = new bm(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f149a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        o.a(edit);
    }

    private bm(Context context) {
        this.f149a = context;
    }

    public void a(bv.a aVar) {
        bv.a(this.f149a).a(aVar);
    }

    public void a(gi giVar) {
        if (!a() || !com.xiaomi.push.service.az.a(giVar.e())) {
            return;
        }
        a(bs.a(this.f149a, c(), giVar));
    }

    public void a(String str) {
        if (!a() || TextUtils.isEmpty(str)) {
            return;
        }
        a(by.a(this.f149a, str));
    }
}
