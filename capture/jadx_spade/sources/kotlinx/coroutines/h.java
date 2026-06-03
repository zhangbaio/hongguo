package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final /* synthetic */ class h {
    static {
        Covode.recordClassIndex(658896);
    }

    public static final <T> T a(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        p0 p0Var;
        p0 a;
        CoroutineContext e;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        if (continuationInterceptor == null) {
            a = v1.a.b();
            e = CoroutineContextKt.e(GlobalScope.INSTANCE, coroutineContext.plus(a));
        } else {
            p0 p0Var2 = null;
            if (continuationInterceptor instanceof p0) {
                p0Var = (p0) continuationInterceptor;
            } else {
                p0Var = null;
            }
            if (p0Var != null) {
                if (p0Var.I()) {
                    p0Var2 = p0Var;
                }
                if (p0Var2 != null) {
                    a = p0Var2;
                    e = CoroutineContextKt.e(GlobalScope.INSTANCE, coroutineContext);
                }
            }
            a = v1.a.a();
            e = CoroutineContextKt.e(GlobalScope.INSTANCE, coroutineContext);
        }
        f fVar = new f(e, currentThread, a);
        fVar.I0(CoroutineStart.DEFAULT, fVar, function2);
        return (T) fVar.J0();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(coroutineContext, function2);
    }
}
