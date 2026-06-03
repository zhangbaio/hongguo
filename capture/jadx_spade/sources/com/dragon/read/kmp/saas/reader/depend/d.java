package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.g0;
import com.dragon.read.kmp.service.m0;
import com.dragon.read.kmp.service.q;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements dm4.g {
    public static final d a;

    static {
        Covode.recordClassIndex(608725);
        a = new d();
    }

    private d() {
    }

    @Override // dm4.g
    public boolean isBasicMode() {
        return g0.a.isBasicMode();
    }

    @Override // dm4.g
    public boolean isFoldDevice() {
        return g0.a.isFoldDevice();
    }

    @Override // dm4.g
    public boolean isPadDevice() {
        return g0.a.isPadDevice();
    }

    @Override // dm4.g
    public boolean needFitPadScreen() {
        return g0.a.needFitPadScreen();
    }

    @Override // dm4.g
    public void o(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        q a2 = m0.a();
        if (a2 != null) {
            a2.o(fileName);
        }
    }

    @Override // dm4.g
    public boolean q(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        q a2 = m0.a();
        if (a2 != null) {
            return a2.q(fileName);
        }
        return false;
    }
}
