package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class u {
    public final Object a;
    public final l b;
    public final Function1<Throwable, Unit> c;
    public final Object d;
    public final Throwable e;

    static {
        Covode.recordClassIndex(658920);
    }

    public static /* synthetic */ u b(u uVar, Object obj, l lVar, Function1 function1, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = uVar.a;
        }
        if ((i & 2) != 0) {
            lVar = uVar.b;
        }
        l lVar2 = lVar;
        if ((i & 4) != 0) {
            function1 = uVar.c;
        }
        Function1 function12 = function1;
        if ((i & 8) != 0) {
            obj2 = uVar.d;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = uVar.e;
        }
        return uVar.a(obj, lVar2, function12, obj4, th);
    }

    public final u a(Object obj, l lVar, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        return new u(obj, lVar, function1, obj2, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return Intrinsics.areEqual(this.a, uVar.a) && Intrinsics.areEqual(this.b, uVar.b) && Intrinsics.areEqual(this.c, uVar.c) && Intrinsics.areEqual(this.d, uVar.d) && Intrinsics.areEqual(this.e, uVar.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        l lVar = this.b;
        int hashCode2 = (hashCode + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public final boolean c() {
        if (this.e != null) {
            return true;
        }
        return false;
    }

    public final void d(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th) {
        l lVar = this.b;
        if (lVar != null) {
            cancellableContinuationImpl.callCancelHandler(lVar, th);
        }
        Function1<Throwable, Unit> function1 = this.c;
        if (function1 != null) {
            cancellableContinuationImpl.callOnCancellation(function1, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Object obj, l lVar, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.a = obj;
        this.b = lVar;
        this.c = function1;
        this.d = obj2;
        this.e = th;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ u(java.lang.Object r8, kotlinx.coroutines.l r9, kotlin.jvm.functions.Function1 r10, java.lang.Object r11, java.lang.Throwable r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L7
            r3 = r0
            goto L8
        L7:
            r3 = r9
        L8:
            r9 = r13 & 4
            if (r9 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r10
        Lf:
            r9 = r13 & 8
            if (r9 == 0) goto L15
            r5 = r0
            goto L16
        L15:
            r5 = r11
        L16:
            r9 = r13 & 16
            if (r9 == 0) goto L1c
            r6 = r0
            goto L1d
        L1c:
            r6 = r12
        L1d:
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.u.<init>(java.lang.Object, kotlinx.coroutines.l, kotlin.jvm.functions.Function1, java.lang.Object, java.lang.Throwable, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
