package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.c0;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d0<S extends c0<S>> {
    static {
        Covode.recordClassIndex(659262);
    }

    public static <S extends c0<S>> Object a(Object obj) {
        return obj;
    }

    public static final boolean c(Object obj) {
        if (obj == d.a) {
            return true;
        }
        return false;
    }

    public static final S b(Object obj) {
        if (obj != d.a) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }
}
