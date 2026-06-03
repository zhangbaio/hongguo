package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.net.AndroidNetworkLibrary;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
class a implements AndroidNetworkLibrary.b {
    public static final com.ttnet.org.chromium.base.g<AndroidNetworkLibrary.b> a;

    /* renamed from: com.ttnet.org.chromium.net.a$a, reason: collision with other inner class name */
    class C0119a implements com.ttnet.org.chromium.base.g<AndroidNetworkLibrary.b> {
        C0119a() {
        }
    }

    a() {
    }

    static {
        Covode.recordClassIndex(654432);
        a = new C0119a();
    }

    public static AndroidNetworkLibrary.b b() {
        com.ttnet.org.chromium.base.j.a(true);
        return new a();
    }

    @Override // com.ttnet.org.chromium.net.AndroidNetworkLibrary.b
    public void a(boolean z, int i) {
        wj6.a.B(z, i);
    }
}
