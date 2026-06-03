package com.ss.videoarch.strategy.utils.smartStrategy;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.NativeObject;
import com.ss.videoarch.strategy.utils.JNINamespace;
import lj6.a;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PitayaBridge extends NativeObject {
    static {
        Covode.recordClassIndex(653230);
    }

    private native void nativeSetObject();

    public PitayaBridge() {
        if (a.m().r.e.mEnableNativeStrategyCenter == 1) {
            nativeSetObject();
        }
    }
}
