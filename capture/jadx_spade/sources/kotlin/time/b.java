package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface b extends m, Comparable<b> {
    /* renamed from: minus-UwyO8pc */
    long mo1058minusUwyO8pc(b bVar);

    public static final class a {
        static {
            Covode.recordClassIndex(658804);
        }

        public static int a(b bVar, b other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return c.h(bVar.mo1058minusUwyO8pc(other), c.b.c());
        }
    }
}
