package com.ss.ttm.player;

import android.hardware.HardwareBuffer;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AJCodecHardwareBuffer {
    public int colorSpace;
    public HardwareBuffer hardwareBuffer;
    public int[] roi;
    public int rotation;

    static {
        Covode.recordClassIndex(652065);
    }

    public AJCodecHardwareBuffer(HardwareBuffer hardwareBuffer, int[] iArr, int i, int i2) {
        this.hardwareBuffer = hardwareBuffer;
        this.roi = iArr;
        this.rotation = i;
        this.colorSpace = i2;
    }
}
