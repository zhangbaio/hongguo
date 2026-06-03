package dk4;

import com.bytedance.covode.number.Covode;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(607769);
        a = new a();
    }

    private a() {
    }

    public final void b() {
        o.a.d("click_search_bar", new ym4.a().g("tab_name", "mine").g("search_entrance", "mine_tab").g("search_bar_type", "button"));
    }

    public final void a(String str, String str2) {
        o.a.d("click_search", new ym4.a().g("tab_name", "mine").g("page_name", "search_result").g("input_query", str).g("search_id", str2).g("search_source_id", "clks_mine###").g("search_entrance", "mine_tab"));
    }

    public final void c(String str, boolean z) {
        String str2;
        ym4.a g = new ym4.a().g("tab_name", "mine").g("input_query", str).g("auto_query", str).g("search_source_id", "clks_mine###").g("search_entrance", "general");
        o oVar = o.a;
        if (z) {
            str2 = "show_search_mine_related";
        } else {
            str2 = "click_search_mine_related";
        }
        oVar.d(str2, g);
    }
}
