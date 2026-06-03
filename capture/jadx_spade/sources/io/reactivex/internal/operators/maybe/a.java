package io.reactivex.internal.operators.maybe;

import com.bytedance.covode.number.Covode;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
abstract class a<T, R> extends Maybe<R> {
    protected final MaybeSource<T> a;

    static {
        Covode.recordClassIndex(656901);
    }

    a(MaybeSource<T> maybeSource) {
        this.a = maybeSource;
    }
}
