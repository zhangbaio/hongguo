package io.reactivex.internal.util;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k {
    static {
        Covode.recordClassIndex(657744);
    }

    public static <T> nm6.j<T> c(int i) {
        if (i < 0) {
            return new io.reactivex.internal.queue.a(-i);
        }
        return new SpscArrayQueue(i);
    }

    static boolean f(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            return true;
        }
    }

    public static void j(Subscription subscription, int i) {
        long j;
        if (i < 0) {
            j = Long.MAX_VALUE;
        } else {
            j = i;
        }
        subscription.request(j);
    }

    public static <T> void g(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            subscriber.onComplete();
            return;
        }
        if (h(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            return;
        }
        do {
            j = atomicLong.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j2 = j | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j, j2));
        if (j != 0) {
            h(j2, subscriber, queue, atomicLong, booleanSupplier);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r1 = r15.d(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T, U> void d(nm6.i<T> r11, io.reactivex.Observer<? super U> r12, boolean r13, io.reactivex.disposables.Disposable r14, io.reactivex.internal.util.h<T, U> r15) {
        /*
            r0 = 1
            r1 = 1
        L2:
            boolean r2 = r15.a()
            boolean r3 = r11.isEmpty()
            r4 = r12
            r5 = r13
            r6 = r11
            r7 = r14
            r8 = r15
            boolean r2 = a(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L16
            return
        L16:
            boolean r3 = r15.a()
            java.lang.Object r2 = r11.poll()
            if (r2 != 0) goto L22
            r10 = 1
            goto L24
        L22:
            r4 = 0
            r10 = 0
        L24:
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r11
            r8 = r14
            r9 = r15
            boolean r3 = a(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L31
            return
        L31:
            if (r10 == 0) goto L3b
            int r1 = -r1
            int r1 = r15.d(r1)
            if (r1 != 0) goto L2
            return
        L3b:
            r15.e(r12, r2)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.k.d(nm6.i, io.reactivex.Observer, boolean, io.reactivex.disposables.Disposable, io.reactivex.internal.util.h):void");
    }

    public static <T> boolean i(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, b.c(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 == Long.MIN_VALUE) {
            h(j | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
            return true;
        }
        return false;
    }

    public static <T, U> void e(nm6.i<T> iVar, Subscriber<? super U> subscriber, boolean z, Disposable disposable, j<T, U> jVar) {
        boolean z2;
        int i = 1;
        while (true) {
            boolean a = jVar.a();
            T poll = iVar.poll();
            if (poll == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (b(a, z2, subscriber, z, iVar, jVar)) {
                if (disposable != null) {
                    disposable.dispose();
                    return;
                }
                return;
            } else if (z2) {
                i = jVar.d(-i);
                if (i == 0) {
                    return;
                }
            } else {
                long requested = jVar.requested();
                if (requested != 0) {
                    if (jVar.f(subscriber, poll) && requested != Long.MAX_VALUE) {
                        jVar.e(1L);
                    }
                } else {
                    iVar.clear();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
            }
        }
    }

    static <T> boolean h(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (f(booleanSupplier)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(poll);
                j2++;
            } else {
                if (f(booleanSupplier)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long addAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j = addAndGet;
                    j2 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T, U> boolean b(boolean z, boolean z2, Subscriber<?> subscriber, boolean z3, nm6.j<?> jVar, j<T, U> jVar2) {
        if (jVar2.b()) {
            jVar.clear();
            return true;
        }
        if (z) {
            if (z3) {
                if (z2) {
                    Throwable c = jVar2.c();
                    if (c != null) {
                        subscriber.onError(c);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable c2 = jVar2.c();
            if (c2 != null) {
                jVar.clear();
                subscriber.onError(c2);
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

    public static <T, U> boolean a(boolean z, boolean z2, Observer<?> observer, boolean z3, nm6.j<?> jVar, Disposable disposable, h<T, U> hVar) {
        if (hVar.b()) {
            jVar.clear();
            disposable.dispose();
            return true;
        }
        if (z) {
            if (z3) {
                if (z2) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    Throwable c = hVar.c();
                    if (c != null) {
                        observer.onError(c);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable c2 = hVar.c();
            if (c2 != null) {
                jVar.clear();
                if (disposable != null) {
                    disposable.dispose();
                }
                observer.onError(c2);
                return true;
            }
            if (z2) {
                if (disposable != null) {
                    disposable.dispose();
                }
                observer.onComplete();
                return true;
            }
            return false;
        }
        return false;
    }
}
