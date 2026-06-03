package kotlin;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {
    public static final a Companion;
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater;
    private volatile Object _value;

    /* renamed from: final, reason: not valid java name */
    private final Object f1041final;
    private volatile Function0<? extends T> initializer;

    public static final class a {
        static {
            Covode.recordClassIndex(658099);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static /* synthetic */ void getFinal$annotations() {
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this._value != n.a) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(658098);
        Companion = new a(null);
        valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this._value;
        n nVar = n.a;
        if (t != nVar) {
            return t;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (androidx.concurrent.futures.a.a(valueUpdater, this, nVar, invoke)) {
                this.initializer = null;
                return invoke;
            }
        }
        return (T) this._value;
    }

    public String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }

    public SafePublicationLazyImpl(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        n nVar = n.a;
        this._value = nVar;
        this.f1041final = nVar;
    }
}
