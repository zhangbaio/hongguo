package yn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int i;
    public String a;
    public long b = Clock.System.INSTANCE.now().toEpochMilliseconds() / 1000;
    public a c;
    public long d;
    public long e;
    public List<String> f;
    public String g;
    private ym4.a h;

    static {
        Covode.recordClassIndex(608968);
        i = 8;
    }

    public final ym4.a b() {
        ym4.a aVar;
        ym4.a aVar2 = new ym4.a();
        aVar2.j(this.h);
        a aVar3 = this.c;
        if (aVar3 != null) {
            aVar = aVar3.g();
        } else {
            aVar = null;
        }
        aVar2.j(aVar);
        return aVar2;
    }

    public b() {
        ym4.a aVar = new ym4.a();
        this.h = aVar;
        aVar.g("share_timestamp", Long.valueOf(this.b));
    }

    public final void a(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.h.h(map);
    }

    public final void c(a shareReportContext) {
        Intrinsics.checkNotNullParameter(shareReportContext, "shareReportContext");
        this.c = shareReportContext;
    }

    public final void d(long j) {
        this.b = j;
        this.h.g("share_timestamp", Long.valueOf(j));
    }
}
