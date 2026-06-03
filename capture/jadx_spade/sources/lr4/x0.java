package lr4;

import com.bytedance.covode.number.Covode;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class x0 {
    public final String a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public int j;

    static {
        Covode.recordClassIndex(611604);
    }

    public int hashCode() {
        return Objects.hash(this.a, Long.valueOf(this.b), Long.valueOf(this.e), Long.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j));
    }

    public String toString() {
        return "ReadingRecord{bookId='" + this.a + "', readTime=" + this.b + ", lastPopupTime=" + this.e + ", lastPopupReadTime=" + this.f + ", readChapterCount=" + this.g + ", chapterCount=" + this.h + ", popupCount=" + this.i + ", popupCountForChaseComment=" + this.j + '}';
    }

    public x0(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.a.equals(((x0) obj).a);
        }
        return false;
    }
}
