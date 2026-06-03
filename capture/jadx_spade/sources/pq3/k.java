package pq3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.ResolutionStrategyData;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    public final j a;
    public final List<ResolutionStrategyData> b;

    static {
        Covode.recordClassIndex(598237);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Intrinsics.areEqual(this.a, kVar.a) && Intrinsics.areEqual(this.b, kVar.b);
    }

    public int hashCode() {
        j jVar = this.a;
        int hashCode = (jVar == null ? 0 : jVar.hashCode()) * 31;
        List<ResolutionStrategyData> list = this.b;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "PlayStrategyConfig(peakDownConfig=" + this.a + ", resolutionStrategyConfig=" + this.b + ')';
    }

    public k(j jVar, List<ResolutionStrategyData> list) {
        this.a = jVar;
        this.b = list;
    }

    public /* synthetic */ k(j jVar, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jVar, (i & 2) != 0 ? null : list);
    }
}
