package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ad;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bh extends ad.a {
    private Context a;

    static {
        Covode.recordClassIndex(655377);
    }

    @Override // com.xiaomi.push.ad.a
    /* renamed from: a, reason: collision with other method in class */
    public String mo187a() {
        return "100886";
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m63a().isEventUploadSwitchOpen();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.a).m65b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public bh(Context context) {
        this.a = context;
    }
}
