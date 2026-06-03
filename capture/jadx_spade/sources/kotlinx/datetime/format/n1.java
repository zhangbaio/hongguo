package kotlinx.datetime.format;

import com.bytedance.covode.number.Covode;
import kotlinx.datetime.format.j1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class n1 extends j1.b {
    private final char b;
    private final int c;

    static {
        Covode.recordClassIndex(659565);
    }

    @Override // kotlinx.datetime.format.j1.b
    public int a() {
        return this.c;
    }

    @Override // kotlinx.datetime.format.j1.b
    public char b() {
        return this.b;
    }

    public n1(char c, int i) {
        super(null);
        this.b = c;
        this.c = i;
    }
}
