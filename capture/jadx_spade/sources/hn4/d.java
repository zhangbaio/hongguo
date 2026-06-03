package hn4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SearchSource;
import com.bytedance.kmp.reading.model.SearchTabType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public Boolean g;
    public String h;
    public String i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;

    static {
        Covode.recordClassIndex(608769);
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public d(int i, String tabTitle, String searchWord, String searchId, String passback, String str, String str2) {
        Intrinsics.checkNotNullParameter(tabTitle, "tabTitle");
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        Intrinsics.checkNotNullParameter(searchId, "searchId");
        Intrinsics.checkNotNullParameter(passback, "passback");
        this.a = SearchTabType.None.getValue();
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = SearchSource.NONE.getValue();
        this.a = i;
        this.b = tabTitle;
        this.d = searchWord;
        this.e = searchId;
        this.i = passback;
        this.n = str;
        this.p = str2;
    }
}
