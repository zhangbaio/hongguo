package com.dragon.read.kmp.mine.preference.viewmodel;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel$savePreferenceData$1", f = "WatchPreferenceViewModel.kt", i = {0, 1}, l = {201, 202, 203, 229}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "userPreferenceSetResponse"}, s = {"L$1", "L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class WatchPreferenceViewModel$savePreferenceData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFromDialog;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ WatchPreferenceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchPreferenceViewModel$savePreferenceData$1(WatchPreferenceViewModel watchPreferenceViewModel, boolean z, Continuation<? super WatchPreferenceViewModel$savePreferenceData$1> continuation) {
        super(2, continuation);
        this.this$0 = watchPreferenceViewModel;
        this.$isFromDialog = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchPreferenceViewModel$savePreferenceData$1 watchPreferenceViewModel$savePreferenceData$1 = new WatchPreferenceViewModel$savePreferenceData$1(this.this$0, this.$isFromDialog, continuation);
        watchPreferenceViewModel$savePreferenceData$1.L$0 = obj;
        return watchPreferenceViewModel$savePreferenceData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchPreferenceViewModel$savePreferenceData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel$savePreferenceData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
