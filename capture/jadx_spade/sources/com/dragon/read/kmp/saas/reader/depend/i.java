package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.d1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i implements dm4.k {
    public static final i a;

    static {
        Covode.recordClassIndex(608730);
        a = new i();
    }

    private i() {
    }

    @Override // dm4.k
    public boolean h() {
        return b1.a.v();
    }

    @Override // dm4.k
    public boolean v() {
        return b1.a.u();
    }

    @Override // dm4.k
    public boolean isDarkSkin() {
        return d1.d(b1.a.h());
    }
}
