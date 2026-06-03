package com.tencent.tinker.android.dx.instruction;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Opcodes {
    static {
        Covode.recordClassIndex(653639);
    }

    public static int extractOpcodeFromUnit(int i) {
        int i2 = i & 255;
        return (i2 == 0 || i2 == 255) ? i : i2;
    }

    private Opcodes() {
    }
}
