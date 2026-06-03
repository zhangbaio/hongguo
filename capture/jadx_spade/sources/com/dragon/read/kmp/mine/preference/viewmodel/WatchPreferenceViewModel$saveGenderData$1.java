package com.dragon.read.kmp.mine.preference.viewmodel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel", f = "WatchPreferenceViewModel.kt", i = {0, 0, 1, 1}, l = {252, 254, 261}, m = "saveGenderData", n = {"selectedData", "unselectedKey", "selectedData", "unselectedKey"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class WatchPreferenceViewModel$saveGenderData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchPreferenceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchPreferenceViewModel$saveGenderData$1(WatchPreferenceViewModel watchPreferenceViewModel, Continuation<? super WatchPreferenceViewModel$saveGenderData$1> continuation) {
        super(continuation);
        this.this$0 = watchPreferenceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object U0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        U0 = this.this$0.U0(this);
        return U0;
    }
}
