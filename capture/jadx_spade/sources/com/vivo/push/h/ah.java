package com.vivo.push.h;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ah extends ab {
    static {
        Covode.recordClassIndex(655051);
    }

    ah(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.v vVar2 = (com.vivo.push.b.v) vVar;
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ah.c(this.a), vVar2.f(), vVar2.k())) {
            com.vivo.push.util.t.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.y yVar = new com.vivo.push.b.y(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(vVar2.h()));
            String a = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a)) {
                hashMap.put("remoteAppId", a);
            }
            yVar.a(hashMap);
            com.vivo.push.m.a().a(yVar);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.a, vVar2.e());
        com.vivo.push.util.t.d("OnUndoMsgTask", "undo message " + vVar2.e() + ", " + repealNotifyById);
        if (repealNotifyById) {
            com.vivo.push.util.t.b(this.a, "回收client通知成功, 上报埋点 1031, messageId = " + vVar2.e());
            com.vivo.push.util.f.a(vVar2.e(), 1031L);
            return;
        }
        com.vivo.push.util.t.d("OnUndoMsgTask", "undo message fail，messageId = " + vVar2.e());
        com.vivo.push.util.t.c(this.a, "回收client通知失败，messageId = " + vVar2.e());
    }
}
