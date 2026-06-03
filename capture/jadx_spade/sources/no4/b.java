package no4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SelectorItemShowType;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.jm0;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.kmp.reading.model.pm0;
import com.bytedance.kmp.reading.model.xm0;
import com.dragon.read.kmp.shortvideo.distribution.infinite.InnerInfinitePanelKt;
import com.dragon.read.kmp.shortvideo.distribution.infinite.d;
import com.dragon.read.kmp.shortvideo.distribution.infinite.g;
import com.dragon.read.kmp.shortvideo.distribution.infinite.h;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.kmp.utils.k0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import ym4.k;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final a d;
    public static final int e;
    public final lo4.a a;
    public final io4.b b;
    public final int c;

    public static final class a {
        static {
            Covode.recordClassIndex(609098);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609097);
        d = new a(null);
        e = 8;
    }

    private final ym4.a d() {
        ym4.a aVar = new ym4.a();
        aVar.g("sub_list_name", h.e(this.b.p));
        return aVar;
    }

    private final Map<String, String> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Map<String, Object> i = k0.a.b().i();
            if (i.containsKey("previous_tab_name")) {
                linkedHashMap.put("previous_tab_name", String.valueOf(i.get("previous_tab_name")));
            }
            if (i.containsKey("enter_tab_type")) {
                linkedHashMap.put("enter_tab_type", String.valueOf(i.get("enter_tab_type")));
            }
        } catch (Exception unused) {
        }
        return linkedHashMap;
    }

    public final void o(d filterItem) {
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        a(filterItem).c();
    }

    public final void t(d filterItem) {
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        a(filterItem).b();
    }

    private final vc4.a a(d dVar) {
        Map<String, String> emptyMap;
        ym4.a aVar = new ym4.a();
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        aVar.h(k0.a.b().i());
        aVar.g("parent_list_name", this.b.f());
        aVar.g("list_name", this.b.c());
        aVar.g("sub_list_name", this.b.d());
        aVar.g("filter_position", "ranking_list_page");
        aVar.g("type", this.b.k);
        Unit unit = Unit.INSTANCE;
        return InnerInfinitePanelKt.v(dVar, null, aVar, 2, null);
    }

    public final void j(String str) {
        Map<String, Object> map;
        Map<String, String> emptyMap;
        o oVar = o.a;
        ym4.a aVar = new ym4.a();
        k b = k0.a.b();
        if (b != null) {
            map = b.i();
        } else {
            map = null;
        }
        aVar.h(map);
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        aVar.g("parent_list_name", this.b.f());
        aVar.g("list_name", this.b.c());
        aVar.g("sub_list_name", this.b.d());
        Unit unit = Unit.INSTANCE;
        oVar.d("enter_ranking_list_page", aVar);
    }

    public final ym4.a e(om0 videoData) {
        Object obj;
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        ym4.a aVar = new ym4.a();
        aVar.g("enter_from", "reserve_ranking_list_page");
        aVar.g("card_position", "reserve_ranking_list_page");
        Map<String, Object> i = k0.a.b().i();
        if (i.containsKey("tab_name")) {
            aVar.g("tab_name", i.get("tab_name"));
        }
        if (i.containsKey("category_name")) {
            aVar.g("category_name", i.get("category_name"));
        }
        if (i.containsKey("category_tab_type")) {
            aVar.g("category_tab_type", i.get("category_tab_type"));
        }
        Object obj2 = i.get("position");
        if (obj2 == null) {
            obj2 = "";
        }
        if (!Intrinsics.areEqual(obj2, "video_feed")) {
            if (i.containsKey("module_name")) {
                obj = i.get("module_name");
            } else {
                obj = "无限流";
            }
            aVar.g("module_name", obj);
        }
        aVar.g("material_name", videoData.e);
        aVar.g("virtual_src_material_id", videoData.p);
        aVar.g("recommend_info", videoData.z);
        aVar.g("recommend_group_id", videoData.A);
        aVar.g("parent_list_name", this.b.f());
        aVar.g("list_name", this.b.c());
        return aVar;
    }

    public final void k(d filterItem) {
        Map<String, String> emptyMap;
        String str;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        ym4.a aVar = new ym4.a();
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        aVar.h(k0.a.b().i());
        Integer num = filterItem.b.g;
        int value = SelectorItemShowType.UsePeriod.getValue();
        if (num != null && num.intValue() == value) {
            String str2 = filterItem.b.a;
            boolean z = false;
            if (str2 != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "月", false, 2, (Object) null);
                if (contains$default) {
                    z = true;
                }
            }
            if (z) {
                str = filterItem.c + filterItem.b.a;
                new vc4.a().m(str).n(filterItem.getType()).l(this.b.e()).k(this.b.f()).i(this.b.c()).h("0").j(aVar).b();
            }
        }
        str = filterItem.b.a;
        new vc4.a().m(str).n(filterItem.getType()).l(this.b.e()).k(this.b.f()).i(this.b.c()).h("0").j(aVar).b();
    }

    public final void l(d filterItem) {
        Map<String, String> emptyMap;
        String str;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        ym4.a aVar = new ym4.a();
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        aVar.h(k0.a.b().i());
        Integer num = filterItem.b.g;
        int value = SelectorItemShowType.UsePeriod.getValue();
        if (num != null && num.intValue() == value) {
            String str2 = filterItem.b.a;
            boolean z = false;
            if (str2 != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "月", false, 2, (Object) null);
                if (contains$default) {
                    z = true;
                }
            }
            if (z) {
                str = filterItem.c + filterItem.b.a;
                new vc4.a().m(str).n(filterItem.getType()).l(this.b.e()).k(this.b.f()).i(this.b.c()).h("0").j(aVar).c();
            }
        }
        str = filterItem.b.a;
        new vc4.a().m(str).n(filterItem.getType()).l(this.b.e()).k(this.b.f()).i(this.b.c()).h("0").j(aVar).c();
    }

    public final void h(String clickTo) {
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
        int i = this.b.b.g;
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
        d g3 = h.g(this.b.p);
        if (g3 == null || (gVar2 = g3.e) == null || (g2 = h.g(gVar2)) == null || (p90Var = g2.b) == null || (str = p90Var.a) == null) {
            str = this.b.b.i;
        }
        d g4 = h.g(this.b.p);
        if (g4 == null || (gVar = g4.e) == null || (g = h.g(gVar)) == null || (str2 = g.getType()) == null) {
            str2 = this.b.b.h;
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
        aVar.g("filter_tag_name", str).g("filter_type", str2).g("list_name", this.b.c()).g("parent_list_name", this.b.f()).g("clicked_content", clickTo).g("sub_list_name", this.b.d());
        o.a.d("click_ranking_list_page", aVar);
    }

    public final void s(io4.g model, int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        b(model, i).r();
    }

    public final void p(io4.g model, int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        b(model, i).a(new ym4.a().g("playlist_position", "ranking_list_page")).p();
    }

    public final void g(io4.g model, int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        b(model, i).a(new ym4.a().g("click_content", "ranking_card").g("playlist_position", "ranking_list_page")).k();
    }

    public final void i(io4.g model, int i) {
        String str;
        Intrinsics.checkNotNullParameter(model, "model");
        ld4.b b = b(model, i);
        k b2 = k0.a.b();
        b2.d("push_book_video_enter_position", "store");
        om0 videoData = model.getVideoData();
        if (videoData == null || (str = videoData.z) == null) {
            str = "";
        }
        b2.d("recommend_info", str);
        b.b(b2);
        b.m();
    }

    public final void m(io4.g model, String clickTo) {
        String str;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(clickTo, "clickTo");
        om0 videoData = model.getVideoData();
        if (videoData == null) {
            return;
        }
        ym4.a e2 = e(videoData);
        if (StringUtilsKt.a(clickTo)) {
            e2.g("click_to", clickTo);
        }
        o oVar = o.a;
        if (StringUtilsKt.a(clickTo)) {
            str = "click_reserve_card";
        } else {
            str = "show_reserve_card";
        }
        oVar.d(str, e2);
    }

    public final ld4.b b(io4.g model, int i) {
        Integer num;
        Map<String, String> emptyMap;
        Object obj;
        xm0 xm0Var;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        jm0 jm0Var;
        List list;
        Object firstOrNull;
        Long l;
        String l2;
        jm0 jm0Var2;
        Long l3;
        jm0 jm0Var3;
        Long l4;
        g gVar;
        d g;
        g gVar2;
        d g2;
        p90 p90Var;
        Intrinsics.checkNotNullParameter(model, "model");
        int i3 = this.b.b.g;
        ym4.a aVar = new ym4.a();
        Integer num2 = null;
        if (i3 != 0) {
            num = Integer.valueOf(i3);
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
        aVar.j(d());
        Map<String, Object> i4 = k0.a.b().i();
        if (i4.containsKey("parent_filter_tag_name")) {
            aVar.g("parent_filter_tag_name", i4.get("parent_filter_tag_name"));
        }
        if (i4.containsKey("previous_tab_name")) {
            aVar.g("previous_tab_name", i4.get("previous_tab_name"));
        }
        if (i4.containsKey("enter_tab_type")) {
            aVar.g("enter_tab_type", i4.get("enter_tab_type"));
        }
        if (i4.containsKey("page_name")) {
            aVar.g("page_name", i4.get("page_name"));
        }
        if (i4.containsKey("position")) {
            aVar.g("position", i4.get("position"));
        }
        if (i4.containsKey("tab_name")) {
            aVar.g("tab_name", i4.get("tab_name"));
        }
        if (i4.containsKey("ranking_list_page_entrance")) {
            aVar.g("ranking_list_page_entrance", i4.get("ranking_list_page_entrance"));
        }
        if (i4.containsKey("module_name")) {
            obj = i4.get("module_name");
        } else {
            obj = "无限流";
        }
        aVar.g("module_name", obj);
        if (i4.containsKey("sub_module_name")) {
            aVar.g("sub_module_name", i4.get("sub_module_name"));
        }
        if (i4.containsKey("interact_topic_name")) {
            aVar.g("interact_topic_name", i4.get("interact_topic_name"));
        }
        if (i4.containsKey("interact_topic_page_entrance")) {
            aVar.g("interact_topic_page_entrance", i4.get("interact_topic_page_entrance"));
        }
        if (i4.containsKey("category_name")) {
            aVar.g("category_name", i4.get("category_name"));
        }
        if (i4.containsKey("category_tab_type")) {
            aVar.g("category_tab_type", i4.get("category_tab_type"));
        }
        Object obj2 = i4.get("from_material_id");
        if (obj2 != null) {
            aVar.g("from_material_id", obj2);
        }
        Object obj3 = i4.get("from_src_material_id");
        if (obj3 != null) {
            aVar.g("from_src_material_id", obj3);
        }
        Object obj4 = i4.get("from_player_position");
        if (obj4 != null) {
            aVar.g("from_player_position", obj4);
        }
        Object obj5 = i4.get("is_from_material_end_recommend");
        if (obj5 != null) {
            aVar.g("is_from_material_end_recommend", obj5);
        }
        Object obj6 = i4.get("search_id");
        if (obj6 != null) {
            aVar.g("search_id", obj6);
        }
        Object obj7 = i4.get("input_query");
        if (obj7 != null) {
            aVar.g("input_query", obj7);
        }
        Object obj8 = i4.get("is_quick_respond_card");
        if (obj8 != null) {
            aVar.g("is_quick_respond_card", obj8);
        }
        Object obj9 = i4.get("responded_src_material_id");
        if (obj9 != null) {
            aVar.g("responded_src_material_id", obj9);
        }
        om0 videoData = model.getVideoData();
        if (videoData != null) {
            xm0Var = videoData.p0;
        } else {
            xm0Var = null;
        }
        if (xm0Var != null) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        d g3 = h.g(this.b.p);
        if (g3 == null || (gVar2 = g3.e) == null || (g2 = h.g(gVar2)) == null || (p90Var = g2.b) == null || (str = p90Var.a) == null) {
            str = this.b.b.i;
        }
        d g4 = h.g(this.b.p);
        if (g4 == null || (gVar = g4.e) == null || (g = h.g(gVar)) == null || (str2 = g.getType()) == null) {
            str2 = this.b.b.h;
        }
        if (model.b()) {
            om0 videoData2 = model.getVideoData();
            String str6 = "";
            if (videoData2 == null || (jm0Var3 = videoData2.R0) == null || (l4 = jm0Var3.a) == null || (str4 = l4.toString()) == null) {
                str4 = "";
            }
            aVar.g("related_playlist_id", str4);
            om0 videoData3 = model.getVideoData();
            if (videoData3 == null || (jm0Var2 = videoData3.R0) == null || (l3 = jm0Var2.a) == null || (str5 = l3.toString()) == null) {
                str5 = "";
            }
            aVar.g("playlist_id", str5);
            om0 videoData4 = model.getVideoData();
            if (videoData4 != null && (jm0Var = videoData4.R0) != null && (list = jm0Var.m) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                pm0 pm0Var = (pm0) firstOrNull;
                if (pm0Var != null && (l = pm0Var.a) != null && (l2 = l.toString()) != null) {
                    str6 = l2;
                }
            }
            aVar.g("src_material_id", str6);
        }
        ld4.b A = new ld4.b().I(model.getVideoData()).u("vertical").A(i2);
        om0 videoData5 = model.getVideoData();
        if (videoData5 != null) {
            str3 = videoData5.A;
        } else {
            str3 = null;
        }
        ld4.b G = A.G(str3);
        if (i3 != 0) {
            num2 = Integer.valueOf(i3);
        }
        return G.t(num2).D(1).F(i + 1).v("small_card").a(aVar).y(str).B(this.b.c()).z(str2).H(model.getVideoData()).E(this.b.f()).x(c());
    }

    public b(lo4.a aVar, io4.b distributeModel, int i) {
        Intrinsics.checkNotNullParameter(distributeModel, "distributeModel");
        this.a = aVar;
        this.b = distributeModel;
        this.c = i;
    }

    private final void f(boolean z, String str, String str2) {
        Map<String, String> emptyMap;
        String str3;
        ym4.a aVar = new ym4.a();
        aVar.h(k0.a.b().i());
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        aVar.g("starring_name", str);
        aVar.g("starring_position", str2);
        if (z) {
            str3 = "show_starring";
        } else {
            str3 = "click_starring";
        }
        o.a.d(str3, aVar);
    }

    public final void u(boolean z, io4.a data, String profilePosition) {
        String str;
        String str2;
        String str3;
        ok0 ok0Var;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(profilePosition, "profilePosition");
        if (z) {
            if (data.a()) {
                return;
            } else {
                data.d(true);
            }
        }
        cj0 cj0Var = data.a.a;
        String str4 = null;
        if (cj0Var != null && (ok0Var = cj0Var.b) != null) {
            str = ok0Var.b;
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (cj0Var != null) {
            str4 = cj0Var.a;
        }
        if (str4 == null) {
            str3 = "";
        } else {
            str3 = str4;
        }
        f(z, str2, profilePosition);
        r(this, z, str2, str3, profilePosition, null, 16, null);
    }

    public static /* synthetic */ void n(b bVar, io4.g gVar, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        bVar.m(gVar, str);
    }

    private final void q(boolean z, String str, String str2, String str3, String str4) {
        Map<String, String> emptyMap;
        String str5;
        ym4.a aVar = new ym4.a();
        aVar.h(k0.a.b().i());
        lo4.a aVar2 = this.a;
        if (aVar2 == null || (emptyMap = aVar2.h()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        aVar.h(emptyMap);
        aVar.g("profile_name", str);
        aVar.g("profile_user_id", str2);
        aVar.g("profile_position", str3);
        if (str4 != null) {
            aVar.g("is_certified", str4);
        }
        if (z) {
            str5 = "show_profile";
        } else {
            str5 = "click_profile";
        }
        o.a.d(str5, aVar);
    }

    static /* synthetic */ void r(b bVar, boolean z, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 16) != 0) {
            str4 = null;
        }
        bVar.q(z, str, str2, str3, str4);
    }
}
