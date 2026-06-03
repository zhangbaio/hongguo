package com.vivo.push;

import com.bytedance.covode.number.Covode;
import com.vivo.push.listener.IPushQueryActionListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(654976);
    }

    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        com.vivo.push.util.g.a().execute(new b(this, iPushQueryActionListener));
    }

    public void querySubscribeState(IPushActionListener iPushActionListener) {
        com.vivo.push.util.g.a().execute(new c(this, iPushActionListener));
    }

    public void deleteRegid(IPushActionListener iPushActionListener, String str, String str2) {
        com.vivo.push.restructure.a.a().h().a(iPushActionListener, str, str2);
    }
}
