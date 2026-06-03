package ym4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    static {
        Covode.recordClassIndex(608698);
    }

    public static final void b(a params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public static final void a(String event, a params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        d dVar = (d) eo0.c.a.a(Reflection.getOrCreateKotlinClass(d.class));
        if (dVar != null) {
            dVar.onEvent(event, params.a);
        }
    }
}
