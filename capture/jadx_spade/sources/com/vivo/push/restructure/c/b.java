package com.vivo.push.restructure.c;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.b.y;
import com.vivo.push.m;
import com.vivo.push.util.t;
import java.util.HashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b implements a {
    private com.vivo.push.restructure.b.a a;

    static {
        Covode.recordClassIndex(655129);
    }

    public b(com.vivo.push.restructure.b.a aVar) {
        this.a = aVar;
    }

    @Override // com.vivo.push.restructure.c.a
    public final void a(int i, String str) {
        t.d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i);
        if (i > 0 && !TextUtils.isEmpty(str)) {
            y yVar = new y(i);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", str);
            com.vivo.push.restructure.b.a aVar = this.a;
            if (aVar != null) {
                String a = aVar.a();
                if (!TextUtils.isEmpty(a)) {
                    hashMap.put("remoteAppId", a);
                }
            }
            yVar.a(hashMap);
            m.a().a(yVar);
        }
    }
}
