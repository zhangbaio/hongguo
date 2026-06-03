package com.dragon.read.kmp.utils;

import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.flow.MutableStateFlow;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final /* synthetic */ class VMAsyncStateFlow$replayCache$1 extends PropertyReference0Impl {
    VMAsyncStateFlow$replayCache$1(Object obj) {
        super(obj, MutableStateFlow.class, "replayCache", "getReplayCache()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((MutableStateFlow) this.receiver).getReplayCache();
    }
}
