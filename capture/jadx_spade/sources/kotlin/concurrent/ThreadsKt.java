package kotlin.concurrent;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ThreadsKt {
    static {
        Covode.recordClassIndex(658268);
    }

    public static final class a extends Thread {
        final /* synthetic */ Function0<Unit> a;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.a.invoke();
        }

        a(Function0<Unit> function0) {
            this.a = function0;
        }
    }

    private static final <T> T getOrSet(ThreadLocal<T> threadLocal, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(threadLocal, "<this>");
        Intrinsics.checkNotNullParameter(function0, "default");
        T t = threadLocal.get();
        if (t == null) {
            T invoke = function0.invoke();
            threadLocal.set(invoke);
            return invoke;
        }
        return t;
    }

    public static final Thread thread(boolean z, boolean z2, ClassLoader classLoader, String str, int i, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        a aVar = new a(block);
        if (z2) {
            aVar.setDaemon(true);
        }
        if (i > 0) {
            aVar.setPriority(i);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z) {
            aVar.start();
        }
        return aVar;
    }

    public static /* synthetic */ Thread thread$default(boolean z, boolean z2, ClassLoader classLoader, String str, int i, Function0 function0, int i2, Object obj) {
        boolean z3;
        boolean z4;
        ClassLoader classLoader2;
        String str2;
        int i3;
        if ((i2 & 1) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i2 & 2) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if ((i2 & 4) != 0) {
            classLoader2 = null;
        } else {
            classLoader2 = classLoader;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        return thread(z3, z4, classLoader2, str2, i3, function0);
    }
}
