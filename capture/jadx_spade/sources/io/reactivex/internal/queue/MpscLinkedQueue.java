package io.reactivex.internal.queue;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReference;
import nm6.i;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class MpscLinkedQueue<T> implements i<T> {
    private final AtomicReference<LinkedQueueNode<T>> a = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> b = new AtomicReference<>();

    static {
        Covode.recordClassIndex(657633);
    }

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        static {
            Covode.recordClassIndex(657634);
        }

        LinkedQueueNode() {
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e) {
            this.value = e;
        }

        LinkedQueueNode(E e) {
            spValue(e);
        }
    }

    LinkedQueueNode<T> a() {
        return this.b.get();
    }

    LinkedQueueNode<T> b() {
        return this.b.get();
    }

    LinkedQueueNode<T> c() {
        return this.a.get();
    }

    @Override // nm6.j
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // nm6.j
    public boolean isEmpty() {
        if (b() == c()) {
            return true;
        }
        return false;
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    @Override // nm6.i, nm6.j
    public T poll() {
        LinkedQueueNode<T> lvNext;
        LinkedQueueNode<T> a = a();
        LinkedQueueNode<T> lvNext2 = a.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            d(lvNext2);
            return andNullValue;
        }
        if (a != c()) {
            do {
                lvNext = a.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            d(lvNext);
            return andNullValue2;
        }
        return null;
    }

    void d(LinkedQueueNode<T> linkedQueueNode) {
        this.b.lazySet(linkedQueueNode);
    }

    LinkedQueueNode<T> e(LinkedQueueNode<T> linkedQueueNode) {
        return this.a.getAndSet(linkedQueueNode);
    }

    @Override // nm6.j
    public boolean offer(T t) {
        if (t != null) {
            LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
            e(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }
}
