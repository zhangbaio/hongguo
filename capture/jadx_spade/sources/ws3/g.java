package ws3;

import android.app.Application;
import com.bytedance.covode.number.Covode;
import k44.e0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final g a;
    private static final g b;

    private g() {
    }

    public final g a() {
        return b;
    }

    static {
        Covode.recordClassIndex(599157);
        g gVar = new g();
        a = gVar;
        b = gVar;
    }

    public final void b(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        e0.a.h().D3(application);
    }
}
