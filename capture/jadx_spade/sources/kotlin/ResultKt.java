package kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ResultKt {
    static {
        Covode.recordClassIndex(658097);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> T getOrThrow(Object obj) {
        throwOnFailure(obj);
        return obj;
    }

    public static final Object createFailure(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void throwOnFailure(Object obj) {
        if (!(obj instanceof Result.Failure)) {
        } else {
            throw ((Result.Failure) obj).exception;
        }
    }

    private static final <R> Object runCatching(Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.Companion;
            return Result.m773constructorimpl(block.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m773constructorimpl(createFailure(th));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrDefault(Object obj, R r) {
        if (Result.m779isFailureimpl(obj)) {
            return r;
        }
        return obj;
    }

    private static final <T> Object onFailure(Object obj, Function1<? super Throwable, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(obj);
        if (m776exceptionOrNullimpl != null) {
            action.invoke(m776exceptionOrNullimpl);
        }
        return obj;
    }

    private static final <T> Object onSuccess(Object obj, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Result.m780isSuccessimpl(obj)) {
            action.invoke(obj);
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrElse(Object obj, Function1<? super Throwable, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(obj);
        if (m776exceptionOrNullimpl != null) {
            return onFailure.invoke(m776exceptionOrNullimpl);
        }
        return obj;
    }

    private static final <R, T> Object map(Object obj, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (Result.m780isSuccessimpl(obj)) {
            return Result.m773constructorimpl(transform.invoke(obj));
        }
        return Result.m773constructorimpl(obj);
    }

    private static final <R, T extends R> Object recover(Object obj, Function1<? super Throwable, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(obj);
        if (m776exceptionOrNullimpl != null) {
            return Result.m773constructorimpl(transform.invoke(m776exceptionOrNullimpl));
        }
        return obj;
    }

    private static final <T, R> Object runCatching(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.Companion;
            return Result.m773constructorimpl(block.invoke(t));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m773constructorimpl(createFailure(th));
        }
    }

    private static final <R, T> Object mapCatching(Object obj, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (Result.m780isSuccessimpl(obj)) {
            try {
                return Result.m773constructorimpl(transform.invoke(obj));
            } catch (Throwable th) {
                Result.Companion companion = Result.Companion;
                return Result.m773constructorimpl(createFailure(th));
            }
        }
        return Result.m773constructorimpl(obj);
    }

    private static final <R, T extends R> Object recoverCatching(Object obj, Function1<? super Throwable, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(obj);
        if (m776exceptionOrNullimpl != null) {
            try {
                return Result.m773constructorimpl(transform.invoke(m776exceptionOrNullimpl));
            } catch (Throwable th) {
                Result.Companion companion = Result.Companion;
                return Result.m773constructorimpl(createFailure(th));
            }
        }
        return obj;
    }

    private static final <R, T> R fold(Object obj, Function1<? super T, ? extends R> onSuccess, Function1<? super Throwable, ? extends R> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(obj);
        if (m776exceptionOrNullimpl == null) {
            return onSuccess.invoke(obj);
        }
        return onFailure.invoke(m776exceptionOrNullimpl);
    }
}
