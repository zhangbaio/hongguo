package kotlin.collections;

import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Grouping<T, K> {
    K keyOf(T t);

    Iterator<T> sourceIterator();
}
