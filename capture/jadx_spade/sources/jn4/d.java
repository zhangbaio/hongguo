package jn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.ui.page.middle.rank.n;
import kotlin.jvm.internal.Intrinsics;
import ym4.k;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(608780);
        a = new d();
    }

    private d() {
    }

    public final void e(n rankTabModel) {
        Intrinsics.checkNotNullParameter(rankTabModel, "rankTabModel");
        k a2 = rankTabModel.a();
        c(tk3.a.d(a2), tk3.a.a(a2), rankTabModel.e);
    }

    public final void d(n rankTabModel, String enterType) {
        Intrinsics.checkNotNullParameter(rankTabModel, "rankTabModel");
        Intrinsics.checkNotNullParameter(enterType, "enterType");
        k a2 = rankTabModel.a();
        b(tk3.a.d(a2), tk3.a.a(a2), rankTabModel.e, enterType);
    }

    public final void c(String str, String str2, String str3) {
        boolean z;
        if (str3 != null && str3.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        o.a.d("show_hot_ranking_list", a(str, str2, str3));
    }

    private final ym4.a a(String str, String str2, String str3) {
        return new ym4.a().g("page_name", "search_result").g("tab_name", str).g("category_name", str2).g("ranking_list_name", str3);
    }

    public final void b(String str, String str2, String str3, String enterType) {
        boolean z;
        Intrinsics.checkNotNullParameter(enterType, "enterType");
        if (str3 != null && str3.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        o.a.d("enter_hot_ranking_list", a(str, str2, str3).g("enter_type", enterType));
    }
}
