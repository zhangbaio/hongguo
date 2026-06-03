package ym4;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    public static final q a;

    static {
        Covode.recordClassIndex(608699);
        a = new q();
    }

    private q() {
    }

    public final void b(String page, String stage, a args) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(args, "args");
        a(page, stage, true, args);
    }

    public final void c(String page, String stage, a args) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(args, "args");
        a(page, stage, false, args);
    }

    private final void a(String str, String str2, boolean z, a aVar) {
        o oVar = o.a;
        aVar.g("page", str);
        aVar.g("stage", str2);
        aVar.g("is_kmp", Boolean.valueOf(z));
        Unit unit = Unit.INSTANCE;
        oVar.d("series_ui_monitor", aVar);
    }
}
