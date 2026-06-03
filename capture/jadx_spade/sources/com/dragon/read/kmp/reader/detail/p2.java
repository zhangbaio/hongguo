package com.dragon.read.kmp.reader.detail;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p2 {
    public static final int c;
    private long a;
    private boolean b;

    static {
        Covode.recordClassIndex(608371);
        c = 8;
    }

    public final void f() {
        ym4.a aVar = new ym4.a();
        aVar.g("page_name", "page_recommend");
        ym4.o.a.d("click_change", aVar);
    }

    public final void h(String str) {
        if (str == null) {
            return;
        }
        ym4.a aVar = new ym4.a();
        aVar.g("book_id", str);
        aVar.g("tag_position", "书籍详情页");
        ym4.o.a.d("click_dianfeng_tag", aVar);
    }

    public final void o(String str) {
        if (str == null) {
            return;
        }
        ym4.a aVar = new ym4.a();
        aVar.g("book_id", str);
        aVar.g("tag_position", "书籍详情页");
        ym4.o.a.d("show_dianfeng_tag", aVar);
    }

    public final void b(String str, ym4.k kVar) {
        ym4.a aVar;
        if (str == null) {
            return;
        }
        if (kVar == null || (aVar = kVar.n()) == null) {
            aVar = new ym4.a();
        }
        aVar.g("book_id", str);
        aVar.g("entrance", "page");
        ym4.o.a.d("add_bookshelf", aVar);
    }

    public final void k(String str, ym4.k kVar) {
        ym4.a aVar;
        if (this.b || str == null) {
            return;
        }
        this.a = wf4.e.a.a();
        this.b = true;
        if (kVar == null || (aVar = kVar.n()) == null) {
            aVar = new ym4.a();
        }
        aVar.g("book_id", str);
        aVar.g("detail_type", "page");
        ym4.o.a.d("go_detail", aVar);
    }

    public final void c(String str, ym4.k kVar) {
        ym4.a aVar;
        if (str == null) {
            return;
        }
        if (kVar == null || (aVar = kVar.n()) == null) {
            aVar = new ym4.a();
        }
        aVar.g("book_id", str);
        aVar.g("conversation_id", com.dragon.read.kmp.reader.detail.platform.a.a.a());
        aVar.g("conversation_position", "book_detail_page");
        aVar.g("conversation_type", "single_chat");
        aVar.g("if_push_book_ai", "1");
        aVar.g("ai_conversation_type", "ai_search_book");
        ym4.o.a.d("impr_im_chat_entrance", aVar);
    }

    public final void i(String str, ym4.k kVar) {
        ym4.a aVar;
        if (str == null) {
            return;
        }
        if (kVar == null || (aVar = kVar.n()) == null) {
            aVar = new ym4.a();
        }
        aVar.g("book_id", str);
        aVar.g("entrance", "book_detail_fold");
        aVar.g("content_type", "novel");
        aVar.g("content_id", str);
        aVar.g("content_id_key", "book_id");
        aVar.g("share_timestamp", Long.valueOf(wf4.e.a.a()));
        aVar.g("type", "book_detail");
        aVar.g("position", "book_detail");
    }

    public final void m(String str, ym4.k kVar) {
        long coerceAtLeast;
        ym4.a aVar;
        if (!this.b) {
            return;
        }
        this.b = false;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(wf4.e.a.a() - this.a, 0L);
        this.a = 0L;
        if (str == null) {
            return;
        }
        if (kVar == null || (aVar = kVar.n()) == null) {
            aVar = new ym4.a();
        }
        aVar.g("book_id", str);
        aVar.g("detail_type", "page");
        aVar.g("stay_time", Long.valueOf(coerceAtLeast));
        ym4.o.a.d("stay_page", aVar);
    }

    public final void d(String str, String clickedContent, String str2) {
        boolean z;
        Intrinsics.checkNotNullParameter(clickedContent, "clickedContent");
        if (str == null) {
            return;
        }
        if (clickedContent.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        ym4.a aVar = new ym4.a();
        aVar.g("book_id", str);
        aVar.g("clicked_content", clickedContent);
        if (str2 != null) {
            aVar.g("click_to", str2);
        }
        ym4.o.a.d("click_novel_page", aVar);
    }

    public final void l(String str, String str2, String forumPosition) {
        Intrinsics.checkNotNullParameter(forumPosition, "forumPosition");
        ym4.a aVar = new ym4.a();
        aVar.j(com.dragon.read.kmp.utils.k0.a.b().n());
        aVar.g("book_id", str);
        aVar.g("forum_id", str2);
        aVar.g("consume_forum_id", str2);
        aVar.g("forum_position", forumPosition);
        ym4.o.a.d("impr_forum_entrance", aVar);
    }

    public static /* synthetic */ void e(p2 p2Var, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        p2Var.d(str, str2, str3);
    }

    public final ym4.k g(String str, String str2, String pageName, int i, String str3, ym4.k kVar) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (str == null) {
            return kVar;
        }
        if (str2 == null) {
            return kVar;
        }
        if (kVar == null) {
            kVar = com.dragon.read.kmp.utils.k0.a.b();
        }
        ym4.k d = kVar.d("book_id", str).d("from_id", str2).d("page_name", pageName);
        if (str3 == null) {
            str3 = "";
        }
        d.d("recommend_info", str3).c("rank", Integer.valueOf(i));
        ym4.o.a.d("click_book", kVar.n());
        return kVar;
    }

    public final void n(String str, String str2, String pageName, int i, String str3, ym4.k kVar) {
        ym4.a aVar;
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (str == null || str2 == null) {
            return;
        }
        if (kVar == null || (aVar = kVar.n()) == null) {
            aVar = new ym4.a();
        }
        aVar.g("book_id", str).g("from_id", str2).g("page_name", pageName).g("recommend_info", str3).g("rank", Integer.valueOf(i));
        ym4.o.a.d("show_book", aVar);
    }

    public final ym4.k j(String str, String str2, String pageName, int i, String str3, String str4, String str5, String str6, String str7, String str8, String position, ym4.k kVar) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(position, "position");
        if (str == null) {
            return kVar;
        }
        if (str2 == null) {
            return kVar;
        }
        ym4.k a = a(str, str2, pageName, i, str3, str4, str5, str6, str7, str8, position, kVar);
        ym4.o.a.d("click_video", a.n());
        return a;
    }

    public final void p(String str, String str2, String pageName, int i, String str3, String str4, String str5, String str6, String str7, String str8, String position, ym4.k kVar) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(position, "position");
        if (str == null || str2 == null) {
            return;
        }
        ym4.o.a.d("show_video", a(str, str2, pageName, i, str3, str4, str5, str6, str7, str8, position, kVar).n());
    }

    public final ym4.k a(String str, String str2, String pageName, int i, String str3, String str4, String str5, String str6, String str7, String str8, String position, ym4.k kVar) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(position, "position");
        if (kVar == null) {
            kVar = com.dragon.read.kmp.utils.k0.a.b();
        }
        if (str == null) {
            str = "";
        }
        ym4.k d = kVar.d("book_id", str);
        if (str2 == null) {
            str2 = "";
        }
        ym4.k d2 = d.d("from_id", str2).d("page_name", pageName);
        if (str3 == null) {
            str3 = "";
        }
        ym4.k c2 = d2.d("recommend_info", str3).c("rank", Integer.valueOf(i));
        if (str4 == null) {
            str4 = "";
        }
        ym4.k d3 = c2.d("src_material_id", str4);
        if (str5 == null) {
            str5 = "";
        }
        ym4.k d4 = d3.d("material_id", str5);
        if (str6 == null) {
            str6 = "";
        }
        ym4.k d5 = d4.d("material_type", str6);
        if (str7 == null) {
            str7 = "";
        }
        ym4.k d6 = d5.d("related_book_id", str7);
        if (str8 == null) {
            str8 = "";
        }
        d6.d("content_type", str8).d("position", position);
        return kVar;
    }
}
