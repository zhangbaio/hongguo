package io.reactivex.internal.queue;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import nm6.i;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements i<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP;
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    @Override // nm6.j
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    static {
        Covode.recordClassIndex(657635);
        MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    @Override // nm6.j
    public boolean isEmpty() {
        if (this.producerIndex.get() == this.consumerIndex.get()) {
            return true;
        }
        return false;
    }

    @Override // nm6.i, nm6.j
    public E poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    E lvElement(int i) {
        return get(i);
    }

    void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    public SpscArrayQueue(int i) {
        super(io.reactivex.internal.util.i.a(i));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    @Override // nm6.j
    public boolean offer(E e) {
        if (e != null) {
            int i = this.mask;
            long j = this.producerIndex.get();
            int calcElementOffset = calcElementOffset(j, i);
            if (j >= this.producerLookAhead) {
                long j2 = this.lookAheadStep + j;
                if (lvElement(calcElementOffset(j2, i)) == null) {
                    this.producerLookAhead = j2;
                } else if (lvElement(calcElementOffset) != null) {
                    return false;
                }
            }
            soElement(calcElementOffset, e);
            soProducerIndex(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    void soElement(int i, E e) {
        lazySet(i, e);
    }

    public boolean offer(E e, E e2) {
        if (offer(e) && offer(e2)) {
            return true;
        }
        return false;
    }
}
