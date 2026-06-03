package com.dragon.read.kmp.reader.utils;

import com.bytedance.covode.number.Covode;
import dm4.s;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    public static final q a;
    private static final HashSet<String> b;
    public static final int c;

    private q() {
    }

    static {
        Covode.recordClassIndex(608663);
        a = new q();
        b = new HashSet<>();
        c = 8;
    }

    public final void a(String bookId, String clickedContent, String result) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(clickedContent, "clickedContent");
        Intrinsics.checkNotNullParameter(result, "result");
        ym4.a aVar = new ym4.a();
        aVar.g("book_id", bookId).g("clicked_content", clickedContent).g("result", result);
        s.b.a("click_reader", aVar);
    }
}
