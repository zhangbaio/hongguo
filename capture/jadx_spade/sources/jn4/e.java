package jn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final a s;
    public static final int t;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private long o;
    private String p;
    private String q;
    private ym4.a r;

    public static final class a {
        static {
            Covode.recordClassIndex(608782);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608781);
        s = new a(null);
        t = 8;
    }

    public final void a() {
        boolean z;
        boolean z2;
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        aVar.g("tab_name", this.a);
        aVar.g("module_name", this.e);
        aVar.g("type", this.d);
        aVar.g("module_rank", String.valueOf(this.f));
        aVar.g("category_name", this.b);
        aVar.g("page_name", "search_result");
        aVar.g("input_query", this.i);
        String str = this.h;
        boolean z3 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("search_attached_info", this.h);
        }
        aVar.g("search_id", this.j);
        aVar.g("search_source_book_id", this.k);
        aVar.g("result_tab", this.g);
        aVar.g("recommend_info", this.l);
        aVar.g("sub_module_name", this.n);
        aVar.g("search_entrance", this.p);
        aVar.g("page_name", this.c);
        String str2 = this.m;
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            aVar.g("search_position", this.m);
        }
        long j = this.o;
        if (j != 0) {
            aVar.g("virtual_src_material_id", Long.valueOf(j));
        }
        String str3 = this.q;
        if (str3 == null || str3.length() == 0) {
            z3 = true;
        }
        if (!z3) {
            aVar.g("recommend_group_id", this.q);
        }
        ym4.a aVar2 = this.r;
        if (aVar2 != null) {
            aVar.j(aVar2);
        }
        o.a.d("show_module", aVar);
    }

    public final e b(String str) {
        this.b = str;
        return this;
    }

    public final e c(String str) {
        this.a = str;
        return this;
    }

    public final e d(String str) {
        this.e = str;
        return this;
    }

    public final e e(int i) {
        this.f = i;
        return this;
    }

    public final e f(String str) {
        this.l = str;
        return this;
    }

    public final e g(String str) {
        this.h = str;
        return this;
    }

    public final e h(String str) {
        this.p = str;
        return this;
    }

    public final e i(String str) {
        this.m = str;
        return this;
    }

    public final e j(String str) {
        this.k = str;
        return this;
    }

    public final e k(String str) {
        this.d = str;
        return this;
    }
}
