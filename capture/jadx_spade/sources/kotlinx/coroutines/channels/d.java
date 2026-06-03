package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.c0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<E> extends c0<d<E>> {
    private final BufferedChannel<E> e;
    private final /* synthetic */ AtomicReferenceArray f;

    static {
        Covode.recordClassIndex(659082);
    }

    private final /* synthetic */ AtomicReferenceArray y() {
        return this.f;
    }

    @Override // kotlinx.coroutines.internal.c0
    public int q() {
        return BufferedChannelKt.b;
    }

    public final BufferedChannel<E> x() {
        BufferedChannel<E> bufferedChannel = this.e;
        Intrinsics.checkNotNull(bufferedChannel);
        return bufferedChannel;
    }

    public final E C(int i) {
        E z = z(i);
        v(i);
        return z;
    }

    public final void v(int i) {
        D(i, null);
    }

    public final Object A(int i) {
        return y().get((i * 2) + 1);
    }

    public final E z(int i) {
        return (E) y().get(i * 2);
    }

    public final void F(int i, E e) {
        D(i, e);
    }

    private final void D(int i, Object obj) {
        y().set(i * 2, obj);
    }

    public final void E(int i, Object obj) {
        y().set((i * 2) + 1, obj);
    }

    public final Object w(int i, Object obj) {
        return y().getAndSet((i * 2) + 1, obj);
    }

    public final void B(int i, boolean z) {
        if (z) {
            x().c1((this.c * BufferedChannelKt.b) + i);
        }
        s();
    }

    public final boolean u(int i, Object obj, Object obj2) {
        return c.a(y(), (i * 2) + 1, obj, obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0063, code lost:
    
        v(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0066, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0068, code lost:
    
        r4 = x().b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006e, code lost:
    
        if (r4 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0070, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(int r4, java.lang.Throwable r5, kotlin.coroutines.CoroutineContext r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.z(r4)
        Le:
            java.lang.Object r1 = r3.A(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.f2
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.j
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            if (r1 == r2) goto L63
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
            if (r1 != r2) goto L28
            goto L63
        L28:
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r1 == r4) goto L62
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.d
            if (r1 != r4) goto L40
            goto L62
        L40:
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            return
        L63:
            r3.v(r4)
            if (r0 == 0) goto L73
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.x()
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r4 = r4.b
            if (r4 == 0) goto L73
            kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r4, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            goto L7f
        L7b:
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
        L7f:
            boolean r1 = r3.u(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.v(r4)
            r1 = r0 ^ 1
            r3.B(r4, r1)
            if (r0 == 0) goto L9a
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.x()
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r4 = r4.b
            if (r4 == 0) goto L9a
            kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.d.r(int, java.lang.Throwable, kotlin.coroutines.CoroutineContext):void");
    }

    public d(long j, d<E> dVar, BufferedChannel<E> bufferedChannel, int i) {
        super(j, dVar, i);
        this.e = bufferedChannel;
        this.f = new AtomicReferenceArray(BufferedChannelKt.b * 2);
    }
}
