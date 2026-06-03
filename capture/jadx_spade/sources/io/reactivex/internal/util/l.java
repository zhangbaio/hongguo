package io.reactivex.internal.util;

import com.bytedance.covode.number.Covode;
import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l<T> implements Function<List<T>, List<T>> {
    final Comparator<? super T> a;

    static {
        Covode.recordClassIndex(657745);
    }

    public l(Comparator<? super T> comparator) {
        this.a = comparator;
    }

    @Override // io.reactivex.functions.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.a);
        return list;
    }
}
