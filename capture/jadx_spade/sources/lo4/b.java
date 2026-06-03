package lo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.StringUtilsKt;
import gk4.f;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements f {
    public static final int p;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public Integer i;
    public Integer j;
    public a k;
    public long l;
    public String m;
    public String n;
    public String o;

    static {
        Covode.recordClassIndex(609091);
        p = 8;
    }

    @Override // gk4.f
    public long a() {
        return this.l;
    }

    public final boolean c() {
        String str = this.g;
        if (str == null || !StringUtilsKt.a(str)) {
            return false;
        }
        return true;
    }

    public final boolean b() {
        if (StringUtilsKt.a(this.m) && StringUtilsKt.a(this.n) && StringUtilsKt.a(this.o)) {
            return true;
        }
        return false;
    }
}
