package un4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d<K, V> {
    public static final int d;
    private final int a;
    private final boolean b;
    private final LinkedHashMap<K, V> c;

    static {
        Covode.recordClassIndex(608934);
        d = 8;
    }

    private final void d() {
        Object firstOrNull;
        while (this.c.size() > this.a) {
            Set<K> keySet = this.c.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(keySet);
            if (firstOrNull == null) {
                return;
            } else {
                this.c.remove(firstOrNull);
            }
        }
    }

    public final V c(K k) {
        return this.c.remove(k);
    }

    public final V a(K k) {
        V v = this.c.get(k);
        if (v == null) {
            return null;
        }
        if (this.b) {
            this.c.remove(k);
            this.c.put(k, v);
        }
        return v;
    }

    public d(int i, boolean z) {
        this.a = i;
        this.b = z;
        this.c = new LinkedHashMap<>();
    }

    public final V b(K k, V v) {
        V remove = this.c.remove(k);
        this.c.put(k, v);
        d();
        return remove;
    }

    public /* synthetic */ d(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? true : z);
    }
}
