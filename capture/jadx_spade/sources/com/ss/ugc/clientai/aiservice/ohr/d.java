package com.ss.ugc.clientai.aiservice.ohr;

import android.graphics.RectF;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    public final int a;
    public final float b;
    public final float c;
    public RectF d;

    static {
        Covode.recordClassIndex(652788);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && Float.compare(this.b, dVar.b) == 0 && Float.compare(this.c, dVar.c) == 0 && Intrinsics.areEqual(this.d, dVar.d);
    }

    public int hashCode() {
        int floatToIntBits = ((((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31;
        RectF rectF = this.d;
        return floatToIntBits + (rectF != null ? rectF.hashCode() : 0);
    }

    public String toString() {
        return "OHRPredictResult(hand=" + this.a + ", leftPercent=" + this.b + ", rightPercent=" + this.c + ", touchArea=" + this.d + ")";
    }

    public final float a() {
        int i = this.a;
        if (i != 1) {
            if (i != 2) {
                return 0.0f;
            }
            return this.c;
        }
        return this.b;
    }

    public d(int i, float f, float f2, RectF rectF) {
        this.a = i;
        this.b = f;
        this.c = f2;
        this.d = rectF;
    }
}
