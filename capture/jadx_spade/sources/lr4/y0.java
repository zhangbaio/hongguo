package lr4;

import com.bytedance.covode.number.Covode;
import java.util.Date;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class y0 {
    public long a;
    public Date b;
    public String c;
    public long d;

    static {
        Covode.recordClassIndex(611605);
    }

    public static class a {
        public Date a;
        public String b;
        public long c;

        static {
            Covode.recordClassIndex(611606);
        }

        public String toString() {
            return "ReadingTimeInSingleDay{date=" + this.a + ", bookId='" + this.b + "', readingTime=" + this.c + '}';
        }

        public a(Date date, String str, long j) {
            this.a = date;
            this.b = str;
            this.c = j;
        }
    }

    public String toString() {
        return "ReadingTime{id=" + this.a + ", date=" + this.b + ", bookId='" + this.c + "', readingTime=" + this.d + '}';
    }

    public y0(Date date, String str, long j) {
        this.b = date;
        this.c = str;
        this.d = j;
    }
}
