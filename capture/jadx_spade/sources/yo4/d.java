package yo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import gk4.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements f {
    private final long a;
    public final Map<String, String> b;
    public final Map<String, String> c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String k;
    public String l;
    public final Map<String, String> m;
    private Map<String, String> n;
    public Integer o;
    public String p;
    public String q;
    public Integer r;
    public Integer s;
    public String t;

    static {
        Covode.recordClassIndex(609170);
    }

    @Override // gk4.f
    public long a() {
        return this.a;
    }

    public final String b() {
        String str = this.i;
        if (str == null) {
            return this.d;
        }
        return str;
    }

    public final String c() {
        String str = this.j;
        if (str == null) {
            return this.e;
        }
        return str;
    }

    public final String d() {
        String str = this.l;
        if (str == null) {
            return "story_post";
        }
        return str;
    }

    public final String e() {
        return String.valueOf(this.a);
    }

    public final void g(Map<String, String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.n = value;
        this.m.putAll(value);
    }

    public final void f(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.m.put(key, value);
    }

    public d(long j, Map<String, String> extraParams, Map<String, String> pageInfo) {
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        this.a = j;
        this.b = extraParams;
        this.c = pageInfo;
        this.f = -1;
        this.h = -1;
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
        this.p = "ugc_story";
    }
}
