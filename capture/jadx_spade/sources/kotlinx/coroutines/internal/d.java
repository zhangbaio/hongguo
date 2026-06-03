package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static final f0 a;

    static {
        Covode.recordClassIndex(659217);
        a = new f0("CLOSED");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.e] */
    public static final <N extends e<N>> N b(N n) {
        while (true) {
            Object f = n.f();
            if (f == a) {
                return n;
            }
            ?? r0 = (e) f;
            if (r0 == 0) {
                if (n.l()) {
                    return n;
                }
            } else {
                n = r0;
            }
        }
    }

    public static final <S extends c0<S>> Object c(S s, long j, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s.c < j || s.j()) {
                Object f = s.f();
                if (f == a) {
                    return d0.a(a);
                }
                S s2 = (S) ((e) f);
                if (s2 == null) {
                    s2 = function2.invoke(Long.valueOf(s.c + 1), s);
                    if (s.n(s2)) {
                        if (s.j()) {
                            s.m();
                        }
                    }
                }
                s = s2;
            } else {
                return d0.a(s);
            }
        }
    }
}
