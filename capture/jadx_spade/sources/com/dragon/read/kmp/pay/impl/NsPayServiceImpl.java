package com.dragon.read.kmp.pay.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.Map;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NsPayServiceImpl implements ok4.a {
    public static final a a;

    public static final class a {
        static {
            Covode.recordClassIndex(607909);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607908);
        a = new a(null);
    }

    private final Single<Triple<Map<String, String>, String, Map<String, String>>> O3(pk4.a aVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource H2(Triple orderParams) {
        Intrinsics.checkNotNullParameter(orderParams, "orderParams");
        com.bytedance.kmp.rxkmp.c cVar = com.bytedance.kmp.rxkmp.c.a;
        Single just = Single.just(orderParams.getFirst());
        Intrinsics.checkNotNullExpressionValue(just, "just(t)");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j2(Throwable th) {
        j.a.d("NsPayServiceImpl", "获取订单出现异常: " + th.getMessage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource l3(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (SingleSource) function1.invoke(p0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object I1(pk4.a r6, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.pay.impl.NsPayServiceImpl$getCJPayParams$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.pay.impl.NsPayServiceImpl$getCJPayParams$1 r0 = (com.dragon.read.kmp.pay.impl.NsPayServiceImpl$getCJPayParams$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.pay.impl.NsPayServiceImpl$getCJPayParams$1 r0 = new com.dragon.read.kmp.pay.impl.NsPayServiceImpl$getCJPayParams$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6b
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.dragon.read.kmp.j r7 = com.dragon.read.kmp.j.a
            java.lang.String r2 = "NsPayServiceImpl"
            java.lang.String r4 = "getCJPayParams-start"
            r7.a(r2, r4)
            io.reactivex.Single r6 = r5.O3(r6)
            com.dragon.read.kmp.pay.impl.a r7 = new com.dragon.read.kmp.pay.impl.a
            r7.<init>()
            com.dragon.read.kmp.pay.impl.b r2 = new com.dragon.read.kmp.pay.impl.b
            r2.<init>()
            io.reactivex.Single r6 = r6.doOnError(r2)
            com.dragon.read.kmp.pay.impl.c r7 = new com.dragon.read.kmp.pay.impl.c
            r7.<init>()
            com.dragon.read.kmp.pay.impl.d r2 = new com.dragon.read.kmp.pay.impl.d
            r2.<init>()
            io.reactivex.Single r6 = r6.flatMap(r2)
            java.lang.String r7 = "flatMap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r0.label = r3
            java.lang.Object r7 = com.dragon.read.kmp.base.RxKmpKt.a(r6, r0)
            if (r7 != r1) goto L6b
            return r1
        L6b:
            java.lang.String r6 = "await(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.pay.impl.NsPayServiceImpl.I1(pk4.a, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
