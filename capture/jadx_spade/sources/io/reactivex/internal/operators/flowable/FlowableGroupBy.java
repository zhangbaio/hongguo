package io.reactivex.internal.operators.flowable;

import com.bytedance.covode.number.Covode;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FlowableGroupBy<T, K, V> extends io.reactivex.internal.operators.flowable.a<T, km6.b<K, V>> {
    final Function<? super T, ? extends K> b;
    final Function<? super T, ? extends V> c;
    final int d;
    final boolean e;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> f;

    static {
        Covode.recordClassIndex(656637);
    }

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<km6.b<K, V>> implements FlowableSubscriber<T> {
        static final Object NULL_KEY;
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final boolean delayError;
        boolean done;
        final Subscriber<? super km6.b<K, V>> downstream;
        Throwable error;
        final Queue<b<K, V>> evictedGroups;
        volatile boolean finished;
        final Map<Object, b<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        boolean outputFused;
        final io.reactivex.internal.queue.a<km6.b<K, V>> queue;
        Subscription upstream;
        final Function<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger groupCount = new AtomicInteger(1);

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        static {
            Covode.recordClassIndex(656639);
            NULL_KEY = new Object();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public km6.b<K, V> poll() {
            return this.queue.poll();
        }

        private void completeEvictions() {
            if (this.evictedGroups != null) {
                int i = 0;
                while (true) {
                    b<K, V> poll = this.evictedGroups.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.onComplete();
                    i++;
                }
                if (i != 0) {
                    this.groupCount.addAndGet(-i);
                }
            }
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                completeEvictions();
                if (this.groupCount.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            Throwable th;
            io.reactivex.internal.queue.a<km6.b<K, V>> aVar = this.queue;
            Subscriber<? super km6.b<K, V>> subscriber = this.downstream;
            int i = 1;
            while (!this.cancelled.get()) {
                boolean z = this.finished;
                if (z && !this.delayError && (th = this.error) != null) {
                    aVar.clear();
                    subscriber.onError(th);
                    return;
                }
                subscriber.onNext((Object) null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            aVar.clear();
        }

        public void onComplete() {
            if (!this.done) {
                Iterator<b<K, V>> it2 = this.groups.values().iterator();
                while (it2.hasNext()) {
                    it2.next().onComplete();
                }
                this.groups.clear();
                Queue<b<K, V>> queue = this.evictedGroups;
                if (queue != null) {
                    queue.clear();
                }
                this.done = true;
                this.finished = true;
                drain();
            }
        }

        void drainNormal() {
            boolean z;
            io.reactivex.internal.queue.a<km6.b<K, V>> aVar = this.queue;
            Subscriber<? super km6.b<K, V>> subscriber = this.downstream;
            int i = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z2 = this.finished;
                    km6.b<K, V> poll = aVar.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (checkTerminated(z2, z, subscriber, aVar)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j && checkTerminated(this.finished, aVar.isEmpty(), subscriber, aVar)) {
                    return;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    this.upstream.request(j2);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.f
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.FlowableSubscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.bufferSize);
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            this.groups.remove(k);
            if (this.groupCount.decrementAndGet() == 0) {
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            Iterator<b<K, V>> it2 = this.groups.values().iterator();
            while (it2.hasNext()) {
                it2.next().onError(th);
            }
            this.groups.clear();
            Queue<b<K, V>> queue = this.evictedGroups;
            if (queue != null) {
                queue.clear();
            }
            this.error = th;
            this.finished = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onNext(T t) {
            Object obj;
            boolean z;
            b bVar;
            if (this.done) {
                return;
            }
            io.reactivex.internal.queue.a<km6.b<K, V>> aVar = this.queue;
            try {
                K apply = this.keySelector.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                b<K, V> bVar2 = this.groups.get(obj);
                if (bVar2 == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    b b = b.b(apply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, b);
                    this.groupCount.getAndIncrement();
                    z = true;
                    bVar = b;
                } else {
                    z = false;
                    bVar = bVar2;
                }
                try {
                    bVar.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(t), "The valueSelector returned null"));
                    completeEvictions();
                    if (z) {
                        aVar.offer(bVar);
                        drain();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled.get()) {
                aVar.clear();
                return true;
            }
            if (this.delayError) {
                if (z && z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
                return false;
            }
            if (z) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    aVar.clear();
                    subscriber.onError(th2);
                    return true;
                }
                if (z2) {
                    subscriber.onComplete();
                    return true;
                }
                return false;
            }
            return false;
        }

        public GroupBySubscriber(Subscriber<? super km6.b<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Map<Object, b<K, V>> map, Queue<b<K, V>> queue) {
            this.downstream = subscriber;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = map;
            this.evictedGroups = queue;
            this.queue = new io.reactivex.internal.queue.a<>(i);
        }
    }

    static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();

        static {
            Covode.recordClassIndex(656641);
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.j
        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            int i = this.produced;
            if (i != 0) {
                this.produced = 0;
                this.parent.upstream.request(i);
                return null;
            }
            return null;
        }

        void drainFused() {
            Throwable th;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            Subscriber<? super T> subscriber = this.actual.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    if (this.cancelled.get()) {
                        aVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && !this.delayError && (th = this.error) != null) {
                        aVar.clear();
                        subscriber.onError(th);
                        return;
                    }
                    subscriber.onNext((Object) null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        void drainNormal() {
            boolean z;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            boolean z2 = this.delayError;
            Subscriber<? super T> subscriber = this.actual.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z3 = this.done;
                        T poll = aVar.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (checkTerminated(z3, z, subscriber, z2)) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                    }
                    if (j2 == j && checkTerminated(this.done, aVar.isEmpty(), subscriber, z2)) {
                        return;
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        this.parent.upstream.request(j2);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, nm6.f
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        public void subscribe(Subscriber<? super T> subscriber) {
            if (this.once.compareAndSet(false, true)) {
                subscriber.onSubscribe(this);
                this.actual.lazySet(subscriber);
                drain();
                return;
            }
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
        }

        State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
        }

        boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                return true;
            }
            if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            subscriber.onError(th);
                        } else {
                            subscriber.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    subscriber.onError(th2);
                    return true;
                }
                if (z2) {
                    subscriber.onComplete();
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    static final class b<K, T> extends km6.b<K, T> {
        final State<T, K> b;

        static {
            Covode.recordClassIndex(656640);
        }

        public void onComplete() {
            this.b.onComplete();
        }

        public void onError(Throwable th) {
            this.b.onError(th);
        }

        public void onNext(T t) {
            this.b.onNext(t);
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> subscriber) {
            this.b.subscribe(subscriber);
        }

        protected b(K k, State<T, K> state) {
            super(k);
            this.b = state;
        }

        public static <T, K> b<K, T> b(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new b<>(k, new State(i, groupBySubscriber, k, z));
        }
    }

    static final class a<K, V> implements Consumer<b<K, V>> {
        final Queue<b<K, V>> a;

        static {
            Covode.recordClassIndex(656638);
        }

        a(Queue<b<K, V>> queue) {
            this.a = queue;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(b<K, V> bVar) {
            this.a.offer(bVar);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super km6.b<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map<K, Object> apply;
        try {
            if (this.f == null) {
                apply = new ConcurrentHashMap<>();
                concurrentLinkedQueue = null;
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                apply = this.f.apply(new a(concurrentLinkedQueue));
            }
            this.a.subscribe((FlowableSubscriber) new GroupBySubscriber(subscriber, this.b, this.c, this.d, this.e, apply, concurrentLinkedQueue));
        } catch (Exception e) {
            Exceptions.throwIfFatal(e);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(e);
        }
    }

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.b = function;
        this.c = function2;
        this.d = i;
        this.e = z;
        this.f = function3;
    }
}
