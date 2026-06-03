package ln4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public mn4.a a;
    public String b;
    public String c;
    public int d;
    public String e;
    public boolean f;
    private final MutableState g;

    static {
        Covode.recordClassIndex(608801);
    }

    public final String a() {
        return (String) this.g.getValue();
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.g.setValue(str);
    }

    public final void c(String newQuery) {
        Intrinsics.checkNotNullParameter(newQuery, "newQuery");
        b(newQuery);
    }

    public a(mn4.a hostDepend, String tabName, int i, String searchEntrance, String categoryName) {
        Intrinsics.checkNotNullParameter(hostDepend, "hostDepend");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(searchEntrance, "searchEntrance");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.b = "";
        this.c = "";
        this.e = "general";
        this.f = true;
        this.g = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.a = hostDepend;
        this.b = tabName;
        this.d = i;
        this.e = searchEntrance;
        this.c = categoryName;
    }
}
