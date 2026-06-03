package com.ss.videoarch.liveplayer;

import android.hardware.HardwareBuffer;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface c {
    void a(a aVar);

    public static class a {
        public HardwareBuffer a;
        public int[] b;
        public int c;
        public int d;

        static {
            Covode.recordClassIndex(652911);
        }

        public a(HardwareBuffer hardwareBuffer, int[] iArr, int i, int i2) {
            this.a = hardwareBuffer;
            this.b = iArr;
            this.c = i;
            this.d = i2;
        }
    }
}
