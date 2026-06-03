package com.vivo.push.h;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u extends ab {

    public interface a {
        void a();

        void b();
    }

    static {
        Covode.recordClassIndex(655074);
    }

    u(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        if (vVar == null) {
            com.vivo.push.util.t.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) vVar;
        Context context = this.a;
        boolean d = com.vivo.push.util.aa.d(context, context.getPackageName());
        if (!d && !qVar.g()) {
            com.vivo.push.b.y yVar = new com.vivo.push.b.y(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(qVar.h()));
            String a2 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("remoteAppId", a2);
            }
            yVar.a(hashMap);
            com.vivo.push.m.a().a(yVar);
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.a.getPackageName() + " isMsgNoShowOnForeground :" + qVar.h());
            return;
        }
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(qVar.h())));
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ah.c(this.a), qVar.f(), qVar.k())) {
            com.vivo.push.b.y yVar2 = new com.vivo.push.b.y(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(qVar.h()));
            String a3 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a3)) {
                hashMap2.put("remoteAppId", a3);
            }
            yVar2.a(hashMap2);
            com.vivo.push.m.a().a(yVar2);
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "vertifyMsg not match =" + qVar.h());
            return;
        }
        InsideNotificationItem e = qVar.e();
        if (e != null) {
            com.vivo.push.util.t.d("OnNotificationArrivedTask", "targetType is " + e.getTargetType() + " ; target is " + e.getTargetContent());
            com.vivo.push.t.b(new v(this, e, qVar, d));
            return;
        }
        com.vivo.push.util.t.a("OnNotificationArrivedTask", "notify is null");
        com.vivo.push.util.t.c(this.a, "通知内容为空，" + qVar.h());
        com.vivo.push.util.f.a(qVar.h(), 1027L);
    }
}
