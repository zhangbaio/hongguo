package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.internal.f0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {
    public final int m;
    private final ReentrantLock n;
    private List<? extends BufferedChannel<E>> o;
    private Object p;
    private final HashMap<kotlinx.coroutines.selects.h<?>, Object> q;

    static {
        Covode.recordClassIndex(659060);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            return super.isClosedForSend();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final E g1() {
        f0 f0Var;
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            if (isClosedForSend()) {
                Throwable L = L();
                if (L == null) {
                    throw new IllegalStateException("This broadcast channel is closed");
                }
                throw L;
            }
            Object obj = this.p;
            f0Var = BroadcastChannelKt.NO_ELEMENT;
            if (obj != f0Var) {
                return (E) this.p;
            }
            throw new IllegalStateException("No value".toString());
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        a aVar;
        f0 f0Var;
        f0 f0Var2;
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            if (this.m == -1) {
                aVar = new b();
            } else {
                aVar = new a();
            }
            if (isClosedForSend()) {
                Object obj = this.p;
                f0Var2 = BroadcastChannelKt.NO_ELEMENT;
                if (obj == f0Var2) {
                    ((BufferedChannel) aVar).close(L());
                    return aVar;
                }
            }
            Object obj2 = this.p;
            f0Var = BroadcastChannelKt.NO_ELEMENT;
            if (obj2 != f0Var) {
                ((BufferedChannel) aVar).mo1078trySendJP2dKIU(g1());
            }
            this.o = CollectionsKt___CollectionsKt.plus((Collection<? extends ReceiveChannel<E>>) this.o, aVar);
            return aVar;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public String toString() {
        f0 f0Var;
        String str;
        StringBuilder sb = new StringBuilder();
        Object obj = this.p;
        f0Var = BroadcastChannelKt.NO_ELEMENT;
        if (obj != f0Var) {
            str = "CONFLATED_ELEMENT=" + this.p + "; ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("BROADCAST=<");
        sb.append(super.toString());
        sb.append(">; SUBSCRIBERS=");
        sb.append(CollectionsKt___CollectionsKt.joinToString$default(this.o, ";", "<", ">", 0, null, null, 56, null));
        return sb.toString();
    }

    private final class a extends BufferedChannel<E> {
        static {
            Covode.recordClassIndex(659061);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            super(BroadcastChannelImpl.this.m, null, 2, 0 == true ? 1 : 0);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: d1, reason: merged with bridge method [inline-methods] */
        public boolean w(Throwable th) {
            ReentrantLock reentrantLock = ((BroadcastChannelImpl) BroadcastChannelImpl.this).n;
            BroadcastChannelImpl<E> broadcastChannelImpl = BroadcastChannelImpl.this;
            reentrantLock.lock();
            try {
                broadcastChannelImpl.h1(this);
                return super.w(th);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private final class b extends g<E> {
        static {
            Covode.recordClassIndex(659062);
        }

        public b() {
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: h1, reason: merged with bridge method [inline-methods] */
        public boolean w(Throwable th) {
            BroadcastChannelImpl.this.h1(this);
            return super.w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void h1(ReceiveChannel<? extends E> receiveChannel) {
        boolean z;
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            List<? extends BufferedChannel<E>> list = this.o;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj) != receiveChannel) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            this.o = arrayList;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean w(Throwable th) {
        f0 f0Var;
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            Iterator<T> it2 = this.o.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).w(th);
            }
            f0Var = BroadcastChannelKt.NO_ELEMENT;
            this.p = f0Var;
            return super.w(th);
        } finally {
            reentrantLock.unlock();
        }
    }

    public BroadcastChannelImpl(int i) {
        super(0, null);
        f0 f0Var;
        this.m = i;
        if (i >= 1 || i == -1) {
            this.n = new ReentrantLock();
            this.o = CollectionsKt__CollectionsKt.emptyList();
            f0Var = BroadcastChannelKt.NO_ELEMENT;
            this.p = f0Var;
            this.q = new HashMap<>();
            return;
        }
        throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + i + " was specified").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            Iterator<T> it2 = this.o.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).close(th);
            }
            List<? extends BufferedChannel<E>> list = this.o;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj).X()) {
                    arrayList.add(obj);
                }
            }
            this.o = arrayList;
            return super.close(th);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo1078trySendJP2dKIU(E e) {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            if (isClosedForSend()) {
                return super.mo1078trySendJP2dKIU(e);
            }
            List<? extends BufferedChannel<E>> list = this.o;
            boolean z = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (((BufferedChannel) it2.next()).Q0()) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                return ChannelResult.Companion.b();
            }
            if (this.m == -1) {
                this.p = e;
            }
            Iterator<T> it4 = this.o.iterator();
            while (it4.hasNext()) {
                ((BufferedChannel) it4.next()).mo1078trySendJP2dKIU(e);
            }
            return ChannelResult.Companion.c(Unit.INSTANCE);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void G0(kotlinx.coroutines.selects.h<?> hVar, Object obj) {
        ReentrantLock reentrantLock = this.n;
        reentrantLock.lock();
        try {
            Object remove = this.q.remove(hVar);
            if (remove != null) {
                hVar.selectInRegistrationPhase(remove);
                return;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            kotlinx.coroutines.i.e(CoroutineScopeKt.CoroutineScope(hVar.getContext()), null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, obj, hVar, null), 1, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0078 -> B:10:0x007b). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object send(E r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = (kotlinx.coroutines.channels.BroadcastChannelImpl$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = new kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.BroadcastChannelImpl r4 = (kotlinx.coroutines.channels.BroadcastChannelImpl) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.n
            r8.lock()
            boolean r2 = r6.isClosedForSend()     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L94
            int r2 = r6.m     // Catch: java.lang.Throwable -> L99
            r4 = -1
            if (r2 != r4) goto L50
            r6.p = r7     // Catch: java.lang.Throwable -> L99
        L50:
            java.util.List<? extends kotlinx.coroutines.channels.BufferedChannel<E>> r2 = r6.o     // Catch: java.lang.Throwable -> L99
            r8.unlock()
            java.util.Iterator r8 = r2.iterator()
            r4 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L5d:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L91
            java.lang.Object r2 = r7.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.L$0 = r4
            r0.L$1 = r8
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r2 = r2.M0(r8, r0)
            if (r2 != r1) goto L78
            return r1
        L78:
            r5 = r2
            r2 = r8
            r8 = r5
        L7b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L8f
            boolean r8 = r4.isClosedForSend()
            if (r8 != 0) goto L8a
            goto L8f
        L8a:
            java.lang.Throwable r7 = r4.S()
            throw r7
        L8f:
            r8 = r2
            goto L5d
        L91:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L94:
            java.lang.Throwable r7 = r6.S()     // Catch: java.lang.Throwable -> L99
            throw r7     // Catch: java.lang.Throwable -> L99
        L99:
            r7 = move-exception
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.send(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
