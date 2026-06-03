package io.reactivex;

import com.bytedance.covode.number.Covode;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Notification<T> {
    static final Notification<Object> COMPLETE;
    final Object value;

    public static <T> Notification<T> createOnComplete() {
        return (Notification<T>) COMPLETE;
    }

    public boolean isOnComplete() {
        if (this.value == null) {
            return true;
        }
        return false;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.value);
    }

    static {
        Covode.recordClassIndex(656223);
        COMPLETE = new Notification<>(null);
    }

    public Throwable getError() {
        Object obj = this.value;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public T getValue() {
        Object obj = this.value;
        if (obj != null && !NotificationLite.isError(obj)) {
            return (T) this.value;
        }
        return null;
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean isOnNext() {
        Object obj = this.value;
        if (obj != null && !NotificationLite.isError(obj)) {
            return true;
        }
        return false;
    }

    public String toString() {
        Object obj = this.value;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.value + "]";
    }

    private Notification(Object obj) {
        this.value = obj;
    }

    public static <T> Notification<T> createOnError(Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return new Notification<>(NotificationLite.error(th));
    }

    public static <T> Notification<T> createOnNext(T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return new Notification<>(t);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.equals(this.value, ((Notification) obj).value);
        }
        return false;
    }
}
