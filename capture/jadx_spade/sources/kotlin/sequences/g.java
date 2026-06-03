package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class g implements Sequence, e {
    public static final g a;

    static {
        Covode.recordClassIndex(658712);
        a = new g();
    }

    private g() {
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return kotlin.collections.y.a;
    }

    @Override // kotlin.sequences.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g b(int i) {
        return a;
    }

    @Override // kotlin.sequences.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public g a(int i) {
        return a;
    }
}
