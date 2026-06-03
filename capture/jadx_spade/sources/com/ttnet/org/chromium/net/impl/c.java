package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.impl.CronetLibraryLoader;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class c implements CronetLibraryLoader.b {
    public static final com.ttnet.org.chromium.base.g<CronetLibraryLoader.b> a;

    class a implements com.ttnet.org.chromium.base.g<CronetLibraryLoader.b> {
        a() {
        }
    }

    c() {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.b
    public void a() {
        wj6.a.b0();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.b
    public void b() {
        wj6.a.c0();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLibraryLoader.b
    public String getCronetVersion() {
        return wj6.a.d0();
    }

    static {
        Covode.recordClassIndex(654596);
        a = new a();
    }

    public static CronetLibraryLoader.b c() {
        com.ttnet.org.chromium.base.j.a(false);
        return new c();
    }
}
