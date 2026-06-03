package com.dragon.read.kmp.utils;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlinx.coroutines.flow.MutableStateFlow;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final /* synthetic */ class VMAsyncStateFlow$value$1 extends MutablePropertyReference0Impl {
    VMAsyncStateFlow$value$1(Object obj) {
        super(obj, MutableStateFlow.class, "value", "getValue()Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((MutableStateFlow) this.receiver).getValue();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((MutableStateFlow) this.receiver).setValue(obj);
    }
}
