package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ad;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bi extends ad.a {
    private Context a;

    static {
        Covode.recordClassIndex(655378);
    }

    @Override // com.xiaomi.push.ad.a
    /* renamed from: a */
    public String mo187a() {
        return "100887";
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m63a().isPerfUploadSwitchOpen();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e);
        }
    }

    public bi(Context context) {
        this.a = context;
    }
}
