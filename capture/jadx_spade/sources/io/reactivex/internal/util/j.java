package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface j<T, U> {
    boolean a();

    boolean b();

    Throwable c();

    int d(int i);

    long e(long j);

    boolean f(Subscriber<? super U> subscriber, T t);

    long requested();
}
