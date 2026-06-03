package dm4;

import com.bytedance.covode.number.Covode;
import dm4.d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p implements d {
    public static final p b;
    public static final int c;
    private final /* synthetic */ d a;

    static {
        Covode.recordClassIndex(608326);
        b = new p();
        c = 8;
    }

    @Override // dm4.d
    public boolean a(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return this.a.a(bookId);
    }

    private p() {
        d chapterDepend = xf4.d.o3.a().chapterDepend();
        this.a = chapterDepend == null ? new a() : chapterDepend;
    }

    public static final class a implements d {
        a() {
        }

        @Override // dm4.d
        public boolean a(String str) {
            return d.a.a(this, str);
        }
    }
}
