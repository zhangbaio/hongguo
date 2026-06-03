package cm4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import lm4.p;
import pm4.q;
import xf4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l extends i {
    public static final int k;
    private final String b;
    private final Context c;
    private final b d;
    private final xm6.e<lm4.h> e;
    private final xm6.e<lm4.k> f;
    public final h g;
    public final f h;
    public final n i;
    private final k j;

    static {
        Covode.recordClassIndex(608296);
        k = 8;
    }

    @Override // cm4.i
    public k a() {
        return this.j;
    }

    @Override // cm4.i
    public Context b() {
        return this.c;
    }

    @Override // cm4.i
    public pm4.j e() {
        return this.d.client();
    }

    @Override // cm4.i
    public lm4.h f() {
        if (this.e.b == null) {
            this.e.a(null, new p());
        }
        lm4.h hVar = this.e.b;
        Intrinsics.checkNotNull(hVar);
        return hVar;
    }

    @Override // cm4.i
    public lm4.k d() {
        boolean z;
        boolean z2;
        if (this.f.b == null) {
            lm4.h f = f();
            lm4.j g = f.g();
            g.b();
            lm4.c a = f.a();
            a.d(g);
            f.b().a();
            lm4.k h = f.h();
            if (a.j()) {
                ec4.g.Companion.a();
                q qVar = q.a;
                boolean a2 = qVar.a(g.g());
                boolean a3 = qVar.a(g.c());
                boolean z3 = true;
                if ((a2 && !a3) || (!a2 && a3)) {
                    z = true;
                } else {
                    z = false;
                }
                d.a aVar = xf4.d.o3;
                dm4.k skinDepend = aVar.a().skinDepend();
                if (skinDepend != null && skinDepend.h()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    dm4.k skinDepend2 = aVar.a().skinDepend();
                    if (skinDepend2 == null || !skinDepend2.v()) {
                        z3 = false;
                    }
                    if (!z3 && !z) {
                        h.c = g.c();
                    }
                }
                a.n();
                h.c = g.g();
                h.j = a.e();
            }
            this.f.a(null, h);
        }
        lm4.k kVar = this.f.b;
        Intrinsics.checkNotNull(kVar);
        return kVar;
    }

    @Override // cm4.i
    public com.dragon.read.kmp.b c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.i.a(key);
    }

    public l(String bookId, Context context, b clientProvider, a bookInfoProvider) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(clientProvider, "clientProvider");
        Intrinsics.checkNotNullParameter(bookInfoProvider, "bookInfoProvider");
        this.b = bookId;
        this.c = context;
        this.d = clientProvider;
        this.e = xm6.b.g(null);
        this.f = xm6.b.g(null);
        this.g = new h();
        this.h = new f();
        this.i = new n();
        this.j = new k(bookInfoProvider);
    }
}
