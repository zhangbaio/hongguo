package kotlinx.coroutines.debug.internal;

import com.bytedance.covode.number.Covode;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    public static final c a;
    private static final StackTraceElement b;
    private static final SimpleDateFormat c;
    private static final ConcurrentWeakMap<a<?>, Boolean> d;
    private static boolean e;
    private static boolean f;
    private static final Function1<Boolean, Unit> g;
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> h;
    private static final /* synthetic */ b i;

    private /* synthetic */ class b {
        private static final /* synthetic */ AtomicIntegerFieldUpdater a;
        private static final /* synthetic */ AtomicLongFieldUpdater b;
        private volatile /* synthetic */ int installations$volatile;
        private volatile /* synthetic */ long sequenceNumber$volatile;

        static {
            Covode.recordClassIndex(659119);
            a = AtomicIntegerFieldUpdater.newUpdater(b.class, "installations$volatile");
            b = AtomicLongFieldUpdater.newUpdater(b.class, "sequenceNumber$volatile");
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private c() {
    }

    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> a;
        public final DebugCoroutineInfoImpl b;

        static {
            Covode.recordClassIndex(659118);
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        private final f a() {
            this.b.getClass();
            return null;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            a();
            return null;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            a();
            return null;
        }

        public String toString() {
            return this.a.toString();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            c.a.f(this);
            this.a.resumeWith(obj);
        }
    }

    private final Function1<Boolean, Unit> d() {
        Object m773constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            Object newInstance = l3.a.q("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            m773constructorimpl = Result.m773constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        return (Function1) m773constructorimpl;
    }

    static {
        Covode.recordClassIndex(659117);
        c cVar = new c();
        a = cVar;
        b = new a.a().b();
        c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DefaultConstructorMarker defaultConstructorMarker = null;
        d = new ConcurrentWeakMap<>(false, 1, defaultConstructorMarker);
        e = true;
        f = true;
        g = cVar.d();
        h = new ConcurrentWeakMap<>(true);
        i = new b(defaultConstructorMarker);
    }

    private final CoroutineStackFrame g(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a<?> aVar) {
        CoroutineStackFrame g2;
        d.remove(aVar);
        CoroutineStackFrame d2 = aVar.b.d();
        if (d2 != null && (g2 = g(d2)) != null) {
            h.remove(g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(a<?> aVar) {
        Job job;
        CoroutineContext context = aVar.b.getContext();
        if (context == null || (job = (Job) context.get(Job.Key)) == null || !job.isCompleted()) {
            return false;
        }
        d.remove(aVar);
        return true;
    }
}
