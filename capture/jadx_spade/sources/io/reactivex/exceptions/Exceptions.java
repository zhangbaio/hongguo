package io.reactivex.exceptions;

import com.bytedance.covode.number.Covode;
import io.reactivex.internal.util.ExceptionHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Exceptions {
    static {
        Covode.recordClassIndex(656274);
    }

    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException propagate(Throwable th) {
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public static void throwIfFatal(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (!(th instanceof LinkageError)) {
                    return;
                } else {
                    throw ((LinkageError) th);
                }
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
