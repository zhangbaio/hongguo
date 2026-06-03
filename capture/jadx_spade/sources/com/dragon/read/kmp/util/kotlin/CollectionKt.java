package com.dragon.read.kmp.util.kotlin;

import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CollectionKt {
    static {
        Covode.recordClassIndex(609498);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> d(List<? extends T> list) {
        if (list == 0 || !(!list.isEmpty())) {
            return null;
        }
        return list;
    }

    public static final <K, V> V a(Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.containsKey(k)) {
            return map.get(k);
        }
        return null;
    }

    private static final <K, V> Object c(Function2<? super Map.Entry<K, V>, ? super Continuation<? super Boolean>, ? extends Object> function2, Map.Entry<K, V> entry, Continuation<? super Boolean> continuation) {
        return function2.invoke(entry, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005a -> B:10:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <K, V> java.lang.Object b(java.util.Map<K, V> r4, kotlin.jvm.functions.Function2<? super java.util.Map.Entry<K, V>, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.dragon.read.kmp.util.kotlin.CollectionKt$removeSafelySuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.util.kotlin.CollectionKt$removeSafelySuspend$1 r0 = (com.dragon.read.kmp.util.kotlin.CollectionKt$removeSafelySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.util.kotlin.CollectionKt$removeSafelySuspend$1 r0 = new com.dragon.read.kmp.util.kotlin.CollectionKt$removeSafelySuspend$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.L$0
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5d
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L44:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L69
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = c(r5, r6, r0)
            if (r6 != r1) goto L5d
            return r1
        L5d:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L44
            r4.remove()
            goto L44
        L69:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.util.kotlin.CollectionKt.b(java.util.Map, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
