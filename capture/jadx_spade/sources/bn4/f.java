package bn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.component.biz.impl.SearchActivity;
import com.dragon.read.report.ReportUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final f a;

    static {
        Covode.recordClassIndex(608736);
        a = new f();
    }

    private f() {
    }

    public final void a(ym4.a args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Args args2 = new Args();
        ReportUtils.addCommonExtra(args2, SearchActivity.class);
        args.j(rn2.b.b(args2));
    }
}
