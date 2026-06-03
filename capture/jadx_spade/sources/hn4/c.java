package hn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(608768);
        a = new c();
    }

    private c() {
    }

    public final ym4.a a(d dVar) {
        String str;
        String str2;
        String str3;
        String str4;
        ym4.a aVar = new ym4.a();
        aVar.g("page_name", "search_result");
        String str5 = null;
        if (dVar != null) {
            str = dVar.n;
        } else {
            str = null;
        }
        aVar.g("search_source_id", str);
        if (dVar != null) {
            str2 = dVar.e;
        } else {
            str2 = null;
        }
        aVar.g("search_id", str2);
        if (dVar != null) {
            str3 = dVar.d;
        } else {
            str3 = null;
        }
        aVar.g("input_query", str3);
        aVar.g("type", "result");
        if (dVar != null) {
            str4 = dVar.b;
        } else {
            str4 = null;
        }
        aVar.g("result_tab", str4);
        if (dVar != null) {
            str5 = dVar.p;
        }
        aVar.g("search_source_book_id", str5);
        return aVar;
    }

    public final void b(boolean z, ym4.a args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (z) {
            o.a.d("show_search_result_actor", args);
        } else {
            o.a.d("click_search_result_actor", args);
        }
    }

    public final void c(boolean z, ym4.a args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (z) {
            o.a.d("show_search_result_cp", args);
        } else {
            o.a.d("click_search_result_cp", args);
        }
    }

    public final void d(boolean z, ym4.a args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (z) {
            o.a.d("show_search_result_role", args);
        } else {
            o.a.d("click_search_result_role", args);
        }
    }
}
