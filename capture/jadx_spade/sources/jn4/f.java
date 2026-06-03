package jn4;

import com.bytedance.covode.number.Covode;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final int J;
    private int A;
    private String B;
    private String C;
    private String D;
    private boolean E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
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
    private String r;
    private boolean s;
    public String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private ym4.a y;
    private int z;

    static {
        Covode.recordClassIndex(608783);
        J = 8;
    }

    public final void b() {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String str2;
        ym4.a aVar = new ym4.a();
        bn4.f.a.a(aVar);
        ym4.a aVar2 = this.y;
        if (aVar2 != null) {
            aVar.j(aVar2);
        }
        aVar.g("tab_name", this.a);
        aVar.g("module_name", this.u);
        aVar.g("book_id", this.b);
        String str3 = this.c;
        boolean z12 = false;
        if (str3 != null && str3.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("book_name", this.c);
        }
        String str4 = this.d;
        if (str4 != null && str4.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            aVar.g("show_book_name", this.d);
            if (this.e) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            aVar.g("is_alias", str2);
        }
        aVar.g("module_rank", Integer.valueOf(this.f));
        aVar.g("rank", this.g);
        aVar.g("page_name", "search_result");
        if (a(this.z)) {
            str = "cartoon";
        } else {
            str = this.h;
        }
        aVar.g("book_type", str);
        aVar.g("genre", Integer.valueOf(this.A));
        aVar.g("type", this.i);
        aVar.g("input_query", this.j);
        aVar.g("source", this.k);
        aVar.g("search_attached_info", this.l);
        aVar.g("category_name", this.m);
        aVar.g("result_tab", this.n);
        String str5 = this.w;
        if (str5 != null && str5.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            aVar.g("list_name", this.w);
        }
        if (this.s) {
            aVar.g("category_recommend_name", this.o);
            aVar.g("category_recommend_id", this.p);
        }
        aVar.g("doc_rank", h.a.a(this.l));
        aVar.g("search_source_book_id", this.q);
        aVar.g("search_id", this.r);
        aVar.g("recommend_info", this.t);
        String str6 = this.x;
        if (str6 != null && str6.length() != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4) {
            aVar.g("search_source_id", this.x);
        }
        String str7 = this.F;
        if (str7 != null && str7.length() != 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!z5) {
            aVar.g("content_rec_label", this.F);
        }
        String str8 = this.D;
        if (str8 != null && str8.length() != 0) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (!z6) {
            aVar.g("post_id", this.D);
        }
        String str9 = this.B;
        if (str9 != null && str9.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            aVar.g("forum_position", this.B);
        }
        String str10 = this.C;
        if (str10 != null && str10.length() != 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (!z8) {
            aVar.g("post_position", this.C);
        }
        String str11 = this.G;
        if (str11 != null && str11.length() != 0) {
            z9 = false;
        } else {
            z9 = true;
        }
        if (!z9) {
            aVar.g("result_type", this.G);
        }
        String str12 = this.v;
        if (str12 != null && str12.length() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            aVar.g("sub_module_name", this.v);
        }
        String str13 = this.H;
        if (str13 != null && str13.length() != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            aVar.g("search_bar_query", this.H);
        }
        String str14 = this.I;
        if (str14 == null || str14.length() == 0) {
            z12 = true;
        }
        if (!z12) {
            aVar.g("is_same_query", this.I);
        }
        o oVar = o.a;
        oVar.d("show_book", aVar);
        if (this.E) {
            oVar.d("show_bookcard", aVar);
        }
    }

    public final f c(String str) {
        this.b = str;
        return this;
    }

    public final f d(String str) {
        this.c = str;
        return this;
    }

    public final f e(String str) {
        this.g = str;
        return this;
    }

    public final f f(String str) {
        this.h = str;
        return this;
    }

    public final f g(String str) {
        this.m = str;
        return this;
    }

    public final f h(int i) {
        this.A = i;
        return this;
    }

    public final f i(int i) {
        this.z = i;
        return this;
    }

    public final f j(String str) {
        this.I = str;
        return this;
    }

    public final f k(String str) {
        this.w = str;
        return this;
    }

    public final f m(String str) {
        this.t = str;
        return this;
    }

    public final f n(String str) {
        this.l = str;
        return this;
    }

    public final f o(String str) {
        this.a = str;
        return this;
    }

    public final f p(String str) {
        this.i = str;
        return this;
    }

    public final f q(int i) {
        this.f = i;
        return this;
    }

    private final boolean a(int i) {
        return nc4.a.a.h(Integer.valueOf(i));
    }

    public final f l(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.u = str;
        }
        return this;
    }
}
