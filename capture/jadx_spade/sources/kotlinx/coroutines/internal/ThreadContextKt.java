package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.u1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ThreadContextKt {
    public static final f0 a;
    private static final Function2<Object, CoroutineContext.Element, Object> b;
    private static final Function2<u1<?>, CoroutineContext.Element, u1<?>> c;
    private static final Function2<m0, CoroutineContext.Element, m0> d;

    static {
        Covode.recordClassIndex(659270);
        a = new f0("NO_THREAD_ELEMENTS");
        b = new Function2<Object, CoroutineContext.Element, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, CoroutineContext.Element element) {
                Integer num;
                int i;
                if (element instanceof u1) {
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        return Integer.valueOf(i + 1);
                    }
                    return element;
                }
                return obj;
            }
        };
        c = new Function2<u1<?>, CoroutineContext.Element, u1<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
            @Override // kotlin.jvm.functions.Function2
            public final u1<?> invoke(u1<?> u1Var, CoroutineContext.Element element) {
                if (u1Var != null) {
                    return u1Var;
                }
                if (element instanceof u1) {
                    return (u1) element;
                }
                return null;
            }
        };
        d = new Function2<m0, CoroutineContext.Element, m0>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
            @Override // kotlin.jvm.functions.Function2
            public final m0 invoke(m0 m0Var, CoroutineContext.Element element) {
                if (element instanceof u1) {
                    u1<?> u1Var = (u1) element;
                    m0Var.a(u1Var, u1Var.u(m0Var.a));
                }
                return m0Var;
            }
        };
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, b);
        Intrinsics.checkNotNull(fold);
        return fold;
    }

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof m0) {
            ((m0) obj).b(coroutineContext);
            return;
        }
        Object fold = coroutineContext.fold(null, c);
        Intrinsics.checkNotNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((u1) fold).e(coroutineContext, obj);
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new m0(coroutineContext, ((Number) obj).intValue()), d);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((u1) obj).u(coroutineContext);
    }
}
