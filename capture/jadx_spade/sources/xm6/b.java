package xm6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import xm6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    static {
        Covode.recordClassIndex(658865);
    }

    public static final a a(boolean z) {
        return b(z, f.a.a);
    }

    public static final c c(int i) {
        return d(i, f.a.a);
    }

    public static final d e(long j) {
        return f(j, f.a.a);
    }

    public static final <T> e<T> g(T t) {
        return h(t, f.a.a);
    }

    public static final a b(boolean z, f trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new a(z, trace);
    }

    public static final c d(int i, f trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new c(i, trace);
    }

    public static final d f(long j, f trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new d(j, trace);
    }

    public static final <T> e<T> h(T t, f trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return new e<>(t, trace);
    }
}
