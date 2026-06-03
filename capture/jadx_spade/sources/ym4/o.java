package ym4;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final o a;

    static {
        Covode.recordClassIndex(608697);
        a = new o();
    }

    private o() {
    }

    public final void b(a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        p.b(params);
    }

    public final void a(String event, a params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        p.a(event, params);
    }

    public final void d(String event, a params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        p.a(event, params);
    }

    public final void c(String event, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        p.a(event, new a(params));
    }
}
