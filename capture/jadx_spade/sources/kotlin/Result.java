package kotlin;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Result<T> implements Serializable {
    public static final Companion Companion;
    private final Object value;

    static {
        Covode.recordClassIndex(658094);
        Companion = new Companion(null);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m772boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m773constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m774equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.areEqual(obj, ((Result) obj2).m782unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m775equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m778hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        return m774equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m778hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m782unboximpl() {
        return this.value;
    }

    public static final class Failure implements Serializable {
        public final Throwable exception;

        static {
            Covode.recordClassIndex(658096);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) obj).exception)) {
                return true;
            }
            return false;
        }
    }

    public String toString() {
        return m781toStringimpl(this.value);
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m779isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    public static final class Companion {
        static {
            Covode.recordClassIndex(658095);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final <T> Object success(T t) {
            return Result.m773constructorimpl(t);
        }

        private final <T> Object failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return Result.m773constructorimpl(ResultKt.createFailure(exception));
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m777getOrNullimpl(Object obj) {
        if (m779isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m780isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m776exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m781toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
