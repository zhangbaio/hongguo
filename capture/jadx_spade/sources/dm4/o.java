package dm4;

import com.bytedance.covode.number.Covode;
import dm4.c;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o implements c {
    public static final o b;
    public static final int c;
    private final /* synthetic */ c a;

    static {
        Covode.recordClassIndex(608325);
        b = new o();
        c = 8;
    }

    @Override // dm4.c
    public boolean a(String bookId, boolean z, Integer num, String str, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return this.a.a(bookId, z, num, str, z2, z3);
    }

    private o() {
        c catalogDepend = xf4.d.o3.a().catalogDepend();
        this.a = catalogDepend == null ? new a() : catalogDepend;
    }

    public static final class a implements c {
        a() {
        }

        @Override // dm4.c
        public boolean a(String str, boolean z, Integer num, String str2, boolean z2, boolean z3) {
            return c.a.a(this, str, z, num, str2, z2, z3);
        }
    }
}
