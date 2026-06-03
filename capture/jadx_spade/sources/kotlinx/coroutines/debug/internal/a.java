package kotlinx.coroutines.debug.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static final f0 a;
    private static final e b;
    private static final e c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }

    static {
        Covode.recordClassIndex(659113);
        a = new f0("REHASH");
        b = new e(null);
        c = new e(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e d(Object obj) {
        if (obj == null) {
            return b;
        }
        if (Intrinsics.areEqual(obj, Boolean.TRUE)) {
            return c;
        }
        return new e(obj);
    }
}
