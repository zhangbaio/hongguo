package dm4;

import com.bytedance.covode.number.Covode;
import dm4.b;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n implements b {
    public static final n b;
    public static final int c;
    private final /* synthetic */ b a;

    static {
        Covode.recordClassIndex(608324);
        b = new n();
        c = 8;
    }

    @Override // dm4.b
    public Object a(String str, String str2, Continuation<? super Unit> continuation) {
        return this.a.a(str, str2, continuation);
    }

    @Override // dm4.b
    public Object b(String str, String str2, Continuation<? super Boolean> continuation) {
        return this.a.b(str, str2, continuation);
    }

    private n() {
        b bookshelfDepend = xf4.d.o3.a().bookshelfDepend();
        this.a = bookshelfDepend == null ? new a() : bookshelfDepend;
    }

    public static final class a implements b {
        a() {
        }

        @Override // dm4.b
        public Object a(String str, String str2, Continuation<? super Unit> continuation) {
            return b.a.a(this, str, str2, continuation);
        }

        @Override // dm4.b
        public Object b(String str, String str2, Continuation<? super Boolean> continuation) {
            return b.a.b(this, str, str2, continuation);
        }
    }
}
