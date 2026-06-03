package sk6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    public final long a;
    public final long b;

    static {
        Covode.recordClassIndex(655844);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.a == aVar.a) {
                    if (this.b == aVar.b) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (j.a(this.a) * 31) + j.a(this.b);
    }

    public String toString() {
        return "DynamicBuffer(bufferLowerBound=" + this.a + ", bufferUpperBound=" + this.b + ")";
    }

    public final boolean b() {
        if (this.a > 0 && this.b > 0) {
            return true;
        }
        return false;
    }

    public final boolean a(a aVar) {
        if (aVar == null || this.a != aVar.a || this.b != aVar.b) {
            return false;
        }
        return true;
    }

    public a(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
