package pk6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    public final int a;
    public final int b;
    public final String c;

    static {
        Covode.recordClassIndex(655823);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (this.a == dVar.a) {
                    if (!(this.b == dVar.b) || !Intrinsics.areEqual(this.c, dVar.c)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        String str = this.c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PlayerTypeParam(playType=" + this.a + ", genreType=" + this.b + ", playFrom=" + this.c + ")";
    }

    public d(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }
}
