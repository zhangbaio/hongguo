package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g0 implements n {
    public static final g0 a;
    private static final Lazy b;
    public static final int c;

    private g0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n F0() {
        return (n) eo0.c.a.a(Reflection.getOrCreateKotlinClass(n.class));
    }

    private final n J0() {
        return (n) b.getValue();
    }

    @Override // com.dragon.read.kmp.service.n
    public boolean c() {
        n J0 = J0();
        if (J0 == null || !J0.c()) {
            return false;
        }
        return true;
    }

    @Override // com.dragon.read.kmp.service.n
    public int getAppId() {
        n J0 = J0();
        if (J0 != null) {
            return J0.getAppId();
        }
        return 1967;
    }

    @Override // com.dragon.read.kmp.service.n
    public int getComplianceStatus() {
        n J0 = J0();
        if (J0 != null) {
            return J0.getComplianceStatus();
        }
        return 0;
    }

    @Override // com.dragon.read.kmp.service.n
    public String getDeviceId() {
        String deviceId;
        n J0 = J0();
        if (J0 == null || (deviceId = J0.getDeviceId()) == null) {
            return "";
        }
        return deviceId;
    }

    @Override // com.dragon.read.kmp.service.n
    public String getDevicePlatform() {
        String devicePlatform;
        n J0 = J0();
        if (J0 == null || (devicePlatform = J0.getDevicePlatform()) == null) {
            return "";
        }
        return devicePlatform;
    }

    @Override // com.dragon.read.kmp.service.n
    public int getUpdateVersionCode() {
        n J0 = J0();
        if (J0 != null) {
            return J0.getUpdateVersionCode();
        }
        return 0;
    }

    @Override // com.dragon.read.kmp.service.n
    public boolean isBasicMode() {
        n J0 = J0();
        if (J0 != null) {
            return J0.isBasicMode();
        }
        return false;
    }

    @Override // com.dragon.read.kmp.service.n
    public boolean isFoldDevice() {
        n J0 = J0();
        if (J0 != null) {
            return J0.isFoldDevice();
        }
        return false;
    }

    @Override // com.dragon.read.kmp.service.n
    public boolean isPadDevice() {
        n J0 = J0();
        if (J0 != null) {
            return J0.isPadDevice();
        }
        return false;
    }

    @Override // com.dragon.read.kmp.service.n
    public boolean needFitPadScreen() {
        n J0 = J0();
        if (J0 != null) {
            return J0.needFitPadScreen();
        }
        return false;
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(608871);
        a = new g0();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.service.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n F0;
                F0 = g0.F0();
                return F0;
            }
        });
        b = lazy;
        c = 8;
    }
}
