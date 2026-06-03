package zk6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b implements a {
    private final String a;
    private final int b;

    static {
        Covode.recordClassIndex(655888);
    }

    @Override // zk6.a
    public int getLevel() {
        return this.b;
    }

    @Override // zk6.a
    public String getTagName() {
        return this.a;
    }

    public b(String str, int i) {
        this.a = str;
        this.b = i;
    }
}
