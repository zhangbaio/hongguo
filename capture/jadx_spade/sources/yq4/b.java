package yq4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements r {
    public static final b b;
    public static final int c;
    private final /* synthetic */ r a;

    static {
        Covode.recordClassIndex(611360);
        b = new b();
        c = 8;
    }

    @Override // yq4.r
    public v a(String str) {
        return this.a.a(str);
    }

    @Override // yq4.r
    public v b(String traceName) {
        Intrinsics.checkNotNullParameter(traceName, "traceName");
        return this.a.b(traceName);
    }

    @Override // yq4.r
    public void c(String str, String str2) {
        this.a.c(str, str2);
    }

    @Override // yq4.r
    public void d(String str, String str2) {
        this.a.d(str, str2);
    }

    @Override // yq4.r
    public w e(String str, String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.a.e(str, path);
    }

    @Override // yq4.r
    public void f(String str, String path, String str2) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.a.f(str, path, str2);
    }

    private b() {
        g b2;
        r F;
        p pVar = com.dragon.read.lib.community.inner.c.a.b().b;
        this.a = (pVar == null || (b2 = pVar.b()) == null || (F = b2.F()) == null) ? new a0() : F;
    }
}
