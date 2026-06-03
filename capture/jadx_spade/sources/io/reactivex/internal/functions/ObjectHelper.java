package io.reactivex.internal.functions;

import com.bytedance.covode.number.Covode;
import io.reactivex.functions.BiPredicate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS;

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return (BiPredicate<T, T>) EQUALS;
    }

    static {
        Covode.recordClassIndex(656347);
        EQUALS = new a();
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    static final class a implements BiPredicate<Object, Object> {
        static {
            Covode.recordClassIndex(656348);
        }

        a() {
        }

        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Object obj, Object obj2) {
            return ObjectHelper.equals(obj, obj2);
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static long requireNonNull(long j, String str) {
        throw new InternalError("Null check on a primitive: " + str);
    }

    public static int verifyPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i);
    }

    public static long verifyPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j);
    }
}
