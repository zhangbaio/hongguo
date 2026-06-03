package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class x extends MainCoroutineDispatcher implements kotlinx.coroutines.f0 {
    private final Throwable a;
    private final String b;

    static {
        Covode.recordClassIndex(659251);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public MainCoroutineDispatcher getImmediate() {
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void x() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.a
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.b
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.a
            r1.<init>(r0, r2)
            throw r1
        L36:
            kotlinx.coroutines.internal.w.d()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.x.x():java.lang.Void");
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.a != null) {
            str = ", cause=" + this.a;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        x();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int i) {
        x();
        throw new KotlinNothingValueException();
    }

    public x(Throwable th, String str) {
        this.a = th;
        this.b = str;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        x();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.f0
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        x();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.f0
    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        x();
        throw new KotlinNothingValueException();
    }
}
