package com.dragon.read.kmp.star_fans;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;

    static {
        Covode.recordClassIndex(609152);
        a = new e();
    }

    private e() {
    }

    private final void a(boolean z, String str) {
        String str2;
        ym4.a aVar = new ym4.a();
        aVar.g("ranking_list_page_entrance", str);
        o oVar = o.a;
        if (z) {
            str2 = "actor_list_show";
        } else {
            str2 = "actor_list_click";
        }
        oVar.d(str2, aVar);
    }

    public final void b(String str, boolean z, String rankingListPageEntrance) {
        Intrinsics.checkNotNullParameter(rankingListPageEntrance, "rankingListPageEntrance");
        if (!Intrinsics.areEqual("actor_fans_rank_list_8662", str)) {
            return;
        }
        a(z, rankingListPageEntrance);
    }

    public final void c(String str, boolean z, String rankingListPageEntrance) {
        boolean z2;
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(rankingListPageEntrance, "rankingListPageEntrance");
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "//mainRank", false, 2, (Object) null);
        if (contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "sub_selected_items=ranklist_actor_fans", false, 2, (Object) null);
            if (contains$default2) {
                a(z, rankingListPageEntrance);
            }
        }
    }
}
