package zp4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609411);
        a = new a();
    }

    private a() {
    }

    public final void a(String str, ym4.a args, boolean z, String str2) {
        boolean z2;
        Intrinsics.checkNotNullParameter(args, "args");
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return;
        }
        o.a.d(str, args);
    }

    public static /* synthetic */ void b(a aVar, String str, ym4.a aVar2, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        aVar.a(str, aVar2, z, str2);
    }
}
