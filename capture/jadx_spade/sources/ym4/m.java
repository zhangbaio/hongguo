package ym4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.ReadingBookType;
import com.bytedance.kmp.reading.model.om0;
import com.dragon.read.kmp.utils.h0;
import com.dragon.read.kmp.utils.k0;
import jd4.c;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final m a;

    static {
        Covode.recordClassIndex(608694);
        a = new m();
    }

    private m() {
    }

    private final String d(s sVar) {
        Integer num;
        if (sVar != null) {
            num = Integer.valueOf(sVar.a);
        } else {
            num = null;
        }
        zg4.a aVar = zg4.a.a;
        int c = aVar.c();
        if (num != null && num.intValue() == c) {
            return "video_series_panel";
        }
        int a2 = aVar.a();
        if (num != null && num.intValue() == a2) {
            return "same_actor_more_videos";
        }
        int b = aVar.b();
        if (num != null && num.intValue() == b) {
            return "same_cp_more_videos";
        }
        return "";
    }

    private static final a h(s sVar, boolean z) {
        a j = t.a(sVar).j(k0.a.b().n());
        if (z) {
            j.k("recommend_info");
            j.k("recommend_group_id");
        }
        return j;
    }

    public final void e(a args, c.a bookData) {
        String str;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(bookData, "bookData");
        args.g("book_id", bookData.b);
        String str2 = bookData.d;
        boolean z = false;
        if (str2 != null && h0.j(str2, 0, 1, null) == ReadingBookType.Listen.getValue()) {
            z = true;
        }
        if (z) {
            str = "audiobook";
        } else {
            str = "novel";
        }
        args.g("book_type", str);
        args.g("position", "video_series_panel_original_book_bar");
        args.g("from_video_position", "video_series_panel_original_book_bar");
    }

    public final void g(boolean z, c.a aVar, s sVar) {
        String str;
        a h = h(sVar, true);
        if (aVar != null) {
            e(h, aVar);
        }
        o oVar = o.a;
        if (z) {
            str = "show_book";
        } else {
            str = "click_book";
        }
        oVar.d(str, h);
    }

    public final a a(om0 om0Var, s sVar, boolean z) {
        a aVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (om0Var == null || (aVar = com.dragon.read.kmp.util.j.e(om0Var)) == null) {
            aVar = new a();
        }
        a g = aVar.g("position", d(sVar));
        String str6 = null;
        if (sVar != null) {
            str = sVar.d;
        } else {
            str = null;
        }
        a g2 = g.g("recommend_info", str);
        if (sVar != null) {
            str2 = sVar.e;
        } else {
            str2 = null;
        }
        a g3 = g2.g("recommend_group_id", str2);
        if (sVar != null) {
            str3 = sVar.f;
        } else {
            str3 = null;
        }
        a g4 = g3.g("related_tag_profile_user_id", str3);
        if (om0Var != null) {
            str4 = om0Var.e;
        } else {
            str4 = null;
        }
        a g5 = g4.g("material_name", str4);
        if (z) {
            if (sVar != null) {
                str5 = sVar.b;
            } else {
                str5 = null;
            }
            a g6 = g5.g("from_feed_src_material_id", str5);
            if (sVar != null) {
                str6 = sVar.c;
            }
            g6.g("from_feed_material_id", str6);
        } else {
            a g7 = g5.g("enter_from", "video_player").g("card_position", d(sVar));
            if (sVar != null) {
                str6 = sVar.b;
            }
            g7.g("virtual_src_material_id", str6);
        }
        return g5;
    }

    public final a c(om0 om0Var, s sVar, int i) {
        a aVar;
        String str;
        String str2;
        if (om0Var == null || (aVar = com.dragon.read.kmp.util.j.e(om0Var)) == null) {
            aVar = new a();
        }
        a g = aVar.g("position", d(sVar));
        String str3 = null;
        if (sVar != null) {
            str = sVar.b;
        } else {
            str = null;
        }
        a g2 = g.g("from_feed_src_material_id", str);
        if (sVar != null) {
            str2 = sVar.c;
        } else {
            str2 = null;
        }
        a g3 = g2.g("from_feed_material_id", str2);
        if (sVar != null) {
            str3 = sVar.f;
        }
        g3.g("related_tag_profile_user_id", str3).g("rank", Integer.valueOf(i + 1));
        return aVar;
    }

    public final void k(boolean z, om0 om0Var, s sVar, int i) {
        String str;
        a j = k0.a.b().n().j(c(om0Var, sVar, i));
        o oVar = o.a;
        if (z) {
            str = "show_video";
        } else {
            str = "click_video";
        }
        oVar.d(str, j);
    }

    public final void i(boolean z, om0 om0Var, s sVar, String str) {
        String str2;
        a k = k0.a.b().n().g("position", d(sVar)).g("click_to", str).j(b(this, om0Var, sVar, false, 4, null)).k("src_material_id");
        o oVar = o.a;
        if (z) {
            str2 = "show_reserve_card";
        } else {
            str2 = "click_reserve_card";
        }
        oVar.d(str2, k);
    }

    public final void f(String str, String str2, String str3, String str4) {
        a g = new a().g("src_material_id", str3).g("tab_name", k0.a.b().l("tab_name")).g("material_id", str4);
        StringBuilder sb = new StringBuilder();
        String str5 = "";
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 != null) {
            str5 = ',' + str2;
        }
        sb.append(str5);
        g.g("tag_name", sb.toString());
        o.a.d("series_video_card_list_show", g);
    }

    public static /* synthetic */ a b(m mVar, om0 om0Var, s sVar, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return mVar.a(om0Var, sVar, z);
    }

    public static /* synthetic */ void j(m mVar, boolean z, om0 om0Var, s sVar, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = null;
        }
        mVar.i(z, om0Var, sVar, str);
    }
}
