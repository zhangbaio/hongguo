package lr4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class r {
    public long a = System.currentTimeMillis();
    public final String b;
    public long c;
    public String d;

    static {
        Covode.recordClassIndex(611566);
    }

    public String toString() {
        return "CacheEntity{key='" + this.b + "', value='" + this.d + "', createTime=" + this.a + ", updateTime=" + this.c + '}';
    }

    public r(String str) {
        this.b = str;
    }
}
