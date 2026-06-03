package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.ad;
import com.xiaomi.push.ge;
import com.xiaomi.push.gk;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.gw;
import com.xiaomi.push.hd;
import com.xiaomi.push.ho;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class o extends ad.a {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f61a = false;

    static {
        Covode.recordClassIndex(655315);
    }

    @Override // com.xiaomi.push.ad.a
    /* renamed from: a */
    public String mo187a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        ah a = ah.a(this.a);
        gw gwVar = new gw();
        if (this.f61a) {
            gwVar.a(0);
            gwVar.b(0);
        } else {
            gwVar.a(ai.a(a, gk.MISC_CONFIG));
            gwVar.b(ai.a(a, gk.PLUGIN_CONFIG));
        }
        hd hdVar = new hd("-1", false);
        hdVar.c(go.DailyCheckClientConfig.f529a);
        hdVar.a(ho.a(gwVar));
        com.xiaomi.channel.commonutils.logger.b.b("OcVersionCheckJob", "-->check version: checkMessage=", gwVar);
        u.a(this.a).a((u) hdVar, ge.Notification, (gr) null);
    }

    public o(Context context) {
        this.a = context;
    }
}
