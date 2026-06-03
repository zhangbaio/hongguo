package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.ProxyChangeListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class q implements ProxyChangeListener.b {
    public static final com.ttnet.org.chromium.base.g<ProxyChangeListener.b> a;

    class a implements com.ttnet.org.chromium.base.g<ProxyChangeListener.b> {
        a() {
        }
    }

    q() {
    }

    static {
        Covode.recordClassIndex(654507);
        a = new a();
    }

    public static ProxyChangeListener.b c() {
        com.ttnet.org.chromium.base.j.a(false);
        return new q();
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.b
    public void a(long j, ProxyChangeListener proxyChangeListener) {
        wj6.a.K(j, proxyChangeListener);
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.b
    public void b(long j, ProxyChangeListener proxyChangeListener, String str, int i, String str2, String[] strArr) {
        wj6.a.L(j, proxyChangeListener, str, i, str2, strArr);
    }
}
