package com.dragon.read.kmp.mine.model;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.mine.model.ChangeProfileItemPageViewModel", f = "ChangeProfileItemPageViewModel.kt", i = {0, 0, 0, 0, 0}, l = {241}, m = "setProfile", n = {"avatarChanged", "userNameChanged", "genderChanged", "descriptionChanged", "bizUserIdChanged"}, s = {"I$0", "I$1", "I$2", "I$3", "I$4"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChangeProfileItemPageViewModel$setProfile$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChangeProfileItemPageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangeProfileItemPageViewModel$setProfile$1(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, Continuation<? super ChangeProfileItemPageViewModel$setProfile$1> continuation) {
        super(continuation);
        this.this$0 = changeProfileItemPageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        b1 = this.this$0.b1(this);
        return b1;
    }
}
