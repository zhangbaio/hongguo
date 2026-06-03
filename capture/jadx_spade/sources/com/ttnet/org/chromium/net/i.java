package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.NetworkActiveNotifier;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class i implements NetworkActiveNotifier.a {
    public static final com.ttnet.org.chromium.base.g<NetworkActiveNotifier.a> a;

    class a implements com.ttnet.org.chromium.base.g<NetworkActiveNotifier.a> {
        a() {
        }
    }

    i() {
    }

    static {
        Covode.recordClassIndex(654480);
        a = new a();
    }

    public static NetworkActiveNotifier.a b() {
        com.ttnet.org.chromium.base.j.a(false);
        return new i();
    }

    @Override // com.ttnet.org.chromium.net.NetworkActiveNotifier.a
    public void a(long j) {
        wj6.a.C(j);
    }
}
