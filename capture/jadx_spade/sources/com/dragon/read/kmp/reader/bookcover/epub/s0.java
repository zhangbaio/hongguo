package com.dragon.read.kmp.reader.bookcover.epub;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s0 {
    public static final s0 a;

    static {
        Covode.recordClassIndex(608276);
        a = new s0();
    }

    private s0() {
    }

    public final void c(String str, String clickedContent, String str2) {
        Intrinsics.checkNotNullParameter(clickedContent, "clickedContent");
        ym4.a h = new ym4.a().h(ym4.n.a.b());
        if (str == null) {
            str = "";
        }
        ym4.a g = h.g("book_id", str).g("clicked_content", clickedContent);
        if (str2 != null) {
            g.g("cover_page_position", str2);
        }
        dm4.s.b.a("click_reader_cover", g);
    }

    public final void a(String str, String hotLineId, String quoteItemId, String moduleName, String pageName, int i) {
        Intrinsics.checkNotNullParameter(hotLineId, "hotLineId");
        Intrinsics.checkNotNullParameter(quoteItemId, "quoteItemId");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        ym4.a h = new ym4.a().h(ym4.n.a.b());
        if (str == null) {
            str = "";
        }
        dm4.s.b.a("click_quote_bookcard", h.g("book_id", str).g("hot_line_id", hotLineId).g("quote_item_id", quoteItemId).g("module_name", moduleName).g("page_name", pageName).g("rank", Integer.valueOf(i)));
    }

    public final void d(String str, String hotLineId, String quoteItemId, String moduleName, String pageName, int i) {
        Intrinsics.checkNotNullParameter(hotLineId, "hotLineId");
        Intrinsics.checkNotNullParameter(quoteItemId, "quoteItemId");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        ym4.a h = new ym4.a().h(ym4.n.a.b());
        if (str == null) {
            str = "";
        }
        dm4.s.b.a("show_quote_bookcard", h.g("book_id", str).g("hot_line_id", hotLineId).g("quote_item_id", quoteItemId).g("module_name", moduleName).g("page_name", pageName).g("rank", Integer.valueOf(i)));
    }

    public static /* synthetic */ void b(s0 s0Var, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str4 = "";
        }
        String str6 = str4;
        if ((i2 & 16) != 0) {
            str5 = "book_cover";
        }
        s0Var.a(str, str2, str3, str6, str5, i);
    }

    public static /* synthetic */ void e(s0 s0Var, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str4 = "";
        }
        String str6 = str4;
        if ((i2 & 16) != 0) {
            str5 = "book_cover";
        }
        s0Var.d(str, str2, str3, str6, str5, i);
    }
}
