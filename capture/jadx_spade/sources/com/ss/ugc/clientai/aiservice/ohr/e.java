package com.ss.ugc.clientai.aiservice.ohr;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    public float a;
    public float b;
    public long c;

    static {
        Covode.recordClassIndex(652791);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Float.compare(this.a, eVar.a) == 0 && Float.compare(this.b, eVar.b) == 0 && this.c == eVar.c;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + j.a(this.c);
    }

    public String toString() {
        return "OHRServiceInput(x=" + this.a + ", y=" + this.b + ", timestamp=" + this.c + ")";
    }

    public e(float f, float f2, long j) {
        this.a = f;
        this.b = f2;
        this.c = j;
    }
}
