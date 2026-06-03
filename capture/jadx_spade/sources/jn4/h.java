package jn4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.bf0;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.e50;
import com.bytedance.kmp.reading.model.x7;
import com.dragon.read.component.biz.impl.ui.page.middle.rank.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import ym4.k;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public static final h a;

    static {
        Covode.recordClassIndex(608785);
        a = new h();
    }

    private h() {
    }

    public final String a(String str) {
        boolean z;
        List split$default;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
        return (String) CollectionsKt___CollectionsKt.getOrNull(split$default, 1);
    }

    public final void l(n rankTabModel) {
        Intrinsics.checkNotNullParameter(rankTabModel, "rankTabModel");
        k a2 = rankTabModel.a();
        e k = new e().c(tk3.a.d(a2)).b(tk3.a.a(a2)).k(rankTabModel.k);
        String str = rankTabModel.e;
        if (str == null) {
            str = "";
        }
        k.d(str).e(rankTabModel.b + 1).g(rankTabModel.a.H).j("").f(rankTabModel.a.l0).a();
    }

    public final void f(String str, String str2) {
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        aVar.g("tab_name", str);
        aVar.g("type", str2);
        o.a.d("delete_search_history_click", aVar);
    }

    public final void g(String str, String str2) {
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        aVar.g("tab_name", str);
        aVar.g("type", str2);
        o.a.d("delete_search_history_success", aVar);
    }

    public final String b(d1 bookInfo, x7 cellViewData) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(bookInfo, "bookInfo");
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        ArrayList arrayList = new ArrayList();
        List list = bookInfo.k1;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String str = ((e50) it2.next()).a;
                if (str != null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    arrayList.add(str);
                }
            }
        }
        List list2 = cellViewData.P0;
        if (list2 != null) {
            Iterator it4 = list2.iterator();
            while (it4.hasNext()) {
                String str2 = ((bf0) it4.next()).a;
                if (str2 != null && str2.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = bookInfo.c;
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(':');
        sb.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, "#", null, null, 0, null, null, 62, null));
        return sb.toString();
    }

    public final void d(n rankTabModel, String clickTo, String str, String str2) {
        Intrinsics.checkNotNullParameter(rankTabModel, "rankTabModel");
        Intrinsics.checkNotNullParameter(clickTo, "clickTo");
        k a2 = rankTabModel.a();
        c l = new c().e(tk3.a.d(a2)).b(tk3.a.a(a2)).c(clickTo).l(rankTabModel.k);
        String str3 = rankTabModel.e;
        if (str3 == null) {
            str3 = "";
        }
        l.f(str3).g(rankTabModel.b + 1).i(rankTabModel.a.H).h(str2).d(str).a();
    }

    public final void j(String str, String str2, String str3, boolean z, Map<String, ? extends Object> map) {
        ym4.a aVar = new ym4.a();
        if (map != null) {
            aVar.h(map);
        }
        aVar.g("conversation_id", str);
        aVar.g("conversation_position", str2);
        aVar.g("conversation_type", str3);
        if (z) {
            aVar.g("if_push_book_ai", 1);
        }
        o.a.d("impr_im_chat_entrance", aVar);
    }

    public final void c(String str, String str2, String str3, String str4, String str5) {
        boolean z;
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        aVar.g("tab_name", str3);
        aVar.g("category_name", str4);
        aVar.g("input_query", str);
        boolean z2 = false;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("tag", str2);
        }
        if (str5 == null || str5.length() == 0) {
            z2 = true;
        }
        if (!z2) {
            aVar.g("label", str5);
        }
        aVar.g("search_source_id", "his###");
        o.a.d("click_search_history", aVar);
    }

    public final void k(String str, String str2, String str3, String str4, String str5) {
        boolean z;
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        aVar.g("tab_name", str3);
        aVar.g("category_name", str4);
        aVar.g("input_query", str);
        boolean z2 = false;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("tag", str2);
        }
        if (str5 == null || str5.length() == 0) {
            z2 = true;
        }
        if (!z2) {
            aVar.g("label", str5);
        }
        aVar.g("search_source_id", "his###");
        o.a.d("show_search_history", aVar);
    }

    public static /* synthetic */ void e(h hVar, n nVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        hVar.d(nVar, str, str2, str3);
    }

    public final void h(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        boolean z;
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        aVar.g("tab_name", str);
        aVar.g("category_name", str2);
        aVar.g("input_query", str3);
        aVar.g("rank", str4);
        aVar.g("search_source_id", str5);
        aVar.g("search_source_book_id", str6);
        aVar.g("gid", str7);
        aVar.g("recommend_info", str8);
        if (str9 != null && str9.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("label", str9);
        }
        aVar.g("page_name", "search_result");
        o.a.d("click_search_hot_word", aVar);
    }

    public final void i(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        boolean z;
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        aVar.g("tab_name", str);
        aVar.g("category_name", str2);
        aVar.g("input_query", str3);
        aVar.g("rank", str4);
        aVar.g("search_source_id", str5);
        aVar.g("search_source_book_id", str6);
        aVar.g("gid", str7);
        aVar.g("recommend_info", str8);
        if (str9 != null && str9.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("label", str9);
        }
        aVar.g("page_name", "search_result");
        o.a.d("show_search_hot_word", aVar);
    }
}
