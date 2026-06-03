package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.push.service.XMPushService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fz implements XMPushService.n {
    private static boolean a;

    /* renamed from: a, reason: collision with other field name */
    private int f484a;

    /* renamed from: a, reason: collision with other field name */
    private Context f485a;
    private boolean b;

    static {
        Covode.recordClassIndex(655545);
        a = false;
    }

    private boolean a() {
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f485a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > this.f484a) {
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a, reason: collision with other method in class */
    public void mo453a() {
        a(this.f485a);
        if (this.b && a()) {
            com.xiaomi.channel.commonutils.logger.b.m54a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            gd a2 = gc.a(this.f485a).a();
            if (!a(a2)) {
                com.xiaomi.channel.commonutils.logger.b.m54a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            ga.a(this.f485a, a2);
        }
    }

    public static void a(boolean z) {
        a = z;
    }

    public fz(Context context) {
        this.f485a = context;
    }

    private String a(String str) {
        if ("com.xiaomi.xmsf".equals(str)) {
            return "1000271";
        }
        return this.f485a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = com.xiaomi.push.service.ah.a(context).a(gj.TinyDataUploadSwitch.a(), true);
        int a2 = com.xiaomi.push.service.ah.a(context).a(gj.TinyDataUploadFrequency.a(), 7200);
        this.f484a = a2;
        this.f484a = Math.max(60, a2);
    }

    private boolean a(gd gdVar) {
        if (!at.m155a(this.f485a) || gdVar == null || TextUtils.isEmpty(a(this.f485a.getPackageName())) || !new PolarisFileWrapper(this.f485a.getFilesDir(), "tiny_data.data").exists() || a) {
            return false;
        }
        if (com.xiaomi.push.service.ah.a(this.f485a).a(gj.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) && !i.m621a(this.f485a) && !i.m624b(this.f485a)) {
            return false;
        }
        return true;
    }
}
