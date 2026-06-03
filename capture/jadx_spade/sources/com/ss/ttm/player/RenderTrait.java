package com.ss.ttm.player;

import android.hardware.HardwareBuffer;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class RenderTrait extends TraitObject {
    static {
        Covode.recordClassIndex(652159);
    }

    public abstract void onClose();

    public abstract int onDrawFrame(HardwareBuffer hardwareBuffer, int[] iArr, int i);

    public int onDrawFrame(AJCodecHardwareBuffer aJCodecHardwareBuffer) {
        return 0;
    }

    public abstract int onOpen();

    public int onOpen(int i) {
        return -1;
    }

    public RenderTrait(int i) {
        super(6, i, 0L);
    }
}
