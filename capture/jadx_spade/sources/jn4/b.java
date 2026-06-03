package jn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.k0;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int w;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
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
    private String s;
    private String t;
    private String u;
    private ym4.a v = new ym4.a();

    static {
        Covode.recordClassIndex(608777);
        w = 8;
    }

    public final void b() {
        o.a.d("click_hot_category", a());
    }

    public final void c() {
        o.a.d("show_hot_category", a());
    }

    private final ym4.a a() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        ym4.a aVar = new ym4.a();
        aVar.h(k0.a.b().k());
        aVar.g("tab_name", this.a);
        aVar.g("category_name", this.b);
        aVar.g("module_name", this.c);
        aVar.g("rank", Integer.valueOf(this.g));
        aVar.g("hot_category", this.f);
        String str = this.h;
        boolean z16 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("module_rank", this.h);
        }
        String str2 = this.d;
        if (str2 != null && str2.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            aVar.g("page_name", this.d);
        }
        String str3 = this.e;
        if (str3 != null && str3.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            aVar.g("type", this.e);
        }
        String str4 = this.j;
        if (str4 != null && str4.length() != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4) {
            aVar.g("gid", this.j);
        }
        String str5 = this.i;
        if (str5 != null && str5.length() != 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!z5) {
            aVar.g("hot_category_name", this.i);
        }
        String str6 = this.k;
        if (str6 != null && str6.length() != 0) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (!z6) {
            aVar.g("recommend_info", this.k);
        }
        String str7 = this.p;
        if (str7 != null && str7.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            aVar.g("input_query", this.p);
        }
        String str8 = this.l;
        if (str8 != null && str8.length() != 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (!z8) {
            aVar.g("search_entrance", this.l);
        }
        String str9 = this.o;
        if (str9 != null && str9.length() != 0) {
            z9 = false;
        } else {
            z9 = true;
        }
        if (!z9) {
            aVar.g("result_tab", this.o);
        }
        String str10 = this.m;
        if (str10 != null && str10.length() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            aVar.g("search_id", this.m);
        }
        String str11 = this.n;
        if (str11 != null && str11.length() != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            aVar.g("search_source_book_id", this.n);
        }
        String str12 = this.u;
        if (str12 != null && str12.length() != 0) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12) {
            aVar.g("search_sec_entrance", this.u);
        }
        String str13 = this.q;
        if (str13 != null && str13.length() != 0) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!z13) {
            aVar.g("hyperlink_from_book_id", this.q);
        }
        String str14 = this.r;
        if (str14 != null && str14.length() != 0) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (!z14) {
            aVar.g("hyperlink_from_group_id", this.r);
        }
        String str15 = this.s;
        if (str15 != null && str15.length() != 0) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (!z15) {
            aVar.g("hyperlink_type", this.s);
        }
        String str16 = this.t;
        if (str16 == null || str16.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            aVar.g("hyperlink_position", this.t);
        }
        aVar.j(this.v);
        return aVar;
    }

    public final b d(String str) {
        this.b = str;
        return this;
    }

    public final b e(String str) {
        this.j = str;
        return this;
    }

    public final b f(String str) {
        this.f = str;
        return this;
    }

    public final b g(String str) {
        this.c = str;
        return this;
    }

    public final b h(String str) {
        this.h = str;
        return this;
    }

    public final b i(String str) {
        this.d = str;
        return this;
    }

    public final b j(int i) {
        this.g = i;
        return this;
    }

    public final b k(String str) {
        this.k = str;
        return this;
    }

    public final b l(String str) {
        this.l = str;
        return this;
    }

    public final b m(String str) {
        this.u = str;
        return this;
    }

    public final b n(String str) {
        this.a = str;
        return this;
    }

    public final b o(String str) {
        this.e = str;
        return this;
    }
}
