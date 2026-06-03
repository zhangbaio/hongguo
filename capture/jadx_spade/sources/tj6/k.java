package tj6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k {
    public final e a;
    public final boolean b;

    static {
        Covode.recordClassIndex(654077);
    }

    public final a a() {
        return new a(null, this.a.toJsonObject(), 1, null);
    }

    public final m b() {
        return new m(null, this.a.toJsonObject(), 1, null);
    }

    public k(e eVar, boolean z) {
        this.a = eVar;
        this.b = z;
    }

    public /* synthetic */ k(e eVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, (i & 2) != 0 ? false : z);
    }
}
