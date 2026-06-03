package no4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.p90;
import com.dragon.read.kmp.shortvideo.distribution.infinite.d;
import com.dragon.read.kmp.shortvideo.distribution.infinite.g;
import com.dragon.read.kmp.shortvideo.distribution.infinite.h;
import com.dragon.read.kmp.utils.k0;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int c;
    public final lo4.a a;
    private final Set<String> b = new LinkedHashSet();

    static {
        Covode.recordClassIndex(609096);
        c = 8;
    }

    public a(lo4.a aVar) {
        this.a = aVar;
    }

    public final void a(boolean z, String str) {
        String str2;
        ym4.a aVar = new ym4.a();
        aVar.g("activity_entrance", "ranking_list_page");
        aVar.g(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, str);
        if (z) {
            aVar.g("enter_method", "click");
        }
        aVar.g("tab_name", k0.a.b().l("tab_name"));
        if (z) {
            str2 = "major_activity_entrance_enter";
        } else {
            str2 = "major_activity_entrance_show";
        }
        o.a.d(str2, aVar);
    }

    public final void f(String str, String str2) {
        Map<String, String> emptyMap;
        o oVar = o.a;
        ym4.a aVar = new ym4.a();
        aVar.h(k0.a.b().i());
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        aVar.g("interact_topic_name", str);
        if (str2 == null) {
            str2 = "video_cover";
        }
        aVar.g("interact_topic_page_entrance", str2);
        Unit unit = Unit.INSTANCE;
        oVar.d("enter_interact_topic_page", aVar);
    }

    public final void g(String title, String clickedContent) {
        boolean z;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(clickedContent, "clickedContent");
        ym4.a aVar = new ym4.a();
        aVar.g("popup_type", title);
        aVar.g("position", "store");
        if (clickedContent.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            aVar.g("clicked_content", clickedContent);
            o.a.d("popup_click", aVar);
        } else {
            o.a.d("popup_show", aVar);
        }
    }

    public final void d(io4.b bVar, String clickTo) {
        Integer num;
        Map<String, String> emptyMap;
        String str;
        String str2;
        Object obj;
        g gVar;
        d g;
        g gVar2;
        d g2;
        p90 p90Var;
        Intrinsics.checkNotNullParameter(clickTo, "clickTo");
        if (bVar == null) {
            return;
        }
        int i = bVar.b.g;
        ym4.a aVar = new ym4.a();
        if (i != 0) {
            num = Integer.valueOf(i);
        } else {
            num = null;
        }
        aVar.g("category_tab_type", num);
        aVar.g("is_landing_page", 1);
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        d g3 = h.g(bVar.p);
        if (g3 == null || (gVar2 = g3.e) == null || (g2 = h.g(gVar2)) == null || (p90Var = g2.b) == null || (str = p90Var.a) == null) {
            str = bVar.b.i;
        }
        d g4 = h.g(bVar.p);
        if (g4 == null || (gVar = g4.e) == null || (g = h.g(gVar)) == null || (str2 = g.getType()) == null) {
            str2 = bVar.b.h;
        }
        Map<String, Object> i2 = k0.a.b().i();
        if (i2.containsKey("parent_filter_tag_name")) {
            aVar.g("parent_filter_tag_name", i2.get("parent_filter_tag_name"));
        }
        if (i2.containsKey("previous_tab_name")) {
            aVar.g("previous_tab_name", i2.get("previous_tab_name"));
        }
        if (i2.containsKey("enter_tab_type")) {
            aVar.g("enter_tab_type", i2.get("enter_tab_type"));
        }
        if (i2.containsKey("page_name")) {
            aVar.g("page_name", i2.get("page_name"));
        }
        if (i2.containsKey("position")) {
            aVar.g("position", i2.get("position"));
        }
        if (i2.containsKey("tab_name")) {
            aVar.g("tab_name", i2.get("tab_name"));
        }
        if (i2.containsKey("ranking_list_page_entrance")) {
            aVar.g("ranking_list_page_entrance", i2.get("ranking_list_page_entrance"));
        }
        if (i2.containsKey("module_name")) {
            obj = i2.get("module_name");
        } else {
            obj = "无限流";
        }
        aVar.g("module_name", obj);
        if (i2.containsKey("sub_module_name")) {
            aVar.g("sub_module_name", i2.get("sub_module_name"));
        }
        if (i2.containsKey("category_name")) {
            aVar.g("category_name", i2.get("category_name"));
        }
        if (i2.containsKey("category_tab_type")) {
            aVar.g("category_tab_type", i2.get("category_tab_type"));
        }
        aVar.g("filter_tag_name", str).g("filter_type", str2).g("list_name", bVar.c()).g("parent_list_name", bVar.f()).g("clicked_content", clickTo).g("sub_list_name", bVar.d());
        o.a.d("click_ranking_list_page", aVar);
    }

    public final void e(String str, String str2, String str3) {
        Map<String, String> emptyMap;
        o oVar = o.a;
        ym4.a aVar = new ym4.a();
        aVar.h(k0.a.b().i());
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        if (str != null) {
            aVar.g("parent_list_name", str);
        }
        if (str3 != null) {
            aVar.g("list_name", str3);
        }
        if (str2 != null) {
            aVar.g("sub_list_name", str2);
        }
        Unit unit = Unit.INSTANCE;
        oVar.d("enter_ranking_list_page", aVar);
    }

    public final void b(String str, String clickContent, String str2, String str3) {
        boolean z;
        String str4;
        Intrinsics.checkNotNullParameter(clickContent, "clickContent");
        ym4.a g = new ym4.a().h(k0.a.b().i()).g("enter_from", "ranking_list_page").g("list_name", str);
        if (clickContent.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            g.g("click_content", clickContent);
            g.g("filter_tag_name", str2);
            g.g("filter_tag_type", str3);
            str4 = "click_category_filter_half_window";
        } else {
            str4 = "enter_category_filter_half_window";
        }
        o.a.d(str4, g);
    }

    public final void i(boolean z, String tagName, String filterType, String str) {
        Map<String, String> emptyMap;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        if (z) {
            if (this.b.contains(tagName)) {
                return;
            } else {
                this.b.add(tagName);
            }
        }
        ym4.a aVar = new ym4.a();
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        aVar.h(k0.a.b().i());
        if (str == null) {
            str2 = tagName;
        } else {
            str2 = str;
        }
        aVar.g("tag_name", str2);
        aVar.g("type", filterType);
        if (str == null) {
            str = tagName;
        }
        aVar.g("list_name", str);
        aVar.g("is_outside_panel", "1");
        aVar.g("filter_position", "ranking_list_page");
        if (aVar.c("parent_filter_tag_name")) {
            aVar.k("parent_filter_tag_name");
        }
        aVar.g("parent_list_name", tagName);
        if (z) {
            str3 = "filter_show";
        } else {
            str3 = "filter_select";
        }
        o.a.d(str3, aVar);
    }

    public static /* synthetic */ void h(a aVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        aVar.g(str, str2);
    }

    public static /* synthetic */ void j(a aVar, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        aVar.i(z, str, str2, str3);
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        aVar.b(str, str2, str3, str4);
    }
}
