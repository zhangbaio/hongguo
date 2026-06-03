package dm4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import dm4.h;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r implements h {
    public static final r b;
    public static final int c;
    private final /* synthetic */ h a;

    static {
        Covode.recordClassIndex(608328);
        b = new r();
        c = 8;
    }

    @Override // dm4.h
    public void a(Context context, String str, boolean z, String str2) {
        this.a.a(context, str, z, str2);
    }

    @Override // dm4.h
    public void b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.a.b(url);
    }

    @Override // dm4.h
    public void c(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.a.c(bookId);
    }

    private r() {
        h navigatorDepend = xf4.d.o3.a().navigatorDepend();
        this.a = navigatorDepend == null ? new a() : navigatorDepend;
    }

    public static final class a implements h {
        a() {
        }

        @Override // dm4.h
        public void b(String str) {
            h.a.b(this, str);
        }

        @Override // dm4.h
        public void c(String str) {
            h.a.c(this, str);
        }

        @Override // dm4.h
        public void a(Context context, String str, boolean z, String str2) {
            h.a.a(this, context, str, z, str2);
        }
    }
}
