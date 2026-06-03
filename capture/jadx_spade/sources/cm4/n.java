package cm4;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final int b;
    private final HashMap<String, com.dragon.read.kmp.b> a = new HashMap<>();

    static {
        Covode.recordClassIndex(608299);
        b = 8;
    }

    public final com.dragon.read.kmp.b a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.get(key);
    }

    public final void b(String key, com.dragon.read.kmp.b serviceImpl) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(serviceImpl, "serviceImpl");
        this.a.put(key, serviceImpl);
    }
}
