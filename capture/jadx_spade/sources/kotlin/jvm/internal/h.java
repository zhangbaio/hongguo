package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.m0;
import kotlin.collections.x;
import kotlin.collections.z;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h {
    static {
        Covode.recordClassIndex(658494);
    }

    public static final kotlin.collections.s a(boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new a(array);
    }

    public static final kotlin.collections.t b(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new b(array);
    }

    public static final kotlin.collections.u c(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new c(array);
    }

    public static final x d(double[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new d(array);
    }

    public static final z e(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new e(array);
    }

    public static final IntIterator f(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new f(array);
    }

    public static final LongIterator g(long[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new i(array);
    }

    public static final m0 h(short[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new j(array);
    }
}
