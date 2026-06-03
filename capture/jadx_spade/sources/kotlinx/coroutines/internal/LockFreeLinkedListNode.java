package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LockFreeLinkedListNode {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a;
    private static final /* synthetic */ AtomicReferenceFieldUpdater b;
    private static final /* synthetic */ AtomicReferenceFieldUpdater c;
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        Covode.recordClassIndex(659240);
        a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");
        b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");
        c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater l() {
        return a;
    }

    public boolean o() {
        return i() instanceof z;
    }

    public boolean p() {
        if (q() == null) {
            return true;
        }
        return false;
    }

    private final z r() {
        z zVar = (z) c.get(this);
        if (zVar == null) {
            z zVar2 = new z(this);
            c.set(this, zVar2);
            return zVar2;
        }
        return zVar;
    }

    public final Object i() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).a(this);
        }
    }

    public final LockFreeLinkedListNode j() {
        z zVar;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object i = i();
        if (i instanceof z) {
            zVar = (z) i;
        } else {
            zVar = null;
        }
        if (zVar == null || (lockFreeLinkedListNode = zVar.a) == null) {
            Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            return (LockFreeLinkedListNode) i;
        }
        return lockFreeLinkedListNode;
    }

    public final LockFreeLinkedListNode k() {
        LockFreeLinkedListNode f = f(null);
        if (f == null) {
            return g((LockFreeLinkedListNode) b.get(this));
        }
        return f;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return kotlinx.coroutines.b0.a(this.receiver);
            }
        } + '@' + kotlinx.coroutines.b0.b(this);
    }

    public final LockFreeLinkedListNode q() {
        Object i;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            i = i();
            if (i instanceof z) {
                return ((z) i).a;
            }
            if (i == this) {
                return (LockFreeLinkedListNode) i;
            }
            Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) i;
        } while (!androidx.concurrent.futures.a.a(a, this, i, lockFreeLinkedListNode.r()));
        lockFreeLinkedListNode.f(null);
        return null;
    }

    public static abstract class a extends b<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode b;
        public LockFreeLinkedListNode c;

        static {
            Covode.recordClassIndex(659241);
        }

        public a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.b = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z;
            LockFreeLinkedListNode lockFreeLinkedListNode2;
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                lockFreeLinkedListNode2 = this.b;
            } else {
                lockFreeLinkedListNode2 = this.c;
            }
            if (lockFreeLinkedListNode2 != null && androidx.concurrent.futures.a.a(LockFreeLinkedListNode.l(), lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.c;
                Intrinsics.checkNotNull(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.h(lockFreeLinkedListNode4);
            }
        }
    }

    private final LockFreeLinkedListNode g(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.o()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) b.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (i() != lockFreeLinkedListNode) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(b, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (o()) {
            lockFreeLinkedListNode.f(null);
        }
    }

    public final boolean e(LockFreeLinkedListNode lockFreeLinkedListNode) {
        b.set(lockFreeLinkedListNode, this);
        a.set(lockFreeLinkedListNode, this);
        while (i() == this) {
            if (androidx.concurrent.futures.a.a(a, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.h(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (androidx.concurrent.futures.a.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.a, r3, r2, ((kotlinx.coroutines.internal.z) r4).a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.LockFreeLinkedListNode f(kotlinx.coroutines.internal.y r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m()
            java.lang.Object r0 = r0.get(r7)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = l()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L26
            if (r0 != r2) goto L1a
            return r2
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = m()
            boolean r0 = androidx.concurrent.futures.a.a(r1, r7, r0, r2)
            if (r0 != 0) goto L25
            goto L0
        L25:
            return r2
        L26:
            boolean r5 = r7.o()
            if (r5 == 0) goto L2d
            return r1
        L2d:
            if (r4 != r8) goto L30
            return r2
        L30:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.y
            if (r5 == 0) goto L3a
            kotlinx.coroutines.internal.y r4 = (kotlinx.coroutines.internal.y) r4
            r4.a(r2)
            goto L0
        L3a:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.z
            if (r5 == 0) goto L5c
            if (r3 == 0) goto L51
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = l()
            kotlinx.coroutines.internal.z r4 = (kotlinx.coroutines.internal.z) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.a
            boolean r2 = androidx.concurrent.futures.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4f
            goto L0
        L4f:
            r2 = r3
            goto Lc
        L51:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = m()
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Ld
        L5c:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.f(kotlinx.coroutines.internal.y):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final int s(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, a aVar) {
        b.set(lockFreeLinkedListNode, this);
        a.set(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        aVar.c = lockFreeLinkedListNode2;
        if (!androidx.concurrent.futures.a.a(a, this, lockFreeLinkedListNode2, aVar)) {
            return 0;
        }
        if (aVar.a(this) == null) {
            return 1;
        }
        return 2;
    }
}
