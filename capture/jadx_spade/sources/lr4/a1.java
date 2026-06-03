package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import com.dragon.read.util.NumberUtils;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a1 implements Comparable<a1> {
    public String a;
    public BookType b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public String n;
    public String o;

    static {
        Covode.recordClassIndex(611608);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a1 a1Var) {
        int i = this.m - a1Var.m;
        if (i != 0) {
            return i;
        }
        int parseInt = NumberUtils.parseInt(this.l, 0) - NumberUtils.parseInt(a1Var.l, 0);
        if (parseInt != 0) {
            return parseInt;
        }
        return NumberUtils.parseInt(this.k, 0) - NumberUtils.parseInt(a1Var.k, 0);
    }
}
