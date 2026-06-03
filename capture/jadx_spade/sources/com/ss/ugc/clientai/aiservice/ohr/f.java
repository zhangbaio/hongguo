package com.ss.ugc.clientai.aiservice.ohr;

import android.graphics.RectF;
import com.bytedance.covode.number.Covode;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    public int d;
    private final int a = 15;
    private final RectF[] b = {new RectF(), new RectF()};
    private final LinkedList<RectF>[] c = {new LinkedList<>(), new LinkedList<>()};
    private final int e = 6;

    static {
        Covode.recordClassIndex(652792);
    }

    private final RectF a(float[] fArr) {
        RectF rectF = new RectF();
        int length = fArr.length / this.e;
        for (int i = 0; i < length; i++) {
            int i2 = this.e;
            float f = fArr[i * i2];
            float f2 = fArr[(i2 * i) + 1];
            float f3 = rectF.left;
            if (f3 == 0.0f || f < f3) {
                rectF.left = f;
            }
            float f4 = rectF.top;
            if (f4 == 0.0f || f2 < f4) {
                rectF.top = f2;
            }
            float f5 = rectF.right;
            if (f5 == 0.0f || f > f5) {
                rectF.right = f;
            }
            float f6 = rectF.bottom;
            if (f6 == 0.0f || f2 > f6) {
                rectF.bottom = f2;
            }
        }
        return rectF;
    }

    public final void b(int i, float[] inputBuffer) {
        Intrinsics.checkNotNullParameter(inputBuffer, "inputBuffer");
        if (i != 1 && i != 2) {
            return;
        }
        this.d = i;
        LinkedList<RectF> linkedList = this.c[i - 1];
        synchronized (linkedList) {
            linkedList.offerLast(a(inputBuffer));
            if (linkedList.size() > this.a) {
                linkedList.removeFirst();
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
