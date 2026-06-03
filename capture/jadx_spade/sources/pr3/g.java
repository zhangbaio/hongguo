package pr3;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public boolean c;
    public boolean d;
    public Map<String, ? extends Object> g;
    public int h;
    public int i;
    public String a = "";
    public String b = "";
    public String e = "";
    public String f = "";

    static {
        Covode.recordClassIndex(598777);
    }

    public g() {
        Map<String, ? extends Object> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.g = emptyMap;
        this.h = 1;
        this.i = 1;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f = str;
    }

    public final void c(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.g = map;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }
}
