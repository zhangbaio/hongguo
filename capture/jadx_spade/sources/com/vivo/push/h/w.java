package com.vivo.push.h;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.h.u;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class w implements u.a {
    final /* synthetic */ v a;

    static {
        Covode.recordClassIndex(655077);
    }

    @Override // com.vivo.push.h.u.a
    public final void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("messageID", String.valueOf(this.a.b.h()));
        String a = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put("remoteAppId", a);
        }
        com.vivo.push.util.f.a(2122L, (HashMap<String, String>) hashMap);
    }

    @Override // com.vivo.push.h.u.a
    public final void a() {
        long k = com.vivo.push.m.a().k();
        if (k < 1400 && k != 1340) {
            com.vivo.push.util.t.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(k)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.a.b.h()));
        String a = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put("app_id", a);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.f.a(6L, (HashMap<String, String>) hashMap);
    }

    w(v vVar) {
        this.a = vVar;
    }
}
