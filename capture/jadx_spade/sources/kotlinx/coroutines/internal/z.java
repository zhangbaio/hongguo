package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class z {
    public final LockFreeLinkedListNode a;

    static {
        Covode.recordClassIndex(659258);
    }

    public String toString() {
        return "Removed[" + this.a + ']';
    }

    public z(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.a = lockFreeLinkedListNode;
    }
}
