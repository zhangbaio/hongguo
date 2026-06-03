package kotlin.coroutines.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c {
    public static final c a;
    private static final a b;
    private static a c;

    private c() {
    }

    static {
        Covode.recordClassIndex(658323);
        a = new c();
        b = new a(null, null, null);
    }

    private final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = b;
            c = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Object obj;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        a aVar = c;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar == b || (method = aVar.a) == null || (invoke = method.invoke(continuation.getClass(), new Object[0])) == null || (method2 = aVar.b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.c;
        if (method3 != null) {
            obj = method3.invoke(invoke2, new Object[0]);
        } else {
            obj = null;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    private static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        static {
            Covode.recordClassIndex(658324);
        }

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }
}
