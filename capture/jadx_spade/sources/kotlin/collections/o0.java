package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class o0 {
    static {
        Covode.recordClassIndex(658230);
    }

    public static byte[] a(Collection<kotlin.g> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] d = kotlin.h.d(collection.size());
        Iterator<kotlin.g> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            kotlin.h.A(d, i, it2.next().f());
            i++;
        }
        return d;
    }
}
