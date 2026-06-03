package io.reactivex.internal.util;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    static {
        Covode.recordClassIndex(657721);
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate(this);
    }

    public boolean isTerminated() {
        if (get() == ExceptionHelper.TERMINATED) {
            return true;
        }
        return false;
    }

    public boolean addThrowable(Throwable th) {
        return ExceptionHelper.addThrowable(this, th);
    }
}
