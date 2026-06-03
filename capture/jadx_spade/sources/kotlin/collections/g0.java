package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g0<E> extends AbstractList<E> implements RandomAccess {
    private final List<E> a;
    private int b;
    private int c;

    static {
        Covode.recordClassIndex(658214);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g0(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.a = list;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.b(i, this.c);
        return this.a.get(this.b + i);
    }

    public final void d(int i, int i2) {
        AbstractList.Companion.d(i, i2, this.a.size());
        this.b = i;
        this.c = i2 - i;
    }
}
