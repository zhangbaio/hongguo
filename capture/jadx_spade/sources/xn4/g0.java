package xn4;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g0 {
    public static final g0 a;

    static {
        Covode.recordClassIndex(608965);
        a = new g0();
    }

    private g0() {
    }

    private final zn4.e b() {
        return (zn4.e) eo0.c.a.a(Reflection.getOrCreateKotlinClass(zn4.e.class));
    }

    public final boolean c() {
        zn4.e b = b();
        if (b != null) {
            return b.ba();
        }
        return false;
    }

    public final boolean d() {
        zn4.e b = b();
        if (b != null) {
            return b.g8();
        }
        return false;
    }

    public final Map<String, String> a() {
        Map<String, String> emptyMap;
        Map<String, String> requestSharkParam;
        zn4.e b = b();
        if (b == null || (requestSharkParam = b.getRequestSharkParam()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return requestSharkParam;
    }

    public final String e(String originUrl) {
        String ea;
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        zn4.e b = b();
        if (b != null && (ea = b.ea(originUrl)) != null) {
            return ea;
        }
        return originUrl;
    }
}
