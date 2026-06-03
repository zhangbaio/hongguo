package jn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final a u;
    public static final int v;
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
    private String o;
    private String p;
    private String q;
    private ym4.a r;
    private String s;
    private long t;

    public static final class a {
        static {
            Covode.recordClassIndex(608779);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608778);
        u = new a(null);
        v = 8;
    }

    public final void a() {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        boolean z5;
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        aVar.g("tab_name", this.a);
        aVar.g("module_name", this.d);
        aVar.g("type", this.c);
        aVar.g("module_rank", String.valueOf(this.f));
        aVar.g("category_name", this.b);
        aVar.g("page_name", "search_result");
        aVar.g("input_query", this.i);
        aVar.g("search_source_book_id", this.k);
        String str2 = this.h;
        boolean z6 = false;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("search_attached_info", this.h);
        }
        aVar.g("search_id", this.j);
        aVar.g("result_tab", this.g);
        aVar.g("click_to", this.l);
        aVar.g("search_entrance", this.p);
        aVar.g("sub_module_name", this.s);
        String str3 = this.e;
        if (str3 != null && str3.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            aVar.g("list_name", this.e);
        }
        String str4 = this.m;
        if (str4 != null && str4.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            str = "0";
        } else {
            str = this.m;
        }
        aVar.g("gid", str);
        String str5 = this.n;
        if (str5 != null && str5.length() != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4) {
            aVar.g("recommend_info", this.n);
        }
        String str6 = this.o;
        if (str6 != null && str6.length() != 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!z5) {
            aVar.g("search_position", this.o);
        }
        String str7 = this.q;
        if (str7 == null || str7.length() == 0) {
            z6 = true;
        }
        if (!z6) {
            aVar.g("recommend_group_id", this.q);
        }
        long j = this.t;
        if (j != 0) {
            aVar.g("virtual_src_material_id", Long.valueOf(j));
        }
        ym4.a aVar2 = this.r;
        if (aVar2 != null) {
            aVar.j(aVar2);
        }
        o.a.d("click_module", aVar);
    }

    public final c b(String str) {
        this.b = str;
        return this;
    }

    public final c c(String str) {
        this.l = str;
        return this;
    }

    public final c d(String str) {
        this.m = str;
        return this;
    }

    public final c e(String str) {
        this.a = str;
        return this;
    }

    public final c f(String str) {
        this.d = str;
        return this;
    }

    public final c g(int i) {
        this.f = i;
        return this;
    }

    public final c h(String str) {
        this.n = str;
        return this;
    }

    public final c i(String str) {
        this.h = str;
        return this;
    }

    public final c j(String str) {
        this.p = str;
        return this;
    }

    public final c k(String str) {
        this.o = str;
        return this;
    }

    public final c l(String str) {
        this.c = str;
        return this;
    }
}
