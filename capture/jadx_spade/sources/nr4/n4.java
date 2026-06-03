package nr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n4 implements m4 {
    public static final int b;
    private final m4 a;

    static {
        Covode.recordClassIndex(611787);
        b = 8;
    }

    @Override // nr4.m4
    public int clearAll() {
        return this.a.clearAll();
    }

    @Override // nr4.m4
    public int a(int i) {
        return this.a.a(i);
    }

    public n4(m4 dao) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.a = dao;
    }

    @Override // nr4.m4
    public void insert(lr4.j1 record) {
        Intrinsics.checkNotNullParameter(record, "record");
        this.a.insert(record);
    }

    @Override // nr4.m4
    public int b(long j, Long l, Integer num, int i) {
        return this.a.b(j, l, num, i);
    }
}
