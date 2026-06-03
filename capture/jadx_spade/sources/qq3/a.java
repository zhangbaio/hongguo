package qq3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import kotlin.jvm.internal.Intrinsics;
import tq3.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    private static final g a;

    static {
        Covode.recordClassIndex(598304);
        a = (g) ShortSeriesApi.Companion.c().getDocker().d(g.class);
    }

    public static final <T> T a(String key, T t, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(t, "default");
        g gVar = a;
        if (gVar.G()) {
            return (T) gVar.Z3(key, t, z);
        }
        return (T) b(key, t, z);
    }

    public static final <T> T b(String key, T t, boolean z) {
        boolean z2;
        T t2;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(t, "default");
        String W0 = a.W0(key, z);
        if (W0 != null && W0.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && (t2 = (T) JSONUtils.getSafeObject(W0, t.getClass())) != null) {
            ShortSeriesApi.Companion.c().getAbTagManager().b(key, W0);
            return t2;
        }
        return t;
    }

    public static /* synthetic */ Object c(String str, Object obj, boolean z, int i, Object obj2) {
        if ((i & 4) != 0) {
            z = true;
        }
        return b(str, obj, z);
    }
}
