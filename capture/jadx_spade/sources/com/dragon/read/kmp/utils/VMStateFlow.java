package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VMStateFlow<T> implements StateFlow<T> {
    public static final int b;
    private final MutableStateFlow<T> a;

    static {
        Covode.recordClassIndex(609581);
        b = 8;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        final MutableStateFlow<T> mutableStateFlow = this.a;
        return (List) new PropertyReference0Impl(mutableStateFlow) { // from class: com.dragon.read.kmp.utils.VMStateFlow$replayCache$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((MutableStateFlow) this.receiver).getReplayCache();
            }
        }.get();
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        final MutableStateFlow<T> mutableStateFlow = this.a;
        return (T) new MutablePropertyReference0Impl(mutableStateFlow) { // from class: com.dragon.read.kmp.utils.VMStateFlow$value$1
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((MutableStateFlow) this.receiver).getValue();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((MutableStateFlow) this.receiver).setValue(obj);
            }
        }.get();
    }

    public void b(T t) {
        this.a.setValue(t);
    }

    public VMStateFlow(T t) {
        this.a = StateFlowKt.MutableStateFlow(t);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.utils.VMStateFlow$collect$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.utils.VMStateFlow$collect$1 r0 = (com.dragon.read.kmp.utils.VMStateFlow$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.utils.VMStateFlow$collect$1 r0 = new com.dragon.read.kmp.utils.VMStateFlow$collect$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3f
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.MutableStateFlow<T> r6 = r4.a
            r0.label = r3
            java.lang.Object r5 = r6.collect(r5, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.utils.VMStateFlow.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
