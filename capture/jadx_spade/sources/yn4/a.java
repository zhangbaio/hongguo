package yn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.kmp.utils.v;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int k;
    public final String a;
    private String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public Map<String, Object> i;
    public Map<String, Object> j;

    static {
        Covode.recordClassIndex(608967);
        k = 8;
    }

    public final String getType() {
        return this.b;
    }

    public final ym4.a g() {
        ym4.a aVar = new ym4.a();
        if (StringUtilsKt.a(this.c)) {
            aVar.g("entrance", this.c);
        } else {
            aVar.g("entrance", this.a);
        }
        aVar.g("type", this.b);
        aVar.g("content_type", this.d);
        aVar.g("content_id_key", this.e);
        aVar.g("content_id", this.f);
        if (!this.j.keySet().isEmpty()) {
            aVar.g("extra", v.a.k(this.j));
        }
        for (String str : this.i.keySet()) {
            aVar.g(str, this.i.get(str));
        }
        aVar.g("second_share_channel", this.h);
        String str2 = this.g;
        if (str2 != null) {
            aVar.g("read_progress", str2);
        }
        return aVar;
    }

    public final a d(String str) {
        this.g = str;
        return this;
    }

    public final a e(String str) {
        this.h = str;
        return this;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a a(Map<?, ?> map) {
        Set<?> keySet;
        String str;
        if (map != null && (keySet = map.keySet()) != null) {
            for (Object obj : keySet) {
                if (obj instanceof String) {
                    Map<String, Object> map2 = this.j;
                    Object obj2 = map.get(obj);
                    if (obj2 == null || (str = obj2.toString()) == null) {
                        str = "";
                    }
                    map2.put(obj, str);
                }
            }
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a b(Map<?, ?> map) {
        Set<?> keySet;
        String str;
        if (map != null && (keySet = map.keySet()) != null) {
            for (Object obj : keySet) {
                if (obj instanceof String) {
                    Map<String, Object> map2 = this.i;
                    Object obj2 = map.get(obj);
                    if (obj2 == null || (str = obj2.toString()) == null) {
                        str = "";
                    }
                    map2.put(obj, str);
                }
            }
        }
        return this;
    }

    public a(String shareEntrance, String type) {
        Intrinsics.checkNotNullParameter(shareEntrance, "shareEntrance");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = shareEntrance;
        this.b = type;
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
    }

    public final a c(String contentType, String contentIdType, String str) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentIdType, "contentIdType");
        this.d = contentType;
        this.e = contentIdType;
        if (str == null) {
            str = "";
        }
        this.f = str;
        return this;
    }
}
