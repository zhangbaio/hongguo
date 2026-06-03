package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.c;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class r extends q {
    private VersionSafeCallbacks.b V;

    static {
        Covode.recordClassIndex(654642);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    VersionSafeCallbacks.b c0() {
        return this.V;
    }

    @Override // com.ttnet.org.chromium.net.impl.q, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.h
    /* renamed from: p0 */
    public CronetEngineBuilderImpl x(c.a.b bVar) {
        this.V = new VersionSafeCallbacks.b(bVar);
        return this;
    }

    public r(Context context, boolean z) {
        super(context, z);
    }
}
